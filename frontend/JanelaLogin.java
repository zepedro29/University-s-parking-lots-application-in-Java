package frontend;

import backend.Sistema;
import Serializacao.Serializacao;
import backend.Pedido;
import backend.Utilizador;
import javax.swing.JOptionPane;

public class JanelaLogin extends javax.swing.JDialog {

    private Sistema sistema;
    private Serializacao bd;
    private String nome;
    private String username;
    private Utilizador utilizador;
    private Pedido pedido;

    public JanelaLogin(Sistema sistema, Serializacao bd, String nome, String username, Utilizador utilizador) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.nome = nome;
        this.username = username;
        this.utilizador = utilizador;

        Usernametxt.requestFocus();
    }

    private void guardarAlteracoes() {
        bd.guardar(sistema);
    }

    private void autenticar() {

        if (Usernametxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o seu username!");
            Usernametxt.requestFocus();
            return;
        }

        if (Passwordtxt.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza a sua password!");
            Passwordtxt.requestFocus();
            return;
        }

        if (!sistema.autenticarUtilizador(Usernametxt.getText(), new String(Passwordtxt.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Os dados introduzidas não correspondem a um utilizador válido.",
                    "Autenticação", JOptionPane.WARNING_MESSAGE);
            Usernametxt.requestFocus();
        } else {
            dispose();
            JOptionPane.showMessageDialog(this, "Bem-vindo " + sistema.getUtilizadorLigado().getUsername() + "!");
            JanelaInicial frame = new JanelaInicial(sistema, bd, nome, username, this, utilizador, pedido);
            frame.setVisible(true);
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTituloLogin1 = new javax.swing.JLabel();
        jLabelTituloLogin = new javax.swing.JLabel();
        Usernametxt = new javax.swing.JTextField();
        Username = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        Passwordtxt = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelIcon = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabelTituloLogin1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabelTituloLogin1.setText("Estacionamentos Uminho");
        getContentPane().add(jLabelTituloLogin1);
        jLabelTituloLogin1.setBounds(180, 30, 380, 50);

        jLabelTituloLogin.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelTituloLogin.setText("Login  ");
        getContentPane().add(jLabelTituloLogin);
        jLabelTituloLogin.setBounds(310, 90, 140, 23);

        Usernametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernametxtActionPerformed(evt);
            }
        });
        getContentPane().add(Usernametxt);
        Usernametxt.setBounds(238, 130, 233, 28);

        Username.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Username.setText("Username");
        getContentPane().add(Username);
        Username.setBounds(110, 130, 126, 28);

        Password.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Password.setText("Password");
        getContentPane().add(Password);
        Password.setBounds(110, 190, 100, 28);

        Passwordtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordtxtActionPerformed(evt);
            }
        });
        getContentPane().add(Passwordtxt);
        Passwordtxt.setBounds(238, 192, 233, 27);

        jButtonLogin.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(0, 204, 0));
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin);
        jButtonLogin.setBounds(250, 240, 89, 33);

        jButtonSair.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(255, 51, 51));
        jButtonSair.setText("Fechar");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(370, 240, 89, 33);

        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/iconCarro.png"))); // NOI18N
        getContentPane().add(jLabelIcon);
        jLabelIcon.setBounds(20, 20, 140, 80);

        jButton1.setText("Registar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 290, 130, 30);

        setSize(new java.awt.Dimension(597, 356));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UsernametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernametxtActionPerformed

    private void PasswordtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordtxtActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        autenticar();
        
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar a aplicação?", "Terminar", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        JanelaRegistoUtenteEViatura frame = new JanelaRegistoUtenteEViatura(sistema, bd, nome, username, utilizador);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField Passwordtxt;
    private javax.swing.JLabel Username;
    private javax.swing.JTextField Usernametxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelTituloLogin;
    private javax.swing.JLabel jLabelTituloLogin1;
    // End of variables declaration//GEN-END:variables

}
