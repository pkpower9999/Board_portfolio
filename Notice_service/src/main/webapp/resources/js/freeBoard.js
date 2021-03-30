$(function(){
    let offset = getParam("offset");
    
    let curPage = (Number(offset)/15);
    let pageCnt = 0;
    $.ajax({
        url:"/api/postCount?board_seq=3",
        type:"get",
        success:function(data){
            console.log(data);

            pageCnt = Math.ceil(data.count/15);
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
                
                if(offset == i*15){
                    template='<a href="/freeBoard?offset='+i*15+'" class="current">'+(i+1)+'</a>';

                }
                else {
                    template='<a href="/freeBoard?offset='+i*15+'">'+(i+1)+'</a>';

                }
                
                $(".pagers").append(template);
                if(i-start == 8){
                    break;
                }
            }
        }
    })

    $("#prev_page").click(function(){
        let newOffset = offset - 15;
        if(newOffset < 0) return;
        location.href="/freeBoard?offset="+newOffset;
    })  // 1개씩 이전
    $("#next_page").click(function(){
        let newOffset = Number(offset) +15;
        console.log(newOffset, pageCnt);
        if(newOffset/15 >= pageCnt) return;
        location.href="/freeBoard?offset="+newOffset;

    })
    $("#prev_10").click(function(){
        let newOffset = offset - 150;
        if(newOffset < 0) newOffset = 0;
        location.href="/freeBoard?offset="+newOffset;
    }) //10개씩 이전
    $("#next_10").click(function(){
        let newOffset = Number(offset) + 150;
        if(newOffset/15 >= pageCnt) newOffset = (pageCnt-1)*15;
        location.href="/freeBoard?offset="+newOffset;
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