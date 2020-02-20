package fr.diax.ss.cheattypeEnum;

public enum CheatType {

    Fly("Fly"),
    Freecam("Freecam");
    private String name;


    private CheatType type;

    CheatType(String name) {
        this.name = name;


    }

    public CheatType getType() {
        return type;
    }

}
