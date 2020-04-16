(function($){
    var flag1 = 0;
    var flag2 = 0;

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

            if($(this).is("#add")){
                $("span").remove(".add");
                YourProblem = $.trim(this.value);
                if(YourProblem == ""){
                    $parent.append("<span class='add'>物业问题不能为空</span>");
                }else if(YourProblem.length < 6){
                    $parent.append("<span class='add'>物业问题描述不能少于6个字</span>");
                }else{
                    $parent.append("<span class='add' style='color: #666'>物业问题可以提交</span>");
                    flag2 = 1;
                }
            }


        });

        $.fn.success = function(){
            $("#send").click(function(){
                if(flag1 == 1 && flag2 == 1){
                    alert("提交成功！");
                }
                $("span").remove();
            })
        }
    }
})(jQuery);