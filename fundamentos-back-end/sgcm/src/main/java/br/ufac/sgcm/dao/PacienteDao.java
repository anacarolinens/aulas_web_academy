package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Paciente;

public class PacienteDao implements IDao<Paciente>{

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public PacienteDao() {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Paciente> get() {
        List<Paciente> registros = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente registro = new Paciente();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                registro.setDataNascimento(rs.getString("data_nascimento"));
                registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                registro.setSexo(rs.getString("sexo"));
                registro.setCep(rs.getString("cep"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setEstado(rs.getString("estado"));
                registro.setEmail(rs.getString("email"));
                registro.setCidade(rs.getString("cidade"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Paciente get(Long id) {
        Paciente registro = new Paciente();
        String sql = "SELECT * FROM paciente WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                registro.setDataNascimento(rs.getString("data_nascimento"));
                registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                registro.setSexo(rs.getString("sexo"));
                registro.setCep(rs.getString("cep"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setEstado(rs.getString("estado"));
                registro.setCidade(rs.getString("cidade"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Paciente> get(String termoBusca) {
        List<Paciente> registros = new ArrayList<>();
        String sql = "SELECT p.*" +
            " FROM paciente p" +
            " WHERE p.nome LIKE ?" +
            " OR email LIKE ?" +
            " OR telefone LIKE ?" +
            " OR data_nascimento LIKE ?" +
            " OR grupo_sanguineo LIKE ?" +
            " OR sexo LIKE ?" +
            " OR cep LIKE ?" +
            " OR endereco LIKE ?" +
            " OR estado LIKE ?" +
            " OR cidade LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca + "%");
            ps.setString(2, "%" + termoBusca + "%");
            ps.setString(3, "%" + termoBusca + "%");
            ps.setString(4, "%" + termoBusca + "%");
            ps.setString(5, "%" + termoBusca + "%");
            ps.setString(6, "%" + termoBusca + "%");
            ps.setString(7, "%" + termoBusca + "%");
            ps.setString(8, "%" + termoBusca + "%");
            ps.setString(9, "%" + termoBusca + "%");
            ps.setString(10, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente registro = new Paciente();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                registro.setDataNascimento(rs.getString("data_nascimento"));
                registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                registro.setSexo(rs.getString("sexo"));
                registro.setCep(rs.getString("cep"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setEstado(rs.getString("estado"));
                registro.setCidade(rs.getString("cidade"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public int insert(Paciente objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO paciente (nome, email, telefone, data_nascimento, grupo_sanguineo, sexo, cep, endereco, estado, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEmail());
            ps.setString(3, objeto.getTelefone());
            ps.setString(4, objeto.getDataNascimento());
            ps.setString(5, objeto.getGrupoSanguineo());
            ps.setString(6, objeto.getSexo());
            ps.setString(7, objeto.getCep());
            ps.setString(8, objeto.getEndereco());
            ps.setString(9, objeto.getEstado());
            ps.setString(10, objeto.getCidade());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public int update(Paciente objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE paciente SET" +
            " nome = ?," +
            " WHERE p.nome LIKE ?" +
            " OR email LIKE ?" +
            " OR telefone LIKE ?" +
            " OR data_nascimento LIKE ?" +
            " OR grupo_sanguineo LIKE ?" +
            " OR sexo LIKE ?" +
            " OR cep LIKE ?" +
            " OR endereco LIKE ?" +
            " OR estado LIKE ?" +
            " OR cidade LIKE ?" +
            " WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEmail());
            ps.setString(3, objeto.getTelefone());
            ps.setString(4, objeto.getDataNascimento());
            ps.setString(5, objeto.getGrupoSanguineo());
            ps.setString(6, objeto.getSexo());
            ps.setString(7, objeto.getCep());
            ps.setString(8, objeto.getEndereco());
            ps.setString(9, objeto.getEstado());
            ps.setString(10, objeto.getCidade());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public int delete(Long id) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM paciente WHERE id = ?";
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
