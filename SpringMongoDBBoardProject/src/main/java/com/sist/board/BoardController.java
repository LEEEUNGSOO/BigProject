package com.sist.board;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.r.RManager;
@Controller
public class BoardController {
   @Autowired
   private BoardDAO dao;
   @Autowired
   private RManager rm;
   @RequestMapping("main/board_insert.do")
   public String board_insert()
   {
	   return  "main/board_insert";
   }
   @RequestMapping("main/board_insert_ok.do")
   public String board_insert_ok(BoardVO vo)
   {
	   dao.boardInsert(vo);
	   return "redirect:board_list.do";
   }
   @RequestMapping("main/board_list.do")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   
	   int curpage=Integer.parseInt(page);
	   List<BoardVO> list=dao.boardListData(curpage);
	   int totalpage=dao.boardTotalpage();
	   
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   
	   return "main/board_list";
   }
   @RequestMapping("main/board_content.do")
   public String board_content(int no,Model model)
   {
	   BoardVO vo=dao.boardContentData(no);
	   model.addAttribute("vo", vo);
	   try
	   {
		   FileWriter fw=new FileWriter("c:\\data\\board.txt");
		   fw.write(vo.getContent());
		   fw.close();
	   }catch(Exception ex){}
	   
	   /*rm.rGraph(vo.getNo());*/
	   
	   return "main/board_content";
   }
   @RequestMapping("main/board_update.do")
   public String board_update(int no,Model model)
   {
	   BoardVO vo=dao.boardUpdateData(no);
	   model.addAttribute("vo", vo);
	   return "main/board_update";
   }
   
}
