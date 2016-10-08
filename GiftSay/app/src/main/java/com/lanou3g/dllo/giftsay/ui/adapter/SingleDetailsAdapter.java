package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.SingleDetailsBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/29.
 * 单品详情适配器
 */
public class SingleDetailsAdapter extends BaseAdapter{
    private List<SingleDetailsBean.DataBean.ItemsBean> datas;
    private Context context;

    public SingleDetailsAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<SingleDetailsBean.DataBean.ItemsBean> datas) {
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
        SingleDetailsViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_single_detials,parent,false);
            holder = new SingleDetailsViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (SingleDetailsViewHolder) convertView.getTag();
        }
        SingleDetailsBean.DataBean.ItemsBean bean = datas.get(position);
        if (bean != null) {
            holder.nameTv.setText(bean.getName());
            holder.shortDescriptionTv.setText(bean.getShort_description());
            holder.priceTv.setText("¥ " + bean.getPrice());
            Picasso.with(context).load(bean.getCover_image_url()).into(holder.imageView);
        }
        return convertView;
    }
    class SingleDetailsViewHolder{
        TextView shortDescriptionTv,nameTv,priceTv;
        ImageView imageView;
        public SingleDetailsViewHolder(View view) {
            shortDescriptionTv = (TextView) view.findViewById(R.id.item_single_details_short_description_tv);
            nameTv = (TextView) view.findViewById(R.id.item_single_details_name_tv);
            priceTv = (TextView) view.findViewById(R.id.item_single_details_price_tv);
            imageView = (ImageView) view.findViewById(R.id.item_single_details_image);
        }
    }
}
