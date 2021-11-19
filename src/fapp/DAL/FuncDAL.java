/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fapp.DAL;
import fapp.DTO.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author brepi
 */
public class FuncDAL {
    private Connection criaCon(){
        Connection con;
        try {
            con = DriverManager.getConnection(  
             //onde vai connectar               login     senha
            "jdbc:mysql://localhost:3306/corp","root","breno123");
            System.out.printf("Conectou\n");
        } catch(Exception e) {
            System.out.println(e);
            System.out.printf("Nao Conectou");
            return null;
        }
        return con;
    }
    public boolean addFunc(String nome, String cpf, String endereco, String contato, String cargo, String hs){
        Statement st = null;
        Connection con = criaCon();
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO CADASTROFUNC(NOMEFUNC,CPFFUNC,ENDERECOFUNC,CONTATOFUNC,CARGOFUNC,HORASEMANA)"+ 
                    "VALUES('"+nome+"','"+cpf+"','"+endereco+"','"+contato+"',"+cargo+","+hs+");");
                return true;
        } catch (SQLException ex) {
                Logger.getLogger(ClienteDAL.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
}
