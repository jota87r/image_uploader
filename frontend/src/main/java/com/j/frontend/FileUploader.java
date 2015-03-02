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
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author jonatan
 */
@ManagedBean
@SessionScoped
public class FileUploader {
  
  private UploadedFile file;
  private String accessToken;

  public void upload() {
    if (file != null && file.getSize() > 0) uploadImpl();
  }
  
  private void uploadImpl() {
    try {
      DiskManager.write(file.getInputstream());
      file = null;
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
  
  public UploadedFile getFile() {
    return file;
  }

  public void setFile(UploadedFile file) {
    this.file = file;
  }
  
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
  
  
}
