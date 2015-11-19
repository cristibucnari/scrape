/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.scrape.web;

import com.scrape.exceptions.ScrapeException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author  Cristi Bucnari,:
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
         //connect to resource
         openConnection.connect();
         //
         int responseCode = openConnection.getResponseCode();
         if(responseCode != 200) throw new ScrapeException("Parse Exception : "+responseCode);
         StringBuilder response;
         //
         try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()))){
             //
             String inputLine;
             response = new StringBuilder();
             //
             while ((inputLine = bufferReader.readLine()) != null) {
                 response.append(inputLine);
		}
           counter++;
           return response.toString(); 
         }               
           //System.out.println(response.toString());         
         
     
     } catch (MalformedURLException ex) {
         Logger.getLogger(AParse.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException | ScrapeException ex) {
         Logger.getLogger(AParse.class.getName()).log(Level.SEVERE, null, ex);
     }
   return ""; 
  }
  /**
   */
 @Override
  public abstract void save(String savefilePath,String content);
  
}
