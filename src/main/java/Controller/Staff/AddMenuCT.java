package Controller.Staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoBanDatCT;
import Dao.DaoHDCT;
import Dao.DaoHoadon;
import Dao.DaoMenu;
import Dao.DaoMenuCT;
import model.Bdct;
import model.Hdct;
import model.HoaDon;
import model.Menu;
import model.Mnct;

/**
 * thï¿½m thï¿½ng bï¿½o thï¿½nh cï¿½ng
 * xóa cái này nhé các bạn ơi
 */
@WebServlet("/AddMenuCT")
public class AddMenuCT extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Bdct bdct;
	    private DaoBanDatCT daobdct;
	    private DaoMenu daomenu;
	    private Menu menu;
	    private Mnct mnct;
	    private HoaDon hd;
	    private DaoHoadon daohd;
		private DaoMenuCT daomnct;
		private Hdct hdtc;
		private DaoHDCT daohdct;
    public AddMenuCT() {
    	 this.bdct= new Bdct();
		 this.daobdct= new DaoBanDatCT();
		 this.daomenu= new DaoMenu();
		 this.menu= new Menu();
		 this.mnct= new Mnct();
		 this.bdct= new Bdct();
		 this.daomnct= new DaoMenuCT();
		 this.hdtc=new Hdct();
		 this.daohdct=new DaoHDCT();
		 this.daohd=new DaoHoadon();
		 this.hd=new HoaDon();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idmenu= Integer.parseInt(request.getParameter("idmn"));
		this.menu= daomenu.findbyid(idmenu);
		int id = Integer.parseInt(request.getParameter("id").trim());
		this.bdct = this.daobdct.findbyid(id);
		int sl= Integer.parseInt(request.getParameter("so_luong"));
		int idhd= Integer.parseInt(request.getParameter("idhd"));
		this.hd= this.daohd.findbyid(idhd);
		
		//insert menuct
		mnct.setBdct(bdct);
		mnct.setMenu(menu);
		mnct.setSo_luong(sl);
		daomnct.insert(mnct);

		//insert hdct
		Mnct m = this.daomnct.findmnctbybdct(bdct);
		this.hdtc.setMnct(m);
		this.hdtc.setSo_luong(0);
		this.hdtc.setThanh_Tien(0);
		this.hdtc.setHoaDon(hd);
		this.daohdct.insert(this.hdtc);
		
		response.sendRedirect(request.getContextPath() + "/AddMenuCTController?id=" + id+"&&idhd="+idhd+"&&success=1 ");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
