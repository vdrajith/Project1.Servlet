package doa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieUpdate
 */
@WebServlet("/MovieUpdate")
public class MovieUpdate extends HttpServlet {
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
	public MovieUpdate() {
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
			Integer id = Integer.parseInt(request.getParameter("id_no"));
			String mobile_no = request.getParameter("mobile_no");
			Connection con = MovieUpdate.getConnection();
			String query = "update movie set mobile_no=? where id_no=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, mobile_no);
            ps.setInt(2, id);
            int executeUpdate = ps.executeUpdate();
			System.out.println("updated");
			PrintWriter w = response.getWriter();
			w.println("updated");
			RequestDispatcher rd = request.getRequestDispatcher("Home1.html");
		    rd.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
