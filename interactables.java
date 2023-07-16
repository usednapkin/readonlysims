import java.util.Random;

public class interactables {

    public int interactableUsageDuration;
    public int interactableEffectiveness;
    public int inUseUntil;

    public String interactableName;

    //just for identification really
    public String interactableType;

    public boolean inUse;

    //first time using this one thats so fun for me
    protected static Random randomizer = new Random();

    public static <T> T randomItem(Random randomizer, T[] array){
        return array[randomizer.nextInt(array.length)];
    }

    public static String toString(String type, String interactableName, int interactableEffectiveness, boolean inUse) {
        String interactableString = "Name: " + interactableName + "\n Type: " + type + "\n Effectiveness: "+ interactableEffectiveness + "\n" ;

        return interactableString;
    }

}