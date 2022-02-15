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

<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                    <span>
                        <img title="在线考试后台管理员" class="img-circle" src="picture/tun.jpg" width="70px"/>
                    </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="clear">
                            <span class="block m-t-xs">
                                 <strong class="font-bold">${logAdmin.loginName}</strong>
                             </span>
                        <span class="text-muted text-xs block">系统管理员 <b class="caret"></b></span>
                        </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="#">编辑</a></li>
                            <li><a href="#">登出</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        菜单
                    </div>
                </li>
                <li>
                    <a href="#"><i class="fa fa-users"></i><span class="nav-label">导航</span></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-database"></i> <span class="nav-label">考试管理</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="examForm.jsp"><i class="fa fa-plus-square"></i>考试</a></li>
                        <li><a href="subItemForm.jsp"><i class="fa fa-plus-square"></i>主观题阅卷</a></li>
                        <li><a href="resultsView.jsp"><i class="fa fa-plus-square"></i>查看成绩</a></li>
                        <li><a href="papersMaintain.jsp"><i class="fa fa-plus-square"></i>考卷维护</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-plus-square"></i> <span class="nav-label">试题新增</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="addSingleChoiceForm.jsp"><i class="fa fa-plus-square"></i>新增单选题</a></li>
                        <li><a href="addMultipleChoiceForm.jsp"><i class="fa fa-plus-square"></i>新增多选题</a></li>
                        <li><a href="addJudgeForm.jsp"><i class="fa fa-plus-square"></i>新增判断题</a></li>
                        <li><a href="addShortAnswerForm.jsp"><i class="fa fa-plus-square"></i>新增简答题</a></li>
                        <li><a href="addProgrammingForm.jsp"><i class="fa fa-plus-square"></i>新增编程题</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-book"></i> <span class="nav-label">试题查询</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="singleSelectForm.jsp"><i class="fa fa-file-text"></i>单选题查询</a></li>
                        <li><a href="multipleSelectForm.jsp"><i class="fa fa-newspaper-o"></i>多选题查询</a></li>
                        <li><a href="judgeSelectForm.jsp"><i class="fa fa-newspaper-o"></i>判断题查询</a></li>
                        <li><a href="shortSelectForm.jsp"><i class="fa fa-newspaper-o"></i>简答题查询</a></li>
                        <li><a href="programSelectForm.jsp"><i class="fa fa-newspaper-o"></i>编程题查询</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-sitemap"></i> <span class="nav-label">分类管理</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="courseName.jsp"><i class="fa fa-plus-square"></i>课程名</a></li>
                        <li><a href="knowledgePoint.jsp"><i class="fa fa-plus-square"></i>知识点</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class=" fa fa-database"></i> <span class="nav-label">用户管理</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="batchImportUser.jsp"><i class="fa fa-plus-square"></i>批量导入用户</a></li>
                        <li><a href="batchModifyUser.jsp"><i class="fa fa-plus-square"></i>批量修改用户</a></li>
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
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary" href="javascript:void(0)"><i
                            class="fa fa-bars"></i> </a>
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
                <div class="col-sm-9 col-md-offset-2">
                    <div class="row wrapper border-bottom white-bg">
                        <div class="col-lg-10">
                            <ol class="breadcrumb">
                                <li>
                                    <a href="teacherForm.jsp">主页</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0)">用户管理</a>
                                </li>
                                <li class="active">
                                    <strong>批量导入用户</strong>
                                </li>
                            </ol>
                        </div>
                    </div>

                    <div class="row  border-bottom white-bg dashboard-header">
                        <div class="col-md-12 ">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <form id="fileForm" action="user/bulkInsert" method="post" enctype="multipart/form-data">
                                        <b>授课院校:</b>
                                        <input type="text" name="schAddr">
                                        <br><br>
                                        <b>教学过程记录表:</b>
                                        <input type="file" id="upload" name="upload" style="position: absolute;left: 150px;top: 57px" class="btn btn-w-m btn-primary" >
                                        <br><br><br>
                                        <%--<button class="btn btn-w-m btn-info" onclick="mySubmit()" type="button" style="min-width:50px">导入</button>--%>
                                        <button class="btn btn-w-m btn-info"  type="submit" style="min-width:50px">导入</button>
                                        <button class="btn btn-white" type="reset">重置</button>
                                    </form>
                                    <pre style="color:red;">
说明：Excel格式如下图所示：
导入的学生信息在《教学过程记录表.xls》文件的第一个工作表“学员信息”中。
学生信息必须从第2行开始，姓名必须在第2列，身份证在第3列，身份证号不能重复出现
<img src="picture/table1.jpg">
</pre>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="outerdiv"
                 style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.2);z-index:2;width:100%;height:100%;display:none;">
                <div id="innerdiv" style="position:absolute;">
                    <img id="bigimg" style="border:5px solid #fff;" src=""/>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%@include file="commScript.html"%>
</div>
<script>
    $(function () {
        if('${param.status}' == 'true'){
            swal("恭喜","批量导入成功！","success")
        }
        if('${param.status}' == 'false'){
            swal("可惜了","批量导入失败！","error")
        }
    })
</script>
</body>
</html>
