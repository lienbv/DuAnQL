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
 * Servlet implementation class ShowBaiVietController
 */
@WebServlet("/HomeManager")
public class ShowBaiVietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private baiVietDao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBaiVietController() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new baiVietDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<BaiViet> list = new ArrayList<BaiViet>();
		list = this.dao.getall();
		if(list != null) {
			request.setAttribute("listbv", list);
			request.getRequestDispatcher("views/Manager/HomeManager.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
