/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fapp.DAL;
import fapp.DTO.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brepi
 */
public class ClienteDAL {
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
    
    public ClienteDTO[] cargaClienteFiltro(String nome, String cpf){
        ClienteDTO clientes[] = null;
        Statement st = null;
        int i = 0;
        try {
            Connection con = criaCon();
            st = con.createStatement();
            // PEGA DA VIEW CADASTROSCLIENTE
            ResultSet rs = st.executeQuery("SELECT * FROM CADASTROCLIENTE WHERE "
                    + "NOMECLIENTE LIKE '%"+ nome +"%' "
                    + "AND CPFCLIENTE LIKE '%" + cpf + "%';");
            while(rs.next()){
                clientes[i] = new ClienteDTO();
                clientes[i].nomeCliente = rs.getString("NOMECLIENTE");
                clientes[i].ContatoCliente = rs.getString("CONTATOCLIENTE");
                clientes[i].EnderecoCliente = rs.getString("ENDERECOCLIENTE");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
    public ClienteDTO[] cargaCliente() throws SQLException{
        Statement st = null;
        int i = 0;
            Connection con = criaCon();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from CADASTROCLIENTE");
            rs.next();
            ClienteDTO clientes[] = new ClienteDTO[rs.getInt("count(*)")];
            rs = st.executeQuery("SELECT * FROM CADASTROCLIENTE;");
            
            while(rs.next()){
                clientes[i] = new ClienteDTO();
                clientes[i].nomeCliente = rs.getString("NOMECLIENTE");
                clientes[i].ContatoCliente = rs.getString("CONTATOCLIENTE");
                clientes[i].EnderecoCliente = rs.getString("ENDERECOCLIENTE");
                i++;
            }
            con.close();
            return clientes;
    }
    
    public boolean addCliente(ClienteDTO cliente){
        Statement st = null;
        Connection con = criaCon();
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO CADASTROCLIENTE(NOMECLIENTE,CPFCLIENTE,CONTATOCLIENTE,CIDADECLIENTE,ENDERECOCLIENTE)"+ 
                    "VALUES('"+cliente.nomeCliente+"','"+cliente.CPFCliente+"','"+cliente.ContatoCliente+"','"+cliente.CidadeCliente+"','"+cliente.EnderecoCliente+"');");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
}
