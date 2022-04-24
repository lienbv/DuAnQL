package Controller.Manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThongKeBanDat")
public class ThongKeBanDat extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public ThongKeBanDat() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/Manager/ThongKeBanDat.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int year = Integer.parseInt(request.getParameter("yeartk"));
		response.sendRedirect(request.getContextPath() + "/ThongKeBanDat?nam="+year);
	}

}
