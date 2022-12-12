package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;

public class UserInfoCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.select_user_info(id);
		
		request.setAttribute("dto", dto);
	}

}
