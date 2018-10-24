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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	               request.getRequestDispatcher("index.html").include(request, response);
	               String name=request.getParameter("name");
	               String password=request.getParameter("password");
	               if(password.equals("admin123")){
	            	   System.out.println("successfully login");
	            	   System.out.println("<br>welcome"+name);
	            	   Cookie ck=new Cookie("name",name);
	            	   response.addCookie(ck);
	            	   
	               }else{
	            	   System.out.println("sorry,username or password error!");
	            	   request.getRequestDispatcher("loginn.html").include(request, response);
	            	   
	            	   
	               }
	System.out.println();
	
	
	
	
	
	
	
	
	
	}

}
