package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CollectBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/10/11.
 * 收藏GridView适配器
 */
public class CollectGvAdapter extends BaseAdapter{

    private Context context;
    private List<CollectBean> datas;

    public CollectGvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CollectBean> datas) {
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
        CollectGvViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_collect,parent,false);
            holder = new CollectGvViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (CollectGvViewHolder) convertView.getTag();
        }
        CollectBean bean = datas.get(position);
        Picasso.with(context).load(bean.getImgUrl()).into(holder.coverImg);
        holder.shortDescriptionTv.setText(bean.getDescription());
        holder.nameTv.setText(bean.getName());
        holder.priceTv.setText("¥ " + bean.getPrice());
        return convertView;
    }
    class CollectGvViewHolder{
        ImageView coverImg;
        TextView shortDescriptionTv,nameTv,priceTv;
        public CollectGvViewHolder(View view) {
            coverImg = (ImageView) view.findViewById(R.id.item_collect_cover_image);
            shortDescriptionTv = (TextView) view.findViewById(R.id.item_collect_short_description_tv);
            nameTv = (TextView) view.findViewById(R.id.item_collect_name_tv);
            priceTv = (TextView) view.findViewById(R.id.item_collect_price_tv);
        }
    }
}
