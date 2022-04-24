package Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lienhe")
public class Lienhe extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Lienhe() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/assets/LienHeKhachHang.jsp").forward(request, response);
	}
	

}
