package doa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieSelect
 */
@WebServlet("/MovieSelect")
public class MovieSelect extends HttpServlet {
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
	public MovieSelect() {
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
		try {
			Connection con = MovieSelect.getConnection();
			String query = "select * from movie";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("retrieving");
				System.out.println(rs.getInt("id_no") + rs.getString("name")
						+ rs.getString("movie_name")
						+ rs.getString("mobile_no") + rs.getString("password"));
				/*
				 * System.out.println("id no is:" + rs.getInt("id_no") +
				 * "name is " + rs.getString("name") + "movie name is:" +
				 * rs.getString("movie_name") + "mobile number is" +
				 * rs.getInt("mobile_no") + "password is" +
				 * rs.getString("password"));
				 */
				PrintWriter w = response.getWriter();
				w.println(""+rs.getString("name"));
			w.println("<a href='LogoutServlet'>logout</a>");
				w.println("<table>");
				w.println("<table width=50% border=1>");
				w.println("<tr><td>" + rs.getInt("id_no") + "</td><td>"
						+ rs.getString("name") + "</td><td>"
						+ rs.getString("movie_name") + "</td><td>"
						+ rs.getString("movie_name") + "</td><td>"
						+ rs.getString("mobile_no") + "</td><td>"
						+ rs.getString("password"));
				w.println("<td>"
						+ "<form action='delete.html'><input type='submit' value='Delete'></form>"
						+ "</td>");
				w.println("<td>"
						+ "<form action='edit.html'><input type='submit' value='edit'></form>"
						+ "</td>");
				// w.println(rs.getInt("id_no") +
				// rs.getString("name")+rs.getString("movie_name")+rs.getString("mobile_no")+rs.getString("password"));*/
				w.println("</table>");
				
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
