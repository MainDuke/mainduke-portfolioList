
	function loginCheck(){
			
		if($("#mem_id").val()==""){
			alert("아이디를 입력해 주세요.");
			$("#mem_id").focus();
			return;
		}
		
		if($("#mem_passwd").val()==""){
			alert("비밀번호를 입력해 주세요.");
			$("#mem_passwd").focus();
			return;
		}
		
		//alert($("#mem_id").val());
		//alert($("#mem_passwd").val);
		document.login.submit();
	}
	

	function memberReg(){
		document.location="Register.jsp";
	}
	
	function inputCheck(){
		if($("#mem_id").value==""){
			alert("아이디를 입력해 주세요.");
			$("#mem_id").focus();
			return;
		}
		if($("#mem_passwd").value==""){
			alert("비밀번호를 입력해 주세요.");
			$("#mem_passwd").focus();
			return;
		}
		if($("#mem_repasswd").value==""){
			alert("비밀번호를 확인해 주세요");
			$("#mem_repasswd").focus();
			return;
		}
		if($("#mem_name").value==""){
			alert("이름을 입력해 주세요.");
			$("#mem_name").focus();
			return;
		}
		if($("#mem_num1").value==""){
			alert("주민번호을 입력해 주세요.");
			$("#mem_num1").focus();
			return;
		}
		if($("#mem_num2").value==""){
			alert("주민번호을 입력해 주세요.");
			$("#mem_num2").focus();
			return;
		}
		if($("#mem_email").value==""){
			alert("이메일을 입력해 주세요.");
			$("#mem_email").focus();
			return;
		}
		if($("#mem_phone").value==""){
			alert("연락처를 입력해 주세요.");
			$("#mem_phone").focus();
			return;
		}
		if($("#mem_job").value=="0"){
			alert("직업을 선택해 주세요.");
			$("#mem_job").focus();
			return;
		}
		
		if($("#mem_passwd").value != $("#mem_repasswd").value){
			alert("비밀번호가 일치하지 않습니다.");
			$("#mem_repasswd").focus();
			return;
		}

		var jumin1=regForm.mem_num1.value;
		var jumin2=regForm.mem_num2.value;
		var jumin=jumin1+jumin2;
		var index="234567892345";
		var total=0;
		for(var i=0;i<12;i++)
			total+=parseInt(jumin.charAt(i)*index.charAt(i));

		total=11-total%11;
		if(total==10)
			total=0;
		else if(total==11)
			total=1;

		if(total!=jumin.charAt(12))
		{
			alert("주민번호를 다시 확인하세요.");
			document.regForm.mem_num1.value="";
			document.regForm.mem_num2.value="";
			document.regForm.mem_num1.focus();
			return;
		}

		if(document.regForm.mem_email.value==""){
			alert("이메일을 입력해 주세요.");
			document.regForm.mem_email.focus();
			return;
		}

		var str=document.regForm.mem_email.value;	   
		var atPos = str.indexOf('@');
		var atLastPos = str.lastIndexOf('@');
		var dotPos = str.indexOf('.'); 
		var spacePos = str.indexOf(' ');
		var commaPos = str.indexOf(',');
		var eMailSize = str.length;
		if (atPos > 1 && atPos == atLastPos && 
		   dotPos > 3 && spacePos == -1 && commaPos == -1 
		   && atPos + 1 < dotPos && dotPos + 1 < eMailSize);
		else {
			  alert('E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요!');
			  document.regForm.mem_email.focus();
			  return;
		}

		document.regForm.submit();
	}
	
	function idCheck(id){
		if(id == ""){
			alert("아이디를 입력해 주세요.");
			document.regForm.mem_id.focus();
		}else{
			url="IdCheck.jsp?mem_id=" + id;
			window.open(url,"post","width=300,height=150");
		}
	}
	
	function zipCheck(){
			url="ZipCheck.jsp?check=y";
			window.open(url,"post","toolbar=no ,width=500 ,height=300 ,directories=no,status=yes,scrollbars=yes,menubar=no");
	}

	//          proBean.getPro_no()
	function productDetail(icode) {
				document.detail.code.value=icode;//////
		//document.detail.action="ProductDetail.jsp";
		document.detail.submit();
	}
	

	function cartUpdate(form){
		alert("update");
		alert(eval(form));
		form.flag.value="update";
		alert(form.flag.value);
		form.submit();
	}
	
	function cartDelete(form) {
		alert("delete");
		alert(eval(form));
		form.flag.value="del";
		
		alert(form.flag.value);
		form.submit();
	}

	function del(id) {
		var tmp;
		tmp=confirm("탈퇴하시겠습니까?");
		if(tmp){
			document.location="MemberDelete.jsp?mem_id="+id;
		}
	}