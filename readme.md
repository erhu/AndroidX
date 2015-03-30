# FLog
A simple and more useful Android Log.

### Usage
#### FLog usage :
```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FLog.logDebug(TAG, "onCreate(), viewId = %d", R.layout.activity_main);
    }
```
#### output:
ThreadName + fileName + method + lineNumber + LogContent
```
#                   thread   file          method    line       content
D/Main(3202): ❖❖❖  main     MainActivity.onCreate():14  ❖❖❖  onCreate(), viewId = 2130903040

```
