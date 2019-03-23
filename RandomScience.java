package yswz.info.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.kingdoms.constants.kingdom.Kingdom;

import yswz.info.Science.TotalScience;
public class RandomScience {//一个用于抽取各种科技的类
	File Sciencefile = new File(".//plugins//KingdomScience//ScienceList");
	TotalScience ts = new TotalScience();
	Random rand = new Random();//创建一个随机数字生成器
	String[] Sl = Sciencefile.list();//获取所有科技
	ArrayList<String> SM = new ArrayList<>();
	ArrayList<String> SP = new ArrayList<>();
	ArrayList<String> SS = new ArrayList<>();
	String[] s;
	boolean sal=false;
	public int RandomMilitary(Kingdom kingdom) throws IOException{//返回一个1开头的科研项目
		for (int i = 0; i < Sl.length; i++) {
			String str = Sl[i];//第i个科技的名字
			char[] c = str.toCharArray();
			if(c[0]=='1'){
				File file = new File(".//plugins//KingdomScience//Kingdom//"+kingdom.getKingdomName());
				FileReader fr = new FileReader(file);
				BufferedReader bufr = new BufferedReader(fr);
				String temp = new String();
				for (int j = 0; (temp = bufr.readLine()) != null; j++) {
					s[j] = temp;
				}
				bufr.close();
				fr.close();
				String[] al = s[5].split(",");
				for (int j = 0; j < al.length; j++) {
					if(al[j] == Sl[i]){
						sal = true;
					}
				}
				if(sal){
					boolean ess = false;
					for (int j = 0; j < al.length; j++) {
						if(al[j] == ts.getEssID(Integer.parseInt(Sl[i]))+""){
							ess = true;
						}
					}
					if(ess){
						SM.add(Sl[i]);//将这个科技列入库中
					}
				}
			}
		}
		int ri = rand.nextInt(SM.size());
		int is = Integer.parseInt(SM.get(ri));//将抽取到的科技转化为int值
		return is;
	}
	public int RandomProject(Kingdom kingdom) throws IOException{//返回一个2开头的科研项目
		for (int i = 0; i < Sl.length; i++) {
			String str = Sl[i];//第i个科技的名字
			char[] c = str.toCharArray();
			if(c[0]=='2'){
				File file = new File(".//plugins//KingdomScience//Kingdom//"+kingdom.getKingdomName());
				FileReader fr = new FileReader(file);
				BufferedReader bufr = new BufferedReader(fr);
				String temp = new String();
				for (int j = 0; (temp = bufr.readLine()) != null; j++) {
					s[j] = temp;
				}
				bufr.close();
				fr.close();
				String[] al = s[5].split(",");
				for (int j = 0; j < al.length; j++) {
					if(al[j] == Sl[i]){
						sal = true;
					}
				}
				if(sal){
					boolean ess = false;
					for (int j = 0; j < al.length; j++) {
						if(al[j] == ts.getEssID(Integer.parseInt(Sl[i]))+""){
							ess = true;
						}
					}
					if(ess){
						SP.add(Sl[i]);//将这个科技列入库中
					}
				}
			}
		}
		int ri = rand.nextInt(SP.size());
		int is = Integer.parseInt(SP.get(ri));//将抽取到的科技转化为int值
		return is;
	}
	public int RandomSociety(Kingdom kingdom) throws IOException{//返回一个3开头的科研项目
		for (int i = 0; i < Sl.length; i++) {
			String str = Sl[i];//第i个科技的名字
			char[] c = str.toCharArray();
			if(c[0]=='3'){
				File file = new File(".//plugins//KingdomScience//Kingdom//"+kingdom.getKingdomName());
				FileReader fr = new FileReader(file);
				BufferedReader bufr = new BufferedReader(fr);
				String temp = new String();
				for (int j = 0; (temp = bufr.readLine()) != null; j++) {
					s[j] = temp;
				}
				bufr.close();
				fr.close();
				String[] al = s[5].split(",");
				for (int j = 0; j < al.length; j++) {
					if(al[j] == Sl[i]){
						sal = true;
					}
				}
				if(sal){
					boolean ess = false;
					for (int j = 0; j < al.length; j++) {
						if(al[j] == ts.getEssID(Integer.parseInt(Sl[i]))+""){
							ess = true;
						}
					}
					if(ess){
						SS.add(Sl[i]);//将这个科技列入库中
					}
				}
			}
		}
		int ri = rand.nextInt(SM.size());
		int is = Integer.parseInt(SM.get(ri));//将抽取到的科技转化为int值
		return is;
	}
}
