package Controller.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daouser;
import model.KhachHang;

/**
 * Servlet implementation class ShowInfoMember
 */
@WebServlet("/ShowInfoMember")
public class ShowInfoMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Daouser daouser;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowInfoMember() {
        super();
        // TODO Auto-generated constructor stub
        this.daouser = new Daouser();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<KhachHang> list = new ArrayList<KhachHang>();
		list = this.daouser.getall(); 
		if(list != null) {
			request.setAttribute("lstMem", list);
			request.getRequestDispatcher("/views/Manager/QuanLyKhachHang.jsp").forward(request, response);
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
