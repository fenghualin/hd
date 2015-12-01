/**
 * com.huanduguihua.user.service.impl
 * UserServiceImpl.java
 * 
 * 2014-5-14-下午4:43:53
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.user.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.huanduguihua.blue.question_1.bean.ReactionTest;
import com.huanduguihua.blue.question_1.service.ReactionTestService;
import com.huanduguihua.blue.question_2.bean.MatchingTest;
import com.huanduguihua.blue.question_2.service.MatchingTestService;
import com.huanduguihua.blue.question_3.bean.LoopTest;
import com.huanduguihua.blue.question_3.service.LoopTestService;
import com.huanduguihua.blue.question_4.bean.CenterTest;
import com.huanduguihua.blue.question_4.service.CenterTestService;
import com.huanduguihua.blue.question_5.bean.EmptyTest;
import com.huanduguihua.blue.question_5.service.EmptyTestService;
import com.huanduguihua.gray.question3.bean.Personality;
import com.huanduguihua.gray.question3.service.PersonalityService;
import com.huanduguihua.gray.question4.bean.Rgtstbean;
import com.huanduguihua.gray.question4.service.RgtstbeanService;
import com.huanduguihua.green.question1.bean.TestSearch;
import com.huanduguihua.green.question1.service.TestSearchService;
import com.huanduguihua.green.question3.bean.TestOperationb;
import com.huanduguihua.green.question3.service.TestOperationbService;
import com.huanduguihua.green.question4.bean.TestTargetcompare;
import com.huanduguihua.green.question4.service.TestTargetcompareService;
import com.huanduguihua.green.question5.bean.TestPintu;
import com.huanduguihua.green.question5.service.TestPintuService;
import com.huanduguihua.manager.bean.TestQuestionLang2;
import com.huanduguihua.manager.service.TestQuestionLangService2;
import com.huanduguihua.orange.quantion1.bean.TestPainting;
import com.huanduguihua.orange.quantion1.service.TestPaintingService;
import com.huanduguihua.orange.question2.bean.ImageInation;
import com.huanduguihua.orange.question2.service.ImageInationService;
import com.huanduguihua.orange.question3.bean.ColorContrast;
import com.huanduguihua.orange.question3.service.ColorContrastService;
import com.huanduguihua.red.question1.bean.TestAppearance;
import com.huanduguihua.red.question1.service.TestAppearanceService;
import com.huanduguihua.red.question2.bean.TestThinking;
import com.huanduguihua.red.question2.service.TestThinkingService;
import com.huanduguihua.red.question3.bean.TestredOperation;
import com.huanduguihua.red.question3.service.TestredOperationService;
import com.huanduguihua.red.question4.bean.TestReasoning;
import com.huanduguihua.red.question4.service.TestReasoningService;
import com.huanduguihua.system.dat.ExcelUtil;
import com.huanduguihua.system.dat.Generate;
import com.huanduguihua.system.dat.UserData;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.user.bean.Mokuai;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.bean.search.UserSearch;
import com.huanduguihua.user.service.CreateTxt;
import com.huanduguihua.user.service.ReportUtils;
import com.huanduguihua.user.service.UserService;
import com.huanduguihua.violet.question1.bean.Induction;
import com.huanduguihua.violet.question1.service.InductionService;
import com.huanduguihua.violet.question2.bean.Logical;
import com.huanduguihua.violet.question2.service.LogicalService;
import com.huanduguihua.wathet.question1.bean.MusicForm;
import com.huanduguihua.wathet.question1.service.MusicFormService;
import com.huanduguihua.wathet.question2.bean.MusicLength;
import com.huanduguihua.wathet.question2.service.MusicLengthService;
import com.huanduguihua.wathet.question3.bean.MusicRhythm;
import com.huanduguihua.wathet.question3.service.MusicRhythmService;
import com.huanduguihua.wathet.question4.bean.MusicCemory;
import com.huanduguihua.wathet.question4.service.MusicCemoryService;
import com.huanduguihua.wathet.question5.bean.MusicAppreciate;
import com.huanduguihua.wathet.question5.service.MusicAppreciateService;
import com.huanduguihua.yellow.question1.bean.TestCompare;
import com.huanduguihua.yellow.question1.service.TestCompareService;
import com.huanduguihua.yellow.question2.bean.TestOperation;
import com.huanduguihua.yellow.question2.service.TestOperationService;
import com.huanduguihua.yellow.question3.bean.TestResult;
import com.huanduguihua.yellow.question3.service.TestResultService;
import com.huanduguihua.yellow.question4.bean.TestMaze;
import com.huanduguihua.yellow.question4.service.TestMazeService;

/**
 * 
 * UserServiceImpl
 * 
 * kin
 * kin
 * 2014-5-14 下午4:43:53
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
@Service
public class UserServiceImpl extends DefaultServiceImpl implements UserService {
	
	@Autowired ReactionTestService reactionTestService;
	@Autowired MatchingTestService matchingTestService;
	@Autowired LoopTestService loopTestService;
	@Autowired CenterTestService centerTestService;
	@Autowired EmptyTestService emptyTestService;
	@Autowired TestCompareService testCompareService;
	@Autowired TestOperationService testOperationService;
	@Autowired TestResultService testResultService;
	@Autowired TestMazeService testMazeService;
	@Autowired TestSearchService testSearchService;
	@Autowired TestTargetcompareService testTargetcompareService;
	@Autowired TestPintuService testPintuService;
	@Autowired TestOperationbService testOperationbService;
	@Autowired TestredOperationService testredOperationService;
	@Autowired TestReasoningService testReasoningService;
	@Autowired TestAppearanceService testAppearanceService;
	@Autowired TestThinkingService testThinkingService;
	@Autowired TestPaintingService testPaintingService;
	@Autowired ImageInationService imageInationService;
	@Autowired ColorContrastService colorContrastService;
	@Autowired MusicFormService musicFormService;
	@Autowired MusicLengthService musicLengthService;
	@Autowired MusicRhythmService musicRhythmService;
	@Autowired MusicCemoryService musicCemoryService;
	@Autowired MusicAppreciateService musicAppreciateService;
	@Autowired InductionService inductionService;
	@Autowired LogicalService logicalService;
	@Autowired TestQuestionLangService2 testQuestionLangService2;
	@Autowired PersonalityService personalityService;
	@Autowired RgtstbeanService rgtstbeanService;
	
	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, User.class);
	}

	
	public UserSearch list(UserSearch search,String pagestart,String pagesize,String sort,String order) throws ServiceException {
		//内容查询
		String query = " select * ";
		
		//条件语句
		String where = " from test_system_user where 1 ";
		
		//如果这里有条件，则where += " and xxx = xxxx";
//		where += " and account_id = " + search.getAccountId();
		if (search.getQueryValue()!=null) {
			where += " and jigou = " + search.getQueryValue();
		}
		if(search.getSearchkey()!=null){
			where += " and "+search.getSearchkey()+" = '" + search.getSearchval()+"'";
		}
		//排序
		String searchOrder = " order by wancheng_time desc";
		if(sort!=null && order!=null){
			searchOrder = " order by "+sort+" "+order;
		}
		search.setQuery(query);
		search.setWhere(where);
		search.setOrder(searchOrder);
		search.setPage(Integer.parseInt(pagestart));
		search.setPageSize(Integer.parseInt(pagesize));
		//调用super.queryBySearch之后会重置query、where、order、param参数
		return (UserSearch) super.queryBySearch(search);
	}
	
	@Override
	public User checkLogin(String username, String password)
			throws ServiceException {
		List<Map<String, Object>> datas = null;
		try {
			if (password.length() < 32) {
				password = DigestUtils.md5DigestAsHex((password).getBytes());
			}
			datas = super.executeQuery("select * from test_system_user where username = ? and password=?", username, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
		if (datas == null || datas.size() == 0) {
			User u = null;
			return u;
		} else {
			return (User) this.pack(datas).get(0);
		}
	}

	@Override
	public User update(User user) throws ServiceException {
		try {
			user = (User) super.update(user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
//		try {
//			if (user.getId() == null) {
//				//添加用户
//				user.setId(super.generateId("test_system_user"));
//				super.executeUpdate("insert into test_system_user(id,name,username,password,create_time,xingbie,nianling,minzu,xueli," +
//						"nianji,banji,xueshengleixing,yuanxuexileixing,shenfenzheng,fuqinxingming,muqinxingming,fuqinnianling," +
//						"muqinnianling,danwei,gudingdianhua,yidongdianhua,email,dizhi,shili,tingli,sejue) " +
//						"values(?,?,?,?,now(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", user.getId(), user.getName(), user.getUsername(), 
//						user.getPassword(), user.getXingbie(), user.getNianling(), user.getMinzu(), user.getXueli(), user.getNianji(), user.getBanji(),
//						user.getXueshengleixing(), user.getYuanxuelileixing(), user.getShenfenzheng(), user.getFuqinxingming(), user.getMuqinxingming(),
//						user.getFuqinnianling(), user.getMuqinnianling(), user.getDanwei(), user.getGudingdianhua(), user.getYidongdianhua(),
//						user.getEmail(), user.getDizhi(), user.getShili(), user.getTingli(), user.getSejue());
//			} else {
//				//更新用户
//				super.executeUpdate("update test_system_user set name=?,username=?,password=?,xingbie=?,nianling=?,minzu=?,xueli=?,nianji=?," +
//						"banji=?,xueshengleixing=?,yuanxuexileixing=?,shenfenzheng=?,fuqinxingming=?,muqinxingming=?,fuqinnianling=?,muqinnianling=?," +
//						"danwei=?,gudingdianhua-?,yidongdianhua=?,email=?,dizhi=?,shili=?,tingli=?,sejue=? where id=?", user.getName(),user.getUsername(),
//						user.getPassword(), user.getXingbie(), user.getNianling(), user.getMinzu(), user.getXueli(), user.getNianji(),
//						user.getBanji(), user.getXueshengleixing(), user.getYuanxuelileixing(), user.getShenfenzheng(), user.getFuqinxingming(),
//						user.getMuqinxingming(), user.getFuqinnianling(), user.getMuqinnianling(), user.getDanwei(), user.getGudingdianhua(), user.getYidongdianhua(),
//						user.getEmail(), user.getDizhi(), user.getShili(), user.getTingli(), user.getSejue(), user.getId());
//			}
//			return user;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new ServiceException();
//		}
	}


	@Override
	public User get(Integer id) throws ServiceException {
		try {
			List<Map<String, Object>> datas = super.executeQuery("select * from test_system_user where id=?", id);
			if (datas.size() == 0) {
				return new User();
			} else {
				return (User) this.pack(datas).get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}


	@Override
	public void delete(Integer id) throws ServiceException {
		try {
			super.executeUpdate("delete from test_system_user where id=?", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}


	@Override
	public boolean checkUsername(String uname) {
		String sql="select id from test_system_user where username=?";
		List<Map<String, Object>> l = super.executeQuery(sql, uname);
		if(l.size() == 0){
			return true;
		}
		else{
			return false;
		}
	}


	@Override
	public List<ReactionTest> listquestionqk(String uid,String tablename,String kinds,HttpServletRequest request) {
		String sql1="select * from test_reaction where user_id=? order by question_no asc";
		String sql2="select * from test_macthing where user_id=? order by question_no asc";
		String sql3="select * from test_loop where user_id=? order by question_no asc";
		String sql4="select * from test_center where user_id=? order by question_no asc";
		String sql5="select * from test_empty where user_id=? order by question_no asc";
		String sql6="select * from test_compare where user_id=? order by question_no asc";
		String sql7="select * from test_operation where user_id=? order by question_no asc";
		String sql8="select * from test_resilt where user_id=? and kinds=2 order by question_no asc";
		String sql9="select * from test_maze where user_id=?";
		String sql10="select * from test_search where user_id=? order by question_no asc";
		String sql11="select * from test_targetcompare where user_id=? order by test_no asc";
		String sql12="select * from test_pintu where user_id=? order by question_no asc";
		String sql13="select * from test_resilt where user_id=? and kinds=4 order by question_no asc";
		String sql14="select * from test_operationb where user_id=? and kinds=1 order by test_no asc";
		String sql15="select * from test_redoperation where user_id=? order by question_no asc";
		String sql16="select * from test_reasoning where user_id=? order by question_no asc";
		String sql17="select * from test_appearance where user_id=? order by question_no asc";
		String sql18="select * from test_thinking where user_id=? order by question_no asc";
		String sql19="select * from test_painting where user_id=? order by question_no asc";
		String sql20="select * from test_imageination where user_id=? order by question_no asc";
		String sql21="select * from test_colorcontrast where user_id=? order by question_no asc";
		String sql22="select * from test_musicform where user_id=? order by question_no asc";
		String sql23="select * from test_musiclength where user_id=? order by question_no asc";
		String sql24="select * from test_musicrhythm where user_id=? order by question_no asc";
		String sql25="select * from test_musiccemory where user_id=? order by question_no asc";
		String sql26="select * from test_musicappreciate where user_id=? order by question_no asc";
		String sql27="select * from test_resilt where user_id=? and kinds=1 order by question_no asc";
		String sql28="select * from test_induction where user_id=?  order by question_no asc";
		String sql29="select * from test_logical where user_id=?  order by question_no asc";
		String sql30="select * from test_operationb where user_id=? and kinds=2 order by test_no asc";
		String sql31="select * from test_operationb where user_id=? and kinds=3 order by test_no asc";
		String sql32="select * from test_personality where user_id=?  order by question_no asc";
		String sql33="select * from test_operationb where user_id=? and kinds=4 order by test_no asc";
		
		if("test_reaction".equals(tablename)){
			List<ReactionTest> l=reactionTestService.list(sql1, uid,kinds);
			List<ReactionTest> list=new ArrayList<ReactionTest>();
			if(l!=null){
				for(ReactionTest reactionTest:l){
					Double time =Double.valueOf(reactionTest.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					reactionTest.setReaction_time(ReportUtils.getTime(d));
					list.add(reactionTest);
				}
			}
			request.setAttribute("qunumber", 1);
			request.setAttribute("questionlist", list);
		}
		else if("test_macthing".equals(tablename)){
			List<MatchingTest> l = matchingTestService.list(sql2, uid, kinds);
			List<MatchingTest> list=new ArrayList<MatchingTest>();
			if(l!=null){
				for(MatchingTest obj:l){
					Double time =Double.valueOf(obj.getReactionTime());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReactionTime(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 2);
			request.setAttribute("questionlist", list);
		}
		else if("test_loop".equals(tablename)){
			List<LoopTest> l=loopTestService.list(sql3, uid, kinds);
			List<LoopTest> list=new ArrayList<LoopTest>();
			if(l!=null){
				for(LoopTest obj:l){
					Double time =Double.valueOf(obj.getReactionTime());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReactionTime(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 3);
			request.setAttribute("questionlist", list);
		}
		else if("test_center".equals(tablename)){
			List<CenterTest> l =centerTestService.list(sql4, uid, kinds);
			List<CenterTest> list=new ArrayList<CenterTest>();
			if(l!=null){
				for(CenterTest obj:l){
					Double time =Double.valueOf(obj.getReactionTime());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReactionTime(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 4);
			request.setAttribute("questionlist", list);
		}
		else if("test_empty".equals(tablename)){
			List<EmptyTest> l=emptyTestService.list(sql5, uid, kinds);
			List<EmptyTest> list=new ArrayList<EmptyTest>();
			if(l!=null){
				for(EmptyTest obj:l){
					Double time =Double.valueOf(obj.getReactionTime());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReactionTime(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 5);
			request.setAttribute("questionlist", list);
		}
		else if("test_compare".equals(tablename)){
			List<TestCompare> l=testCompareService.list(sql6, uid, kinds);
			List<TestCompare> list=new ArrayList<TestCompare>();
			if(l!=null){
				for(TestCompare obj : l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 6);
			request.setAttribute("questionlist", list);
		}
		else if("test_operation".equals(tablename)){
			List<TestOperation> l=testOperationService.list(sql7, uid, kinds);
			List<TestOperation> list=new ArrayList<TestOperation>();
			if(l!=null){
				for(TestOperation obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 7);
			request.setAttribute("questionlist", list);
		}
		else if("test_resilt".equals(tablename) && Integer.parseInt(kinds)==2){
			List<TestResult> l=testResultService.list(sql8, uid, kinds);
			List<TestResult> list=new ArrayList<TestResult>();
			if(l!=null){
				for(TestResult obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 8);
			request.setAttribute("questionlist", list);
		}
		else if("test_maze".equals(tablename)){
			List<TestMaze> l=testMazeService.list(sql9, uid, kinds);
			List<TestMaze> list=new ArrayList<TestMaze>();
			if(l!=null){
				for(TestMaze obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 9);
			request.setAttribute("questionlist", list);
		}
		else if("test_search".equals(tablename)){
			List<TestSearch> l=testSearchService.list(sql10, uid, kinds);
			List<TestSearch> list=new ArrayList<TestSearch>();
			if(l!=null){
				for(TestSearch obj : l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 10);
			request.setAttribute("questionlist", list);
		}
		else if("test_targetcompare".equals(tablename)){
			List<TestTargetcompare> l=testTargetcompareService.list(sql11, uid, kinds);
			List<TestTargetcompare> list=new ArrayList<TestTargetcompare>();
			if(l!=null){
				for(TestTargetcompare obj:l){
					Double time =Double.valueOf(obj.getReactionTime());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReactionTime(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 11);
			request.setAttribute("questionlist",list);
		}
		else if("test_pintu".equals(tablename)){
			List<TestPintu> l=testPintuService.list(sql12, uid, kinds);
			List<TestPintu> list=new ArrayList<TestPintu>();
			if(l!=null){
				for(TestPintu obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					Double time2 =Double.valueOf(obj.getReaction_time());
					Double d2  = (double) (time2/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					obj.setStart_think(ReportUtils.getTime(d2));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 12);
			request.setAttribute("questionlist",list);
		}
		else if("test_resilt".equals(tablename)  && Integer.parseInt(kinds)==4){
			List<TestResult> l =testResultService.list(sql13, uid, kinds);
			List<TestResult> list=new ArrayList<TestResult>();
			if(l!=null){
				for(TestResult obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 13);
			request.setAttribute("questionlist",list);
		}
		else if("test_operationb".equals(tablename)  && Integer.parseInt(kinds)==1){
			List<TestOperationb> l=testOperationbService.list(sql14, uid, kinds);
			List<TestOperationb> list=new ArrayList<TestOperationb>();
			if(l!=null){
				for(TestOperationb obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 14);
			request.setAttribute("questionlist",list);
		}
		else if("test_redoperation".equals(tablename)){
			List<TestredOperation> l=testredOperationService.list(sql15, uid, kinds);
			List<TestredOperation> list=new ArrayList<TestredOperation>();
			if(l!=null){
				for(TestredOperation obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					Double time2 =Double.valueOf(obj.getStart_think());
					Double d2  = (double) (time2/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					obj.setStart_think(ReportUtils.getTime(d2));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 15);
			request.setAttribute("questionlist" , list);
		}
		else if("test_reasoning".equals(tablename)){
			List<TestReasoning> l =testReasoningService.list(sql16, uid, kinds);
			List<TestReasoning> list=new ArrayList<TestReasoning>();
			if(l!=null){
				for(TestReasoning obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 16);
			request.setAttribute("questionlist",list);
		}
		else if("test_appearance".equals(tablename)){
			List<TestAppearance> l = testAppearanceService.list(sql17, uid, kinds);
			List<TestAppearance> list=new ArrayList<TestAppearance>();
			if(l!=null){
				for(TestAppearance obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 17);
			request.setAttribute("questionlist",list);
		}
		else if("test_thinking".equals(tablename)){
			List<TestThinking> l=testThinkingService.list(sql18, uid, kinds);
			List<TestThinking> list=new ArrayList<TestThinking>();
			if(l!=null){
				for(TestThinking obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 18);
			request.setAttribute("questionlist", list);
		}
		else if("test_painting".equals(tablename)){
			List<TestPainting> l= testPaintingService.list(sql19, uid, kinds);
			List<TestPainting> list=new ArrayList<TestPainting>();
			if(l!=null){
				for(TestPainting obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 19);
			request.setAttribute("questionlist", list);
		}
		else if("test_imageination".equals(tablename)){
			List<ImageInation> l= imageInationService.list(sql20, uid, kinds);
			List<ImageInation> list=new ArrayList<ImageInation>();
			if(l!=null){
				for(ImageInation obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 20);
			request.setAttribute("questionlist", list);
		}
		else if("test_colorcontrast".equals(tablename)){
			List<ColorContrast> l= colorContrastService.list(sql21, uid, kinds);
			List<ColorContrast> list= new ArrayList<ColorContrast>();
			if(l!=null){
				for(ColorContrast obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 21);
			request.setAttribute("questionlist", list);
		}
		else if("test_musicform".equals(tablename)){
			List<MusicForm> l= musicFormService.list(sql22, uid, kinds);
			List<MusicForm> list=new ArrayList<MusicForm>();
			if(l!=null){
				for(MusicForm obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 22);
			request.setAttribute("questionlist", list);
		}
		else if("test_musiclength".equals(tablename)){
			List<MusicLength> l= musicLengthService.list(sql23, uid, kinds);
			List<MusicLength> list= new ArrayList<MusicLength>();
			if(l!=null){
				for(MusicLength obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 23);
			request.setAttribute("questionlist",list);
		}
		else if("test_musicrhythm".equals(tablename)){
			List<MusicRhythm> l= musicRhythmService.list(sql24, uid, kinds);
			List<MusicRhythm> list=new ArrayList<MusicRhythm>();
			if(l!=null){
				for(MusicRhythm obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 24);
			request.setAttribute("questionlist", list);
		}
		else if("test_musiccemory".equals(tablename)){
			List<MusicCemory> l = musicCemoryService.list(sql25, uid, kinds);
			List<MusicCemory> list= new ArrayList<MusicCemory>();
			if(l!=null){
				for(MusicCemory obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 25);
			request.setAttribute("questionlist", list);
		}
		else if("test_musicappreciate".equals(tablename)){
			List<MusicAppreciate> l= musicAppreciateService.list(sql26, uid, kinds);
			List<MusicAppreciate> list=new ArrayList<MusicAppreciate>();
			if(l!=null){
				for(MusicAppreciate obj : l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 26);
			request.setAttribute("questionlist", list);
		}
		else if("test_resilt".equals(tablename)  && Integer.parseInt(kinds)==1){
			List<TestResult> l = testResultService.list(sql27, uid, kinds);
			List<TestResult> list = new ArrayList<TestResult>();
			if(l!=null){
				for(TestResult obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 27);
			request.setAttribute("questionlist", list);
		}
		else if("test_induction".equals(tablename)){
			List<Induction> l = inductionService.list(sql28, uid, kinds);
			List<Induction> list = new ArrayList<Induction>();
			if(l!=null){
				for(Induction obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 28);
			request.setAttribute("questionlist", list);
		}
		else if("test_logical".equals(tablename)){
			List<Logical> l = logicalService.list(sql29, uid, kinds);
			List<Logical> list = new ArrayList<Logical>();
			if(l!=null){
				for(Logical obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 29);
			request.setAttribute("questionlist", list);
		}
		else if("test_operationb".equals(tablename)  && Integer.parseInt(kinds)==2){
			List<TestOperationb> l =testOperationbService.list(sql30, uid, kinds);
			List<TestOperationb> list = new ArrayList<TestOperationb>();
			if(l!=null){
				for(TestOperationb obj : l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 30);
			request.setAttribute("questionlist", list);
		}
		else if("test_operationb".equals(tablename)  && Integer.parseInt(kinds)==3){
			List<TestOperationb> l = testOperationbService.list(sql31, uid, kinds);
			List<TestOperationb> list = new ArrayList<TestOperationb>();
			if(l!=null){
				for(TestOperationb obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 31);
			request.setAttribute("questionlist", list);
		}
		else if("test_personality".equals(tablename)){
			List<Personality> l = personalityService.list(sql32, uid, kinds);
			List<Personality> list = new ArrayList<Personality>();
			if(l!=null){
				for(Personality obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 32);
			request.setAttribute("questionlist", list);
		}
		else if("test_operationb".equals(tablename)  && Integer.parseInt(kinds)==4){
			List<TestOperationb> l = testOperationbService.list(sql33, uid, kinds);
			List<TestOperationb> list = new ArrayList<TestOperationb>();
			if(l!=null){
				for(TestOperationb obj:l){
					Double time =Double.valueOf(obj.getReaction_time());
					Double d  = (double) (time/1000/1000/1000);
					obj.setReaction_time(ReportUtils.getTime(d));
					list.add(obj);
				}
			}
			request.setAttribute("qunumber", 33);
			request.setAttribute("questionlist",list);
		}
		else if("test_rgtst".equals(tablename)){
			request.setAttribute("qunumber", 34);
			request.setAttribute("questionlist",rgtstbeanService.list("select * from test_rgtst where user_id=?", uid, kinds));
		}
		return null;
	}
	
	@Override
	public int generateReport(User u) {
		int count = 1;//做题个数
		String sql1="select * from test_reaction where user_id=? order by question_no asc";
		String sql2="select * from test_macthing where user_id=? order by question_no asc";
		String sql3="select * from test_loop where user_id=? order by question_no asc";
		String sql4="select * from test_center where user_id=? order by question_no asc";
		String sql5="select * from test_empty where user_id=? order by question_no asc";
		String sql6="select * from test_compare where user_id=? order by question_no asc";
		String sql7="select * from test_operation where user_id=? order by id asc";
		String sql8="select * from test_resilt where user_id=? and kinds=2 order by question_no asc";
		String sql9="select * from test_maze where user_id=?";
		String sql10="select * from test_search where user_id=? order by question_no asc";
		String sql11="select * from test_targetcompare where user_id=? order by test_no asc";
		String sql12="select * from test_pintu where user_id=? order by question_no asc";
		String sql13="select * from test_resilt where user_id=? and kinds=4 order by question_no asc";
		String sql14="select * from test_operationb where user_id=? and kinds=1 order by test_no asc";
		String sql15="select * from test_redoperation where user_id=? order by question_no asc";
		String sql16="select * from test_reasoning where user_id=? order by question_no asc";
		String sql17="select * from test_appearance where user_id=? order by question_no asc";
		String sql18="select * from test_thinking where user_id=? order by question_no asc";
		String sql19="select * from test_painting where user_id=? order by question_no asc";
		String sql20="select * from test_imageination where user_id=? order by question_no asc";
		String sql21="select * from test_colorcontrast where user_id=? order by question_no asc";
		String sql22="select * from test_musicform where user_id=? order by question_no asc";
		String sql23="select * from test_musiclength where user_id=? order by question_no asc";
		String sql24="select * from test_musicrhythm where user_id=? order by question_no asc";
		String sql25="select * from test_musiccemory where user_id=? order by question_no asc";
		String sql26="select * from test_musicappreciate where user_id=? order by question_no asc";
		String sql27="select * from test_resilt where user_id=? and kinds=1 order by question_no asc";
		String sql28="select * from test_induction where user_id=?  order by question_no asc";
		String sql29="select * from test_logical where user_id=?  order by question_no asc";
		String sql30="select * from test_operationb where user_id=? and kinds=2 order by test_no asc";
		String sql31="select * from test_operationb where user_id=? and kinds=3 order by test_no asc";
		String sql32="select * from test_personality where user_id=?  order by question_no asc";
		String sql33="select * from test_operationb where user_id=? and kinds=4 order by test_no asc";
		try {
			String uid=u.getId()+"";
			File f=new File(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".txt");
			CreateTxt.createwjj(ReportUtils.getwebpath()+"download/data/");
			if(f.exists()){
				f.delete();
			}
//			System.out.println(ReportUtils.getwebpath() + "download/data/"
//					+ u.getUsername() + ".txt");
			String kinds ="0";
			List<ReactionTest> l1= reactionTestService.list(sql1, uid,kinds);
			List<MatchingTest> l2=matchingTestService.list(sql2, uid, kinds);
			List<LoopTest> l3 = loopTestService.list(sql3, uid, kinds);
			List<CenterTest> l4 = centerTestService.list(sql4, uid, kinds);
			List<EmptyTest> l5 = emptyTestService.list(sql5, uid, kinds);
			List<TestCompare> l6=testCompareService.list(sql6, uid, kinds);
			List<TestOperation> l7 = testOperationService.list(sql7, uid, kinds);
			List<TestResult> l8=testResultService.list(sql8, uid, kinds);
			List<TestMaze> l9= testMazeService.list(sql9, uid, kinds);
			List<TestSearch> l10=testSearchService.list(sql10, uid, kinds);
			List<TestTargetcompare> l11=testTargetcompareService.list(sql11, uid, kinds);
			List<TestPintu> l12=testPintuService.list(sql12, uid, kinds);
			List<TestResult> l13=testResultService.list(sql13, uid, kinds);
			List<TestOperationb> l14=testOperationbService.list(sql14, uid, kinds);
			List<TestredOperation> l15=testredOperationService.list(sql15, uid, kinds);
			List<TestReasoning> l16=testReasoningService.list(sql16, uid, kinds);
			List<TestAppearance> l17=testAppearanceService.list(sql17, uid, kinds);
			List<TestThinking> L18=testThinkingService.list(sql18, uid, kinds);
			List<TestPainting> l19=testPaintingService.list(sql19, uid, kinds);
			List<ImageInation> l20=imageInationService.list(sql20, uid, kinds);
			List<ColorContrast> l21=colorContrastService.list(sql21, uid, kinds);
			List<MusicForm> l22=musicFormService.list(sql22, uid, kinds);
			List<MusicLength> l23=musicLengthService.list(sql23, uid, kinds);
			List<MusicRhythm> l24=musicRhythmService.list(sql24, uid, kinds);
			List<MusicCemory> l25=musicCemoryService.list(sql25, uid, kinds);
			List<MusicAppreciate> l26=musicAppreciateService.list(sql26, uid, kinds);
			List<TestResult> l27=testResultService.list(sql27, uid, kinds);
			List<Induction> l28=inductionService.list(sql28, uid, kinds);
			List<Logical> l29=logicalService.list(sql29, uid, kinds);
//			System.out.println("sql30: " + sql30 +", uid: " + uid);
			List<TestOperationb> l30=testOperationbService.list(sql30, uid, kinds);
//			System.out.println("sql30.content: " + l30.size() +", l30:> " + l30);
			List<TestOperationb> l31=testOperationbService.list(sql31, uid, kinds);
			List<Personality> l32=personalityService.list(sql32, uid, kinds);
			List<TestOperationb> l33=testOperationbService.list(sql33, uid, kinds);
			
//			if(l1.size()>0){
				if (l1 != null && l1.size()>0) {
					count++;
					new ReportUtils().generateXzfy(l1,u);
				}
//			} else{
//				return false;
//			} 
//			if(l2.size()>0){
				if (l2 != null && l2.size()>0){
					count++;
					new ReportUtils().generateTxpp(l2,u);
				}
//			}
//			else{
//				return false;
//			}
//			if(l3!=null){
				if (l3 != null && l3.size()>0){
					count++;
  					new ReportUtils().generateYyhl(l3, u);
				}
//			}
//			else{
//				return false;
//			}
//			if(l4.size()>0){
  				if (l4 != null && l4.size()>0){
					count++;
  					new ReportUtils().generateZyclq(l4, u);
  				}
//			}
//			else{
//				return false;
//			}
//			if(l5.size()>0){
  				if (l5 != null && l5.size()>0){
					count++;
  					new ReportUtils().generateSkb(l5, u);
  				}
//			}
//			else{
//				return false;
//			}
//			if(l6.size()>0){
  				if (l6 != null && l6.size()>0){
					count++;
  					new ReportUtils().generateSxjc(l6, u);
  				}
  					
//			}
//			else{
//				return false;
//			}
//			if(l7.size()>0){
  				if (l7 != null && l7.size()>0){
					count++;
  					new ReportUtils().generateSxjct(l7, u);
  				}
//			}
//			else{
//				return false;
//			}
//			if(l8.size()>0){
  				if (l8 != null && l8.size()>0){
					count++;
  					new ReportUtils().generateYycy(l8, u);
  				}
//			}
//			else{
//				return false;
//			}
//			if(l9.size()>0){
  				if (l9 != null && l9.size()>0){
					count++;
  					new ReportUtils().generateMaze(l9, u);
  				}
//			}
//			else{
//				return false;
//			}
//			if(l10.size()>0){
  				if (l10 != null && l10.size()>0){
					count++;
  					new ReportUtils().generateMbss(l10, u);
  				}
//			}
//			else{
//				return false;
//			}
//			if(l11.size()>0){
  				if (l11 != null && l11.size()>0){
					count++;
  					new ReportUtils().generateMbbj(l11, u);
  				}
//			}
//			else{
//				return false;
//			}
//			if(l12.size()>0){
  				if (l12 != null && l12.size()>0){
					count++;
  					new ReportUtils().generateMbpt(l12, u);
  				}
//			}
//			else{
//				return false;
//			}
//			if(l13.size()>0){
  				if (l13 != null && l13.size()>0){
					count++;
  					new ReportUtils().generateRjjwo(l13, u);
			}
//			else{
//				return false;
//			}
//			if(l14.size()>0){
  				if (l14 != null && l14.size()>0){
					count++;
  					new ReportUtils().generateRjjwt(l14, u);
			}
//			else{
//				return false;
//			}
//			if(l15.size()>0){
  				if (l15 != null && l15.size()>0){
					count++;
  					new ReportUtils().generateKjcz(l15,u);
			}
//			else{
//				return false;
//			}
//			if(l16.size()>0){
  				if (l16 != null && l16.size()>0){
					count++;
  					new ReportUtils().generateKjtl(l16, u);
			}
//			else{
//				return false;
//			}
//			if(l17.size()>0){
  				if (l17 != null && l17.size()>0){
					count++;
  					new ReportUtils().generateBxnl(l17, u);
			}
//			else{
//				return false;
//			}
//			if(L18.size()>0){
  				if (L18 != null && L18.size()>0){
					count++;
  					new ReportUtils().generateSwzh(L18, u);
			}
//			else{
//				return false;
//			}
//			if(l19.size()>0){
  				if (l19 != null && l19.size()>0){
					count++;
  					new ReportUtils().generateKjbj(l19, u);
			}
//			else{
//				return false;
//			}
//			if(l20.size()>0){
  				if (l20 != null && l20.size()>0){
					count++;
  					new ReportUtils().generateYsxx(l20, u);
			}
//			else{
//				return false;
//			}
//			if(l21.size()>0){
  				if (l21 != null && l21.size()>0){
					count++;
  					new ReportUtils().generateScdb(l21, u);
			}
//			else{
//				return false;
//			}
//			if(l22.size()>0){
  				if (l22 != null && l22.size()>0){
					count++;
  					new ReportUtils().generateYdxx(l22, u);
			}
//			else{
//				return false;
//			}
//			if(l23.size()>0){
  				if (l23 != null && l23.size()>0){
					count++;
  					new ReportUtils().generateYc(l23, u);
			}
//			else{
//				return false;
//			}
//			if(l24.size()>0){
  				if (l24 != null && l24.size()>0){
					count++;
  					new ReportUtils().generateJzxx(l24, u);
			}
//			else{
//				return false;
//			}
//			if(l25.size()>0){
  				if (l25 != null && l25.size()>0){
					count++;
  					new ReportUtils().generateYdjy(l25, u);
			}
//			else{
//				return false;
//			}
//			if(l26.size()>0){
  				if (l26 != null && l26.size()>0){
					count++;
  					new ReportUtils().generateYyjs(l26, u);
			}
//			else{
//				return false;
//			}
//			if(l27.size()>0){
  				if (l27 != null && l27.size()>0){
					count++;
                    new ReportUtils().generateZzgl(l27, u);
			}
//			else{
//				return false;
//			}
//			if(l28.size()>0){
  				if (l28!= null && l28.size()>0){
					count++;
  					new ReportUtils().generateGntl(l28, u);
			}
//			else{
//				return false;
//			}
//			if(l29.size()>0){
  				if (l29 != null && l29.size()>0){
					count++;
  					new ReportUtils().generateLjtl(l29, u);
			}
//			else{
//				return false;
//			}
  				if (l30 != null && l30.size()>0){
					count++;
  					List<String> list=new ArrayList<String>();
  				if (l30 != null){
					for(TestOperationb t:l30){
						TestQuestionLang2 lang2 = testQuestionLangService2.get(t.getQuestion_no());
						list.add(lang2.getQuestion_text());
						//System.out.println("zyxx: " + lang2.getQuestion_text());
					}
					System.out.println("zyxx.l30: " + l30.size());
					System.out.println("list.size: " + list.size());
	  				
  				}
  				new ReportUtils().generateZyxx(l30, u,list);
			}
//			else{
//				return false;
//			}
//			if(l31.size()>0){
  				if (l31 != null && l31.size()>0){
					count++;
  					new ReportUtils().generateRgo(l31, u);
			}
//			else{
//				return false;
//			}
//			if(l32.size()>0){
  				if (l32 != null && l32.size()>0){
					count++;
  					new ReportUtils().generateRgtso(l32, u);
			}
//			else{
//				return false;
//			}
//			if(l33.size()>0){
  				if (l33 != null && l33.size()>0){
					count++;
  					new ReportUtils().generateRgt(l33, u);
			}
//			else{
//				return false;
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}


	@Override
	public Integer chaxunuser() {
//		String sql="select count(id) coundId from test_system_user";
//		Long l= (Long) super.executeQuery(sql).get(0).get("coundId");
//		if(l>0){
			String sqlmax="select max(id) id from test_system_user";
			List<Map<String, Object>> datas=super.executeQuery(sqlmax);
			Integer lmax =null; 
			if(datas.size()>0){
				lmax=(Integer) datas.get(0).get("id");
			}
			return (lmax == null) ? 0 : lmax;
//		}
//		else{
//			return new Integer(100000);
//		}
	}
	
	@Override
	public User getUserByUsername(String username) throws ServiceException {
		try {
			List<Map<String, Object>> datas = super.executeQuery("select * from test_system_user where username = ? ", username);
			if (datas.size() > 0) {
				User user = (User) super.pack(datas, User.class).get(0);
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.huanduguihua.user.service.UserService#endableOnline(java.lang.String)
	 */
	@Override
	public void endableOnline(String username) throws ServiceException {
		try {
			super.executeUpdate("update test_system_user set online = 1 where username = ?", username);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void disableOnline(String username) throws ServiceException {
		try {
			super.executeUpdate("update test_system_user set online = 0 where username = ?", username);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.huanduguihua.user.service.UserService#disableOnlineAll()
	 */
	@Override
	public void disableOnlineAll() throws ServiceException {
		try {
			super.executeUpdate("update test_system_user set online = 0");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public String generatedat(User u,Integer step) {
		File f=new File(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".txt");
		
		CreateTxt.createwjj(ReportUtils.getwebpath()+"download/data/");
		if(!f.exists()){
			return "no";
		}
		Generate gen = new Generate();
		UserData data = new UserData();
		data.ID = getString(u.getUsername());
		data.Name = getString(u.getName());
		data.Age = getString(u.getNianling());
		data.Nation = getString(u.getMinzu());
		data.Nationality = getString(u.getGuoji());
		data.Vision = getString(u.getShili());
		data.Sex = getString(u.getXingbie());
		data.Blood = getString(u.getXiexing());
		data.Birthday = "无";
		data.School = getString(u.getSchool());
		data.StudentType = getString(u.getXueshengleixing());
		data.Grade = getString(u.getXueli());
		data.CClass = getString(u.getNianji());
		data.Ability = "无";
		data.Interest = getString(u.getTechang());
		data.FatherAge = getString(u.getFuqinnianling());
		data.MotherAge = getString(u.getMuqinnianling());
		data.FatherWork = getString(u.getFuqinzhiye());
		data.MotherWork = getString(u.getMuqinzhiye());
		data.FatherIncome = getString(u.getFuqinshouru());
		data.MotherIncome = getString(u.getMuqinshouru());
		data.FatherAntecedents = getString(u.getFuqinwenhuachengdu());
		data.MotherAntecedents = getString(u.getMuqinwenhuachengdu());
		data.Telephone =getString( u.getYidongdianhua());
		data.Email = getString(u.getEmail());
		data.Home = getString(u.getDizhi());
		List<Boolean> visited = new ArrayList<Boolean>();
		visited.add(true);
		visited.add(true);
		visited.add(true);
		gen.generate(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".txt", ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".dat", step, data,visited);
		return "ok";
	}
	private String getString(Object obj) {
		if (obj == null) {
			return "无";
		} else {
			return obj.toString();
		}
	}


	@Override
	public boolean generateexcel(User u, String tablename, Integer kinds,String filename) {
		String sql1="select * from test_reaction where user_id=? order by question_no asc";
		String sql30="select * from test_operationb where user_id=? and kinds=2 order by test_no asc";
		List<String> listxlsname=new ArrayList<String>();
		List<Map<String,Object>> l=new ArrayList<Map<String,Object>>();
		listxlsname.add("测试编号");
		listxlsname.add("姓名");
		listxlsname.add("年龄");
		listxlsname.add("民族");
		listxlsname.add("国籍");
		listxlsname.add("视力");
		listxlsname.add("性别");
		listxlsname.add("血型");
		listxlsname.add("测试日期");
		listxlsname.add("学校");
		listxlsname.add("学生类型");
		listxlsname.add("年级");
		listxlsname.add("班级");
		listxlsname.add("特长");
		listxlsname.add("兴趣");
		listxlsname.add("父亲年龄");
		listxlsname.add("母亲年龄");
		listxlsname.add("父亲职业");
		listxlsname.add("母亲职业");
		listxlsname.add("父亲收入");
		listxlsname.add("母亲收入");
		listxlsname.add("父亲文化程度");
		listxlsname.add("母亲文化程度");
		listxlsname.add("电话");
		listxlsname.add("电子邮件");
		listxlsname.add("家庭住址");
		if("test_reaction".equals(tablename)){
			List<ReactionTest> list=reactionTestService.list(sql1, u.getId()+"",kinds+"");
			for(ReactionTest r:list){
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("测试编号", u.getUsername());
				map.put("姓名", u.getName());
				map.put("年龄", u.getNianling());
				map.put("民族", u.getMinzu());
				map.put("国籍", u.getGuoji());
				map.put("视力", u.getShili());
				map.put("性别", u.getXingbie());
				map.put("血型", u.getXiexing());
				map.put("测试日期", u.getCreateTime());
				map.put("学校", u.getSchool());
				map.put("学生类型", u.getXueshengleixing());
				map.put("年级", u.getNianji());
				map.put("班级", u.getBanji());
				map.put("特长", u.getTechang());
				map.put("兴趣", u.getTechang());
				map.put("父亲年龄", u.getFuqinnianling());
				map.put("母亲年龄", u.getMuqinnianling());
				map.put("父亲职业", u.getFuqinzhiye());
				map.put("母亲职业", u.getMuqinzhiye());
				map.put("父亲收入", u.getFuqinshouru());
				map.put("母亲收入", u.getMuqinshouru());
				map.put("父亲文化程度", u.getFuqinwenhuachengdu());
				map.put("母亲文化程度", u.getMuqinwenhuachengdu());
				map.put("电话", u.getYidongdianhua());
				map.put("电子邮件", u.getEmail());
				map.put("家庭住址", u.getDizhi());
				map.put("呈现序号", r.getQuestion_no());
				map.put("反应时", r.getReaction_time());
				map.put("选择", r.getReaction_choice());
				map.put("时延", r.getDelay());
				if(r.getIs_true()==true){
					map.put("正误", 1);
				}
				else{
					map.put("正误", 0);
				}
				map.put("位置", r.getPosition());
				l.add(map);
				
			}
			listxlsname.add("呈现序号");
			listxlsname.add("反应时");
			listxlsname.add("选择");
			listxlsname.add("时延");
			listxlsname.add("正误");
			listxlsname.add("位置");
		}
		else if("test_operationb".equals(tablename)  && kinds==2){
			List<TestOperationb> list = testOperationbService.list(sql30, u.getId()+"", kinds+"");
//			System.out.println("size:"+list.size());
			Double d=0d;
			
			for(TestOperationb t:list){
				d=d+Double.valueOf(t.getReaction_time());
			}
			d = d / 1000 / 1000 / 1000;
//			System.out.println("d: " + d);
			for(TestOperationb t:list){
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("测试编号", u.getUsername());
				map.put("姓名", u.getName());
				map.put("年龄", u.getNianling());
				map.put("民族", u.getMinzu());
				map.put("国籍", u.getGuoji());
				map.put("视力", u.getShili());
				map.put("性别", u.getXingbie());
				map.put("血型", u.getXiexing());
				map.put("测试日期", u.getCreateTime());
				map.put("学校", u.getSchool());
				map.put("学生类型", u.getXueshengleixing());
				map.put("年级", u.getNianji());
				map.put("班级", u.getBanji());
				map.put("特长", u.getTechang());
				map.put("兴趣", u.getTechang());
				map.put("父亲年龄", u.getFuqinnianling());
				map.put("母亲年龄", u.getMuqinnianling());
				map.put("父亲职业", u.getFuqinzhiye());
				map.put("母亲职业", u.getMuqinzhiye());
				map.put("父亲收入", u.getFuqinshouru());
				map.put("母亲收入", u.getMuqinshouru());
				map.put("父亲文化程度", u.getFuqinwenhuachengdu());
				map.put("母亲文化程度", u.getMuqinwenhuachengdu());
				map.put("电话", u.getYidongdianhua());
				map.put("电子邮件", u.getEmail());
				map.put("家庭住址", u.getDizhi());
				map.put("呈现序号", t.getQuestion_no());
				map.put("反应时",ReportUtils.getTime(Double.parseDouble(t.getReaction_time())/1000/1000/1000));
				map.put("总反应时", d);
				map.put("选择", t.getStudent_choice());
				map.put("得分", t.getStudent_score());
				l.add(map);
			}
			listxlsname.add("呈现序号");
			listxlsname.add("反应时");
			listxlsname.add("总反应时");
			listxlsname.add("选择");
			listxlsname.add("得分");
		}
		else{
			return false;
		}
		CreateTxt.createwjj(ReportUtils.getwebpath()+"download/data/");
		ExcelUtil.generate(listxlsname, listxlsname, l, ReportUtils.getwebpath()+"download/data/"+u.getUsername()+"_"+filename+".xls");
		return true;
	}
	@Override
	public boolean isRecordInDb(String url, User user) {
//		String url = mokuai.getMokuaiUrl();
		HashMap map = new HashMap();
		map.put("blue/question_1/reaction", "test_reaction");
		map.put("blue/question_2/figure", "test_macthing");
		map.put("blue/question_3/phonological", "test_loop");
		map.put("blue/question_4/executive", "test_center");
		map.put("blue/question_5/visualspatial", "test_empty");
		map.put("yellow/comparing", "test_compare");
		map.put("yellow/operation", "test_operation");
		map.put("yellow/linguisitic", "test_resilt");
		map.put("yellow/snake", "test_maze");
		map.put("green/question1/searching", "test_search");
		map.put("green/comparing", "test_targetcompare");
		map.put("green/matching", "test_pintu");
		map.put("green/interactionA", "test_resilt");
		map.put("green/interactionB", "test_operationb");
		map.put("red/operation", "test_redoperation");
		map.put("red/deduction", "test_reasoning");
		map.put("red/presentational", "test_appearance");
		map.put("red/thinking", "test_thinking");
		map.put("orange/proportion", "test_painting");
		map.put("orange/imagination", "test_imageination");
		map.put("orange/colorcontrast", "test_colorcontrast");
		map.put("wathet/tonality", "test_musicform");
		map.put("wathet/lenght", "test_musiclength");
		map.put("wathet/rhythm", "test_musicrhythm");
		map.put("wathet/memory", "test_musiccemory");
		map.put("wathet/appreciate", "test_musicappreciate");
		map.put("violet/management", "test_resilt");
		map.put("violet/induction", "test_induction");
		map.put("violet/logical", "test_logical");
		map.put("darkgray/tendency", "test_operationb");
		map.put("gray/personalityA", "test_operationb");
		map.put("gray/personalityC", "test_personality");
		map.put("gray/personalityB", "test_operationb");
		map.put("gray/personalityD", "test_rgtst");
		return isRecord(String.valueOf(user.getId()), (String)map.get(url),user.getZuotijindu());
	}	
	@Override
	public boolean isRecordNotInDb(String url, User user) {
//		String url = mokuai.getMokuaiUrl();
		HashMap map = new HashMap();
		map.put("blue/question_1/reaction", "sql1");
		map.put("blue/question_2/figure", "sql2");
		map.put("blue/question_3/phonological", "sql3");
		map.put("blue/question_4/executive", "sql4");
		map.put("blue/question_5/visualspatial", "sql5");
		map.put("yellow/comparing", "sql6");
		map.put("yellow/operation", "sql7");
		map.put("yellow/linguisitic", "sql8");
		map.put("yellow/snake", "sql9");
		map.put("green/question1/searching", "sql10");
		map.put("green/comparing", "sql11");
		map.put("green/matching", "sql12");
		map.put("green/interactionA", "sql13");
		map.put("green/interactionB", "sql14");
		map.put("red/operation", "sql15");
		map.put("red/deduction", "sql16");
		map.put("red/presentational", "sql17");
		map.put("red/thinking", "sql18");
		map.put("orange/proportion", "sql19");
		map.put("orange/imagination", "sql20");
		map.put("orange/colorcontrast", "sql21");
		map.put("wathet/tonality", "sql22");
		map.put("wathet/lenght", "sql23");
		map.put("wathet/rhythm", "sql24");
		map.put("wathet/memory", "sql25");
		map.put("wathet/appreciate", "sql26");
		map.put("violet/management", "sql27");
		map.put("violet/induction", "sql28");
		map.put("violet/logical", "sql29");
		map.put("darkgray/tendency", "sql30");
		map.put("gray/personalityA", "sql31");
		map.put("gray/personalityC", "sql32");
		map.put("gray/personalityB", "sql33");
		map.put("gray/personalityD", "sql34");
		return !isRecord(String.valueOf(user.getId()), (String)map.get(url));
	}	
	private boolean isRecord(String uid,String sqlName) {
		String sql1="select * from test_reaction where  user_id=?";
		String sql2="select * from test_macthing where  user_id=? ";
		String sql3="select * from test_loop where user_id=? ";
		String sql4="select * from test_center where user_id=? ";
		String sql5="select * from test_empty where user_id=? ";
		String sql6="select * from test_compare where  user_id=? ";
		String sql7="select * from test_operation where  user_id=? ";
		String sql8="select * from test_resilt where user_id=? and kinds=2 ";
		String sql9="select * from test_maze where user_id=?";
		String sql10="select * from test_search where user_id=? ";
		String sql11="select * from test_targetcompare  where user_id=? ";
		String sql12="select * from test_pintu where  user_id=? ";
		String sql13="select * from test_resilt where user_id=? and kinds=4 ";
		String sql14="select * from test_operationb where user_id=? and kinds=1 ";
		String sql15="select * from test_redoperation where  user_id=? ";
		String sql16="select * from test_reasoning where  user_id=? ";
		String sql17="select * from test_appearance where  user_id=? ";
		String sql18="select * from test_thinking where  user_id=? ";
		String sql19="select * from test_painting where  user_id=? ";
		String sql20="select * from test_imageination where user_id=? ";
		String sql21="select * from test_colorcontrast where  user_id=? ";
		String sql22="select * from test_musicform where  user_id=? ";
		String sql23="select * from test_musiclength where  user_id=? ";
		String sql24="select * from test_musicrhythm where  user_id=? ";
		String sql25="select * from test_musiccemory where  user_id=? ";
		String sql26="select * from test_musicappreciate where  user_id=? ";
		String sql27="select * from test_resilt where user_id=? and kinds=1 ";
		String sql28="select * from test_induction where  user_id=?  ";
		String sql29="select * from test_logical where  user_id=?  ";
		String sql30="select * from test_operationb where user_id=? and kinds=2 ";
		String sql31="select * from test_operationb where user_id=? and kinds=3 ";
		String sql32="select * from test_personality where user_id=?  ";
		String sql33="select * from test_operationb where user_id=? and kinds=4 ";
		String kinds = "";
		if("sql1".equals(sqlName)){
			List<ReactionTest> l=reactionTestService.list(sql1, uid,kinds);
			if(l!=null && l.size()>0 ){
				return true;
			}
		}
		else if("sql2".equals(sqlName)){
			List<MatchingTest> l = matchingTestService.list(sql2, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql3".equals(sqlName)){
			List<LoopTest> l=loopTestService.list(sql3, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql4".equals(sqlName)){
			List<CenterTest> l =centerTestService.list(sql4, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql5".equals(sqlName)){
			List<EmptyTest> l=emptyTestService.list(sql5, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql6".equals(sqlName)){
			List<TestCompare> l=testCompareService.list(sql6, uid, kinds);
			if(l!=null && l.size()>0 ){
				return true;
			}
		}
		else if("sql7".equals(sqlName)){
			List<TestOperation> l=testOperationService.list(sql7, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql8".equals(sqlName)){
			List<TestResult> l=testResultService.list(sql8, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql9".equals(sqlName)){
			List<TestMaze> l=testMazeService.list(sql9, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql10".equals(sqlName)){
			List<TestSearch> l=testSearchService.list(sql10, uid, kinds);
			if(l!=null && l.size()>0 ){
				return true;
			}
		}
		else if("sql11".equals(sqlName)){
			List<TestTargetcompare> l=testTargetcompareService.list(sql11, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql12".equals(sqlName)){
			List<TestPintu> l=testPintuService.list(sql12, uid, kinds);
			if(l!=null && l.size()>0 ){
				return true;
			}
		}
		else if("sql13".equals(sqlName)){
			List<TestResult> l =testResultService.list(sql13, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql14".equals(sqlName)){
			List<TestOperationb> l=testOperationbService.list(sql14, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql15".equals(sqlName)){
			List<TestredOperation> l=testredOperationService.list(sql15, uid, kinds);
			if(l!=null && l.size()>0 ){
				return true;
			}
		}
		else if("sql16".equals(sqlName)){
			List<TestReasoning> l =testReasoningService.list(sql16, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql17".equals(sqlName)){
			List<TestAppearance> l = testAppearanceService.list(sql17, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql18".equals(sqlName)){
			List<TestThinking> l=testThinkingService.list(sql18, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql19".equals(sqlName)){
			List<TestPainting> l= testPaintingService.list(sql19, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql20".equals(sqlName)){
			List<ImageInation> l= imageInationService.list(sql20, uid, kinds);
			if(l!=null && l.size()>0 ){
				return true;
			}
		}
		else if("sql21".equals(sqlName)){
			List<ColorContrast> l= colorContrastService.list(sql21, uid, kinds);
			if(l!=null && l.size()>0 ){
				return true;
			}
		}
		else if("sql22".equals(sqlName)){
			List<MusicForm> l= musicFormService.list(sql22, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql23".equals(sqlName)){
			List<MusicLength> l= musicLengthService.list(sql23, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql24".equals(sqlName)){
			List<MusicRhythm> l= musicRhythmService.list(sql24, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql25".equals(sqlName)){
			List<MusicCemory> l = musicCemoryService.list(sql25, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql26".equals(sqlName)){
			List<MusicAppreciate> l= musicAppreciateService.list(sql26, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql27".equals(sqlName)){
			List<TestResult> l = testResultService.list(sql27, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql28".equals(sqlName)){
			List<Induction> l = inductionService.list(sql28, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql29".equals(sqlName)){
			List<Logical> l = logicalService.list(sql29, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql30".equals(sqlName)){
			List<TestOperationb> l =testOperationbService.list(sql30, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql31".equals(sqlName)){
			List<TestOperationb> l = testOperationbService.list(sql31, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql32".equals(sqlName)){
			List<Personality> l = personalityService.list(sql32, uid, kinds);
			if(l!=null && l.size()>0){
				return true;
			}
		}
		else if("sql33".equals(sqlName)){
			List<TestOperationb> l = testOperationbService.list(sql33, uid, kinds);
			if(l!=null && l.size()>0){
				return true;			
				}
		}
		else if("sql34".equals(sqlName)){
			List<Rgtstbean> l = rgtstbeanService.list("select * from test_rgtst where user_id=?", uid, kinds);
			if(l!=null && l.size()>0){
				return true;			
				}
		}
		return false;
	}
	private boolean isRecord(String uid,String tablename,Integer zuotijindu) {
		String sql1="select * from test_reaction where question_no=48 and user_id=?";
		String sql2="select * from test_macthing where question_no=48 and user_id=? ";
		String sql3="select * from test_loop where user_id=? ";
		String sql4="select * from test_center where user_id=? ";
		String sql5="select * from test_empty where user_id=? ";
		String sql6="select * from test_compare where question_no=9 and user_id=? ";
		String sql7="select * from test_operation where question_no=9 and  user_id=? ";
		String sql8="select * from test_resilt where user_id=? and kinds=2 ";
		String sql9="select * from test_maze where user_id=?";
		String sql10="select * from test_search where question_no=2 and user_id=? ";
		String sql11="select * from test_targetcompare test_no=9 and where user_id=? ";
		String sql12="select * from test_pintu where question_no=2 and user_id=? ";
		String sql13="select * from test_resilt where user_id=? and kinds=4 ";
		String sql14="select * from test_operationb where user_id=? and kinds=1 ";
		String sql15="select * from test_redoperation where question_no=4 and user_id=? ";
		String sql16="select * from test_reasoning where question_no=6 and user_id=? ";
		String sql17="select * from test_appearance where question_no=36 and user_id=? ";
		String sql18="select * from test_thinking where question_no=36 and user_id=? ";
		String sql19="select * from test_painting where question_no=6 and user_id=? ";
		String sql20="select * from test_imageination where user_id=? ";
		String sql21="select * from test_colorcontrast where question_no=18 and user_id=? ";
		String sql22="select * from test_musicform where question_no=6 and  user_id=? ";
		String sql23="select * from test_musiclength where question_no=6 and user_id=? ";
		String sql24="select * from test_musicrhythm where question_no=6 and user_id=? ";
		String sql25="select * from test_musiccemory where question_no=8 and user_id=? ";
		String sql26="select * from test_musicappreciate where question_no=8 and user_id=? ";
		String sql27="select * from test_resilt where user_id=? and kinds=1 ";
		String sql28="select * from test_induction where question_no=6 and user_id=?  ";
		String sql29="select * from test_logical where question_no=10 and user_id=?  ";
		String sql30="select * from test_operationb where user_id=? and kinds=2 ";
		String sql31="select * from test_operationb where user_id=? and kinds=3 ";
		String sql32="select * from test_personality where user_id=?  ";
		String sql33="select * from test_operationb where user_id=? and kinds=4 ";
		String kinds = "";
		if("test_reaction".equals(tablename)){
			List<ReactionTest> l=reactionTestService.list(sql1, uid,kinds);
			if(l!=null && l.size()>0 && zuotijindu<2){
				return true;
			}
		}
		else if("test_macthing".equals(tablename)){
			List<MatchingTest> l = matchingTestService.list(sql2, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<3){
				return true;
			}
		}
		else if("test_loop".equals(tablename)){
//			List<LoopTest> l=loopTestService.list(sql3, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;
//			}
			return false;
		}
		else if("test_center".equals(tablename)){
//			List<CenterTest> l =centerTestService.list(sql4, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;
//			}
			return false;
		}
		else if("test_empty".equals(tablename)){
//			List<EmptyTest> l=emptyTestService.list(sql5, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;
//			}
			return false;
		}
		else if("test_compare".equals(tablename)){
			List<TestCompare> l=testCompareService.list(sql6, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<7){
				return true;
			}
		}
		else if("test_operation".equals(tablename)){
			List<TestOperation> l=testOperationService.list(sql7, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<8){
				return true;
			}
		}
		else if("test_resilt".equals(tablename)){
//			List<TestResult> l=testResultService.list(sql8, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;
//			}
			return false;
		}
		else if("test_maze".equals(tablename)){
			List<TestMaze> l=testMazeService.list(sql9, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<10){
				return true;
			}
		}
		else if("test_search".equals(tablename)){
			List<TestSearch> l=testSearchService.list(sql10, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<11){
				return true;
			}
		}
		else if("test_targetcompare".equals(tablename)){
			List<TestTargetcompare> l=testTargetcompareService.list(sql11, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<12){
				return true;
			}
		}
		else if("test_pintu".equals(tablename)){
			List<TestPintu> l=testPintuService.list(sql12, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<13){
				return true;
			}
		}
		else if("test_resilt".equals(tablename)){
//			List<TestResult> l =testResultService.list(sql13, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;
//			}
			return false;
		}
		else if("test_operationb".equals(tablename)){
//			List<TestOperationb> l=testOperationbService.list(sql14, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;
//			}
			return false;
		}
		else if("test_redoperation".equals(tablename)){
			List<TestredOperation> l=testredOperationService.list(sql15, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<16){
				return true;
			}
		}
		else if("test_reasoning".equals(tablename)){
			List<TestReasoning> l =testReasoningService.list(sql16, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<17){
				return true;
			}
		}
		else if("test_appearance".equals(tablename)){
			List<TestAppearance> l = testAppearanceService.list(sql17, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<18){
				return true;
			}
		}
		else if("test_thinking".equals(tablename)){
			List<TestThinking> l=testThinkingService.list(sql18, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<19){
				return true;
			}
		}
		else if("test_painting".equals(tablename)){
			List<TestPainting> l= testPaintingService.list(sql19, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<20){
				return true;
			}
		}
		else if("test_imageination".equals(tablename)){
			List<ImageInation> l= imageInationService.list(sql20, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<21){
				return true;
			}
		}
		else if("test_colorcontrast".equals(tablename)){
			List<ColorContrast> l= colorContrastService.list(sql21, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<22){
				return true;
			}
		}
		else if("test_musicform".equals(tablename)){
			List<MusicForm> l= musicFormService.list(sql22, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<23){
				return true;
			}
		}
		else if("test_musiclength".equals(tablename)){
			List<MusicLength> l= musicLengthService.list(sql23, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<24){
				return true;
			}
		}
		else if("test_musicrhythm".equals(tablename)){
			List<MusicRhythm> l= musicRhythmService.list(sql24, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<25){
				return true;
			}
		}
		else if("test_musiccemory".equals(tablename)){
			List<MusicCemory> l = musicCemoryService.list(sql25, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<26){
				return true;
			}
		}
		else if("test_musicappreciate".equals(tablename)){
			List<MusicAppreciate> l= musicAppreciateService.list(sql26, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<27){
				return true;
			}
		}
		else if("test_resilt".equals(tablename)){
//			List<TestResult> l = testResultService.list(sql27, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;
//			}
			return false;
		}
		else if("test_induction".equals(tablename)){
			List<Induction> l = inductionService.list(sql28, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<29){
				return true;
			}
		}
		else if("test_logical".equals(tablename)){
			List<Logical> l = logicalService.list(sql29, uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<30){
				return true;
			}
		}
		else if("test_operationb".equals(tablename)){
//			List<TestOperationb> l =testOperationbService.list(sql30, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;
//			}
			return false;
		}
		else if("test_operationb".equals(tablename)){
//			List<TestOperationb> l = testOperationbService.list(sql31, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;
//			}
			return false;
		}
		else if("test_personality".equals(tablename)){
//			List<Personality> l = personalityService.list(sql32, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;
//			}
			return false;
		}
		else if("test_operationb".equals(tablename)){
//			List<TestOperationb> l = testOperationbService.list(sql33, uid, kinds);
//			if(l!=null && l.size()>0){
//				return true;			
//				}
			return false;
		}
		else if("test_rgtst".equals(tablename)){
			List<Rgtstbean> l = rgtstbeanService.list("select * from test_rgtst where user_id=?", uid, kinds);
			if(l!=null && l.size()>0 && zuotijindu<35){
				return true;			
			}
		}
		return false;
	}
}
