package Controller.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.NhanVienDao;
import model.Staff;

/**
 * Servlet implementation class ShowAccStaffController
 */
@WebServlet("/showaccstaff")
public class ShowAccStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NhanVienDao daonv; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAccStaffController() {
        super();
        // TODO Auto-generated constructor stub
        this.daonv = new NhanVienDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Staff> liststaff = new ArrayList<Staff>();
		liststaff = this.daonv.getall();
		if(liststaff != null) {
			request.setAttribute("lstStaff", liststaff);
			request.getRequestDispatcher("/views/Manager/QuanLyNhanVien.jsp").forward(request, response);
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
