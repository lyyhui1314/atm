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
		String path = "login.jsp"; // 跳转路径
		String id = request.getParameter("id"); // 接收id
		String password = request.getParameter("password"); // 接收密码
		List<String> info = new ArrayList<>(); // 保存返回信息

		if (info.size() == 0) {
			User user = new User(); // 实例化vo
			user.setId(id);
			user.setPassword(password);

			try {
				if (DAOFactory.getIUSerDAOInstance().findLogin(user)) {
					path = "index.jsp";
					HttpSession session = request.getSession();
					session.setAttribute("userNow", user);
				} else {
					if (DAOFactory.getIUSerDAOInstance().checkId(id)) {
						info.add("密码输入错误");
					} else {
						info.add("账号不存在！");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("info", info);
			request.getRequestDispatcher(path).forward(request, response); // 跳转
		}
	}
}
