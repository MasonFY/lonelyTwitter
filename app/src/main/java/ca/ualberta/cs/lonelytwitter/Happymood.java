package ca.ualberta.cs.lonelytwitter;

/**
 * Created by fmao1 on 1/17/17.
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
