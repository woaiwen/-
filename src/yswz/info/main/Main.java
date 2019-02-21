package yswz.info.main;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.kingdoms.events.KingdomCreateEvent;
import org.kingdoms.main.Kingdoms;
import org.kingdoms.manager.game.GameManagement;

import yswz.info.gui.ScienceGUI;

public class Main extends JavaPlugin implements Listener{
	String str = null;
	public GameManagement kingdomsmanager;
	File file = new File(".//plugins//KingdomScience");
	@Override
	public void onEnable() {
		getLogger().info("�������в��������");
		Bukkit.getPluginManager().registerEvents(this,this);
		if(Bukkit.getPluginManager().getPlugin("Kingdoms") != null){
            try{
            kingdomsmanager = Kingdoms.getManagers();
            } catch (NoClassDefFoundError e) {
                Kingdoms.logInfo("Kingdoms: NoClassDefFoundError");
            } catch (Exception e){
                Kingdoms.logInfo("Kingdoms: Exception");
            }
        }
		if(!(file.exists())){
			file.mkdir();
		}
		File Sciencefile = new File(".//plugins//KingdomScience//ScienceList");
		if(!(Sciencefile.exists())){
			Sciencefile.mkdir();
		}
		File Kingdomfile = new File(".//plugins//KingdomScience//Kingdom");
		if(!(Kingdomfile.exists())){
			Kingdomfile.mkdir();
		}
		super.onEnable();
	}
	@Override
	public void onDisable() {
		getLogger().info("������Ӫ����ѹر�");
		super.onDisable();
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ks")){
			if(args.length>=1){
				if("Open".equalsIgnoreCase(args[0])){
					ScienceGUI.OpenStudyGUI(Bukkit.getPlayer(sender.getName()));
				}
			}
		}
		return false;
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		str = event.getInventory().getTitle();
		if (str.equals("��3�������С����˵�")){
			event.setCancelled(true);
			if(�㿪�ߵĹ���û�����ڽ��еĿ�����Ŀ){
				if(event.getRawSlot()==2){//���ѡ����¿���
					ִ�����ѡ��;
				}else if(event.getRawSlot()==4){//���ѡ�񹤳̿���
					ִ�����ѡ��;
				}else if(event.getRawSlot()==6){//���ѡ��������
					ִ�����ѡ��;
				}
			}else if(������������Ŀʱ�䵽��){
				if(event.getRawSlot()==4){//�����ȡ���гɹ�
					¼����гɹ�;
					RandomScience Rc = new RandomScience();
					int Rm = Rc.RandomMilitary(GameManagement.getPlayerManager().getSession(Bukkit.getPlayer(event.getWhoClicked().getName())).getKingdom());
					int Rp = Rc.RandomProject(GameManagement.getPlayerManager().getSession(Bukkit.getPlayer(event.getWhoClicked().getName())).getKingdom());
					int Rs = Rc.RandomSociety(GameManagement.getPlayerManager().getSession(Bukkit.getPlayer(event.getWhoClicked().getName())).getKingdom());
					���³�ȡ�ĿƼ�¼����������;
				}
			}
		}
	}
	@EventHandler
	public void KingdomCreateEvent(KingdomCreateEvent event) throws IOException{//��һ������������ʱ
		File file2 = new File(".//plugins//KingdomScience//Kingdom//"+event.getKingdom().getKingdomName());
		if(!(file2.exists())){
			//������ Ӧ�������ļ�;
			file2.createNewFile();
			FileWriter fw = new FileWriter(file2);
			BufferedWriter bw = new BufferedWriter(fw);
			//����������Ĭ������;
			String[] str = {"false","2003/08/08 00:00:00","11","21","31","0"};�д��޸�
			for (int i = 0; i < str.length; i++) {
				bw.write(str[i]);
				bw.newLine();
			}
			bw.close();
		}
	}
}
