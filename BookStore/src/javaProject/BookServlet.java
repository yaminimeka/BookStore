// This is a program written to insert the values of the books in the bookdetails table.


package javaProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
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
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String isbn= request.getParameter("isbn");
		System.out.println("My first servelet");
		String booktitle = request.getParameter("booktitle");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		//String dob= request.getParameter("dob");
		//String password = request.getParameter("password");
		//PrintWriter obj= response.getWriter();
		//obj.write(g);
		
		Connection con=null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","loginsystem",
					"password");
			Statement stmt= con.createStatement();
			//String query = "insert into bookdetails values ("+isbn+"','"+lname+"','"+address+"',"+phoneno+",'"+password+"')";
			//double price2 = Double.parseDouble("price");
            String query = "insert into bookdetails values ('"+isbn+"','"+booktitle+"',"+quantity+","+price+")";
			System.out.println(query);
			stmt.executeUpdate(query);
			System.out.println("succesfully");
		
			con.commit();
			con.close();
			//request.getRequestDispatcher("/RegistrationSuccessful.jsp").forward(request, response);
			response.sendRedirect("/BookStore/BookRegistrationSuccessful.jsp");
			//request.getRequestDispatcher("/BookRegistrationSuccessful.html").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Oracle
 catch (SQLException e) {
			// TODO Auto-generated catch block
	 int errorCode = e.getErrorCode();
	 System.out.println("error"+errorCode);
	 if(errorCode==1)
	 {
		 response.sendRedirect("/BookStore/UniqueIsbn.jsp");
	 }
			e.printStackTrace();
		}
		//response.sendRedirect("/BookStore/UniqueIsbn.jsp");
	}

}
