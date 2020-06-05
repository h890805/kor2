package sist.com.dao;
 
public class adminCartBeans {
	
	private int Prono;
	private String ProName;
	private String Proimg;
	private String ProCon;
	private int ProPrice;
	private String ProKind;
	private String ProDate;
	private String ProState;
	
	
	
	public adminCartBeans(int prono, String proName, String proimg, String proCon, int proPrice, String proKind,
			String proDate, String proState) {
		super();
		Prono = prono;
		ProName = proName;
		Proimg = proimg;
		ProCon = proCon;
		ProPrice = proPrice;
		ProKind = proKind;
		ProDate = proDate;
		ProState = proState;
	}
	public int getProno() {
		return Prono;
	}
	public void setProno(int prono) {
		Prono = prono;
	}
	public String getProName() {
		return ProName;
	}
	public void setProName(String proName) {
		ProName = proName;
	}
	public String getProimg() {
		return Proimg;
	}
	public void setProimg(String proimg) {
		Proimg = proimg;
	}
	public String getProCon() {
		return ProCon;
	}
	public void setProCon(String proCon) {
		ProCon = proCon;
	}
	public int getProPrice() {
		return ProPrice;
	}
	public void setProPrice(int proPrice) {
		ProPrice = proPrice;
	}
	public String getProKind() {
		return ProKind;
	}
	public void setProKind(String proKind) {
		ProKind = proKind;
	}
	public String getProDate() {
		return ProDate;
	}
	public void setProDate(String proDate) {
		ProDate = proDate;
	}
	public String getProState() {
		return ProState;
	}
	public void setProState(String proState) {
		ProState = proState;
	}
	@Override
	public String toString() {
		return "adminCart [Prono=" + Prono + ", ProName=" + ProName + ", Proimg=" + Proimg + ", ProCon=" + ProCon
				+ ", ProPrice=" + ProPrice + ", ProKind=" + ProKind + ", ProDate=" + ProDate + ", ProState=" + ProState
				+ "]";
	}
	
	
	

}
