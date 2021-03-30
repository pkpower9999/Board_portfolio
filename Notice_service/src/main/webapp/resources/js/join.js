$(function(){
	$("#join_btn").click(function(){
		let dupCheck = false;


		if($("user_id").val() == ""){
			alert("아이디를 입력해주세요");
			return;
		}
		if($("#user_email").val() == ""){
			alert("메일주소를 입력해주세요");
			return;
		}
		if($("#user_pwd").val() == ""){
			alert("비밀번호를 입력해주세요");
			return;
		}
		else{
			if($("#user_pwd").val() != $("#user_pwd_confirm").val()){
				alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
				return;
			}
		}

		let userData = {
			"ui_id": $("#user_id").val(),
			"ui_pwd": $("#user_pwd").val(),
			"ui_name":$("#user_name").val(),
            "ui_email":$("#user_email").val(),
            "ui_blog":$("#user_blog").val(),
            "ui_profile_img":$("#user_pf_img").val(),
            "ui_introduce":$("#user_pf_msg").val(),
		}
		$.ajax({
			url:"/api/userAdd",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(userData),
			success:function(data){
				console.log(data);
				alert("가입되었습니다.");
				history.back();

			},
			error:function(data){
				alert("에러");
			}

		})

	
	})

	$("#id_dup_chk").click(function(){
		if($("#user_id").val() == ""){
			alert("아이디를 입력해주세요");
			return;
		}
		if($("#user_id").val().legth < 4){
			alert("아이디는 4글자 이상 입력해주세요");
			return;
		}

		let data = {
			ui_id:$("#user_id").val()
		}

		$.ajax({
			url:"/api/userchk",
			type:"post",
			contentType:"application/json",
			resultType:"json",
			data:JSON.stringify(data),
			success:function(data){
				console.log(data);
				dupCheck = !data.result;
				if(data.result == true){
					$(".err_msg").html("["+$("#user_id").val()+"]은/는 이미 가입된 아이디입니다. ");
					$(".err_msg").addClass("err").removeClass("ok");
				}
				else {
                    $(".err_msg").html("["+$("#user_id").val()+"]은/는 가입가능한 아이디입니다.");
                    $(".err_msg").addClass("ok").removeClass("err");
                }
			},
			error:function(data) {
                alert("에러 발생");
                console.log(data);
            }

		})

		
	})

	$("#user_id").keyup(function(){
		$(".err_msg").html("");
		dupCheck = false;
	})
})