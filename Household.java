

import java.util.ArrayList;
import java.util.Random;

/**
 * Initialises sim households
 * @author usednapkin
 */

public class Household {

    private final String[]addressNames = new String[]{"Yellow", "Blue", "Red", "Pink", "Purple", "Orange", "Green", "Turquoise", "Magenta", "Prismarine", "Grey"};
    private final String[] addressStreetType = new String[]{"Lane", "Road", "Court", "Avenue", "Street"};

    //generates all sims
    //unfortunately i think these need to be public
    public Sim leadSim;
    public Sim sim2;
    public Sim sim3;
    public Sim sim4;
    public Sim sim5;
    
    public Integer HouseholdFunds;
    public String HouseholdAddress;
    
    public ArrayList<Sim> Sims = new ArrayList<Sim>();
    public ArrayList<Sim> Graveyard = new ArrayList<Sim>();

    private Random randomizer = new Random();

    /**
    * Generates a sim household with five sims and an address
    * 
    * Constructor takes no arguments, does everything automatically
    */
    public Household() {

        this.HouseholdFunds = 0;

        this.HouseholdAddress = randomizer.nextInt(64) + " " + randomItem(randomizer, addressNames) + " " + randomItem(randomizer, addressStreetType);
    
        
        //array of sims for dealing with them in bulk/checking which ones are alive
        Sims.add(0, Sim.generateSim(true));
        Sims.add(1, Sim.generateSim(false));
        Sims.add(2, Sim.generateSim(false));
        Sims.add(3, Sim.generateSim(false));
        Sims.add(4, Sim.generateSim(false));

    }

        //getters for household funds/address
    public String getHouseholdFunds() {
        return this.HouseholdFunds.toString();
    }

    public String getHouseholdAddress() {
        return this.HouseholdAddress;
    }

    public <T> T randomItem(Random randomizer, T[] array){
        return array[randomizer.nextInt(array.length)];
    }


        /**
        * get sim household information
        * @return a full list of sims
        */
    public String toString() {
        String simString = "In your household... \n";
        for (int i = 0; i < Sims.size(); i++) {
            simString = simString + Sims.get(i);
        }

        simString += "Your Household's Current Funds: $" + this.getHouseholdFunds() + "\n";
        simString += "Your Household's Address: " + this.getHouseholdAddress() + "\n";

        return simString;
    }

}
