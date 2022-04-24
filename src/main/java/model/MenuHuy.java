package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu_huy database table.
 * 
 */
@Entity
@Table(name="menu_huy")
@NamedQuery(name="MenuHuy.findAll", query="SELECT m FROM MenuHuy m")
public class MenuHuy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MNH")
	private int idMnh;

	private String ghi_Chu;

	private int so_Luong;

	//bi-directional many-to-one association to Mnct
	@ManyToOne
	@JoinColumn(name="ID_MNCT")
	private Mnct mnct;

	public MenuHuy() {
	}

	public int getIdMnh() {
		return this.idMnh;
	}

	public void setIdMnh(int idMnh) {
		this.idMnh = idMnh;
	}

	public String getGhi_Chu() {
		return this.ghi_Chu;
	}

	public void setGhi_Chu(String ghi_Chu) {
		this.ghi_Chu = ghi_Chu;
	}

	public int getSo_Luong() {
		return this.so_Luong;
	}

	public void setSo_Luong(int so_Luong) {
		this.so_Luong = so_Luong;
	}

	public Mnct getMnct() {
		return this.mnct;
	}

	public void setMnct(Mnct mnct) {
		this.mnct = mnct;
	}

}