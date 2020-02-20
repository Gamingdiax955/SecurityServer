package fr.diax.ss;

import fr.diax.ss.command.ssCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ssMain extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("ss").setExecutor(new ssCommand());
        getServer().getPluginManager().registerEvents(new ssCommand(), this);
    }

    @Override
    public void onDisable() {

    }
}
