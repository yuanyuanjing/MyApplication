package medicine.myapplication;

import org.xutils.DbManager;

/**
 * Created by Administrator on 2017/6/7.
 */

public class DatabaseOpenHelper {
    private DbManager.DaoConfig daoConfig;
    public DatabaseOpenHelper(String name,int version){
        daoConfig=new DbManager.DaoConfig()
                .setDbName(name)
                .setDbVersion(version)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        db.getDatabase().enableWriteAheadLogging();//开启WAL更快
                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        //数据库升级操作
                    }
                });

    }

    public DbManager.DaoConfig getDaoConfig(){
        return daoConfig;
    }

}
