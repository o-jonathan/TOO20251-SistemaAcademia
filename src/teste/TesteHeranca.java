/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.Aluno;
import modelo.AlunoConvenio;
import modelo.AvaliacaoFisica;
import modelo.Convenio;
import modelo.Impressora;
import modelo.Pessoa;
import modelo.Plano;
import modelo.Professor;

/**
 *
 * @author 20241PF.CC0020
 */
public class TesteHeranca {

    public static void main(String[] args) {
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Plano p1 = new Plano("Premium", "Acesso total", 100.00);
        Convenio c1 = new Convenio();
        c1.setNome("IFSUL");
        c1.setDesconto(5);
        //System.out.println(p1.exibirDados());
        
        Professor p = new Professor();
        p.setNome("Juka");
        p.setEspecializacao("Musculacao");
        
        // Com direito a desconto:
        Aluno a1 = new Aluno();
        a1.setNome("Pedro");
        a1.setMatricula("2024-1");
        a1.setDataNascimento(LocalDate.parse("10/02/2005", formato));
        a1.setDataMatricula(LocalDate.parse("02/01/2025", formato));
        a1.setPlano(p1);
        a1.verificaDesconto();
        //System.out.println(a1.exibirDados());
        
        // Sem direito a desconto:
        AlunoConvenio a2 = new AlunoConvenio(c1);
        a2.setNome("Maria");
        a2.setMatricula("2023-2");
        a2.setDataMatricula(LocalDate.parse("10/04/2024", formato));
        a2.setPlano(p1);
        a2.verificaDesconto();
        //System.out.println(a2.exibirDados());
        
        AvaliacaoFisica av1 = new AvaliacaoFisica(a1);
        a1.adicionarAvaliacao(av1);
        av1.setProfessor(p);
        
        Impressora.imprimirDados(p);
        Impressora.imprimirDados(p1);
        Impressora.imprimirDados(av1);
        Impressora.imprimirDados(a1);
        Impressora.imprimirDados(a2);
    }
}
