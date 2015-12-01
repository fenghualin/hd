package com.huanduguihua.system.dat;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Generate {
	
	private String[] zyxxArr = {
			"空间设计型", "技术操作型", "社会研究型", "经济操作型", "操作服务型",
			"意识设计型", "自然活动型", "意识研究型", "意识组织型", "艺术操作型",
			"物品设计型", "技术制造型", "加工操作型", "自然研究型", "安全服务型",
			"表演服务型", "人员管理型", "工程活动型", "活动公关型", "考古活动型",
			"行政管理型", "驾驶操作型", "美术创作型", "意识表达型", "事务管理型",
			"法务管理型", "教育服务型", "健康服务型", "文艺创作型", "信电操作型",
			"消费服务型", "艺术表演型", "戏剧创作型", "体育表演型", "思想表演型"
	};
	
	private class MBBJ{
		public Double x;
		public Double y;
		public Double t;
		public Boolean v;
	}
	private Map<String,Integer> Method;
	private List<Boolean> visited;
	public Generate() {
		Method = new HashMap<String, Integer>();
		Method.put("xzfy", 0);
		Method.put("txpp", 0);
		Method.put("swzh", 0);
		Method.put("bxnl", 0);
		Method.put("skb", 0);
		Method.put("zyclq", 0);
		Method.put("yyhl", 0);
		Method.put("sxcy", 0);
		Method.put("sxcy2", 6);
		Method.put("yycy", 0);
		Method.put("kjzj", 0);
		Method.put("rj2", 0);
		Method.put("kjcz", 5);
		Method.put("kjbl", 0);
		Method.put("ysxx", 0);
		Method.put("zzgl", 0);
		Method.put("ljtl", 0);
		Method.put("rg1", 0);
		Method.put("rg2", 0);
		Method.put("rgts1", 0);
		Method.put("rgts2", 0);
		Method.put("zyxx", 7);
		Method.put("gntl", 0);
		Method.put("scdb", 0);
		Method.put("kjtl", 2);
		Method.put("rj1", 0);
		Method.put("ydxx", 0);
		Method.put("yc", 0);
		Method.put("jzxx", 0);
		Method.put("ydjy", 0);
		Method.put("yyjs", 0);
		Method.put("maze", 1);
		Method.put("mbbj", 3);
		Method.put("mbpt", 4);
		Method.put("mbss", 0);
		Method.put("", -1);
		
	}

	/**
	 * 导出DAT文件
	 * @param txtFile	txt文件地址
	 * @param datFile	导出的dat文件存放在哪里
	 * @param step		步骤？暂时不明确，传入34即可
	 * @param data		用户的数据
	 * @param visited	贪吃蛇的Visited？不明确，传入几条模拟数据
	 * @return
	 */
	public boolean generate( String txtFile, String datFile, Integer step, UserData data, List<Boolean> visited ){
		this.visited = visited;
		Scanner sc = null;
		DataOutputStream dos = null;
		try {
			sc = new Scanner(new File(txtFile), "GBK");
			dos = new DataOutputStream(new FileOutputStream(datFile));
			dos.writeInt( Integer.reverseBytes(step) );
			writeDataToStream(dos,data.ID);
			writeDataToStream(dos,data.Name);
			writeDataToStream(dos,data.Age);
			writeDataToStream(dos,data.Nation);
			writeDataToStream(dos,data.Nationality);
			writeDataToStream(dos,data.Vision);
			writeDataToStream(dos,data.Sex);
			writeDataToStream(dos,data.Blood);
			writeDataToStream(dos,data.Birthday);
			writeDataToStream(dos,data.School);
			writeDataToStream(dos,data.StudentType);
			writeDataToStream(dos,data.Grade);
			writeDataToStream(dos,data.CClass);
			writeDataToStream(dos,data.Ability);
			writeDataToStream(dos,data.Interest);
			writeDataToStream(dos,data.FatherAge);
			writeDataToStream(dos,data.MotherAge);
			writeDataToStream(dos,data.FatherWork);
			writeDataToStream(dos,data.MotherWork);
			writeDataToStream(dos,data.FatherIncome);
			writeDataToStream(dos,data.MotherIncome);
			writeDataToStream(dos,data.FatherAntecedents);
			writeDataToStream(dos,data.MotherAntecedents);
			writeDataToStream(dos,data.Telephone);
			writeDataToStream(dos,data.Email);
			writeDataToStream(dos,data.Home);
			
			writeTxtToStream(dos,sc);
			
			String fixedDatFile = datFile.replace(".dat", "_fix.dat");
			sc = new Scanner(new File(txtFile), "GBK");
            dos = new DataOutputStream(new FileOutputStream(fixedDatFile));
            writeTxtToStream(dos,sc);
			
			sc.close();
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			
		}
		return true;
	}
	
	private void writeTxtToStream(DataOutputStream dos, Scanner sc) throws IOException{
		sc.nextLine();
		
		while (sc.hasNext()){
			String type = sc.nextLine();
			System.out.println("type=="+type);
			writeDataToStream(dos,type);
			switch ( Method.get(type) ) {
			case 0:
				method0(dos,sc);
				break;
			case 1:
				method1(dos,sc);
				break;
			case 2:
				method2(dos,sc);
				break;
			case 3:
				method3(dos,sc);
				break;
			case 4:
				method4(dos,sc);
				break;
			case 5:
				method5(dos,sc);
				break;
			case 6:
				method6(dos,sc);
				break;
			case 7:
				method7(dos,sc);
				break;
			default:
				break;
			}
		}
	}
	
	private void writeDataToStream(DataOutputStream dos, String str){
		try {
			dos.writeLong(Long.reverseBytes( (str.getBytes("GBK").length) ));
			dos.write(str.getBytes("GBK"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private void method0(DataOutputStream dos, Scanner sc) throws IOException{
		sc.nextLine();
		sc.nextLine();
		String line;
		int cnt = 0;
		List<Double> dList = new ArrayList<Double>();  
		List<Integer> iList = new ArrayList<Integer>();
		while ( sc.hasNext() ){
			line = sc.nextLine();
			if ( line.equals("---------------------------------------------------------------------------") )
				break;
			Scanner ss = new Scanner(line);
			dList.add( ss.nextDouble() );
			iList.add( ss.nextInt() );
			ss.close();
			cnt ++;
		}
		dos.writeLong(Long.reverseBytes(12*cnt+4));
		dos.writeInt(Integer.reverseBytes(cnt));
		for ( int i=0; i<cnt; i++ ){
			dos.writeInt( Integer.reverseBytes( iList.get(i) ) );
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( dList.get(i) ) ) );
		}
	}
	
	private void method1(DataOutputStream dos, Scanner sc) throws IOException{
		sc.nextLine();
		String line = sc.nextLine();
		dos.writeLong(Long.reverseBytes(24+visited.size()));
		if ( line.equals("---------------------------------------------------------------------------") ){//没有答题内容
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( 0 ) ) );
			dos.writeInt( Integer.reverseBytes( 0 ) );
			dos.writeInt( Integer.reverseBytes( 0 ) );
			dos.writeInt( Integer.reverseBytes( visited.size() ) );
			for ( int i=0; i<visited.size(); i++ ){
				dos.writeBoolean(visited.get(i));
			}
			dos.writeInt( Integer.reverseBytes( 0 ) );
		}else{
			Scanner ss = new Scanner(line);
			ss.next();
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( ss.nextDouble() ) ) );
			ss.next();
			Integer tmp = ss.nextInt();
			dos.writeInt( Integer.reverseBytes( tmp ) );
			ss.next();
			ss.next();
			dos.writeInt( Integer.reverseBytes( ss.nextInt() ) );
			dos.writeInt( Integer.reverseBytes( visited.size() ) );
			for ( int i=0; i<visited.size(); i++ ){
				dos.writeBoolean(visited.get(i));
			}
			dos.writeInt( Integer.reverseBytes( tmp ) );
			ss.close();		
			if ( sc.hasNext() )
				sc.nextLine();
		}
	}
	
	private void method2(DataOutputStream dos, Scanner sc) throws IOException{
		sc.nextLine();
		String line;
		List< List<Integer> > list = new ArrayList<List<Integer>>();
		List<Double> usedTimeList = new ArrayList<Double>();
		int cnt = 0;
		while ( sc.hasNext() ){
			line = sc.nextLine();
			if ( line.equals("---------------------------------------------------------------------------") )
				break;
			List<Integer> opList = new ArrayList<Integer>();
			while ( sc.hasNext() ){
				line = sc.nextLine();
				Scanner ss = new Scanner(line);	
				if ( line.startsWith("  UsedTime:") ){
					ss.next();
					usedTimeList.add( ss.nextDouble() );
					ss.close();
					break;
				}
				cnt ++;
				ss.next();ss.next();ss.next();
				opList.add(ss.nextInt());
				ss.close();
			}
			list.add(opList);
		}
		dos.writeLong(Long.reverseBytes( cnt*4 + list.size()*12 + 4 ));
		dos.writeInt(Integer.reverseBytes( list.size() ));
		for ( int i=0; i<list.size(); i++ ){
			dos.writeInt(Integer.reverseBytes( list.get(i).size() ));
			for ( int j=0; j<list.get(i).size(); j++ )
				dos.writeInt(Integer.reverseBytes( list.get(i).get(j) ));
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( usedTimeList.get(i) ) ) );
		}
				
	}
	
	private void method3(DataOutputStream dos, Scanner sc) throws IOException{
		sc.nextLine();
		String line;
		List< List<MBBJ> > list = new ArrayList<List<MBBJ>>();
		List< MBBJ > tmpList = null;
		List<Double> usedTimeList = new ArrayList<Double>();
		int cnt = 0;
		String tmp;
		while ( sc.hasNext() ){
			line = sc.nextLine();
			Scanner ss = new Scanner(line);
			if ( line.equals("---------------------------------------------------------------------------") ){
				if ( tmpList != null )
				list.add(tmpList);
				ss.close();
				break;
			}
			if ( line.startsWith("  Segment") ){
				if ( tmpList != null )
					list.add(tmpList);
				tmpList = new ArrayList<Generate.MBBJ>();
				ss.next();ss.next();
				tmp = ss.next();
				usedTimeList.add( Double.parseDouble( tmp.substring(10) ) );
				ss.close();
				continue;
			}
			MBBJ mbbj = new MBBJ();
			ss.next();ss.next();
			mbbj.x = Double.parseDouble( ss.next().substring(2) );
			mbbj.y = Double.parseDouble( ss.next().substring(2) );
			mbbj.t = Double.parseDouble( ss.next().substring(2) );
			mbbj.v = ss.next().equals("out") ? false:true;
			tmpList.add(mbbj);
			cnt ++;
			ss.close();
		}
		
		dos.writeLong(Long.reverseBytes( cnt*25 + list.size()*12 + 4 ));
		dos.writeInt(Integer.reverseBytes( list.size() ));
		for ( int i=0; i<list.size(); i++ ){
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( usedTimeList.get(i) ) ) );
			dos.writeInt(Integer.reverseBytes( list.get(i).size() ));
			for ( int j=0; j<list.get(i).size(); j++ ){
				dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( list.get(i).get(j).x ) ) );
				dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( list.get(i).get(j).y ) ) );
				dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( list.get(i).get(j).t ) ) );
				dos.writeBoolean( list.get(i).get(j).v );
			}
		}
				
	}
	
	private void method4(DataOutputStream dos, Scanner sc) throws IOException{
		sc.nextLine();
		String line;
		List< List<Integer> > list = new ArrayList<List<Integer>>();
		List< Integer > rectList = null;
		List<Double> usedTimeList = new ArrayList<Double>();
		List<Double> firstTimeList = new ArrayList<Double>();
		List<Integer> moveNum = new ArrayList<Integer>();
		int cnt = 0;
		while ( sc.hasNext() ){
			line = sc.nextLine();
			Scanner ss = new Scanner(line);
			if ( line.equals("---------------------------------------------------------------------------") ){
				list.add(rectList);
				ss.close();
				break;
			}
			if ( line.startsWith("  UsedTime") ){
				if ( rectList != null )
					list.add(rectList);
				rectList = new ArrayList<Integer>();
				ss.next();
				usedTimeList.add( ss.nextDouble() );
				ss.next();
				firstTimeList.add( ss.nextDouble() );
				ss.next();
				moveNum.add( ss.nextInt() );
				ss.close();
				continue;
			}
			if ( line.startsWith("    Rect") ){
				ss.next();ss.next();ss.next();
				rectList.add( ss.nextInt() );
				cnt ++;
				ss.close();
				continue;
			}
			ss.close();
		}
		
		dos.writeLong(Long.reverseBytes( cnt*4 + usedTimeList.size()*24 + 4 ));
		dos.writeInt(Integer.reverseBytes( usedTimeList.size() ));
		for ( int i=0; i<usedTimeList.size(); i++ ){
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( usedTimeList.get(i) ) ) );
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( firstTimeList.get(i) ) ) );
			dos.writeInt( Integer.reverseBytes( moveNum.get(i) )  );
			dos.writeInt( Integer.reverseBytes( list.get(i).size() )  );
			for ( int j=0; j<list.get(i).size(); j++ ){
				dos.writeInt( Integer.reverseBytes( list.get(i).get(j) )  );
			}
		}
				
	}
	
	private void method5(DataOutputStream dos, Scanner sc) throws IOException{
		sc.nextLine();
		String line;
		List< List<Integer> > list1 = new ArrayList<List<Integer>>();
		List< List<Integer> > list2 = new ArrayList<List<Integer>>();
		List< Integer > modList = null;
		List< Integer > selList = null;
		List<Double> usedTimeList = new ArrayList<Double>();
		List<Double> firstTimeList = new ArrayList<Double>();
		List<Integer> moveNum = new ArrayList<Integer>();
		int cnt = 0;
		while ( sc.hasNext() ){
			line = sc.nextLine();
			Scanner ss = new Scanner(line);
			if ( line.equals("---------------------------------------------------------------------------") ){
				list1.add(modList);
				list2.add(selList);
				ss.close();
				break;
			}
			if ( line.startsWith("  Segment") ){
				if ( modList != null )
					list1.add(modList);
				if ( selList != null )
					list2.add(selList);
				modList = new ArrayList<Integer>();
				selList = new ArrayList<Integer>();
				ss.next();ss.next();ss.next();
				usedTimeList.add( ss.nextDouble() );
				ss.next();
				firstTimeList.add( ss.nextDouble() );
				ss.next();
				moveNum.add( ss.nextInt() );
				ss.close();
				continue;
			}
			if ( line.startsWith("    Mod") ){
				ss.next();ss.next();ss.next();
				modList.add( ss.nextInt() );
				cnt ++;
				ss.close();
				continue;
			}
			if ( line.startsWith("    Sel") ){
				ss.next();ss.next();ss.next();
				selList.add( ss.nextInt() );
				cnt ++;
				ss.close();
				continue;
			}
			
			ss.close();
		}
		
		dos.writeLong(Long.reverseBytes( cnt*4 + usedTimeList.size()*28 + 4 ));
		dos.writeInt(Integer.reverseBytes( usedTimeList.size() ));
		for ( int i=0; i<usedTimeList.size(); i++ ){
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( usedTimeList.get(i) ) ) );
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( firstTimeList.get(i) ) ) );
			dos.writeInt( Integer.reverseBytes( moveNum.get(i) )  );
			dos.writeInt( Integer.reverseBytes( list1.get(i).size() )  );
			for ( int j=0; j<list1.get(i).size(); j++ ){
				dos.writeInt( Integer.reverseBytes( list1.get(i).get(j) )  );
			}
			dos.writeInt( Integer.reverseBytes( list2.get(i).size() )  );
			for ( int j=0; j<list2.get(i).size(); j++ ){
				dos.writeInt( Integer.reverseBytes( list2.get(i).get(j) )  );
			}
		}
				
	}
	
	private void method6(DataOutputStream dos, Scanner sc) throws IOException{
		sc.nextLine();
		String line;
		List< List<Double> > list = new ArrayList<List<Double>>();
		List< Double > tmpList = null;
		List<Integer> selList = new ArrayList<Integer>();
		List<String> answer = new ArrayList<String>();
		int cnt = 0;
		while ( sc.hasNext() ){
			line = sc.nextLine();
			Scanner ss = new Scanner(line);
			if ( line.equals("---------------------------------------------------------------------------") ){
				if ( tmpList != null ){
					list.add(tmpList);
				}
				ss.close();
				break;
			}
			if ( line.startsWith("  Segment") ){
				if ( tmpList != null )
					list.add(tmpList);
				tmpList = new ArrayList<Double>();
				ss.next();ss.next();ss.next();
				selList.add( ss.nextInt() );
				ss.next();
				answer.add(ss.next());
				ss.close();
				continue;
			}
			
			ss.next();ss.next();ss.next();
			tmpList.add(ss.nextDouble());
			cnt ++;
			ss.close();
		}
		int strSize = 0;
		for ( int i=0; i<answer.size(); i++ ){
			strSize += answer.get(i).getBytes("GBK").length;
		}
		dos.writeLong(Long.reverseBytes( cnt*8 + list.size()*16 + strSize + 4 ));
		dos.writeInt(Integer.reverseBytes( list.size() ));
		for ( int i=0; i<list.size(); i++ ){
			dos.writeInt(Integer.reverseBytes( selList.get(i) ));
			writeDataToStream(dos, answer.get(i));
			dos.writeInt(Integer.reverseBytes( list.get(i).size() ));			
			for ( int j=0; j<list.get(i).size(); j++ ){
				dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( list.get(i).get(j) ) ) );
			}
		}
				
	}
	
	private void method7(DataOutputStream dos, Scanner sc) throws IOException{
		String line;
		line = sc.nextLine();
		List< Double > timeList = new ArrayList<Double>();
		List< Double > scoreList = new ArrayList<Double>();
		List<Integer> selList = new ArrayList<Integer>();
		List<String> strList = new ArrayList<String>();
		int cntSeg = 0;
		int cntModule = 0;
		while ( sc.hasNext() ){
			line = sc.nextLine();
			Scanner ss = new Scanner(line);
			if ( line.equals("---------------------------------------------------------------------------") ){
				ss.close();
				break;
			}
			if ( line.startsWith("  Segment") ){
				cntSeg ++;
				ss.next();ss.next();
				selList.add( Integer.parseInt( ss.next().substring(10) ) );
				timeList.add( Double.parseDouble( ss.next().substring(10) ) );
				String str = ss.nextLine();
				strList.add( str.substring(2,str.length()-1) );
				ss.close();
				continue;
			}
			if ( line.startsWith("  Module") ){
				cntModule ++;
				ss.next();ss.next();ss.next();
				scoreList.add( Double.parseDouble( ss.next() ) );
				ss.close();
				continue;
			}
			ss.close();
		}
		int strSize = 0;
		for ( int i=0; i<strList.size(); i++ ){
			strSize += strList.get(i).getBytes("GBK").length+8;
		}
		dos.writeLong(Long.reverseBytes( cntSeg*12 + cntModule*8 + strSize + 8 + 35*18 ));
		dos.writeInt(Integer.reverseBytes( strList.size() ));
		for ( int i=0; i<strList.size(); i++ ){
			writeDataToStream(dos, strList.get(i));
			dos.writeInt(Integer.reverseBytes( selList.get(i) ));
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( timeList.get(i) ) ) );
		}
		dos.writeInt(Integer.reverseBytes( scoreList.size() ));
		for ( int i=0; i<scoreList.size(); i++ ){
			writeDataToStream(dos, new String(zyxxArr[i].getBytes("GBK"),"GBK"));
			dos.writeLong( Long.reverseBytes( Double.doubleToRawLongBits( scoreList.get(i) ) ) );
		}
				
	}
}
