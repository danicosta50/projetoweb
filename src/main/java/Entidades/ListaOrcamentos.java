/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author F2258573
 */
public class ListaOrcamentos {
     private static  List<Orcamento> lista = new ArrayList<>();
  
  public static List<Orcamento> Listar(){
      return lista;

  }
  
  public static void Adicionar (Orcamento orcamento){
      lista.add(orcamento);
  }
  
    public static void Excluir (Orcamento orcamento){
      
      lista.remove(orcamento);
        
  }


}