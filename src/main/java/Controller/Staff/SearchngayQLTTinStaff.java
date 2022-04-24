package Controller.Staff;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.converters.DateConverter;

import Dao.DaoTTBD;
import model.ThongTinBanDat;

@WebServlet("/SearchngayQLTTinStaff")
public class SearchngayQLTTinStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ThongTinBanDat ttbd;
    private DaoTTBD daottbd;
    private List<ThongTinBanDat> lst;
	public SearchngayQLTTinStaff() {
		super();
		this.ttbd= new ThongTinBanDat();
		this.daottbd= new DaoTTBD();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");		
        
		Date txtSearch= Date.valueOf(request.getParameter("txt")) ;
		lst =  daottbd.finDate(txtSearch);
		System.out.println(ttbd);

		request.setAttribute("txtSearch", txtSearch);
		request.setAttribute("TTBD", lst);
		
		int in= daottbd.count();
		request.setAttribute("sl", in);
		int ttdem= daottbd.counttthd();
		request.setAttribute("tt", ttdem);
		
		request.getRequestDispatcher("/views/Staff/QuanLyThongTinBan.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
