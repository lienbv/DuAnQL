package Controller.Manager;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuanLyThongKe
 */
@WebServlet("/QuanLyThongKe")
public class QuanLyThongKe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuanLyThongKe() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		request.setAttribute("nam", year);
		request.getRequestDispatcher("/views/Manager/QuanLyThongKe.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
