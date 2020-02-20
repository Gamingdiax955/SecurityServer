package fr.diax.ss.cheattypeEnum;

import org.bukkit.entity.Player;

public enum CheatType {

    Fly(CheatType.Fly);

    CheatType type;

    CheatType(CheatType type) {
        this.type = type;
    }

    public CheatType getType(Player player) {
        if (type.getType(player) == CheatType.Fly) {
            if (player.getLocation().getY() > 5) {

            }
        }
        return type;
    }


}
