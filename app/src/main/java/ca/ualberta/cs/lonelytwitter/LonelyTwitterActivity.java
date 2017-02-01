package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is the main view of the project. <br> In this class, user interaction and
 * file manipulation is performed.
 * All files are in the form of "json" files that are stored in Emulator's access
 * <pre>\
 * 		pre-fromatted text:<br>
 * 		 File Explorer -> data -> data -> ca.ualberta.cs.longlytweitter -> files -> file.sav
 * </pre>
 * <code> begin <br>
 *     some pseudo code <br>
 *      end. </code>
 * This file name is indicated in the &nbsp $nbsp FILENAME constant.
 * <ul>
 *     <li> item 1</li>
 *     <li> item 2</li>
 *     <li> item 3</li>
 * </ul>
 * <ol>
 *     <li> item 1</li>
 *     <li> item 2</li>
 *     <li> item 3</li>
 * </ol>
 *
 * @author fmao1
 * @version 1.0
 * @see Tweet
 * @since 0.5
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweet are saved there. The format of the file is JSON.
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */

	private static final String FILENAME = "file.sav";
	private enum TweetListOrdering {DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING, TEXT_DESCENDING}
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				text = trimExtraSpaces(text);

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				/*Tweet newTweet = new NormalTweet(text);
				try {
					newTweet.setMessage("This is a tweet");
				} catch (TweetTooLongException e) {
					e.printStackTrace();
				}
				ImportantTweet newestImportantTweet = new ImportantTweet(text);
				newestImportantTweet.getMessage();
				newestImportantTweet.isImportant();

				String test = newTweet.getMessage();

				ArrayList<Tweet> tweetList = new ArrayList<Tweet>(
			    tweetList.add(newTweet);
				tweetList.add(newestImportantTweet);*/

				saveInFile();


			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();
				adapter.notifyDataSetChanged();
				saveInFile();}
		});

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
		//tweetList = new ArrayList<Tweet>();
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * TRIMS EXTRA SPACES USING REGULAR EXPRESSION.
	 *
	 * @param inputString string that needs to be cleared of extra spaces
	 * @return resulting string
     */

	private String trimExtraSpaces(String inputString){
		inputString = inputString.replaceAll("\\s+", " ");
		return inputString;
	}

	/**
	 * This method sorts item in the tweet list and refreshes the adapter.
	 * @param ordering
     */
	private void sortTweetListItems(TweetListOrdering ordering){

	}

	/**
	 * Load tweet from specified file.
	 *
	 * @throws TweetTooLongException if the text is too long.
	 * @exception FileNotFoundException if the file is not created first.
	 */
	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			//taken from http://
			//2017-01-24 18:19
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);
			/*String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}*/

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			tweetList = new ArrayList<Tweet>();
			//throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * Save tweets to a specified file in Json format.
	 * @throws FileNotFoundException if file folder doesn't exist.
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			/*fos.write(new String(date.toString() + " | " + text)
					.getBytes());*/

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			// TODO: Handle the Exception properly later
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();
		}
	}
}