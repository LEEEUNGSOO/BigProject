package com.sist.dao;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
/*
 *   <div class="col-xs-4">
        <a class="thumbnail" href="/recipe/6874112">
			            <span class="thumbnail_over"><img src="http://recipe.ezmember.co.kr/img/thumb_over.png"></span>
            <img src="http://recipe.ezmember.co.kr/cache/recipe/2017/08/05/55cff86c9945bffdafb217c3df8552db1_m.jpg" style="width:275px; height:275px;">
          <div class="caption">
            <h4 class="ellipsis_title2">간편 츄러스/추로스</h4>
            <p>by 밥심은국력</p>
          </div>
        </a>
 */
@Component
public class RecipeManager {
	@Autowired
	private RecipeDAO dao;
	public static void main(String[] arg)
	{
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		RecipeManager rm=(RecipeManager)app.getBean("recipeManager");
		List<RecipeVO> list=rm.recipeAllData();
		for(RecipeVO vo:list)
		{
			rm.dao.recipeInsert(vo);
		}
		System.out.println("end..");
	}
	public List<RecipeVO> recipeAllData()//1
	{
		List<RecipeVO> list=new ArrayList<RecipeVO>();
		try
		{
			for(int i=1;i<=1000;i++)
			{
				Document doc=Jsoup.connect("http://www.10000recipe.com/recipe/list.html?order=accuracy&page="+i).get();
				Elements title=doc.select("div.col-xs-4 div.caption h4.ellipsis_title2");
				Elements poster=doc.select("div.col-xs-4 a.thumbnail img[src*=/recipe/]");
				Elements chef=doc.select("div.col-xs-4 div.caption p");
				for(int j=0;j<title.size();j++)
				{
					System.out.println(title.get(j).text()+" "+chef.get(j).text()+" "+poster.get(j).attr("src"));
					RecipeVO vo=new RecipeVO();
					vo.setPoster(poster.get(j).attr("src"));
					vo.setTitle(title.get(j).text());
					vo.setChef(chef.get(j).text());
					list.add(vo);
				}
			}
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
