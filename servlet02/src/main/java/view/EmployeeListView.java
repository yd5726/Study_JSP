package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;

@WebServlet("/select")
public class EmployeeListView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//EmployeeSelect에서 //조회해온 데이터를 request에 담는다. -> list
		ArrayList<EmployeeDTO> list = (ArrayList<EmployeeDTO>) request.getAttribute("list");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>command 패턴 실습결과 - 조회</h2>");
		out.print("<div><a href='employee/new.html'>사원등록<a></div>");
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>사번</th>");
		out.print("<th>성명</th>");
		out.print("<th>부서코드</th>");
		out.print("<th></th>");
		out.print("</tr>");
		for(EmployeeDTO dto : list){
			out.print("<tr>");
			out.printf("<td>%d</td>",dto.getEmployee_id());
			out.printf("<td>%s</td>",dto.getName());
			out.printf("<td>%d</td>",dto.getDepartment_id());
			out.printf("<td><a href='delete.do?id=%d'>삭제<a></td>",dto.getEmployee_id());
			//?id=%d : 파라메타를 통해 값을 가져온다!!
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("<html>");
	}

}
