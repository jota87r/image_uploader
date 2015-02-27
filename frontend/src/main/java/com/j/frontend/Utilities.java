/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.frontend;

/**
 *
 * @author jonatan
 */
public class Utilities {
  
  public final static boolean isNull(String val) {
    return val == null || "".equals(val.trim()) || "null".equalsIgnoreCase(val);
  }
}
