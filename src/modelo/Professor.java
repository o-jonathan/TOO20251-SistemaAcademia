/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 20241PF.CC0020
 */
public class Professor extends Pessoa {
    private String especializacao;

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    
    @Override
    public String exibirDados() {
        String aux = super.exibirDados();
        aux += "\nEspecializacao: " + especializacao;
        return aux;
    }
}
