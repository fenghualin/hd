package com.huanduguihua.user.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.huanduguihua.blue.question_1.bean.ReactionTest;
import com.huanduguihua.blue.question_2.bean.MatchingTest;
import com.huanduguihua.blue.question_3.bean.LoopTest;
import com.huanduguihua.blue.question_4.bean.CenterTest;
import com.huanduguihua.blue.question_5.bean.EmptyTest;
import com.huanduguihua.gray.question3.bean.Personality;
import com.huanduguihua.green.question1.bean.TestSearch;
import com.huanduguihua.green.question3.bean.TestOperationb;
import com.huanduguihua.green.question4.bean.TestTargetcompare;
import com.huanduguihua.green.question5.bean.TestPintu;
import com.huanduguihua.orange.quantion1.bean.TestPainting;
import com.huanduguihua.orange.question2.bean.ImageInation;
import com.huanduguihua.orange.question3.bean.ColorContrast;
import com.huanduguihua.red.question1.bean.TestAppearance;
import com.huanduguihua.red.question2.bean.TestThinking;
import com.huanduguihua.red.question3.bean.TestredOperation;
import com.huanduguihua.red.question4.bean.TestReasoning;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.violet.question1.bean.Induction;
import com.huanduguihua.violet.question2.bean.Logical;
import com.huanduguihua.wathet.question1.bean.MusicForm;
import com.huanduguihua.wathet.question2.bean.MusicLength;
import com.huanduguihua.wathet.question3.bean.MusicRhythm;
import com.huanduguihua.wathet.question4.bean.MusicCemory;
import com.huanduguihua.wathet.question5.bean.MusicAppreciate;
import com.huanduguihua.yellow.question1.bean.TestCompare;
import com.huanduguihua.yellow.question2.bean.TestOperation;
import com.huanduguihua.yellow.question3.bean.TestResult;
import com.huanduguihua.yellow.question4.bean.TestMaze;

public class ReportUtils {

	
	public void generateXzfy(List<ReactionTest> l,User u) {
		String content="---------------------------------------------------------------------------\r\nxzfy\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(int i =0 ;i<l.size();i++){
			ReactionTest reactionTest=l.get(i);
			Double time =Double.valueOf(reactionTest.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			if(reactionTest.getIs_true()==true)
				content=content+"\r\n"+getTime(d)+"          "+1;
			else
				content=content+"\r\n"+getTime(d)+"          "+0;
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	public void generateTxpp(List<MatchingTest> l,User u) {
		String content="---------------------------------------------------------------------------\r\ntxpp\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(int i=0;i<l.size();i++){
			MatchingTest matchingTest=l.get(i);
			Double time =Double.valueOf(matchingTest.getReactionTime());
			Double d  = (double) (time/1000/1000/1000);
			if(matchingTest.getIsTrue() == true)
				content=content+"\r\n"+getTime(d)+"          "+1;
			else
				content=content+"\r\n"+getTime(d)+"          "+0;
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	public void generateYyhl(List<LoopTest> l,User u) {
		String content="---------------------------------------------------------------------------\r\nyyhl\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(int i=0;i<l.size();i++){
			LoopTest loopTest=l.get(i);
			Double time =Double.valueOf(loopTest.getReactionTime());
			Double d  = (double) (time/1000/1000/1000);
			if(String.valueOf(loopTest.getCorrectAnswer()).equals(String.valueOf(loopTest.getReactionChoice()))){
				content=content+"\r\n"+getTime(d)+"          "+1;
			}
			else{
				content=content+"\r\n"+getTime(d)+"          "+0;
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	public void generateZyclq(List<CenterTest> l,User u) {
		String content="---------------------------------------------------------------------------\r\nzyclq\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(int i=0;i<l.size();i++){
			CenterTest centerTest=l.get(i);
			Double time =Double.valueOf(centerTest.getReactionTime());
			Double d  = (double) (time/1000/1000/1000);
			if(String.valueOf(centerTest.getCorrectAnswer()).equals(String.valueOf(centerTest.getReactionChoice()))){
				content=content+"\r\n"+getTime(d)+"          "+1;
			}
			else{
				content=content+"\r\n"+getTime(d)+"          "+0;
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	public void generateSkb(List<EmptyTest> l,User u) {
		String content="---------------------------------------------------------------------------\r\nskb\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(int i=0;i<l.size();i++){
			EmptyTest emptyTest=l.get(i);
			Double time =Double.valueOf(emptyTest.getReactionTime());
			Double d  = (double) (time/1000/1000/1000);
			if(String.valueOf(emptyTest.getCorrectAnswer()).equals(String.valueOf(emptyTest.getReactionChioce()))){
				content=content+"\r\n"+getTime(d)+"          "+1;
			}
			else{
				content=content+"\r\n"+getTime(d)+"          "+0;
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	public void generateSxjc(List<TestCompare> l,User u) {
		String content="---------------------------------------------------------------------------\r\nsxcy\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(int i=0;i<l.size();i++){
			TestCompare testCompare=l.get(i);
			Double time =Double.valueOf(testCompare.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			if(testCompare.getIs_true()==true)
				content=content+"\r\n"+getTime(d)+"          "+1;
			else
				content=content+"\r\n"+getTime(d)+"          "+0;
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	public void generateSxjct(List<TestOperation> l,User u) {
		String content="---------------------------------------------------------------------------\r\nsxcy2\r\n---------------------------------------------------------------------------";
		int y=0;
		if(l!=null){
		for(int i=0;i<l.size();i++){
			TestOperation testOperation=l.get(i);
			Double time =Double.valueOf(testOperation.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			if(testOperation.getStudent_answer()==null && y==0 && testOperation.getStep()==1){
				content=content+"\r\n  Segment "+testOperation.getStep()+": SelProblem: "+testOperation.getTest_no()+"  Answer: "+testOperation.getCorrect_answer();
				y=1;
			}
			else if(testOperation.getStudent_answer()==null && y==1 && testOperation.getStep()==2){
				int z=3+testOperation.getTest_no();
				content=content+"\r\n  Segment "+testOperation.getStep()+": SelProblem: "+z+"  Answer: "+testOperation.getCorrect_answer();
				y=2;
			}
			else if(testOperation.getStudent_answer()==null && y==2 && testOperation.getStep()==3){
				int z=7+testOperation.getTest_no();
				content=content+"\r\n  Segment "+testOperation.getStep()+": SelProblem: "+z+"  Answer: "+testOperation.getCorrect_answer();
				y=3;
			}
			if(testOperation.getStep()==1){
				content=content+"\r\n    UsedTime "+testOperation.getQuestion_no()+" : "+getTimethree(d);
			}
			else if(testOperation.getStep()==2){
				content=content+"\r\n    UsedTime "+testOperation.getQuestion_no()+" : "+getTimethree(d);
			}
			else if(testOperation.getStep()==3){
				content=content+"\r\n    UsedTime "+testOperation.getQuestion_no()+" : "+getTimethree(d);
			}
		}
		}
		
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	public void generateYycy(List<TestResult> l,User u) {
		String content="---------------------------------------------------------------------------\r\nyycy\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(int i=0;i<l.size();i++){
			TestResult testResult=l.get(i);
			Double time =Double.valueOf(testResult.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			if("A".equals(testResult.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+0;
			}
			else if("B".equals(testResult.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+1;
			}
			else if("C".equals(testResult.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+2;
			}
			else if("D".equals(testResult.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+3;
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	public void generateMaze(List<TestMaze> l,User u) {
		String content="---------------------------------------------------------------------------\r\nmaze\r\n---------------------------------------------------------------------------";
		if(l!=null){
		for(int i=0;i<l.size();i++){
			TestMaze testMaze=l.get(i);
			Double time =Double.valueOf(testMaze.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\nUsedTime: "+getTime(d)+" Hit: "+testMaze.getWall_number()+" Dead Area: "+testMaze.getBlindness_number();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 目标搜索
	 * @param l
	 * @param u
	 */
	public void generateMbss(List<TestSearch> l,User u) {
		String content="---------------------------------------------------------------------------\r\nmbss\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(int i=0;i<l.size();i++){
			TestSearch testSearch=l.get(i);
			Double time =Double.valueOf(testSearch.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+testSearch.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 目标比较
	 * @param l
	 * @param u
	 */
	public void generateMbbj(List<TestTargetcompare> l,User u) {
		String content="---------------------------------------------------------------------------\r\nmbbj\r\n---------------------------------------------------------------------------";
		if(l!=null){
		for(int i=0;i<l.size();i++){
			TestTargetcompare testTargetcompare=l.get(i);
			if(testTargetcompare.getTestNo()==9){
				Double time =Double.valueOf(testTargetcompare.getReactionTime());
				Double d  = (double) (time/1000/1000/1000);
				content = content+"\r\n  Segment 1: used_time="+getTime(d);
			}
		}
		for(int i=0;i<l.size();i++){
			TestTargetcompare testTargetcompare=l.get(i);
			if(testTargetcompare.getTestNo()<9){
				Double time =Double.valueOf(testTargetcompare.getReactionTime());
				Double d  = (double) (time/1000/1000/1000);
				content = content+"\r\n    Point "+testTargetcompare.getTestNo()+": "+testTargetcompare.getZuobiao()+" t="+getTime(d)+" "+testTargetcompare.getIs_true();
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 目标拼图
	 */
	public void generateMbpt(List<TestPintu> l , User u){
		String content="---------------------------------------------------------------------------\r\nmbpt\r\n---------------------------------------------------------------------------";
		if(l!=null){
		for(int i = 0 ; i < l.size() ; i ++){
			TestPintu testpintu=l.get(i);
			Double time =Double.valueOf(testpintu.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			Double stratthink =Double.valueOf(testpintu.getStart_think());
			Double d2  = (double) (stratthink/1000/1000/1000);
			content=content+"\r\n  UsedTime: "+getTimethree(d)+"  FirstTime: "+getTimethree(d2)+" MoveNumber: "+testpintu.getSum_step();
			if(testpintu.getQuestion_no()==1){
				for(int y=0;y<9;y++){
					content=content+"\r\n    Rect "+(y+1)+" selection: "+y;
				}
			}
			else if(testpintu.getQuestion_no()==2){
				for(int y=0;y<16;y++){
					content=content+"\r\n    Rect "+(y+1)+" selection: "+y;
				}
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 人际交往1
	 */
	public void generateRjjwo(List<TestResult> l , User u){
		String content="---------------------------------------------------------------------------\r\nrj1\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(TestResult t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			if("A".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+0;
			}
			else if("B".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+1;
			}
			else if("C".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+2;
			}
			else if("D".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+3;
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 人际交往2
	 */
	public void generateRjjwt(List<TestOperationb> l,User u ){
		String content="---------------------------------------------------------------------------\r\nrj2\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(TestOperationb t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			if("A".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+0;
			}
			else if("B".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+1;
			}
			else if("C".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+2;
			}
			else if("D".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+3;
			}
			else if("E".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+4;
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 空间操作
	 */
	public void generateKjcz(List<TestredOperation> l , User u ){
		String content="---------------------------------------------------------------------------\r\nkjcz\r\n---------------------------------------------------------------------------";
		if(l!=null){
		for(TestredOperation t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			Double stratthink =Double.valueOf(t.getStart_think());
			Double d2  = (double) (stratthink/1000/1000/1000);
			content=content+"\r\n  Segment "+t.getQuestion_no()+": UsedTime: "+getTimethree(d)+"  FirstTime: "+getTimethree(d2)+" MoveNumber: "+t.getSum_step();
			String[] mod=t.getMod().split(",");
			for(int i=0;i<mod.length;i++){
				content=content+"\r\n    Mod "+(i+1)+" : "+(mod[i].length()==0?"0":mod[i]);
			}
			String[] sel=t.getSel().split(",");
			for(int i=0;i<sel.length;i++){
				content=content+"\r\n    Sel "+(i+1)+" : "+(sel[i].length()==0?"0":sel[i]);
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 空间推理
	 */
	public void generateKjtl(List<TestReasoning> l , User u){
		String content="---------------------------------------------------------------------------\r\nkjtl\r\n---------------------------------------------------------------------------";
		if(l!=null){
		for(TestReasoning t : l){
			content=content+"\r\nRegion "+t.getQuestion_no()+":";
			if(t.getStudent_choicea()!=null && t.getStudent_choicea()>0){
				Double time =Double.valueOf(t.getReaction_time());
				Double d  = (double) (time/1000/1000/1000);
				content=content+"\r\n  Option 1 selection: "+t.getStudent_choicea();
				if(t.getStudent_choiceb()!=null && t.getStudent_choiceb()>0){
					content=content+"\r\n  Option 2 selection: "+t.getStudent_choiceb();
					if(t.getStudent_choicec()!=null && t.getStudent_choicec()>0){
						content=content+"\r\n  Option 3 selection: "+t.getStudent_choicec();
						content=content+"\r\n  UsedTime: "+getTime(d);
					}
					else{
						content=content+"\r\n  UsedTime: "+getTime(d);
					}
				}
				else{
					content=content+"\r\n  UsedTime: "+getTime(d);
				}
				
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 表象能力
	 */
	public void generateBxnl(List<TestAppearance> l , User u){
		String content="---------------------------------------------------------------------------\r\nbxnl\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(TestAppearance t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getReaction_chioce();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 思维转换能力
	 */
	public void generateSwzh(List<TestThinking> l , User u){
		String content="---------------------------------------------------------------------------\r\nswzh\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(TestThinking t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getReaction_chioce();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 空间比较
	 */
	public void generateKjbj(List<TestPainting> l , User u){
		String content="---------------------------------------------------------------------------\r\nkjbl\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(TestPainting t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 门萨艺术
	 */
	public void generateYsxx(List<ImageInation> l , User u){
		String content="---------------------------------------------------------------------------\r\nysxx\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(ImageInation t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 色彩对比
	 */
	public void generateScdb(List<ColorContrast> l , User u){
		String content="---------------------------------------------------------------------------\r\nscdb\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(ColorContrast t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 音调形象
	 */
	public void generateYdxx(List<MusicForm> l , User u){
		String content="---------------------------------------------------------------------------\r\nydxx\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(MusicForm t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 音长
	 */
	public void generateYc(List<MusicLength> l , User u){
		String content="---------------------------------------------------------------------------\r\nyc\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(MusicLength t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 节奏
	 */
	public void generateJzxx(List<MusicRhythm> l , User u){
		String content="---------------------------------------------------------------------------\r\njzxx\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(MusicRhythm t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 音的记忆
	 */
	public void generateYdjy(List<MusicCemory> l , User u){
		String content="---------------------------------------------------------------------------\r\nydjy\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(MusicCemory t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 音乐鉴赏
	 */
	public void generateYyjs(List<MusicAppreciate> l , User u){
		String content="---------------------------------------------------------------------------\r\nyyjs\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(MusicAppreciate t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 组织管理能力
	 */
	public void generateZzgl(List<TestResult> l , User u){
		String content="---------------------------------------------------------------------------\r\nzzgl\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(TestResult t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			if("A".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+0;
			}
			else if("B".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+1;
			}
			else if("C".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+2;
			}
			else if("D".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+3;
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 概念推理
	 */
	public void generateGntl(List<Induction> l , User u){
		String content="---------------------------------------------------------------------------\r\ngntl\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(Induction t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choicea()+t.getStudent_choiceb();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 逻辑推理
	 */
	public void generateLjtl(List<Logical> l , User u){
		String content="---------------------------------------------------------------------------\r\nljtl\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(Logical t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 职业心向
	 */
	public void generateZyxx(List<TestOperationb> l , User u,List<String> lstr){
		String content="---------------------------------------------------------------------------\r\nzyxx\r\n---------------------------------------------------------------------------";
		//System.out.println("report.list.size: " + l.size());
		if(l!=null){
		for(int i=0;i<l.size();i++){
			TestOperationb t =l.get(i);
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			if("A".equals(t.getStudent_choice()) || "0".equals(t.getStudent_choice())){
				content=content+"\r\n  Segment "+(t.getTest_no())+": selection="+0+" used_time="+getTime(d)+" ("+lstr.get(i)+")";
			}
			else if("B".equals(t.getStudent_choice()) || "1".equals(t.getStudent_choice())){
				content=content+"\r\n  Segment "+(t.getTest_no())+": selection="+1+" used_time="+getTime(d)+" ("+lstr.get(i)+")";
			}
			else if("C".equals(t.getStudent_choice()) || "2".equals(t.getStudent_choice())){
				content=content+"\r\n  Segment "+(t.getTest_no())+": selection="+2+" used_time="+getTime(d)+" ("+lstr.get(i)+")";
			}
			else if("D".equals(t.getStudent_choice()) || "3".equals(t.getStudent_choice())){
				content=content+"\r\n  Segment "+(t.getTest_no())+": selection="+3+" used_time="+getTime(d)+" ("+lstr.get(i)+")";
			}
			else if("E".equals(t.getStudent_choice()) || "4".equals(t.getStudent_choice())){
				content=content+"\r\n  Segment "+(t.getTest_no())+": selection="+4+" used_time="+getTime(d)+" ("+lstr.get(i)+")";
			} else {
				System.out.println("未识别的选项：" + t.getStudent_choice());
			}
			
		}
		for(int i =1;i<36;i++){
			content=content+"\r\n  Module "+i+" score: 1.667";
		}
		}
		
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 人格1
	 */
	public void generateRgo(List<TestOperationb> l , User u){
		String content="---------------------------------------------------------------------------\r\nrg1\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(TestOperationb t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			if("A".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+0;
			}
			else if("B".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+1;
			}
			else if("C".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+2;
			}
			else if("D".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+3;
			}
			else if("E".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+4;
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 人格投射1
	 */
	public void generateRgtso(List<Personality> l , User u){
		String content="---------------------------------------------------------------------------\r\nrgts1\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(Personality t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			content=content+"\r\n"+getTime(d)+"          "+t.getStudent_choice();
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content+"\r\n");
	}
	/**
	 * 人格2
	 */
	public void generateRgt(List<TestOperationb> l , User u){
		String content="---------------------------------------------------------------------------\r\nrg2\r\n---------------------------------------------------------------------------\r\nUsedTime  Selection";
		if(l!=null){
		for(TestOperationb t:l){
			Double time =Double.valueOf(t.getReaction_time());
			Double d  = (double) (time/1000/1000/1000);
			if("A".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+0;
			}
			else if("B".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+1;
			}
			else if("C".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+2;
			}
			else if("D".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+3;
			}
			else if("E".equals(t.getStudent_choice())){
				content=content+"\r\n"+getTime(d)+"          "+4;
			}
		}
		}
		CreateTxt.contentToTxt(getwebpath()+"download/data/"+u.getUsername()+".txt", content);
	}
	/**
	 * 获取webroot的绝对路径
	 */
	public static String getwebpath(){
		String webpath = "";
		try {
			URL url = ReportUtils.class.getProtectionDomain().getCodeSource().getLocation();
			String runningPath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
			webpath = runningPath.substring(1,runningPath.lastIndexOf("WEB-INF"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webpath;
	}
	
	/**
	 * 返回8位小数
	 * @param d
	 * @return
	 */
	public static String getTime(Double d){
		String str = String.valueOf(d);
		String s = str.substring(str.indexOf(".")+1, str.length());
		int y=s.length();
		if(s.length()<8){
			for(int i =0;i<(8-y);i++){
				s=s+"0";
			}
		}
		else{
			s=s.substring(0,8);
		}
		str= str.substring(0, str.indexOf(".")+1);
		return str+s;
	}
	/**
	 * 返回3位小数
	 * @param d
	 * @return
	 */
	public static String getTimethree(Double d){
		String str = String.valueOf(d);
		String s = str.substring(str.indexOf(".")+1, str.length());
		int y=s.length();
		if(s.length()<3){
			for(int i =0;i<(3-y);i++){
				s=s+"0";
			}
		}
		else{
			s=s.substring(0,3);
		}
		str= str.substring(0, str.indexOf(".")+1);
		return str+s;
	}
	/**
	 * 文件下载
	 */
	public static boolean FileDown(HttpServletResponse response,File file){
		
		if(file == null || file.getName() == "") return false;
		
		response.reset();
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition",  "attachment;filename=" + new String(file.getName().getBytes()));
		response.addHeader("Content-Length", "" + file.length());
		
		try {
			OutputStream fos = response.getOutputStream();
			FileInputStream fis = new FileInputStream(file);
			
			byte[] bytes = new byte[1024];
			int length = -1;
			while((length = fis.read(bytes)) != -1){
				fos.write(bytes, 0, length);
				fos.flush();
				Thread.sleep(10);
			}
			fos.close();
			fis.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
