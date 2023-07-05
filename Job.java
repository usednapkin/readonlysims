public enum Job {
    //enum list of jobs
    //ill expand this
    TEACHER (480, 360, 400, false),
    JANITOR (480, 600, 350, false),
    ASTRONAUT (540, 480, 600, false),
    PROGRAMMER (540, 480, 700, false),
    PIZZAPERSON (480, 600, 350, false),
    UNISTUDENT (480, 360, 0, true),
    CHILDSTUDENT (480, 360, 0, true);

    private final int workStartTime;
    private final int simWorkingTicks;
    private final int simDailyPay;
    private final boolean childOnly;
   
    Job(int startTime, int workTicks, int dailyPay, boolean child) {
        this.workStartTime = startTime;
        this.simWorkingTicks = workTicks;
        this.simDailyPay = dailyPay;
        this.childOnly = child;
    }

    
}
