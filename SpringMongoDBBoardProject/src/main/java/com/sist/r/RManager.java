package com.sist.r;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;
// D:\springBigData\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMongoDBBoardProject\main
@Component
public class RManager {
   public void rGraph(int no)
   {
	   try
	   {
		   RConnection rc=new RConnection();
		   rc.setStringEncoding("utf8");
		   rc.voidEval("library(wordcloud2)");
		   rc.voidEval("library(htmlwidgets)");
		   rc.voidEval("library(KoNLP)");
		   rc.voidEval("library(webshot)");
		   rc.voidEval("data<-readLines(\"c:/data/board.txt\")");
		   rc.voidEval("data1<-sapply(data, extractNoun,USE.NAMES = F)");
		   rc.voidEval("data2<-unlist(data1)");
		   rc.voidEval("data3<-Filter(function(x){nchar(x)>=2},data2)");
		   rc.voidEval("data4<-table(data3)");
		  // rc.voidEval("webshot::install_phantomjs()");
		   rc.voidEval("my_graph=wordcloud2(data4, size=1.5,shape = 'star')");
		   rc.voidEval("saveWidget(my_graph,\"D:/springBigData/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMongoDBBoardProject/main/board.html\",selfcontained = F)");
		   rc.voidEval("dev.off()");
		   rc.close();
	   }catch(Exception ex){}
   }
}
