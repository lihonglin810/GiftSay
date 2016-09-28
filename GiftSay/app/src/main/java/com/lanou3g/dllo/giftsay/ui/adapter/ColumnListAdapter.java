package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CategoryRvBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 */
public class ColumnListAdapter extends BaseAdapter{
    private Context context;
    private List<CategoryRvBean.DataBean.ColumnsBean> datas;

    public ColumnListAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CategoryRvBean.DataBean.ColumnsBean> datas) {
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
        ColumnListViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_column_list,parent,false);
            holder = new ColumnListViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ColumnListViewHolder) convertView.getTag();
        }
        CategoryRvBean.DataBean.ColumnsBean bean = datas.get(position);
        if (bean != null){
            Picasso.with(context).load(datas.get(position).getBanner_image_url()).into(holder.bannerImg);
            holder.titleTv.setText(datas.get(position).getTitle());
            holder.subtitleTv.setText(datas.get(position).getSubtitle());
            holder.authorTv.setText(datas.get(position).getAuthor());
        }
        return convertView;
    }
    class ColumnListViewHolder {
        ImageView bannerImg;
        TextView titleTv,subtitleTv,authorTv;
        public ColumnListViewHolder(View view) {
            bannerImg = (ImageView) view.findViewById(R.id.item_column_banner_image);
            titleTv = (TextView) view.findViewById(R.id.item_column_title);
            subtitleTv = (TextView) view.findViewById(R.id.item_column_subtitle);
            authorTv = (TextView) view.findViewById(R.id.item_column_author);
        }
    }
}
