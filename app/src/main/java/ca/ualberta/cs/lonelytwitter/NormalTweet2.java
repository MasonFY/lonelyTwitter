package ca.ualberta.cs.lonelytwitter;

/**
 * Created by fmao1 on 1/17/17.
 */


/**
 * judge the Tweet is a normalTweet or not.
 * if this a normalTweet, then we should return a Boolean value "False" for isImportant.
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
