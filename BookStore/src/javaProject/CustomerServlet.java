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
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
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
		
		
		String fname= request.getParameter("fname");
		System.out.println("My first servelet");
		String lname= request.getParameter("lname");
		String address= request.getParameter("address");
		String city= request.getParameter("city");
		String state= request.getParameter("state");
		String zip= request.getParameter("zip");
		String phoneno= request.getParameter("phoneno");
		//String dob= request.getParameter("dob");
		String password = request.getParameter("password");
		//PrintWriter obj= response.getWriter();
		//obj.write(g);
		
		Connection con=null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","loginsystem",
					"password");
			Statement stmt= con.createStatement();
			
			String abc="select count(*) from customerdetails where phoneno='"+phoneno+"'";
			System.out.println(abc);
			ResultSet r1 = stmt.executeQuery(abc);
			while(r1.next())
			{
				int count= r1.getInt(1);
				if(count==0)
				{
					String query = "insert into Customerdetails values (customers_seq.nextVal,'"+fname+"','"+lname+"','"+address+"','"+phoneno+"','"+password+"','"+city+"','"+state+"',"+zip+")";
					System.out.println(query);
					stmt.executeUpdate(query);
					System.out.println("succesfully");
				}
				else
				{
					request.getRequestDispatcher("/AlreadyRegistered.jsp").forward(request, response);

				/*	String a = "select phoneno from customerdetails where phoneno='"+phoneno+"' ";
					System.out.println(a);
					ResultSet r = stmt.executeQuery(a);
					String mobileno ="";
					while(r.next())
					{
						mobileno = r.getString(1);
						System.out.println(mobileno);
						if(phoneno.equals(mobileno))
						{
							request.getRequestDispatcher("/AlreadyRegistered.jsp").forward(request, response);

						}
						else
						{
							String query = "insert into Customerdetails values (customers_seq.nextVal,'"+fname+"','"+lname+"','"+address+"',"+phoneno+",'"+password+"')";
							System.out.println(query);
							stmt.executeUpdate(query);
							System.out.println("succesfully");
						}
					}*/

				}
			}
						
		
			
			
		
		
			String query2 = "select id from customerdetails where fname = '"+fname+"'";
			System.out.println(query2);
			ResultSet rs = stmt.executeQuery(query2);
			String value = null;
			if(rs.next())
			{
				value = ""+rs.getInt(1);
			}
			System.out.println(value);
			request.getSession().setAttribute("id", value);
			con.commit();
			con.close();
			request.getRequestDispatcher("/RegistrationSuccessful.jsp").forward(request, response);
			
			/*String query2 = "select id from customerdetails where fname = '"+fname+"'";
			System.out.println(query2);
			ResultSet rs = stmt.executeQuery(query2);
			String value = null;
			if(rs.next())
			{
				value = ""+rs.getInt(1);
			}*/
			//request.setAttribute(, query2);
			//request.setAttribute("id", value);
			
			//response.sendRedirect("http://localhost:8082/BookStore/RegistrationSuccessful.html");
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
