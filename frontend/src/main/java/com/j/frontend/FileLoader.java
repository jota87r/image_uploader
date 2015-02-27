/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.frontend;

import com.j.backend.DiskManager;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonatan
 */
@WebServlet("/imageLoader/*")
public class FileLoader extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String img = request.getParameter("img");
    if (!Utilities.isNull(img)) serveImage(img, response);
  }
  
  private void serveImage(String img, HttpServletResponse response) throws IOException {
    response.setContentType("image");
    response.getOutputStream().write(DiskManager.read(img));
  }
}
