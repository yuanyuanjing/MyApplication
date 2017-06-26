package medicine.myapplication;

import android.util.Log;

import org.xutils.DbManager;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */

public class UserDB {

    public static String DB_NAME="User.db";
    public static int VERSION=1;
    private static UserDB userDB;
    private static DbManager db;
    private UserDB(){
        DatabaseOpenHelper databaseOpenHelper=new DatabaseOpenHelper(DB_NAME,VERSION);
        db=x.getDb(databaseOpenHelper.getDaoConfig());
    }
    public synchronized static UserDB  getIntance(){
        if (userDB==null){
            userDB=new UserDB();
        }
        return userDB;
    }

    public void saveUser(User user){
        try {
            db.save(user);
        } catch (DbException e) {
            e.printStackTrace();
            Log.d("YUAN","添加数据异常"+e.toString());
        }
    }

    public List<User> findUser(){
        List<User> list=null;
        try {
            list=db.selector(User.class).findAll();
        } catch (DbException e) {
            e.printStackTrace();
            Log.d("YUAN","查询数据异常"+e.toString());
        }
        return list;
    }
    public void delDB(WhereBuilder whereBuilder){


        try {
            db.delete(User.class,whereBuilder);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }



}
