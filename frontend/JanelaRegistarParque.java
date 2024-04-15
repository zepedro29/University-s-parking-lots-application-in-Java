package frontend;

import Serializacao.Serializacao;
import backend.Parque;
import backend.Pedido;
import backend.Sistema;
import backend.TipoParque;
import backend.Utilizador;
import javax.swing.JOptionPane;

public class JanelaRegistarParque extends javax.swing.JFrame {

    private Sistema sistema;
    private JanelaLogin JanelaLogin;
    private Serializacao bd;
    private String nome;    
    private String username;
    private Utilizador utilizador;
    private Pedido pedido;

    public JanelaRegistarParque(Sistema sistema, JanelaLogin JanelaLogin, Serializacao bd, String nome, Parque parque) {
        initComponents();

        this.sistema = sistema;       
        this.bd = bd;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        verTiposParque();          
    }
    
    private void verTiposParque() {
        TipoParque[]tipos = {TipoParque.CONDICIONADO, TipoParque.LIVRE, TipoParque.ASSEGURADO};
        for (TipoParque tipo : tipos) {
            comboTiposParque.addItem(tipo.toString());
        }
    }

    public void guardar() {
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o nome do parque");
            txtNome.requestFocus();
            return;
        }
        if (txtCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o codigo do parque");
            txtCodigo.requestFocus();
            return;
        }
        if (txtLugares.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o numero maximo de lugares do parque");
            txtLugares.requestFocus();
            return;
        }
        if (comboTiposParque.getSelectedItem().toString().equalsIgnoreCase("Selecione o tipo de parque...")) {
            JOptionPane.showMessageDialog(this, "Selecione um tipo");
            return;
        }
        
        TipoParque tipo;
        if (comboTiposParque.getSelectedItem().toString().equalsIgnoreCase("LIVRE")) {
            tipo = TipoParque.LIVRE;
        } else if (comboTiposParque.getSelectedItem().toString().equalsIgnoreCase("CONDICIONADO")) {
            tipo = TipoParque.CONDICIONADO;
        } else {
            tipo = TipoParque.ASSEGURADO;
        }
                       
        Parque p = new Parque(txtCodigo.getText(), txtNome.getText(), Integer.parseInt(txtLugares.getText()), tipo);
        sistema.getListaParques().registarParque(p);
        bd.guardar(sistema);
        JOptionPane.showMessageDialog(this, "Parque criado com sucesso!");
        txtNome.setText("");
        txtCodigo.setText("");
        txtLugares.setText("");
        comboTiposParque.setSelectedItem("Selecione o tipo de parque...");
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtLugares = new javax.swing.JTextField();
        comboTiposParque = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Registar Parque");

        jLabel2.setText("Código");

        jLabel3.setText("Tipo de parque: ");

        jLabel5.setText("Número de Lugares: ");

        txtLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLugaresActionPerformed(evt);
            }
        });

        comboTiposParque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o tipo..." }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel6.setText("Nome: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtLugares, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCodigo)
                        .addComponent(comboTiposParque, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboTiposParque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtLugares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnVoltar))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLugaresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugaresActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        JanelaTabelaParques frame = new JanelaTabelaParques(sistema, bd);
        frame.setVisible(true);
        dispose();


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        JanelaTabelaParques frame = new JanelaTabelaParques(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> comboTiposParque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtLugares;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
