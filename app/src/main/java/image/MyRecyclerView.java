package image;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/6/12.
 */

public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    private View view;//记录第一个view
    private OnItemScrollChangeListener mItemScrollChangeListener;
    public interface OnItemScrollChangeListener{
        void onChange(View view,int position);
    }
    public void setOnItemScrollChangeListener(
            OnItemScrollChangeListener mItemScrollChangeListener)
    {
        this.mItemScrollChangeListener = mItemScrollChangeListener;
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        view=getChildAt(0);
        if (mItemScrollChangeListener!=null){
            mItemScrollChangeListener.onChange(view,getChildPosition(view));
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        View newview=getChildAt(0);
        if (mItemScrollChangeListener!=null){
            if (newview!=null&& newview!=view){
                view=newview;
                mItemScrollChangeListener.onChange(view,getChildAdapterPosition(view));
            }
        }

    }
}
