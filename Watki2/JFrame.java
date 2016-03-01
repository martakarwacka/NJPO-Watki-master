package watki2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JFrame extends javax.swing.JFrame {

    Thread factorialRec;
    Thread factorialIt;
    public JFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doCalculationsButton = new javax.swing.JButton();
        interruptButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        valueNumericUpDown = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        recLabel = new javax.swing.JLabel();
        itLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        doCalculationsButton.setText("Oblicz");
        doCalculationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doCalculationsButtonActionPerformed(evt);
            }
        });

        interruptButton.setText("Nie chcę dłużej czekać");
        interruptButton.setEnabled(false);
        interruptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interruptButtonActionPerformed(evt);
            }
        });

        resultLabel.setText("0");

        jLabel2.setText("Wartość silni z: ");

        jLabel3.setText("Silnia z podanej liczby wynosi: ");

        jLabel4.setText("Dla obliczeń metodą rekurencyjną");

        jLabel5.setText("Dla obliczeń metodą iteracyjną");

        recLabel.setText("0");

        itLabel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(doCalculationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interruptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultLabel)
                    .addComponent(valueNumericUpDown, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recLabel)
                    .addComponent(itLabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(valueNumericUpDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doCalculationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resultLabel)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(recLabel)))
                    .addComponent(interruptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(itLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doCalculationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doCalculationsButtonActionPerformed
        resultLabel.setText("0");
        recLabel.setText("0");
        itLabel.setText("0");
        if((int)valueNumericUpDown.getValue() <= 20000 && (int)valueNumericUpDown.getValue() >= 0){
        doCalculationsButton.setEnabled(false);
        interruptButton.setEnabled(true);
        factorialRec = new Thread(new Factorial(true,(int)valueNumericUpDown.getValue()));
        factorialIt = new Thread(new Factorial(false,(int)valueNumericUpDown.getValue()));
        factorialRec.start();
        factorialIt.start();
            try {
                factorialIt.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        getResults();
        doCalculationsButton.setEnabled(true);
        interruptButton.setEnabled(false);
        }
        else
            JOptionPane.showMessageDialog(null,"Wprowadzona liczba musi być z zakresu 0-20000","Błędna wartość",JOptionPane.WARNING_MESSAGE);
        
            
    }//GEN-LAST:event_doCalculationsButtonActionPerformed

    private void interruptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interruptButtonActionPerformed
        interruptButton.setEnabled(false);
        factorialRec.interrupt();
        factorialIt.interrupt();
        doCalculationsButton.setEnabled(true);
    }//GEN-LAST:event_interruptButtonActionPerformed

    private void getResults(){
        if(Factorial.GetRecResult().toString().equals(Factorial.GetItResult().toString())){
            resultLabel.setText(Factorial.GetRecResult().toString());
            recLabel.setText(Long.toString(Factorial.GetRecTime()) + " μs");
            itLabel.setText(Long.toString(Factorial.GetItTime())+ " μs");
        }
        else
            resultLabel.setText("Wystąpił błąd");
        
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doCalculationsButton;
    private javax.swing.JButton interruptButton;
    private javax.swing.JLabel itLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel recLabel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JSpinner valueNumericUpDown;
    // End of variables declaration//GEN-END:variables
}
