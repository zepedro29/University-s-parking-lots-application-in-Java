package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ControloEntradasSaidas implements Serializable{

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida; 
    private Viatura viatura;      
    private Parque parque;

    public ControloEntradasSaidas(LocalDateTime dataEntrada, Parque parque, Viatura viatura) {
        this.dataEntrada = dataEntrada;
        this.parque = parque;        
        this.viatura = viatura;
        this.dataSaida = null;
        
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    } 

    public Parque getParque() {
        return parque;
    }

    public Viatura getViatura() {
        return viatura;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }
   

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
        
    
    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }
        
    public void setParque(Parque parque){
        this.parque = parque;
    }
    
    public void setViatura(Viatura viatura){
        this.viatura = viatura;
    }
    
    @Override
    public String toString() {
        return "EntradaSaida{" + "dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", viatura=" + viatura + ", parque=" + parque +'}';
    }
}
