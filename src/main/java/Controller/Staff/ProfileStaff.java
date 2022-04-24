package Controller.Staff;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.mysql.cj.Session;

import Dao.DaoTTBD;
import Dao.Dao_Staff;
import model.KhachHang;
import model.Staff;

/**
 * Servlet implementation class ProfileStaff
 */
@MultipartConfig
@WebServlet({ 
	"/ProfileStaff", 
	"/ProfileStaff/Update_profile_staff",
	"/ProfileStaff/Changepass_staff" 
	})
public class ProfileStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Staff staff;
	private Dao_Staff dao;
	private DaoTTBD daottb;

	public ProfileStaff() {
		this.staff = new Staff();
		this.dao = new Dao_Staff();
		this.daottb = new DaoTTBD();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		this.staff = (Staff) session.getAttribute("acountST");
		request.setAttribute("staff", this.staff);
		
		int in= daottb.count();
		request.setAttribute("sl", in);
		int ttdem= daottb.counttthd();
		request.setAttribute("tt", ttdem);

		request.getRequestDispatcher("/views/Staff/ThongTinCaNhanStaff.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String sdt = request.getParameter("phone");
		String email = request.getParameter("email");
		String mkcu = request.getParameter("pass_cu");
		String mkmoi = request.getParameter("pass_moi");
		String xacnhan = request.getParameter("xacnhan_pass");
		int index = Integer.parseInt(request.getParameter("idnv"));
		this.staff=this.dao.findbyid(index);
		String url = request.getRequestURL().toString();
		if (url.contains("Changepass_staff")) {
			if (mkcu.equals(this.staff.getPassword())) {
				this.dao.changepassstaff(index, mkmoi);
				response.sendRedirect(request.getContextPath() + "/ProfileStaff?" + "succes=5");
			} else {
				response.sendRedirect(request.getContextPath() + "/ProfileStaff?" + "error=5");
			}
		} else if (url.contains("Update_profile_staff")) {
			try {
				String realpath = request.getServletContext().getRealPath("/img");
				Path path = Paths.get(realpath);
				if (!Files.exists(path)) {
					Files.createDirectory(path);
				}
				Part part = request.getPart("image");
				String filenameUpload = part.getSubmittedFileName();
				if (!"".equals(filenameUpload)) {
					String namefile = Path.of(filenameUpload).getFileName().toString();
					part.write(Paths.get(realpath.toString(), namefile).toString());
					this.staff.setImg(namefile);
				}
				
				this.staff.setIdnv(index);
				this.staff.setHoTen(name);
				this.staff.setSdt(sdt);
				this.staff.setEmail(email);
				this.dao.updateprofilestaff(staff);
				response.sendRedirect(request.getContextPath() + "/ProfileStaff?" + "succesUpdateprofilestaff=6");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}