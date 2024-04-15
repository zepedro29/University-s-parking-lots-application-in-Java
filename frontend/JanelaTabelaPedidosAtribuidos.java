package frontend;

import backend.EstadoPedido;
import backend.Pedido;
import backend.Sistema;
import Serializacao.Serializacao;
import backend.Utilizador;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.AbstractTableModel;

public class JanelaTabelaPedidosAtribuidos extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao bd;
    private AbstractTableModel modeloTabela;
    private String username; 
    private String nome; 
    private JanelaLogin JanelaLogin;
    private Utilizador Utilizador;
    private Pedido Pedido;
    
    public JanelaTabelaPedidosAtribuidos(Sistema sistema, Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.modeloTabela = criarTabela();
        jTable1.setModel(modeloTabela);
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
                return sistema.getPedidos().listarPedidosEstado(EstadoPedido.ATRIBUIDO).size();
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                 
                Pedido p = sistema.getPedidos().listarPedidosEstado(EstadoPedido.ATRIBUIDO).get(rowIndex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Pedidos Atribuídos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(143, 143, 143))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JanelaInicial frame = new JanelaInicial(sistema, bd, username, nome, JanelaLogin, Utilizador, Pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
