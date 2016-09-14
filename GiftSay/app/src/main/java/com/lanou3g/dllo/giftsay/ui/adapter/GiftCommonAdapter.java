package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.GiftCommonBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 榜单所有页adapter
 */
public class GiftCommonAdapter extends RecyclerView.Adapter<GiftCommonAdapter.GiftCommonViewHolder>{
    private Context context;
    private List<GiftCommonBean.DataBean.ItemsBean> datas;

    public GiftCommonAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<GiftCommonBean.DataBean.ItemsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public GiftCommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gift_common,parent,false);
        GiftCommonViewHolder holder = new GiftCommonViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GiftCommonViewHolder holder, int position) {
        Picasso.with(context).load(datas.get(position).getCover_image_url()).into(holder.giftCoverImage);
        holder.giftNameTv.setText(datas.get(position).getName());
        holder.giftShortDescriptionTv.setText(datas.get(position).getShort_description());
        holder.giftPriceTv.setText(datas.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    class GiftCommonViewHolder extends RecyclerView.ViewHolder{
        ImageView giftCoverImage;
        TextView giftShortDescriptionTv,giftNameTv,giftPriceTv;
        public GiftCommonViewHolder(View itemView) {
            super(itemView);
            giftCoverImage = (ImageView) itemView.findViewById(R.id.item_gift_cover_image);
            giftShortDescriptionTv = (TextView) itemView.findViewById(R.id.short_description_tv);
            giftNameTv = (TextView) itemView.findViewById(R.id.item_gift_name_tv);
            giftPriceTv = (TextView) itemView.findViewById(R.id.item_gift_price_tv);
        }
    }
}
