/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scrape.web;
import com.scrape.exceptions.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Cristi Bucnari
 */
public class Scrape extends AParse{

    static String PATH_OUT_WRITE_FILE = "/YOUR/PATH/WHERE/THE/FILE/IS/SAVED/";      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       String pageName = "wiki_Modular_programming.html"; 
       Scrape scrape = new Scrape();
       String content = scrape.getContent("https://en.wikipedia.org/wiki/Modular_programming");
       if(!content.equals("")){
        scrape.save(PATH_OUT_WRITE_FILE+pageName, content);
       }
       System.out.println(content);
       System.out.println("Count Files : "+scrape.getCounter());
    }
    /**
     * save the content to a file
     * 
     * @param savefilePath
     * @param content
   */
 @Override
  public void save(String savefilePath,String content){
     try {
         File fileOut = new File(savefilePath);
         fileOut.delete();
         
         try (FileWriter fw = new FileWriter(savefilePath)) {
             fw.write(content);
         }
       System.out.println("Done");
     } catch (IOException ex) {
         Logger.getLogger(Scrape.class.getName()).log(Level.SEVERE, null, ex);
     }      
  }

}
