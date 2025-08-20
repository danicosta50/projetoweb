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
public class ListaPacientesSelecionados {
     private static  List<paciente> lista = new ArrayList<>();
  
  public static List<paciente> Listar(){
      return lista;

  }
  
  public static void Adicionar (paciente paciente){
      lista.add(paciente);
  }
  
    public static void Excluir (paciente paciente){
      
      lista.remove(paciente);
        
  }
public static paciente buscarPaciente(String nome, String cpf) {
    for (paciente paciente : lista) { 
        if (paciente.getNome().contains(nome) || paciente.getCpf().contains(cpf)) { 
            return paciente; 
        }
    }
    // Se nenhum paciente foi encontrado, exibe a mensagem e retorna null
    JOptionPane.showMessageDialog(null, "Não foi encontrado este paciente");
    return null;
}

}