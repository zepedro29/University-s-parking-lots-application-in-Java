package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaPedidos implements Serializable {

    private ArrayList<Pedido> listaPedidos;

    public ListaPedidos() {
        listaPedidos = new ArrayList<>();
    }

    public void efetuarPedido(Pedido p) { 
        listaPedidos.add(p);
    }

    public int tamanho() {
        return listaPedidos.size();
    }

    public void confirmarPedido(Pedido pedido) { 
        
        for (Pedido p : listaPedidos) {
            if (p.getUtente().equals(pedido.getUtente()) && p.getEstado().equals(EstadoPedido.ATRIBUIDO)) {
                listaPedidos.remove(p);
            }
        }
        pedido.setEstado(EstadoPedido.ATRIBUIDO);
    }

    public void recusarPedido(Pedido pedido) { 
        pedido.setEstado(EstadoPedido.RECUSADO);
    }
    
    public Pedido pesquisarPorUtente (String username) {
        for (Pedido pedido : listaPedidos) {
            if ((pedido.getUtente().getUsername().equals(username))) {
                 return pedido;
            }     
        }
        return null;
    }

    
    public void atribuirLugar(Pedido pedido) {
        int contador = 0; //Numero de pessoas que ja tem acesso ao parque do pedido dado como argumento
        for (Pedido p : listaPedidos) {
            if (p.getEstado().equals(EstadoPedido.ATRIBUIDO) && p.getParque().equals(pedido.getParque())) {
                contador++;
            }
        }
        pedido.setNumLugar(contador + 1); //O lugar que vamos atribuir é o do numero de pessoas +1;       
    }

    
    public EstadoPedido verEstado(Pedido pedido) { 
        return pedido.getEstado();
    }

    
    public ArrayList<Pedido> listarPedidosEstado(EstadoPedido estado) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        for (Pedido p : listaPedidos) {
            if (p.getEstado().equals(estado)) {
                pedidos.add(p);
            }
        }
        return pedidos;
    }

    
    public double calcValorGlobal() {
        double total = 0;
        for (Pedido p : listaPedidos) { 
            if (p.getEstado().equals(EstadoPedido.ATRIBUIDO)) {
                if (p.getTipoParque().equals(TipoParque.LIVRE)) {
                    total += 22.5; //total = total + 22.5
                } else if (p.getTipoParque().equals(TipoParque.CONDICIONADO)) {
                    total += 50;
                } else {
                    total += 100;
                }
            }
        }
        return total;
    }

    
    public double calcValorTipo(TipoParque tipo) {
        double total = 0;
        double preco;
        if (tipo.equals(TipoParque.LIVRE)) {
            preco = 22.5;
        } else if (tipo.equals(TipoParque.CONDICIONADO)) {
            preco = 50;
        } else {
            preco = 100;
        }
        for (Pedido p : listaPedidos) { 
            if (p.getEstado().equals(EstadoPedido.ATRIBUIDO)) {
                if (p.getTipoParque().equals(tipo)) {
                    total += preco;
                }
            }
        }
        return total;
    }

    //Verificar se uma matricula tem acesso a um parque
    public boolean temAcesso(String matricula, Parque parque) {
        TipoParque tipo = parque.getTipoParque();
        
        if (tipo.equals(TipoParque.ASSEGURADO)) {
            for (Pedido p : listaPedidos) {
                if (p.getTipoParque().equals(tipo) && p.getParque().equals(parque)) {
                    Viatura v = p.getUtente().getListaViaturas().retornarViaturaa(matricula);
                    return true;
                    }
                
            }
            return false;
        } else {
            for (Pedido p : listaPedidos) {
                if (p.getTipoParque().equals(tipo)) {
                    ListaViaturas viaturas = p.getUtente().getListaViaturas();
                    Viatura v = p.getUtente().getListaViaturas().retornarViaturaa(matricula);
                            return true;
                        
                    }
                }
            }
            return false;
        }
    }



        
    

               
