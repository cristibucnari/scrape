package com.scrape.web;

import java.net.URL;

/**
 *
 * @author Cristi Bucnari
 */
public interface IScrape {
 /**
  * get content of the file
  * @param url
  * @return string content of URL
  */ 
   public String getContent(String url); 
  /**
   * stop the script
   * @param savefilePath location where the file is saved
   * @param content
   */ 
  public void save(String savefilePath,String content);
  
}
