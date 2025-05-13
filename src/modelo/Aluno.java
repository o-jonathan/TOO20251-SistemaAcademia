/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20241PF.CC0020
 */
public class Aluno extends Pessoa {
    private String matricula;
    private LocalDate dataMatricula;
    private Plano plano;
    private double valorMensalidade;
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
    
    public String mostrarAvaliacoes() {
        String aux = "Historico de Avaliacoes: \n";
        for(AvaliacaoFisica cadaAvaliacao:avaliacoes) {
            aux += "->> " + cadaAvaliacao;
        }
        return aux;
    }
    public void adicionarAvaliacao(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
    }
    
    public List<AvaliacaoFisica> getAvaliacoes() {
        return avaliacoes;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public LocalDate getDataMatricula() {
        return dataMatricula;
    }
    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    public Plano getPlano() {
        return plano;
    }
    public void setPlano(Plano plano) {
        this.plano = plano;
        if (Period.between(dataMatricula, LocalDate.now()).getMonths() > 3)
            valorMensalidade = plano.getValor() - (plano.getValor() * 0.1);
        else valorMensalidade = plano.getValor();
    }
    public void verificaDesconto()
    {
        if (Period.between(dataMatricula, LocalDate.now()).getMonths() > 3)
            valorMensalidade = plano.getValor() - (plano.getValor() * 0.1);
        else valorMensalidade = plano.getValor();
    }
    
    @Override
    public String exibirDados() {
        String aux = super.exibirDados();
        aux += "\nMatricula: " + matricula;
        aux += "\nAvaliacoes Fisicas Realizadas: " + getAvaliacoes().size();
        aux += "\nValor da Mensalidade: " + valorMensalidade;
        return aux;
    }
}
