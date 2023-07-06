public enum Need {
    //a sim's needs in enum form
    SLEEP (-100, 100, 100),
    HUNGER (-100, 100, 100),
    BLADDER (-100, 100, 100),
    HYGIENE (-100, 100, 100),
    FUN (-100, 100, 100),
    SOCIAL (-100, 100, 100);

    public final static int NegativeNeedLowerLimit = -100;
    public final static int PositiveNeedUpperLimit = 100;
    public int simCurrentNeed = 100;

    Need(int NegativeNeedLowerLimit, int PositiveNeedUpperLimit, int simCurrentNeed) {
        this.simCurrentNeed = 100;
    }


}
