/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author PCU
 */
public class ReviewDisplay extends HttpServlet {
    
    private static String directoryName;
    
    public ReviewDisplay()
    {
        super();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReviewDisplay</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReviewDisplay at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        File file = new File("C:\\Users\\PCU\\Documents\\NetBeansProjects\\DarkPrime\\build\\web\\Reviews.html");
        Document doc = null;
        File folder = new File(directoryName);
        File[] files = folder.listFiles();
        
        try
        {
            doc = Jsoup.parse(file, null);
        }
        catch (IOException e)
            {
                String resultString = "Error loading page: " + e;
            }
        Element e = doc.select("form[name=reviewDisplay]").first();
        
        if(directoryName == null)
        {
            directoryName = getServletConfig().getInitParameter("reviewDirectory");
        }
        
        for(File f : files)
        {
            e.append(fileToString(f));
        }
        
    }
    
//    private static String readFile(File f) throws IOException
//    {
//        byte[] encoded = Files.readAllBytes(Paths.get(f.getAbsolutePath()));
//        return new String (encoded, StandardCharSet.utf8); 
//    }
    
    private static String fileToString(File file) throws IOException
    {
        //String str = "";
        
        BufferedReader buffer = new BufferedReader(new FileReader(file.getAbsolutePath()));
        StringBuffer sb = new StringBuffer();
        String line = null;
        
        while((line = buffer.readLine()) != null)
        {
            sb.append(line).append("\n");
        }
        
        return line;
//        BufferedReader buffer = new BufferedReader(new FileReader(file));
//        String s;// = buffer.readLine();
//        StringBuilder sb = new StringBuilder();
//        char[] buff = new char[1024];
//        int numRead = 0;
//
//        while((numRead = buffer.read(buff)) != -1)
//        {
//            s = String.valueOf(buff, 0, numRead);
//            sb.append(s);
//            buff = new char[1024];
//            //sb.append(s).append("</br >");
//            //s = buffer.readLine();
//        }
//        buffer.close();
//        //str = sb.toString();
//        
//        return sb.toString();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
