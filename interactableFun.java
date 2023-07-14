public class interactableFun extends interactables {
    private final String[] funNamePool = new String[]{"So Fun It Hurts", "High FPS", "Velocity", "Jam 'n' Groove", "Java™️ Enabled", "Seizure Proofed", "Fun-For-All"};
    private final String[] interactableNamePool = new String[]{"Gaming PC", "Games Console", "TV", "Board Game", "Laptop", "VR Headset", "CD Player"};

    public interactableFun() {
        //effectiveness between 80 and 100
        this.interactableEffectiveness = randomizer.nextInt(30, 100);

        //between 20 and 40 ingame minutes
        this.interactableUsageDuration = randomizer.nextInt(30, 60);

        //randomise the name
        this.interactableName = randomItem(randomizer, funNamePool) + " " + randomItem(randomizer, interactableNamePool);
        
        //interactables will always be available when initialised
        this.inUse = true;
    
    }
}
