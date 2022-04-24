package Controller.Manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daottban;
import model.TtBan;

@WebServlet("/UpdateBanManager")
public class UpdateBanManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Daottban daottban;
    private TtBan ttban;
    public UpdateBanManager() {
       daottban= new Daottban();
       ttban= new TtBan();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		ttban= daottban.findbyid(id);
		request.setAttribute("ban", ttban);
		request.getRequestDispatcher("/views/Manager/UpdateBan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int loai = Integer.parseInt( request.getParameter("loaiban"));
		ttban.setLoaiBan(loai);
		daottban.update(ttban);
		response.sendRedirect(request.getContextPath() + "/ThembanManager" + "?successUpdateBanManager=1");
	}
}
