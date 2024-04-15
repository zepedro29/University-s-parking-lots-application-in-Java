package frontend;

import Serializacao.Serializacao;
import backend.Administrador;
import backend.Parque;
import backend.Pedido;
import backend.Seguranca;
import backend.Sistema;
import backend.Utente;
import backend.Utilizador;
import javax.swing.JOptionPane;

public class JanelaInicial extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao bd;
    private String nome;
    private String username;
    private JanelaLogin JanelaLogin;
    private Utilizador utilizador;
    private Pedido pedido;
    private Utente utente;
    private Parque parque;

    public JanelaInicial(Sistema sistema, Serializacao bd, String nome, String username, JanelaLogin JanelaLogin, Utilizador utilizador, Pedido pedido) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.nome = nome;
        this.username = username;
        this.JanelaLogin = JanelaLogin;
        this.utilizador = utilizador;
        this.pedido = pedido;

        jMenuUtente.setVisible(sistema.getUtilizadorLigado() instanceof Utente);
        jMenuAdmin.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
        jMenuSeguranca.setVisible(sistema.getUtilizadorLigado() instanceof Seguranca);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuUtilizador = new javax.swing.JMenu();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuUtente = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuAdmin = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        Atribuidos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuSeguranca = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ParqueEstacionamento.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("         Bem Vindo! ");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jMenuUtilizador.setText("Opções");

        jMenuItemGuardar.setText("Guardar Dados ");
        jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarActionPerformed(evt);
            }
        });
        jMenuUtilizador.add(jMenuItemGuardar);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuUtilizador.add(jMenuItemSair);

        jMenuBar1.add(jMenuUtilizador);

        jMenuUtente.setText("Menu");

        jMenuItem3.setText("Os seus Dados");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuUtente.add(jMenuItem3);

        jMenuItem1.setText("Viaturas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuUtente.add(jMenuItem1);

        jMenuItem5.setText("Estado do Pedido");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuUtente.add(jMenuItem5);

        jMenuItem6.setText("Solicitar Acesso a Parque");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuUtente.add(jMenuItem6);

        jMenuBar1.add(jMenuUtente);

        jMenuAdmin.setText("Menu");

        jMenuItem4.setText("Lista Seguranças");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuAdmin.add(jMenuItem4);

        jMenuItem8.setText("Parques");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenuAdmin.add(jMenuItem8);

        Atribuidos.setText("Pedidos");

        jMenuItem2.setText("Atribuidos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Atribuidos.add(jMenuItem2);

        jMenuItem16.setText("Pendentes");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        Atribuidos.add(jMenuItem16);

        jMenuItem17.setText("Recusados");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        Atribuidos.add(jMenuItem17);

        jMenuAdmin.add(Atribuidos);

        jMenuItem9.setText("Mais Informações");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenuAdmin.add(jMenuItem9);

        jMenuBar1.add(jMenuAdmin);

        jMenuSeguranca.setText("Menu");

        jMenuItem14.setText("Viaturas ");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenuSeguranca.add(jMenuItem14);

        jMenuItem10.setText("Registar Entrada");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenuSeguranca.add(jMenuItem10);

        jMenuItem11.setText("Registar Saida");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenuSeguranca.add(jMenuItem11);

        jMenu1.setText("Parques");

        jMenuItem13.setText("Disponibilidade");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuItem15.setText("Verificar acesso a parque ");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        jMenuSeguranca.add(jMenu1);

        jMenuBar1.add(jMenuSeguranca);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed
        bd.guardar(sistema);
        JOptionPane.showMessageDialog(this, "Alterações guardadas.");
    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar a aplicação?", "Fechar", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JanelaVerDadosU frame = new JanelaVerDadosU(sistema, bd, nome, username, JanelaLogin, utilizador);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JanelaViaturasUtente frame = new JanelaViaturasUtente(sistema, bd, nome, username, this, utilizador);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JanelaEstadoPedido frame = new JanelaEstadoPedido(sistema, bd, nome, username, JanelaLogin, pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        JanelaComprarParque frame = new JanelaComprarParque(sistema, bd, nome, username, this, utilizador, pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JanelaTabelaSegurancas frame = new JanelaTabelaSegurancas(sistema, bd, utilizador);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        JanelaTabelaParques frame = new JanelaTabelaParques(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        JanelaMaisInformacoes frame = new JanelaMaisInformacoes(sistema, bd, this);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        JanelaRegistoEntradas frame = new JanelaRegistoEntradas(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        JanelaRegistoSaidas frame = new JanelaRegistoSaidas(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        JanelaViaturas frame = new JanelaViaturas(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        JanelaLugaresDisponiveis frame = new JanelaLugaresDisponiveis(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        JanelaVerificarAcesso frame = new JanelaVerificarAcesso(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        JanelaTabelaPedidosRecusados frame = new JanelaTabelaPedidosRecusados(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JanelaTabelaPedidosAtribuidos frame = new JanelaTabelaPedidosAtribuidos(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        JanelaTabelaPedidosPendentes frame = new JanelaTabelaPedidosPendentes(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem16ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Atribuidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuAdmin;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuSeguranca;
    private javax.swing.JMenu jMenuUtente;
    private javax.swing.JMenu jMenuUtilizador;
    // End of variables declaration//GEN-END:variables
}
