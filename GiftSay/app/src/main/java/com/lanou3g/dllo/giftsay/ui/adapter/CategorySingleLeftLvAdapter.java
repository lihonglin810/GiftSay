package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

    public CategorySingleLeftLvAdapter(Context context) {
        this.context = context;
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
        CateGorySingleBean.DataBean.CategoriesBean bean = datas.get(position);
        holder.nameTv.setText(bean.getName());
        return convertView;
    }
    class CategorySingleLeftLvViewHolder{
        TextView nameTv;
        public CategorySingleLeftLvViewHolder(View view) {
            nameTv = (TextView) view.findViewById(R.id.item_category_single_left_tv);
        }
    }
}
