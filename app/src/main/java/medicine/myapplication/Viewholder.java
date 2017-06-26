package medicine.myapplication;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Viewholder {
    String name;
    public TextView textView;
    public TextView gender_text;
    public TextView time_text;
    public TextView title;
    public ImageView imageView;

    /*
    游戏信息
    */
    public TextView game_name;
    public TextView game_type;

    /*
     WIFI信息
     */
    public TextView wifi_text;
    public TextView wifistate_text;
    public ImageView wifi_img;

    /*
    家庭成员
    */
    public CheckBox family_checkbox;
    public TextView realname_text;
    public TextView role_text;

    /*
    医生信息
    */
    public ImageView doctor_img;
    public TextView doctor_name;
    public TextView doctor_hospital;
    public TextView doctor_goodl;
    public TextView doctor_department;

}
