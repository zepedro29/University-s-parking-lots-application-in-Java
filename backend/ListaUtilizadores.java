package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaUtilizadores implements Serializable {

    private ArrayList<Utilizador> listaUtilizador;
    private Utente utente; 

    public ListaUtilizadores() {
        listaUtilizador = new ArrayList<>();
    }

    public void adicionar(Utilizador Utilizador) {
        listaUtilizador.add(Utilizador);
    }

    public void remover(Utilizador Utilizador) {
        listaUtilizador.remove(Utilizador);
    }

    public boolean existe(String username) {
        for (int i = 0; i < listaUtilizador.size(); i++) {
            Utilizador u = listaUtilizador.get(i);
            String user = u.getUsername();
            if (user.equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public Utilizador getUtilizador(String username) {
        if (existe(username)) {
            for (int i = 0; i < listaUtilizador.size(); i++) {
                Utilizador u = listaUtilizador.get(i);
                String user = u.getUsername();
                if (user.equalsIgnoreCase(username)) {
                    return u;
                }
            }
        }
        return null;
    }

    public Utilizador getUtilizadorNome(String nome) {
        for (int i = 0; i < listaUtilizador.size(); i++) {
            Utilizador u = listaUtilizador.get(i);
            String user = u.getNome();
            if (nome.equalsIgnoreCase(user)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Seguranca> getSegurancas() {
        ArrayList<Seguranca> segurancas = new ArrayList<>();
        for (int i = 0; i < listaUtilizador.size(); i++) {
            Utilizador u = listaUtilizador.get(i);
            if (u instanceof Seguranca) {
                segurancas.add((Seguranca) u);
            }
        }
        return segurancas;
    }

    public ArrayList<Administrador> getAdministradores() {
        ArrayList<Administrador> administradores = new ArrayList<>();
        for (int i = 0; i < listaUtilizador.size(); i++) {
            Utilizador u = listaUtilizador.get(i);
            if (u instanceof Administrador) {
                administradores.add((Administrador) u);
            }
        }
        return administradores;
    }
    
    public void adicionarUtente (String username, String password, String nome) {
            Utente u = new Utente (username, password, nome);
            listaUtilizador.add(u);
        }
    
    public ArrayList<Utente> getUtentes() {
        ArrayList<Utente> utentes = new ArrayList<>();
        for (int i = 0; i < listaUtilizador.size(); i++) {
            Utilizador u = listaUtilizador.get(i);
            if (u instanceof Utente) {
                utentes.add((Utente) u);
            }
        }
        return utentes;
    }
    public void editarDados(String nome, String username, String password) {
        utente.setNome(nome);
        utente.setUsername(username);
        utente.setPassword(password);
    }

}
