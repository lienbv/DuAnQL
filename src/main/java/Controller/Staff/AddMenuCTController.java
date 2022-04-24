package Controller.Staff;

import java.io.IOException;
import java.util.List;

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
import Dao.DaoTTBD;
import Dao.Daoloaimenu;
import model.Bdct;
import model.Hdct;
import model.HoaDon;
import model.LoaiMenu;
import model.Menu;
import model.Mnct;


@WebServlet({"/AddMenuCTController","/AddMenuCTController/createe"})
public class AddMenuCTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Bdct bdct;
    private DaoBanDatCT daobdct;
    private DaoMenu daomenu;
    private Menu menu;
    private Mnct mnct;
    private HoaDon hd;
    private DaoHoadon daohd;
	private DaoMenuCT daomnct;
	private Daoloaimenu daoloai;
	private Hdct hdtc;
	private DaoHDCT daohdct;
	private DaoTTBD daottb;
    public AddMenuCTController() {
		 this.bdct= new Bdct();
		 this.daobdct= new DaoBanDatCT();
		 this.daomenu= new DaoMenu();
		 this.menu= new Menu();
		 this.mnct= new Mnct();
		 this.bdct= new Bdct();
		 this.daomnct= new DaoMenuCT();
		 this.daoloai= new Daoloaimenu();
		 this.hdtc=new Hdct();
		 this.daohdct=new DaoHDCT();
		 this.daohd=new DaoHoadon();
		 this.hd=new HoaDon();
		 this.daottb = new DaoTTBD();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		this.bdct = this.daobdct.findbyid(id);
		int idhd= Integer.parseInt(request.getParameter("idhd"));
		request.setAttribute("bdct", this.bdct);
		request.setAttribute("idbdct", id);
		request.setAttribute("idmn", menu);
		request.setAttribute("idhd", idhd);
		List<Menu> lstmenu= daomenu.trangthaistaff(1);
		request.setAttribute("monan", lstmenu);
		List<LoaiMenu> lstLoai= this.daoloai.getall();
		request.setAttribute("listLoai", lstLoai);
		int in= daottb.count();
		request.setAttribute("sl", in);
		int ttdem= daottb.counttthd();
		request.setAttribute("tt", ttdem);
		request.getRequestDispatcher("/views/Staff/StaffThemMon.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idmenu= Integer.parseInt(request.getParameter("idmn"));
		this.menu= daomenu.findbyid(idmenu);
		int id = Integer.parseInt(request.getParameter("id").trim());
		this.bdct = this.daobdct.findbyid(id);
		int sl= Integer.parseInt(request.getParameter("s_l"));
		int idhd= Integer.parseInt(request.getParameter("idhd"));
		this.hd= this.daohd.findbyid(idhd);
		
		Mnct mnct1 = new Mnct(sl,bdct,menu);
		daomnct.insert(mnct1);

		//insert hdct
		Mnct m = this.daomnct.findmnctbybdct(bdct);
		
		Hdct hdtc1 = new Hdct(0,0,hd,m);

		this.daohdct.insert(hdtc1);
		
		response.sendRedirect(request.getContextPath() + "/AddMenuCTController?id=" + id+"&&idhd="+idhd+"&&successInsertHDCT=1 ");
	

	}

}

