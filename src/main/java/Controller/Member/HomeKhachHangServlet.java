package Controller.Member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.baiVietDao;
import model.BaiViet;

@WebServlet("/HomeKhachHangServlet")
public class HomeKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private baiVietDao dao;
    
    public HomeKhachHangServlet() {
    	this.dao=new baiVietDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
			List<BaiViet> list=dao.getall();
			request.setAttribute("baiviet", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("views/assets/HomeKhachHang.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/HomeKhachHangServlet");
	}

}
