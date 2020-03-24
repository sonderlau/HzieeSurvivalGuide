//界面尺寸修正
(function () {
    var doc = document,
        win = window,
        oBody = doc.documentElement || doc.body,
        resize = "onorientationchange" in win ? "orientationchange" : "resize";
    rem();
    addEventListener(resize, rem, false);
    function rem() {
        oBody.style.fontSize = 100 * (doc.body.clientWidth / 767) + "px";
    }
})();

/*下拉菜单*/
var aLi = $(".navbar-nav>li");
var dW = $(".my-dropdown");
aLi.each(function (i) {
    if(i===0) return;
    $(this).hover(
        function () {
            console.log(i);
            dW.eq(i-1).stop(true).show(500);
            dW.css({
                background: "#58406f",
                color: "#fff"
            });
        },function () {
            dW.eq(i-1).stop(true).hide(500);
            dW.css({
                background: "#fff",
                color: "#58406f"
            });
        });

});

/*swiper轮播*/
var mySwiper = new Swiper ('.swiper-container', {
    loop: true,
    autoplay: 3000,
    // 如果需要分页器
    pagination: '.swiper-pagination',

    // 如果需要前进后退按钮
    nextButton: '.swiper-button-next',
    prevButton: '.swiper-button-prev',

    // 如果需要滚动条
    // scrollbar: '.swiper-scrollbar',
    scrollbarHide: false,
    scrollbarDraggable: true,
    paginationClickable: true,
})
