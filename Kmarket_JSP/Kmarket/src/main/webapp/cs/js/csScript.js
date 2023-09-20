/**
 * 
 */

 function selectCateDetail(){
	 
	 const selectList = $('#cateDetail').val();
	 
	 const jsonData={
		 "selectList" : selectList
	 }
	 
	 $.ajax({
		 url: '/Kmarket/cs/qna/write.do',
		 type: 'GET',
		 data: jsonData,
		 dataType:'json',
		 success: function(data){
			 
			 const selectDetailView = $('#selectDetailView');
			 
			 //옵션추가
			 selectDetailView.append($('<option>',{
				    value: '',
                    text: '2차 분류 선택',
                    disabled: 'disabled',
                    selected: 'selected'
				 
			 }));
			 
			 //db를 통한 데이터 옵션 생성
			 $.each(data, function(index, item){
				 selectDetailView.append($('<option>',{
						value: item.aeName,
                        text: item.dName 
				 }));
				 
			 });
			 
		 }
		 
	 });
	 
	 
 }