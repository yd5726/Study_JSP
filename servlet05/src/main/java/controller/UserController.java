package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.UserAllCommand;
import command.UserCommand;
import command.UserInfoCommand;

@WebServlet("*.ju")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		uri = uri.substring(path.length());
		
		boolean redirect = false;
		String view ="";
		Command command = null;
		if(uri.equals("/user.ju")){
			UserCommand uc = new UserCommand();
			uc.execute(request, response);
			view = "user.jsp";
		}else if(uri.equals("/userAll.ju")) {
			command = new UserAllCommand();
			command.execute(request, response);
			view = "userAll.jsp";
		}else if(uri.equals("/user_info.ju")){
			command = new UserInfoCommand();
			command.execute(request, response);
			view = "user_info.jsp";
		}
		
		if(redirect){
			response.sendRedirect(view);
		}else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
