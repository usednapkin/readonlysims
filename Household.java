

import java.util.ArrayList;
import java.util.Random;

/**
 * Initialises sim households
 * @author usednapkin
 */

public class Household {

    //sim random pools
    private final String[] mascNamePool = new String[]{"Dave", "John", "Toby", "Tom", "Miguel", "Henry", "Jack", "Ryan", "James", "Matt"};
    private final String[] femNamePool = new String[]{"Isabelle", "Anna", "Ffion", "Matilda", "Liz", "Amanda", "Carrie", "Sophie", "Eris", "Bessie"};
    private final String[] neutralNamePool = new String[]{"Alex", "Jay", "Sock", "Frog", "Ashley", "Casey", "Stick", "Cameron", "Tingle", "Rock"};
    private final String[] lastNamePool = new String[]{"Apple", "Blahaj", "Custard", "Doorstep", "Electron", "Foghorn", "Grape", "Hellscape", "Intangible", "Java"};
   
    private final Pronouns[] selectablePronouns = new Pronouns[]{Pronouns.THEY, Pronouns.HE, Pronouns.SHE};
    
    private final Age[] selectableAge = new Age[]{Age.CHILD, Age.TEEN, Age.YOUNGADULT, Age.ADULT, Age.ELDER};
    
    private final Job[] selectableJob = new Job[]{Job.TEACHER, Job.JANITOR, Job.ASTRONAUT, Job.PIZZAPERSON, Job.PROGRAMMER};
    
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
    
    private Random randomizer = new Random();
    
    public ArrayList<Sim> Sims = new ArrayList<Sim>();
    public ArrayList<Sim> Graveyard = new ArrayList<Sim>();

    /**
    * Generates a sim household with five sims and an address
    * 
    * Constructor takes no arguments, does everything automatically
    */
    public Household() {

        this.HouseholdFunds = 0;

        this.HouseholdAddress = randomizer.nextInt(64) + " " + randomItem(randomizer, addressNames) + " " + randomItem(randomizer, addressStreetType);
        
        this.leadSim = generateSim(true);
        this.sim2 = generateSim(false);
        this.sim3 = generateSim(false);
        this.sim4 = generateSim(false);
        this.sim5 = generateSim(false);  
        
        //array of sims for dealing with them in bulk/checking which ones are alive
        Sims.add(0, leadSim);
        Sims.add(0, sim2);
        Sims.add(0, sim3);
        Sims.add(0, sim4);
        Sims.add(0, sim5);

    }

    
    //thank you eris
    public <T> T randomItem(Random randomizer, T[] array){
        return array[randomizer.nextInt(array.length)];
    }

    /**
     * this one generates sims and makes sure they follow certain parameters
     * ie child/elder sims cant work, teen sims have a chance of
     * going to university or going to work
     * 
     * @param lead whether the sim is the lead sim of the household - 
     * this will force them in to being an adult
     * @return a freshly generated sim
     */
    public Sim generateSim(boolean lead) {
        Pronouns simPronouns = randomItem(randomizer, selectablePronouns);
        Job simJob = randomItem(randomizer, selectableJob);
        Age simAge = randomItem(randomizer, selectableAge);

        if (lead == true) {
            simAge = Age.ADULT;
        }
            
        if (simAge == Age.CHILD) {
            simJob = Job.CHILDSTUDENT;
        }

        if (simAge == Age.ELDER) {
            simJob = Job.RETIRED;
        }

        if (simAge == Age.TEEN) {
            float rollforUni = randomizer.nextFloat(1);
            if (rollforUni > 0.5) {
                simJob = Job.UNISTUDENT;
                
            }
        }

        String simfName = "" ;

            //choose name based off pronouns
        switch(simPronouns) {
            case THEY:
                simfName = randomItem(randomizer, neutralNamePool);
                break;
            case HE:
                simfName = randomItem(randomizer, mascNamePool);
                break;
            case SHE:
                simfName = randomItem(randomizer, femNamePool);
                break;
        }

        //pick a last name
        String simlName = randomItem(randomizer, lastNamePool);

        Sim newSim = new Sim(simfName, simlName, simPronouns, simJob, simAge);

        return newSim;
    }

        //getters for household funds/address
    public String getHouseholdFunds() {
        return this.HouseholdFunds.toString();
    }

    public String getHouseholdAddress() {
        return this.HouseholdAddress;
    }

        /**
        * get sim household information
        * @return a full list of sims
        */
    public String toString() {
        String simString = "In your household... \n";
        simString += this.leadSim.toString();
        simString += this.sim2.toString();
        simString += this.sim3.toString();
        simString += this.sim4.toString();
        simString += this.sim5.toString();

        simString += "Your Household's Current Funds: $" + this.getHouseholdFunds() + "\n";
        simString += "Your Household's Address: " + this.getHouseholdAddress() + "\n";

        return simString;
    }

}
