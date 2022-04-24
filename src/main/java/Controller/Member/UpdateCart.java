package Controller.Member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.DaoMenu;
import Dao.DaoTTBD;
import model.GioHang;
import model.KhachHang;
import model.Menu;
import model.ThongTinBanDat;

/**
 * Servlet implementation class UpdateCart
 */
@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Menu menu;
	private DaoMenu daomn;
	private List<GioHang> lstcart;
	private ArrayList<GioHang> dsgiohang;
	private ThongTinBanDat ttbd;
	private DaoTTBD daoTTBD;
	private KhachHang kh;

	public UpdateCart() {
		this.menu = new Menu();
		this.daomn = new DaoMenu();
		this.lstcart = new ArrayList<GioHang>();
		this.ttbd = new ThongTinBanDat();
		this.daoTTBD = new DaoTTBD();
		this.dsgiohang = new ArrayList<GioHang>();
		this.kh = new KhachHang();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		this.kh = (KhachHang) session.getAttribute("acountKH");
		int index = Integer.parseInt(request.getParameter("idbd"));
		this.ttbd = this.daoTTBD.findbyid(index);
		session.setAttribute("user", this.lstcart);
		this.ttbd = this.daoTTBD.findttbdbystatus(kh);
		int idmenu = Integer.parseInt(request.getParameter("idmn"));
		this.menu = this.daomn.findbyid(idmenu);
		Object object = session.getAttribute("gh");
		if (object == null) {
			dsgiohang.add(new GioHang(0, Integer.parseInt(request.getParameter("soluong")), this.menu, this.ttbd));

			session.setAttribute("gh", dsgiohang);
		} else {
			dsgiohang = (ArrayList<GioHang>) session.getAttribute("gh");
			this.dsgiohang.add(new GioHang(dsgiohang.size(), Integer.parseInt(request.getParameter("soluong")), this.menu, this.ttbd));
			session.setAttribute("gh", dsgiohang);
		}
		response.sendRedirect(request.getContextPath() + "/CheckoutOrder");
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
