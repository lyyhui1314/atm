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
		User user = new User(); // 实例化vo
		String path = "mred.jsp"; // 跳转路径
		Object obj = request.getSession().getAttribute("userNow"); // 当前用户状态
		List<String> info = new ArrayList<>(); // 保存返回信息
		String money = request.getParameter("money");
		if (money == "")
			money = request.getParameter("act");
		try {
			user = (User) obj;
			if (DAOFactory.getIUSerDAOInstance().redMoney(user, Double.parseDouble(money))) {
				info.add("取款成功！");
			} else {
				info.add("余额不足！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
