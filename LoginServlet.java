import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet{
description="Login Servlet Testing",
urlPatterns={"/LoginServlet"},
initParams= {
		@WebInitParam(name="user",value="Sirisha"),
		@WebInitParam(name="password",value="Sirisha98"),
}
}
public class LoginServlet extends HttpServlet {
	@override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//get request for user id n pwd
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		//get servlet config init params
		String userID=getServletConfig().getInitParameter("user");
		String password=getServletConfig().getInitParameter("password");
		if(userID.equals(user)&&password.equals(password)) {
			reuest.setAttribute("user",user);
			request.getRequestDispatcher("LoginSucces.jsp").forward(request, response);
		}
		else {
			RequestDispatcher rd =getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out =response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}

}
