package Controller.Member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GioHang;

@WebServlet("/Deletefood")
public class Deletefood extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<GioHang> dsgiohang;

	public Deletefood() {
		this.dsgiohang = new ArrayList();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idcart = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		dsgiohang = (ArrayList<GioHang>) session.getAttribute("gh");
		for (int i = 0; i < dsgiohang.size(); i++) {
			if (dsgiohang.get(i).getIdgh() == idcart) {
				dsgiohang.remove(dsgiohang.get(i));
				session.setAttribute("gd", dsgiohang);
				response.sendRedirect(request.getContextPath() + "/Order");
			}

		}

	}
}
