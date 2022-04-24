package Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Dao.DaoTTBD;
import model.ThongTinBanDat;

public class Checkdatebooking {
	private DaoTTBD dao;
	private List<ThongTinBanDat> lstttb;

	public Checkdatebooking() {
		this.dao = new DaoTTBD();
		this.lstttb = new ArrayList<ThongTinBanDat>();
	}

	public void checkdate() {
		this.lstttb = this.dao.findttbdbystatus();
		System.out.println(this.lstttb.size());
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		System.out.println(hour + " dòng 26 nè");
		for (ThongTinBanDat t : this.lstttb) {
			if (t.getNgayDatBan().getDate() < day) {
				t.setTrang_Thai("Cancelled");
				this.dao.update(t);
			} else {
				System.out.println(hour + " dòng 32 nè");
				if (t.getGioDatBan().getHours() < hour) {
					t.setTrang_Thai("Cancelled");
					this.dao.update(t);
				} else if (t.getGioDatBan().getHours() == hour){
					if (t.getGioDatBan().getMinutes() < minute) {
						t.setTrang_Thai("Cancelled");
						this.dao.update(t);
					}
				}
			}

		}
	}
}
