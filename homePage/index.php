<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--<meta name="description" content="">
    <meta name="author" content="">-->
    <title>源缘居</title>
    <!-- CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/blog.css" rel="stylesheet">
  </head>
  <body>
    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item active" href="index.html">首页</a>
          <a class="blog-nav-item" href="#part1">生活</a>
          <a class="blog-nav-item" href="#part2">旅行</a>
          <a class="blog-nav-item" href="#part3">学习</a>
        </nav>
      </div>
    </div>
	<div class="intr">
    	<span class="avtar"></span>
        <p class="peointr">我叫刘源，一名软件工程专业大三的学生。</p>
        <p class="peointr">爱生活，爱旅行，爱学习。</p>
    </div>
    <div class="title" id="part1">爱生活</div>
    <div class="content">
    	<div class="pic pic1">
    		<img src="image/h1.jpg" alt="">
    		<p>听音乐</p>
    	</div>
    	<div class="pic pic2">
    		<img src="image/h2.jpg" alt="">
    		<p>美食</p>
    	</div>
    	<div class="pic pic3">
    		<img src="image/h3.jpg" alt="">
    		<p>看小说</p>
    	</div>
    </div>
    <div class="title" id="part2">爱旅行</div>
    <div class="content">
    	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
              </ol>
              <div class="carousel-inner" role="listbox">
                <div class="item active">
                  <img src="image/s1.jpg" alt="...">
                </div>
                <div class="item">
                  <img src="image/s2.jpg" alt="...">
                </div>
				<div class="item">
                  <img src="image/s3.jpg" alt="...">
                </div>
              </div>
              <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
              </a>
            </div>
    </div>
	<div class="title" id="part3">爱学习</div>
	<!-- mySql查询结果用php输出到表格 -->
    <?php 
$hostname_conweb = "localhost";
$database_conweb = "phpweb";
$username_conweb = "root";
$password_conweb = "";
$conweb = mysql_pconnect($hostname_conweb, $username_conweb, $password_conweb) or trigger_error(mysql_error(),E_USER_ERROR); 
mysql_select_db($database_conweb, $conweb); 
$sql="CREATE TABLE `schedule` ( `class` INT, `Mon` VARCHAR(15), `Tues` VARCHAR(15), `Wed` VARCHAR(15), `Thur` VARCHAR(15), `Fri` VARCHAR(15)) ";
mysql_query("SET?NAMES?'utf8'");
mysql_query($sql,$conweb);
$insert="INSERT INTO `schedule` (`class`, `Mon`, `Tues`, `Wed`, `Thur`, `Fri`) VALUES ('1', '软件工程概论', '编译原理', '无', '无', '计算机图形技术'), ('2', '操作系统原理', '数值计算与MATLAB', '软件工程概论', '形式化方法', '编译原理'), ('3', '可视语言与信息可视化', '形式化方法', '无', '可视语言与信息可视化', '数值计算与MATLAB'), ('4', '无', '管理概论', '无', '无', '无'), ('5', '计算机前沿开发', '用户界面设计', '计算机前沿开发', '用户界面设计', '无')";
mysql_query($insert,$conweb);
$sql1="select * from schedule";
$result = mysql_query($sql1,$conweb);
mysql_close($conweb);
?>
<table width="600" border="1" align="center">
<caption>大三上学期课程表</caption>
  <tr align="center" valign="middle">
    <td width="700">第几节课</td>
    <td width="700" height="40">周一</td>
    <td width="700">周二</td>
    <td width="700">周三</td>
    <td width="700">周四</td>
    <td width="700">周五</td>
  </tr>
  <?php while ($row = mysql_fetch_array($result)){?>
    <tr align="center" valign="middle">
      <td width="600"><?php echo $row['class']; ?></td>
      <td width="600"><?php echo $row['Mon']; ?></td>
      <td width="600"><?php echo $row['Tues']; ?></td>
      <td width="600"><?php echo $row['Wed']; ?></td>
      <td width="600"><?php echo $row['Thur']; ?></td>
      <td width="600"><?php echo $row['Fri']; ?></td>
    </tr>
  <?php }?>
</table>
    <div class="blog-footer">
      <p></p>
    </div>
    <a href="" class="btt">顶部</a>
    <!-- Js-->
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugin.js"></script>
  </body>
</html>
