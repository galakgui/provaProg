package org.bigolin.media.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.bigolin.control.ActiveRecord;
import org.bigolin.control.Conexao;

/**
 * Created by Guilherme
 */

 public class ItemMedia implements ActiveRecord {
    private String name;
    private double nota;
    private double peso;


    public ItemMedia(String name, double nota, double peso) {
        this.name = name;
        this.nota = nota;
        this.peso = peso;
    }
    
    public String getName() {
        return name;
    }

    public ItemMedia setName(String name) {
        this.name = name;
        return this;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    @Override
    public boolean insert() {
	Conexao c = new Conexao();
        Connection dbConnection = c.getConexao();
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO nota VALUES" + "(nota_seq.nextval,?,?,?)";

        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setDouble(1, this.getPeso());
            preparedStatement.setDouble(2, this.getNota());
            preparedStatement.setString(3, this.getName());
          
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
           
            e.printStackTrace();
        }finally{
            c.desconecta();
        }        
        return true;
    }

}
