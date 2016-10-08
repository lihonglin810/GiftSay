package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CategoryLvBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/30.
 * 攻略ListView的GridView适配器
 */
public class StrategyLvGvAdapter extends BaseAdapter{
    private List<CategoryLvBean.DataBean.ChannelGroupsBean.ChannelsBean> datas;
    private Context context;

    public StrategyLvGvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CategoryLvBean.DataBean.ChannelGroupsBean.ChannelsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : 6;
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
        StrategyLvGvViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_stragety_lv_gv,parent,false);
            holder = new StrategyLvGvViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (StrategyLvGvViewHolder) convertView.getTag();
        }
        CategoryLvBean.DataBean.ChannelGroupsBean.ChannelsBean bean = datas.get(position);
        Picasso.with(context).load(bean.getCover_image_url()).into(holder.imageView);
        return convertView;
    }
    class StrategyLvGvViewHolder{
        ImageView imageView;
        public StrategyLvGvViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.item_strategy_lv_gv_img);
        }
    }
}
