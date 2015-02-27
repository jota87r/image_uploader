/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.frontend;

import com.j.backend.DiskManager;
import com.j.backend.MinorException;
import com.j.backend.SevereException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author jonatan
 */
@ManagedBean
public class FileUploader {
  
  private UploadedFile file;

  public void upload() {
    try {
      DiskManager.write(file.getInputstream());
      MessageManager.setMessage("Great!", "Your photo has been uploaded");
    } catch (IOException | SevereException | NullPointerException ex) {
      MessageManager.setMessage("Oops!", "Try again...");
    } catch (MinorException ex) {
      MessageManager.setMessage("Great!", "Your photo has been uploaded");
    }
  }
  
  public List<Object> getImages() {
    return Arrays.asList(DiskManager.getRandomFileNames());
  }
  
  public byte[] getImage(String name) {
    return DiskManager.read(name);
  }
  
  public UploadedFile getFile() {
    return file;
  }

  public void setFile(UploadedFile file) {
    this.file = file;
  }
  
  
}
