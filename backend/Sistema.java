package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class Sistema implements Serializable {

    private ListaUtilizadores utilizadores;
    
    private ListaParques parques;
    private ListaPedidos pedidos;
    private Utilizador utilizadorLigado;
    private Utente utente;
    private ListaViaturas listaViaturas;
    private ListaControlos listaControlos; 
    private ListaParques listaParques;
    

     public Sistema() {
        this.utilizadores = new ListaUtilizadores();
        this.parques = new ListaParques();
        this.pedidos = new ListaPedidos();
        this.listaParques = new ListaParques();
        this.listaViaturas = new ListaViaturas();
        this.listaControlos = new ListaControlos();
    }
     
      
     
    public Utente getUtente() {
        return utente;
    }
    
    
    
    public ListaParques getListaParques(){
        return listaParques;
    }
    
    public ListaControlos getListaControlos() {
        return listaControlos;
    }
    
     public void setListaControlos(ListaControlos listaControlos){
        this.listaControlos = listaControlos;
    }

    public ListaUtilizadores getUtilizadores(){
        return utilizadores;
    }

    public void setListaUtilizador(ListaUtilizadores utilizadores){
        this.utilizadores = utilizadores;
    }
        
    public void setListaViaturas(ListaViaturas listaViaturas) {
        this.listaViaturas = listaViaturas;
    }

    public ListaViaturas getListaViaturas() {
        return listaViaturas;
    }

    public ListaParques getParques(){
        return parques;
    }

    public void setParques(ListaParques parques){
        this.parques = parques;
    }
    
    public ListaPedidos getPedidos(){
        return pedidos;
    }

    public void setPedidos(ListaPedidos pedidos){
        this.pedidos = pedidos;
    }

    public Utilizador getUtilizadorLigado(){
        return utilizadorLigado;
    }

    public void setUtilizadorligado(Utilizador utilizadorligado){
        this.utilizadorLigado = utilizadorligado;
    }

    public boolean autenticarUtilizador(String username, String password) {
        if (utilizadores.existe(username)) {
            try {
                Utilizador u = utilizadores.getUtilizador(username);
                if (u.getPassword().equals(password)) {
                    utilizadorLigado = u;
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public void inicializar() {
        
        utilizadores.adicionar(new Administrador("a1234", "admin", "Aministrador"));
        
        utilizadores.adicionar(new Seguranca("s1", "1234", "Segurança 1"));

        
        //CARROS
        Viatura v1 = new Viatura("11 AA 11", "BMW", "M5", "Gasolina");
        listaViaturas.adicionarViatura(v1);
        

        Viatura v2 = new Viatura("22 BB 22", "Volkswagen", "Golf 1.6", "Gasóleo");
        listaViaturas.adicionarViatura(v2);
        
        
        Viatura v3 = new Viatura("33 CC 33", "Mercedes", "e63", "Gasolina");
        listaViaturas.adicionarViatura(v3);
        
        

        //UTENTES
        Utente u1 = new Utente("user1", "1234", "Utente 1");   
        u1.getListaViaturas().adicionarViatura(v1);
        utilizadores.adicionar(u1);
        
        
        Utente u2 = new Utente("user2", "1234", "Utente 2");
        u2.getListaViaturas().adicionarViatura(v2);
        utilizadores.adicionar(u2);
        
        
        Utente u3 = new Utente("user3", "1234", "Utente 3");
        u3.getListaViaturas().adicionarViatura(v3);
        utilizadores.adicionar(u3); 
        
        
               
       //PARQUES
        Parque p1 = new Parque("123L", "entrada", 100, TipoParque.LIVRE);
        listaParques.registarParque(p1);
        
        Parque p2 = new Parque("456C", "engenharias", 80, TipoParque.CONDICIONADO);
        listaParques.registarParque(p2);

        Parque p3 = new Parque("789A", "bar", 50, TipoParque.ASSEGURADO);
        listaParques.registarParque(p3);
           

    }

    public void terminar() {
        System.exit(0);
    }

}
