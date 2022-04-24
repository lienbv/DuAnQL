package Controller.Manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import Dao.DaoMenu;
import Dao.Daoloaimenu;
import model.LoaiMenu;
import model.Menu;

@MultipartConfig
@WebServlet("/updateMenuManager")
public class updateMenuManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoMenu daomenu;
	private Menu menu;
	private LoaiMenu loaimenu;
	private Daoloaimenu daoloai;

	public updateMenuManager() {
		this.daomenu = new DaoMenu();
		this.menu = new Menu();
		this.daoloai = new Daoloaimenu();
		this.loaimenu = new LoaiMenu();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listCategorey(request, response);
		request.getRequestDispatcher("/views/Manager/EditFoodManager.jsp").forward(request, response);
	}

	private void listCategorey(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		menu = this.daomenu.findbyid(id);
		request.setAttribute("menu", menu);
		List<LoaiMenu> lstLoai = daoloai.getall();
		request.setAttribute("listCC", lstLoai);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");

			String realpath = request.getServletContext().getRealPath("./views/assets/imgs");
			Path path = Paths.get(realpath);
			if (!Files.exists(path)) {
				Files.createDirectory(path);
			}
			Part part = request.getPart("img");
			String filenameUpload = part.getSubmittedFileName();
			if (!"".equals(filenameUpload)) {
				String namefile = Path.of(filenameUpload).getFileName().toString();
				part.write(realpath + System.getProperty("file.separator") + namefile);
				menu.setImg(namefile);
			}
			String tenmon = request.getParameter("tenMon");
			float gia = Float.parseFloat(request.getParameter("gia"));
			int loai = Integer.parseInt(request.getParameter("chonLoai"));
			int trangthai = Integer.parseInt(request.getParameter("trangthai"));
			loaimenu = daoloai.findbyid(loai);
			menu.setTen_Mon_An(tenmon);
			menu.setGia(gia);
			menu.setLoaiMenu(loaimenu);
			menu.setTrang_Thai(trangthai);
			daomenu.update(menu);
			response.sendRedirect(request.getContextPath() + "/ThemMenuManager" + "?successupdateMenuManager=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
