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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewUsersServlet
 */
@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUsersServlet() {
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
		  		  System.out.println("loaded driver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","loginsystem",
							"password");
		
					Statement stmt= con.createStatement();
					/*String query = "insert into bookdetails values ("+isbn+"','"+lname+"','"+address+"',"+phoneno+",'"+dob+"','"+password+"')";
		            String query = "insert into bookdetails values ("+isbn+",'"+booktitle+"',"+quantity+","+price+")";
		            System.out.println(query);
					stmt.executeUpdate(query);
					System.out.println("succesfully");*/
				
					

		  System.out.println("got connection");

		  
		  // Step 3. Create a Statement object and call its executeUpdate 
		  // method to insert a record
		 // Statement stmt = con.createStatement();


		  // Step 4. Use the same Statement object to obtain a ResultSet object
		  String sql = "SELECT ID, Fname, Lname FROM customerdetails";
		  ResultSet rs = stmt.executeQuery(sql);
		 
		  
		  System.out.println(sql);
		  
/*		 while(rs.next()){
			 count++;
			 System.out.println(rs);
		 }*/
		  while (rs.next()) {
			 
			users.add(rs.getInt("id"));
			users.add(rs.getString("fname"));
			users.add(rs.getString("lname"));
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
		
		request.getRequestDispatcher("/ViewAllUsers.jsp").forward(request, response);
	  //  RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	    //if (dispatcher != null){
	     //  dispatcher.forward(request, response);
	  //  }
	
	
	
	
	}

}
