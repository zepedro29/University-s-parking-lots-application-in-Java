package frontend;

import Serializacao.Serializacao;
import backend.Pedido;
import backend.Sistema;
import backend.Utente;
import backend.Utilizador;

import javax.swing.JOptionPane;

public class JanelaVerDadosU extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao bd;
    private String nome;
    private String username;
    private JanelaLogin JanelaLogin;
    private Utilizador utilizador;
    private Pedido pedido;

    public JanelaVerDadosU(Sistema sistema, Serializacao bd, String nome, String username, JanelaLogin JanelaLogin, Utilizador utilizador) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.nome = nome;
        this.username = username;
        this.utilizador = utilizador;

        txtUsername.setEditable(false);
        txtNome.setEditable(false);
        txtPass.setEditable(false);

        setTitle("Os seus dados ");
        Utente utente = (Utente) sistema.getUtilizadorLigado();
        txtNome.setText(utente.getNome());
        txtUsername.setText(utente.getUsername());
        txtPass.setText(utente.getPassword());

    }

    /*public void guardar() {
        if (txtNome.getText().isEmpty() || txtPass.getText().isEmpty() || txtConf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos, por favor!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            if (!txtPass.getText().equals(txtConf.getText())) {
                JOptionPane.showMessageDialog(this, "As passwords não correspondem!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                sistema.getUtilizadores().editarDados(txtNome.getText(), username, txtPass.getText());
                JOptionPane.showMessageDialog(this, "Dados editados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jEditar = new javax.swing.JButton();
        txtPass = new javax.swing.JTextField();
        jButtonVoltar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Os Seus Dados");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/DadosUtente.png"))); // NOI18N

        jLabel3.setText("Nome:");

        jLabel4.setText("Username:");

        jLabel5.setText("Password:");

        jEditar.setText("Editar");
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
            }
        });

        jButtonVoltar1.setText("Voltar");
        jButtonVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(126, 126, 126)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jEditar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonVoltar1))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)))))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEditar)
                    .addComponent(jButtonVoltar1))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarActionPerformed
        JanelaEditarDadosUtente frame = new JanelaEditarDadosUtente(sistema, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jEditarActionPerformed

    private void jButtonVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltar1ActionPerformed
        JanelaInicial frame = new JanelaInicial(sistema, bd, nome, username, JanelaLogin, utilizador, pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVoltar1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar1;
    private javax.swing.JButton jEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
