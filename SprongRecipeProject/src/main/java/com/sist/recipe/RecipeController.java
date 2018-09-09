package com.sist.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.RecipeDAO;
import com.sist.dao.RecipeVO;
import com.sist.r.RManager;

import java.io.*;
import java.util.*;
@Controller
public class RecipeController {
   @Autowired
   private RecipeDAO dao;
   @Autowired
   private RManager rm;
   @RequestMapping("main/main.do")
   public String main_page(String page,Model model)
   {
	   System.out.println("1");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<RecipeVO> list=dao.recipeListData(curpage);
	   System.out.println("size:"+list.size());
	   for(RecipeVO vo:list)
	   {
		   System.out.println(vo.getTitle());
	   }
	   model.addAttribute("list", list);
	   return "main/main";
   }
   @RequestMapping("main/chef.do")
   public String main_chef(String chef,Model model)
   {
	   List<RecipeVO> list=dao.recipeChefData(chef);
	   model.addAttribute("list", list);
	   String data="";
	   for(RecipeVO vo:list)
	   {
		   data+=vo.getTitle()+"\n";
	   }
	   try
	   {
		   File f=new File("c:\\data\\chef.txt");
		   if(f.exists())
			   f.delete();
		   FileWriter fw=new FileWriter("c:\\data\\chef.txt");
		   fw.write(data);
		   fw.close();
	   }catch(Exception ex){}
	   rm.rChefGraph();
	   return "main/chef";
   }
}
