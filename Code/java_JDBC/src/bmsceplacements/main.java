/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmsceplacements;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 *
 * @author Nilansh Thakur
 */
public class main extends Thread{
    //This function enables to play audiio during splash screen
    public static void play(String file){
        InputStream music;
        try{
            music=new FileInputStream(new File(file));
            AudioStream audio=new AudioStream(music);
            AudioPlayer.player.start(audio);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Could not load music.");
        }
    }
    public static void main(String args[]){
        //mention this path here
        play("give the absolute path of the audio file");
        testing t=new testing();
        java.awt.EventQueue.invokeLater(() -> {
             t.setVisible(true);
         });
        studentlist l=new studentlist();
        try{
            //This is a snippet to create a loading screen 
            for(int i=0;i<100;i++)
            {
                Thread.sleep(73);
                t.bar.setValue(i);
                t.progress.setText(Integer.toString(i)+"%");
            }
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmsceplacements","root","");
        String query="select * from meeting"; 
        PreparedStatement st2=con.prepareStatement(query);
        ResultSet rs2=st2.executeQuery();
        l.t01.setModel(DbUtils.resultSetToTableModel(rs2)); 
        con.close();
        
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        new testing().setVisible(false);
        l.setVisible(true);
        t.dispose();
}
}
