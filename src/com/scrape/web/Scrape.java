/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scrape.web;
import com.scrape.exceptions.*;
import java.lang.AutoCloseable;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author madrid-linux
 */
public class Scrape extends AParse  implements AutoCloseable{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /**
     * close the input file
     */
    @Override
    public void close(){
      try {
            stop(); 
            throw new ScrapeException("Stop Final");
        } catch (ScrapeException ex) {
            Logger.getLogger(Scrape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
