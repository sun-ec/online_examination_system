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
        var elements = document.getElementsByName("xh");
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
                <div class="col-sm-12">
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
                                    <strong>批量操作用户</strong>
                                </li>
                            </ol>
                        </div>
                    </div>

                    <div class="row  border-bottom white-bg dashboard-header">
                        <div class="col-md-12 ">
                            <div class="ibox float-e-margins">
                                <div class="ibox-content">
                                    <form action="user/showUsers" method="post">
                                        <b>授课院校:</b><input type="text" name="sch">
                                        <button class="btn btn-w-m btn-info" type="submit" style="min-width:50px">查询</button>
                                        <button class="btn btn-white" type="reset">重置</button>
                                    </form>
                                    <table class="table table-striped" style="text-align: center;">
                                        <thead>
                                        <tr>
                                            <th style="text-align:center">序号</th>
                                            <th style="text-align:center">姓名</th>
                                            <th style="text-align:center">身份证号码</th>
                                            <th style="text-align:center">专业</th>
                                            <th style="text-align:center">最高学历</th>
                                            <th style="text-align:center">手机号码</th>
                                            <th style="text-align:center">QQ号码</th>
                                            <th style="text-align:center">授课院校</th>
                                            <th style="text-align:center">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${usersList}" var="item" varStatus="status">
                                            <tr id="tr_${item.id}">
                                                <td><input type="checkbox" name="xh" value="${item.id}">${status.index+1}</td>
                                                <td>${item.userName}</td>
                                                <td>${item.idCardNo}</td>
                                                <td>${item.marjor}</td>
                                                <td>${item.eduBackground}</td>
                                                <td>${item.mobile}</td>
                                                <td>${item.qq}</td>
                                                <td>${item.schAddr}</td>
                                                <td><a onclick="openmodel('${item.id}')"><i class="fa fa-pencil"></i></a></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <input type="checkbox" name="all" style="margin-left: 22px" onclick="checkall(this)"><b>全选</b>
                                    <button type="button" onclick="bultDelete()" class="btn btn-w-m btn-danger">批量删除</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div><div class="modal fade in" id="mymodel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none; padding-right: 17px;">
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
                        <form id="updateform" class="form-horizontal text-center" role="form">
                            <input type="hidden" name="id" id="id">
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">学号：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control"  name="stuNo" id="stuNo" type="text" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">用户名：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control"  name="userName" id="userName" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">旧密码：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" name="opassWord" id="opassWord" type="text" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">新密码：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="passWord" id="passWord">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">确认密码：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="dpassWord" id="dpassWord">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">性别：</label><br>
                                <div class="col-sm-8">
                                    <input  name="gender" type="radio">男
                                    <input type="radio" name="gender">女
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">出生日期：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" type="date" name="birthday" id="birthday" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">身份证号：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="idCardNo" id="idCardNo" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">手机：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="mobile" id="mobile">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">QQ：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="qq" id="qq">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">Email：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="email" id="email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">籍贯：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="nationPlace" id="nationPlace">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">专业：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="marjor" id="marjor">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">最高学历：</label><br>
                                <div class="col-sm-8">
                                    <select class="form-control" name="eduBackground" id="eduBackground">
                                        <option value="">无</option>
                                        <option value="专科">专科</option>
                                        <option value="本科">本科</option>
                                        <option value="硕士">硕士</option></select><br>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="margin-top: 3.5%">毕业院校：</label><br>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="graduateSchool" id="graduateSchool" >
                                </div>
                            </div>
                        </form>
                    </div><!--模态框内容结束-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
                        <button type="button" class="btn btn-primary" onclick="myUpdate()">保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div>
        </div>
</div>

</div>
</div>
</div>
<%@include file="commScript.html"%>
</div>
<script>
    function openmodel(id) {
        $('#mymodel').modal('show');
        $.post('user/showAjaxUpdate',{id:id},function (jsonData) {
            $('#id').val(jsonData.id);
            $('#stuNo').val(jsonData.stuNo);
            $('#idCardNo').val(jsonData.idCardNo);
            $('#userName').val(jsonData.userName);
            $('#opassWord').val(jsonData.passWord);
            $('#mobile').val(jsonData.mobile);
            $('#homeAddr').val(jsonData.homeAddr);
            $('#schAddr').val(jsonData.schAddr);
            $('#qq').val(jsonData.qq);
            $('#email').val(jsonData.email);
            if(jsonData.gender==='男'){
                $('#gender').eq(0).attr({'checked':true})
            }
            if(jsonData.gender==='女'){
                $('#gender').eq(1).attr({'checked':true})
            }
            $('#birthday').val(jsonData.birthday);
            $('#nationPlace').val(jsonData.nationPlace);
            $('#marjor').val(jsonData.marjor);
            $('#eduBackground').val(jsonData.eduBackground);
            $('#graduateSchool').val(jsonData.graduateSchool);
        },'json')
    }
    function myUpdate() {
        $.post('user/ajaxUpdate',$('#updateform').serialize(),function (jsonData) {
            $('#mymodel').modal('hide');
            if(jsonData.status){
                swal({title:"更新成功",title:"请刷新页面再查询",icon:"success"})

            }else{
                swal({title:"更新失败",icon:"error"})
            }
        },'json')
    }

    function bultDelete() {
        var topics="";
       $('input[name="xh"]:checked').each(function (index) {
           topics+=$(this).val()+',';
       });
        topics=topics.substr(0,topics.length-1);
        $.post('user/bulkDelete',{userIdStr:topics},function (jsonData) {
            if(jsonData.status){
                swal({title:"批量删除成功",icon:"success"})
                var split = topics.split(",");
                for(var i=0;i<split.length;i++){
                    $('#tr_'+split[i]).remove();
                }
            }else{
                swal({title:"批量删除成功失败",icon:"error"})
            }
        },'json')
    }
</script>
</body>
</html>
