package javaProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FetchBookDetails
 */
@WebServlet("/FetchBookDetails")
public class FetchBookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchBookDetails() {
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
		Connection con = null;
		ArrayList users = new ArrayList();
		int count=0;
		String bookid="";
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String isbn= request.getParameter("isbn");
	    
		try {
		  		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  		  System.out.println("loaded driver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","loginsystem",
							"password");
		
					Statement stmt= con.createStatement();
					
					

		  System.out.println("got connection");

		
		 
		String sql = "SELECT isbn, title, quantity, price FROM bookdetails where isbn = '"+isbn+"'";
		  ResultSet rs = stmt.executeQuery(sql);
		 
		  
		  System.out.println(sql);
		  
/*		 while(rs.next()){
			 count++;
			 System.out.println(rs);
		 }*/
		  while (rs.next()) {
			 
	 bookid=rs.getString("isbn");
	 users.add(rs.getString("isbn"));
			users.add(rs.getString("title"));
			users.add(rs.getInt("quantity"));
			users.add(rs.getInt("price"));
			System.out.println(users);
			
			
			
		  
		  }
		  rs.close(); 
		  con.commit();
			con.close();
		}
		catch (ClassNotFoundException e1) {
		  // JDBC driver class not found, print error message to the console
		  System.out.println(e1.toString());
		}
		
		catch (SQLException e2) {
		  // Exception when executing java.sql related commands, print error message to the console
		  System.out.println(e2.toString());
		}
		catch (Exception e3) {
		  // other unexpected exception, print error message to the console
		  System.out.println(e3.toString());
		}
		request.setAttribute("user",users);
		
		if(isbn.equals(bookid)){
			
			request.getRequestDispatcher("/FetchBookDetails.jsp").forward(request, response);
		}
		else
		{
			response.sendRedirect("/BookStore/WrongIsbn.jsp");
		}
		
		
	  //  RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	    //if (dispatcher != null){
	     //  dispatcher.forward(request, response);
	  //  }
	
	
	}

}
