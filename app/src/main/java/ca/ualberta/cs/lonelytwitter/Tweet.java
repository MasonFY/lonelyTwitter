package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

import static android.R.attr.data;

/**
 * Created by famo1 on 9/13/16.
 *
 * Tweet class is super class that implements Tweetable
 */

/**
 * defined what is a Tweet, and what tweet should include
 */
public abstract class Tweet {
    private String message;
    private Date date;

    /**
     * What is a message
     * @param message get the message and the new date
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * to find this is a ImportantTweet or not
     * @return it will return a Boolean value
     */
    public abstract Boolean isImportant();


    /**
     * judge the length of this message is biger than 140 or not
     * @param message input the message to find it is good or not
     * @throws TweetTooLongException if the text is too long
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * set a data
     * @param date input a data
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * to get a message
     * @return the message you want to get
     */
    public String getMessage() {
        return message;
    }

    /**
     * to get a data
     * @return the data you want to use
     */
    public Date getDate() {
        return date;
    }


    /**
     *
     * @return put "|" between every data and message
     */
    @Override
    public String toString(){
        return date.toString() + "|" + message;
    }
}

