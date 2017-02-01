package ca.ualberta.cs.lonelytwitter;

/**
 * Created by fmao1 on 1/17/17.
 */


/**
 * judge the Tweet is a normalTweet or not.
 * if this ImportantTweet, then we should return a Boolean value "TRUE" for isImportant.
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
