/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PCU
 */
public class ReviewClass extends HttpServlet {
    
    private static final long serialVersionUID = 1l;
    private static String directoryName;
    
    public ReviewClass()
    {
        super();
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
            throws ServletException, IOException
    {
        //String name = "test";
        //String comment = "Testy McTest test.";
        
        String name = request.getParameter("name");
        String comment = request.getParameter("comments");
        String resultString = "Unable to submit comment";
        
        response.setContentType("text/html;charset=UTF-8");
        
        if(directoryName == null)
        {
            directoryName = getServletConfig().getInitParameter("directory");
        }
        
        if((name != null && name.length() > 0) && (comment != null && comment.length() > 0))
        {
            response.setContentType("text/html;charset=UTF-8");
            
            File directory = new File(directoryName);
            String fullFileName = directoryName + File.separator + name + "Review.txt";
            File newFile = new File(fullFileName);
            
            try (PrintWriter output = new PrintWriter(new FileWriter(newFile)))
            {
                output.println(name);
                output.println(comment);
                output.close();
                
                try (PrintWriter out = response.getWriter())
                {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Thank You</title>");
                    out.println("<link rel=\"stylesheet\" href=\"/Stylesheets/Index.css\">");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<img src=\"/Images/Dark Prime Header.jpg\" alt=\"Dark Prime Consignment\">");
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
                    out.println("<td><a href='Reviews.html'>Reviews</a></td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("<div class='mainBody' align='center'><br><h2>Thanks for leaving a review!<br>Your input is welcome and helps us improve!</h2>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
            
            catch(Exception e)
            {
                resultString = "Error submitting comment: " + e;
            }
        }
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
        
        out.println(docType);
            
    }
/*
    protected void buildReplyPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
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
            out.println("<td><a href='Reviews.html'>Reviews</a></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<div class='mainBody'>Thanks for leaving a review! Your input is welcome and helps us improve!");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/
    
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
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "A simple file to process testimonies submitted through the review form.";
    }// </editor-fold>

}
