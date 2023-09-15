package kr.co.Kmarket.dto;

public class CsArticleDTO {

	private int aNo;
	private String cate;
	private String cateDtail;
	private String title;
	private String content;
	private int file;
	private String writer;
	private String regip;
	private String rdate;
	private String aeName;
	private String akName;
	private int type;
	private String dName;
	
	private FileDTO fileDto;
	
	
	public FileDTO getFileDto() {
		return fileDto;
	}
	public void setFileDto(FileDTO fileDto) {
		this.fileDto = fileDto;
	}
	public int getaNo() {
		return aNo;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getCateDtail() {
		return cateDtail;
	}
	public void setCateDtail(String cateDtail) {
		this.cateDtail = cateDtail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFile() {
		return file;
	}
	public void setFile(int file) {
		this.file = file;
	}
	public void setFile(String oriName) {
		
		if(oriName != null) {
			this.file = 1;	
		}else {
			this.file = 0;
		}
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getAeName() {
		return aeName;
	}
	public void setAeName(String aeName) {
		this.aeName = aeName;
	}
	public String getAkName() {
		return akName;
	}
	public void setAkName(String akName) {
		this.akName = akName;
	}
	public int getdType() {
		return type;
	}
	public void setdType(int type) {
		this.type = type;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	

	
	
	
}
