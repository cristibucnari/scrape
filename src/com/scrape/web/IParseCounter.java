/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.scrape.web;

/**
 *
 * @author Cristi Bucnari
 */
public interface IParseCounter {
/**
 * 
 */
  public void start();  
/**
 * 
 */
  public void stop();  
  
/**
 * 
     * @return  the counter
 */
  public int getCounter();  
}
