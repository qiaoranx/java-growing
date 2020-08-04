package com.company.controller;

import com.company.model.AuthService;
import com.company.model.AuthServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveAuthServlet extends HttpServlet {
      AuthService authService=new AuthServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> authMap=new HashMap<>();
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(1024*4);
        String tempPath=this.getServletContext().getRealPath("/tmp");
        factory.setRepository(new File(tempPath));
        ServletFileUpload upload=new ServletFileUpload(factory);
        upload.setSizeMax(1024*1024*1024);
        String path=null;
        Boolean uploadSucc=true;
        try {
            List<FileItem> fileItems=upload.parseRequest(request);
            String orgcode=null;
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()){
                    String name=fileItem.getFieldName();
                    String value=fileItem.getString("utf-8");
                    authMap.put(name,value);
                    if("orgcode".equals(name)){
                          orgcode=value;
                    }
                }else{
                    String filename=fileItem.getName();
                    String newName=orgcode+filename.substring(filename.lastIndexOf("."));
                    authMap.put("filename",newName);
                     path= this.getServletContext().getRealPath("/authFile")+"/"+newName;
                    fileItem.write(new File(path));
                }
            }
        } catch (Exception e) {
            uploadSucc=false;
            e.printStackTrace();
        }
        if(uploadSucc){
           if(!authService.saveAuth(authMap)){
               File file=new File(path);
               file.delete();
           }else{
               request.getRequestDispatcher("auth/goAddAuth.jsp").forward(request,response);
           }
        }
    }
}
