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
<script type="text/javascript">
var no=0;
$(function(){
	$('#delBtn').click(function(){
		if(no==0)
		{
			no=1;
			$('#delBtn').text("취소");
			$('#del').show();
		}
		else
		{
			no=0;
			$('#delBtn').text("삭제");
			$('#del').hide();
		} 
	});
	
	/* var flag=false;
	$("input[text]").each(function(){
		if($(this).val().length==0){
			flag=true;
			return false;
		}		
	});
	if(!flag)
	$("form").submit(); */
	
});
</script>
</head>
<body>
   <div class="container">
    <div class="row">
     <h2>내용보기</h2>
     <table class="table table-hover">
      <tr>
       <td class="success text-center" width=20%>번호</td>
       <td class="text-center" width=30%>${vo.no }</td>
       <td class="success text-center" width=20%>작성일</td>
       <td class="text-center" width=30%>${vo.regdate }</td>
      </tr>
      <tr>
       <td class="success text-center" width=20%>이름</td>
       <td class="text-center" width=30%>${vo.name }</td>
       <td class="success text-center" width=20%>조회수</td>
       <td class="text-center" width=30%>${vo.hit }</td>
      </tr>
      <tr>
       <td class="success text-center" width=20%>제목</td>
       <td class="text-left" colspan="3">${vo.subject }</td>
      </tr>
      <tr>
       <td class="text-left" valign="top" colspan="4" height="200">${vo.content }</td>
      </tr>
     </table>
     <table class="table">
      <tr>
       <td class="text-right">
        <a href="board_update.do?no=${vo.no }" class="btn btn-sm btn-warning">수정</a>
        <a class="btn btn-sm btn-success" id="delBtn">삭제</a>
        <a href="board_list.do" class="btn btn-sm btn-danger">목록</a>
       </td>
      </tr>
      <tr id="del" style="display:none">
        <td class="text-right">
         <form method="post" action="board_delete.do">
                         비밀번호:<input type=password name=pwd size=10>
               <input type=hidden name=no value="${vo.no }">
               <input type=submit value="삭제" class="btn btn-sm btn-info">
         </form>
        </td>
      </tr>
     </table>
    <!--  <iframe src="board.html" frameborder="0" width=800 height=500></iframe> -->
    </div>
   </div>
</body>
</html>






