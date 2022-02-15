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
                                    <a href="javascript:void(0)">分类管理</a>
                                </li>
                                <li class="active">
                                    <strong>知识点</strong>
                                </li>
                            </ol>
                        </div>
                    </div>

                    <div class="row  border-bottom white-bg dashboard-header">
                        <div class="col-md-12 ">
                            <div class="ibox float-e-margins">
                                    <div style="height: 300px">
                                        <form id="addForm"  method="post" action="tech/query">
                                            <i class="	glyphicon glyphicon-import"></i><lable style="color: #0d8ddb;font-weight: bold">新增知识点</lable>
                                            <div><label class="col-sm-2 control-label" style="position:relative;left: 55px;top: 8px">课程:</label>
                                                <select style="width: 222px;height: 154px;position: relative;left: 18px" id="courseId" name="courseId" multiple class="form-control">
                                                    <c:forEach var="item" items="${courList}">
                                                        <option value="${item.id}" <c:if test="${item.id} == ${TechCategoryList.get(0).courseId}"> selected</c:if>>${item.courseName}</option>
                                                    </c:forEach>
                                                </select>
                                            <div class="form-group"><label style="position: relative;left: -520px;top: 30px;">知识点：</label>
                                                <div class="col-sm-10"><input type="text" name="techCtgr" style="width: 350px;position: relative;left: 115px;top: 30px"></div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-4 col-sm-offset-2" style="position: relative;left: 115px;top: 30px">
                                                    <button class="btn btn-primary" onclick="formSub()" type="button">保存</button>
                                                    <button style="background-color: #0d8ddb" class="btn btn-primary" type="submit">查询</button>
                                                    <button class="btn btn-white" type="reset">重置</button>
                                                </div>
                                            </div>
                                            </div>
                                        </form>
                                    </div>
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>知识点</h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="ibox-content">

                                        <table class="table" id="table">
                                            <thead>
                                            <tr>
                                                <th style="text-align: center">序号</th>
                                                <th style="text-align: center">知识点</th>
                                                <th style="text-align: center">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="item" items="${TechCategoryList}" varStatus="status">
                                                <tr id="tr_${item.id}">
                                                    <td style="text-align: center">${status.index+1}</td>
                                                    <td style="text-align: center">${item.techCtgr}</td>
                                                    <td style="text-align: center">
                                                        <button class="btn btn-primary btn-circle" onclick="btn_openmodel(this,'${item.id}')" type="button" data-backdrop="" data-toggle="modal" data-target="#myModal"><i class="fa fa-list"></i></button>
                                                        <button class="btn btn-danger btn-circle"  type="button" onclick="myDelete('${item.id}')"><i class="fa fa-times"></i></button>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade in" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content animated flipInY">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        ×
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        更新
                    </h4>
                </div>
                <div class="modal-body">
                    <form id="updateForm" class="form-horizontal text-center" role="form">
                        <input type="hidden" name="id" id="id">
                        <div class="form-group">
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-offset-1 control-label">课程名:</label>
                                <select class="col-sm-8 form-control" style="width: 348px" name="courseId">
                                    <c:forEach var="item" varStatus="status" items="${courList}">
                                        <option value="${item.id}" >${item.courseName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <br><br>
                            <div class="form-group">
                                <label class="col-sm-2 col-sm-offset-1 control-label">知识点：</label>
                                <div class="col-sm-7" style="padding: 0">
                                    <input type="text" class="form-control" required id="techCtgr" name="techCtgr">
                                </div>
                            </div>
                        </div>
                    </form>
                </div><!--模态框内容结束-->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消
                    </button>
                    <button type="button" onclick="myUpdate()" class="btn btn-primary">
                        保存
                    </button>
                </div>
            </div><!-- /.modal-content -->
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
    function btn_openmodel(e,id) {
        var parent=e.parentNode.parentNode;
        var techCtgr=$(parent).find("td").eq(1).text();
        $('#techCtgr').val(techCtgr);
        $('#id').val(id);
    }

    function myUpdate(){
        $.post('tech/ajaxUpdate',$('#updateForm').serialize(),function (jsonData) {
            $('#myModal').modal('hide');
            if(jsonData.status){
                swal({
                    title: "更新成功",
                    icon: "success"
                });
                $("#tr_"+$('#id').val()).find("td").eq(1).text($('#techCtgr').val());
            }else{
                swal({
                    title: "更新失败",
                    icon: "error"
                });
            }
        },'json')
    }
    function myDelete(id){
        console.log(id);
        swal({
            title: "您是否确认此知识点?",
            text: "删除操作不可恢复，再确认！",
            icon: "warning",
            buttons: ["取消","确认"],
            dangerMode: true,
        })
            .then((willDelete) => {
            if (willDelete) {
                $.post('tech/ajaxDelete',{id:id},function (jsonData) {
                    if(jsonData.status){
                        swal({
                            title: "删除成功",
                            icon: "success"
                        });
                        $('#tr_'+id).remove();
                    }else{
                        swal({
                            title: "删除失败",
                            icon: "error"
                        });
                    }
                },'json')
            }else{
                swal("您的数据是安全的!");
    }
    })
    }

    function formSub(){
        $.post('tech/addTech',$('#addForm').serialize(),function(jsonData){
            if(jsonData.status){
                swal({
                    title: "添加成功",
                    icon: "success"
                });
                $.get('test/queryTech?courId='+$('#courseId').val(),function (jsonData) {
                    $('#table').find("tbody").empty();
                    $.each(jsonData,function (index, value) {
                        var tr='<tr id="tr_'+value.id+'">'+
                            '<td style="text-align: center">'+(index+1)+'</td>'+
                            '<td style="text-align: center">'+value.techCtgr+'</td>'+
                            '<td style="text-align: center">'+
                            '<button class="btn btn-primary btn-circle" onclick="btn_openmodel(this,'+value.id+')" type="button" data-backdrop="" data-toggle="modal" data-target="#myModal"><i class="fa fa-list"></i></button>'+
                            '<button class="btn btn-danger btn-circle"  type="button" onclick="myDelete('+value.id+')"><i class="fa fa-times"></i></button>'+
                            '</td>'+
                            '</tr>';
                        $('#table').find("tbody").append(tr);
                    })
                },'json')
            }else{
                swal({
                    title: "添加失败",
                    icon: "error"
                });
            }
        },'json')
    }


    $(function () {
        $('#courseId').change(function () {
          $.get('test/queryTech?courId='+$('#courseId').val(),function (jsonData) {
              $('#table').find("tbody").empty();
              $.each(jsonData,function (index, value) {
                  var tr='<tr id="tr_'+value.id+'">'+
                      '<td style="text-align: center">'+(index+1)+'</td>'+
                      '<td style="text-align: center">'+value.techCtgr+'</td>'+
                      '<td style="text-align: center">'+
                        '<button class="btn btn-primary btn-circle" onclick="btn_openmodel(this,'+value.id+')" type="button" data-backdrop="" data-toggle="modal" data-target="#myModal"><i class="fa fa-list"></i></button>'+
                        '<button class="btn btn-danger btn-circle"  type="button" onclick="myDelete('+value.id+')"><i class="fa fa-times"></i></button>'+
                      '</td>'+
                  '</tr>';
                  $('#table').find("tbody").append(tr);
              })
          },'json')
        })
    })
</script>
</body>
</html>
