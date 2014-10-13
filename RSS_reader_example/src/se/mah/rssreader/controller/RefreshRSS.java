package se.mah.rssreader.controller;
import se.mah.rssreader.model.FeedManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class RefreshRSS extends AsyncTask <Void, Void, Void> {
	
	/**
	 * Class for starting an AsyncTask that downloads new info from RSSFeed.
	 */
	private Context 			mContext;
	private RSSCallback 		mFragmentCallback; //When we are finished we will tell a class that implements this interface that we are ready
	private final String 		TAG = "Refresh";
	
	public RefreshRSS(RSSCallback fragmentCallback, Context context) {
		this.mFragmentCallback = fragmentCallback;
		this.mContext = context;
	}
	

	/**
	 * What to do
	 */
	@Override
	protected Void doInBackground(Void... params) {
		FeedManager feedManager = new FeedManager(mContext);
		feedManager.readFeedFromNet();
		return null;
	}
	/**
	 * What to do once it's finished
	 */
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		try {
			mFragmentCallback.onRSSRefreshCompleted();  //Tell the calling class that the work is finished.
		} catch (Exception e) {
			Log.i(TAG,e.getMessage());
		}
		Log.d(TAG, "Done.");
	}
}
