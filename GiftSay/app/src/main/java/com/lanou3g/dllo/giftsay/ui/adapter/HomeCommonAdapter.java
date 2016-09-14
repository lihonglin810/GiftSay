package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.HomeCommonBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 主页所有页适配器
 */
public class HomeCommonAdapter extends BaseAdapter{

    private List<HomeCommonBean.DataBean.ItemsBean> datas;
    private Context context;

    public HomeCommonAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomeCommonBean.DataBean.ItemsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeCommonViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_common,parent,false);
            holder = new HomeCommonViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (HomeCommonViewHolder) convertView.getTag();
        }
        HomeCommonBean.DataBean.ItemsBean bean = datas.get(position);
        if (bean != null){
            holder.categoryTv.setText(bean.getColumn().getCategory());
            holder.toptitleTv.setText(bean.getColumn().getTitle());
            holder.nicknameTv.setText(bean.getAuthor().getNickname());
            holder.bottomtitleTv.setText(bean.getTitle());
            String count = String.valueOf(bean.getLikes_count());
            holder.likescountTv.setText(count);
            Picasso.with(context).load(bean.getAuthor().getAvatar_url()).into(holder.avatarImg);
            Picasso.with(context).load(bean.getCover_image_url()).into(holder.coverImg);
        }
        return convertView;
    }

    private class HomeCommonViewHolder{
        TextView categoryTv,toptitleTv,bottomtitleTv,nicknameTv,likescountTv;
        ImageView avatarImg,coverImg;
        public HomeCommonViewHolder(View view){
            categoryTv = (TextView) view.findViewById(R.id.item_category);
            toptitleTv = (TextView) view.findViewById(R.id.item_top_title);
            bottomtitleTv = (TextView) view.findViewById(R.id.item_bottom_title);
            nicknameTv = (TextView) view.findViewById(R.id.item_nickname);
            likescountTv = (TextView) view.findViewById(R.id.item_likes_count);
            avatarImg = (ImageView) view.findViewById(R.id.item_avatar_img);
            coverImg = (ImageView) view.findViewById(R.id.item_cover_img);
        }
    }
}
