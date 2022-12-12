package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductInfoCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = dao.select_product_info(num);
		
		request.setAttribute("dto", dto);
	}

}
