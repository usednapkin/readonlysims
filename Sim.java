import java.util.ArrayList;
public class Sim {
    //initialise everything about a sim
    private final String simFirstName;
    private final String simLastName;
    private final String simPronoun;

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
    public Sim(String fName, String lName, String pronoun, ArrayList<Needs> needs, Job job, Age age){
        this.simFirstName = fName;
        this.simLastName = lName;
        this.simPronoun = pronoun;

        this.simProfession = job;

        this.simAge = age;


        //sim should always be alive & available on initialisation, even if it chooses to do something or dies the first tick it can
        this.simIsAlive = true;
        this.simCurrentlyAvailable = true;
    }

    public void setPartner(Sim partner) {
        this.simPartner = partner;
    }

    public void setBestFriend(Sim bestFriend) {
        this.simBestFriend = bestFriend;
    }

}
