package Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.Units;
import org.apache.poi.xddf.usermodel.text.TabAlignment;
//import org.apache.poi.xwpf.converter.pdf.PdfConverter;
//import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import Dao.DaoHDCT;
import Dao.DaoHoadon;
import model.Hdct;
import model.HoaDon;
import model.ThongTinBanDat;

public class WritePDF {
	private HoaDon hd;
	private DaoHoadon dao_HD;
	private List<Hdct> listHDCT;
	private DaoHDCT dao_HDCT;

	public WritePDF() {
		this.hd = new HoaDon();
		this.dao_HD = new DaoHoadon();
		this.listHDCT = new ArrayList<Hdct>();
		this.dao_HDCT = new DaoHDCT();
	}

	public void exportPDF(HttpServletResponse response, int id_HD) {

		try {
			this.hd = this.dao_HD.sortIDbyHD();
			ThongTinBanDat ttdb = this.hd.getThongTinBanDat();
			String fileName = "Inhoadon_Ban"+ttdb.getIdBd()+".docx";
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			ServletOutputStream pos = response.getOutputStream();
			
			XWPFDocument doc = new XWPFDocument();
			
			String img = "C:\\Users\\HLC_2021\\Desktop\\DuAn11\\src\\main\\webapp\\views\\assets\\imgs\\logo.jpg";
			XWPFParagraph par = doc.createParagraph();
			par.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun run0 = par.createRun();
			FileInputStream is = new FileInputStream(img);
			run0.addPicture(is, Document.PICTURE_TYPE_PNG, img, Units.toEMU(100), Units.toEMU(30));

			XWPFParagraph par1 = doc.createParagraph();
			par1.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun run = par1.createRun();
			run.setText("Bủng Buffet");
			run.setFontSize(20);
			run.setEmbossed(true);

			XWPFParagraph par2 = doc.createParagraph();
			par2.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun run2 = par2.createRun();
			run2.setText("Địa chỉ:Số 9,Lô 9 Khu Liền Kề Nam Thắng,Ngõ 67 Phùng Khoang,Hà Nội");
			run2.addBreak();
			run2.setText("Số điện thoại:0977256375");
			run2.setFontSize(10);

			XWPFParagraph par3 = doc.createParagraph();
			par3.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun run3 = par3.createRun();
			run3.setText("Thông tin hóa đơn");
			run3.setFontSize(20);
			run3.setEmbossed(true);

			XWPFParagraph par4 = doc.createParagraph();
			par4.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun run4 = par4.createRun();
			run4.setText("          Mã bàn :                                 Bàn " + ttdb.getIdBd());
			run4.addBreak();
			int id1 = this.hd.getIdhd() + 1;
			run4.setText("Số hóa đơn :                             " + id1);
			run4.addBreak();
			run4.setText("                       Khách Hàng :                         " + this.hd.getKhachHang().getHoTen());
			run4.addBreak();
			run4.setText("             Giờ vào :                                   " + ttdb.getGioDatBan());
			run4.addBreak();
			run4.setText("                                 Giờ ra :                                     " + this.hd.getThoi_gian());
			run4.setFontSize(10);
			int numberRow = 0;
			XWPFTable table = doc.createTable();
			table.setCellMargins(40, 40, 40, 40);
			table.setTableAlignment(TableRowAlign.CENTER);
			table.setWidth(6000);
			XWPFTableRow row = table.getRow(0);
			row.getCell(0).setText("Tên Món");
			row.addNewTableCell().setText("Đơn Giá");
			row.addNewTableCell().setText("Số Lượng");
			row.addNewTableCell().setText("Thành Tiền");
			this.hd = this.dao_HD.findbyid(id_HD);
			this.listHDCT = this.dao_HDCT.findhdctbyidhd(this.hd);
			for (Hdct hdct : this.listHDCT) {
				XWPFTableRow row1 = table.createRow();
				row1.getCell(0).setText(hdct.getMnct().getMenu().getTen_Mon_An());
				row1.getCell(1).setText(hdct.getMnct().getMenu().getGia() + "");
				row1.getCell(2).setText(hdct.getSo_luong() + "");
				row1.getCell(3).setText(hdct.getThanh_Tien() + "");
			}
			XWPFTableRow row2 = table.createRow();
			row2.getCell(1).setText("Tổng Tiền");
			float tongtien = 0;
			for (Hdct x : this.listHDCT) {
				tongtien += x.getThanh_Tien();
			}
			row2.getCell(3).setText(tongtien + "");

			doc.write(pos);
			doc.close();
			pos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
