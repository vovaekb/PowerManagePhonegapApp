package org.privalov.Obedoed;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;
import android.view.WindowManager.LayoutParams;

public class WakeLockPlugin extends Plugin {
	@Override
	public PluginResult execute(String action, JSONArray args, String callbackId) {
		PowerManager powerManager = ( PowerManager )cordova.getActivity().getSystemService( Context.POWER_SERVICE );
		final PowerManager.WakeLock wakeLock = powerManager.newWakeLock( 
			PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "SleepManager" );
		if( action.equals( "PowerSave_off" ) ){
			String result = "PowerSave off success";
        	Log.v("SleepManager", "PowerSave_off success");
        	Runnable newThread = new Runnable() {
				public void run() {
					cordova.getActivity().getWindow().addFlags(LayoutParams.FLAG_KEEP_SCREEN_ON);					
				}
			};
			
			return new PluginResult( PluginResult.Status.OK, result );
		}
		else if( action.equals( "PowerSave_on" ) ) {
			Runnable newThread = new Runnable() {
				public void run() {
					cordova.getActivity().getWindow().clearFlags(LayoutParams.FLAG_KEEP_SCREEN_ON);					
				}
			};
			String result = "PowerSave on success";
			return new PluginResult( PluginResult.Status.OK, result );
		} else {
			return new PluginResult( PluginResult.Status.INVALID_ACTION );
		}
		
		
	}

}
