# Cordova/PhoneGap UserAgent Plugin #
Plugin for Cordova 3.0+ that allows you to change your User-Agent for HTTP requests.

# Check your user agent
https://www.whoishostingthis.com/tools/user-agent/

# Change User-agent with caution!
Starting from Build.VERSION_CODES.KITKAT Android version, changing the user-agent while loading a web page causes WebView to initiate loading once again.
https://developer.android.com/reference/android/webkit/WebSettings#setUserAgentString(java.lang.String)

# Related question from stackoverflow
https://stackoverflow.com/questions/62434410/set-user-agent-in-webview-for-android-api-30/62535531

# Actual info
According to https://www.infoq.com/news/2020/03/chrome-phasing-user-agent/, Chrome will replace User-Agent with a new API called Client Hints.

---------------------------------------------------------------------------------------------------------------------------

## Adding the plugin to your project ##
To install the plugin, use the Cordova CLI and enter the following:<br />
`cordova plugin add https://github.com/LouisT/cordova-useragent`

## Platforms ##
- Android
- iOS (9+, with [WKWebView plugin](https://github.com/apache/cordova-plugin-wkwebview-engine))

## Use ##
To set your User-Agent:<br />
`UserAgent.set(useragent)`

To get your current User-Agent:<br />
`UserAgent.get(function(ua) { })`

To set your User-Agent back to the default:<br />
`UserAgent.reset()`
