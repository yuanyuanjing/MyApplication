package image;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import medicine.myapplication.R;

import static android.os.Build.VERSION_CODES.N;

/**
 * Created by Administrator on 2017/6/10.
 */

public class GalleryActivity extends Activity {
   //@ViewInject(R.id.RecyclerView)
    MyRecyclerView recyclerView;
    @ViewInject(R.id.gally_img)
    ImageView gally_img;

    ImageView sss;

    GalleryAdapter imgadapter;
    LinearLayoutManager linearLayoutManager;
    int  firstItemPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        x.view().inject(this);
        int a=8;


        recyclerView= (MyRecyclerView) findViewById(R.id.RecyclerView);
        Log.d("YUAN","GIT修改测试");

        final List<Integer> mDatas=new ArrayList<Integer>(Arrays.asList(R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.l,
                R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
                R.drawable.h,R.drawable.i,R.drawable.f));
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //linearLayoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(linearLayoutManager);


        imgadapter=new GalleryAdapter(this,mDatas);
        //firstItemPosition = linearLayoutManager.findLastVisibleItemPosition();

        //imgadapter.notifyItemChanged();
        recyclerView.setAdapter(imgadapter);
        int start = linearLayoutManager.findFirstVisibleItemPosition();
        int end = linearLayoutManager.findLastVisibleItemPosition();
        Log.d("YUAN","开始:"+start+"结束:"+end);
        recyclerView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                gally_img.setImageResource(mDatas.get(position));
            }
        });


        imgadapter.setOnItemClickLitener(new GalleryAdapter.GalleryOnItemClickLitener() {
            @Override
            public void onItemClickLitener(View view, int position) {
                Toast.makeText(GalleryActivity.this, position+"", Toast.LENGTH_SHORT)
                        .show();

                 /*for (int i=0;i<position;i++){

                    recyclerView.getChildAt(i).setBackgroundColor(Color.WHITE);
                }

                recyclerView.getChildAt(position).setBackgroundColor(Color.RED);*/
                gally_img.setImageResource(mDatas.get(position));


                /*if (position<=firstItemPosition){
                    recyclerView.getChildAt(position).setBackgroundColor(Color.RED);
                }else {
                    recyclerView.getChildAt(position-firstItemPosition).setBackgroundColor(Color.RED);
                }*/



            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getRawX();
        int y= (int) event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                int mLastX= (int) event.getRawX();
                int mLastY= (int) event.getRawY();
                int deltaX=x-mLastX;
                int deltaY=y-mLastY;

                int translationX= N;
            }

        }

        return true;
    }
}
