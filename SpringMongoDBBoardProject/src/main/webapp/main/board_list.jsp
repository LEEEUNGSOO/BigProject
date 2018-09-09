<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ �Խ���</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
    margin: 0px auto;
    width:800px;
}
h2{
   text-align: center;
}
</style>

</head>
<body>
<%= application.getRealPath("/main") %>
   <div class="container">
     <div class="row">
       <h2>������ �Խ���</h2>
       <table class="table">
        <tr>
          <td class="text-left">
           <a  href="board_insert.do"  class="btn btn-sm btn-danger">����</a>
          </td>
        </tr>
       </table>
       <table class="table table-hover">
         <tr class="danger">
          <th width="10%" class="text-center">��ȣ</th>
          <th width="45%" class="text-center">����</th>
          <th width="15%" class="text-center">�̸�</th>
          <th width="20%" class="text-center">�ۼ���</th>
          <th width="10%" class="text-center">��ȸ��</th>
         </tr>
         <c:set var="color" value=""/>
         <c:forEach var="vo" items="${list }" varStatus="s">
          <c:if test="${s.index%2==0 }">
            <c:set var="color" value=""/>
          </c:if>
          <c:if test="${s.index%2!=0 }">
            <c:set var="color" value="warning"/>
          </c:if>
          <tr class="${color }">
	          <td width="10%" class="text-center">${s.count }</td>
	          <td width="45%" class="text-left"><a href="board_content.do?no=${vo.no }">${vo.subject }</a></td>
	          <td width="15%" class="text-center">${vo.name}</td>
	          <td width="20%" class="text-center">${vo.regdate }</td>
	          <td width="10%" class="text-center">${vo.hit }</td>
          </tr>
         </c:forEach>
       </table>
       <table class="table">
         <tr>
          <td class="text-left">
           Search:<select name=fs>
            <option value="name">�̸�</option>
            <option value="subject">����</option>
            <option value="content">����</option>
           </select>
           <input type=text name=ss size=12>
           <input type=button value="ã��" class="btn btn-sm btn-primary">
          </td>
          <td class="text-right">
            <a href="board_list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-info">����</a>
              ${curpage } page / ${totalpage } pages
            <a href="board_list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-success">����</a>
          </td>
         </tr>
       </table>
     </div>
   </div>
</body>
</html>