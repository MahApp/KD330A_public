package se.mah.rssreader.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import android.content.Context;
import android.util.Log;

public class FeedManager {
	private Context appContext;
	//private ArrayList<RSSItem> articleList;
	RSSFeed rssFeed;
	private static final String MAH_NEWS_SAVED_FILE_NAME = "mahnews";
	private static final String MAH_NEWS_ADDRESS = "http://www.mah.se/Nyheter/RSS/News/";
	private static final String MEDARBETARNYHETER = "http://www.mah.se/Nyheter/RSS/Medarbetarnyheter-fran-Malmo-hogskola/";
	private static final String KURSLITTERTUR = "http://www.mah.se/Nyheter/RSS/Kurslitteraturannonser/";
	private static final String TAG = "FeedManager";
	 
	public FeedManager(Context c) {
		appContext = c;
	}
	
	public RSSFeed getSavedFeed()
	{
		loadCache();
		return rssFeed;
	}
	
	public void readFeedFromNet(){
		DOMParser domParser = new DOMParser();
		Random r = new Random();
		RSSFeed rssFeed;
		int i = r.nextInt(3);
		if (i==0){
			rssFeed = domParser.parseXml(MAH_NEWS_ADDRESS);
		}else if (i==1){
			rssFeed = domParser.parseXml(MEDARBETARNYHETER);
		}else{
			rssFeed = domParser.parseXml(KURSLITTERTUR);
		}
		saveCache(rssFeed);  //Save the latest
		Log.d(TAG, "Read MAH News items from net: "+ rssFeed.getItemCount());
	}
	
	private void saveCache(RSSFeed rssFeed)
	{
			try {
				FileOutputStream fos = appContext.openFileOutput(MAH_NEWS_SAVED_FILE_NAME , Context.MODE_PRIVATE);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(rssFeed);
				oos.close();
				fos.close();
				Log.d(TAG, "Saved MAH News");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

	public boolean loadCache()
	{		
		boolean returnValue = false; 
		if (appContext.getFileStreamPath(MAH_NEWS_SAVED_FILE_NAME).exists())
		{
			try
			{
				FileInputStream fis = appContext.openFileInput(MAH_NEWS_SAVED_FILE_NAME);
				ObjectInputStream ois = new ObjectInputStream(fis);
				rssFeed = (RSSFeed) ois.readObject();
				fis.close();
				returnValue = true;
			}
			catch (Exception e)
			{
				Log.e(TAG, e.toString());
				/* something is probably wrong with the cache file so 
				 *  let's delete it*/
				deleteCache();
			}
		}
		
		/*
		 *  return the complete list of articles to the listener
		 *  when all items in the feed queue are processed
		 */
		return returnValue;
	}

	public void deleteCache()
	{
		Log.e(TAG, "Deleting file: " + appContext.getFileStreamPath(MAH_NEWS_SAVED_FILE_NAME).toString());
		appContext.getFileStreamPath(MAH_NEWS_SAVED_FILE_NAME).delete();
	}
}
