package backend;

import java.io.Serializable;

public class Seguranca extends Utilizador implements Serializable {
    
    
    public Seguranca(){
        
        
    }
    
    public Seguranca(String username, String password, String nome) {
        super(username, password, nome);
    }

}

