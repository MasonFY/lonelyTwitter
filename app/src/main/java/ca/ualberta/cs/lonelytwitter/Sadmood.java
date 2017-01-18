package ca.ualberta.cs.lonelytwitter;

/**
 * Created by fmao1 on 1/17/17.
 */

public class Sadmood extends Mood{

        public Sadmood(String face){
            super(face);
        }

        @Override
        public String whatmood(){
            return "sad";
        }
    }
