<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/page/common/taglib.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/main/left.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="mainframe">
<Script language="javaScript">
function getTablesByStart(name){
	var inputs = document.getElementsByTagName("table");
	var files = new Array();
	var y = 0;
	for (var i=0; i<inputs.length; i++) {		
	  if (inputs[i].id !=null && inputs[i].id.length>name.length && inputs[i].id.substring(0, name.length)==name){
		 files[y] = inputs[i];
		 y++;
	  }
	}
	return files;
}

function HideAll(){
	var tables = getTablesByStart("menu_");
    for (var i=0; i<tables.length; i++) {
		tables[i].style.display = "none";
		var id = tables[i].id.substring("menu_".length);
		var imgId = document.getElementById("Img"+ id);
		var imgId2 = document.getElementById("Img"+ id + "_0");
		if(imgId) imgId.src="/images/midclosedfolder.gif";
		if(imgId2) imgId2.src="/images/clsfld.gif";
	}
}

function turnit(id) {
	var menu = document.getElementById("menu_"+ id);
	var imgId = document.getElementById("Img"+ id);
	var imgId2 = document.getElementById("Img"+ id + "_0");
	if (menu.style.display=="none"){
		HideAll();
		menu.style.display = "";
		if(imgId) imgId.src="/images/midopenedfolder.gif";
		if(imgId2) imgId2.src="/images/openfld.gif";
	}else{
		menu.style.display = "none";
		if(imgId) imgId.src="/images/midclosedfolder.gif";
		if(imgId2) imgId2.src="/images/clsfld.gif";
	}
}
</Script>
</head>
<body leftmargin="0" topmargin="0" bgcolor="#F1F1F1"><br>
<!-------------------------产品管理START------------------------------->
<table border=0 width="98%" align="center" cellspacing="0" cellpadding="0">
  <tr> 
    <td colspan="3" language="JavaScript" onMouseUp="turnit('Product')" style="CURSOR: hand"> 
      <img id="ImgProduct" src="/images/midclosedfolder.gif" align="absMiddle" border="0" width="16"><img name="ImgProduct_0" src="/images/clsfld.gif" align="absMiddle" border="0"> 
        <font face=宋体><b>产品管理</b></font> 
    </td>
  </tr>
</table>
<table id="menu_Product" border=0 width="98%" align="center" cellspacing="0" cellpadding="0" style="display:none">
  <tr> 
    <td width="50"><img src="/images/vertline.gif" border=0><img src="/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22"><img src="/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16"></td>
    <td width="123"> <a href="<html:rewrite action='/control/product/type/list'/>">产品类别管理</a> </td>
  </tr>
  <tr> 
    <td width="50"><img src="/images/vertline.gif" border=0><img src="/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22"><img src="/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16"></td>
    <td width="123"> <a href="<html:rewrite action='/control/brand/list'/>">产品品牌管理</a> </td>
  </tr>
  <tr> 
    <td width="50"><img src="/images/vertline.gif" border=0><img src="/images/lastnodeline.gif" align="absMiddle" border=0 width="16" height="22"><img src="/images/doctemp.gif" align="absMiddle" border="0" width="16" height="16"></td>
    <td width="123"> <a href="<html:rewrite action='/control/product/list'/>">产品管理</a> </td>
  </tr>
</table>
<!-------------------------产品管理END------------------------------->
<table border="0" width="98%" align="center" cellspacing="0" cellpadding="0">
  <tr> 
    <td width="20"><img src="/images/lastnodeline.gif" border="0"></td>
    <td>
      <a href="<html:rewrite action='/employee/logout'/>" target="_parent">退出系统</a>
    </td>
  </tr>
</table>
</body>
</html>
