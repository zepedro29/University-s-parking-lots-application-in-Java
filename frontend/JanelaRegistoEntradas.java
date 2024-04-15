package frontend;

import Serializacao.Serializacao;
import backend.ControloEntradasSaidas;
import backend.Parque;
import backend.Pedido;
import backend.Sistema;
import backend.Utilizador;
import backend.Viatura;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class JanelaRegistoEntradas extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao bd;
    private String username;
    private String nome;
    private Utilizador utilizador;
    private JanelaLogin JanelaLogin;
    private Pedido pedido;

    public JanelaRegistoEntradas(Sistema sistema, Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        for (Parque p : sistema.getListaParques().listarParques()) {

            comboParque.addItem(p.getCodigo());
        }
    }

    // falta ver se a viatura já está no parque
    public void guardar() {
        if (txtMatricula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza a sua matricula");
            txtMatricula.requestFocus();
            return;
        }
        if (comboParque.getSelectedItem().toString().equalsIgnoreCase("Selecione um parque...")) {
            JOptionPane.showMessageDialog(this, "Selecione um parque");
            return;
        }

        Viatura v = sistema.getListaViaturas().retornarViaturaa(txtMatricula.getText().trim());
        Parque p = sistema.getListaParques().obterParque(comboParque.getSelectedItem().toString());

        ControloEntradasSaidas c = new ControloEntradasSaidas(LocalDateTime.now(), p, v);
        sistema.getListaControlos().entradaViatura(c);

        JanelaInicial frame = new JanelaInicial(sistema, bd, nome, username, JanelaLogin, utilizador, pedido);
        frame.setVisible(true);
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        comboParque = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Registo de Entradas ");

        jLabel2.setText("Parque: ");

        jLabel3.setText("Matrícula:");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboParque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o parque..." }));
        comboParque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboParqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMatricula)
                                    .addComponent(comboParque, 0, 192, Short.MAX_VALUE))))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboParque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboParqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboParqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboParqueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboParque;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
