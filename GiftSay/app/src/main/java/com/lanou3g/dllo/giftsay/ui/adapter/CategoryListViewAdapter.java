package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lanou3g.dllo.giftsay.model.bean.CategoryLvBean;

import java.util.List;

/**
 * Created by dllo on 16/9/20.
 * 分类界面ListView的适配器
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

        return convertView;
    }

    private class CategoryListViewHolder{

        public CategoryListViewHolder(View view) {
        }
    }
}
