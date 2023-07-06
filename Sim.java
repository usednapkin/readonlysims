import java.util.ArrayList;

public class Sim {
    //initialise everything about a sim
    private final String simFirstName;
    private final String simLastName;

    private final Pronouns simPronoun;

    //private ArrayList<Traits> simTraits;
    private ArrayList<Need> simNeeds = new ArrayList<Need>();

    private boolean simCurrentlyAvailable;
    private boolean simIsAlive;

    //tick measure for when sim will be able to do something. 
    //will normally be 0 and then will be set to things when sim is doing
    private int simOccupiedUntil;

    private Job simProfession;

    private Age simAge;

    private Sim simPartner;
    private Sim simBestFriend;

    private ArrayList<Sim> friends;
    private ArrayList<Sim> children;


    //sim constructor
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

        this.simNeeds.add(Need.SLEEP);
        this.simNeeds.add(Need.BLADDER);
        this.simNeeds.add(Need.HUNGER);
        this.simNeeds.add(Need.HYGIENE);
        this.simNeeds.add(Need.SOCIAL);
        this.simNeeds.add(Need.FUN);
    }

    //getters & general sim info
    public String getName() {
        return this.simFirstName + " " + this.simLastName;
    }

    public String getPronoun() {
        return this.simPronoun.subject.toString() + "/" + this.simPronoun.objectP.toString();
    }

    public String getAge() {
        return this.simAge.toString().toLowerCase();
    }

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
        return "Current Need states:\n Sleep: " + simNeeds.get(0).simCurrentNeed + "/100 | Bladder: "  + simNeeds.get(1).simCurrentNeed + "/100 | Hunger: "  + simNeeds.get(2).simCurrentNeed + "/100 | Hygiene: "  + simNeeds.get(3).simCurrentNeed + "/100 | Social: "  + simNeeds.get(4).simCurrentNeed + "/100 | Fun: "  + simNeeds.get(5).simCurrentNeed + "/100 \n";
    }

    public String toString() {
        
        return this.getName() + "'s info! \n Pronouns: " + this.getPronoun() + "\n Life Stage: " + this.getAge() + "\n Profession: " + this.getJob() + "\n Partner: " + this.getPartner() + "\n Best Friend: " + this.getBestie() + "\n" + this.isAvailable() + "\n" + this.getNeed();

    }
    
    //i apologise for the ugly but this was the only way i could think of doing this without destroying the delicate structure i have built
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

    public void die() {
        this.simIsAlive = false;
    }

    public void setPartner(Sim partner) {
        this.simPartner = partner;
    }

    public void setBestFriend(Sim bestFriend) {
        this.simBestFriend = bestFriend;
    }


}
