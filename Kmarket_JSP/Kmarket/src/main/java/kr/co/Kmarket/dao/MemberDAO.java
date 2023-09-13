package kr.co.Kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;


public class MemberDAO extends DBHelper{
	
	private String SQL = "";
	
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//register
	public void insertUser() {
		
		SQL = "";
		
		
			
	}

	//login
	public void selectUser() {
		
		
		
	}
	
	//추가 register(중복확인)
	public void selectCountUid() {
		
	}
	public void selectCountNick() {
		
	}
	public void selectCountHp() {
		
	}
	public void selectCountEmail() {
		
	}
	
	//////////////////////////2차 개발////////////////////////////
		//아이디 찾기
		public void selectCountNameAndEmail() {
			
			
			
		}
		//비밀번호 찾기
		public void selectCountUidAndEmail() {
			
		
			
		}
		//아이디찾기 전송
		public void selectUserByNameAndEmail() {
			
			
		}
		public void selectUsers() {
			
		}
		//비밀번호 찾기 변경, 회원정보수정 비밀번호 변경
		public void updateUserPass() {
			
		}
		//회원탈퇴
		public void updateUserForWithdraw() {
			
			
		}
		//회원정보수정
		public void updateUser() {
	
		}
		
		public void deleteUser(String uid) {}
	
}
