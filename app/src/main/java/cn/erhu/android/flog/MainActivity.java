package cn.erhu.android.flog;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FLog.logDebug(TAG, "onCreate(), viewId = %d", R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FLog.logDebug(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        FLog.logDebug(TAG, "onStop(), @ %s", "FLog");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        FLog.logDebug(TAG, "onDestroy()");
        super.onDestroy();
    }
}
