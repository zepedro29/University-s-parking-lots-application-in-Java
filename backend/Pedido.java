package backend;

import java.io.Serializable;

public class Pedido implements Serializable {

    private Utente utente;
    private EstadoPedido estado;
    private Parque parque;
    private TipoParque tipoParque;
    private int numLugar;
   
    
     public Pedido(Utente utente, Parque parque, TipoParque tipoParque) {
        this.utente = utente;
        this.estado = estado.PENDENTE;
        this.parque = parque;
        this.tipoParque = tipoParque;
        
    }

    public Utente getUtente() {
        return utente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public Parque getParque() {
        return parque;
    }

    public TipoParque getTipoParque() {
        return tipoParque;
    }

    public int getNumLugar() {
        return numLugar;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setParque(Parque parque) {
        this.parque = parque;
    }

    public void setTipoParque(TipoParque tipoParque) {
        this.tipoParque = tipoParque;
    }

    public void setNumLugar(int numLugar) {
        this.numLugar = numLugar;
    }

}
