/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.frontend;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jonatan
 */
class MessageManager {
  
  static void setMessage(String title, String content) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(title, content));
  }
}
