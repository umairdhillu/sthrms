package com.soltechsystem.view.general;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Image", urlPatterns = { "/image" })
public class Image extends HttpServlet {
//    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    
    private static final String CONTENT_TYPE = "image/jpeg; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String fileName = request.getParameter("filename").toString();
        String imgType = request.getParameter("type").toString();
        String imgCat = request.getParameter("cat");
        String mimeType = request.getParameter("mimetype");
        
        String contentType = mimeType+"; charset=UTF-8";
        
        System.out.println(fileName+","+imgType+","+imgCat);
        
        String imageRoot = null;
        if (imgCat.equals("profile")){
            imageRoot = "C:\\work\\startup\\employee_images";
        }else if (imgCat.toUpperCase().equals("driving_license".toUpperCase())){
            imageRoot = "C:\\work\\startup\\employee_images\\DRIVING_LICENSE";
        }else if (imgCat.toUpperCase().equals("cnic".toUpperCase())){
            imageRoot = "C:\\work\\startup\\employee_images\\CNIC";
        }else if (imgCat.toUpperCase().equals("passport".toUpperCase())){
            imageRoot = "C:\\work\\startup\\employee_images\\PASSPORT";
        }else if(imgCat.equals("QUALIFICATION_CERTIFICATE")){
            imageRoot = "C:\\work\\startup\\employee_images\\qualification";
        }else if(imgCat.equals("APPLICANT_CV")){
            imageRoot = "C:\\work\\startup\\employee_images\\APPLICANT_CV";
        }
        //response.setContentType(mimeType+"; charset=UTF-8");
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();


        File file = new File(imageRoot+"\\"+fileName+"."+imgType); // linux
        System.out.println("displaying image: "+imageRoot+"\\"+fileName+"."+imgType);
        if (!file.exists()){
            file  = new File(imageRoot+"\\"+"noimage"+"."+"png");
        }

        if (file.exists()) {
            FileInputStream input = null;
            System.out.println("image exists");
            try {
                input = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(input);
                byte[] bytes = new byte[10240];
                while (bis.read(bytes, 0, 10240) != -1) {
                    out.write(bytes);
                }
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
                if (input != null) {
                    input.close();
                }

            }

        }
    }
}
