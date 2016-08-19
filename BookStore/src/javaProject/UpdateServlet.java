package javaProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("i am here");
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		Long isbn =Long.parseLong(request.getParameter("isbn"));
		String price =request.getParameter("price");
		String	title	=	request.getParameter("title");
		System.out.println(quantity+"" +isbn+""+ price);
		Connection con = null;
				
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","loginsystem","password");
			Statement stmt=con.createStatement();
			String query = "UPDATE bookdetails SET quantity= "+quantity+", price = "+price+", title = '"+title+"' where isbn='"+isbn+"'";
			System.out.println(query);
			int i = stmt.executeUpdate(query);
			System.out.println("The I value is " +i);
			con.close();
			//request.getRequestDispatcher("/RegistrationSuccessful.jsp").forward(request, response);
			response.sendRedirect("/BookStore/UpdateSuccesfull.jsp");
			//request.getRequestDispatcher("/BookRegistrationSuccessful.html").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Oracle
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
