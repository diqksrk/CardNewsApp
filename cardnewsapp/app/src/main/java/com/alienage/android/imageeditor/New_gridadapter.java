package com.alienage.android.imageeditor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//데이터와 라이니어 레이어 합쳐서 화면에 뿌려주는 메소드.
public class New_gridadapter extends BaseAdapter {
    Context context;
    ArrayList<News_Data> data = new ArrayList<>();
    public onShareClickListener listener;

    New_gridadapter(Context context, ArrayList<News_Data> data){
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.new_gridview,null);
        }
        ImageView iv1 = (ImageView)convertView.findViewById(R.id.news_image);
        TextView tv1 = (TextView)convertView.findViewById(R.id.news_title);
        Button btn1 = (Button)convertView.findViewById(R.id.button2);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("http://www.facebook.com/sharer/sharer.php?u=" + data.get(position).getNews_html()));
//            }
//        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onShare(position);
            }
        });

        iv1.setImageResource(data.get(position).getNews_img());
        tv1.setText(data.get(position).getNews_title());

        return convertView;
    }

    public void setOnShareClickListener(onShareClickListener listener){
        this.listener =listener;
    }
//
//    @Override
//    public void onClick(View v) {
//        if(this.listener != null){
//            listener.onShare(position);
//            notifyDataSetChanged();
//        }
//    }

    interface onShareClickListener{
        void onShare(int position);
    }
}
