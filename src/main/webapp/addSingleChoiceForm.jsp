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
                                 <strong class="font-bold">${logUser.userName}</strong>
                             </span>
                        <span class="text-muted text-xs block">系统管理员 <b class="caret"></b></span>
                        </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
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
                <li class="active">
                    <a href="#"><i class="fa fa-plus-square"></i> <span class="nav-label">试题新增</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li class="active"><a href="addSingleChoiceForm.jsp"><i class="fa fa-plus-square"></i>新增单选题</a></li>
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
                        <li><a href="test/queryChoice1"><i class="fa fa-file-text"></i>单选题查询</a></li>
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
                        <span class="m-r-sm text-muted welcome-message">欢迎${logUser.userName}</span>
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
                                    <a href="javascript:void(0)">试题新增</a>
                                </li>
                                <li class="active">
                                    <strong>新增单选题</strong>
                                </li>
                            </ol>
                        </div>
                    </div>

                    <div class="row  border-bottom white-bg dashboard-header">
                        <div class="col-md-12 ">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <a href="singleSelectForm.jsp">
                                        <button style="position:absolute;left: -150px" class="btn btn-primary" type="submit">查询选题</button>
                                    </a>
                                    <form id="SingleChoice" method="post" action="test/addChoice1" class="form-horizontal">
                                        <div class="form-group"><label class="col-sm-2 control-label">单选题题干</label>
                                            <div class="col-sm-10"><textarea name="question" cols="60"
                                                                             rows="10"></textarea></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">应用格式</label>
                                            <div class="col-sm-10"><textarea id="singletype"cols="60"
                                                                             rows="5">&ltpre&gt此处为应用格式的代码&lt/pre&gt</textarea></div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-10" style="margin-left: 120px">
                                                <button type="button" onclick="myCopy()" class="btn btn-w-m btn-default" style="min-width:60px">复制格式代码</button>
                                            </div>
                                        </div>
                                        <div><label class="col-sm-2 control-label">课程</label>
                                            <select style="width: 222px;height: 154px" id="courses" multiple class="form-control">
                                                <c:forEach items="${courList}" var="course">
                                                    <option value="${course.id}">${course.courseName}</option>
                                                </c:forEach>
                                            </select>
                                            <label style="position: relative;left: 350px;top: -145px">知识点</label>
                                            <select style="width: 222px;height: 154px;position: absolute;left: 440px;top: 438px" name="techCateId" multiple class="form-control">
                                            </select>
                                        </div>
                                        <div>
                                            <lable style="margin-left: 75px">选项</lable>
                                            <lable style="margin-left: 210px">内容</lable>
                                            <lable style="margin-left: 260px">正确答案</lable>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">A</label>
                                            <textarea style="margin-left: 10px" name="optionA"  cols="58" rows="1"></textarea>
                                            <input style="position: relative;top: -8px;left: 20px" type="radio"
                                                   name="correct"  value="A">
                                            <label class="col-sm-2 control-label">B</label>
                                            <textarea  style="margin-left: 10px"name="optionB"  cols="58" rows="1"></textarea>
                                            <input style="position: relative;top: -8px;left: 20px" type="radio"
                                                   name="correct" value="B">
                                            <label class="col-sm-2 control-label">C</label>
                                            <textarea  style="margin-left: 10px" name="optionC"  cols="58" rows="1"></textarea>
                                            <input style="position: relative;top: -8px;left: 20px" type="radio"
                                                   name="correct"  value="C">
                                            <label class="col-sm-2 control-label">D</label>
                                            <textarea  style="margin-left: 10px"name="optionD"  cols="58" rows="1"></textarea>
                                            <input style="position: relative;top: -8px;left: 20px" type="radio"
                                                   name="correct" value="D">
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-4 col-sm-offset-2" style="margin-left: 300px">
                                                <button class="btn btn-primary" type="submit">保存</button>
                                                <button class="btn btn-white" type="reset">重置</button>
                                            </div>
                                        </div>

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
<script>

    $(function () {
        $('#courses').change(function () {
            $.get('test/queryTech?courId='+$(this).val(),function (jsonData) {
                $('[name="techCateId"]').empty();
                $.each(jsonData,function (index, value) {
                    $('[name="techCateId"]').append("<option value="+value.id+">"+value.techCtgr+"</option>");
                })
            })
        });
        if("${param.status}"=="true"){
            swal({
                title: "成功",
                text: "添加成功！",
                icon: "success",
                button: "OK"
            });
        }
         if("${param.status}"=="false"){
             swal({
                 title: "失败",
                 text: "添加失败",
                 icon: "error",
                 button: "OK"
             });
         }
  })

    function myCopy(){
        var ele = document.getElementById("singletype");
        ele.select();
        document.execCommand("Copy");
        alert("复制成功");
    }
</script>
</body>
</html>
