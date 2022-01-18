package javaBeans;

import java.io.Serializable;

public class LoaiSua implements Serializable{
	private String maLoaiSua;
	private String tenLoai;
	
	public LoaiSua() {
		super();
	}
	
	public String getMaLoaiSua() {
		return maLoaiSua;
	}
	public void setMaLoaiSua(String maLoaiSua) {
		this.maLoaiSua = maLoaiSua;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	
	
}
