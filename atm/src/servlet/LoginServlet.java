package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.DAOFactory;
import vo.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "login.jsp"; // ��ת·��
		String id = request.getParameter("id"); // ����id
		String password = request.getParameter("password"); // ��������
		List<String> info = new ArrayList<>(); // ���淵����Ϣ

		if (info.size() == 0) {
			User user = new User(); // ʵ����vo
			user.setId(id);
			user.setPassword(password);

			try {
				if (DAOFactory.getIUSerDAOInstance().findLogin(user)) {
					path = "index.jsp";
					HttpSession session = request.getSession();
					session.setAttribute("userNow", user);
				} else {
					if (DAOFactory.getIUSerDAOInstance().checkId(id)) {
						info.add("�����������");
					} else {
						info.add("�˺Ų����ڣ�");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("info", info);
			request.getRequestDispatcher(path).forward(request, response); // ��ת
		}
	}
}
