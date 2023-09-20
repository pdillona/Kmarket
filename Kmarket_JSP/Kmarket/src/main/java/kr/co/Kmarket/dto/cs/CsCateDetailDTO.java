package kr.co.Kmarket.dto.cs;

public class CsCateDetailDTO {

	private String aeName;
	private int type;
	private String dName;
	
	
	public String getAeName() {
		return aeName;
	}
	public void setAeName(String aeName) {
		this.aeName = aeName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setType(String type) {
		this.type = Integer.parseInt(type);
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	
	
	
	
}
