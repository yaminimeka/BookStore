// This is a program written to update the books 
//quantity after purchasing them with the credit card details.

package javaProject;

import java.io.IOException;
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
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseServlet() {
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
	
		String[] booksIsbn = request.getParameterValues("book");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "loginsystem",
					"password");
			Statement st = con.createStatement();
			ResultSet rs = null;
			String title = null;
			double price = 0;
			System.out.println("I am in post");
			for (int i = 0; i < booksIsbn.length; i++) {
				rs = st.executeQuery("select * from bookdetails where isbn = '"
						+ booksIsbn[i] + "'");
				while (rs.next()) {
					title = rs.getString("TITLE");
					price = rs.getDouble("PRICE");
				}

				int username = Integer.parseInt(request.getSession()
						.getAttribute("username").toString());
				
				String purchaseQuery = "insert into purchasedetails values("
						+ username + ",'" + booksIsbn[i]
						+ "','" + title + "',1," + price + ")";
				System.out.println(purchaseQuery);
				
				System.out.println("select quantity from bookdetails where isbn='"
						+ booksIsbn[i] + "'");
				System.out.println("after sysout");
				st.executeUpdate(purchaseQuery);
				System.out.println("after update");
				String query = "select quantity from bookdetails where isbn='"
						+ booksIsbn[i] + "'";
				int quantity = 0;
				ResultSet res = st.executeQuery(query);
				while (res.next()) {
					System.out.println("res.getInt(1)"+res.getInt(1));
					quantity = res.getInt(1) - 1;
					
				}
				System.out.println("update bookdetails set quantity=" + quantity +" where isbn = '"+ booksIsbn[i]+"'");
				st.executeUpdate("update bookdetails set quantity=" + quantity +" where isbn = '"+ booksIsbn[i]+"'");
				System.out.println(purchaseQuery);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// request.getRequestDispatcher("/ViewPurchasedBookServlet").forward(request,
		// response);
		request.getRequestDispatcher("/Payment.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am in post");

		
		
	}

}
