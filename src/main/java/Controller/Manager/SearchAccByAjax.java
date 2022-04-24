package Controller.Manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.NhanVienDao;
import model.Staff;

/**
 * Servlet implementation class SearchAccByAjax
 */
@WebServlet("/SearchAccByAjax")
public class SearchAccByAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NhanVienDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchAccByAjax() {
		super();
		// TODO Auto-generated constructor stub
		this.dao = new NhanVienDao();
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
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("txt");
		List<Staff> list = this.dao.findStaffByAjax(name);
		request.setAttribute("lstStaff", list);
		request.setAttribute("search", name);
		request.getRequestDispatcher("views/Manager/QuanLyNhanVien.jsp").forward(request, response);
	}

}
