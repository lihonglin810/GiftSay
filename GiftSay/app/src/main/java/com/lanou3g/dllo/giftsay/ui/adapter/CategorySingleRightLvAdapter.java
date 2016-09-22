package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CateGorySingleBean;
import com.lanou3g.dllo.giftsay.view.MyGridView;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 分类单品界面ListView适配器
 */
public class CategorySingleRightLvAdapter extends BaseAdapter{
    private List<CateGorySingleBean.DataBean.CategoriesBean> datas;
    private Context context;


    public CategorySingleRightLvAdapter(Context context) {
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
        CategorySingleViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_category_single_lv,parent,false);
            holder = new CategorySingleViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (CategorySingleViewHolder) convertView.getTag();
        }

        CateGorySingleBean.DataBean.CategoriesBean bean = datas.get(position);
        if (bean != null){
            holder.singleTv.setText(bean.getName());
            holder.adapter.setDatas(bean.getSubcategories());
            holder.gridView.setAdapter(holder.adapter);
        }
        return convertView;
    }

    class CategorySingleViewHolder{
        TextView singleTv;
        CategorySingleLvGvAdapter adapter;
        MyGridView gridView;
        public CategorySingleViewHolder(View view) {
            singleTv = (TextView) view.findViewById(R.id.item_category_single_tv);
            adapter = new CategorySingleLvGvAdapter(context);
            gridView = (MyGridView) view.findViewById(R.id.item_category_single_gv);
        }
    }
}
