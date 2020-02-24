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
import vo.User;

@WebServlet("/MTraNextServlet")
public class MTraNextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MTraNextServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(); // ʵ����vo
		String path = "mtram.jsp"; // ��ת·��
		String traid = (String) request.getSession().getAttribute("traId"); // ȡ��ת���˻�
		String tramo = request.getParameter("tramo");
		Object obj = request.getSession().getAttribute("userNow"); // ��ǰ�û�״̬
		List<String> info = new ArrayList<>(); // ���淵����Ϣ

		try {
			user = (User) obj;
			if (DAOFactory.getIUSerDAOInstance().traMoney(user, traid, Double.parseDouble(tramo))) {
				info.add("ת�˳ɹ���");
				request.getSession().setAttribute("traMoney", tramo);
			} else {
				info.add("����!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
