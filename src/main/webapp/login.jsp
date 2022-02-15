<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<base href="${pageContext.request.contextPath}/">
<head>
    <meta charset="utf-8">
    <title>在线考试后台管理系统</title>
    <%@include file="common.html"%>
    <style>
        div#bg {
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 100%;
            z-index: -10;
            background-position: center 0;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
            -webkit-background-size: cover;
            -o-background-size: cover;
            zoom: 1;
            opacity:1;
            transition: opacity 1s linear;
            -moz-transition: opacity 1s linear;
            -webkit-transition: opacity 1s linear;
            -o-transition: opacity 1s linear;
        }
    </style>
</head>

<body class="gray-bg">
<div id="bg"></div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-6 col-md-offset-3 column">
            <form action="user/login" method="post" class="form-horizontal col-md-6 col-md-offset-3" style="margin-top: 30%">
                <div class="form-group" align="center">
                    <br>
                    <div class="input-group">
                        <h2><span class="glyphicon glyphicon-tower"></span> 在线考试后台系统</h2>
                    </div>
                    <br>
                    <div class="input-group  input-group-lg">
                        <div class="input-group-addon"><span style="color: #c12e2a" class="glyphicon glyphicon-user"></span></div>
                        <input type="text" class="form-control" value="james" required name="userName" placeholder="请输入用户名">
                    </div>
                    <br>
                    <div class="input-group input-group-lg">
                        <div class="input-group-addon"><span style="color: #0E2D5F" class="glyphicon glyphicon-lock"></span></div>
                        <input type="password" class="form-control" value="james" required name="passWord" placeholder="请输入密码">
                    </div>
                    <br>
                    <c:if test="${logInfo}">
                        <div class="form-group" style="color:red;">
                            用户名/密码不正确，请确认后重试。
                        </div>
                        <br>
                    </c:if>

                    <c:if test="${param.logAccess eq true}">
                        <div class="form-group" style="color:red;">
                            请先登录后再尝试其他操作。
                        </div>
                        <br>
                    </c:if>
                    <div class="input-group">
                        <button type="submit" class="btn btn-primary">登录</button>&nbsp;&nbsp;&nbsp;
                        <button type="reset" class="btn btn-primary">重置</button>
                    </div>
                </div>
            </form>


        </div>
        <div class="col-md-3 column">
        </div>
    </div>
</div>

    <!-- Mainly scripts -->
    <script src="static/js/jquery-2.1.1.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $.get('do_rem.jsp',function (json) {
            if(json.status===true){
                $(":checkbox").attr("checked",true);
            }
        },"json")
    });
    var bgImgUrl = 'picture/images/login/{num}.jpg', bgNum,
        bgImgArr = [],
        bgDiv = document.getElementById("bg");
    for (var i=1; i <= 4; i++){
        bgImgArr.push(bgImgUrl.replace('{num}', i));
    }
    setBGimg();
    function setBGimg(d){
        if(!bgNum || bgNum >= bgImgArr.length) bgNum = 0;
        bgDiv.style.opacity = .001;
        setTimeout(function(){
            bgDiv.style.backgroundImage = 'url('+ bgImgArr[bgNum] +')';
            bgNum++;
            bgDiv.style.opacity = 1;
        }, 1000);
        if(typeof d === 'undefined')
            setInterval(function(){setBGimg(true);}, 5000);
    }
</script>
</body>

