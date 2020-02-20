package fr.diax.ss.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class SsCommand implements CommandExecutor, Listener {

    public String préfix = "§6SécurityServer §5> ";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;


            if (args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "§c") + "/ss <Player>");
                return false;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                p.sendMessage(préfix+"§cLe joueur demandée n'est pas en ligne");
                return false;
            }

            Inventory inv = Bukkit.createInventory(p, 4*9, "§eSécurityServer > §9"+target.getName());
            ssInventory(target,inv);
            p.openInventory(inv);


        }

        return false;
    }

    public void ssInventory(Player name,Inventory inv) {

        Material type;
        ItemStack head = new ItemStack(Material.SKULL);
        SkullMeta skm = (SkullMeta) head.getItemMeta();
        ItemStack paper = new ItemStack(Material.PAPER);
        ItemMeta paperm = paper.getItemMeta();

        paperm.setDisplayName("§aChoisir une sanction");
        skm.setOwner(name.getName());
        inv.setItem(13, head);
        inv.setItem(22, paper);
    }

    @EventHandler
    public void OnMove(InventoryInteractEvent event) {
        Player p = (Player) event.getWhoClicked();

        if (event.getInventory().getTitle().equalsIgnoreCase("§eSécurityServer > §9" + p.getName())) {
            event.setCancelled(true);
        }
    }

}
