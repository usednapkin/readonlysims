public enum Pronouns {
    //cant believe its come to this
    THEY ("they", "them", "their", "theirs", "theirself"),
    HE ("he", "him", "his", "himself", "hisself"),
    SHE("she", "her", "her", "hers", "herself");

    public final String subject;
    public final String objectP;
    public final String possessiveD;
    public final String possessiveP;
    public final String reflexive;

    Pronouns(String subject, String objectP, String possessiveD, String possessiveP, String reflexive) {
        this.subject = subject;
        this.objectP = objectP;
        this.possessiveD = possessiveD;
        this.possessiveP = possessiveP;
        this.reflexive = reflexive;
    }
}
