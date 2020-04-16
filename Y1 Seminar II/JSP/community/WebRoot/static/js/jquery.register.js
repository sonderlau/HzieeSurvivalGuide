(function($){
    var flag1 = 0;
    var flag2 = 0;
    var flag3 = 0;

    $.fn.check = function(){
        $("form :input").blur(function(){
            var $parent = $(this).parent();
            if($(this).is("#username")){
                $("span").remove(".name");
                var YourName = $.trim(this.value);
                var str1 = /[~#^$@%&!*()<>:;'"{}【】  ]/;
                if(YourName == ""){
                    $parent.append("<span class='name'>用户名不能为空</span>");
                }else if(str1.test(YourName) == true){
                    $parent.append("<span class='name'>用户名不能包含特殊字符</span>");
                }else{
                    $parent.append("<span class='name' style='color: #666'>用户名可以使用</span>");
                    flag1 = 1;
                }
            }

            if($(this).is("#password")){
                $("span").remove(".pwd");
                YourPassword = $.trim(this.value);
                if(YourPassword == ""){
                    $parent.append("<span class='pwd'>密码不能为空</span>");
                }else if(YourPassword.length < 6){
                    $parent.append("<span class='pwd'>密码长度不能少于6位</span>");
                }else{
                    $parent.append("<span class='pwd' style='color: #666'>密码可以使用</span>");
                    flag2 = 1;
                }
            }

            if($(this).is("#checkPassword")){
                $("span").remove(".check");
                var YourCheckPassword = $.trim(this.value);
                if(YourCheckPassword != $.trim($("#password").val())){
                    $parent.append("<span class='check'>两次密码不相同</span>");
                }else{
                    $parent.append("<span class='check' style='color: #666'>两次密码相同</span>");
                    flag3 = 1;
                }
            }

        });

//        $.fn.success = function(){
            $("#send").click(function(){
                if(flag1 == 1 && flag2 == 1 && flag3 == 1){
                    alert("注册成功！");
                }else{
                	alert("注册失败！");
                }
                $("span").remove();
            })
//        }
    }
})(jQuery);