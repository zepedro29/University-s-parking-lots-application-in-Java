package frontend;

import Serializacao.Serializacao;
import backend.EstadoPedido;
import backend.Parque;
import backend.Pedido;
import backend.Sistema;
import backend.Utente;
import backend.Utilizador;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class JanelaListaPedidos extends javax.swing.JFrame {

    private String nome;
    private Sistema sistema;
    private Serializacao bd;
    private AbstractTableModel modeloTabela;
    private Utente utente;
    private Parque parque;
    private Utilizador utilizador;
    private JanelaLogin JanelaLogin;
    private String username;
    private Pedido pedido;

    public JanelaListaPedidos(String nome, Sistema sistema, Serializacao bd, Utente utente, Parque parque, Utilizador utilizador, JanelaLogin JanelaLogin, String username, Pedido pedido) {
        initComponents();

        this.nome = nome;
        this.sistema = sistema;
        this.bd = bd;
        this.utente = utente;
        this.parque = parque;
        this.utilizador = utilizador;
        this.JanelaLogin = JanelaLogin;
        this.username = username;
        this.pedido = pedido;

        modeloTabela = criarTabelaPedidos();
        jTable1.setModel(modeloTabela);
    }

    private AbstractTableModel criarTabelaPedidos() {
        String[] nomeColunas = {"Utente", "Tipo de Parque", "Estado do Pedido", "Nº Lugar"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {

                return sistema.getPedidos().tamanho();

            }

            @Override
            public int getColumnCount() {

                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return sistema.getPedidos().listarPedidosEstado(EstadoPedido.PENDENTE).get(rowIndex).getUtente().getUsername();
                    case 1:
                        return sistema.getPedidos();
                    case 2:
                        return sistema.getPedidos().verEstado(pedido);
                    case 3:
                        /*return*/ sistema.getPedidos().atribuirLugar(pedido);

                    default:
                        return "";
                }
            }

        };
    }

    private void conceder() {
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor selecionar uma linha", "Aviso", JOptionPane.WARNING_MESSAGE);
            btnConceder.setSelected(false);
        } else {

            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente conceder acesso?", "Acesso concedido", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                int rowIndex = jTable1.getSelectedRow();

                String username = (String) modeloTabela.getValueAt(rowIndex, 1);

                sistema.getPedidos().confirmarPedido(pedido);
                JOptionPane.showMessageDialog(null, "Pedido aceite com sucesso", "Sucesso", JOptionPane.OK_OPTION);
                this.atualizarTabela();
                btnConceder.setSelected(false);
            }
        }
    }

    private void recusar() {
         if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor selecionar uma linha", "Aviso", JOptionPane.WARNING_MESSAGE);
            btnConceder.setSelected(false);
        } else {

            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente recusar acesso?", "Acesso recusado", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                int rowIndex = jTable1.getSelectedRow();

                String username = (String) modeloTabela.getValueAt(rowIndex, 1);

                sistema.getPedidos().recusarPedido(pedido);
                JOptionPane.showMessageDialog(null, "Pedido recusado com sucesso", "Sucesso", JOptionPane.OK_OPTION);
                this.atualizarTabela();
                btnConceder.setSelected(false);
            }
        }
    }

    public void atualizarTabela() {
        modeloTabela.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnConceder = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Pedidos de Acesso");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Utente", "Tipo de Parque", "Estado do Pedido", "Nº Lugar"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Recusar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnConceder.setText("Conceder");
        btnConceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcederActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnConceder, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConceder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConcederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcederActionPerformed
        conceder();
    }//GEN-LAST:event_btnConcederActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        recusar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JanelaInicial frame = new JanelaInicial(sistema, bd, nome, username, JanelaLogin, utilizador, pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConceder;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
