package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * Created by fmao1 on 2/14/17.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    public void add(Tweet tweet){
        tweets.add(tweet);
    }

    public void addTweet(Tweet tweet){

        if (hasTweet(tweet)) {
            throw new IllegalArgumentException();
        }
        else{
            tweets.add(tweet);
        }
    }

    public ArrayList<Tweet> getTweets(){
        return tweets;
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }
    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public int getCount(){
        return tweets.size();
    }
}

