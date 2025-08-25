/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author F2258573
 */
public class validarCpf {
      public static boolean validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 14) return false;
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }
    
}
