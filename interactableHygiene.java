public class interactableHygiene extends interactables {

    private final String[] hygeineNamePool = new String[]{"Fancy", "Bubbles", "Deluxe", "Stink-B-Gone", "Automatic", "Clean As A Whistle"};
    private final String[] interactableNamePool = new String[]{"Bath", "Shower", "Cleaning Machine", "Kitchen Sink", "Jacuzzi", "Skin Blaster 9000", "PowerWasher"};

    public interactableHygiene() {
        //effectiveness between 80 and 100
        this.interactableEffectiveness = randomizer.nextInt(80, 100);

        //between 20 and 40 ingame minutes
        this.interactableUsageDuration = randomizer.nextInt(20, 40);

        //randomise the name
        this.interactableName = randomItem(randomizer, hygeineNamePool) + " " + randomItem(randomizer, interactableNamePool);

        //interactables will always be available when initialised
        this.inUse = true;
    }
}
