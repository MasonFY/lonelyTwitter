package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by fmao1 on 1/17/17.
 */


/**
 * defined what elements of Mood should have.
 */
public abstract class Mood {
    private String face;
    private Date date;

    /**
     * to get what face looks like
     * @param face input the face you want to inout
     */
    public Mood(String face){
        this.face = face;
        this.date = new Date();
    }

    /**
     * to get the face and the date
     * @param face input the face to the function
     * @param date inout the date to the function
     */
    public Mood(String face, Date date){
        this.face = face;
        this.date = date;
    }

    /**
     * @return a String what mood you get to
     */
    public abstract String whatmood();
}
