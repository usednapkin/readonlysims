public class interactableHunger extends interactables {

    private final String[] hungerNamePool = new String[]{"Fancy", "Crisp 'n' Ready", "Delicious", "Umami King", "Chef's Choice", "Sous Chef's Delight", "Crunchy"};
    private final String[] interactableNamePool = new String[]{"Fridge", "Oven", "Cupcake Machine", "Vending Machine", "Toaster", "Microwave", "RoboChef"};

    public interactableHunger() {
        //effectiveness between 40 and 100
        this.interactableEffectiveness = randomizer.nextInt(40, 100);

        //between five and ten ingame minutes
        this.interactableUsageDuration = randomizer.nextInt(5, 10);

        //randomise the name
        this.interactableName = randomItem(randomizer, hungerNamePool) + " " + randomItem(randomizer, interactableNamePool);
    
        //type identifier
        this.interactableType = "Hunger";
    
        //interactables will always be available when initialised
        this.inUse = true;

    }
}
