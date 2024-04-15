package backend;

import java.io.Serializable;

public class Administrador extends Utilizador implements Serializable {

    public Administrador(String username, String password, String nome) {
        super(username, password, nome);
    }

}



