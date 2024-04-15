package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Parque implements Serializable {

    private String codigo;
    private TipoParque tipoParque;
    private String nome;
    private int numLugares;
    private double preco;
    private int numLugaresDisponiveis;
    

    public Parque(String codigo, String nome, int numLugares, TipoParque tipoParque) {
        
        this.codigo = codigo;
        this.tipoParque = tipoParque;
        this.nome = nome;
        this.numLugares = numLugares;       
        this.numLugaresDisponiveis = numLugares;
        
        if(tipoParque.equals(TipoParque.LIVRE)){
                this.preco = 22.5;
            } else if (tipoParque.equals(TipoParque.CONDICIONADO)) {
                this.preco = 50;
            } else {
                this.preco = 100;
            }
            
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public TipoParque getTipoParque() {
        return tipoParque;
    }

    public String getNome() {
        return nome;
    }

    public int getNumLugares() {
        return numLugares;
    }

    public int getNumLugaresDisponiveis() {
        return numLugaresDisponiveis;
    }

    public double getPreco() {
        return preco;
    }

    public void setTipoParque(TipoParque tipoParque) {
        this.tipoParque = tipoParque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumLugares(int numLugares) {
        this.numLugares = numLugares;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setNumLugaresDisponiveis(int numDisponiveis) {
        this.numLugaresDisponiveis = numDisponiveis;
    }
    
}
