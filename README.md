# online_examination_system

#### 项目介绍
基于SSM（Spring+Spring mvc+Mybatis）的在线考试系统，支持excel表的导入导出

#### 软件架构
+src
  +main                         //源码文件
    +java
      +com
        +oes
          +controller           //控制层
          +interceptor          //拦截器
          +mapper               //映射器
          +model                //模型层
          +service              //业务层
            +impl               //业务层实现类
    +resources
      +com.oes.mapper           //mybatis SQL映射文件
      -applicationContext.xml   //spring配置文件
      -log4j.properties         //log4j资源文件
      -mybatis-config.xml       //mybatis配置文件
      -ojdbc.properties         //数据库连接资源文件
      -springmvc-servlet.xml    //spring mvc配置文件
    +webapp
      +common                   //页面公共部分(eg:导航栏、外部CSS\JS引入代码)
      +images                   //页面图片资源
      +static                   //页面静态资源(eg:.css/.js/.fonts)
      +views                    //页面
      +WEB-INF                  //WEB应用目录
      index.jsp                 //主页面
  +test                         //测试文件
    +java
      +com.oes.service          //业务测试
    +resources
-target                         //构建物目标文件
-pom.xml                        //架构配置文件


#### 安装教程

1. 数据库文件在资源文件中有，需要的朋友可自行导入

#### 使用说明

1. 数据库使用Oracle/mysql
2. JDK版本1.8.0_144
3. Tomcat版本9
4. 开发时Maven版本3.5.3



> note：mysql数据库的数据生成的脚本，有个别语句有问题，基本是插入数据的问题，注意报错就可以手动改一下，基本上没几个。原本是使用的oracle数据库，我手动改了一下语句和配置，换成MySQL了。还有部分功能没有写完，但是jsp页面都有了。

