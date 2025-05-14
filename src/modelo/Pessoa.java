/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20241PF.CC0020
 */
public abstract class Pessoa {
        //Atributos
    private LocalDate dataNascimento;
    private String nome;
    private String cpf;
    
        //Construtores
    Pessoa() {}
    Pessoa(String n) {
        nome = n;
    }
    Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
        //Métodos
    public String exibirDados() {
        String aux = "Dados da Pessoa cadastrada:";
        aux += "\nNome: " + nome;
        if (cpf != null)
            aux += "\nCPF: " + cpf;
        
        return aux;
    }
    @Override
    public String toString() {
        return nome;
    }
    
        //Getters
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    
        //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setDataNascimento(LocalDate dtN) {
        this.dataNascimento = dtN;
    }
}
