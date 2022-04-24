package Controller.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoMenu;
import Dao.DaoTTBD;
import Dao.Daoloaimenu;
import model.LoaiMenu;
import model.Menu;

/**
 * Servlet implementation class ViewMenuStaff
 */
@WebServlet("/ViewMenuStaff")
public class ViewMenuStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoMenu menuDao;
	private Daoloaimenu daoloaimn;
	private List<LoaiMenu> lstloaimn;
	private List<Menu> lstmn;
	private DaoTTBD daottb;

	public ViewMenuStaff() {

		this.menuDao = new DaoMenu();
		this.daoloaimn = new Daoloaimenu();
		this.lstloaimn = new ArrayList<LoaiMenu>();
		this.lstmn = new ArrayList<Menu>();
		this.daottb = new DaoTTBD();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.lstmn = this.menuDao.getall();
		request.setAttribute("menu", this.lstmn);
		this.lstloaimn = this.daoloaimn.getall();

		List<LoaiMenu> lstdrink = new ArrayList<LoaiMenu>();
		List<LoaiMenu> lstbuffet = new ArrayList<LoaiMenu>();
		List<LoaiMenu> lsthaisan = new ArrayList<LoaiMenu>();
		for (LoaiMenu x : this.lstloaimn) {
			if (x.getLoai() == 1) {
				lstbuffet.add(x);
			} else if (x.getLoai() == 2) {
				lsthaisan.add(x);
			} else {
				lstdrink.add(x);
			}
		}
		int in= daottb.count();
		request.setAttribute("sl", in);
		int ttdem= daottb.counttthd();
		request.setAttribute("tt", ttdem);

		request.setAttribute("buffet", lstbuffet);
		request.setAttribute("douong", lstdrink);
		request.setAttribute("haisan", lsthaisan);

		request.getRequestDispatcher("/views/Staff/ViewMenuStaff.jsp").forward(request, response);

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
