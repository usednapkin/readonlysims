

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Initialises sim households
 * @author usednapkin
 */

public class Household {

        //sim random pools
        //should probably do something different with these but like,, h
        List<String> mascNamePool = Arrays.asList("Dave", "John", "Toby", "Tom", "Miguel", "Henry", "Jack", "Ryan", "James", "Matt");
        List<String> femNamePool = Arrays.asList("Isabelle", "Anna", "Ffion", "Matilda", "Liz", "Amanda", "Carrie", "Sophie", "Eris", "Bessie");
        List<String> neutralNamePool = Arrays.asList("Alex", "Jay", "Sock", "Frog", "Ashley", "Casey", "Stick", "Cameron", "Tingle", "Rock");

        List<String> lastNamePool = Arrays.asList("Apple", "Blahaj", "Custard", "Doorstep", "Electron", "Foghorn", "Grape", "Hellscape", "Intangible", "Java");;

        List<Pronouns> selectablePronouns = Arrays.asList(Pronouns.THEY, Pronouns.HE, Pronouns.SHE);
        List<Age> selectableAge = Arrays.asList(Age.CHILD, Age.TEEN, Age.YOUNGADULT, Age.ADULT, Age.ELDER);
        List<Job> selectableJob = Arrays.asList(Job.TEACHER, Job.JANITOR, Job.ASTRONAUT, Job.PIZZAPERSON, Job.PROGRAMMER);


        List<String> addressNames = Arrays.asList("Yellow", "Blue", "Red", "Pink", "Purple", "Orange", "Green", "Turquoise", "Magenta", "Prismarine", "Grey");
        List<String> addressStreetType = Arrays.asList("Lane", "Road", "Court", "Avenue", "Street");

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
            this.HouseholdAddress = randomizer.nextInt(64) + " " + randomiserStr(randomizer, addressNames) + " " + randomiserStr(randomizer, addressStreetType);

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

        //these just randomise things 

        public String randomiserStr(Random randomizer, List<String> list) {
            return list.get(randomizer.nextInt(list.size()));
        }

        public Age randomiserAge(Random randomizer, List<Age> list) {
            return list.get(randomizer.nextInt(list.size()));
        }

        public Job randomiserJob(Random randomizer, List<Job> list) {
            return list.get(randomizer.nextInt(list.size()));
        }

        public Pronouns randomiserPronouns(Random randomizer, List<Pronouns> list) {
            return list.get(randomizer.nextInt(list.size()));
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
            Pronouns simPronouns = randomiserPronouns(randomizer, selectablePronouns);
            Job simJob = randomiserJob(randomizer, selectableJob);
            Age simAge = randomiserAge(randomizer, selectableAge);

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
                    simfName = randomiserStr(randomizer, neutralNamePool);
                    break;
                case HE:
                    simfName = randomiserStr(randomizer, mascNamePool);
                    break;
                case SHE:
                    simfName = randomiserStr(randomizer, femNamePool);
                    break;
            }

            //pick a last name
            String simlName = randomiserStr(randomizer, lastNamePool);

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
