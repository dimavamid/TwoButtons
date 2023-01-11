
package twobuttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtons {
        JFrame frame;
        JLabel label;
    
    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();  
      }
    
    public void go(){
         frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         
         JButton labelButton = new JButton("Change label");
         labelButton.addActionListener(new LabelListener());
         
         JButton colorButton = new JButton("Change color");
         colorButton.addActionListener(new ColorListener());
         
         label = new JLabel ("I`m a label");
         Mypanel panel = new Mypanel ();
         
         frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
         frame.getContentPane().add(BorderLayout.CENTER, panel);
         frame.getContentPane().add(BorderLayout.EAST, labelButton);
         frame.getContentPane().add(BorderLayout.WEST, label);
         
        frame.setSize(600,600);
        frame.setVisible(true);
        }
    
    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
        label.setText("Ouch!");
        }
        
    }

            
    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
        frame.repaint();
        }
        
    }
            
    class Mypanel extends JPanel {
       public void paintComponent(Graphics g){
           g.fillRect(0,0,this.getWidth(),this.getHeight());
           
           int red = (int) (Math.random() * 255);
           int green = (int) (Math.random() * 255);
           int blue = (int) (Math.random() * 255);
           
           Color randomColor = new Color (red, green, blue);
           g.setColor(randomColor);
           g.fillOval(70,70,100,100);
       }             
    
    
}
}