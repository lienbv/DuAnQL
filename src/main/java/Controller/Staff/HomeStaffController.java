package Controller.Staff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Dao.DaoTTBD;
import Dao.baiVietDao;
import model.BaiViet;
import model.Staff;

@MultipartConfig
@WebServlet({ "/HomeStaffController", "/HomeStaffController/create", "/HomeStaffController/update/*"})
public class HomeStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private baiVietDao dao;
	private List<BaiViet> lst;
	private DaoTTBD daottb;

	public HomeStaffController() {
		this.dao = new baiVietDao();
		this.lst = new ArrayList<BaiViet>();
		this.daottb = new DaoTTBD();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		findID(request, response);
		int in= daottb.count();
		request.setAttribute("sl", in);
		int ttdem= daottb.counttthd();
		request.setAttribute("tt", ttdem);
		request.getRequestDispatcher("views/Staff/QuanLyBaiVietStaff.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();

		if (url.contains("create")) {
			insert(request, response);

		}  else if (url.contains("update")) {
			int index = Integer.parseInt(request.getParameter("id"));
			response.sendRedirect(request.getContextPath() + "/UpdateBaiVietController?id=" + index);
		}
		findID(request, response);
	}

	private void findID(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("acountST");

		lst = dao.findIDNV(staff);
		request.setAttribute("listBV", lst);
	}


	private void insert(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Staff staff = (Staff) session.getAttribute("acountST");
			String realpath = request.getServletContext().getRealPath("./views/assets/imgs/");
			Path path = Paths.get(realpath);
			if (!Files.exists(path)) {
				Files.createDirectory(path);
			}
			Part part = request.getPart("chonAnh");
			String namefile = Path.of(part.getSubmittedFileName()).getFileName().toString();
			part.write(realpath+System.getProperty("file.separator")+namefile); 
			String mota = request.getParameter("mota");
			String tieude = request.getParameter("tieuDe");
			String link = request.getParameter("link");
			
		    BaiViet	bv= new BaiViet( namefile, link, mota, tieude, staff);
			
			dao.insert(bv);

			response.sendRedirect(request.getContextPath() + "/HomeStaffController" + "?success=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
