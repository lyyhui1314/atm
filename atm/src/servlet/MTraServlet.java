package servlet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import factory.DAOFactory;

@WebServlet("/MTraServlet")
public class MTraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MTraServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "mtram.jsp"; // ��ת·��
		String traname = ""; // ����ת���˻���
		String traid = request.getParameter("traid"); // ȡ��ת���˻�
		List<String> info = new ArrayList<>(); // ���淵����Ϣ

		try {
			if (DAOFactory.getIUSerDAOInstance().checkId(traid)) {
				traname = DAOFactory.getIUSerDAOInstance().getTraname(traid);
				info.add("ת���û�����" + traname);
				request.getSession().setAttribute("traId", traid); // ��ת���˻����������
			} else {
				info.add("�˻�������!");
				path = "mtraid.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
