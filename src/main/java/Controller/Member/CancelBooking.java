package Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoCart;
import Dao.DaoTTBD;
import model.ThongTinBanDat;

/**
 * Servlet implementation class CancelBooking
 */
@WebServlet({ "/CancelBooking", "/CancelBooking/Staffcancel", "/CancelBooking/Staffdelete",
		"/CancelBooking/Memberdelete", "/CancelBooking/Guest"

})
public class CancelBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoTTBD daottbd;
	private ThongTinBanDat ttbd;
	private DaoCart daocart;

	public CancelBooking() {
		this.ttbd = new ThongTinBanDat();
		this.daottbd = new DaoTTBD();
		this.daocart = new DaoCart();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		this.ttbd = this.daottbd.findbyid(id);
		String url = request.getRequestURL().toString();
		HttpSession session = request.getSession();
		String date = (String) session.getAttribute("date_book");
		if (url.contains("Memberdelete")) {
			if (this.ttbd.getTrang_Thai().equals("Confirmed")) {
				this.ttbd.setTrang_Thai("Cancelled");
				this.daottbd.update(ttbd);
			} else if (this.ttbd.getTrang_Thai().equals("Waitting line")) {
				this.daocart.deletecartbyttbd(ttbd);
				this.daottbd.delete(id);
			}
			response.sendRedirect(request.getContextPath() + "/Booking?date=" + date + "&&sucssesCancelBooking=3");
		} else if (url.contains("Staffdelete")) {
			this.daocart.deletecartbyttbd(ttbd);
			this.daottbd.delete(id);
			response.sendRedirect(request.getContextPath() + "/Notification" + "?sucssesCancelBooking=3");
		} else if (url.contains("Staffcancel")) {
			this.ttbd.setTrang_Thai("Cancelled");
			this.daottbd.update(ttbd);
			response.sendRedirect(request.getContextPath() + "/Notification" + "?sucssesCancelBooking=3");
		} else if (url.contains("Guest")) {
			if (this.ttbd.getTrang_Thai().equals("Confirmed")) {
				this.ttbd.setTrang_Thai("Cancelled");
				this.daottbd.update(ttbd);
			} else if (this.ttbd.getTrang_Thai().equals("Waitting line")) {
				this.daocart.deletecartbyttbd(ttbd);
				this.daottbd.delete(id);
			}
			response.sendRedirect(request.getContextPath() + "/HomeKhachHangServlet?sucssesCancelBooking=3");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
