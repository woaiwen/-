package yswz.info.Science;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TotalScience{
	/*ÿ�����е���һ���ļ�����ʽ���£��ļ���ΪID��
	 * Cost,Time,Name,EssID
	 * 
	 *    ID:�ÿƼ���Ψһ���к�,��ʽΪ������������(����=1,����=2,���=3)+���
	 *  Cost:�о�������Դ��
	 *  Time:�о�����ʱ�䣨��λΪ���룩
	 *  Name:�Ƽ�����
	 * EssID:ǰ�ÿƼ�������Ϊ0��
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
