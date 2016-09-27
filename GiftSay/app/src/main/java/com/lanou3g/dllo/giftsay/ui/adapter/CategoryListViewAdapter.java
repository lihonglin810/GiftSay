package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CategoryLvBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/20.
 * 分类攻略界面ListView的适配器
 */
public class CategoryListViewAdapter extends BaseAdapter{

    private List<CategoryLvBean.DataBean.ChannelGroupsBean> datas;
    private Context context;

    public CategoryListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CategoryLvBean.DataBean.ChannelGroupsBean> datas) {
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
        CategoryListViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_category_strategy_lv,parent,false);
            holder = new CategoryListViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (CategoryListViewHolder) convertView.getTag();
        }
        CategoryLvBean.DataBean.ChannelGroupsBean bean = datas.get(position);
        if (bean != null){
            holder.titleTv.setText(bean.getName());
            Picasso.with(context).load(bean.getChannels().get(0).getCover_image_url()).into(holder.img1);
            Picasso.with(context).load(bean.getChannels().get(1).getCover_image_url()).into(holder.img2);
            Picasso.with(context).load(bean.getChannels().get(2).getCover_image_url()).into(holder.img3);
            Picasso.with(context).load(bean.getChannels().get(3).getCover_image_url()).into(holder.img4);
            Picasso.with(context).load(bean.getChannels().get(4).getCover_image_url()).into(holder.img5);
            Picasso.with(context).load(bean.getChannels().get(5).getCover_image_url()).into(holder.img6);
        }
        return convertView;
    }

    class CategoryListViewHolder{
        ImageView img1,img2,img3;
        ImageView img4,img5,img6;
        TextView titleTv;
        LinearLayout showLayout;
        public CategoryListViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.category_strategy_title_tv);
            img1 = (ImageView) view.findViewById(R.id.item_category_lv_img1);
            img2 = (ImageView) view.findViewById(R.id.item_category_lv_img2);
            img3 = (ImageView) view.findViewById(R.id.item_category_lv_img3);
            img4 = (ImageView) view.findViewById(R.id.item_category_lv_img4);
            img5 = (ImageView) view.findViewById(R.id.item_category_lv_img5);
            img6 = (ImageView) view.findViewById(R.id.item_category_lv_img6);
            showLayout = (LinearLayout) view.findViewById(R.id.item_strategy_show_layout);
        }
    }
}
