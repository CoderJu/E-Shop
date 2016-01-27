<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="/WEB-INF/page/common/taglib.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/main/top.css">
<%
Date dNow = new Date(); 
SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
%>
<html>
<head>
<title>Untitled Document</title>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<script language=javascript>

function MM_findObj(n, d) { //v3.0
  var p,i,x;  
  if(!d) d=document; 
  if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);
    }
  if(!(x=d[n])&&d.all) x=d.all[n]; 
  for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document); 
  return x;
}
function MM_nbGroup(event, grpName) { //v3.0
  var i,img,nbArr,args=MM_nbGroup.arguments;
  if (event == "init" && args.length > 2) {
    if ((img = MM_findObj(args[2])) != null && !img.MM_init) {
      img.MM_init = true; img.MM_up = args[3]; img.MM_dn = img.src;
      if ((nbArr = document[grpName]) == null) nbArr = document[grpName] = new Array();
      nbArr[nbArr.length] = img;
      for (i=4; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {
        if (!img.MM_up) img.MM_up = img.src;
        img.src = img.MM_dn = args[i+1];
        nbArr[nbArr.length] = img;
    } }
  } else if (event == "over") {
    document.MM_nbOver = nbArr = new Array();
    for (i=1; i < args.length-1; i+=3) if ((img = MM_findObj(args[i])) != null) {
      if (!img.MM_up) img.MM_up = img.src;
      img.src = (img.MM_dn && args[i+2]) ? args[i+2] : args[i+1];
      nbArr[nbArr.length] = img;
    }
  } else if (event == "out" ) {
    for (i=0; i < document.MM_nbOver.length; i++) {
      img = document.MM_nbOver[i]; img.src = (img.MM_dn) ? img.MM_dn : img.MM_up; }
  } else if (event == "down") {
    if ((nbArr = document[grpName]) != null)
      for (i=0; i < nbArr.length; i++) { img=nbArr[i]; img.src = img.MM_up; img.MM_dn = 0; }
    document[grpName] = nbArr = new Array();
    for (i=2; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {
      if (!img.MM_up) img.MM_up = img.src;
      img.src = img.MM_dn = args[i+1];
      nbArr[nbArr.length] = img;
  } 
    }
}

function MM_preloadImages() { //v3.0
 var d=document; 
 if(d.images){ if(!d.MM_p) d.MM_p=new Array();
   var i,j=d.MM_p.length,a=MM_preloadImages.arguments; 
   for(i=0; i<a.length; i++)
   if (a[i].indexOf("#")!=0){ 
	   d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];
	   }
   }
}

function exitsystem(){
	if (confirm('您确定要退出系统吗？'))
	  window.parent.location="<html:rewrite action='/Administrator/Logout'/>"; 
}
</script>
<META content="MShtml 6.00.2600.0" name=GENERATOR>
</head>
<body bgColor=#ffffff 
onload="javascript:MM_preloadImages(
		'/images/OAHeader_r1_c3_f2.gif','/images/OAHeader_r1_c3_f3.gif',
		'/images/OAHeader_r1_c5_f2.gif','/images/OAHeader_r1_c5_f3.gif',
		'/images/OAHeader_r1_c7_f2.gif','/images/OAHeader_r1_c7_f3.gif',
		'/images/OAHeader_r1_c9_f2.gif','/images/OAHeader_r1_c9_f3.gif',
		'/images/OAHeader_r1_c11_f2.gif','/images/OAHeader_r1_c11_f3.gif');">
<table style="margin: 0px" cellSpacing=0 cellPadding=0 width="100%" bgColor=#6386de border=0 valign="top">
<tbody>
	<tr valign=top>
		<td valign=top width="450" class="My" align=left>
			<img src="/images/global/managelogo.gif" border=0 />
		</td>
    <td width="124">
		<table style="margin: 0px" height="100%" cellSpacing=0 cellPadding=0 bgColor=#6386de border=0>
			<tbody></tbody>
		</table>
	</td>
    <td align=right width=611>
		<table style="margin: 0px" height="100%" cellSpacing=0 cellPadding=0 bgColor=#6386de border=0>
        	<tbody>
				<tr valign=bottom height=20>
          		<td width=18>
          			<img src="/images/top_toolbar.gif" border=0>
          		</td>
				<td class=top bgColor=#000000><nobr>登录者：${employee.realname }| 当前日期-<%=formatter.format(dNow) %></nobr></td>
				</tr>
        <tr height=38>
				<td></td>
          		<td valign=center align=right>
			<a 
			onmouseover="MM_nbGroup('over','OAHeader_r1_c3','/images/OAHeader_r1_c3_f2.gif','/images/OAHeader_r1_c3_f3.gif',1);" 
            title="帮助文档" style="cursor: hand" 
            onmouseout="MM_nbGroup('out');" 
            href="<html:rewrite action='/ControlCenter/MainUI/Doc'/>"  target="mainframe">
            <img id=OAHeader_r1_c3 src="/images/OAHeader_r1_c3.gif" border=0  name=OAHeader_r1_c3>
            </a></span> &nbsp; 
            <a 
            onmouseover="MM_nbGroup('over','OAHeader_r1_c5','/images/OAHeader_r1_c5_f2.gif','/image/OAHeader_r1_c5_f3.gif',1);" 
            title="刷新页面" onmouseout="MM_nbGroup('out');" 
            href="javascript:parent.mainframe.location.reload()">
            <img src="/images/OAHeader_r1_c5.gif" border=0 name=OAHeader_r1_c5>
            </a> &nbsp; 
            <a 
            onmouseover="MM_nbGroup('over','OAHeader_r1_c7','/images/OAHeader_r1_c7_f2.gif','/image/OAHeader_r1_c7_f3.gif',1);" 
            title="后退" onmouseout="MM_nbGroup('out');" 
            href="javascript:history.back()">
            <img src="/images/OAHeader_r1_c7.gif" border=0 name=OAHeader_r1_c7>
            </a> &nbsp; 
            <a 
            onmouseover="MM_nbGroup('over','OAHeader_r1_c9','/images/OAHeader_r1_c9_f2.gif','/image/OAHeader_r1_c9_f3.gif',1);" 
            title="前进" onmouseout="MM_nbGroup('out');" 
            href="javascript:history.forward()">
            <img src="/images/OAHeader_r1_c9.gif" border=0  name=OAHeader_r1_c9>
            </a> &nbsp; 
            <a 
            onmouseover="MM_nbGroup('over','OAHeader_r1_c11','/images/OAHeader_r1_c11_f2.gif','/image/OAHeader_r1_c11_f3.gif',1);" 
            title="退出系统" onmouseout="MM_nbGroup('out');" 
            href="javascript:exitsystem()">
            <img src="/images/OAHeader_r1_c11.gif" border=0 name=OAHeader_r1_c11>
            </a> &nbsp; 
				</td>
			   </tr>
			  </tbody>
			</table>
		  </td>
		 </tr>
		</tbody>
	   </table>
	</body>
</html>
