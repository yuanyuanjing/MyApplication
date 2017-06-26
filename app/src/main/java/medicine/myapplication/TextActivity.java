/*
package medicine.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.xutils.DbManager;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

*/
/**
 * Created by Administrator on 2017/6/3.
 *//*


public class TextActivity extends Activity {
    @ViewInject(R.id.textview)
    private TextView textView;
    @ViewInject(R.id.listview)
    private ListView listView;
    List<String> list;
    ProgressDialog progressDialog;
    protected DbManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        onCall();
        initdata();
        try {
            adddata();

        } catch (DbException e) {
            e.printStackTrace();
            Log.d("YUAN","数据库添加异常");

        }

        try {
            dbFind();
        } catch (DbException e) {
            e.printStackTrace();
            Log.d("YUAN","数据库查询异常");
        }
        */
/*list=new ArrayList<>();
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("版本更新");
        progressDialog.setMessage("正在更新...");
        progressDialog.setCancelable(true);


        list.add("http://imgsrc.baidu.com/imgad/pic/item/caef76094b36acaf0accebde76d98d1001e99ce7.jpg");
        list.add("http://img002.21cnimg.com/photos/album/20150702/m600/2D79154370E073A2BA3CD4D07868861D.jpeg");
        list.add("http://dl.bizhi.sogou.com/images/2012/03/14/124196.jpg");
        list.add("http://pic55.nipic.com/file/20141208/19462408_171130083000_2.jpg");
        list.add("http://img.zcool.cn/community/01bf1655e514b16ac7251df840273f.jpg");
        list.add("http://pic78.huitu.com/res/20160604/1029007_20160604114552332126_1.jpg");
        list.add("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg");
        list.add("http://pic.58pic.com/58pic/17/41/38/88658PICNuP_1024.jpg");
        list.add("http://pic41.nipic.com/20140518/18521768_133448822000_2.jpg");
        list.add("http://pic28.nipic.com/20130424/11588775_115415688157_2.jpg");
        list.add("http://pic.58pic.com/58pic/13/85/85/73T58PIC9aj_1024.jpg");
        list.add("http://img03.tooopen.com/images/20131111/sy_46708898917.jpg");
        list.add("http://img05.tooopen.com/images/20150531/tooopen_sy_127457023651.jpg");
        list.add("http://pic32.nipic.com/20130827/12906030_123121414000_2.png");
        list.add("http://pic.58pic.com/58pic/12/03/18/68w58PICjJP.jpg");
        DoctorAdapter doctorAdapter=new DoctorAdapter(this,list);
        listView.setAdapter(doctorAdapter);

        textView.setText("成功");

        String url="http://xiaoyujiankan.oss-cn-shanghai.aliyuncs.com/administrator/2017-06-01-11-57-25/Yaodian-debug.apk";
        RequestParams params=new RequestParams(url);
        //自定义保存路径
        params.setSaveFilePath(Environment.getExternalStorageDirectory() + "/usm.apk");
        params.setAutoRename(true);
        x.http().get(params, new Callback.ProgressCallback<File>() {
            @Override
            public void onSuccess(File result) {
                //apk下载完成后，调用系统的安装方法
               Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.fromFile(result), "application/vnd.android.package-archive");
                startActivity(intent);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                Log.d("YUAN","失败");
            }

            @Override
            public void onWaiting() {
                progressDialog.show();
            }

            @Override
            public void onStarted() {
                Log.d("YUAN","开始");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                progressDialog.setMax((int) total);
                progressDialog.setProgress((int) current);
                Log.d("YUAN",total+"/"+current);




            }
        });*//*









    }

    private void adddata() throws DbException {

        */
/*List<User> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            User user=new User("李峰",System.currentTimeMillis()+i,"1649@qq.com","123456");
            list.add(user);
        }
        db.saveBindingId(list);*//*

        db.save(new User("李峰",System.currentTimeMillis(),"1649@qq.com","123456"));
    }

    private void dbFind() throws DbException {

        List<User> user=db.selector(User.class)
                .where("name","like","%kevin%")
                .and("email","=","1649@qq.com")
                .orderBy("regTime",true)
                .limit(2)//只查询2条记录
                .offset(2)//偏移两个,从第三个记录开始返回,limit配合offset达到sqlite的limit m,n的查询
                .findAll();
        if(list == null || list.size() == 0){
            return;//请先调用dbAdd()方法
        }
        Log.d("YUAN","大小"+user.size());

    }

    private void initdata() {



        DbManager.DaoConfig daoConfig=new DbManager.DaoConfig()
                .setDbName("our.db")
                .setDbVersion(2)
                .setAllowTransaction(true)
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                    }
                })
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {

                    }


                })
                .setTableCreateListener(new DbManager.TableCreateListener() {
                    @Override
                    public void onTableCreated(DbManager db, TableEntity<?> table) {

                    }
                });

        db=x.getDb(daoConfig);
    }

    @Event(value = R.id.textview,type = View.OnClickListener.class)
    private void setTextView(View view){
        textView.setText("失败");
    }

    public void onCall() {

        if (Build.VERSION.SDK_INT >= 23) {
            int WRITEPhonePermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE);
            if (WRITEPhonePermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
                //ActivityCompat.requestPermissions(Function_Activity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
                return;
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[]
            grantResults) {


        if (requestCode == 123) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {


            } else {


            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }



    }
}*/
