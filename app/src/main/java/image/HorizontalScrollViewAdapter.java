package image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import medicine.myapplication.R;

/**
 * Created by Administrator on 2017/6/9.
 */

public class HorizontalScrollViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mlayoutInflater;
    private List<Integer> mdatas;

    public HorizontalScrollViewAdapter(Context context, List<Integer> mDatas){
        this.context=context;
        mlayoutInflater= LayoutInflater.from(context);
        this.mdatas=mDatas;
    }
    @Override
    public int getCount() {
        if (mdatas!=null){
            return mdatas.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mdatas!=null){
            return mdatas.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder Holder;
        if (convertView==null){
            Holder=new ViewHolder();
            convertView=mlayoutInflater.inflate(R.layout.activity_index_gallery_item,parent,false);
            Holder.mImg= (ImageView) convertView.findViewById(R.id.id_index_gallery_item_image);
            Holder.mText= (TextView) convertView.findViewById(R.id.id_index_gallery_item_text);
            convertView.setTag(Holder);
        }else {
            Holder= (ViewHolder) convertView.getTag();

        }
        Holder.mImg.setImageResource(mdatas.get(position));
        Holder.mText.setText("测试数据");


        return convertView;
    }

    private class ViewHolder
    {
        ImageView mImg;
        TextView mText;
    }
}
