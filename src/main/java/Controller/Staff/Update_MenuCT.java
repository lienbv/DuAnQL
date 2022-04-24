package Controller.Staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoHDCT;
import Dao.DaoMenuCT;
import Dao.DaoTTBD;
import model.Hdct;
import model.Mnct;

@WebServlet("/Update_MenuCT")
public class Update_MenuCT extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoMenuCT daomnct;
	private Mnct mnct;
	private DaoHDCT dao_hdct;
	private Hdct hdct;
	private DaoTTBD daottb;

	public Update_MenuCT() {
		this.daomnct = new DaoMenuCT();
		this.mnct = new Mnct();
		this.dao_hdct = new DaoHDCT();
		this.hdct = new Hdct();
		 this.daottb = new DaoTTBD();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int in= daottb.count();
		request.setAttribute("sl", in);
		int ttdem= daottb.counttthd();
		request.setAttribute("tt", ttdem);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idbdct = Integer.parseInt(request.getParameter("idbcct"));
		int idmenuCT = Integer.parseInt(request.getParameter("idmenuCT"));
		int idhdCT = Integer.parseInt(request.getParameter("idHDCT"));
		int idhd=Integer.parseInt(request.getParameter("idhd"));
		int sl = Integer.parseInt(request.getParameter("spinner"));
		int slUP = Integer.parseInt(request.getParameter("spinnerr"));
		
		if(slUP<0) {
			response.sendRedirect(request.getContextPath() + "/menuCTController?id=" + idbdct+"&&idhd="+idhd + "&&errorSLPos=1");
		}else if(sl<0) {
			response.sendRedirect(request.getContextPath() + "/menuCTController?id=" + idbdct+"&&idhd="+idhd + "&&errorSLPos=1");
		}else if(slUP<=sl) {
			this.mnct = this.daomnct.findbyid(idmenuCT);
			this.mnct.setSo_luong(sl);
			this.daomnct.update(this.mnct);
			this.hdct = this.dao_hdct.findbyid(idhdCT);
			double gia=mnct.getMenu().getGia()*slUP;
			this.hdct.setThanh_Tien(gia);
			this.hdct.setSo_luong(slUP);
			this.dao_hdct.update(this.hdct);
			response.sendRedirect(request.getContextPath() + "/menuCTController?id=" + idbdct+"&&idhd="+idhd );
		}else {
			response.sendRedirect(request.getContextPath() + "/menuCTController?id=" + idbdct+"&&idhd="+idhd + "&&errorSL=1");
		}
	}

}
