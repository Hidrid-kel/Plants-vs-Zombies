import java.awt.*;
import javax.swing.*;


public class Menu extends JPanel {

    /**
     * Creates new form Menu
     */
    Image bgImage;
    public Menu() {
        initComponents();
        setSize(1012, 785);
        bgImage  = new ImageIcon(this.getClass().getResource("images/menu.jpg")).getImage();
        
    }

    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage,0,0,null);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1012, 785));

        jPanel1.setOpaque(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(485, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(555, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        GameWindow.begin();
    }                                    


    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}

