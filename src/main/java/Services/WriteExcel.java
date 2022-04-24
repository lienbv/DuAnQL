package Services;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Dao.DaoHDCT;
import Dao.DaoHoadon;
import model.Hdct;
import model.HoaDon;
import model.ThongTinBanDat;

public class WriteExcel {
	private HoaDon hd;
	private DaoHoadon dao_HD;
	private List<Hdct> listHDCT;
	private DaoHDCT dao_HDCT;

	public WriteExcel() {
		this.hd = new HoaDon();
		this.dao_HD = new DaoHoadon();
		this.listHDCT = new ArrayList<Hdct>();
		this.dao_HDCT = new DaoHDCT();
	}

	public void exportExcel(HttpServletResponse response, int id_HD) {
		try {
			// response.setContentType("text/html;charset=UTF-8");
			String fileName = "InHoaDon.xlsx";
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			ServletOutputStream pos = response.getOutputStream();
			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("Information");
			XSSFFont font = workBook.createFont();
			font.setBold(true);
			font.setFontHeightInPoints((short) 25);
			font.setFontName("Arial");
			XSSFCellStyle style = workBook.createCellStyle();
			style.setFont(font);
			Row row0 = sheet.createRow(0);
			Cell ce = row0.createCell(0);
			ce.setCellValue("Thông Tin Bàn Đặt");
			ce.setCellStyle(style);
			int colum = 1;
			this.hd = this.dao_HD.sortIDbyHD();
			ThongTinBanDat ttdb = this.hd.getThongTinBanDat();
			XSSFFont font1 = workBook.createFont();
			font1.setFontName("Arial");
			font1.setFontHeightInPoints((short) 15);
			XSSFCellStyle style1 = workBook.createCellStyle();
			style1.setFont(font1);

//			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss");

//			style2.setDataFormat(workBook.createDataFormat().getFormat("dd-M-yyyy hh:mm:ss"));
			CreationHelper creationHelper = workBook.getCreationHelper();
			XSSFCellStyle style2 = workBook.createCellStyle();
			style2.setDataFormat(creationHelper.createDataFormat().getFormat("HH:MM:SS"));
			font1.setFontName("Arial");
			font1.setFontHeightInPoints((short) 15);
			style2.setFont(font1);

			// MÃƒ BÃ€N
			Row row1 = sheet.createRow(2);
			Cell ce1 = row1.createCell(1);
			ce1.setCellValue("Mã Bàn");
			ce1.setCellStyle(style1);
			Cell ce11 = row1.createCell(5);
			ce11.setCellValue("Bàn " + ttdb.getIdBd());
			ce11.setCellStyle(style1);

			// Sá»� HÃ“A Ä�Æ N
			Row row2 = sheet.createRow(4);
			Cell ce2 = row2.createCell(1);
			ce2.setCellValue("Số Hóa Đơn");
			ce2.setCellStyle(style1);
			Cell ce22 = row2.createCell(5);
			int id = this.hd.getIdhd() + 1;
			ce22.setCellValue(id);
			ce22.setCellStyle(style1);

			// KHÃ�CH HÃ€NG
			Row row3 = sheet.createRow(6);
			Cell ce3 = row3.createCell(1);
			ce3.setCellValue("Khách Hàng");
			ce3.setCellStyle(style1);
			Cell ce33 = row3.createCell(5);
			ce33.setCellValue(this.hd.getKhachHang().getHoTen());
			ce33.setCellStyle(style1);

			// Giá»� VÃ o
			Row row4 = sheet.createRow(8);
			Cell ce4 = row4.createCell(1);
			ce4.setCellValue("Giờ Vào");
			ce4.setCellStyle(style1);
			Cell ce44 = row4.createCell(5);
			ce44.setCellValue(ttdb.getGioDatBan());
			ce44.setCellStyle(style2);

			// Giá»� ra
			Row row5 = sheet.createRow(10);
			Cell ce5 = row5.createCell(1);
			ce5.setCellValue("Giờ ra");
			ce5.setCellStyle(style1);
			Cell ce55 = row5.createCell(5);
			ce55.setCellValue(this.hd.getThoi_gian());
			ce55.setCellStyle(style2);

			int numberRow = 12;
			XSSFFont font7 = workBook.createFont();
			XSSFCellStyle style7 = workBook.createCellStyle();
			style7.setFont(font1);
			style7.setBorderLeft(BorderStyle.MEDIUM);
			style7.setBorderRight(BorderStyle.MEDIUM);
			style7.setBorderTop(BorderStyle.MEDIUM);
			style7.setBorderBottom(BorderStyle.MEDIUM);
			Row row7 = sheet.createRow(numberRow++);
			Cell ce7 = row7.createCell(1);
			ce7.setCellValue("STT");
			ce7.setCellStyle(style7);
			Cell ce8 = row7.createCell(2);
			ce8.setCellValue("Tên Món");
			ce8.setCellStyle(style7);
			Cell ce9 = row7.createCell(3);
			ce9.setCellValue("Đơn Gía");
			ce9.setCellStyle(style7);
			Cell ce10 = row7.createCell(4);
			ce10.setCellValue("Số Lượng");
			ce10.setCellStyle(style7);
			Cell ce18 = row7.createCell(5);
			ce18.setCellValue("Thành Tiền");
			ce18.setCellStyle(style7);

			XSSFCellStyle style3 = workBook.createCellStyle();
			style3.setBorderLeft(BorderStyle.MEDIUM);
			style3.setBorderRight(BorderStyle.MEDIUM);
			style3.setBorderTop(BorderStyle.MEDIUM);
			style3.setBorderBottom(BorderStyle.MEDIUM);

			this.hd = this.dao_HD.findbyid(id_HD);
			this.listHDCT = this.dao_HDCT.findhdctbyidhd(this.hd);
			int i = 1;
			for (Hdct hdct : this.listHDCT) {
				Row row = sheet.createRow(numberRow++);
				Cell c1 = row.createCell(1);
				c1.setCellValue(i++);
				c1.setCellStyle(style3);

				Cell c2 = row.createCell(2);
				c2.setCellValue(hdct.getMnct().getMenu().getTen_Mon_An());
				c2.setCellStyle(style3);

				Cell c3 = row.createCell(3);
				c3.setCellValue(hdct.getMnct().getMenu().getGia());
				c3.setCellStyle(style3);

				Cell c4 = row.createCell(4);
				c4.setCellValue(hdct.getSo_luong());
				c4.setCellStyle(style3);

				Cell c5 = row.createCell(5);
				c5.setCellValue(hdct.getThanh_Tien());
				c5.setCellStyle(style3);
			}

			// Tá»•ng Tiá»�n
			Row row15 = sheet.createRow(numberRow++);
			Cell ce15 = row15.createCell(3);
			ce15.setCellValue("Tổng Tiền");
			ce15.setCellStyle(style1);
			Cell ce16 = row15.createCell(5);
			float tongtien = 0;
			for (Hdct x : this.listHDCT) {
				tongtien += x.getThanh_Tien();
			}
			ce16.setCellValue(tongtien);
			ce16.setCellStyle(style1);

			for (colum = 1; colum < 8; colum++) {
				sheet.autoSizeColumn(colum);
			}
			// OutputStream pos = new FileOutputStream("InHoaDon.xlsx");
			workBook.write(pos);
			workBook.close();
			pos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}