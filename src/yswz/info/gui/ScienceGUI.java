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
	static Inventory inv = Bukkit.createInventory(null ,9 ,"��3�������С����˵�");
	static List<String> LX = new ArrayList<String>();
	static List<String> L0 = new ArrayList<String>();
    static List<String> L1 = new ArrayList<String>();
    static List<String> L2 = new ArrayList<String>();
    static List<String> L3 = new ArrayList<String>();
	public ScienceGUI() {
		LX.add("��9��������������������������������������������������");
		LX.add("��b"+���б���+"�����");
		LX.add("��b���ȷ��");
		LX.add("��9��������������������������������������������������");
		//////////////////////////////////////
		L0.add("��9��������������������������������������������������");
		L0.add("��b���ڽ���:"+���б���);
		L0.add("��b����Ҫ:"+ʱ�����);
		L0.add("��9��������������������������������������������������");
		L0.add("��4ͬһʱ��ֻ�ܽ���һ��������Ŀ");
		//////////////////////////////////////
		L1.add("��9��������������������������������������������������");
		L1.add("��b���о��¿��У����γ�ȡ���Ŀ�����Ŀ�ǣ�");
		L1.add("��b"+������б���);
		L1.add("��9��������������������������������������������������");
		L1.add("��b��ҪͶ����Դ��:"+��Ӧ��Դ�����);
		L1.add("��9��������������������������������������������������");
		L1.add("��b����ʱ��:"+��Ӧʱ�����);
		//////////////////////////////////////
		L2.add("��9��������������������������������������������������");
		L2.add("��b���й��̿��У����γ�ȡ���Ŀ�����Ŀ�ǣ�");
		L2.add("��b"+������б���);
		L2.add("��9��������������������������������������������������");
		L2.add("��b��ҪͶ����Դ��:"+��Ӧ��Դ�����);
		L2.add("��9��������������������������������������������������");
		L2.add("��b����ʱ��:"+��Ӧʱ�����);
		//////////////////////////////////////
		L3.add("��9��������������������������������������������������");
		L3.add("��b���������У����γ�ȡ���Ŀ�����Ŀ�ǣ�");
		L3.add("��b"+������б���);
		L3.add("��9��������������������������������������������������");
		L3.add("��b��ҪͶ����Դ��:"+��Ӧ��Դ�����);
		L3.add("��9��������������������������������������������������");
		L3.add("��b����ʱ��:"+��Ӧʱ�����);
	}
	public static void OpenStudyGUI(Player p){
		ItemStack ax = new ItemStack(Material.ENCHANTMENT_TABLE ,1);//���ڽ��п���ͼ��
		ItemStack a0 = new ItemStack(Material.ENCHANTMENT_TABLE ,1);//�������ͼ��
		ItemStack a1 = new ItemStack(Material.GOLD_SWORD ,1);//���¿���ͼ��
		ItemStack a2 = new ItemStack(Material.DISPENSER ,1);//���̿���ͼ��
		ItemStack a3 = new ItemStack(Material.BOOKSHELF ,1);//������ͼ��
		
		ItemMeta Imx = ax.getItemMeta();
		ItemMeta Im1 = a1.getItemMeta();
		ItemMeta Im2 = a2.getItemMeta();
		ItemMeta Im3 = a3.getItemMeta();
		ItemMeta Im0 = a0.getItemMeta();
		Imx.setDisplayName("��6���¿���");
		Im1.setDisplayName("��6���¿���");
		Im2.setDisplayName("��6���̿���");
		Im3.setDisplayName("��6������");
		Im0.setDisplayName("��6���н�����");
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
		if(���ڽ��п���){
			if(����ʱ�����){
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
