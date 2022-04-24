package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bai_viet database table.
 * 
 */
@Entity
@Table(name="bai_viet")
@NamedQuery(name="BaiViet.findAll", query="SELECT b FROM BaiViet b")
public class BaiViet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDbv;

	private String img;

	private String link;

	private String noi_dung;

	private String ten_tieu_de;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="IDNV")
	private Staff staff;

	public BaiViet() {
	}

	public BaiViet(String img, String link, String noi_dung, String ten_tieu_de, Staff staff) {
		this.img = img;
		this.link = link;
		this.noi_dung = noi_dung;
		this.ten_tieu_de = ten_tieu_de;
		this.staff = staff;
	}

	public int getIDbv() {
		return this.IDbv;
	}

	public void setIDbv(int IDbv) {
		this.IDbv = IDbv;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNoi_dung() {
		return this.noi_dung;
	}

	public void setNoi_dung(String noi_dung) {
		this.noi_dung = noi_dung;
	}

	public String getTen_tieu_de() {
		return this.ten_tieu_de;
	}

	public void setTen_tieu_de(String ten_tieu_de) {
		this.ten_tieu_de = ten_tieu_de;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}