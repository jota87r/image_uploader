/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonatan
 */
public class DiskManager {
  
  private final static int BUFFER_SIZE = 8 * 1024;
  private final static String path = System.getProperty("user.home") + "/uploaded_images/";

  public static void createPath() throws SevereException {
    try {
      Files.createDirectories(Paths.get(path));
    } catch (IOException ex) {
      throw new SevereException(ex);
    }
  }
  
  public static void write(InputStream in) throws SevereException, MinorException {
    try (OutputStream out = new FileOutputStream(createFile())) {
      byte[] buffer = new byte[BUFFER_SIZE];
      for (int bytesRead = in.read(buffer); bytesRead != -1; bytesRead = in.read(buffer))
        out.write(buffer, 0, bytesRead);
    } catch (IOException ex) {
      throw new SevereException(ex);
    } finally {
      try {
        in.close();
      } catch(IOException e) {
        throw new MinorException(e);
      }
    }
  }
  
  public static byte[] read(String name) {
    byte[] data = null;
    try {
      data = Files.readAllBytes(Paths.get(path + name));
    } catch (IOException ex) {
      Logger.getLogger(DiskManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return data == null ? new byte[0] : data;
  }
  
  public static String[] getRandomFileNames() {
    Files.list(path);
  }
  
  private static File createFile() {
    return new File(path + nameForFile());
  }
  
  private static String nameForFile() {
    return UUID.randomUUID().toString();
  }
  
}
