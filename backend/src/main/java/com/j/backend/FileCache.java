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
  
  private final static int CACHE_NAME_SIZE = 100;
  
  private static FileCache instance;
  
  private ConcurrentLinkedQueue<String> fileNames;
  
  private FileCache() {
    fileNames = new ConcurrentLinkedQueue<>();
  }
  
  final static FileCache instance() {
    return instance == null ? instance = new FileCache() : instance;
  }
  
  void addNameToCache(String name) {
    if (limitReached())
      fileNames.poll();
    fileNames.add(name);
  }
  
  String getNameFromCache() {
    return fileNames.peek();
  }
  
  boolean limitReached() {
    return fileNames.size() > CACHE_NAME_SIZE;
  }
  
  Object[] getNames() {
    return fileNames.toArray();
  }
}
