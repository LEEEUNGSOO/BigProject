package com.sist.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 *   일반 Controller : forward,sendRedirect
 *                   list.jsp,list.do
 *   RestController : 파일 전송==> 일반 문자열 전송 
 *                    ajax , 스크립트 
 *                    @ResponseBody
 */

import com.sist.dao.*;
@RestController
public class BoardRestController {
    @Autowired
    private BoardDAO dao;
    @RequestMapping("main/board_update_ok.do")
    public String board_update_ok(BoardVO vo)
    {
    	String data="<script>alert(\"비밀번호가 틀립니다\");history.back();</script>";
    	boolean bCheck=dao.boardUpdateOk(vo.getNo(), vo);
    	if(bCheck==true)
    	{
    		data="<script>location.href=\"board_content.do?no="+vo.getNo()+"\";</script>";
    	}
    	return data;
    }
    @RequestMapping("main/board_delete.do")
    public String board_delete(int no,String pwd)
    {
    	String data="<script>alert(\"비밀번호가 틀립니다\");history.back();</script>";
    	boolean bCheck=dao.boardDelete(no, pwd);
    	if(bCheck==true)
    	{
    		data="<script>location.href=\"board_list.do\";</script>";
    	}
    	return data;
    }
}
