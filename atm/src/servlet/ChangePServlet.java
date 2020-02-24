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

@WebServlet("/ChangePServlet")
public class ChangePServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "changep.jsp";
		String oldpass = request.getParameter("oldpass"); // 取得密码
		String newpass1 = request.getParameter("newpass1");
		String newpass2 = request.getParameter("newpass2");
		User user = new User(); // 实例化vo
		List<String> info = new ArrayList<>(); // 保存返回信息
		Object obj = request.getSession().getAttribute("userNow"); // 当前用户状态

		try {
			user = (User) obj;
			if (DAOFactory.getIUSerDAOInstance().getPass(user).equals(oldpass)) {
				if (!DAOFactory.getIUSerDAOInstance().getPass(user).equals(newpass1)) {
					if (newpass1.equals(newpass2)) {
						DAOFactory.getIUSerDAOInstance().setPass(user, newpass1);
						info.add("更改成功！");
					} else {
						info.add("两次新密码输入不一致！");
					}
				} else {
					info.add("新密码不得与旧密码相同！");
				}
			} else {
				info.add("密码输入错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}
}
