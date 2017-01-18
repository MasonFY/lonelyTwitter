package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by fmao1 on 1/17/17.
 */

public abstract class Mood {
    private String face;
    private Date date;

    public Mood(String face){
        this.face = face;
        this.date = new Date();
    }

    public Mood(String face, Date date){
        this.face = face;
        this.date = date;
    }


    public abstract String whatmood();
}
