package fr.diax.ss;

import fr.diax.ss.command.SsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class SsMain extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("ss").setExecutor(new SsCommand());
        getServer().getPluginManager().registerEvents(new SsCommand(), this);
    }

    @Override
    public void onDisable() {

    }
}
