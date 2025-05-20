/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author 20241PF.CC0020
 */
public class AlunoConvenio extends Aluno {
    private Convenio convenio;
    
    public AlunoConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Convenio getConvenio() {
        return convenio;
    }
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    @Override
    public void setPlano(Plano plano) {
        super.plano = plano;
        verificaDesconto();
    }

    @Override
    public void verificaDesconto() {
        int tempo = (Period.between(super.dataMatricula, LocalDate.now()).getYears() * 12) + Period.between(super.dataMatricula, LocalDate.now()).getMonths();
        if (super.plano != null) {
            super.valorMensalidade = super.plano.getValor();
            if (tempo > 3) {
                super.valorMensalidade -= (super.valorMensalidade * 0.1);
            }
            
            if (convenio != null) {
                super.valorMensalidade -= (convenio.getDesconto() / 100) * super.plano.getValor();
            }
        }
    }

    @Override
    public String exibirDados() {
        String aux = super.exibirDados();
        aux += "\nConvenio: " + convenio.getNome() + " - " + convenio.getDesconto() + "%";
        return aux;
    }
    
}
