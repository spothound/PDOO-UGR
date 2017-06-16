/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import NapakalakiGame.Player ; 
import NapakalakiGame.Treasure ; 
import NapakalakiGame.Napakalaki ; 
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author pinguino
 */
public class PlayerView extends javax.swing.JPanel {
    
    
    private Player playerModel ; 
    private Napakalaki napakalakiModel ; 
    private NapakalakiView npkvModel ; 
    
    public void setNpkvModel(NapakalakiView model){
        npkvModel = model ; 
    }
    
    public void setNapakalakiModel(Napakalaki model){
        napakalakiModel = model ; 
    }

    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
        this.pendingBadConsequence1.setVisible(false);
    }
    
    public void mostrarPending(boolean mode){
        this.pendingBadConsequence1.setVisible(mode);
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
    // Se recorren los tesoros que contiene el panel,
    // almacenando en un vector aquellos que están seleccionados.
    //Finalmente se devuelve dicho vector.

        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            tv.setEnabled(false);
            if ( tv.isSelected() )
                output.add ( tv.getTreasure() );
        }
        return output;
    }

    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        //al panel
        for (Treasure t : aList) {
        TreasureView aTreasureView = new TreasureView();
        aTreasureView.setTreasure (t);
        aTreasureView.setVisible (true);
        aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
        }
    
    
    public void setPlayer(Player model){
        playerModel = model ; 
       
        int levelfinal= playerModel.getLevels();
        for(Treasure t : playerModel.getVisibleTreasures())
            levelfinal += t.getBonus();
        
        if(playerModel.is_cultist()){
            fondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            fondo.setBackground(Color.black);
            player.setForeground(new java.awt.Color(220, 20, 20));
        }else{
            fondo.setBackground(new java.awt.Color(246, 246, 246));
            fondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            player.setForeground(new java.awt.Color(0, 0, 0));
            
            
        }
        fillTreasurePanel (visibleTreasures, playerModel.getVisibleTreasures());
        fillTreasurePanel (hiddenTreasures, playerModel.getHiddenTreasures());
        this.pendingBadConsequence1.setPending(model.getPendingBadConsequence()) ; 
        this.player.setText(playerModel.toString()) ; 
        repaint();
        revalidate();
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        player = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        makeVisibleButtom = new javax.swing.JButton();
        DiscardButtom = new javax.swing.JButton();
        DiscardAllButtom = new javax.swing.JButton();
        StealTreasure = new javax.swing.JToggleButton();
        pendingBadConsequence1 = new GUI.pendingBadConsequence();
        jSeparator1 = new javax.swing.JSeparator();
        hiddenTreasures = new javax.swing.JPanel();

        fondo.setBackground(new java.awt.Color(246, 246, 246));
        fondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        player.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        player.setForeground(new java.awt.Color(85, 80, 80));
        player.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        player.setText("____________________________________________________________________________");
        player.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        visibleTreasures.setBackground(java.awt.Color.lightGray);
        visibleTreasures.setBorder(new javax.swing.border.MatteBorder(null));

        makeVisibleButtom.setText("Make Visible");
        makeVisibleButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleButtomActionPerformed(evt);
            }
        });

        DiscardButtom.setText("Discard Treasure");
        DiscardButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscardButtomActionPerformed(evt);
            }
        });

        DiscardAllButtom.setText("DIscard All Treasures");
        DiscardAllButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscardAllButtomActionPerformed(evt);
            }
        });

        StealTreasure.setText("Steal Treasure");
        StealTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StealTreasureActionPerformed(evt);
            }
        });

        hiddenTreasures.setBackground(java.awt.Color.gray);
        hiddenTreasures.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addComponent(pendingBadConsequence1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(DiscardButtom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(makeVisibleButtom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DiscardAllButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StealTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46))
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(player, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(hiddenTreasures, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addContainerGap())))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pendingBadConsequence1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(player)
                        .addGap(18, 18, 18)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(makeVisibleButtom)
                            .addComponent(DiscardAllButtom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DiscardButtom)
                            .addComponent(StealTreasure))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void StealTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StealTreasureActionPerformed
        // TODO add your handling code here:
        napakalakiModel.getCurrentPlayer().stealTreasure() ;
        setPlayer( napakalakiModel.getCurrentPlayer() ) ;
    }//GEN-LAST:event_StealTreasureActionPerformed

    private void DiscardAllButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscardAllButtomActionPerformed
        // TODO add your handling code here:
        this.npkvModel.enableUseJoker(false) ; 
        napakalakiModel.getCurrentPlayer().discardAllTreasures();
        setPlayer( napakalakiModel.getCurrentPlayer() ) ;
        this.npkvModel.enableNextTurn();
    }//GEN-LAST:event_DiscardAllButtomActionPerformed

    private void DiscardButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscardButtomActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selected = getSelectedTreasures (hiddenTreasures);
        if(napakalakiModel.is_joker(selected))
            this.npkvModel.enableUseJoker(false) ;
        napakalakiModel.discardHiddenTreasures(selected);
        selected = getSelectedTreasures(visibleTreasures) ;
        napakalakiModel.discardVisibleTreasures(selected) ;
        setPlayer( napakalakiModel.getCurrentPlayer() ) ;
        if(napakalakiModel.getCurrentPlayer().validState())
        this.npkvModel.enableNextTurn();
    }//GEN-LAST:event_DiscardButtomActionPerformed

    private void makeVisibleButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleButtomActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        if(napakalakiModel.is_joker(selHidden))
            this.npkvModel.enableUseJoker(true) ; 
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
        if(napakalakiModel.getCurrentPlayer().validState())
        this.npkvModel.enableNextTurn();
    }//GEN-LAST:event_makeVisibleButtomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DiscardAllButtom;
    private javax.swing.JButton DiscardButtom;
    private javax.swing.JToggleButton StealTreasure;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton makeVisibleButtom;
    private GUI.pendingBadConsequence pendingBadConsequence1;
    private javax.swing.JLabel player;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}