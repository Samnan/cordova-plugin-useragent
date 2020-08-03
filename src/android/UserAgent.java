package im.ltdev.cordova;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class UserAgent extends CordovaPlugin {

        public WebSettings settings;

        @Override
        public void initialize(CordovaInterface cordova, CordovaWebView webView) {

            super.initialize(cordova, webView);

            try{
                // another solution here https://github.com/miloproductionsinc/cordova-plugin-useragent/blob/master/src/android/UserAgent.java
                // CordovaWebViewEngine e = webView.getEngine(); // returns null
                View v = webView.getView();
                settings = ((WebView)v).getSettings();

            }catch (Exception error){

                settings = null;

            }
        }

        @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
               try {
                  if (action.equals("set")) {
                     String text = args.getString(0);
                     settings.setUserAgentString(text);
                     callbackContext.success(settings.getUserAgentString());
                     return true;
                   } else if (action.equals("get")) {
                     callbackContext.success(settings.getUserAgentString());
                     return true;
                   } else if (action.equals("reset")) {
                     settings.setUserAgentString(null);
                     callbackContext.success(settings.getUserAgentString());
                     return true;
                  }
                  callbackContext.error("Invalid action");
                  return false;
                } catch (Exception e) {
                  callbackContext.error(e.getMessage());
                  return false;
               }
	}

}
