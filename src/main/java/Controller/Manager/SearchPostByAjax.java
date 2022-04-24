package Controller.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.baiVietDao;
import model.BaiViet;

/**
 * Servlet implementation class SearchPostByAjax
 */
@WebServlet("/SearchPostByAjax")
public class SearchPostByAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private baiVietDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchPostByAjax() {
		super();
		// TODO Auto-generated constructor stub
		this.dao = new baiVietDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("txt");
		List<BaiViet> list = new ArrayList<BaiViet>();
		list = this.dao.findName(name);
		if (list != null) {
			request.setAttribute("search", name);
			request.setAttribute("listbv", list);
			request.getRequestDispatcher("views/Manager/HomeManager.jsp").forward(request, response);
		}
	}

}
