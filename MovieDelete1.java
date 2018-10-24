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
 * Servlet implementation class MovieDelete1
 */
@WebServlet("/MovieDelete1")
public class MovieDelete1 extends HttpServlet {
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
    public MovieDelete1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				try {
				Integer id = Integer.parseInt(request.getParameter("id_no"));
				Connection con = MovieDelete1.getConnection();
				String query = "delete from movie where id_no=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, id);
				int executeUpdate = ps.executeUpdate();
				System.out.println("......");

				System.out.println("deleted...");
				PrintWriter w = response.getWriter();
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

