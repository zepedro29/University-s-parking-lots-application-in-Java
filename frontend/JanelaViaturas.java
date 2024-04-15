package frontend;

import Serializacao.Serializacao;
import backend.ControloEntradasSaidas;
import backend.Parque;
import backend.Pedido;
import backend.Sistema;
import backend.Utilizador;
import backend.Viatura;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class JanelaViaturas extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao bd;
    private AbstractTableModel modeloTabela;
    private String nome;
    private String username;
    private JanelaLogin JanelaLogin;
    private Utilizador Utilizador;
    private Pedido Pedido;

    public JanelaViaturas(Sistema sistema, Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;

        this.modeloTabela = criarTabelaMatriculas();
        TabelaMatriculas.setModel(modeloTabela);
        atualizarTabela();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        for (Parque p : sistema.getListaParques().listarParques()) {
            jComboBoxParque.addItem(p.getCodigo());
        }
    }

    public void atualizarTabela() {

        modeloTabela.fireTableDataChanged();

    }

    private AbstractTableModel criarTabelaMatriculas() {
        String[] nomeColunas = {"Matrícula", "Parque"};

        jLabel1.setText("Viaturas atuais");

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {

                return sistema.getListaControlos().getViaturasNosParques().size();

            }

            @Override
            public int getColumnCount() {

                return nomeColunas.length;
            }
            //ControloEntradasSaidas es = sistema.getListaControlos().getViaturasPorDataEParque(data, p).get(rowIndex);

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                ControloEntradasSaidas c = sistema.getListaControlos().getViaturasNosParques().get(rowIndex);

                switch (columnIndex) {
                    case 0:
                        return c.getViatura().getMatricula();
                    case 1:
                        return c.getParque().getCodigo();
                    default:
                        return "";
                }
            }
        };
    }

    private AbstractTableModel criarTabelaDatas() {
        String[] nomeColunas = {"Matrícula do Automóvel", "Parque", "Data e Hora"};

        jLabel1.setText("Viaturas por Data");

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {

                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
                LocalDate data = LocalDate.parse(txtData.getText(), formatter);

                return sistema.getListaControlos().getViaturasPorData(data).size();

            }

            @Override
            public int getColumnCount() {

                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d MMM uuuu HH:mm");
                LocalDate data = LocalDate.parse(txtData.getText(), formatter);

                ControloEntradasSaidas c = sistema.getListaControlos().getViaturasPorData(data).get(rowIndex);

                switch (columnIndex) {
                    case 0:
                        return c.getViatura().getMatricula();
                    case 1:
                        return c.getParque().getCodigo();
                    case 2:
                        return c.getDataEntrada().format(formatter2);
                    default:
                        return "";
                }
            }
        };
    }

    private AbstractTableModel criarTabelaDatasEParque() {
        String[] nomeColunas = {"Matrícula do Automóvel", "Parque", "Data e Hora"};

        jLabel1.setText("Viaturas por Data e Parque");

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {

                //vamos escrever o tst da data, a linha 84 é o formato da data e na linha 85 passa o tst para o formato de uma data
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
                LocalDate data = LocalDate.parse(txtData.getText(), formatter);
                Parque p = sistema.getListaParques().obterParque(jComboBoxParque.getSelectedItem().toString());

                return sistema.getListaControlos().getViaturasPorDataEParque(data, p).size();

            }

            @Override
            public int getColumnCount() {

                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d MMM uuuu HH:mm");
                LocalDate data = LocalDate.parse(txtData.getText(), formatter);
                Parque p = sistema.getListaParques().obterParque(jComboBoxParque.getSelectedItem().toString());

                ControloEntradasSaidas c = sistema.getListaControlos().getViaturasPorDataEParque(data, p).get(rowIndex);

                switch (columnIndex) {
                    case 0:
                        return c.getViatura().getMatricula();
                    case 1:
                        return c.getParque().getCodigo();
                    case 2:
                        return c.getDataEntrada().format(formatter2);
                    default:
                        return "";
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaMatriculas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBoxParque = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabelaMatriculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Matrículas"
            }
        ));
        jScrollPane1.setViewportView(TabelaMatriculas);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Viaturas nas Instalações");

        jLabel2.setText("DATA:");

        jLabel3.setText("PARQUE:");

        jButton1.setText("Procurar");
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

        jComboBoxParque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um parque..." }));
        jComboBoxParque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxParqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(109, 109, 109))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxParque, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtData))
                        .addGap(0, 30, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxParque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JanelaInicial frame = new JanelaInicial(sistema, bd, nome, username, JanelaLogin, Utilizador, Pedido);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtData.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza uma data!");
            txtData.requestFocus();
            return;
        }

        if (jComboBoxParque.getSelectedItem().equals("Selecione um parque...")) {
            this.modeloTabela = criarTabelaDatas();
            TabelaMatriculas.setModel(modeloTabela);
        } else {
            this.modeloTabela = criarTabelaDatasEParque();
            TabelaMatriculas.setModel(modeloTabela);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxParqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxParqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxParqueActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaMatriculas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxParque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
