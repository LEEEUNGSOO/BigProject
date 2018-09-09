<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
    width:800px;
}
h2{
   text-align: center;
}
</style>
</head>
<body>
    <div class="container">
      <div class="row">
       <h2>수정하기</h2>
       <form method=post action="board_update_ok.do">
       <table class="table table-hover">
         <tr>
           <td width=20% class="text-right">이름</td>
           <td width=80% class="text-left">
            <input type=text name=name size=12 value="${vo.name }">
            <input type=hidden name=no value="${vo.no }">
           </td>
         </tr>
         <tr>
           <td width=20% class="text-right">제목</td>
           <td width=80% class="text-left">
            <input type=text name=subject size=45 value="${vo.subject }">
           </td>
         </tr>
         <tr>
           <td width=20% class="text-right">내용</td>
           <td width=80% class="text-left">
            <textarea rows="10" cols="55" name=content>${vo.content }</textarea>
           </td>
         </tr>
         <tr>
           <td width=20% class="text-right">비밀번호</td>
           <td width=80% class="text-left">
            <input type=password name=pwd size=10>
           </td>
         </tr>
         <tr>
           <td colspan="2" class="text-center">
            <input type=submit value=수정 class="btn btn-sm btn-primary">
            <input type=button value=취소 class="btn btn-sm btn-success" onclick="javascript:history.back()">
           </td>
         </tr>
       </table>
       </form>
      </div>
    </div>
</body>
</html>