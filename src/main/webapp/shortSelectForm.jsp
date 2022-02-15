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
    function checkall(all) {
        //得到4个checkbox
        var elements = document.getElementsByName("question");
        // <input type="checkbox" name="all" checked >, checked属性让checkbox选中
        if(all.checked){
            for(var i=0; i<elements.length; i++){
                elements[i].checked = true;
            }
        }else{
            for(var i=0; i<elements.length; i++){
                elements[i].checked = false;
            }
        }
    }
    function checkalld(all) {
        var element = document.getElementsByName("questiond");
        // <input type="checkbox" name="all" checked >, checked属性让checkbox选中
        if(all.checked){
            for(var i=0; i<element.length; i++){
                element[i].checked = true;
            }
        }else{
            for(var i=0; i<element.length; i++){
                element[i].checked = false;
            }
        }
    }
    function showdetail() {
        document.getElementById("view2").style.display="";
        document.getElementById("view1").style.display="none";
    }
    function hiddendetail() {
        document.getElementById("view2").style.display="none";
        document.getElementById("view1").style.display="";
    }
</script>

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
                        <li><a href="paperNum.jsp"><i class="fa fa-plus-square"></i>考试</a></li>
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
                <li class="active">
                    <a href="#"><i class="fa fa-book"></i> <span class="nav-label">试题查询</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="test/queryChoice1"><i class="fa fa-file-text"></i>单选题查询</a></li>
                        <li><a href="test/queryChoice2"><i class="fa fa-newspaper-o"></i>多选题查询</a></li>
                        <li><a href="test/queryTrueFalse"><i class="fa fa-newspaper-o"></i>判断题查询</a></li>
                        <li class="active"><a href="test/querySimple4"><i class="fa fa-newspaper-o"></i>简答题查询</a></li>
                        <li><a href="test/querySimple5"><i class="fa fa-newspaper-o"></i>编程题查询</a></li>
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
                    <title>贵美商城后台管理系统</title>
                    <!-- 面包屑导航 -->
                    <div class="row wrapper border-bottom white-bg">
                        <div class="col-lg-10">
                            <ol class="breadcrumb">
                                <li>
                                    <a href="teacherForm.jsp">主页</a>
                                </li>
                                <li>
                                    <a href="javascript:void(0)">试题查询</a>
                                </li>
                                <li class="active">
                                    <strong>简答题查询</strong>
                                </li>
                            </ol>
                        </div>
                    </div>

                    <div class="row  border-bottom white-bg dashboard-header">
                        <div class="col-md-12 ">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <form action="#" method="post">
                                        <button style="position:absolute;left: -150px" class="btn btn-primary" type="submit">继续新增</button>
                                    </form>
                                    <form id="program" method="post" action="#" class="form-horizontal"
                                          enctype="multipart/form-data">
                                        <div class="form-group"><label style="position: relative;left: -565px">简答题题干</label>
                                            <div class="col-sm-10"><input type="text" style="width: 350px;margin-left: 115px"><b>(模糊查询)</b></div>
                                        </div>
                                        <div><label class="col-sm-2 control-label">课程</label>
                                            <select style="width: 222px;height: 154px" id="courses" multiple class="form-control">
                                                <c:forEach items="${courList}" var="course">
                                                    <option value="${course.id}">${course.courseName}</option>
                                                </c:forEach>
                                            </select>
                                            <label style="position: relative;left: 350px;top: -145px">知识点</label>
                                            <select style="width: 222px;height: 154px;position: absolute;left: 440px;top: 73px" name="techCateId" multiple class="form-control">
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-4 col-sm-offset-2" style="margin-left: 300px">
                                                <button class="btn btn-primary" type="submit">查询</button>
                                                <button class="btn btn-white" type="reset">重置</button>
                                            </div>
                                        </div>
                                        <hr>
                                        <div id="view1">
                                            <input type="checkbox" name="question">1.为什么猫要吃老鼠？<br><br>
                                            <input type="checkbox" name="question">2.为什么猫要吃老鼠？<br><br>
                                            <button type="button" onclick="showdetail()" class="btn btn-w-m btn-success" style="min-width:50px">展开</button>
                                            <input style="margin-left: 10px" type="checkbox" name="all" onclick="checkall(this)">全选
                                        </div>
                                        <div id="view2" style="display: none">
                                            <form action="#" method="post">
                                                <input type="checkbox" name="questiond">1.为什么猫要吃老鼠？<br>
                                                <b style="color: red">标准答案：</b><br>
                                                <textarea class="form-control" rows="4"></textarea>
                                                <button type="submit" class="btn btn-w-m btn-primary" style="min-width:50px">更新</button>
                                                <button type="submit" class="btn btn-w-m btn-danger" style="min-width:50px ;margin-left: 20px">删除</button>
                                                <br>
                                                <input type="checkbox" name="questiond">2.为什么猫要吃老鼠？<br>
                                                <b style="color: red">标准答案：</b><br>
                                                <textarea class="form-control" rows="4"></textarea>
                                                <button type="submit" class="btn btn-w-m btn-primary" style="min-width:50px">更新</button>
                                                <button type="submit" class="btn btn-w-m btn-danger" style="min-width:50px;margin-left: 20px">删除</button>
                                                <br>
                                            </form>
                                            <button type="button" onclick="hiddendetail()" class="btn btn-w-m btn-success" style="min-width:50px">收起</button>
                                            <input style="margin-left: 10px" type="checkbox" name="all" onclick="checkalld(this)">全选
                                        </div>
                                            考卷编码：<input type="text" id="exam_no1" name="exam_no">
                                            <select name="exam_no" id="exam_no" style="display: none">
                                                <c:forEach items="${examNo}" var="examno">
                                                    <option name="exa" value="${examno}">${examno}</option>
                                                </c:forEach>
                                            </select>
                                            <button type="button" name="inputs" class="btn btn-w-m btn-primary" style="min-width:50px;display: none">输入</button>
                                            <button type="button" name="chooes" class="btn btn-w-m btn-primary" style="min-width:50px">选择</button>
                                            <br>
                                            <span style="color: red">(注:考点拼音简称2-6个大写字母*YYMMDD*1~2班级号，如北京大学1班:PU1245201)</span>

                                        </form>
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
</body>
</html>
