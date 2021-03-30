//login.js
$(function () {
    $("#login_btn").click(function () {
        let id = $("#user_name").val();
        let pwd = $("#user_pwd").val();

        let loginData = {
            id: id,
            pwd: pwd
        }

        $.ajax({
            url: "/api/login",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(loginData),
            success: function (data) {
                if (data.result == true) {
                    location.href = "/";
                    history.back();
                }
                else {
                    alert("아이디 또는 비밀번호 오류입니다");
                }
            },
            error: function () {
                alert("에러");
            }
        })
    })
    $("#user_pwd").keydown(function (e) {
        // 코드로 #login_btn 클릭하는것
        if (e.keyCode == 13) {
            $("#login_btn").trigger("click");
        }
    })
})