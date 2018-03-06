
package br.com.infnet.contatos;

import br.com.infnet.excecoes.DAOException;
import br.com.infnet.jdbc.FabricaDeConexoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;



public class ContatoDAO {
    
    public List<Contato> listar() throws DAOException{
        
        List<Contato> retorno = new ArrayList<>();
        Connection conexao = null;
        try {
            
            conexao = FabricaDeConexoes.conectar();
            String sql = "SELECT * FROM contatos"; // A Query a ser executada.
            Statement stmt = conexao.createStatement(); //
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                
                Contato contato = new Contato();
                contato.setId(rs.getInt("Id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setFone(rs.getString("fone"));
                //------------------------------------
                retorno.add(contato);
                
            }
            
        } catch (Exception e) {
            
            throw new DAOException();
            
        }finally {
            
            FabricaDeConexoes.desconectar(conexao);
            
        }
        
        
        return retorno;
        
    }
    
    public void inserir (Contato contato) throws DAOException{
        
        Connection conexao = null;
        try {
            
            conexao = FabricaDeConexoes.conectar();
            String sql = "INSERT INTO contatos (nome, email, fone) VALUES (?,?,?)"; // A Query a ser executada.
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString (1, contato.getNome());
            ps.setString (2, contato.getEmail());
            ps.setString (1, contato.getFone());
            ps.executeUpdate();
            
                        
        } catch (Exception e) {
            
            throw new DAOException();
            
        }finally {
            
            FabricaDeConexoes.desconectar(conexao);
            
        }
        
        
        
    }
    
    
}
