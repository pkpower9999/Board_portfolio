$(function(){
    let offset = getParam("offset");
    
    let curPage = (Number(offset)/10);
    let pageCnt = 0;
    $.ajax({
        url:"/api/postCount?board_seq=2",
        type:"get",
        success:function(data){
            console.log(data);

            pageCnt = Math.ceil(data.count/10);
            console.log(pageCnt);
            $(".pagers").html(""); // .pagers 내부 HTML 삭제
            let start = 0;
            if(curPage - 4 >= 0){
                start = curPage-4;
            }
            else {
                start = 0;
            }
            
            for(let i=start; i<pageCnt; i++){
                let template;
                
                if(offset == i*10){
                    template='<a href="/notice?offset='+i*10+'" class="current">'+(i+1)+'</a>';

                }
                else {
                    template='<a href="/notice?offset='+i*10+'">'+(i+1)+'</a>';

                }
                
                $(".pagers").append(template);
                if(i-start == 8){
                    break;
                }
            }
        }
    })

    $("#prev_page").click(function(){
        let newOffset = offset - 10;
        if(newOffset < 0) return;
        location.href="/notice?offset="+newOffset;
    })  // 1개씩 이전
    $("#next_page").click(function(){
        let newOffset = Number(offset) +10;
        console.log(newOffset, pageCnt);
        if(newOffset/10 >= pageCnt) return;
        location.href="/notice?offset="+newOffset;

    })
    $("#prev_10").click(function(){
        let newOffset = offset - 100;
        if(newOffset < 0) newOffset = 0;
        location.href="/notice?offset="+newOffset;
    }) //10개씩 이전
    $("#next_10").click(function(){
        let newOffset = Number(offset) + 100;
        if(newOffset/10 >= pageCnt) newOffset = (pageCnt-1)*10;
        location.href="/notice?offset="+newOffset;
    })

})

function getParam(sname) {

    var params = location.search.substr(location.search.indexOf("?") + 1);

    var sval = "";

    params = params.split("&");

    for (var i = 0; i < params.length; i++) {

        temp = params[i].split("=");

        if ([temp[0]] == sname) { sval = temp[1]; }

    }

    return sval;

}