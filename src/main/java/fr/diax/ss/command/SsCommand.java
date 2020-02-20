package fr.diax.ss.command;

import fr.diax.ss.cheattypeEnum.CheatType;
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

    private final String prefix = "§6SécurityServer §5> ";
    private final CheatType type;

    public SsCommand(CheatType type) {
        this.type = type;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;


            if (args.length == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "§c") + "/ss <Player>");
                return false;
            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("fl")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "§a") + "Vérification en cours...");
                }

                return false;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage(prefix + "§cLe joueur demandée n'est pas en ligne");
                return false;
            }

            Inventory inventory = Bukkit.createInventory(player, 4 * 9, "§eSécurityServer > §9" + target.getName());
            ssInventory(target, inventory);
            player.openInventory(inventory);


        }

        return false;
    }

    public void ssInventory(Player player, Inventory inventory) {


        ItemStack head = new ItemStack(Material.SKULL);
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        ItemStack paper = new ItemStack(Material.PAPER);
        ItemMeta paperMeta = paper.getItemMeta();

        paperMeta.setDisplayName("§aChoisir une sanction");
        headMeta.setOwner(player.getName());
        inventory.setItem(13, head);
        inventory.setItem(22, paper);
    }

    @EventHandler
    public void onInteract(InventoryInteractEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getTitle().equalsIgnoreCase("§eSécurityServer > §9" + player.getName())) {
            event.setCancelled(true);
        }
    }

    public void checkfly(Player player) {
        if (type.getType(player) == CheatType.Fly) {

        }
    }

}
