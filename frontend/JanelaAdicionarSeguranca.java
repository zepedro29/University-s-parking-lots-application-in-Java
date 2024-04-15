package frontend;

import Serializacao.Serializacao;
import backend.Seguranca;
import backend.Sistema;
import backend.Utilizador;
import javax.swing.JOptionPane;

public class JanelaAdicionarSeguranca extends javax.swing.JFrame {

    private Sistema sistema;
    private Seguranca seguranca;
    private JanelaTabelaSegurancas janelaTabelaSegurancas;
    private Serializacao bd;
    private String nome;
    private Utilizador utilizador;

    public JanelaAdicionarSeguranca(Sistema sistema, Seguranca seguranca, JanelaTabelaSegurancas janelaTabelaSegurancas, Serializacao bd) {
        initComponents();

        this.sistema = sistema;
        this.bd = bd;
        this.janelaTabelaSegurancas = janelaTabelaSegurancas;
        this.utilizador = utilizador;
        
        if (registoNovo()) {    
            //Altera o titulo da janela
            //Como construimos sempre uma nova janela, as caixas de texto já estão limpas
            setTitle("Criação de novo utilizador");
            txtNome.requestFocus();                      
        }else{
            //No caso de um registo existente
            //Altera o titulo da janela
            setTitle("Alteração de dados de utilizador");
            //Preenche as caixas de texto com os dados do utilizador
            txtNome.setText(utilizador.getUsername());
            txtUsername.setText(utilizador.getUsername());
            
            txtPass.requestFocus();
        }
    }

    private boolean registoNovo() {
        return utilizador == null;
        } 
    
    private void guardar() {
         if (registoNovo() && txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o nome!");            
            txtNome.requestFocus();
            return;
        }
        
        if (txtUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o username!");            
            txtUsername.requestFocus();
            return;
        }
               
        if (txtPass.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a nova password!");
            txtPass.requestFocus();
            return;
        } 
        if (txtConf.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a password de confirmação!");
            txtConf.requestFocus();
            return;
        } 
        
        String password = new String(txtPass.getText());
        
        if (!password.equals(new String(txtConf.getText()))){
            JOptionPane.showMessageDialog(this, "A password de confirmação não corresponde à password introduzida!");
            txtConf.requestFocus();
            return;
        }
        
        if (registoNovo()) {      
            txtUsername.setEditable(true);                                 
            Seguranca novo = new Seguranca();            
            novo.setUsername(txtUsername.getText());
            novo.setNome(txtNome.getText());
            
            novo.setPassword(password);
         
            sistema.getUtilizadores().adicionar(novo);
                              
                  
        }else{
            txtUsername.setEditable(false);
            utilizador.setUsername(txtUsername.getText());        
            utilizador.setPassword(password);       
        }
        //Se tiver feito uma referencia a listagem, atualiza a listagem
        if (janelaTabelaSegurancas != null) janelaTabelaSegurancas.atualizarTabela();                 
        
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        JanelaTabelaSegurancas admlista = new JanelaTabelaSegurancas(sistema, bd, utilizador);
        admlista.setVisible(true);
        dispose();
        
        
    }
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
        txtPass = new javax.swing.JPasswordField();
        txtConf = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Segurança");

        jLabel2.setText("Nome:");

        jLabel3.setText("Username:");

        jLabel4.setText("Password:");

        jLabel5.setText("Confirmação Password:");

        txtConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar");
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
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNome)
                                .addComponent(txtUsername)
                                .addComponent(txtPass)
                                .addComponent(txtConf, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JanelaTabelaSegurancas frame = new JanelaTabelaSegurancas(sistema, bd, utilizador);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtConf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
