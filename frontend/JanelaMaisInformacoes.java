package frontend;

import Serializacao.Serializacao;
import backend.Sistema;
import backend.TipoParque;
import backend.ListaViaturas;
import backend.Pedido;
import backend.Utilizador;

public class JanelaMaisInformacoes extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao bd;
    private JanelaInicial JanelaInicial;
    private String nome;
    private String username;
    private JanelaLogin JanelaLogin;
    private Utilizador utilizador;
    private Pedido pedido;

    public JanelaMaisInformacoes(Sistema sistema, Serializacao bd, JanelaInicial JanelaInicial) {
        initComponents();

        this.sistema = sistema;
        this.bd = bd;
        this.JanelaInicial = JanelaInicial;
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        txtTotal.setEditable(false);
        txtLivre.setEditable(false);
        txtAssegurado.setEditable(false);
        txtCondi.setEditable(false);
        txtGasolina.setEditable(false);
        txtGasoleo.setEditable(false);

        double valorPorTipoLivre = sistema.getPedidos().calcValorTipo(TipoParque.LIVRE);
        txtLivre.setText("" + valorPorTipoLivre);

        double valorPorTipoCondicionado = sistema.getPedidos().calcValorTipo(TipoParque.CONDICIONADO);
        txtLivre.setText("" + valorPorTipoCondicionado);

        double valorPorTipoAssegurado = sistema.getPedidos().calcValorTipo(TipoParque.ASSEGURADO);
        txtLivre.setText("" + valorPorTipoAssegurado);

        double total = sistema.getPedidos().calcValorGlobal();
        txtTotal.setText("" + total);
        
        
        float pgasoleo = sistema.getListaViaturas().getPercentagemPorCombustivel("Gasóleo");
        String pgasoleo2 = String.valueOf(pgasoleo);
        txtGasoleo.setText(pgasoleo2);
        float pgasolina = sistema.getListaViaturas().getPercentagemPorCombustivel("Gasolina");
        String pgasolina2 = String.valueOf(pgasolina);
        txtGasolina.setText(pgasolina2);
        
        double livre = sistema.getPedidos().calcValorTipo(TipoParque.LIVRE);
        String valorLivre = String.valueOf(livre);
        txtLivre.setText(valorLivre);
        
        double condi = sistema.getPedidos().calcValorTipo(TipoParque.CONDICIONADO);
        String valorCondi = String.valueOf(condi);
        txtCondi.setText(valorCondi);
        
        double assegurado = sistema.getPedidos().calcValorTipo(TipoParque.ASSEGURADO);
        String valorAssegurado = String.valueOf(assegurado);
        txtAssegurado.setText(valorAssegurado);
        
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLivre = new javax.swing.JTextField();
        txtCondi = new javax.swing.JTextField();
        txtAssegurado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtGasoleo = new javax.swing.JTextField();
        txtGasolina = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Mais Informações");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Valor Angariado");

        jLabel3.setText("Parque Livre:");

        jLabel4.setText("Parque Condicionado:");

        jLabel5.setText("Parque Assegurado: ");

        txtCondi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCondiActionPerformed(evt);
            }
        });

        txtAssegurado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsseguradoActionPerformed(evt);
            }
        });

        jLabel6.setText("TOTAL:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Percentagem de Viaturas Por Combustivel");

        jLabel8.setText("Gasóleo:");

        jLabel9.setText("Gasolina:");

        txtGasolina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGasolinaActionPerformed(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAssegurado, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLivre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCondi, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtGasoleo)
                                            .addComponent(txtGasolina, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
                                    .addComponent(jLabel7))))
                        .addContainerGap(114, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 548, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(38, 38, 38))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLivre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtGasoleo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCondi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txtGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAssegurado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCondiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCondiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCondiActionPerformed

    private void txtAsseguradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsseguradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsseguradoActionPerformed

    private void txtGasolinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGasolinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGasolinaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JanelaInicial frame = new JanelaInicial(sistema, bd, nome, username, JanelaLogin, utilizador, pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAssegurado;
    private javax.swing.JTextField txtCondi;
    private javax.swing.JTextField txtGasoleo;
    private javax.swing.JTextField txtGasolina;
    private javax.swing.JTextField txtLivre;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
