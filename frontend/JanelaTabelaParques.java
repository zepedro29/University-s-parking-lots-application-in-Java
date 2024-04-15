package frontend;

import backend.Parque;
import backend.Sistema;
import Serializacao.Serializacao;
import backend.Pedido;
import backend.Utilizador;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.AbstractTableModel;

public class JanelaTabelaParques extends javax.swing.JFrame {
    
    private Sistema sistema;
    private Serializacao bd;
    private AbstractTableModel modeloTabela;
    private Utilizador utilizador;
    private String username;
    private String nome;
    private JanelaLogin JanelaLogin;
    private Pedido pedido;
    private Parque parque;
    
    public JanelaTabelaParques(Sistema sistema, Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.modeloTabela = criarTabela();
        jTable1.setModel(modeloTabela);
    }
    
    private void atualizar() {
        modeloTabela.fireTableDataChanged();
    }
    
    private AbstractTableModel criarTabela() {
        String[] nomeColunas = {"Tipo", "Nome", "Codigo", "Numero maximo de lugares", "Numero de lugares disponiveis"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {
                
                return sistema.getListaParques().listarParques().size();
            }

            @Override
            public int getColumnCount() {
               
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                
                Parque p = sistema.getListaParques().listarParques().get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return p.getTipoParque();
                    case 1:
                        return p.getNome();
                    case 2:
                        return p.getCodigo();
                    case 3:
                        return p.getNumLugares();
                    case 4: 
                        return p.getNumLugaresDisponiveis();
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
        jVoltar = new javax.swing.JButton();
        jAdicionar = new javax.swing.JButton();
        jRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Parques");

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

        jVoltar.setText("Voltar");
        jVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVoltarActionPerformed(evt);
            }
        });

        jAdicionar.setText("Adicionar");
        jAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarActionPerformed(evt);
            }
        });

        jRemover.setText("Remover");
        jRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(359, 359, 359))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAdicionar)
                    .addComponent(jRemover)
                    .addComponent(jVoltar))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVoltarActionPerformed
        JanelaInicial frame = new JanelaInicial(sistema, bd, nome, username, JanelaLogin, utilizador, pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jVoltarActionPerformed

    private void jAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarActionPerformed
        JanelaRegistarParque frame = new JanelaRegistarParque(sistema, JanelaLogin, bd, nome, parque);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jAdicionarActionPerformed

    private void jRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoverActionPerformed
        int rowIndex = jTable1.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um parque para remover!");
            return;
        }
        Parque p = sistema.getListaParques().obterParque((String) modeloTabela.getValueAt(rowIndex, 2));
        sistema.getListaParques().removerParque(p);
        bd.guardar(sistema);
        atualizar();
        
    }//GEN-LAST:event_jRemoverActionPerformed

   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAdicionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jVoltar;
    // End of variables declaration//GEN-END:variables
}
