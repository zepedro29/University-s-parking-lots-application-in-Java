package backend;

import java.io.Serializable;

public class Utilizador implements Serializable{

    private String username;
    private String password;
    private String nome;
    
    public Utilizador(){
        
        
    }
    
    public Utilizador(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNome() {
        return nome;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

