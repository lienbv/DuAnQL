package Controller.Manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daottban;
import model.TtBan;

@WebServlet({ "/ThembanManager", "/ThembanManager/create", "/ThembanManager/edit" })
public class ThembanManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daottban daottban;

	public ThembanManager() {
		daottban = new Daottban();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<TtBan> lstttban = daottban.getall();
		request.setAttribute("listBan", lstttban);

		request.getRequestDispatcher("/views/Manager/QuanLyBan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String url = request.getRequestURL().toString();
		if (url.contains("create")) {
			insert(request, response);

		} else if (url.contains("edit")) {
			int index = Integer.parseInt(request.getParameter("id"));
			response.sendRedirect(request.getContextPath() + "/UpdateBanManager?id=" + index);
		}

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");

			int loai = Integer.parseInt(request.getParameter("loaiban"));
			TtBan ttban1 = new TtBan(loai);
			daottban.insert(ttban1);
			response.sendRedirect(request.getContextPath() + "/ThembanManager" + "?successThemBan=1");
		} catch (IOException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/ThembanManager" + "?error=1");
		}

	}

}
