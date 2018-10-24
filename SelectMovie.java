package doa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa2.verify;

/**
 * Servlet implementation class SelectMovie
 */
@WebServlet("/SelectMovie")
public class SelectMovie extends HttpServlet {
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
	public SelectMovie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			con = verify.getConnection();
			String query = "select name from movie where password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, password);
			// int executeUpdate = ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name1 = rs.getString("name");
				if (name.equals(name1)) {
					System.out.println("login");
									//rd.forward(request, response);
					System.out.println("redirecting.."+name);
				  	   Cookie ck=new Cookie("name",name);
	            	   response.addCookie(ck);
	            		 request.getRequestDispatcher("MovieSelect").include(request, response);

				} else {
					PrintWriter w = response.getWriter();
					w.println("invalid login");
                
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
