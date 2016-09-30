package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CategoryLvBean;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.ui.activity.StrategyLvDetailsActivity;
import com.lanou3g.dllo.giftsay.ui.activity.StrategyLvLookAllActivity;
import com.lanou3g.dllo.giftsay.view.MyGridView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 16/9/20.
 * 分类攻略界面ListView的适配器
 */
public class CategoryListViewAdapter extends BaseAdapter{

    private List<CategoryLvBean.DataBean.ChannelGroupsBean> datas;
    private Context context;
    private StrategyLvGvAdapter strategyLvGvAdapter;

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
        final CategoryLvBean.DataBean.ChannelGroupsBean bean = datas.get(position);
        if (bean != null){
            holder.titleTv.setText(bean.getName());
            holder.showLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, StrategyLvLookAllActivity.class);
                    intent.putExtra("title",bean.getName());
                    List<CategoryLvBean.DataBean.ChannelGroupsBean.ChannelsBean> list = bean.getChannels();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list", (Serializable) list);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
            final List<CategoryLvBean.DataBean.ChannelGroupsBean.ChannelsBean> datas = bean.getChannels();
            strategyLvGvAdapter = new StrategyLvGvAdapter(context);
            strategyLvGvAdapter.setDatas(datas);
            holder.gridView.setAdapter(strategyLvGvAdapter);
            holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(context, StrategyLvDetailsActivity.class);
                    String name = datas.get(position).getName();
                    String idUrl = datas.get(position).getId()+"";
                    String url = ConstantBean.STRATEGY_LV_DETAILS_URL + idUrl + ConstantBean.STRATEGY_LV_DETAILS_PINJIE_URL;
                    intent.putExtra("url",url);
                    intent.putExtra("name",name);
                    context.startActivity(intent);
                }
            });
        }
        return convertView;
    }

    class CategoryListViewHolder{
        MyGridView gridView;
        TextView titleTv;
        LinearLayout showLayout;
        public CategoryListViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.category_strategy_title_tv);
            gridView = (MyGridView) view.findViewById(R.id.strategy_lv_gv);
            showLayout = (LinearLayout) view.findViewById(R.id.item_strategy_show_layout);
        }
    }
}
