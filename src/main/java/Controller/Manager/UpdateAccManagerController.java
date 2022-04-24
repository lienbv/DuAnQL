package Controller.Manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.NhanVienDao;
import model.Staff;

/**
 * Servlet implementation class UpdateAccManagerController
 */
@WebServlet("/UpdateAccManager")
public class UpdateAccManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NhanVienDao daonv;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccManagerController() {
        super();
        // TODO Auto-generated constructor stub
        this.daonv = new NhanVienDao();
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
		int id = Integer.parseInt(request.getParameter("id"));
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cccd = request.getParameter("cccd");
		String sdt = request.getParameter("sodienthoai");
		String email = request.getParameter("email");
		String chucvu = request.getParameter("flexRadioRole");
		String img = request.getParameter("anhdaidien");
		
		this.editAccount(id, fullname, username, password, cccd, sdt, email, chucvu, img);
		response.sendRedirect(request.getContextPath() + "/showaccstaff?successUpdateAccManager=1");
		//response.sendRedirect("showaccstaff");
	}
	
	private void editAccount(int id, String fullname, String username, String password, String cccd, String sdt, String email, String chucvu, String img) {
		Staff st = new Staff();
		st.setIdnv(id);
		st.setHoTen(fullname);
		st.setUsername(username);
		st.setPassword(password);
		st.setCccd(cccd);
		st.setSdt(sdt);
		st.setEmail(email);
		st.setChucVu(chucvu);
		st.setImg(img);
		this.daonv.update(st);
	}

}
