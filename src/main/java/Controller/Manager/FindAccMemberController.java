package Controller.Manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daouser;
import model.KhachHang;
import model.Staff;

/**
 * Servlet implementation class FindAccMemberController
 */
@WebServlet("/FindAccMember")
public class FindAccMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Daouser dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAccMemberController() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new Daouser();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("txt");
		List<KhachHang> list = this.dao.findMemberByAjax(name);
		request.setAttribute("lstMem", list);
		request.setAttribute("search", name);
		request.getRequestDispatcher("views/Manager/QuanLyKhachHang.jsp").forward(request, response);
	}

}
