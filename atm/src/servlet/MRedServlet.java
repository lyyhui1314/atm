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

@WebServlet("/MRedServlet")
public class MRedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MRedServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(); // ʵ����vo
		String path = "mred.jsp"; // ��ת·��
		Object obj = request.getSession().getAttribute("userNow"); // ��ǰ�û�״̬
		List<String> info = new ArrayList<>(); // ���淵����Ϣ
		String money = request.getParameter("money");
		if (money == "")
			money = request.getParameter("act");
		try {
			user = (User) obj;
			if (DAOFactory.getIUSerDAOInstance().redMoney(user, Double.parseDouble(money))) {
				info.add("ȡ��ɹ���");
			} else {
				info.add("���㣡");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
