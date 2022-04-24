package Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.baiVietDao;

@WebServlet("/DeleteBaiViet")
public class DeleteBaiViet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private baiVietDao dao;

	public DeleteBaiViet() {
		this.dao = new baiVietDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			this.dao.delete(id);
			response.sendRedirect(request.getContextPath() + "/HomeStaffController?id=" + id + "&&successDeletePost=1");
		} catch (Exception e) {
			e.printStackTrace();
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
