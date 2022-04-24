package Controller.Manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.NhanVienDao;

/**
 * Servlet implementation class DeleteAccManagerController
 */
@WebServlet("/DeleteAccManager")
public class DeleteAccManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NhanVienDao dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccManagerController() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new NhanVienDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idnv = Integer.parseInt(request.getParameter("idnv"));
		this.dao.delete(idnv);
		response.sendRedirect("showaccstaff");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
