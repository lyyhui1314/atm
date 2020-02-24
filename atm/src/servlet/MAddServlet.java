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
		String path = "madd.jsp"; // 跳转路径
		String money = request.getParameter("money"); // 保存存款
		User user = new User(); // 实例化vo
		List<String> info = new ArrayList<>(); // 保存返回信息
		Object obj = request.getSession().getAttribute("userNow"); // 当前用户状态

		try {
			user = (User) obj;
			if (DAOFactory.getIUSerDAOInstance().addMoney(user, Double.parseDouble(money))) {
				info.add("存款成功！");

			} else {
				info.add("存款失败！");
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
