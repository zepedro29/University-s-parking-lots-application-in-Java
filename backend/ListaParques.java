package backend;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListaParques implements Serializable {

    private ArrayList<Parque> listaParques;

    public ListaParques() {
        listaParques = new ArrayList<>();
    }

    public void adicionar(Parque p) {
        listaParques.add(p);
    }

    public void removerParque (Parque parque) { //ok
        if (listaParques.contains(parque)) {
             listaParques.remove(parque);
        } 
    }

    public ArrayList<Parque> verParques() {
        return listaParques;
    }

    
    public Parque obterParque(String codigo){
        for(Parque p: listaParques){
            if (p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }
    
    public void registarParque(Parque parque) {  //ok
        if (listaParques.isEmpty()) {
            listaParques.add(parque);
        } else {
            if (existeParque(parque.getCodigo())) {
                System.out.println("Já existe um parque com este codigo");
                JOptionPane.showMessageDialog(null, "O parque já existe em sistema");
            } else {
                listaParques.add(parque);
            }
        }
    }

    public boolean existeParque(String codigo) { //ok
        for (Parque parque : listaParques) {
            if ((parque.getCodigo().equals(codigo))) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList <Parque> listarParques(){ //ok
        return listaParques;
    }
    
    
    
}
