import java.util.Random;

public class interactables {

    public int interactableUsageDuration;
    public int interactableEffectiveness;

    public String interactableName;

    public static <T> T randomItem(Random randomizer, T[] array){
        return array[randomizer.nextInt(array.length)];
    }

}