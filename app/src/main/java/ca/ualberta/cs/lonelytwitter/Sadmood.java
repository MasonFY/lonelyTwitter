package ca.ualberta.cs.lonelytwitter;

/**
 * Created by fmao1 on 1/17/17.
 */

/**
 * sub-function of the main function Mood()
 * if it is a Sadmood, so it will return a string "sad" in function whatmood().
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
