package Lihad.BMCDocs;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BMCDocs extends JavaPlugin implements Listener {
	protected static String PLUGIN_NAME = "BeyondTag";
	protected static String header = "[" + PLUGIN_NAME + "] ";
	private static Logger log = Logger.getLogger("Minecraft");
	public static Map<String,String[]> map = new HashMap<String,String[]>();
	@Override
	public void onEnable() {
		startupReader();
		this.getServer().getPluginManager().registerEvents(this, this);
		getCommand("bmcdocs").setExecutor(this);
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("bmcdocs") && args.length == 1 && (args[0].equalsIgnoreCase("-reload") || args[0].equalsIgnoreCase("-r")) 
				&& (sender instanceof ConsoleCommandSender || (sender instanceof Player && ((Player)sender).isOp()))) {
			map.clear();
			sender.sendMessage("running BMCDOCS reload...notification posted to console when complete...");
			this.getServer().getScheduler().scheduleAsyncDelayedTask(this, new Runnable(){
				public void run() {
					startupReader();
					info("reload complete");
				}
			}, 1);
			return true;
		}
		return false;
	}
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event){
		String[] array = event.getMessage().split(" ");
		if(map.containsKey(array[0].substring(1))){
			event.getPlayer().sendMessage(map.get(array[0].substring(1)));
			event.setCancelled(true);
		}
	}
	private void startupReader(){
		File[] files = new File("plugins/MCDocs").listFiles();
		for(int i = 0;i<files.length;i++){
			if(files[i].isFile()){
				try{
					ArrayList<String> tempLines = new ArrayList<String>();
					FileInputStream fis = new FileInputStream("plugins/MCDocs/" + files[i].getName());
					info("BMCDOCS added: "+files[i].getName());
					Scanner scanner = new Scanner(fis, "UTF-8");
					while (scanner.hasNextLine()) {
						try{
							tempLines.add(scanner.nextLine() + " ");
						}
						catch(Exception ex){
							tempLines.add(" ");
						}
					}
					String[] array = tempLines.toArray(new String[tempLines.size()]);
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&a");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.GREEN+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&b");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.AQUA+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&c");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.RED+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&d");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.LIGHT_PURPLE+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&e");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.YELLOW+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&9");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.BLUE+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&0");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.BLACK+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&1");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.DARK_BLUE+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&2");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.DARK_GREEN+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&3");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.DARK_AQUA+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&4");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.DARK_RED+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&5");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.DARK_PURPLE+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&6");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.GOLD+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&7");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.LIGHT_PURPLE+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&8");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.GRAY+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&f");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.WHITE+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&B");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.BOLD+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&u");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.UNDERLINE+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&i");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.ITALIC+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&s");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.STRIKETHROUGH+broke[k];
						}
						array[j]=rebuilt;
					}
					for(int j = 0;j<array.length;j++){
						String[] broke = array[j].split("&m");
						String rebuilt = broke[0];
						for(int k = 1; k<broke.length;k++){
							rebuilt = rebuilt+ChatColor.MAGIC+broke[k];
						}
						array[j]=rebuilt;
					}
					map.put(files[i].getName().substring(0, files[i].getName().indexOf(".")), array);
					scanner.close();
					fis.close();
				}
				catch (Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}
	public static void info(String message){ 
		log.info(header + ChatColor.WHITE + message);
	}
	public static void severe(String message){
		log.severe(header + ChatColor.RED + message);
	}
	public static void warning(String message){
		log.warning(header + ChatColor.YELLOW + message);
	}
	public static void log(java.util.logging.Level level, String message){
		log.log(level, header + message);
	}
}