package yswz.info.Science;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TotalScience{
	/*每个科研单独一个文件，格式如下（文件名为ID）
	 * Cost,Time,Name,EssID
	 * 
	 *    ID:该科技的唯一序列号,格式为————种类(军事=1,工程=2,社会=3)+序号
	 *  Cost:研究花费资源点
	 *  Time:研究所需时间（单位为毫秒）
	 *  Name:科技名称
	 * EssID:前置科技（无则为0）
	 */
	private int ID;
	File Sciencefile = new File(".//plugins//KingdomScience//ScienceList//"+ID);
	public int getCost(int ID) throws IOException{
		this.ID = ID;
		FileInputStream fis = new FileInputStream(Sciencefile);
		byte b[] = new byte[1024];
		fis.read(b);
		String[] str = new String(b).split(",");
		String S = str[0];
		fis.close();
		return Integer.valueOf(S);
	}
	public String getName(int ID) throws IOException {
		this.ID = ID;
		FileInputStream fis = new FileInputStream(Sciencefile);
		byte b[] = new byte[1024];
		fis.read(b);
		String[] str = new String(b).split(",");
		String S = str[2];
		fis.close();
		return S;
	}
	public Long getTime(int ID) throws IOException {
		this.ID = ID;
		FileInputStream fis = new FileInputStream(Sciencefile);
		byte b[] = new byte[1024];
		fis.read(b);
		String[] str = new String(b).split(",");
		String S = str[1];
		fis.close();
		return Long.valueOf(S);
	}
	public int getEssID(int ID) throws IOException {
		this.ID = ID;
		FileInputStream fis = new FileInputStream(Sciencefile);
		byte b[] = new byte[1024];
		fis.read(b);
		String[] str = new String(b).split(",");
		String S = str[3];
		fis.close();
		return Integer.valueOf(S);
	}

}
