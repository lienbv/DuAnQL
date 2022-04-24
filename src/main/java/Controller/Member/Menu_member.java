package Controller.Member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoMenu;
import Dao.Daoloaimenu;
import model.LoaiMenu;
import model.Menu;

@WebServlet("/Menu")
public class Menu_member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoMenu menuDao;
	private Daoloaimenu daoloaimn;
	private List<LoaiMenu> lstloaimn;
	private List<Menu> lstmn;
	
	public Menu_member() {
		super();
		this.menuDao = new DaoMenu();
		this.daoloaimn=new Daoloaimenu();
		this.lstloaimn=new ArrayList<LoaiMenu>();
		this.lstmn=new ArrayList<Menu>();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.lstmn = this.menuDao.trangthaistaff(1);
		request.setAttribute("dsmonan", this.lstmn);
		this.lstloaimn = this.daoloaimn.getall();
		request.setAttribute("dsloaimn", this.lstloaimn);
		List<LoaiMenu> lstdrink=new ArrayList<LoaiMenu>();
		List<LoaiMenu> lstbuffet=new ArrayList<LoaiMenu>();
		List<LoaiMenu> lstdoan=new ArrayList<LoaiMenu>();
				for(LoaiMenu x: this.lstloaimn) {
					if(x.getLoai()==3) {
						lstdrink.add(x);
					}else if(x.getLoai()==2) {
						lstbuffet.add(x);
					}else {
						lstdoan.add(x);
					}
				}
				
				request.setAttribute("buffet", lstbuffet);
				request.setAttribute("doan", lstdoan);
				request.setAttribute("drink", lstdrink);
		RequestDispatcher dis = request.getRequestDispatcher("/views/assets/ThucDonKhachHang.jsp");
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}