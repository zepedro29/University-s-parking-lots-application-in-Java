package frontend;

import backend.EstadoPedido;
import backend.Parque;
import backend.Pedido;
import backend.Sistema;
import Serializacao.Serializacao;
import backend.Utilizador;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.AbstractTableModel;
import javax.swing.JOptionPane;


public class JanelaTabelaPedidosPendentes extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao bd;
    private AbstractTableModel modeloTabela;
    private Utilizador utilizador;
    private String username;
    private String nome;
    private JanelaLogin JanelaLogin;
    private Pedido pedido;
    
    
    
    public JanelaTabelaPedidosPendentes(Sistema sistema, Serializacao bd) {
        initComponents();        
        this.sistema = sistema;
        this.bd = bd;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.modeloTabela = criarTabela();
        jTabela.setModel(modeloTabela);
    }

    private void atualizar() {
        modeloTabela.fireTableDataChanged();
    }
    
    private AbstractTableModel criarTabela() {
        String[] nomeColunas = {"Tipo de Parque", "Username", "Codigo Parque", "Numero do lugar"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return sistema.getPedidos().listarPedidosEstado(EstadoPedido.PENDENTE).size();
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                /*
                Este método é invocado quando se pretende "popular" cada uma das células da tabela
                Se a tabela tem 3 linhas e 2 colunas existem 6 células (3*2), logo o método será invocado 6 vezes
                    rowIndex representa a linha da célula (0 a rowCount -1)
                    columnIndex representa a coluna da célula (0 a ColumnCount -1)
                 */ 
                Pedido p = sistema.getPedidos().listarPedidosEstado(EstadoPedido.PENDENTE).get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return p.getTipoParque();
                    case 1:
                        return p.getUtente().getUsername();
                    case 2:
                        
                        if (p.getParque() == null) {
                            return "";
                        } else {
                        return p.getParque().getCodigo();
                        }
                                               
                    case 3:
                        return p.getNumLugar();
                    default:
                        return "";
                }
            }
        };
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Pedidos Pendentes");

        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTabela);

        jButton1.setText("Recusar Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceitar Pedido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(176, 176, 176))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rowIndex = jTabela.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um pedido para recusar o acesso!");
            return;
        }
        Pedido p = sistema.getPedidos().pesquisarPorUtente((String) modeloTabela.getValueAt(rowIndex, 1));
        sistema.getPedidos().recusarPedido(p);
        bd.guardar(sistema);
        atualizar();
        JOptionPane.showMessageDialog(this, "Pedido Recusado!");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int rowIndex = jTabela.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um pedido para conceder o acesso!");
            return;
        }
        Pedido p = sistema.getPedidos().pesquisarPorUtente((String) modeloTabela.getValueAt(rowIndex, 1));
        sistema.getPedidos().confirmarPedido(p);
        bd.guardar(sistema);
        atualizar();
        JOptionPane.showMessageDialog(this, "Pedido concedido!");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JanelaInicial frame = new JanelaInicial(sistema, bd, username, nome, JanelaLogin, utilizador, pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    // End of variables declaration//GEN-END:variables
}
