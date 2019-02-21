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
	String[] Sl = Sciencefile.list();//��ȡ���пƼ�
	List SM;
	List SP;
	List SS;
	String[] s;
	boolean sal=false;
	public int RandomMilitary(Kingdom kingdom){//����һ��1��ͷ�Ŀ�����Ŀ
		for (int i = 0; i < Sl.length; i++) {
			String str = Sl[i];//��i���Ƽ�������
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
						SM.add(Sl[i]);//�������Ƽ��������
					}
				}
			}
		}
		return ���г�ȡ;
	}
	public int RandomProject(Kingdom kingdom){//����һ��2��ͷ�Ŀ�����Ŀ
		for (int i = 0; i < Sl.length; i++) {
			String str = Sl[i];//��i���Ƽ�������
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
						SP.add(Sl[i]);//�������Ƽ��������
					}
				}
			}
		}
		return ���г�ȡ;
	}
	public int RandomSociety(Kingdom kingdom){//����һ��3��ͷ�Ŀ�����Ŀ
		for (int i = 0; i < Sl.length; i++) {
			String str = Sl[i];//��i���Ƽ�������
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
						SS.add(Sl[i]);//�������Ƽ��������
					}
				}
			}
		}
		return ���г�ȡ;
	}
}
