/* 
 * */
package javaProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewPurchasedBookServlet
 */
@WebServlet("/ViewPurchasedBookServlet")
public class ViewPurchasedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewPurchasedBookServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		ArrayList user = new ArrayList();
		int count = 0;
		int balance;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ArrayList childData = new ArrayList();
		ArrayList toatlCost = new ArrayList();

		String username = request.getSession().getAttribute("username")
				.toString();
		System.out.println(username);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("loaded driver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "loginsystem",
					"password");

			Statement stmt = con.createStatement();
			System.out.println("got connection");

			String sql = "SELECT unique ISBN, price,title  FROM purchasedetails WHERE id = "
					+ username + " ";
			// String purchasedQuery = "insert into purchasedetails values("
			// + username + "," + Integer.parseInt(booksIsbn[i])
			// + ",'" + title + "',1," + price + ",3," +sum+ )";
			// string totalsql = "SELECT SUM(cost) FROM purchasedetails;"
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println(sql);

			while (rs.next()) {

				user.add(rs.getString("isbn"));
				user.add(rs.getDouble("price"));
				user.add(rs.getString("title"));

			}

			if (user.size() > 0) {
				for (int i = 0; i < user.size(); i++) {
					String query = "Select count(*) FROM purchasedetails WHERE id = "
							+ username + "  and isbn	='" + user.get(i) + "'";
					System.out
							.println("Select count(*)  FROM purchasedetails WHERE id = "
									+ username
									+ "  and isbn	='"
									+ user.get(i)
									+ "'");
					ResultSet res = stmt.executeQuery(query);
					
					while (res.next()) {

						System.out.println("price"+user.get(i + 1));
						System.out.println("total"+((Double)(user.get(i + 1))* res.getInt(1)));
						childData.add(user.get(i));
						childData.add(user.get(i + 2));
						childData.add(res.getInt(1));
						childData.add(((Double)(user.get(i + 1))* res.getInt(1)));

					}
					;
					i = i + 2;

				}
				System.out.println(childData + "childdata");
				String totalsql = (" SELECT SUM(price)  FROM purchasedetails");
				ResultSet result = stmt.executeQuery(totalsql);

				while (result.next()) {

					childData.add(result.getString(1));
				}
				System.out.println(user);
				rs.close();
				con.commit();
				con.close();
			}
		} catch (ClassNotFoundException e1) {
			// JDBC driver class not found, print error message to the console
			e1.printStackTrace();
			System.out.println(e1.toString());
		}

		catch (SQLException e2) {
			// Exception when executing java.sql related commands, print error
			// message to the console
			e2.printStackTrace();
			System.out.println(e2.toString());
		} catch (Exception e3) {
			// other unexpected exception, print error message to the console
			e3.printStackTrace();
			System.out.println(e3.toString());
		}
		System.out.println(user);

		request.setAttribute("user", childData);

		request.getRequestDispatcher("/ViewMyBooks.jsp").forward(request,
				response);

	}

}
