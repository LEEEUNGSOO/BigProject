package com.sist.r;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;

//D:\springBigData\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SprongRecipeProject\main
@Component
public class RManager {
   public void rChefGraph()
   {
	   try
	   {
		   RConnection rc=new RConnection();
		   
		   // R import 
		   rc.voidEval("library(KoNLP)");
		   rc.voidEval("library(wordcloud2)");
		   rc.voidEval("library(webshot)");
		   rc.voidEval("library(htmlwidgets)");
		   
		   rc.voidEval("data<-readLines(\"c:/data/chef.txt\")");
		   //명사추출 
		   rc.voidEval("data1<-sapply(data, extractNoun,USE.NAMES = F)");
		   //순서없이 만들기 
		   rc.voidEval("data2<-unlist(data1)");
		   // 영어 , 숫자 제거 
		   rc.voidEval("data2<-gsub(\"[A-Za-z]\",\"\",data2)");
		   rc.voidEval("data2<-gsub(\"[0-9]\",\"\",data2)");
		   //2글자이상 자르기 
		   rc.voidEval("data3<-Filter(function(x){nchar(x)>=2},data2)");
		   //단어횟수 
		   rc.voidEval("data4<-table(data3)");
		   //내림차순으로 120개까지만 출력해라 
		   rc.voidEval("data5<-head(sort(data4,decreasing = T),120)");
		   //wordcloud2(demoFreq, size=1.6)
		   rc.voidEval("my_graph<-wordcloud2(data4,  size=1.6)");
		   //rc.voidEval("my_graph<-wordcloud2(data4, size = 0.7, shape = 'star')");
		   //html출력하기 
		   rc.voidEval("saveWidget(my_graph,\"D:/springBigData/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SprongRecipeProject/main/chef.html\",selfcontained = F)");
		   //rc.voidEval("dev.off()");
		   rc.close();
	   }catch(Exception ex){}
   }
}
