package medicine.myapplication;

import android.app.Application;

import org.xutils.x;


/**
 * Created by Administrator on 2017/6/3.
 */

public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
