package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class RecipeDAO {
   @Autowired
   private MongoTemplate mt;
   public void recipeInsert(RecipeVO vo)
   {
	   Query query=new Query();
	   List<RecipeVO> list=mt.find(query, RecipeVO.class,"repice");
	   
	   int max=0;
	   for(RecipeVO rvo:list)
	   {
		   if(max<rvo.getNo())
			   max=rvo.getNo();
	   }
	   
	   vo.setNo(max+1);
	   
	   mt.insert(vo,"repice");
	   
   }
   public List<RecipeVO> recipeListData(int page)
   {
	   List<RecipeVO> list=new ArrayList<RecipeVO>();
	   Query query=new Query();
	   int rowSize=100;
	   int skip=(rowSize*page)-rowSize;  // 0 ,100 ,200...
	   query.skip(skip).limit(rowSize);
	   list=mt.find(query, RecipeVO.class,"repice");// select * from recipe where
	   // {}
	   return list;
   }
   public List<RecipeVO> recipeChefData(String chef)
   {
	   List<RecipeVO> list=new ArrayList<RecipeVO>();
	   BasicQuery query=new BasicQuery("{chef:'"+chef+"'}");
	   // {chef:{$regex:'.*'+chef}}
	   list=mt.find(query, RecipeVO.class,"repice");
	   return list;
   }
}
