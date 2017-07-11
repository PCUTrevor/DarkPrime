/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PCU
 */
@WebServlet(urlPatterns = {"/ReviewForm"})
public class ReviewForm extends HttpServlet {

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
        
        File directory = new File("./Testimonies");
        File[] files = directory.listFiles();
        
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Dark Prime Consignment</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"stylesheet\" href=\"Stylesheets/Index.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<img src=\"Images/Dark Prime Header.jpg\" alt=\"Dark Prime Name\">");
            out.println("<div class=\"headInfo\">5800 South 1900 West Roy, Utah<br>Tues - Sat 1-7<br>Sun - Mon By appointment only");
            out.println("<br>Follow us:");
            out.println("<a href='www.facebook.com/darkprimeconsignment'>Facebook Image</a>");
            out.println("</div>");
        
            out.println("<table align='center'>");
            out.println("<tr>");
            out.println("<td><a href='index.html'>Home</a></td>");
            out.println("<td><a href='About.html'>About</a></td>");
            out.println("<td><a href='Contact.html'>Contact us</a></td>");
            out.println("<td><a href='Vendors.html'>Vendors</a></td>");
            out.println("<td>Reviews</td>");
            out.println("</tr>");
            out.println("</table>");
        
            out.println("<div class='mainBody'>Go ahead! Leave a review, it helps us all!");
            out.println("<div class=\"reviewDis\">Here's what people are saying about Dark Prime!");
            out.println("<form name=\"reviewDisplay\">");
            out.println("<br />");
            
            for(File f : files)
            {
                out.println(fileToString(f));
                out.println("<br />");
                out.println("-------------------------------------------<br />");
            }
            
            out.println("</form>");
            out.println("</div>");
            
            out.println("<div class=\"review\">");
            out.println("<form action=\"ReviewClass\" method=\"POST\" name=\"reviewForm\" class=\"sub\">");
            out.println("<input type=\"text\" name=\"name\" placeholder=\"Name\"><br><br>");
            out.println("<textarea name=\"comments\" rows=\"5\" cols=\"40\">Please write your comments here.</textarea><br><br>");
            out.println("<input type=\"submit\" value=\"Submit Comment\">");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }
    
    private static String fileToString(File file) throws IOException
    {
        //String str = "";
        
        BufferedReader buffer = new BufferedReader(new FileReader(file.getAbsolutePath()));
        StringBuilder sb = new StringBuilder();
        String line;
        
        while((line = buffer.readLine()) != null)
        {
            sb.append(line).append("<br />");
        }
        
        return sb.toString();//line;
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
