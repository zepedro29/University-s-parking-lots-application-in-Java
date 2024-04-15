package backend;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ListaControlos implements Serializable {

    private ArrayList<ControloEntradasSaidas> listaControlos;

    public ListaControlos() {
        listaControlos = new ArrayList<>();
    }

    public void entradaViatura(ControloEntradasSaidas c) {

        if (c.getParque().getNumLugaresDisponiveis() == 0) {
            System.out.println("O parque está cheio");
        } else {
            listaControlos.add(c);
            int lugaresDisponiveis = c.getParque().getNumLugaresDisponiveis();
            c.getParque().setNumLugaresDisponiveis(lugaresDisponiveis--);
        }
    }

    public void saidaViaturas(ControloEntradasSaidas c) {
        if (c.getParque().getNumLugaresDisponiveis() == c.getParque().getNumLugares()) {
            System.out.println("O parque está vazio");
        } else {
            c.setDataSaida(LocalDateTime.now());
            int lugaresDisponiveis = c.getParque().getNumLugaresDisponiveis();
            c.getParque().setNumLugaresDisponiveis(lugaresDisponiveis++);
        }
    }

    public ControloEntradasSaidas obterEntrada(Viatura viatura) {

        for (ControloEntradasSaidas e : listaControlos) {
            if (e.getViatura().equals(viatura) && e.getDataSaida() == null) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<ControloEntradasSaidas> getViaturasNosParques() {

        ArrayList<ControloEntradasSaidas> listaViaturasNosParques = new ArrayList<>();

        for (ControloEntradasSaidas e : listaControlos) {

            if (e.getDataSaida() == null) {
                listaViaturasNosParques.add(e);
            }
        }
        return listaViaturasNosParques;
    }

    public ArrayList<ControloEntradasSaidas> getViaturasPorData(LocalDate d) {

        ArrayList<ControloEntradasSaidas> listaViaturasPorData = new ArrayList<>();

        for (ControloEntradasSaidas p : listaControlos) {

            if (p.getDataEntrada().toLocalDate().equals(d)) {
                listaViaturasPorData.add(p);
            }
        }
        return listaViaturasPorData;
    }

    public ArrayList<ControloEntradasSaidas> getViaturasPorDataEParque(LocalDate d, Parque p) {

        ArrayList<ControloEntradasSaidas> listaViaturasPorDataEParque = new ArrayList<>();

        for (ControloEntradasSaidas e : listaControlos) {

            if (e.getDataEntrada().toLocalDate().equals(d) && e.getParque().equals(p)) {
                listaViaturasPorDataEParque.add(e);
            }
        }
        return listaViaturasPorDataEParque;
    }

    public boolean verDisponivilidadesParque(Parque p) {

        if (p.getNumLugaresDisponiveis() == 0) {
            return false;
        } else {
            return true;
        }
    }

}
