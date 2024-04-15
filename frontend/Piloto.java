package frontend;

import Serializacao.Serializacao;
import backend.Administrador;
import backend.ListaUtilizadores;
import backend.Sistema;
import backend.Utilizador;

public class Piloto {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Serializacao bd = new Serializacao("bd");
        String nome = new String();
        String username = new String();
        String password = new String();
        Utilizador utilizador = new Utilizador(nome, username, password);
        

        //Se o ficheiro de base de dados nao existir
        if (!bd.getFicheiro().exists()) {
            
            sistema.inicializar();
            //Adiciona dois utilizadores para que possa ser possivel entrar no sistema
            sistema.getUtilizadores().adicionar(new Administrador("admin", "admin", "Aministrador"));
            
            System.out.println("Dados iniciados com sucesso");
        } else {
            sistema = bd.carregar();
            System.out.println("Dados carregados");
        }

        JanelaLogin login = new JanelaLogin(sistema, bd, nome, username, utilizador);
        login.setVisible(true);

//        JanelaInicial principal = new JanelaInicial(sistema, bd);
//        principal.setVisible(true);        
    }

}
