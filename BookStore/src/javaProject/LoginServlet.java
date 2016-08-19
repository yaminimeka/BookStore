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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		
		String username= request.getParameter("username");
		
		String password= request.getParameter("password");
		String usertype= request.getParameter("usertype");
		
		HttpSession ss = request.getSession();
		 
		ss.setAttribute("username", username);
		ss.setAttribute(usertype, password);
		Connection con= null;
		if(usertype.equals("admin"))
		{
			if((username.equals("admin"))&&(password.equals("admin")))
					{
						HttpSession	session	=	request.getSession();
						session.setAttribute("userName", "admin");
						response.sendRedirect("/BookStore/Welcome.jsp");
					}
			else
			{
				response.sendRedirect("/BookStore/WrongPassword.jsp");
			}
		}
		else
		{
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","loginsystem",
					"password");
			Statement stmt= con.createStatement();
			int id = Integer.parseInt(username);
			String query = "select id,password from customerdetails where id = " +id+ "";
			System.out.println(query);
			//stmt.executeUpdate(query);
			String dbpassword= null;
			int userid = 0;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
			{
				userid= rs.getInt(1);
				dbpassword = rs.getString(2);
				System.out.println("entered resultset");
				if((userid == id) && (dbpassword.equals(password))){
					HttpSession	session	=	request.getSession();
					session.setAttribute("userid", id);
					request.getRequestDispatcher("/UserWelcome.jsp").forward(request, response);
				}
				else
				{
					response.sendRedirect("/BookStore/WrongPassword.jsp");
				}
				
			}
			
				//response.sendRedirect("/BookStore/WrongPassword.jsp");
			System.out.println("succesfully");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		
		}

	}

}
