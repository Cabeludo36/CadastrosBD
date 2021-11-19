/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fapp.DTO;

/**
 *
 * @author brepi
 */

public class ClienteDTO {
    public String nomeCliente;
    public String CPFCliente;
    public String ContatoCliente;
    public String CidadeCliente;
    public String EnderecoCliente;
    
    public ClienteDTO(){
        
    }
    // get's
    public String getnomeCliente() {
        return nomeCliente;
    }
    public String geCPFCliente() {
        return CPFCliente;
    }
    public String getContatoCliente() {
        return ContatoCliente;
    }
    public String getCidadeCliente() {
        return CidadeCliente;
    }
    public String getEnderecoCliente() {
        return EnderecoCliente;
    }
    // set's
    public void setnomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }
    public void setContatoCliente(String ContatoCliente) {
        this.nomeCliente = ContatoCliente;
    }
    public void setCidadeCliente(String CidadeCliente) {
        this.CidadeCliente = CidadeCliente;
    }
    public void setEnderecoCliente(String EnderecoCliente) {
        this.EnderecoCliente = EnderecoCliente;
    }
}
