/**
 * Initialises sim ages
 * @author usednapkin
 */

public enum Age {

    /*NOTE
     * BABIES ARE GONNA BE REALLY HARD TO IMPLEMENT BECAUSE THEY HAVE NO AUTONOMY SO I'M LEAVING THEM FOR NOW
     * gonna have to figure out how to balance baby with sims own needs
     * treat baby as need? idk
     */
    //enummed sim ages

   CHILD (true, false, true),
   TEEN (true, true, true),
   YOUNGADULT (true, true, false),
   ADULT (true, true, false),
   ELDER (true, false, false);
   
   //age-dependent things a sim can do
   private final boolean simCanAutonomy;
   private final boolean simCanWork;
   private final boolean simCanSchool;

     /**
     * constructor for sim ages
     * @param canAutonomy whether the sim can perform autonomy for itself 
     * @param canWork whether the sim can go to work
     * @param canSchool whether the sim can go to school
     */
     Age(boolean canAutonomy, boolean canWork, boolean canSchool) {
        this.simCanAutonomy = canAutonomy;
        this.simCanWork = canWork;
        this.simCanSchool = canSchool;
     }

}
