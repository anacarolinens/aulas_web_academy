package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Usuarios;

public class UsuariosDao implements IDao<Usuarios> {
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public UsuariosDao(){
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Usuarios> get() {
        List<Usuarios> registros = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios registro = new Usuarios();
                registro.setId(rs.getLong("id"));
                registro.setNomeCompleto(rs.getString("nome_completo"));
                registro.setNomeUsuario(rs.getString("nome_usuario"));
                registro.setSenha(rs.getString("senha"));
                registro.setAtivo(rs.getString("ativo"));
                registro.setPapel(rs.getString("papel"));            
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Usuarios get(Long id) {
        Usuarios registro = new Usuarios();
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setNomeCompleto(rs.getString("nome_completo"));
                registro.setNomeUsuario(rs.getString("nome_usuario"));
                registro.setSenha(rs.getString("senha"));
                registro.setAtivo(rs.getString("ativo"));
                registro.setPapel(rs.getString("papel")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Usuarios> get(String termoBusca) {
        List<Usuarios> registros = new ArrayList<>();
        String sql = "SELECT u.*"+
        "FROM usuario u"+
        " WHERE u.nome_completo LIKE ?" +
        " OR nome_usuario LIKE ?"+
        " OR senha LIKE ?"+
        " OR ativo LIKE ?"+
        " OR papel LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca + "%");
            ps.setString(2, "%" + termoBusca + "%");
            ps.setString(3, "%" + termoBusca + "%");
            ps.setString(4, "%" + termoBusca + "%");
            ps.setString(5, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios registro = new Usuarios();
                registro.setId(rs.getLong("id"));
                registro.setNomeCompleto(rs.getString("nome_completo"));
                registro.setNomeUsuario(rs.getString("nome_usuario"));
                registro.setSenha(rs.getString("senha"));
                registro.setAtivo(rs.getString("ativo"));
                registro.setPapel(rs.getString("papel")); 
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public int insert(Usuarios objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO usuario (nome_completo,nome_usuario, senha,ativo,papel) VALUES (?, ?, ?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNomeCompleto());
            ps.setString(2, objeto.getNomeUsuario());
            ps.setString(3, objeto.getSenha());
            ps.setString(4, objeto.getAtivo());
            ps.setString(5, objeto.getPapel());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public int update(Usuarios objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE usuario SET" +
            " nome_completo = ?," +
            " nome_usuario = ?," +
            " senha = ?," +
            " ativo = ?, " +
            " papel = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNomeCompleto());
            ps.setString(2, objeto.getNomeUsuario());
            ps.setString(3, objeto.getSenha());
            ps.setString(4, objeto.getAtivo());
            ps.setString(5, objeto.getPapel());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public int delete(Long id) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

}
