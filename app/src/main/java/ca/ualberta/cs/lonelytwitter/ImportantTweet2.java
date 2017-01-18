package ca.ualberta.cs.lonelytwitter;

/**
 * Created by fmao1 on 1/17/17.
 */

public class ImportantTweet2 extends Tweet {

    public ImportantTweet2(String message){

        super(message);
    }

    @Override
    public Boolean isImportant(){

        return Boolean.TRUE;
    }

}
