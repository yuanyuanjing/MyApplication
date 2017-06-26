package medicine.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */

public class DoctorAdapter extends BaseAdapter {
    List<String> list;
    Context context;
    Viewholder holder;
    Bitmap pngBM;
    int pos;
    URL url;



    public DoctorAdapter(Context context, List<String> list){
        this.context=context;
        this.list=list;


    }
    @Override
    public int getCount() {
        if(!list.isEmpty()){
            list.size();
        }
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        if(!list.isEmpty()){
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            Log.d("YUAN","加载医生列表");
            holder=new Viewholder();
            convertView= LayoutInflater.from(context).inflate(R.layout.private_doctor_item,null);

            holder.doctor_img= (ImageView) convertView.findViewById(R.id.doctor_img);

            convertView.setTag(holder);

        }
        else {

            holder= (Viewholder) convertView.getTag();
        }


       //holder.doctor_img.setImageURI(Uri.parse(list.get(position)));
        Log.d("YUAN",list.get(position));
        pos=position;
        ImageOptions imageOptions= new ImageOptions.Builder()
                .setSize(DensityUtil.dip2px(100),DensityUtil.dip2px(100))//设置图片大小
                .setRadius(DensityUtil.dip2px(5))//圆角半径
                .setCrop(true)//是否对图片进行裁剪,如果ImageView的大小不是定义为wrap_content, 不要crop
                .setFadeIn(true)//设置淡入效果
                .setLoadingDrawableId(R.mipmap.ic_launcher)//设置加载过程中显示的图片
                .setFailureDrawableId(R.mipmap.ic_launcher)//设置加载失败显示的图片
                .setUseMemCache(true)//设置使用缓存
                .setCircular(true)//设置图片显示为圆形
                .setIgnoreGif(true)//设置支持gif
                .build();
        x.image().bind(holder.doctor_img, list.get(pos),imageOptions);



       /* new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url=new URL(list.get(pos));
                    pngBM = BitmapFactory.decodeStream(url.openStream());

                    Message message=new Message();
                    message.what=1;
                    handler.sendMessage(message);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/





        return convertView;
    }
    Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){


                /*if (holder.doctor_img.getTag() != null && holder.doctor_img.getTag().equals(url)) {
                    holder.doctor_img.setImageBitmap(pngBM);
                }*/
                holder.doctor_img.setImageBitmap(pngBM);

            }

        }
    };

    public static Bitmap getHttpBitmap(String url){


        URL myFileURL;
        Bitmap bitmap=null;


        try{
            myFileURL = new URL(url);
            //获得连接
            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();
            //设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
            conn.setConnectTimeout(6000);
            //连接设置获得数据流
            conn.setDoInput(true);
            //不使用缓存
            conn.setUseCaches(false);
            //这句可有可无，没有影响
            //conn.connect();
            //得到数据流
            InputStream is = conn.getInputStream();
            //解析得到图片
            bitmap = BitmapFactory.decodeStream(is);
            //关闭数据流
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }



        return bitmap;

    }
}
