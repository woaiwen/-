package yswz.info.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ScienceGUI {
	static Inventory inv = Bukkit.createInventory(null ,9 ,"§3王国科研——菜单");
	static List<String> LX = new ArrayList<String>();
	static List<String> L0 = new ArrayList<String>();
    static List<String> L1 = new ArrayList<String>();
    static List<String> L2 = new ArrayList<String>();
    static List<String> L3 = new ArrayList<String>();
	public ScienceGUI() {
		LX.add("§9—————————————————————————");
		LX.add("§b"+科研变量+"已完成");
		LX.add("§b点击确定");
		LX.add("§9—————————————————————————");
		//////////////////////////////////////
		L0.add("§9—————————————————————————");
		L0.add("§b正在进行:"+科研变量);
		L0.add("§b还需要:"+时间变量);
		L0.add("§9—————————————————————————");
		L0.add("§4同一时间只能进行一个科研项目");
		//////////////////////////////////////
		L1.add("§9—————————————————————————");
		L1.add("§b进行军事科研，本次抽取到的科研项目是：");
		L1.add("§b"+随机科研变量);
		L1.add("§9—————————————————————————");
		L1.add("§b需要投入资源点:"+对应资源点变量);
		L1.add("§9—————————————————————————");
		L1.add("§b所需时间:"+对应时间变量);
		//////////////////////////////////////
		L2.add("§9—————————————————————————");
		L2.add("§b进行工程科研，本次抽取到的科研项目是：");
		L2.add("§b"+随机科研变量);
		L2.add("§9—————————————————————————");
		L2.add("§b需要投入资源点:"+对应资源点变量);
		L2.add("§9—————————————————————————");
		L2.add("§b所需时间:"+对应时间变量);
		//////////////////////////////////////
		L3.add("§9—————————————————————————");
		L3.add("§b进行社会科研，本次抽取到的科研项目是：");
		L3.add("§b"+随机科研变量);
		L3.add("§9—————————————————————————");
		L3.add("§b需要投入资源点:"+对应资源点变量);
		L3.add("§9—————————————————————————");
		L3.add("§b所需时间:"+对应时间变量);
	}
	public static void OpenStudyGUI(Player p){
		ItemStack ax = new ItemStack(Material.ENCHANTMENT_TABLE ,1);//正在进行科研图标
		ItemStack a0 = new ItemStack(Material.ENCHANTMENT_TABLE ,1);//科研完成图标
		ItemStack a1 = new ItemStack(Material.GOLD_SWORD ,1);//军事科研图标
		ItemStack a2 = new ItemStack(Material.DISPENSER ,1);//工程科研图标
		ItemStack a3 = new ItemStack(Material.BOOKSHELF ,1);//社会科研图标
		
		ItemMeta Imx = ax.getItemMeta();
		ItemMeta Im1 = a1.getItemMeta();
		ItemMeta Im2 = a2.getItemMeta();
		ItemMeta Im3 = a3.getItemMeta();
		ItemMeta Im0 = a0.getItemMeta();
		Imx.setDisplayName("§6军事科研");
		Im1.setDisplayName("§6军事科研");
		Im2.setDisplayName("§6工程科研");
		Im3.setDisplayName("§6社会科研");
		Im0.setDisplayName("§6科研进行中");
		Imx.setLore(LX);
		Im1.setLore(L1);
		Im2.setLore(L2);
		Im3.setLore(L3);
		Im0.setLore(L0);
		ax.setItemMeta(Imx);
		a1.setItemMeta(Im1);
		a2.setItemMeta(Im2);
		a3.setItemMeta(Im3);
		a0.setItemMeta(Im0);
		if(正在进行科研){
			if(科研时间结束){
				inv.setItem(4, ax);
			}else{
				inv.setItem(4, a0);
			}
		}else{
			inv.setItem(2, a1);
			inv.setItem(4, a2);
			inv.setItem(6, a3);
		}
		p.closeInventory();
        p.openInventory(inv);
	}
}
