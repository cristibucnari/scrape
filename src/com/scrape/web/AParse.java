/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.scrape.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author  Cristi Bucnari
 */
public abstract class AParse implements IScrape, IParseCounter {
 private int counter;
 protected String requestMethod="GET";
 
  /**
   * stop the script,exit status is the counter of file
   *
   */ 
 @Override
  public void stop(){
    System.exit(counter);
  } 
  /**
   * start the script
   *
   */ 
 @Override
  public void start(){
    counter = 0;
  } 
  /**
   * 
   * @return  the counter, how many files are scraped
   */
 @Override
  public int getCounter(){
   return counter;
  } 
  /**
   * implementation from interface IScrape
     * @param url
   */
 @Override
  public String getContent(String url){
     try {
         URL urlObject = new URL(url);
         HttpURLConnection openConnection = (HttpURLConnection) urlObject.openConnection();
         openConnection.setRequestMethod(this.requestMethod);
     
     } catch (MalformedURLException ex) {
         Logger.getLogger(AParse.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(AParse.class.getName()).log(Level.SEVERE, null, ex);
     }
   return ""; 
  }
  /**
   * 
   */
 @Override
  public void save(String savefilePath){
  
  }
  
}
