/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class consulta {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
    private String nomePaciente;
    private String cpf;
    private Integer id_paciente;

    private Date dataConsulta;
    private String Valor;
  
    private boolean consultaRealizada;
    private String receitaObservacoes;

    public consulta(String nomePaciente,Integer id_paciente, Date dataConsulta) {
        this.nomePaciente = nomePaciente;
        this.dataConsulta = dataConsulta;
        this.cpf = "";
        this.receitaObservacoes = "";
        this.consultaRealizada = false;
        this.id_paciente = id_paciente;
        this.Valor = "";
    }

    public consulta() {
    }

    public int getId() {
        return id;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }



    public String getValor() {
        return Valor;
    }

   

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

   

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }

    public void setReceitaObservacoes(String receitaObservacoes) {
        this.receitaObservacoes = receitaObservacoes;
    }

    // Construtores, getters e setters

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getCpf() {
        return cpf;
    }


    public Date getDataConsulta() {
        return dataConsulta;
    }


    public boolean isConsultaRealizada() {
        return consultaRealizada;
    }

    public String getReceitaObservacoes() {
        return receitaObservacoes;
    }
}


