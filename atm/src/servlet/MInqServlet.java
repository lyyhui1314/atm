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

@WebServlet("/MInqServlet")
public class MInqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MInqServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Double money = 0.0; // 保存用户余额
		User user = new User(); // 实例化vo
		String path = "minq.jsp"; // 跳转路径
		Object obj = request.getSession().getAttribute("userNow"); // 当前用户状态
		List<String> info = new ArrayList<>(); // 保存返回信息
		try {
			user = (User) obj;
			money = DAOFactory.getIUSerDAOInstance().inqMoney(user);
			info.add(Double.toString(money));

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
