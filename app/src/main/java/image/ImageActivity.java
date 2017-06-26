package image;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import medicine.myapplication.R;

/**
 * Created by Administrator on 2017/6/8.
 */

public class ImageActivity extends Activity {
    @ViewInject(R.id.id_gallery)
    LinearLayout id_gallery;
    @ViewInject(R.id.id_content)
    ImageView img;
    @ViewInject(R.id.id_horizontalScrollView)
    MyHorizontalScrollView myHorizontalScrollView;

    LayoutInflater inflater;

    HorizontalScrollViewAdapter adapter;
    GalleryAdapter imgadapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_pager);
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra("android.intent.extras.CAMERA_FACING", 1); // 调用前置摄像头 startActivityForResult(intent, 1);
        startActivity(intent);
        x.view().inject(this);
      /*  Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);*/
        inflater=LayoutInflater.from(this);
        final List<Integer> mDatas=new ArrayList<Integer>(Arrays.asList(R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
                R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
                R.drawable.image,R.drawable.image,R.drawable.image));
        adapter=new HorizontalScrollViewAdapter(ImageActivity.this,mDatas);
        imgadapter=new GalleryAdapter(ImageActivity.this,mDatas);


        myHorizontalScrollView.setCurrentImageChangeListener(new MyHorizontalScrollView.CurrentImageChangeListener() {

            @Override
            public void onCurrentImgChanged(int position, View viewIndicator) {
                img.setImageResource(mDatas.get(position));
                viewIndicator.setBackgroundColor(Color.parseColor("#AA024DA4"));
            }
        });

        myHorizontalScrollView.setOnItemClickListener(new MyHorizontalScrollView.OnItemClickListener() {


            @Override
            public void onClick(View view, int pos) {
                img.setImageResource(mDatas.get(pos));
                view.setBackgroundColor(Color.parseColor("#AA024DA4"));
            }
        });

        myHorizontalScrollView.initDatas(adapter);


    }
}
