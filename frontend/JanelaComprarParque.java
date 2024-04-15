package frontend;

import Serializacao.Serializacao;
import backend.Pedido;
import backend.Sistema;
import backend.Utente;
import backend.TipoParque;
import backend.Utilizador;
import javax.swing.JOptionPane;

public class JanelaComprarParque extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao bd;
    private String nome;
    private String username;
    private JanelaLogin JanelaLogin;
    private JanelaInicial JanelaInicial;
    private Utilizador utilizador;
    private Pedido pedido;

    public JanelaComprarParque(Sistema sistema, Serializacao bd, String nome, String username, JanelaInicial JanelaInicial, Utilizador utilizador, Pedido pedido) {
        initComponents();

        this.sistema = sistema;
        this.bd = bd;
        this.nome = nome;
        this.username = username;
        this.JanelaInicial = JanelaInicial;
        this.utilizador = utilizador;
        this.pedido = pedido;

        txtPreco.setEditable(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxAcesso = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Parque");

        jLabel2.setText("Escolha o tipo de acesso que deseja:");

        boxAcesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Assegurado", "Livre", "Condicionado" }));

        jLabel3.setText("Preços:");

        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxAcesso, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPreco, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(boxAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Utente u = (Utente) sistema.getUtilizadorLigado();

        if (boxAcesso.getSelectedItem().toString().equalsIgnoreCase("Selecione um parque...")) {
            JOptionPane.showMessageDialog(this, "Selecione um parque");
            return;
        }

        if (boxAcesso.getSelectedItem().toString().equalsIgnoreCase("Assegurado")) {
            txtPreco.setText("100€");
            Pedido p1 = new Pedido(u, null, TipoParque.ASSEGURADO);

            sistema.getPedidos().efetuarPedido(p1);

        } else if (boxAcesso.getSelectedItem().toString().equalsIgnoreCase("Livre")) {
            txtPreco.setText("25,50€");
            Pedido p2 = new Pedido(u, null, TipoParque.LIVRE);
            sistema.getPedidos().efetuarPedido(p2);
            
        } else {
            Pedido p3 = new Pedido(u, null, TipoParque.CONDICIONADO);
            txtPreco.setText("50€");
            sistema.getPedidos().efetuarPedido(p3);
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JanelaInicial frame = new JanelaInicial(sistema, bd, nome, username, JanelaLogin, utilizador, pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxAcesso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
