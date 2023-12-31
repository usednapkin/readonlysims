//extended from base interactable class 
public class interactableSleep extends interactables {
    
    private final String[] sleepNamePool = new String[]{"King Comfy", "Queen Comfy", "Master", "Number One Very Good", "Sleep's Best", "Sweet Dreams", "Zzz..."};

    public interactableSleep() {
        //effectiveness between 60 and 100
        this.interactableEffectiveness = randomizer.nextInt(60, 100);

        //between six and seven in game hours
        this.interactableUsageDuration = randomizer.nextInt(360, 420);

        //randomise the name
        this.interactableName = randomItem(randomizer, sleepNamePool) + " Bed";

        //type identifier
        this.interactableType = "Sleep";

        //interactables will always be available when initialised
        this.inUse = true;
    }

}
