package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import java.util.ArrayList;

/**
 * Created by fmao1 on 2/14/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{

    public TweetListTest(){
        super(LonelyTwitterActivity.class);

    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another test Tweet");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());
    }

    public void testDeleteTweet(){

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testString(){
        assertEquals("'test' should be 'test'", "test", "test");
        assertTrue("'test' should start with 't'", "test".startsWith("t"));
    }

    public void testAddTweetDuplicate(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test for duplicate tweet");
        tweets.addTweet(tweet);
        try{
            tweets.addTweet(tweet);
            fail();
        } catch (IllegalArgumentException e){
        }
    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test for has tweet");
        tweets.add(tweet);
        assertTrue("has tweet", tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test the getting count");
        tweets.add(tweet);
        assertEquals("T means true, so we can get the count", tweets.getCount(), "T");
    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet0 = new NormalTweet("test0");
        Tweet tweet1 = new NormalTweet("test1");
        Tweet tweet2 = new NormalTweet("test2");
        tweets.addTweet(tweet0);
        tweets.addTweet(tweet1);
        tweets.addTweet(tweet2);
        ArrayList<Tweet> getTweets = tweets.getTweets();
        assertEquals("getTweets[0] = test0", getTweets.get(0), tweet0);
        assertEquals("getTweets[1] = test1", getTweets.get(1), tweet1);
        assertEquals("getTweets[2] = test2", getTweets.get(2), tweet2);
    }

}
