package controlador;

import java.util.ArrayList;
import java.util.Set;

import modelo.Cliente;
import modelo.Numero;

public class ClienteDTO {

    private Cliente cliente;
    private ArrayList<NumeroDTO> numerosRegistrados;
    private ArrayList<NumeroDTO> numerosPorAsignar;
    private ArrayList<NumeroDTO> numerosPorCancelar;

    public ClienteDTO(Cliente cliente, Set<Numero> numerosRegistrados, Set<Numero> numerosPorAsignar,
    		Set<Numero> numerosPorCancelar) {
        this.cliente = cliente;
        this.numerosRegistrados = new ArrayList<NumeroDTO>();
        this.numerosPorAsignar = new ArrayList<NumeroDTO>();
        this.numerosPorCancelar = new ArrayList<NumeroDTO>();
        
        for(Numero numero : numerosRegistrados){
            NumeroDTO numeroDTO = new NumeroDTO(numero);
            this.numerosRegistrados.add(numeroDTO);
       }
        
        for(Numero numero : numerosPorAsignar){
            NumeroDTO numeroDTO = new NumeroDTO(numero);
            this.numerosPorAsignar.add(numeroDTO);
       }
        
        for(Numero numero : numerosPorCancelar){
            NumeroDTO numeroDTO = new NumeroDTO(numero);
            this.numerosPorCancelar.add(numeroDTO);
       }
    }

    public boolean soyValido() {
    	return cliente.getId() > 0;
    }

    public String getNombre() {
        return cliente.getNombre();
    }

    public String getPaterno() {
        return cliente.getPaterno();
    }

    public String getMaterno() {
        return cliente.getMaterno();
    }

    public ArrayList<NumeroDTO> getNumerosRegistrados() {
        return numerosRegistrados;
    }

    public ArrayList<NumeroDTO> getNumerosPorAsignar() {
        return numerosPorAsignar;
    }

    public ArrayList<NumeroDTO> getNumerosPorCancelar() {
        return numerosPorCancelar;
    }

}