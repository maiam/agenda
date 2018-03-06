/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infnet.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 *
 * @author Rafael Martins
 */
public class FabricaDeConexoes {
    
    public static Connection conectar(){
        
        Connection conexao = null;
        try {
            
            //1º passo: Carregar o drive na memória.
            Class.forName("com.mysql.jdbc.Driver");
            //2º passo: Definir os parâmetros do DriverMananger
            String url = "jdbc:mysql://localhost:3306/word";
            String usr = "root";
            String pwd = "root";
            //3º Passo: obter a conexão
            conexao = DriverManager.getConnection(url, usr, pwd);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        
        return conexao;
        
    }
    
    public static void desconectar (Connection conexao){
        
        try {
            
            
            if (conexao != null && !conexao.isClosed()) {
                
                conexao.close();
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
    
    } // É necessário testar o método! Para isso é preciso criar um método Main;
    
    /*
    //----------------------------------------------------------------
    public static void main(String[] args) throws Exception {
        
        Connection con = FabricaDeConexoes.conectar();
        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println("Banco de Dados" + dbmd.getDatabaseProductName());
        FabricaDeConexoes.desconectar(con);
              
    }
    //----------------------------------------------------------------
*/
}


