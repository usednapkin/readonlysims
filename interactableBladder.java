//extended from interactables.java
public class interactableBladder extends interactables {
    
    private final String[] toiletNamePool = new String[]{"Whoosh!", "Waterfall", "Master", "Nature's Favourite", "Bladder's Choice", "Breaktime Buddy", "Toilet Times"};

    public interactableBladder() {
        //effectiveness always 100
        this.interactableEffectiveness = 100;

        //between five and ten ingame minutes
        this.interactableUsageDuration = randomizer.nextInt(5, 10);

        //randomise the name
        this.interactableName = randomItem(randomizer, toiletNamePool) + " Toilet";
    
        //type identifier
        this.interactableType = "Bladder";

        //interactables will always be available when initialised
        this.inUse = true;
    }

}
