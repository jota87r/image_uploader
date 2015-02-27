/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.backend;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author jonatan
 */
class FileCache {
  
  private static FileCache instance;
  
  private ConcurrentLinkedQueue<String> fileNames;
  
  private FileCache() {
    fileNames = new ConcurrentLinkedQueue<>();
  }
  
  public final static FileCache instance() {
    return instance == null ? instance = new FileCache() : instance;
  }
  
  
}
