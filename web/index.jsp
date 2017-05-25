<%--
  Created by IntelliJ IDEA.
  User: monsterlin
  Date: 2017/5/23
  Time: 上午11:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <title></title>
  <link rel="stylesheet" href="http://cdn.monsterlin.com/css/style.css" />
</head>

<body>
<header>
  <h1 id="logo">
    <a href="#">ReadMe</a>
  </h1>
  <span id="flogo">让乐趣无处不在</span>
</header>
<div id="menu">
  <ul>
    <li id="choose">段子百科</li>
  </ul>
</div>
<div id="main">
  <div class="left">


    <s:iterator value="satinList" var="satin">
    <div class="box">
      <div class="theader">
        <img src="<s:property value="authorImg"/>" alt="" class="user"/>
        <h4 class="name"><s:property value="author" /></h4>
      </div>
      <div class="tpar">
        <a href="<s:property value="fromUrl"/>"><p><s:property value="content" /></p></a>
      </div>
      <div class="from">
        <span class="time"><s:property value="date" /></span>
        |
        <span class="place"><s:property value="source" /></span>
      </div>
    </div>
    </s:iterator>


    <!-- 分页 -->
    <div class="page">
      <p><a href="#"><</a>
        <a href="#">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">6</a>
        <a href="#">7</a>
        <a href="#">8</a>
        <a href="#">9</a>
        <a href="#">></a></p>
    </div>
  </div>
  <div class="right">
    <div class="sponsors">
      <h3>Links</h3>
      <ul>
        <li><img src="https://shawnzeng.com/wp-content/uploads/2017/05/ad.jpg"></li>
        <li><img src="https://shawnzeng.com/wp-content/uploads/2017/05/ad.jpg"></li>
        <li><img src="https://shawnzeng.com/wp-content/uploads/2017/05/ad.jpg"></li>
        <li><img src="https://shawnzeng.com/wp-content/uploads/2017/05/ad.jpg"></li>
        <li><img src="https://shawnzeng.com/wp-content/uploads/2017/05/ad.jpg"></li>
        <li><img src="https://shawnzeng.com/wp-content/uploads/2017/05/ad.jpg"></li>
      </ul>
    </div>
  </div>
</div>
<div class="footer">
  <p>@2017 xxx xxxxx</p>
</div>
</body>

</html>