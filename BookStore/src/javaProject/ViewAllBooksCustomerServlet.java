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

/**
 * Servlet implementation class ViewAllBooksCustomerServlet
 */
@WebServlet("/ViewAllBooksCustomerServlet")
public class ViewAllBooksCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllBooksCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		ArrayList users = new ArrayList();
		int count=0;
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
		try {
		  		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  		  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","loginsystem",
							"password");
		
					Statement stmt= con.createStatement();
					

		  
		  
		  // Step 3. Create a Statement object and call its executeUpdate 
		  // method to insert a record
		 // Statement stmt = con.createStatement();


		  // Step 4. Use the same Statement object to obtain a ResultSet object
		  String sql = "SELECT title, ISBN, quantity, price FROM bookdetails where quantity>0";
		  ResultSet rs = stmt.executeQuery(sql);
		 
		  
		  while (rs.next()) {
			 
			 users.add(rs.getString("isbn"));
			users.add(rs.getString("title"));
			users.add(rs.getInt("quantity"));
			users.add(rs.getDouble("price"));
			
			
			
		  
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
		if(!request.getParameter("f").equals("1")){
			request.getRequestDispatcher("/ViewAllBooks.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/adminViewAllBooks.jsp").forward(request, response);
		}
	  //  RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	    //if (dispatcher != null){
	     //  dispatcher.forward(request, response);
	  //  }

	}

}
