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
		getLogger().info("王国科研插件已启用");
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
		getLogger().info("王国阵营插件已关闭");
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
		if (str.equals("§3王国科研——菜单")){
			event.setCancelled(true);
			if(点开者的国家没有正在进行的科研项目){
				if(event.getRawSlot()==2){//玩家选择军事科研
					执行玩家选择;
				}else if(event.getRawSlot()==4){//玩家选择工程科研
					执行玩家选择;
				}else if(event.getRawSlot()==6){//玩家选择社会科研
					执行玩家选择;
				}
			}else if(如果这个科研项目时间到了){
				if(event.getRawSlot()==4){//玩家领取科研成果
					录入科研成果;
					RandomScience Rc = new RandomScience();
					int Rm = Rc.RandomMilitary(GameManagement.getPlayerManager().getSession(Bukkit.getPlayer(event.getWhoClicked().getName())).getKingdom());
					int Rp = Rc.RandomProject(GameManagement.getPlayerManager().getSession(Bukkit.getPlayer(event.getWhoClicked().getName())).getKingdom());
					int Rs = Rc.RandomSociety(GameManagement.getPlayerManager().getSession(Bukkit.getPlayer(event.getWhoClicked().getName())).getKingdom());
					将新抽取的科技录入王国数据;
				}
			}
		}
	}
	@EventHandler
	public void KingdomCreateEvent(KingdomCreateEvent event) throws IOException{//当一个王国被创建时
		File file2 = new File(".//plugins//KingdomScience//Kingdom//"+event.getKingdom().getKingdomName());
		if(!(file2.exists())){
			//创建对 应王国的文件;
			file2.createNewFile();
			FileWriter fw = new FileWriter(file2);
			BufferedWriter bw = new BufferedWriter(fw);
			//创建王国的默认数据;
			String[] str = {"false","2003/08/08 00:00:00","11","21","31","0"};有待修改
			for (int i = 0; i < str.length; i++) {
				bw.write(str[i]);
				bw.newLine();
			}
			bw.close();
		}
	}
}
