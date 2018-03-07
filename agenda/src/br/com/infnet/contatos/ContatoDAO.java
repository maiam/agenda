
package br.com.infnet.contatos;

import br.com.infnet.excecoes.DAOException;
import br.com.infnet.jdbc.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;



public class ContatoDAO extends Contato {

    public List<Contato> listar() throws DAOException {
        
        List<Contato> retorno = new ArrayList<>();
        Connection conexao = null;
        try {
            
            conexao = FabricaDeConexoes.conectar();
            String sql = "SELECT * FROM contatos";
            Statement stmt = conexao.createStatement(); //
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                
                Contato contato = new Contato();
                contato.setId(rs.getInt("Id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setFone(rs.getString("fone"));
                retorno.add(contato);
            }//while
            
        } catch (Exception e) {
            
            throw new DAOException("Houve um problema ao conectar com o banco de dados.");
        } finally {
            
            FabricaDeConexoes.desconectar(conexao);
        }//trycatch finally
        
        return retorno;
    }//listar
    
    public void inserir(Contato contato) throws DAOException {

        Connection conexao = null;
        try {

            conexao = FabricaDeConexoes.conectar();
            conexao.setAutoCommit(false);
            String sql = "INSERT INTO contatos (nome, email, fone) VALUES (?,?,?)"; // A Query a ser executada.
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getEmail());
            ps.setString(3, contato.getFone());
            ps.executeUpdate();
            conexao.commit();
            
        } catch (Exception e) {

            throw new DAOException("Houve um problema ao conectar com o banco de dados.");

        } finally {
            
            FabricaDeConexoes.desconectar(conexao);
        }//trycatch finally
    }//inserir
    
    public void alterar(Contato contato) throws DAOException {

        Connection conexao = null;
        try {

            conexao = FabricaDeConexoes.conectar();
            conexao.setAutoCommit(false);
            String sql = "UPDATE contatos SET nome=?, email=?, fone=? WHERE id=?"; // A Query a ser executada.
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getEmail());
            ps.setString(3, contato.getFone());
            ps.setString(4, String.valueOf(contato.getId()));
            int updatecount = ps.executeUpdate();
            conexao.commit();
        } catch (Exception e) {

            throw new DAOException("Houve um problema ao conectar com o banco de dados.");
        } finally {
            
            FabricaDeConexoes.desconectar(conexao);
        }//trycatch finally
    }//alterar
    
    public void excluir(Contato contato) throws DAOException {

        Connection conexao = null;
        try {

            conexao = FabricaDeConexoes.conectar();
            conexao.setAutoCommit(false);
            String sql = "DELETE FROM contatos WHERE id=?"; // A Query a ser executada.
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, String.valueOf(contato.getId()));
            int deletecount = ps.executeUpdate();
            conexao.commit();
        } catch (Exception e) {

            throw new DAOException("Houve um problema ao conectar com o banco de dados.");
        } finally {
            
            FabricaDeConexoes.desconectar(conexao);
        }//trycatch finally
    }//excluir
}//classDF
