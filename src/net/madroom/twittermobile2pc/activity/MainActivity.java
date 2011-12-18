package net.madroom.twittermobile2pc.activity;

import net.madroom.twittermobile2pc.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Uri uri = getIntent().getData();
        if(uri!=null) {
            String uriString = uri.toString();
            if(URLUtil.isHttpsUrl(uriString)) {
                uriString = uriString.replace("https://m.twitter", "https://twitter");
                uriString = uriString.replace("https://mobile.twitter", "https://twitter");
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uriString)));
            } else if(URLUtil.isHttpUrl(uriString)) {
                uriString = uriString.replace("http://m.twitter", "http://twitter");
                uriString = uriString.replace("http://mobile.twitter", "http://twitter");
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uriString)));
            }
            System.exit(RESULT_OK);
        }
    }

}
