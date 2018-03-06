
package br.com.infnet.gui;

import br.com.infnet.contatos.Contato;
import br.com.infnet.contatos.ContatoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AgendaDeContatos extends javax.swing.JFrame {

    private int idEmEdicao;
    private List<Integer> listaDeIds;
    private ContatoDAO contatoDAO;
    
    public AgendaDeContatos() {
        initComponents();
        contatoDAO = new ContatoDAO();
        this.listarContatos();
    }
    
    private void listarContatos(){
        
        lstNomes.removeAll();
        listaDeIds = new ArrayList();
        try {
            
            List<Contato> contatos = contatoDAO.listar();
            for (Contato contato : contatos) {
                
                lstNomes.add(contato.getNome());
                listaDeIds.add(contato.getId());
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro ao listar os Contatos");
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lstNomes = new java.awt.List();
        lblNome = new java.awt.Label();
        txtNome = new java.awt.TextField();
        lblEmail = new java.awt.Label();
        lblFone = new java.awt.Label();
        txtEmail = new java.awt.TextField();
        txtFone = new java.awt.TextField();
        pnlBotao = new java.awt.Panel();
        btnSalvar = new java.awt.Button();
        btnLimpar = new java.awt.Button();
        btnExcluir = new java.awt.Button();
        btnImprimir = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda de contatos");

        lblNome.setText("Nome:");

        lblEmail.setText("Email");

        lblFone.setText("Telefone");

        btnSalvar.setLabel("Salvar");
        btnSalvar.setName("Salvar"); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        pnlBotao.add(btnSalvar);
        btnSalvar.getAccessibleContext().setAccessibleName("");

        btnLimpar.setLabel("Limpar");
        pnlBotao.add(btnLimpar);

        btnExcluir.setEnabled(false);
        btnExcluir.setLabel("Excluir");
        pnlBotao.add(btnExcluir);

        btnImprimir.setLabel("Imprimir");
        pnlBotao.add(btnImprimir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBotao, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(lstNomes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblFone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lstNomes, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(416, 404));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        try {
            
        Contato contato = new Contato();
        contato.setId(idEmEdicao);
        contato.setNome(txtNome.getText());
        contato.setEmail(txtEmail.getText());
        contato.setFone(txtFone.getText());
        
        if (idEmEdicao == 0){
            
            contatoDAO.inserir(contato);
            
        }
            
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar os Contatos");
        }
        
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaDeContatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnExcluir;
    private java.awt.Button btnImprimir;
    private java.awt.Button btnLimpar;
    private java.awt.Button btnSalvar;
    private java.awt.Label lblEmail;
    private java.awt.Label lblFone;
    private java.awt.Label lblNome;
    private java.awt.List lstNomes;
    private java.awt.Panel pnlBotao;
    private java.awt.TextField txtEmail;
    private java.awt.TextField txtFone;
    private java.awt.TextField txtNome;
    // End of variables declaration//GEN-END:variables
}
