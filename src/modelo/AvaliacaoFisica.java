/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jonathan
 */
public class AvaliacaoFisica {
    private Aluno aluno;
    private LocalDate data;
    private double peso;
    private double altura;
    private int idade;
    private double imc;
    private Professor professor;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public AvaliacaoFisica(Aluno aluno) {
        this.aluno = aluno;
        data = LocalDate.now();
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getPeso() {
        return peso;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getAltura() {
        return altura;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public Pessoa getAluno() {
        return aluno;
    }
    
    public double calcularIMC() {
        return peso / (altura * altura);
    }
    public void calcularIdade() {
        idade = Period.between(aluno.getDataNascimento(), data).getYears();
    }
    public String exibirDados() {
        String retorno = "Dados da Avaliacao Fisica:\n";
        retorno += "Aluno: " + aluno + "\n";
        calcularIdade();
        if (idade != 0)
            retorno += "Idade: " + idade + "\n";
        if (data != null)
            retorno += "Data da avaliacao: " + data.format(formato) + "\n";
        imc = calcularIMC();
        if (imc > 0)
            retorno += "IMC: " + imc;
        if (professor != null)
            retorno += "Professor Responsavel: " + professor;
        return retorno;
    }
    @Override
    public String toString() {
        return formato.format(data) + " - IMC: " + imc;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
