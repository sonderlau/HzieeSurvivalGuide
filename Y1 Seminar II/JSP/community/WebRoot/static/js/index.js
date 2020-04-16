var i=0;
var Timer;
$(function(){
    $(".picImg").eq(0).show().siblings().hide();   //默认第一张图片显示，其他的隐藏
    //自动轮播
    TimerBanner();
    //点击横框

    $(".tabs li").hover(function(){  //鼠标移动上去
        clearInterval(Timer); //让计时器暂时停止   清除计时器
        i = $(this).index();   //获取该圈的索引
        showPic();           //调用显示图片的方法，显示该索引对应的图片
    },function(){  //鼠标离开
        TimerBanner();    //继续轮播   计时器开始
    });
    // //点击左右按钮
    // $(".btn1").click(function(){
    //     clearInterval(Timer);
    //     i--;   //往左
    //     if(i == -1){
    //         i = 4;
    //     }
    //     showPic();
    //     TimerBanner();
    // });
    // $(".btn2").click(function(){
    //     clearInterval(Timer);
    //     i++;   //往右
    //     if(i == 5){
    //         i = 0;
    //     }
    //     showPic();
    //     TimerBanner();
    // });
});
//轮播部分
function TimerBanner(){
    Timer = setInterval(function(){
        i++;
        if(i == 4){
            i = 0;
        }
        showPic()
    },10000);
}
//显示图片
function showPic(){
    $(".picImg").eq(i).show().siblings().hide();
    $(".tabs li").eq(i).addClass("bg").siblings().removeClass("bg");
}

$(function () {
    $("#leftLabel").hover(function () {
        $("#leftLabel").css("box-shadow","0 3px 15px 0 rgba(224,224,224,.5)");
    },function () {
        $("#leftLabel").css("box-shadow","200px 200px 15px 0 rgba(255,255,255,.1)");
    });
    $("#rightLabel").hover(function () {
        $("#rightLabel").css("box-shadow","0 3px 15px 0 rgba(224,224,224,.5)");
    },function () {
        $("#rightLabel").css("box-shadow","200px 200px 15px 0 rgba(255,255,255,.1)");
    });
});

//模块标题消失
// $(function () {
//     let old = "";
//     $(".leftWord").hover(function () {
//         $(".leftWord").remove();
//     },function () {
//         $(".leftImg").before(old);
//     })
// });

