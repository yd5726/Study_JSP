package employee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.HrDAO;

public class EmployeeDelete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파마메타를 통해 값을 가져온다!!
		int emp_num = Integer.parseInt(request.getParameter("id"));
		
		// 2. 수집한 정보를 DB저장 : DB연결 -> 저장처리메소드 호출
		HrDAO dao = new HrDAO();
		dao.employee_delete(emp_num);
	}

}
