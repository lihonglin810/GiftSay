package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CateGorySingleBean;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 分类单品界面左面的ListView适配器
 */
public class CategorySingleLeftLvAdapter extends BaseAdapter{
    private Context context;
    private List<CateGorySingleBean.DataBean.CategoriesBean> datas;
    private int selectPosition;

    public CategorySingleLeftLvAdapter(Context context) {
        this.context = context;
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
        notifyDataSetChanged();
    }

    public void setDatas(List<CateGorySingleBean.DataBean.CategoriesBean> datas) {
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
        CategorySingleLeftLvViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_category_single_left_lv,parent,false);
            holder = new CategorySingleLeftLvViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (CategorySingleLeftLvViewHolder) convertView.getTag();
        }
        holder.nameTv.setTag(datas.get(position));
        CateGorySingleBean.DataBean.CategoriesBean bean = datas.get(position);
        holder.nameTv.setText(bean.getName());
        if (position == selectPosition){
            holder.nameTv.setTextColor(Color.RED);
            holder.relativeLayout.setBackgroundColor(Color.WHITE);
            holder.leftview.setBackgroundColor(Color.RED);
        }else {
            holder.nameTv.setTextColor(Color.BLACK);
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#f4f4f4"));
            holder.leftview.setBackgroundColor(Color.parseColor("#f4f4f4"));
        }
        return convertView;
    }
    class CategorySingleLeftLvViewHolder{
        TextView nameTv;
        LinearLayout relativeLayout;
        TextView leftview;
        public CategorySingleLeftLvViewHolder(View view) {
            nameTv = (TextView) view.findViewById(R.id.item_category_single_left_tv);
            relativeLayout = (LinearLayout) view.findViewById(R.id.item_category_single_left_layout);
            leftview = (TextView) view.findViewById(R.id.item_category_single_left_view);
        }
    }
}
