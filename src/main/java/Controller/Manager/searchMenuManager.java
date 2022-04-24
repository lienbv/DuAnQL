package Controller.Manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoMenu;
import model.Menu;

/**
 * Servlet implementation class searchMenuManager
 */
@WebServlet("/searchMenuManager")
public class searchMenuManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Menu> lst;
	private DaoMenu daomenu;

	public searchMenuManager() {
		daomenu = new DaoMenu();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String txtSearch = request.getParameter("txt");
		lst = daomenu.findName(txtSearch);
		if(lst!=null) {
			request.setAttribute("listmenu", lst);
			System.out.println(lst);
			request.setAttribute("txtS", txtSearch);
			request.getRequestDispatcher("/views/Manager/QuanLyThucDon.jsp").forward(request, response);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
