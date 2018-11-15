
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is my first servlet example.
 */
@WebServlet("/hello")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**  
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*response.setContentType("text/html");*/

		PrintWriter out = response.getWriter();
		out.println("<h1>" + "Users list" + "</h1>");
		ArrayList<UserBean> users = new ArrayList<>();
		UserDAO userDAO = new UserDAO();
		users = userDAO.getUsers();
		for(UserBean user : users)
		{	
			out.println("User id " + user.getId() + "<br/>");
			out.println("User firstName " + user.getFirstName() + "<br/>");
			out.println("User lastName " + user.getLastName() + "<br/>");
			out.println("User username " + user.getUsername() + "<br/>");
			out.println("User password " + user.getPassword() + "<br/>");
		}
		/*RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/mypage.html");
		rd.forward(request, response);*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
