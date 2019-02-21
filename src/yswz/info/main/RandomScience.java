package yswz.info.main;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.kingdoms.constants.kingdom.Kingdom;

import yswz.info.Science.TotalScience;
public class RandomScience {
	File Sciencefile = new File(".//plugins//KingdomScience//ScienceList");
	TotalScience ts = new TotalScience();
	String[] Sl = Sciencefile.list();//获取所有科技
	List SM;
	List SP;
	List SS;
	String[] s;
	boolean sal=false;
	public int RandomMilitary(Kingdom kingdom){//返回一个1开头的科研项目
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
						SM.add(Sl[i]);//将整个科技列入库中
					}
				}
			}
		}
		return 库中抽取;
	}
	public int RandomProject(Kingdom kingdom){//返回一个2开头的科研项目
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
						SP.add(Sl[i]);//将整个科技列入库中
					}
				}
			}
		}
		return 库中抽取;
	}
	public int RandomSociety(Kingdom kingdom){//返回一个3开头的科研项目
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
						SS.add(Sl[i]);//将整个科技列入库中
					}
				}
			}
		}
		return 库中抽取;
	}
}
