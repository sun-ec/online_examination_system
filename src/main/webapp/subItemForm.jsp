<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="108kb" autoFlush="true" %>
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
                        <li><a href="paperNum.jsp"><i class="fa fa-plus-square"></i>考试</a></li>
                        <li><a href="test/showCorrect"><i class="fa fa-plus-square"></i>主观题阅卷</a></li>
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
                        <li class="active"><a href="test/queryChoice1"><i class="fa fa-file-text"></i>单选题查询</a></li>
                        <li><a href="test/queryChoice2"><i class="fa fa-newspaper-o"></i>多选题查询</a></li>
                        <li><a href="test/queryTrueFalse"><i class="fa fa-newspaper-o"></i>判断题查询</a></li>
                        <li><a href="test/querySimple4"><i class="fa fa-newspaper-o"></i>简答题查询</a></li>
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

                <div class="row wrapper border-bottom white-bg">
                    <div class="col-lg-10">
                        <ol class="breadcrumb">
                            <li>
                                <a href="teacherForm.jsp">主页</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">考试管理</a>
                            </li>
                            <li class="active">
                                <strong>查看成绩</strong>
                            </li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
        <div class="examboder" style="text-align: center;height: 1200px">
            <p style="font-weight: bold">改卷（<b style="color: red">试卷编号：${exam}</b>）</p>
            <br>
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="col-lg-12">
                        <c:forEach var="item" items="${correct}" varStatus="status">
                            <div>
                                <p class="spand"  style="clear:both;background-color: #6fd1bd;width: 1200px;height:20px;cursor: pointer">
                                    <b style="color: red;float: left">${status.index+1}.${((item.value)["basicInfo"])[2]}</b>
                                    <b style="float: left;margin-left: 30px">客观题得分：${((item.value)["basicInfo"])[3]}分&nbsp;&nbsp;&nbsp;&nbsp;</b>
                                    <b style="float: left;color: red;"></b>
                                </p>
                                <div name="content"  style="display: none;clear:both">
                                    <b style="float: left">(一)简答题 每题5分</b>
                                    <c:forEach var='t' items='${(item.value)["examInfo"]}' step="2"  varStatus="sta">
                                        <br> <br>
                                        <b style="float: left ;color: blue">${fn:replace(sta.index/2+1,".0","")}.${t}？</b><br><br>
                                        <input type="text" style="float: left;width: 1000px" value='${((item.value)["examInfo"])[sta.index+1]}'><br><br>
                                        <b style="float: left;margin-top: 3px">得分：</b><input name="correct_n" type="text" style="float: left;width: 70px"><b style="float: left;margin-top: 3px">分</b>
                                    </c:forEach>
                                    <br><br>
                                    <button style="float: left" type="button" onclick="myMutil(this,'${((item.value)["basicInfo"])[0]}')" class="btn btn-w-m btn-success">完成</button>
                                    <p style="float: left;color: red;margin-top: 5px;font-weight: bold;margin-left: 20px;font-size: 16px"></p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>
        <!-- Mainly scripts -->
        <%@include file="commScript.html"%>

        <script>
            function myMutil(e,id){
                var arr=new Array();
                $("[name='correct_n']").each(function (i) {
                    arr[i]=$(this).val();
                });
                $.post('score/subjective',{"id":id,"scores":arr.join(',')},function (jsonData) {
                    if(jsonData.status){
                        swal({title:"成功",text:"总分："+jsonData.score+"分",icon:"success"})
                        $(e.parentNode).find("p").eq(0).text("总分："+jsonData.score)
                        $(e.parentNode.parentNode).find("p").find("b").eq(2).text("总分："+jsonData.score);
                        $(e.parentNode).hide()
                    }else{
                        swal({text:"失败",title:"服务器开小差了，请重试尝试",icon:"error"})
                    }
                },'json')

            }
            $(function () {
                $('.spand').click(function (event) {
                    if($(this.parentNode).find('div').is(':hidden')){
                        $(this.parentNode).find('div').show()
                    }else{
                        $(this.parentNode).find('div').hide()
                    }
                });
            })
        </script>
    </div>
</div>
</body>
</html>
