/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.backend;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonatan
 */
public class MinorException extends Exception {
  
  public MinorException(Exception e) {
    super(e);
    Logger.getLogger(DiskManager.class.getName()).log(Level.WARNING, null, e);
  }
}
