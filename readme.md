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

        FLog.printViewStructure((ViewGroup) v.getParent());
/*      
        // print structure from root and show fullName of class
        FLog.printViewStructure((ViewGroup) v.getParent(), true, true);

        // do not print structure from root and do not show fullName of class
        FLog.printViewStructure((ViewGroup) v.getParent(), false, false);
*/

// output --------------------------------------------------------------------------
D/v_structure(15234): ❖❖❖ main FLog.pvs():207   ❖❖❖ DecorView
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖ ┗━━━━[0]: ActionBarOverlayLayout
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┣━━━━[0]: FrameLayout
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┃        ┗━━━━[0]: CanvasLayerView
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┣━━━━[1]: ActionBarContainer
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┃        ┣━━━━[0]: ActionBarView
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┃        ┃        ┗━━━━[0]: LinearLayout
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┃        ┃                 ┣━━━━[0]: HomeView
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┃        ┃                 ┃        ┣━━━━[0]: ImageView
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┃        ┃                 ┃        ┗━━━━[1]: ImageView
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┃        ┃                 ┗━━━━[1]: LinearLayout
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┃        ┃                          ┣━━━━[0]: TextView
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┃        ┃                          ┗━━━━[1]: TextView
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┃        ┗━━━━[1]: ActionBarContextView
D/v_structure(15234): ❖❖❖ main FLog._pvs():258  ❖❖❖          ┗━━━━[2]: ActionBarContainer

    }
```
