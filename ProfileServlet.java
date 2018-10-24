package doa6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection getConnection() throws ClassNotFoundException,
	SQLException {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe", "system", "ajith");
System.out.println(con);
return con;
}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
           request.getRequestDispatcher("index.html").include(request, response);
           Cookie ck[]=request.getCookies();
           if(ck!=null){
        	   String name=ck[0].getValue();
        	   if(!name.equals("")||name!=null){
        		   System.out.println("<b>welcome to profile</b>");
        		   System.out.println("<br>welcome,"+name);
        	   }
           }else{
        	   System.out.println("please login first");
        	   request.getRequestDispatcher("loginn.html").include(request, response);
           }
	System.out.println();
	
	
	
	
	
	
	
	
	
	}

}
