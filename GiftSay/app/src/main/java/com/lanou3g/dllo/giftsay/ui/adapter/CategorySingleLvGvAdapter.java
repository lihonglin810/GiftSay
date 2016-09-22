package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CateGorySingleBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 分类单品界面ListView中的GridView适配器
 */
public class CategorySingleLvGvAdapter extends BaseAdapter{
    private Context context;
    private List<CateGorySingleBean.DataBean.CategoriesBean.SubcategoriesBean> datas;

    public CategorySingleLvGvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CateGorySingleBean.DataBean.CategoriesBean.SubcategoriesBean> datas) {
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
        CategorySingleGvViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_category_single_lv_gv,parent,false);
            holder = new CategorySingleGvViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (CategorySingleGvViewHolder) convertView.getTag();
        }
        CateGorySingleBean.DataBean.CategoriesBean.SubcategoriesBean bean = datas.get(position);
        if (bean != null){
            holder.nameTV.setText(bean.getName());
            Picasso.with(context).load(bean.getIcon_url()).into(holder.iconImg);
        }
        return convertView;
    }
    class CategorySingleGvViewHolder{
        ImageView iconImg;
        TextView nameTV;
        public CategorySingleGvViewHolder(View view) {
            iconImg = (ImageView) view.findViewById(R.id.item_category_single_gv_img);
            nameTV = (TextView) view.findViewById(R.id.item_category_single_gv_tv);
        }
    }
}
