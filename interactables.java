import java.util.Random;

public class interactables {

    public int interactableUsageDuration;
    public int interactableEffectiveness;
    public int inUseUntil;

    public String interactableName;

    public boolean inUse;

    //first time using this one thats so fun for me
    protected static Random randomizer = new Random();

    public static <T> T randomItem(Random randomizer, T[] array){
        return array[randomizer.nextInt(array.length)];
    }

}