package org.privalov.Obedoed;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

import com.samples.powermanagephonegapapp.ApplicationContext;

public class WakeLockPlugin extends Plugin {
	@Override
	public PluginResult execute(String action, JSONArray args, String callbackId) {
		Log.v("Start"	, "Pugin");
		PowerManager powerManager = (PowerManager)cordova.getActivity().getSystemService(Context.POWER_SERVICE);
		final PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "WakeLockPlugin");
		Log.v("WakeLock created"	, "Plugin");
		//Turning off power management
		if(action.equals("turn_off")){
			Log.v("Start turn_off"	, "Plugin");
			wakeLock.acquire();
			String result = "Turn off complete";
			Log.v(result, "Plugin");
			return new PluginResult(PluginResult.Status.OK, result);
		} //Turning on power management
		else if(action.equals("turn_on")){
			Log.v("Start turn_on"	, "Plugin");
			
			Runnable mReleaser = new Runnable() {
	            public void run() {
	            	wakeLock.release();
	            }
	        };
	        
	        String result = "Turn on complete";
			Log.v(result, "Plugin");
			return new PluginResult(PluginResult.Status.OK, result);
			
		} else{
			return new PluginResult(PluginResult.Status.INVALID_ACTION);
		}
		
		
	}

}
