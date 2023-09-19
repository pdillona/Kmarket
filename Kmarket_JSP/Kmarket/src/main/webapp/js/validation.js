/**
 * 회원가입 유효성 검사
 */
	
	let isUidOk = false;
	let isPassOk = false;
	let isNameOk = false;
	let isEmailOk = false;
	let isHpOk = false;
	let isCompanyOk = false;
	let isBizNumOk = false;
	let isComNumOk = false;
	let isFaxOk = false;
	
	
	// 데이터 검증에 사용하는 정규표현식
	const reUid   = /^[a-z]+[a-z0-9]{4,19}$/g;
	const rePass  = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{5,16}$/;
	const reName  = /^[가-힣]{2,10}$/ 
	const reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	const reHp    = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;
	const reCompany = /\(주\)\s+\S+/;	
	
	//유효성 검사 (Validation)
	$(function(){
		
		// 아이디 검사(유효하지 않은 아이디 입력 후 재입력시 span부분 초기화(공백))
		$('input[name=km_uid]').keydown(function () {
			$('.msgId').css('color','black').text('영문, 숫자로 4~12자까지 설정해 주세요.');
			isUidOk= false;
		});
		
		// 비번 검사
		$('input[name=km_pass2]').focusout(function() {
			
			const pass1 = $('input[name=km_pass1]').val();
			const pass2 = $('input[name=km_pass2]').val();
			
			if(pass1 == pass2){
				
				if(pass2.match(rePass)){
					$('.msgPass2').css('color','green').text('사용할 수 있는 비밀번호 입니다.');
					isPassOk= true;
				}else{
					$('.msgPass2').css('color','red').text('사용할 수 없는 비밀번호 입니다.');
					isPassOk= false;
				}
				
			}else{
				$('.msgPass2').css('color','red').text('비밀번호가 일지 하지 않습니다.');
				isPassOk = false;
			}
			
		});
		
		// member이름, seller 대표자, 담당자
		$('input[name=km_name], input[name=kms_ceo]').focusout(function() {
			const name = $(this).val();
			
			if(name.match(reName)){
				$('.msgName').text('');
				isNameOk = true;
			}else{
				$('.msgName').css('color','red').text('유효한 이름이 아닙니다.');
				isNameOk = false;
			}
		});
		
		
		// 이메일
		$('input[name=km_email]').keydown(function () {
			$('.resultEmail').text('');
			isEmailOk= false;
		});
		
		// 휴대폰
		$('input[name=km_hp]').keydown(function () {
			
			$('.msgHp').text('');
			isHpOk= false;
		});
		
		// 최종 확인
		$('#formUser').submit(function() { //서브밋 일어났을 때니 전송 전에 실행됨
			
			// 폼 전송 취소
			if(!isUidOk){
				alert('아이디를 확인 하세요');
				
				return false;
			}
			
			if(!idPassOk){
				alert('비밀번호를 확인 하세요');
				
				return false;
			}
			
			if(!isNameOk){
				alert('이름을 확인 하세요');
				
				return false;
			}
			
						
			if(!isEmailOk){
				alert('이메일을 확인 하세요');
				
				return false;
			}
			
			if(!isHpOk){
				alert('휴대폰 번호를 확인 하세요');
				
				return false;
			}
		
			return true; // 폼 전송 시작
		});
	});
	