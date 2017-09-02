package org.bigolin.control;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 * @version 1.0.0
 */
public class Conexao {

    private String usuario = "bd3_int22";
    private String senha = "goiabafede";
    private String servidor = "oracle.canoas.ifrs.edu.br";
    private int porta = 1521;

    private Connection conexao = null;
    
    public Conexao(
            String usuario,
            String senha) {
        this.senha = senha;
        this.usuario = usuario;
    }

    public Conexao() {
    
    }

    public Connection getConexao() {
        if (conexao == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conexao = DriverManager.getConnection(
                        "jdbc:oracle:thin:@" + this.servidor + ":" + this.porta + ":XE",
                        this.usuario,
                        this.senha);

            } catch (ClassNotFoundException e) {
                System.out.println("Senhor programador! Importe o pacote do DB antes de chingar o java");
            } catch(SQLException e){
                e.printStackTrace(); //Sei lá que diabos tu fez então olhe com calma as coisas.
            }

        }
        return conexao;
    }

    public void desconecta() {
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}