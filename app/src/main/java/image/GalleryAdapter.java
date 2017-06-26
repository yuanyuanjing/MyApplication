package image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import medicine.myapplication.R;

/**
 * Created by Administrator on 2017/6/10.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<Integer> list;
    View view;
    int size=0;
    GalleryOnItemClickLitener itemClickListener;


    public GalleryAdapter(Context context,List<Integer> list){
        inflater=LayoutInflater.from(context);
        this.list=list;
    }

    public void setOnItemClickLitener(GalleryOnItemClickLitener onItemClickLitener){
        this.itemClickListener=onItemClickLitener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view=inflater.inflate(R.layout.activity_index_gallery_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.img= (ImageView) view.findViewById(R.id.id_index_gallery_item_image);
        viewHolder.tex= (TextView) view.findViewById(R.id.id_index_gallery_item_text);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.img.setImageResource(list.get(position));
        if (itemClickListener!=null){
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClickLitener(holder.img,position);
                }
            });
        }
        Log.d("YUAN",position+":"+list.get(position));
    }



    @Override
    public int getItemCount() {
        if (list!=null){
            size=list.size();
        }
        return size;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView img;
        TextView  tex;
    }

    public interface GalleryOnItemClickLitener{
        void onItemClickLitener(View view,int position);
    }


}
