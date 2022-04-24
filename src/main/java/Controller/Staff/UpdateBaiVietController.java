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
import Dao.NhanVienDao;
import Dao.baiVietDao;
import model.BaiViet;
import model.Staff;

@MultipartConfig
@WebServlet({ "/UpdateBaiVietController", "/UpdateBaiVietController/update" })
public class UpdateBaiVietController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private baiVietDao dao;
	private BaiViet bv;
	private NhanVienDao daonv;

	private List<BaiViet> lst;
	private Staff f;
	private DaoTTBD daottb;

	public UpdateBaiVietController() {
		this.dao = new baiVietDao();
		this.daonv = new NhanVienDao();
		this.bv = new BaiViet();
		this.lst = new ArrayList<BaiViet>();
		 this.daottb = new DaoTTBD();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			bv = this.dao.findbyid(id);
			request.setAttribute("bv", bv);
			int in= daottb.count();
			request.setAttribute("sl", in);
			int ttdem= daottb.counttthd();
			request.setAttribute("tt", ttdem);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("views/Staff/EditBaiViet.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			
			HttpSession session = request.getSession();
			Staff staff = (Staff) session.getAttribute("acountST");
			
			String realpath = request.getServletContext().getRealPath("./views/assets/imgs/");
			Path path = Paths.get(realpath);
			if (!Files.exists(path)) {
				Files.createDirectory(path);
			}
			Part part = request.getPart("img");
			String filenameUpload = part.getSubmittedFileName();
			if(!"".equals(filenameUpload)) {
				String namefile = Path.of(filenameUpload).getFileName().toString();
				part.write(realpath+System.getProperty("file.separator")+namefile); 
				bv.setImg(namefile);
			}
					
			
			String mota = request.getParameter("noidung");
			String tieude = request.getParameter("tieude");
			String link = request.getParameter("link");
			bv.setTen_tieu_de(tieude);
			bv.setLink(link);
			bv.setNoi_dung(mota);
			bv.setStaff(staff);
			
			dao.update(bv);
			
			response.sendRedirect(request.getContextPath() + "/HomeStaffController"+"?successUpdateBaiViet=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}