package doa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieInsert
 */
@WebServlet("/MovieInsert")
public class MovieInsert extends HttpServlet {
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
    public MovieInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    try {
						Connection con=MovieInsert.getConnection();
						String query="insert into Movie values(9,'aji','ayan','9444604278','ajitha')";
						PreparedStatement ps = con.prepareStatement(query);
						int executeUpdate = ps.executeUpdate();
						System.out.println("inserted");
						PrintWriter w = response.getWriter();
						w.println("inserted");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
	
	
	
	}

}
