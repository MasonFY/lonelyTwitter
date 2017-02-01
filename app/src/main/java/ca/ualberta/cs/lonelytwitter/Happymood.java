package ca.ualberta.cs.lonelytwitter;

/**
 * Created by fmao1 on 1/17/17.
 */

/**
 * sub-function of the main function
 * if it is a happymood, so it will return a string "happy" in function whatmood().
 */
public class Happymood extends Mood{

    public Happymood(String face){
        super(face);
    }

    @Override
    public String whatmood(){
        return "happy";
    }
}
