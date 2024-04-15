package backend;

import java.io.Serializable;

public class Viatura implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private String combustivel;

    public Viatura(String matricula, String marca, String modelo, String combustivel) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.combustivel = combustivel;

    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

}
