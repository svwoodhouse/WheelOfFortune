package wheeloffortune;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author svw5194
 */
public class MainMenuGUI extends JFrame 
{
    private JButton spinWheel;
    private JButton buyVowel;
    private JButton solvePuzzle;
    private JButton exitGame;
    private WheelClass wheel = new WheelClass();
    ImageIcon image = new ImageIcon("V:\\NetBeansProjects\\WheelOfFortune\\wheels.png");
    JLabel imageLabel = new JLabel(image);

         
    JFrame mainFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel spinPanel = new JPanel();
    JPanel vowelPanel = new JPanel();
    JPanel solvePanel = new JPanel();
    
    public MainMenuGUI() throws IOException 
    {
         super("Wheel of Fortune : Main Frame");
         mainFrame.getContentPane().setLayout(null);
         mainFrame.setSize(860, 410);
         mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mainFrame.setVisible(true);
        imageLabel.setBounds(10, 10, 400, 400);
        imageLabel.setVisible(true);
         
         spinWheel = new JButton("Spin the Wheel");
         buyVowel = new JButton("Buy a Vowel");
         solvePuzzle = new JButton("Solve the Puzzle");
         exitGame = new JButton("Exit the Game");
         
         spinWheel.setBounds(10, 320, 200, 50);
         buyVowel.setBounds(220, 320, 200, 50);
         solvePuzzle.setBounds(430, 320, 200, 50);
         exitGame.setBounds(640, 320, 200, 50);

         mainFrame.add(imageLabel);
         mainFrame.add(spinWheel);
         mainFrame.add(buyVowel);
         mainFrame.add(solvePuzzle);
         mainFrame.add(exitGame);    

         spinWheel.addActionListener(new ActionListener() 
         {
           public void actionPerformed(ActionEvent e) 
           {
                 wheel.spinWheel();        
           }});
           
           buyVowel.addActionListener(new ActionListener()
           {
               public void actionPerformed(ActionEvent e)
               {
                 wheel.buyVowel();
               }
           });
         
         /*
         buyVowel.addActionListener(handler);
         solvePuzzle.addActionListener(handler);
         exitGame.addActionListener(handler);
                 */
    }
    
}
