package hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HrDAO;
import dto.EmployeeDTO;

@WebServlet("/employee/emp_info")
public class EmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비지니스 로직 : 선택한 사원정보를 DB에서 조회해온다.
		HrDAO dao = new HrDAO();
		
		//DB에서 선택한 사원정보를 조회해오는 메소드 호출
		int id = Integer.parseInt(request.getParameter("id"));
		EmployeeDTO dto = dao.employee_info(id);
		
		//응답화면 연결
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<div><a href='../'>홈으로</a></div>");
		out.print("<div><a href='emp_list'>사원목록</a></div>");
		out.print("<hr>");
		out.print("<h2>사원정보</h2>");
		
		out.print("<table border='1'>");
		out.printf("<tr><th>사번</th><td>%d</td></tr>",dto.getEmployee_id());
		out.printf("<tr><th>사원명</th><td>%s</td></tr>",dto.getName());
		out.printf("<tr><th>이메일</th><td>%s</td></tr>",dto.getEmail());
		out.printf("<tr><th>부서코드</th><td>%d</td></tr>",dto.getDepartment_id());
		out.printf("<tr><th>업무코드</th><td>%s</td></tr>",dto.getJob_id());
		out.printf("<tr><th>급여</th><td>%d</td></tr>",dto.getSalary());
		out.printf("<tr><th>입사일자</th><td>%s</td></tr>",dto.getHire_date());
		out.print("<tr>");
		out.printf("<td><a href='emp_delete?id=%d'>삭제</a></td>",dto.getEmployee_id());
		out.printf("<td><a href='emp_alter?id=%d'>수정</a></td>",dto.getEmployee_id());
		out.print("</tr>");
		out.print("</table>");
		out.print("</table>");
		
		
		
		out.print("</body>");
		out.print("</html>");
	}

}
