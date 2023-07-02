


var dates;
var suijishu;
$(function () {
    $("#text").blur(function () {
        var reg = /^1[357]\d{9}$/;
        if ($(this).val() == "") {
            $("#phone").html("必须输入手机号码");
        } else if (!reg.test($("#text").val())) {
            $("#phone").html("手机号码格式不正确")
        } else {
            $("#phone").html("")
        }
    })

    $("#yzms").blur(function(){
        if($(this).val() == ""){
            $("#yzmss").html("请输入验证码");
        }else{
            $("#yzmss").html("");
        }
    })


    $("#zhuce").click(function () {
        var text = $("[name=phone]").val();

        var reg = /^1[357]\d{9}$/;
        if ($("#text").val() == "") {
            $("#phone").html("必须输入手机号码");
        } else if (!reg.test($("#text").val())) {
            $("#phone").html("手机号码格式不正确");
        }else if($("#yzms").val() == ""){
            $("#yzmss").html("请输入验证码");
        }else if(document.getElementById("tongyi").checked == false){
            $("xianshi").fadeIn(1000);
        }else if($("#yzms").val() != suijishu){
            $("#yzmss").html("验证码错误");
        }else{
            $("xianshi").fadeOut(1000);
            $("form").submit();
            
        }

    })
    $("#yzm").click(function () {
    	var phone = $("[name=phone]").val();
    	if(!isNaN(phone) && phone != ""){
    		$.post("ZhuCe.do?State=yanzhengs",{"Phone":phone},function (Data){
        		if(Data == "true"){
        			$(this).css("background", "#ccc");
                    miao = 60;
                    $(this).html("请"+miao+"秒后重试");
                    dates = setInterval("jian()",1000);
                    suijishu="";
                    for(var i=0;i<6;i++)
                        suijishu+=Math.floor(Math.random()*10);
                    	/*alert(suijishu);*/
                    	window.frames['j'].location.href = "http://utf8.api.smschinese.cn/?Uid=红领巾儿&Key=89fa7893561ea47640596&smsMob="+$("#text").val()+"&smsText=尊敬的瑶乐购客户，您的验证码是："+suijishu+"，打死也不要告诉别人哦！站长QQ：1973689961     -----------------------------    TY童瑶互联网社区①  QQ群号：822358714    肯定有人会问，TY童瑶互联网社区是干嘛的？TY童瑶互联网社区是中国第一互联网社区，在这里你可以了解学习Java、.Net、Web、Jsp、Asp、大数据、Ai、以及渗透、攻击、拿站欢迎加入学习讨论。";
        		}else{
        			alert("手机号已注册！");
        		}
        	})
    	}else{
    		alert("请输入正确的手机号码");
    	}
    	
    })
})

var miao = 60;

function jian(){
    if(miao==0){
        dates = clearInterval();
        $("#yzm").html("点击获取验证码");
        $("#yzm").css("background", "#ff3366");
    }else{
        miao--;
        $("#yzm").html("请"+miao+"秒后重试");
    }

}


