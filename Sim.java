import java.util.ArrayList;

/**
 * Initialises all sims
 * 
 * @author usednapkin
 */

public class Sim {
    //initialise everything about a sim
    private final String simFirstName;
    private final String simLastName;

    private final Pronouns simPronoun;

    private boolean simCurrentlyAvailable;
    private boolean simIsAlive;

    //tick measure for when sim will be able to do something. 
    //will normally be 0 and then will be set to things when sim is doing
    private int simOccupiedUntil;

    //sim needs, originally did these as an enum because i'm insane but i think
    //this way is probably a lot... easier, idk what i was on
    private int needSleep;
    private int needBladder;
    private int needHunger;
    private int needHygiene;
    private int needSocial;
    private int needFun;

    //gonna use these to regulate sim feelings
    public final int simNeedUpperLimit = 100;
    public final int simNeedLowerLimit = -100;

    private Job simProfession;

    private Age simAge;

    private Sim simPartner;
    private Sim simBestFriend;

    private ArrayList<Sim> friends;
    private ArrayList<Sim> children;


    //sim constructor
    /**
     * all of these will be randomly selected upon household generation 
     * 
     * @param fName sim's first name 
     * @param lName sim's last name
     * @param pronoun chosen pronoun for sim
     * @param job chosen job for sim
     * @param age chosen age for sim
     */
    public Sim(String fName, String lName, Pronouns pronoun, Job job, Age age){
        this.simFirstName = fName;
        this.simLastName = lName;
        this.simPronoun = pronoun;

        this.simProfession = job;

        this.simAge = age;


        //sim should always be alive & available on initialisation, even if it chooses to do something or dies the first tick it can
        this.simIsAlive = true;
        this.simCurrentlyAvailable = true;
        this.simOccupiedUntil = 0;

        //generate a full happy batch of needs on start
        this.needSleep = 100;
        this.needBladder = 100;
        this.needHygiene = 100;
        this.needHunger = 100;
        this.needFun = 100;
        this.needSocial = 100;

    }

    //getters & general sim info

    /**
     * for easier formatting
     * @return sim's first name and last name 
     */
    public String getName() {
        return this.simFirstName + " " + this.simLastName;
    }

    /**
     * for easier formatting
     * @return sim's formatted pronouns
     */
    public String getPronoun() {
        return this.simPronoun.subject.toString() + "/" + this.simPronoun.objectP.toString();
    }

    /**
     * for easier formatting
     * @return sim's formatted age
     */
    public String getAge() {
        return this.simAge.toString().toLowerCase();
    }

    /**
     * @return a formatted version of the sim's job
     */
    public String getJob() {
        Job job = this.simProfession;

        switch(job) {
            //ugly, sorry
            case ASTRONAUT:
                return "Astronaut";
            case CHILDSTUDENT:
                return "Young Student";
            case JANITOR:
                return "Janitor";
            case PIZZAPERSON:
                return "Pizza Maker/Delivery Person";
            case PROGRAMMER:
                return "Programmer";
            case RETIRED:
                return "This sim is retired!";
            case TEACHER:
                return "Teacher";
            case UNISTUDENT:
                return "University student";
            default:
                return "This sim does not appear to have a job!"; //you should NOT be seeing this message
        }
    }


    public String isAvailable() {
        if (this.simCurrentlyAvailable = true)
            return this.simFirstName + " isn't doing anything right now!";
        
        return this.simFirstName + " is busy right now!";
    }

    public String getPartner() {
        if (this.simPartner != null)
            return this.simFirstName + "'s partner is " + this.simBestFriend.getName();
        
            return "This sim does not have a partner!";
    }

    public String getBestie() {
        if (this.simBestFriend != null)
            return this.simFirstName + "'s best friend is " + this.simBestFriend.getName();
        
            return "This sim does not have a best friend!";
    }

    public String getNeed() {
        return "Current Need states:\n Sleep: " + this.needSleep + "/100 | Bladder: "  + this.needBladder + "/100 | Hunger: "  + this.needHunger + "/100 | Hygiene: "  + this.needHygiene + "/100 | Social: "  + this.needSocial + "/100 | Fun: "  + this.needFun + "/100 \n";
    } 

      //this is what happens when you can't use enums. i remember why i tried now
      //anyway lets get to it! (refactor this later, jesus christ)

      /**
       * streamlines the need requirement by making sure it will bound to -100+100
       * 
        * @param amount the amount to increase or decrease by
        * @param currentNeedState the need's current state
        * @param addSub whether its being added or subtracted
        */
    public int checkNeedRequirement(int amount, int currentNeedState, boolean addSub) {
        //make everything positive
        amount = Math.abs(amount);
        //max is 100
        amount = Math.min(amount, 100);

        //reduce to 100
        if(addSub == true ) {
            if ((currentNeedState + amount) > simNeedUpperLimit) {
                amount = (simNeedUpperLimit - currentNeedState);
                return amount;
            }  
        }
        
        if (addSub == false){
            if ((currentNeedState - amount) < simNeedLowerLimit) {
                amount = (simNeedLowerLimit - currentNeedState);
                return amount;
            }
        }
        return amount;
    }

    //true = add, false = remove
    public void setNeedSleep(int amount, boolean addSub) {

        amount = checkNeedRequirement(amount, this.needSleep, addSub);

        if (addSub == true) {
            this.needSleep = this.needSleep + amount;
            return;
        }
        this.needSleep = this.needSleep - amount;
      }

    public void setNeedBladder(int amount, boolean addSub) {

        amount = checkNeedRequirement(amount, this.needBladder, addSub);

        if (addSub == true) {
            this.needBladder = this.needBladder + amount;
            return;
        }

        this.needBladder = this.needBladder - amount;
    }

    public void setNeedHunger(int amount, boolean addSub) {

        amount = checkNeedRequirement(amount, this.needHunger, addSub);

        if (addSub == true) {
            this.needHunger = this.needHunger + amount;
            return;
        }

        this.needHunger = this.needHunger - amount;
    }

    public void setNeedHygiene(int amount, boolean addSub) {

        amount = checkNeedRequirement(amount, this.needHygiene, addSub);

        if (addSub == true) {
            this.needHygiene = this.needHygiene + amount;
            return;
        }

        this.needHygiene = this.needHygiene - amount;
    }

    public void setNeedFun(int amount, boolean addSub) {

        amount = checkNeedRequirement(amount, this.needFun, addSub);

        if (addSub == true) {
            this.needFun = this.needFun + amount;
            return;
        }

        this.needFun = this.needFun - amount;
    }

    public void setNeedSocial(int amount, boolean addSub) {

        amount = checkNeedRequirement(amount, this.needSocial, addSub);

        if (addSub == true) {
            this.needSocial = this.needSocial + amount;
            return;
        }

        this.needSocial = this.needSocial - amount;
    }



    public String toString() {
        return this.getName() + "'s info! \n Pronouns: " + this.getPronoun() + "\n Life Stage: " + this.getAge() + "\n Profession: " + this.getJob() + "\n Partner: " + this.getPartner() + "\n Best Friend: " + this.getBestie() + "\n" + this.isAvailable() + "\n" + this.getNeed();    
    }
    
    //i apologise for the ugly but this was the only way i could think of doing this without destroying the delicate structure i have built
    /**
     * ages up a sim, calls death function or changes sim age
     */
    public void ageUp() {
        switch(this.simAge) {
            case CHILD:
                this.simAge = Age.TEEN;
                break;
            case TEEN:
                this.simAge = Age.YOUNGADULT;
                break;
            case YOUNGADULT:
                this.simAge = Age.ADULT;
                break;
            case ADULT:
                this.simAge = Age.ELDER;
                break;
            case ELDER:
                this.die();
                break;
        }
    }

    /**
     * objectively the funniest function i have ever had to write
     * changes death flags
     * 
     * no i'm not implementing ghosts, but in case i do, i've only changed the death flag
     * ;}
     */
    public void die() {
        this.simIsAlive = false;
    }

    //these are just setters for friend/partner flags
    public void setPartner(Sim partner) {
        this.simPartner = partner;
    }

    public void setBestFriend(Sim bestFriend) {
        this.simBestFriend = bestFriend;
    }


}
