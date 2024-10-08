package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        try {
            // Conectando ao banco de dados
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste_db", "postgres", "pdal1313");
            if (conexao != null) {
                System.out.println("Banco de dados conectado com sucesso");
                Statement stm = conexao.createStatement();
                inserirDados(stm);
                consultaDados(stm);
            } else {
                System.out.println("Conexao falhou");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para realizar a consulta
    static void consultaDados(Statement stm) {
        String query = "SELECT id, name FROM persons";
        try {
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                System.out.println("id: " + result.getInt("id") + ", Nome: " + result.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void inserirDados(Statement stm) {
        String sql = "insert into persons (name) values ('iasmin')";
        try {
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
