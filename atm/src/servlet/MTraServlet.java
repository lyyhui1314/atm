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

@WebServlet("/MTraServlet")
public class MTraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MTraServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "mtram.jsp"; // 跳转路径
		String traname = ""; // 保存转账账户名
		String traid = request.getParameter("traid"); // 取得转账账户
		List<String> info = new ArrayList<>(); // 保存返回信息

		try {
			if (DAOFactory.getIUSerDAOInstance().checkId(traid)) {
				traname = DAOFactory.getIUSerDAOInstance().getTraname(traid);
				info.add("转账用户名：" + traname);
				request.getSession().setAttribute("traId", traid); // 将转账账户存入服务器
			} else {
				info.add("账户不存在!");
				path = "mtraid.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
