/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20241PF.CC0020
 */
public class Aluno extends Pessoa {
    protected String matricula;
    protected LocalDate dataMatricula;
    protected Plano plano;
    protected double valorMensalidade;
    protected List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
    
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
        verificaDesconto();
    }
    public void verificaDesconto()
    {   
        int tempo = (Period.between(dataMatricula, LocalDate.now()).getYears() * 12) + Period.between(dataMatricula, LocalDate.now()).getMonths();
        if (plano != null) {
            valorMensalidade = plano.getValor();
            if (tempo > 3) {
                valorMensalidade -= (valorMensalidade * 0.1);
            }
        }
    }
    
    @Override
    public String exibirDados() {
        String aux = super.exibirDados();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        aux += "\nMatricula: " + matricula;
        aux += "\nData de Matricula: " + dataMatricula.format(formato);
        aux += "\nAvaliacoes Fisicas Realizadas: " + getAvaliacoes().size();
        if (plano != null) {
            aux += "\nValor da Mensalidade: " + valorMensalidade;
            aux += "\nPlano: " + plano.getNome() + " - R$" + plano.getValor(); 
        }
        return aux;
    }
}
