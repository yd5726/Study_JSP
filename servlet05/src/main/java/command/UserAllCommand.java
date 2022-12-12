package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;

public class UserAllCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		UserDAO dao = new UserDAO();
		List<String> list = dao.select_name_all();
		List<UserDTO> user_list= dao.select_user_list();
		
		request.setAttribute("list", list);
		request.setAttribute("user_list", user_list);
	}

}
