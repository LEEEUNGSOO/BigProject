<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
    .row{
         margin: 0px auto;
         width: 800px;
    }
    h2{
        text-align: center;
    }
  </style>
  <!-- <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script> -->
  <script type="text/javascript">
   /* $(function(){
	   $('#keyword').keyup(function(){
		  var k=$(this).val();
		  $('#rt > tbody > tr').hide();
		  var temp=$('#rt > tbody > tr > td:nth-child(3n+2):contanis("'+k+'")');
		  $(temp).parent().show();
	   });
   }); */
   $(document).ready(function() {
       $("#keyword").keyup(function() {
           var k = $(this).val();
           $("#rt > tbody > tr").hide();
           var temp = $("#rt > tbody > tr > td:nth-child(3n+2):contains('" + k + "')");

           $(temp).parent().show();
       })
   })
  </script>
</head>
<body>
   <%-- <%= application.getRealPath("/") %> --%>
   <div class="container">
     <div class="row">
      <h2>레시피 검색</h2>
      <table class="table">
       <tr>
         <td>
           <form class="form-horizontal">
		    <div class="form-group">
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="keyword" placeholder="Enter FindData" >
		      </div>
		      <input type=button value="검색" class="btn btn-sm btn-danger">
		    </div>
         </td>
       </tr>
      </table>
      <table class="table table-hover" id="rt">
        <thead>
          <tr class="warning">
            <th></th>
            <th>제목</th>
            <th>세프</th>
          </tr>
        </thead>
        <tbody>
          <c:set var="color" value=""/>
          <c:forEach var="vo" items="${list }" varStatus="s">
            <c:if test="${s.index%2==0 }">
              <c:set var="color" value=""/>
            </c:if>
            <c:if test="${s.index%2==1 }">
              <c:set var="color" value="info"/>
            </c:if>
            <tr class="${color }">
             <td class="text-center">
              <img src="${vo.poster }" width=30 height="30">
             </td>
             <td>${vo.title }</td>
             <td class="text-center"><a href="chef.do?chef=${vo.chef }">${vo.chef }</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
     </div>
   </div>
</body>
</html>