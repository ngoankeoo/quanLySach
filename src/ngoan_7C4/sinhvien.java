package ngoan_7C4;

public class sinhvien {
	private int masv;
	private String hoten;
	private String tenkhoa;
	private String gioitinh;
	private int diemtin;
	
	public sinhvien(int masv, String hoten, String tenkhoa, String gioitinh, int diemtin) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.tenkhoa = tenkhoa;
		this.gioitinh = gioitinh;
		this.diemtin = diemtin;
	}

	public int getMasv() {
		return masv;
	}

	public void setMasv(int masv) {
		this.masv = masv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getTenkhoa() {
		return tenkhoa;
	}

	public void setTenkhoa(String tenkhoa) {
		this.tenkhoa = tenkhoa;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public int getDiemtin() {
		return diemtin;
	}

	public void setDiemtin(int diemtin) {
		this.diemtin = diemtin;
	}

	@Override
	public String toString() {
		return "sinhvien [masv=" + masv + ", hoten=" + hoten + ", tenkhoa=" + tenkhoa + ", gioitinh=" + gioitinh
				+ ", diemtin=" + diemtin + "]";
	}
	
	

}
