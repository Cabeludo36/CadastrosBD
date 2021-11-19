/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fapp.BLL;
import fapp.DAL.*;
import fapp.DTO.*;
/**
 *
 * @author brepi
 */
public class ClienteBLL {
    public ClienteDTO[] cargaCliente() throws Exception{
        ClienteDAL carga = new ClienteDAL();
        ClienteDTO[] clientes = null;
        clientes = carga.cargaCliente();
        return clientes;
    }
    public ClienteDTO[] cargaClienteFiltro(String nome, String cpf){
        ClienteDAL carga = new ClienteDAL();
        ClienteDTO[] clientes = null;
        try {
            clientes = carga.cargaClienteFiltro(nome, cpf);
        } catch (Exception e){
            throw e;
        }
        return clientes;
    }
    public boolean addCliente(String nome, String cpf, String contato, String cidade, String endereco){
        ClienteDAL add = new ClienteDAL();
        return add.addCliente(nome, cpf, contato, cidade, endereco);
    }
}
