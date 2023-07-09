/**
 * Initialises sim jobs along with daily pay, start times,
 * end times & who can work them
 * @author usednapkin
 */

public enum Job {
    //enum list of jobs
    //ill expand this
    TEACHER (480, 360, 400, false),
    JANITOR (480, 600, 350, false),
    ASTRONAUT (540, 480, 600, false),
    PROGRAMMER (540, 480, 700, false),
    PIZZAPERSON (480, 600, 350, false),
    RETIRED(0, 0, 100, false),
    UNISTUDENT (480, 360, 0, true),
    CHILDSTUDENT (480, 360, 0, true);


    private final int workStartTime;
    private final int simWorkingTicks;
    private final int simDailyPay;
    private final boolean childOnly;
   
    /**
     * constructs job
     * @param startTime tick value when work starts
     * @param workTicks how long the sim wil be unavailable for
     * @param dailyPay how much sim gets paid
     * @param child whether this is a job for babies (school)
     */
    Job(int startTime, int workTicks, int dailyPay, boolean child) {
        this.workStartTime = startTime;
        this.simWorkingTicks = workTicks;
        this.simDailyPay = dailyPay;
        this.childOnly = child;
    }


}
