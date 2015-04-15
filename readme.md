# FLog
A simple and more useful Android Log.

### Usage
#### logXXX()
```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FLog.logDebug(TAG, "onCreate(), viewId = %d", R.layout.activity_main);
    }

// output -------------------------------------------------
// ThreadName + fileName + method + lineNumber + LogContent
D/Main(3202): ❖❖❖  main     MainActivity.onCreate():14  ❖❖❖  onCreate(), viewId = 2130903040
```
#### printViewStructure():
```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutParams p = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        View v = new CanvasLayerView(this);
        v.setLayoutParams(p);
        setContentView(v);

        FLog.pvs(v);
/*      FLog.pvs(v, true, true);
        FLog.pvs(v, false, true);
        FLog.pvs(v, false, false);
*/

// output --------------------------------------------------------------------------
D/v_structure( 7068): ❖❖❖ main FLog.pvs():211   ❖❖❖  DecorView
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖  └────(1, 0, ActionBarOverlayLayout)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           ├────(2, 0, FrameLayout)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           │       └────(3, 0, CanvasLayerView)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           ├────(2, 1, ActionBarContainer)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           │       ├────(3, 0, ActionBarView)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           │       │       └────(4, 0, LinearLayout)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           │       │                ├────(5, 0, HomeView)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           │       │                │       ├────(6, 0, ImageView)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           │       │                │       └────(6, 1, ImageView)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           │       │                └────(5, 1, LinearLayout)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           │       │                         ├────(6, 0, TextView)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           │       │                         └────(6, 1, TextView)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           │       └────(3, 1, ActionBarContextView)
D/v_structure( 7068): ❖❖❖ main FLog.doPvs():262 ❖❖❖           └────(2, 2, ActionBarContainer)

```
