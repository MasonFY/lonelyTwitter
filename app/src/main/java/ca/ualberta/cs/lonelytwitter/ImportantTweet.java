package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/13/16.
 */

/**
 * judge the Tweet is a normalTweet or not.
 * if this ImportantTweet, then we should return a Boolean value "TRUE" for isImportant.
 */
public class ImportantTweet extends Tweet {

    public ImportantTweet(String message){super(message);
    }

    @Override
    public Boolean isImportant(){return Boolean.TRUE;
    }

}
