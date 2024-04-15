package frontend;

import Serializacao.Serializacao;
import backend.Pedido;
import backend.Seguranca;
import backend.Sistema;
import backend.Viatura;
import backend.Utente;
import backend.Utilizador;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class JanelaViaturasUtente extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao bd;
    private String nome;
    private String username;
    private JanelaInicial JanelaInicial;
    private JanelaLogin JanelaLogin;
    private AbstractTableModel modeloTabela;
    private Utilizador utilizador;
    private Pedido pedido;

    public JanelaViaturasUtente(Sistema sistema, Serializacao bd, String nome, String username, JanelaInicial JanelaInicial, Utilizador utilizador) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.nome = nome;
        this.username = username;
        this.JanelaInicial = JanelaInicial;
        this.utilizador = utilizador;

        modeloTabela = criarTabelaViaturas();
        jTableViaturasUtente.setModel(modeloTabela);
        atualizarTabela();
        setLocationRelativeTo(null);
    }

    public void atualizarTabela() {

        modeloTabela.fireTableDataChanged();

    }

    private AbstractTableModel criarTabelaViaturas() {
        String[] nomeColunas = {"Matrícula", "Combustível", "Marca", "Modelo"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {

                Utente utente = (Utente) sistema.getUtilizadorLigado();
                return utente.getListaViaturas().tamanhoLista();

            }

            @Override
            public int getColumnCount() {

                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                Utente utente = (Utente) sistema.getUtilizadorLigado();
                Viatura v = utente.getListaViaturas().getListaViaturass().get(rowIndex);

                switch (columnIndex) {
                    case 0:
                        return v.getMatricula();
                    case 1:
                        return v.getCombustivel();
                    case 2:
                        return v.getMarca();
                    case 3:
                        return v.getModelo();
                    default:
                        return "";
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableViaturasUtente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("    As Suas Viaturas");

        jTableViaturasUtente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matrícula", "Combustível", "Marca", "Modelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableViaturasUtente);
        if (jTableViaturasUtente.getColumnModel().getColumnCount() > 0) {
            jTableViaturasUtente.getColumnModel().getColumn(0).setResizable(false);
            jTableViaturasUtente.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JanelaInicial utente2 = new JanelaInicial(sistema, bd, nome, username, JanelaLogin, utilizador, pedido);
        utente2.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Utente u = (Utente) sistema.getUtilizadorLigado();
        if (u.verificarTamanhoLista() == true) {
            dispose();
            JanelaAdicionarViaturas frame = new JanelaAdicionarViaturas(sistema, bd, nome, username, this, utilizador);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Já possui 3 viaturas!");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (jTableViaturasUtente.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor selecionar uma linha", "Aviso", JOptionPane.WARNING_MESSAGE);
            btnRemover.setSelected(false);
        } else {

            int opcao = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende eliminar a viatura?", "Eliminar Viatura", JOptionPane.YES_NO_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {

                int rowIndex = jTableViaturasUtente.getSelectedRow();

                String matricula = (String) modeloTabela.getValueAt(rowIndex, 0);

                Utente utente = (Utente) sistema.getUtilizadorLigado();                               
                utente.remover(matricula);
                
                //Viatura v = utente.getListaViaturas().retornarViaturaa(matricula);
                //utente.getListaViaturas().removerViatura(v);
                               
                //sistema.getListaViaturas().removerViatura(v);
                
                atualizarTabela();
                JOptionPane.showMessageDialog(null, "Viatura eliminada com sucesso", "Sucesso", JOptionPane.OK_OPTION);
               

            }

        }
    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableViaturasUtente;
    // End of variables declaration//GEN-END:variables
}
