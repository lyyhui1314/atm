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

@WebServlet("/MAddServlet")
public class MAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "madd.jsp"; // ��ת·��
		String money = request.getParameter("money"); // ������
		User user = new User(); // ʵ����vo
		List<String> info = new ArrayList<>(); // ���淵����Ϣ
		Object obj = request.getSession().getAttribute("userNow"); // ��ǰ�û�״̬

		try {
			user = (User) obj;
			if (DAOFactory.getIUSerDAOInstance().addMoney(user, Double.parseDouble(money))) {
				info.add("���ɹ���");

			} else {
				info.add("���ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
