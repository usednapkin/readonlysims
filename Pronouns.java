/**
 * Initialises sim pronouns
 * @author usednapkin
 */

public enum Pronouns {
    //cant believe its come to this
    THEY ("they", "them", "their", "theirs", "theirself"),
    HE ("he", "him", "his", "his", "himself"),
    SHE("she", "her", "her", "hers", "herself");

    public final String subject;
    public final String objectP;
    public final String possessiveD;
    public final String possessiveP;
    public final String reflexive;

    /**
     * @param subject subjective pronoun - i.e they
     * @param objectP objective pronoun - i.e them
     * @param possessiveD - possessive determiner - indicates posession - their, his, her
     * @param possessiveP - possessive pronoun - theirs, himself, hers
     * @param reflexive - reflexive pronoun, refers to previously named noun/pronoun - theirself, hisself, herself
     */
    Pronouns(String subject, String objectP, String possessiveD, String possessiveP, String reflexive) {
        this.subject = subject;
        this.objectP = objectP;
        this.possessiveD = possessiveD;
        this.possessiveP = possessiveP;
        this.reflexive = reflexive;
    }
}
