/**
 * 사용자 중복체크
 */
$(function(){
	// 아이디 중복체크
	const inputUid = document.getElementsByName('km_uid')[0];
	const uidResult = document.getElementsByClassName('msgId')[0];
	const btnCheckUid = document.getElementById('btnCheckUid');
	
	if(btnCheckUid != null){
		
		btnCheckUid.onclick = function(){
		
			const uid = inputUid.value;
			
			// 아이디 유효성 검사
			if(!uid.match(reUid)){
				uidResult.innerText = '유효한 아이디가 아닙니다.';
				uidResult.style.color = 'red';
				isUidOk = false;
				return;				
			}
			
			// 서버전송
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/Kmarket/member/checkUid.do?uid='+uid);
			xhr.send();
			
			xhr.onreadystatechange = function(){
				
				if(xhr.readyState == XMLHttpRequest.DONE){
					
					if(xhr.status == 200){
						
						const data = JSON.parse(xhr.response);
						
						if(data.result > 0){
							uidResult.innerText = '이미 사용중인 아이디 입니다.';
							uidResult.style.color = 'red';
							isUidOk = false;
						}else{
							uidResult.innerText = '사용 가능한 아이디 입니다.';
							uidResult.style.color = 'green';
							isUidOk = true;
						}
					}
				}// readyState end
			}// onreadystatechange end
		}// btnCheckUid onclick end
	}
	
		
	// 휴대폰 중복체크
	$('input[name=km_hp]').focusout(function(){
		
		const km_hp = $(this).val();
		
		if(!km_hp.match(reHp)){
			$('.msgHp').css('color', 'red').text('휴대폰 번호가 유효하지 않습니다.');
			isHpOk = false;
			return;	
		}
		
		const url = '/Kmarket/member/checkHp.do?hp='+km_hp;
		
		$.get(url, function(result){
			
			const data = JSON.parse(result);
			
			if(data.result > 0){
				$('.msgHp').css('color', 'red').text('이미 사용중인 휴대폰입니다.');
				isHpOk = false;
			}else{
				$('.msgHp').css('color', 'green').text('사용 가능한 휴대폰입니다.');
				isHpOk = true;
			}
			
		});
	});
	
	
});