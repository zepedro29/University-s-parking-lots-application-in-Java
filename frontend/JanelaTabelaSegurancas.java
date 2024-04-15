package frontend;

import Serializacao.Serializacao;
import backend.Pedido;
import backend.Seguranca;
import backend.Sistema;
import backend.Utilizador;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class JanelaTabelaSegurancas extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao bd;
    private AbstractTableModel modeloTabela;
    private Utilizador utilizador;
    private String username;
    private String nome;
    private JanelaLogin JanelaLogin;
    private Pedido pedido;
    private Seguranca seguranca;

    public JanelaTabelaSegurancas(Sistema sistema, Serializacao bd, Utilizador utilizador) {
        initComponents();

        this.sistema = sistema;
        this.bd = bd;
        this.utilizador = utilizador;

        modeloTabela = criarTabelaSegurancas();
        jTableSeg.setModel(modeloTabela);
        atualizarTabela();

    }

    private AbstractTableModel criarTabelaSegurancas() {
        String[] nomeColunas = {"Nome", "Username", "Password"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {

                return sistema.getUtilizadores().getSegurancas().size();
            }

            @Override
            public int getColumnCount() {

                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return sistema.getUtilizadores().getSegurancas().get(rowIndex).getNome();
                    case 1:
                        return sistema.getUtilizadores().getSegurancas().get(rowIndex).getUsername();
                    case 2:
                        return sistema.getUtilizadores().getSegurancas().get(rowIndex).getPassword();
                    default:
                        return "";
                }
            }
        };
    }

    public void atualizarTabela() {
        modeloTabela.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSeg = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Seguranças");

        jTableSeg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Username", "Password"
            }
        ));
        jScrollPane1.setViewportView(jTableSeg);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (jTableSeg.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor selecionar uma linha", "Aviso", JOptionPane.WARNING_MESSAGE);
            btnRemover.setSelected(false);
        } else {

            int opcao = JOptionPane.showConfirmDialog(null, "Eliminar o segurança em efetivo?", "Eliminar segurança", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                int rowIndex = jTableSeg.getSelectedRow();

                Seguranca s = (Seguranca) sistema.getUtilizadores().getUtilizador((String) modeloTabela.getValueAt(rowIndex, 1));
                sistema.getUtilizadores().remover(s);
            
                JOptionPane.showMessageDialog(null, "Segurança eliminado com sucesso", "Sucesso", JOptionPane.OK_OPTION);
                atualizarTabela();
                

            }
        }
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        JanelaAdicionarSeguranca frame = new JanelaAdicionarSeguranca(sistema, seguranca, this, bd);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JanelaInicial frame = new JanelaInicial(sistema, bd, nome, username, JanelaLogin, utilizador, pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSeg;
    // End of variables declaration//GEN-END:variables
}
