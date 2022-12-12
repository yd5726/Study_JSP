package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.ProductAllCommand;
import command.ProductInfoCommand;

@WebServlet("*.pc")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		uri = uri.substring(path.length());
		
		boolean redirect = false;
		String view ="";
		Command command = null;
		if(uri.equals("/productAll.pc")) {
			command = new ProductAllCommand();
			command.execute(request, response);
			view="productAll.jsp";
		}else if(uri.equals("/product_info.pc")) {
			command = new ProductInfoCommand(); 
			command.execute(request, response);
			view="product_info.jsp";
		}
		
		if(redirect){
			response.sendRedirect(view);
		}else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
