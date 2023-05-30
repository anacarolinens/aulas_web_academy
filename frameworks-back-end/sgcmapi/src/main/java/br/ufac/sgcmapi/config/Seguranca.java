package br.ufac.sgcmapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Seguranca {
    
    @Bean
    public UserDetailsService udService() {
        return new PerfilUsuarioService();
    }

    //Encriptador da senha
    @Bean
    public BCryptPasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Configuração da autenticação
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(udService());
        authProvider.setPasswordEncoder(passEncoder());
        return authProvider;
    }

    //Objeto que modifica as propriedades
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.httpBasic();
        http.cors();
        //Para qualquer requisição pode permitir
        http.authorizeHttpRequests().anyRequest().permitAll();
        //Dizendo como fazer a autendicação - recuperar o usuario e senha
        // http.authenticationProvider(authProvider());

        // //Determinando quem tem acesso a endpoint só quem tem acesso admin
        // http.authorizeHttpRequests().antMatchers("/config/**").hasRole("ADMIN");

        // //Dizendo quais as permissões do usuario comum - exigir autenticação para qualquer usuario
        // http.authorizeHttpRequests().anyRequest().authenticated();

        // //Configuração do logout
        // http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        // //Depois que der certo retorna um ok
        // http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK));

        //Desabilita crsf
        http.csrf().disable();

        return http.build();

    }

}
