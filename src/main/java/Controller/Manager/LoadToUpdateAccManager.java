package Controller.Manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.NhanVienDao;
import model.Staff;

/**
 * Servlet implementation class LoadToUpdateAccManager
 */
@WebServlet("/LoadToUpdate")
public class LoadToUpdateAccManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NhanVienDao daonv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadToUpdateAccManager() {
        super();
        // TODO Auto-generated constructor stub
        this.daonv = new NhanVienDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("idacc"));
		try {
			Staff st = new Staff();
			st = this.daonv.findbyid(id);
			request.setAttribute("staff", st);
			request.getRequestDispatcher("views/Manager/EditInfoStaff.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
