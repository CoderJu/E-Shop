<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/page/common/taglib.jsp" %>
<link rel="stylesheet" href="/css/common/default.css" type="text/css">
<link rel="stylesheet" href="/css/productManage/productTypeList.css" type="text/css">
<html>
<head>
<title>产品类别管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function toPage(){
		
	}
</script>

</head>
<body>
<html:form action="/control/productManage/type/list" method="post">
  <table>
    <tr class="listHead">
      <td width="8%">代号</td>
      <td width="5%">修改</td>
      <td width="10%">产品类别名称</td>
	  <td width="10%">创建下级类别</td>
	  <td width="15%">所属父类</td>
	  <td>备注</td>
	  <td width="20%">创建时间</td>
    </tr>
  	<c:forEach items="${pageView.records }" var= "entity">
    <tr class="date">
      <td>${entity.typeId }</td>
      <td><img src="/images/edit.gif" width="15" height="16" border="0"></td>
      <td>${entity.name }</td>
	  <td>创建子类别</td>
	  <td><c:if test="${! empty entity.parentType.name }"> ${entity.parentType.name }</c:if></td>
	  <td>${entity.note }</td>
	  <td>${entity.createTime }</td>
	</tr>
	</c:forEach>
    <tr> 
      <td class="end" colspan="7">
      <table>
          <tr> 
            <td width="5%"></td>
              <td width="85%">
              <input name="AddDic" type="button" class="frm_btn" id="AddDic" onClick="javascript:window.location.href='<html:rewrite action="/control/product/type/manage"/>?method=addUI&parentid=${param.parentid}'" value="添加类别"> &nbsp;&nbsp;
			  <input name="query" type="button" class="frm_btn" id="query" onClick="javascript:window.location.href='<html:rewrite action="/control/product/type/manage"/>?method=queryUI'" value=" 查 询 "> &nbsp;&nbsp;
            </td>
          </tr>
        </table>
        </td>
    </tr>
  </table>
  </html:form>
</body>
</html>