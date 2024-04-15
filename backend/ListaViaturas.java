package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ListaViaturas implements Serializable {

    private ArrayList<Viatura> listaViaturas;

    public ListaViaturas() {
        listaViaturas = new ArrayList<>();
    }

    public ArrayList<Viatura> getListaViaturass() {

        return new ArrayList<>(listaViaturas);
    }

    public List<Viatura> listarViaturasPorData(LocalDate data) {

        List<Viatura> listaViaturasData = new ArrayList<>();
        return listaViaturasData;
    }

    public double viaturasPorCombustivel(String combustivel) {
        double contador = 0;
        for (Viatura viatura : listaViaturas) {
            if (viatura.getCombustivel().equalsIgnoreCase(combustivel)) {
                contador++;
            }
        }
        return (contador / listaViaturas.size()) * 100;
    }

    //remover viatura pela matricula
    /*public void removerViatura(String matricula) {
        for (Viatura v1 : listaViaturas) {
            if (v1.getMatricula().equals(matricula)) {
                listaViaturas.remove(v1);
            } else {
                JOptionPane.showMessageDialog(null, "A viatura não existe em sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }*/
    
    public void removerViatura(Viatura v) {
        if (!listaViaturas.contains(v)) {
            listaViaturas.remove(v);
        }

    }

    public void adicionarViatura(Viatura viatura) {
        if (!listaViaturas.contains(viatura)) {
            listaViaturas.add(viatura);
        }

    }

    public Viatura retornarViaturaa(String matricula) {

        for (Viatura v1 : listaViaturas) {
            if (v1.getMatricula().equalsIgnoreCase(matricula)) {
                return v1;
            }
        }
        return null;
    }

    public float getPercentagemPorCombustivel(String combustivel) { 
        int contador = 0;
        for (int i = 0; i < listaViaturas.size(); i++) {
            Viatura e = listaViaturas.get(i);
            if (e.getCombustivel().equalsIgnoreCase(combustivel)) {
                contador++;
            }
        }
        float percentagemPorCombustivel = contador / (float) listaViaturas.size() * 100;
        return percentagemPorCombustivel;
    }

    public int tamanhoLista() {
        return listaViaturas.size();
    }
}



