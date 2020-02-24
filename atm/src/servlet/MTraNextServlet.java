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
		User user = new User(); // 实例化vo
		String path = "mtram.jsp"; // 跳转路径
		String traid = (String) request.getSession().getAttribute("traId"); // 取得转账账户
		String tramo = request.getParameter("tramo");
		Object obj = request.getSession().getAttribute("userNow"); // 当前用户状态
		List<String> info = new ArrayList<>(); // 保存返回信息

		try {
			user = (User) obj;
			if (DAOFactory.getIUSerDAOInstance().traMoney(user, traid, Double.parseDouble(tramo))) {
				info.add("转账成功！");
				request.getSession().setAttribute("traMoney", tramo);
			} else {
				info.add("余额不足!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
