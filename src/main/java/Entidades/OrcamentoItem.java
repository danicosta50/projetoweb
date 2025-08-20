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
public class OrcamentoItem {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String item;

   private int valor;
    private String Descricao;
   
    
 


    

public OrcamentoItem(){
    this.valor = 0;
    this.Descricao="";
    this.item = "";
    
    
   
}

    public OrcamentoItem(int valor, String Descricao, String item) {
        this.valor = valor;
        this.Descricao = Descricao;
        this.item = item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

  

   

    public String getDescricao() {
        return Descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

   

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
}
