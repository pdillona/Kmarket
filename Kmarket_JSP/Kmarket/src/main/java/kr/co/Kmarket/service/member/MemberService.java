package kr.co.Kmarket.service.member;

import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import kr.co.Kmarket.dao.member.MemberDAO;
import kr.co.Kmarket.dto.member.MemberDTO;

public class MemberService {
	
	private static MemberService instance = new  MemberService();
	public static MemberService getInstance() {
		return instance;
	}
	private MemberService() {}
	
	//이메일 인증코드
	private static String generatedCode;
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	//회원가입
	public void insertMember(MemberDTO dto) {
		dao.insertMember(dto);
	}

	//중복확인
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	
	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
	
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	
	public int selectCountbizRegNum(String bizRegNum) {
		return dao.selectCountbizRegNum(bizRegNum);
	}
	
	public int selectCountcomRegNum(String comRegNum) {
		return dao.selectCountcomRegNum(comRegNum);
	}
	
	//로그인
	public MemberDTO selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
	
	//아이디 찾기
	public int selectCountNameAndEmail(String name,String email) {
		return dao.selectCountNameAndEmail(name, email);
	}
	
	//비밀번호 찾기
	public int selectCountUidAndEmail(String uid,String email) {
		return dao.selectCountUidAndEmail(uid, email);
	}
	
	//아이디찾기 전송
	public MemberDTO selectMemberByNameAndEmail(String name, String email) {
		return dao.selectMemberByNameAndEmail(name, email);
	}

	//비밀번호 찾기 변경, 회원정보수정 비밀번호 변경
	public int updateMemberPass(String uid, String pass) {
		return dao.updateMemberPass(uid, pass);
	}
	
	//회원정보수정
	public void updateMember(MemberDTO dto) {
		dao.updateMember(dto);
	}
	
	//회원탈퇴
	public int updateMemberForWithdraw(String uid) {
		return dao.updateMemberForWithdraw(uid);
	}

///////////////////////////////////////////////////////////////////////
	//이메일 인증
	public int sendCodeByEmail(String receiver) {
	
	//인증코드 생성
	int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
	generatedCode = ""+code;
	
	//기본정보
	String sender = "z82714567@gmail.com";
	String password = "hygeihfpwgeukruv";
	String title = "Jboard2 인증코드 입니다.";
	String content = "<h1>인증코드는 " + code + "</h1>";
	
	//Gmail SMTP 서버 설정
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "465");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.ssl.enable", "true");
	props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	
	//Gmail STMP 세션 생성
	Session gmailSession = Session.getInstance(props, new Authenticator(){
		
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(sender, password);
		}
	});
	
	//메일 발송
	int status = 0;
	Message message = new MimeMessage(gmailSession);
	
	try{
		message.setFrom(new InternetAddress(sender, "보내는 사람", "UTF-8"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
		message.setSubject(title);
		message.setContent(content, "text/html;charset=UTF-8");
		Transport.send(message);
		
		status = 1;
	}catch(Exception e){
		status = 0;
	}
	return status;
	}//sendCodeByEmail end

	public int confirmCodeByEmail(String code) {

	if(code.equals(generatedCode)) {
		return 1;
	}else {
		return 0;
		}
	}
	
	
	
	
}
