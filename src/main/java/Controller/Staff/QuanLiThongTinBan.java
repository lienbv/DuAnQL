package Controller.Staff;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoBanDatCT;
import Dao.DaoTTBD;
import model.Bdct;
import model.ThongTinBanDat;

/**
 * Servlet implementation class QuanLiThongTinBan
 */
@WebServlet("/QuanLiThongTinBan")
public class QuanLiThongTinBan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoTTBD daottbd;
	
    public QuanLiThongTinBan() {
        this.daottbd= new DaoTTBD();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ThongTinBanDat> lstttbd= daottbd.showttbdbyqlttb();
		request.setAttribute("TTBD", lstttbd);
		
		int in= daottbd.count();
		request.setAttribute("sl", in);
		int ttdem= daottbd.counttthd();
		request.setAttribute("tt", ttdem);
		
		request.getRequestDispatcher("/views/Staff/QuanLyThongTinBan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
