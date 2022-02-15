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
<style>
    .examboder{
        background-color: #dfdbb9;
    }
    .table>tbody>tr>td{
        text-align: center;
        line-height: 1.42857;
        vertical-align: middle
    }

</style>
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
                        <li><a href="score/query"><i class="fa fa-plus-square"></i>查看成绩</a></li>
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
        <div style="text-align: right;">
            <a href="papersMaintain1.jsp"><button style="min-width: 50px"type="button" class="btn btn-w-m btn-primary">刷新</button></a>
        </div>
        <div class="examboder" style="text-align: center;height: 1200px">
            <p style="font-weight: bold">考试成绩（<b style="color: red">试卷编号：</b>）</p>
            <br>
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>成绩表 </h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="row">
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th style="text-align: center">序号</th>
                                            <th style="text-align: center">姓名</th>
                                            <th style="text-align: center">成绩</th>
                                            <th style="text-align: center">性别</th>
                                            <th style="text-align: center">在读/毕业院校</th>
                                            <th style="text-align: center">专业</th>
                                            <th style="text-align: center">最高学历</th>
                                            <th style="text-align: center">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${scoreList}" varStatus="status">
                                            <tr id="tr_${item[0]}">
                                                <td>${status.index+1}</td>
                                                <td>${item[1]}</td>
                                                <td>${item[2]}</td>
                                                <td>${item[3]}</td>
                                                <td>${item[4]}</td>
                                                <td>${item[5]}</td>
                                                <td>${item[6]}</td>
                                                <td><button class="btn btn-danger btn-circle"  type="button" onclick="myDelete('{item[0]}')"><i class="fa fa-times"></i></button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <form id="formToUpdate" action="score/export" method="post" enctype="multipart/form-data">
                                <div>
                                    <br>
                                    <b style="float: left;margin-top: 6px">教学过程记录表：</b>
                                    <input  style="float: left;margin-top: 3px" type="file" name="excelFile">
                                    <button style="float: left;margin-left: -80px" type="submit" class="btn btn-w-m btn-info">导出成绩</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <%@include file="commScript.html"%>

</div>
<script>
    function ajaxSub() {
        $("#formToUpdate").ajaxSubmit({
            type:'post',
            url:'score/export',
            jsonData: data,
            success:function(){
                swal("成功");
            },
            error:function () {
                alert('error');
            }
        });
    }

    function myDelete(e) {
        swal({
                title: "确认？",
                text: "请确认删除",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            })
                .then((willDelete) => {
                if (willDelete) {
                    $.post('score/deleteScore',{"id":e},function (jsonData) {
                        if(jsonData.status){
                            $('#tr_'+e).remove();
                            swal("删除成功", {
                                icon: "success",
                            });
                        }else{
                            swal("删除失败", {
                                icon: "error",
                            });
                        }
                    },'json')
                } else {
                    swal("你的数据是安全的！");
        }
        })
    }

</script>
</body>
</html>
