/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author F2258573
 */
@Entity
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
   private int id_item;

    private int paciente_id;
    private boolean pago;

    public Orcamento(int id) {
        this.id = id;
    }

    public Orcamento(int id, int id_item, int paciente_id) {
        this.id = id;
        this.id_item = id_item;
        this.paciente_id = paciente_id;
        this.pago = false;
    }

    public Orcamento() {
    }
    

    public Orcamento(int id_item, int paciente_id) {
        this.id_item = id_item;
        this.paciente_id = paciente_id;
        this.pago = false;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
 


    

public Orcamento(paciente paciente){
 
    
    this.paciente_id = paciente.getId();
    this.pago = false;
   
}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }


   

    
}
