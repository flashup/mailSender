package org.haxe.extension;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import android.net.Uri;
import android.graphics.Bitmap;
import java.io.FileOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;

/* 
	You can use the Android Extension class in order to hook
	into the Android activity lifecycle. This is not required
	for standard Java code, this is designed for when you need
	deeper integration.
	
	You can access additional references from the Extension class,
	depending on your needs:
	
	- Extension.assetManager (android.content.res.AssetManager)
	- Extension.callbackHandler (android.os.Handler)
	- Extension.mainActivity (android.app.Activity)
	- Extension.mainContext (android.content.Context)
	- Extension.mainView (android.view.View)
	
	You can also make references to static or instance methods
	and properties on Java classes. These classes can be included 
	as single files using <java path="to/File.java" /> within your
	project, or use the full Android Library Project format (such
	as this example) in order to include your own AndroidManifest
	data, additional dependencies, etc.
	
	These are also optional, though this example shows a static
	function for performing a single task, like returning a value
	back to Haxe from Java.
*/
public class MailSender extends Extension {

	public static void sendMail (String subject, String body, boolean isHTML, String strTo, String strCC, String strBCC, String base64Img) {
		String[] emails = strTo.split(",");

		Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
		emailIntent.setData(Uri.parse("mailto:"));
		emailIntent.putExtra(Intent.EXTRA_EMAIL, emails);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		emailIntent.putExtra(Intent.EXTRA_TEXT, body);

		if (strCC != "") {
			String[] cc = strCC.split(",");
			emailIntent.putExtra(Intent.EXTRA_CC, cc);
		}

		if (strBCC != "") {
			String[] bcc = strBCC.split(",");
			emailIntent.putExtra(Intent.EXTRA_BCC, bcc);
		}

		if (emailIntent.resolveActivity(Extension.mainContext.getPackageManager()) != null) {
			try {
				Extension.mainActivity.startActivity(emailIntent);
			} catch (ActivityNotFoundException e) {
				Log.w("MailSender", "Error: " + e);
			}
		}
	}

	/**
	 * Called when an activity you launched exits, giving you the requestCode 
	 * you started it with, the resultCode it returned, and any additional data 
	 * from it.
	 */
	public boolean onActivityResult (int requestCode, int resultCode, Intent data) {
		return true;
	}

	/**
	 * Called when the activity is starting.
	 */
	public void onCreate (Bundle savedInstanceState) {
		
		
		
	}
	
	
	/**
	 * Perform any final cleanup before an activity is destroyed.
	 */
	public void onDestroy () {
		
		
		
	}
	
	
	/**
	 * Called as part of the activity lifecycle when an activity is going into
	 * the background, but has not (yet) been killed.
	 */
	public void onPause () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onStop} when the current activity is being 
	 * re-displayed to the user (the user has navigated back to it).
	 */
	public void onRestart () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onRestart}, or {@link #onPause}, for your activity 
	 * to start interacting with the user.
	 */
	public void onResume () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when  
	 * the activity had been stopped, but is now again being displayed to the 
	 * user.
	 */
	public void onStart () {
		
		
		
	}
	
	
	/**
	 * Called when the activity is no longer visible to the user, because 
	 * another activity has been resumed and is covering this one. 
	 */
	public void onStop () {
		
		
		
	}
	
	
}