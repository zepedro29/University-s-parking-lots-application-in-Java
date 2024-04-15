package backend;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Utente extends Utilizador implements Serializable{

   
    private ListaViaturas listaViaturas;

    public Utente(String username, String password, String nome) {
        super(username, password, nome);       
        listaViaturas = new ListaViaturas();       
    }
      
    public ListaViaturas getListaViaturas(){
        return listaViaturas;
    }

   

    public void remover(String matricula){
        Viatura v = getListaViaturas().retornarViaturaa(matricula);
        listaViaturas.removerViatura(v);             
        }
    

    public void adicionarViatura (Viatura viatura) { 
        /*if (!listaViaturas.contains(viatura)) {
            listaViaturas.add(viatura);
        }*/
        listaViaturas.adicionarViatura(viatura);
    }
    

    public boolean verificarTamanhoLista() {
        int n = getListaViaturas().tamanhoLista();
        if (n >= 3) {
            System.out.println("Não pode colocar mais viaturas nos parques");
            return false;
        } else {
            
            return true;
        }

    }
    

}
        
