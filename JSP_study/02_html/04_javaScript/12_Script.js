       function fo()
       {
             document.myform.name.focus();
       }//fo() end
       //--------------------
       function check() {
             name=document.myform.name.value;
            
             if(name==""){
                    alert("이름을 입력하시요");
                    document.myform.name.focus();//포커스 설정
                    return;
             }
             id=document.myform.id.value;
             if(document.myform.id.value==""){
                    alert("ID을 입력하시요");
                    document.myform.id.focus();//포커스 설정
                    return;
             }
            
             pwd=document.myform.pwd.value;
             if(pwd==""){
                    alert("암호를 입력하시요");
                    document.myform.pwd.focus();//포커스 설정
                    return;
             }
            
             pwd2=document.myform.pwd2.value;
             if(pwd2==""){
                    alert("암호확인를 입력하시요");
                    document.myform.pwd2.focus();//포커스 설정
                    return;
             }
            
             if(pwd!=pwd2){
                    alert("암호와 암호확인 같은 문자를 넣어 주세요")
                    document.myform.pwd.value="";
                    document.myform.pwd2.value="";
                    document.myform.pwd.focus();
                    return;
             }
              
             jumin1=document.myform.jumin1.value;
             if(jumin1==""){
                    alert("주민번호를  입력하시요");
                    document.myform.jumin1.value="";
                    document.myform.jumin1.focus();//포커스 설정
                    return;
             }
        
           jumin2=document.myform.jumin2.value;
             if(jumin2==""){
                    alert("주민번호를  입력하시요");
                    document.myform.jumin2.value="";
                    document.myform.jumin2.focus();//포커스 설정
                    return;
             }
            
             if(!document.myform.email.value){
                    alert(" 이메일을 입력 하시요")
                    document.myform.email.focus();
                    return;
             }
             if(document.myform.fro.value==""){
                    alert(" 소개 부분을 입력 하시요")
                    document.myform.fro.focus();
                    return;
             }
            
             alert("당신의 이름:" +name+"\n당신의 아이디:"+id)
       }//check() end
