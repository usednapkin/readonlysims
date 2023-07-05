import java.util.ArrayList;
public class Sim {
    //initialise everything about a sim
    private final String simFirstName;
    private final String simLastName;

    private final Pronouns simPronoun;

    //private ArrayList<Traits> simTraits;
    private ArrayList<Needs> simNeeds;

    private boolean simCurrentlyAvailable;
    private boolean simIsAlive;

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
    }

    //getters & general sim info
    public String getName() {
        return this.simFirstName + " " + this.simLastName;
    }

    public String getPronoun() {
        return this.simPronoun.subject.toString() + "/" + this.simPronoun.objectP.toString();
    }

    public String getAge() {
        return this.simAge.toString();
    }

    public String getJob() {
        return this.simProfession.toString();
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

    public String toString() {
        
        return this.getName() + "'s info! \n Pronouns: " + this.getPronoun() + "\n Life Stage: " + this.getAge() + "\n Profession: " + this.getJob() + "\n Partner: " + this.getPartner() + "\n Best Friend: " + this.getBestie() + "\n" + this.isAvailable() + "\n";

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
