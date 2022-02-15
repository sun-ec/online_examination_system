<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<base href="${pageContext.request.contextPath}/">
<html>
<head>
    <meta charset="utf-8">
    <title>在线考试系统教师端</title>
    <%@include file="common.html"%>
</head>
<script>
    function closemodel() {
        document.getElementById("mymodel").style.display="none";
    }
</script>

<body>

    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                    <span>
                        <img  title="考生" class="img-circle" src="picture/tun.jpg" width="70px" />
                    </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="clear">
                            <span class="block m-t-xs">
                                 <strong class="font-bold">${logAdmin.loginName}</strong>
                             </span>
                        </span>
                        </a>
                    </div>
                    <div class="logo-element">
                        菜单
                    </div>
                </li>
                <li>
                    <a href="#"><i class="fa fa-users"></i><span class="nav-label">导航</span></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-database"></i> <span class="nav-label">考试管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="examForm.jsp"><i class="fa fa-plus-square"></i>考试</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-database"></i> <span class="nav-label">用户管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="modifyUserInfo.jsp"><i class="fa fa-plus-square"></i>修改用户信息</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary" href="javascript:void(0)"><i class="fa fa-bars"></i> </a>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">欢迎${logAdmin.loginName}</span>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-sign-out"></i> 登出
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row  border-bottom white-bg dashboard-header">
            <div class="col-sm-12">
                <div class="col-sm-12">
                    <div class="row wrapper border-bottom white-bg">
                        <div class="col-lg-10">
                            <ol class="breadcrumb">
                                <li>
                                    <a href="studentForm.jsp">主页</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0)">用户管理</a>
                                </li>
                                <li class="active">
                                    <strong>修改用户信息</strong>
                                </li>
                            </ol>
                        </div>
                    </div>
                </div>
                <div class="modal-dialog" id="mymodel">
                    <div class="modal-content animated flipInY">
                        <div class="modal-header" style="height: 60px">
                            <span style="text-align: center"><h2>修改用户信息</h2></span>
                            <button onclick="closemodel()" type="button" class="close" data-dismiss="modal" style="position: relative;top: -350px"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                        </div>
                        <div class="modal-body" style="height: 500px">
                            <form action="#" method="post" style="text-align: center;margin-top: 230px">
                                <lable style="position: relative;top:-244px;left: -120px">用户名：</lable><input class="form-control" type="text" disabled="true" style="position: relative;top: -265px;left:178px;height: 27px;width: 182px">
                                <lable style="position: relative;top:-265px;left: -120px">旧密码：</lable><input class="form-control" type="text" style="position: relative;top: -286px;left:178px;height: 27px;width: 182px">
                                <lable style="position: relative;top:-288px;left: -29px">新密码：</lable><input type="text" style="position: relative;top: -287px;left: -30px"><br>
                                <lable style="position: relative;top:-288px;left: -37px">确认密码：</lable><input type="text" style="position: relative;top: -287px;left: -38px"><br>
                                <lable style="position: relative;top:-288px;left: -81px">性别：</lable>
                                <lable style="position: relative;top:-288px;left: -29px">男</lable><input name="sex" type="radio" style="position: relative;top: -287px;left: -30px">
                                <lable style="position: relative;top:-288px;left: -29px">女</lable><input type="radio" name="sex"style="position: relative;top: -287px;left: -30px"><br>
                                <lable style="position: relative;top:-288px;left: -37px">出生日期：</lable><input type="text" style="position: relative;top: -287px;left: -38px"><br>
                                <lable style="position: relative;top:-288px;left: -37px">身份证号：</lable><input type="text" style="position: relative;top: -287px;left: -38px"><br>
                                <lable style="position: relative;top:-288px;left: -22px">手机：</lable><input type="text" style="position: relative;top: -287px;left: -23px"><br>
                                <lable style="position: relative;top:-288px;left: -19px">QQ：</lable><input type="text" style="position: relative;top: -287px;left: -19px"><br>
                                <lable style="position: relative;top:-288px;left: -26px">Email：</lable><input type="text" style="position: relative;top: -287px;left: -27px"><br>
                                <lable style="position: relative;top:-288px;left: -22px">籍贯：</lable><input type="text" style="position: relative;top: -287px;left: -23px"><br>
                                <lable style="position: relative;top:-288px;left: -22px">专业：</lable><input type="text" style="position: relative;top: -287px;left: -23px"><br>
                                <lable style="position: relative;top:-288px;left: -35px">最高学历：</lable>
                                <select name="xueli" id="xueli" style="position: relative;top: -287px;left: -39px;width: 182px">
                                    <option value="0">无</option>
                                    <option value="1">专科</option>
                                    <option value="2">本科</option>
                                    <option value="3">硕士</option></select><br>
                                <lable style="position: relative;top:-288px;left: -37px">毕业院校：</lable><input type="text" style="position: relative;top: -287px;left: -38px"><br>
                                <button onclick="closemodel()"type="button" class="btn btn-white" style="position: relative;top:-240px;left:200px">关闭</button>
                                <button onclick="closemodel()" type="submit" class="btn btn-primary" style="position: relative;top:-240px;left:200px">保存更改</button>
                            </form>
                        </div>
                    </div>
                </div>
              </div>
        </div>
    </div>
    <%@include file="commScript.html"%>
</body>
</html>
