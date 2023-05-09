# PowerManagePhonegapApp

Powerful PhoneGap plugin for control power management system from Android application.
Plugin implements two power management actions:
1. Power save off - turning off power management (sets the mode to "keep the screen turned on").
2. Power save on - turning on power management (remove mode "keep the screen turned on").

Using instructions:
1. Copy and paste package org.privalov.Obedoed from that project to folder src in your project.
2. Add file plugins.xml to folder res/xml in your Android project;
3. Add following line to file plugins.xml:

```xml
  <plugin name="WakeLock" value="org.privalov.Obedoed.WakeLockPlugin"/>
```

4. Add following line to AndroidManifest.xml:

```xml
  <uses-permission android:name="android.permission.WAKE_LOCK" />  
```
  
5. Paste PhoneGap library to folder assets/www/ and add link to this file in your file index.html:

```html
  <script type="text/javascript" charset="utf-8" src="cordova-2.0.0.min.js"></script>
```

6. Add code to turn off power management in your javascript file:

```javascript
  cordova.exec( function(data){ //Your success callback }, function( e ){ //Your error callback }, 'WakeLock', 'PowerSave_off', []);
```

7. Add code to turn on power management in your javascript file:

```javascript
  cordova.exec( function(data){ //Your success callback }, function( e ){ //Your error callback }, 'WakeLock', 'PowerSave_on', []);
```
