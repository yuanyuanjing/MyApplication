package medicine.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */



public class Dbtest extends Activity {
    @ViewInject(R.id.listview)
    private ListView listView;
    @ViewInject(R.id.textview)
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        org.xutils.x.view().inject(this);

        UserDB userDB=UserDB.getIntance();
        User user1=new User("lifeng",27);
        User user2=new User("yuanjing",24);
        userDB.saveUser(user1);
        userDB.saveUser(user2);

        WhereBuilder whereBuilder=WhereBuilder.b("name","=","yuanjing");
        userDB.delDB(whereBuilder);
        List<User> list=userDB.findUser();
        if (list!=null){
            for (User user:list){
                Log.d("YUAN",user.toString());
            }
        }

    }

}
