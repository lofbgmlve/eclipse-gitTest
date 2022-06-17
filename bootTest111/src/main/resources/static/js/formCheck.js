$(function(){
	// 유효성 검사 
	//e.preventDefault();
	// 한글성명 
     $("#name").on("keyup", function(){
		var check_kor = /[^ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		if(check_kor.test($(this).val())){
			alert("한글만 입력할 수 있습니다.!!! 한글만");
			$(this).val($(this).val().replace(check_kor,""));
		}
	});
	// 아이디는 영문만.  - OK 
	$("#id").on("keyup", function(){ 
		var check_char = /[^A-Za-z0-9]/gi;
		if(check_char.test($(this).val())){
			alert("영문 대소문자, 숫자만 입력할 수 있습니다.");
			$(this).val($(this).val().replace(check_char,""));
		}
	});
	
	// 영문이름 - 유효성 -Ok
	$("#engName").on("keyup", function(){ 
		var check_eng = /[^A-Za-z]/gi;
		if(check_eng.test($(this).val())){
			alert("영문 대소문자만 입력할 수 있습니다.");
			$(this).val($(this).val().replace(check_eng,""));
		}
	}); 
	
	//email  - Ok
	$("#email").on("keyup", function(){ 
		var check_eng = /[^A-Za-z0-9]/gi;
		if(check_eng.test($(this).val())){
			alert("영문 대소문자, 숫자만 입력할 수 있습니다.");
			$(this).val($(this).val().replace(check_eng,""));
		}
	}); 
	
	
	// 연령 -Ok
	$("#years").on("keyup", function(){
		var check_num  = /[^0-9]+$/
		if(check_num.test($(this).val())){
			alert("숫자만 입력할 수 있습니다.");
			$(this).val($(this).val().replace(check_num, ""));
		} 
	});
	
	//주민번호 -OK
	$("#regNo").on("keyup", function(){
		var check_num  =  /[^0-9]/;
		if( check_num.test($(this).val())){
			alert("숫자만 입력할 수 있습니다.");
			$(this).val($(this).val().replace(check_num, ""));
		}
	});
	
	// 전화번호- Ok 
	$("#phone").on("keyup", function(){
		var check_num  =  /[^0-9]/;
		if( check_num.test($(this).val())){
			alert("숫자만 입력할 수 있습니다.");
			$(this).val($(this).val().replace(check_num, ""));
		}
	});
	
	// 핸드폰번호- Ok 
	$("#hp").on("keyup", function(){
		var check_num  =  /[^0-9]/;
		if( check_num.test($(this).val())){
			alert("숫자만 입력할 수 있습니다.");
			$(this).val($(this).val().replace(check_num, ""));
		}
	});
	// 연봉 - 숫자
	$("#salary").on("keyup", function(){
		var check_num  =  /[^0-9]/;
		if( check_num.test($(this).val())){
			alert("숫자만 입력할 수 있습니다.");
			$(this).val($(this).val().replace(check_num, ""));
		}
	});
	
	
	// 주민번호 하이픈(-, *** ) 
	
	
	//***** 숫자 ', ' 넣기 
	$("#salary").on("keyup", function(){
      var salary = $("#salary").val();
      $("#salary").val(addComma(salary));
      parseInt(salary.replace(/,/g,''));
		
   });
   
   
   var salary = $("#salary").val();
   $("#salary").val(addComma( deleteComma(salary)));
   
   // 콤마 추가하기
   function addComma(salary){
     var regExp = /\B(?=(\d{3})+(?!\d))/g;
	 return salary.toString().replace(regExp, ',');

	}
	
	// 콤마 제거하기 
	function deleteComma(salary){
		var regEx = String (salary);
		return regEx.replace(/[^\d]+/g, '');
	}
	

	$("#milYn").change(function(){
		
		var select = $('option:selected' , this).text();
		console.log(select);
		
		if(select =="미필"){
			
			$("#milStartdate").attr('disabled', true);
			$("#milEnddate").attr('disabled', true);
			$("#milType").attr('disabled', true);
			$("#milLevel").attr('disabled', true);
			
			
		}else if(select =="군필"){
		
			$("#milStartdate").attr('disabled', false);
			$("#milEnddate").attr('disabled', false);
			$("#milType").attr('disabled', false);
			$("#milLevel").attr('disabled', false);
			
		}
	});
	
	
	
	

	
	//  이메일 입력 셀릭트 박스
	$("#selectDomain").on("change", function(){
		var str = $(this).val();
		
		if(str== "직접입력"){
			$("#emailDomain").val();
			$("#emailDomain").prop("readonly", false);
		}else if(str == "네이버"){
			$("#emailDomain").val("naver.com");
			$("#emailDomain").prop("readonly", true);
		}else if(str== "다음"){
			$("#emailDomain").val("daum.net");
			$("#emailDomain").prop("readonly", true);
		}else if(str == "지메일"){
			$("#emailDomain").val("gmail.com");
			$("#emailDomain").prop("readonly", true);
		}
	});
	
	
	// 폼체크 전체 유효성 검사 
	// 사번,아이디, 이름 ,비밀번호, 이메일, ,*비밀번호확인, *입사일자
	$("#insaWriteForm").on("submit", function(){
		if($("#name").val().length <=0 ){
			alert("한글이름이 입력되지 않았습니다.\n한글이름을 입력해주세요.");
			$("#email").focus();
			return false;
		}
		if($("#email").val().length <=0 ){
			alert("이메일 아이디가 입력되지 않았습니다.\n이메일 아이디를 입력해주세요.");
			$("#email").focus();
			return false;
		}
		if($("#sabun").val().length <=0){
			alert("사번이 입력되지 않았습니다. \n 사번을 입력해주세요");
			$("#sabun").focus();
			return false;
		}
		if($("#id").val().length<= 0){
			alert("아이디가 입력되지 않았습니다\n 아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}
		if($("#pwd1").val().length <= 0){
			alert("비밀번호가 입력되지 않았습니다.\n 비밀번호를 입력해주세요");
			$("#pwd1").focus();
			return false;
		}
		if($("#pwd2").val().length <= 0){
			alert("비밀번호가 입력되지 않았습니다.\n 비밀번호를 입력해주세요");
			$("#pwd2").focus();
			return false;
		}
		if($("#hp").val().length <= 0){
			alert("핸드폰 번호를 입력하지 않았습니다.\n 핸드폰번호를 입력해주세요.");
			$("#hp").focus();
			return false;
		}
		if($("#joinDay").val().length <= 0){
			alert("입사일이 입력되지 않았습니다.\n입사일을 입력해주세요");
			$("#joinDay").focus();
			return false;
		}
		
		if($("#emailDomain").val().length <=0 ){
			alert("이메일주소를 입력되지 않았습니다.\n이메일주소 입력해주세요.");
			$("#emailDomain").focus();
			return false;
		}
		// 연봉이 db에 들어갈 때, 콤마를 삭제하고 들어가게 하기.
		if($("#salary").val().length >= 0 ){
		var salary = $("#salary").val();
		 $("#salary").val(subComma(salary));
		}

		
		
		
	}); // insaWriteFrom  submit유효성 검사
	
	// 주민번호로 만 나이 구하기. 
	$("#regNo").on("blur", function(){
		var regNo = $("#regNo").val();
		var dateObj = new Date();  // 날짜구하는 객체
		var Year = dateObj.getFullYear();
		console.log("Year : " +Year);
		var curDate = "";
		var tmpAge = 0; // 임시 나이 지정 
		// var curYear = dateObj.getYear() ;
		
		
		var curMonth = dateObj.getMonth() +1; // 현재 월
		console.log("curMonth :" + curMonth)
		

		var regNo = $("#regNo").val(); // 주민번호 값 
		var sex = regNo.substr(6,1);  // 2 or 1 
		
		if(curMonth <10){ 
			curMonth = "0" + curMonth ;
		}
		 
		var curDay = dateObj.getDate();  // 현재 날짜 
		if(curDay < 10){
			curDay = "0" + curDay;  // 123456789 일일떄 = 01일기입
		}
		
		curDate = Year + curMonth + curDay;  // 현재일자 구하기
		console.log("curDate : " +curDate);
		
		
		//  성별자리가 1, 2인지 
		if(sex <= 2){
			tmpAge = Year-(1900 +parseInt(regNo.substring(0,2)));
			console.log("tmpAge : " + tmpAge);
		}else{  // 성별자리가 3,4 인지 
			tmpAge = Year -(2000 + parseInt(regNo.substr(0,2)));
			console.log(tmpAge);
		}
		
		var tmpBirthday = regNo.substring(2,6);  // 1900년대인지 2000년대인지 
		console.log("tmpBirthday : " + tmpBirthday);
		
		if(curDate > (Year + tmpBirthday)){
			tmpAge += 1;
			console.log("tmpAge :" +tmpAge);
			$("#years").val(tmpAge);  // 나이 입력
		} else {
			tmpAge;
			console.log(tmpAge);
			$("#years").val(tmpAge);  // 나이입력!
		}
		
		
		// * 주민번호 받아서 - 성별 바꾸기 
		if(sex =="2" || sex =="4"){
			$("#sex option[value='여자']").attr("selected", true) ;
			console.log("sexif24 : "+sex);
			
			} else if(sex == "1" ||sex== "3" ) {
			$("#sex option[value='남자']").attr("selected", true) ;
				console.log("sexif13 : "+sex);
				console.log("남자");
		}
		
	});  // 주민번호 !! 
	
	
	
	
	
	//if(sex ==2 && 4){
	//	$("#sex").$('selected:option'("여자"));
	//} else {
	//	$("#sex").$('selected:option'("남자"));
	//}
	
	// 비밀번호 확인
	// *** pwd2 의 커서가 떠나면 비밀번호확인 function 이 진행된다.  - Ok
	$("#pwd2").on("keyup", function(){
		var pwd1 = $("#pwd1").val();
		var pwd2 = $("#pwd2").val();
		if(pwd1.length == pwd2.length){
			if(pwd1 == pwd2 ){
				
				alert("비밀번호가 확인되었습니다.");
			}else{
				alert("비밀번호가 확인되지 않습니다. 비밀번호를 다시 확인해주시기 바랍니다.");
				$("#pwd2").val("");
				$("#pwd2").focus();
				console.log("pwd1 : " +pwd1);
				console.log("pwd2 : "+ pwd2);
				return false;
			
			}
		}
	});
	
	//function pwdCheck(){
	//	var pwd1 = $("#pwd1").val();
	//	var pwd2 = $("#pwd2").val();
	
	//	if(pwd1 == pwd2){
	//		alert("비밀번호가 확인되었습니다.");
	//	}else{
	//		alert("비밀번호가 확인되지 않습니다. 비밀번호를 다시 확인해주시기 바랍니다.");
	//	}
	//}
	

	// 우편번호 - ok
	$("#btnZipFind").click(findZip);

  function findZip() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

				if(data.userSelectedType ==='R'){
					roadAddr =data.roadAddress;
				} else {
					
					roadAddr = data.roadAddress;
				}
				
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.userSelectedType ==='R'){
	
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
                	roadAddr += extraRoadAddr;
				}
               
               $("#zip").val(data.zonecode);
               $("#addr1").val(roadAddr);
               $("#addr2").focus();
            }
        }).open();
    }  //findZipCode end
  	
  	
  	
  
	// var sex =$("#sex option").sex($("#sex option:seleted"));
	
	
	

	


	function insertInsaAjax (insaWriteForm){
	// var sabun = $("#subun").val();
	
	var params = {
		sabun : $("#sabun").val(),
		joinDay : $("#joinDay").val(),
		retireDay :$("#retireDay").val(),
		putYn:$("#putYn").val(),
		name:$("#name").val(),
		regNo:$("#regNo").val(),
		engName:$("#engName").val(),
		phone:$("#phone").val(),
		hp:$("#hp").val(),
		carrier:$("#carrier").val(),
		posGbnCode:$("#posGbnCode").val(),
		cmpRegNo:$("#cmpRegNo").val(),
		sex:$("#sex").val(),
		years1 : $("#years").val(),
		email:$("#email").val() + "@"+$("#emailDomain").val(),
		zip:Number($("#zip").val()),
		addr1:$("#addr1").val(),
		addr2:$("#addr2").val(),
		deptCode:$("#deptCode").val(),
		joinGbnCode:$("#joinGbnCode").val(),
		id:$("#id").val(),
		pwd:$("#pwd1").val(),
		salary:$("#salary").val(),
		kosaRegYn:$("#kosaRegYn").val(),
		kosaClassCode:$("#kosaClassCode").val(),
		milYn:$("#milYn").val(),
		milType:$("#milType").val(),
		milLevel:$("#milLevel").val(),
		milStartdate:$("#milStartdate").val(),
		milEnddate:$("#milEndate").val(),
		joinType:$("#joinType").val(),
		gartLevel:$("#gartLevel").val(),
		selfIntro:$("#selfIntro").val(),
		crmName:$("#crmName").val(),
		profileImage:$("#profileImage").val(),
		carrierImage:$("#carrierImage").val()
	};
	
	
	$.ajax({
		url:"writeProcess",
		//contentType:"application/json",
		type:"post",
		data:params,
		// dataType:"json",
		success:function(res){
			console.log("Success --res : " + res);
			console.log(params);
			
			if(res=="insert"){
				alert("인사정보가 등록되었습니다. ");	
				//console.log(sabun);
				console.log("insert 성공"); 
				
			}else if(res=="update"){
				alert("인사정보가 수정되었습니다.");
				console.log("update 성공");				
			}

		},
		error:function(){
			console.log("Error --insertInsaAjax !!!");
			alert("Error --insertInsaAjax !!!");
		}
	});
	
	} // insertInsa




	// 저장 버튼 눌렀을 때 일어나는 이벤트 
	$("#save").on("click" , function(){
		// 콤마 제거하기
		if($("#salary").val().length > 0 ){
		var salary = $("#salary").val();
		 $("#salary").val(deleteComma(salary));
		} else{
			$("#salary").val(0);
		}
		
		insertInsaAjax($(this).attr("id"));
	});





	//검색Ajax
	function searchAjax(){
		
		
	}// end searchAjax 




	// 검색 버튼 눌렀을 때 ! 
	$("#search").on("click",function(){
		
		
		
	});



});  // function end


		