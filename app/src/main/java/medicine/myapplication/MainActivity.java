import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import medicine.myapplication.R;

public class MainActivity extends Activity {

@ViewInject(R.id.textview)
private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        textView.setText("成功");








    }


}
