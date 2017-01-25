package ca.ualberta.cs.lonelytwitter;

/**
 * Created by fmao1 on 1/17/17.
 */

public class NormalTweet2 extends Tweet implements Tweetable {
    public NormalTweet2(String message){

        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
