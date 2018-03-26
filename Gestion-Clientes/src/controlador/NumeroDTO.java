/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.DecimalFormat;
import modelo.Numero;

/**
 *
 * @author emilio
 */
public class NumeroDTO {
    private String numero;

    public NumeroDTO(Numero numero) {
        this.numero = numero.getNumero();
    }

    public String getNumero() {
        return numero;
    }
    
    public String getNumeroFormatted(){
        DecimalFormat formatter = new DecimalFormat("##,##,##,##,##");
        String numberComma = formatter.format(Long.valueOf(numero));
        String hyphenedNumber = numberComma.replaceAll(",", "-");
        return hyphenedNumber;
    }
    
    public static void main(String[] args){
        NumeroDTO numero = new NumeroDTO(new Numero("5512345678", Numero.Estado.asignado));
        System.out.println(numero.getNumeroFormatted());
    }
    
    
    
}