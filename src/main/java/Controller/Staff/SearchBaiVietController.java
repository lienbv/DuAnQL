package Controller.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoTTBD;
import Dao.NhanVienDao;
import Dao.baiVietDao;
import model.BaiViet;
import model.Staff;


@WebServlet(urlPatterns = { "/seachercontroller" })
public class SearchBaiVietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private baiVietDao dao;
	private BaiViet bv;
	private NhanVienDao daonv;
	private List<BaiViet> lst;
	private Staff f;
	private DaoTTBD daottb;
	
    public SearchBaiVietController() {
    	this.dao = new baiVietDao();
		this.daonv = new NhanVienDao();
		this.bv = new BaiViet();
		this.daottb = new DaoTTBD();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html;charset=UTF-8");
	     request.setCharacterEncoding("UTF-8");
		
	    HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("acountST");
		lst = dao.findIDNV(staff);
	     
		String txtSearch=request.getParameter("txt");
		lst=dao.findNameNV(txtSearch,staff);

		request.setAttribute("listBV", lst);
		request.setAttribute("txtS", txtSearch);
		
		int in= daottb.count();
		request.setAttribute("sl", in);
		int ttdem= daottb.counttthd();
		request.setAttribute("tt", ttdem);
		
		request.getRequestDispatcher("views/Staff/QuanLyBaiVietStaff.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
