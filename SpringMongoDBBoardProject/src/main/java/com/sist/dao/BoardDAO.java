package com.sist.dao;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDAO {
  @Autowired
  private MongoTemplate mt;
  public void boardInsert(BoardVO vo)
  {
	  Query query=new Query(); // Á¶°Ç
	  // WHERE
	  List<BoardVO> list=mt.find(query, BoardVO.class,"board");
	  int max=0;
	  for(BoardVO bvo:list)
	  {
		  if(max<bvo.getNo())
			  max=bvo.getNo();
	  }
	  vo.setNo(max+1);
	  vo.setHit(0);
	  vo.setRegdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	  mt.insert(vo,"board");
  }
  public List<BoardVO> boardListData(int page)
  {
	  List<BoardVO> list=new ArrayList<BoardVO>();
	  Query query=new Query();
	  int rowSize=10;
	  int skip=(rowSize*page)-rowSize;
	  query.skip(skip).limit(rowSize);
	  query.with(new Sort(Sort.Direction.DESC,"no"));
	  list=mt.find(query, BoardVO.class,"board");
	  return list;
  }
  public int boardTotalpage()
  {
	  Query query=new Query();
	  int count=(int)mt.count(query, "board");//long  select count(*) from table_name
	  return (int)(Math.ceil(count/10.0));
  }
  public BoardVO boardContentData(int no)
  {
	  BoardVO vo=new BoardVO();
	  BasicQuery query=new BasicQuery("{no:"+no+"}");// find({no:1})
	  Update update=new Update();
	  vo=mt.findOne(query, BoardVO.class,"board");
	  update.set("hit", vo.getHit()+1);
	  mt.updateFirst(query, update, "board");
	  vo=mt.findOne(query, BoardVO.class,"board");
	  return vo;
  }
  public BoardVO boardUpdateData(int no)
  {
	  BoardVO vo=new BoardVO();
	  BasicQuery query=new BasicQuery("{no:"+no+"}");// find({no:1})
	  vo=mt.findOne(query, BoardVO.class,"board");
	  return vo;
  }
  public boolean boardUpdateOk(int no,BoardVO vo)
  {
	  boolean bCheck=false;
	  BasicQuery query=new BasicQuery("{no:"+no+"}");//where no=1
	  BoardVO pvo=mt.findOne(query, BoardVO.class,"board");
	  if(vo.getPwd().equals(pvo.getPwd()))
	  {
		  bCheck=true;
		  Update update=new Update();
		  update.set("name", vo.getName());
		  update.set("subject", vo.getSubject());
		  update.set("content", vo.getContent());
		  mt.updateFirst(query, update, "board");
	  }
	  return bCheck;
  }
  public boolean boardDelete(int no,String pwd)
  {
	  boolean bCheck=false;
	  BasicQuery query=new BasicQuery("{no:"+no+"}");//where no=1
	  BoardVO vo=mt.findOne(query, BoardVO.class,"board");
	  if(pwd.equals(vo.getPwd()))
	  {
		  bCheck=true;
		  mt.remove(query, "board");
	  }
	  return bCheck;
  }
}





