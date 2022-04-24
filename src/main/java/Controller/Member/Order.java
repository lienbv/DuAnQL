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

import Dao.DaoCart;
import Dao.DaoMenu;
import Dao.DaoTTBD;
import model.GioHang;
import model.KhachHang;
import model.Menu;
import model.ThongTinBanDat;

@WebServlet({ "/Order", "/Order/chonmon", "/Order/datban", "/Order/delete" })
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Menu menu;
	private List<Menu> lstmn;
	private DaoMenu daomn;
	private DaoCart daocart;
	private List<GioHang> lstcart;
	private ArrayList<GioHang> dsgiohang;
	private ThongTinBanDat ttbd;
	private DaoTTBD daoTTBD;
	private KhachHang kh;

	public Order() {
		this.menu = new Menu();
		this.lstmn = new ArrayList<Menu>();
		this.daomn = new DaoMenu();
		this.daocart = new DaoCart();
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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		this.kh = (KhachHang) session.getAttribute("acountKH");
		int id = this.kh.getIdkh();
		this.lstmn = this.daomn.getall();
		this.ttbd = this.daoTTBD.findttbdbystatus(kh);
		this.lstcart = this.daocart.FindCartbyIDDB(this.ttbd);
		this.dsgiohang = (ArrayList<GioHang>) this.daocart.FindCartbyIDDB(this.ttbd);
		String url = request.getRequestURL().toString();
		request.setAttribute("listcart", this.lstcart);
		request.setAttribute("listmenu", this.lstmn);
		request.setAttribute("iduser", id);
		request.getRequestDispatcher("/views/assets/OrderMenuKhachHang.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		HttpSession session = request.getSession();
		this.kh = (KhachHang) session.getAttribute("acountKH");
		int id = this.kh.getIdkh();
		this.ttbd = this.daoTTBD.findttbdbystatus(kh);
		String ngay = (String) session.getAttribute("date_book");
		if (url.contains("datban")) {
			this.daocart.deletecartbyttbd(ttbd);
			lstcart = (List<GioHang>) session.getAttribute("gh");
			if(lstcart != null) {
				for (GioHang x : lstcart) {
					x.setIdgh(0);
					this.daocart.insert(x);
				}
			}
			response.sendRedirect(request.getContextPath() + "/Booking?date=" + ngay);
		} else if (url.contains("chonmon")) {
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
				this.dsgiohang.add(new GioHang(dsgiohang.size(), Integer.parseInt(request.getParameter("soluong")),
						this.menu, this.ttbd));
				session.setAttribute("gh", dsgiohang);
			}
			response.sendRedirect(request.getContextPath() + "/Order");
		} else if (url.contains("delete")) {
			int idcart = Integer.parseInt(request.getParameter("id"));
			dsgiohang = (ArrayList<GioHang>) session.getAttribute("gh");
			for (int i = 0; i < dsgiohang.size(); i++)
				if (dsgiohang.get(i).getIdgh() == idcart) {
					dsgiohang.remove(dsgiohang.get(i));
				}
			session.setAttribute("gd", dsgiohang);
			response.sendRedirect(request.getContextPath() + "/Order");
		}

	}
}
