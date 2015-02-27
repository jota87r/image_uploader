/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.frontend.listeners;

import com.j.backend.DiskManager;
import com.j.backend.SevereException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author jonatan
 */
@WebListener
public class ContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {
      DiskManager.createPath();
    } catch (SevereException ex) {
      Logger.getLogger(ContextListener.class.getName()).log(Level.SEVERE, null, ex);
    }
    DiskManager.initCache();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
