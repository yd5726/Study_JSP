package customer.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;
import customer.CustomerDTO;

public class CustomerList implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		// DB에서 전체 고객 목록을 조회해온다.
		CustomerDAO dao = new CustomerDAO();
		List<CustomerDTO> list = dao.customer_list();
		
		// 화면에서 출력할 수 있도록 request에 attribute로 담는다.
		request.setAttribute("list", list);
		
		// 카테고리에 따른 사이드바 선택 - setAttribute 첫 생성 : 고객관리
		request.setAttribute("category", "cu");
		// 카테고리에 따른 사이드바 선택 - 세션 이동
		request.getSession().setAttribute("category", "cu");
	}

}
