package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CategoryRvBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 分类攻略界面RecyclerView的适配器
 */
public class CategoryRvAdapter extends RecyclerView.Adapter<CategoryRvAdapter.CategoryRvViewHolder>{

    private List<CategoryRvBean.DataBean.ColumnsBean> datas;
    private Context context;

    public CategoryRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CategoryRvBean.DataBean.ColumnsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public CategoryRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category_strategy_rv,parent,false);
        CategoryRvViewHolder holder = new CategoryRvViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CategoryRvViewHolder holder, int position) {
        Picasso.with(context).load(datas.get(position).getBanner_image_url()).into(holder.bannerImg);
        holder.titleTv.setText(datas.get(position).getTitle());
        holder.subtitleTv.setText(datas.get(position).getSubtitle());
        holder.authorTv.setText(datas.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 :datas.size();
    }

    class CategoryRvViewHolder extends RecyclerView.ViewHolder{
        ImageView bannerImg;
        TextView titleTv,subtitleTv,authorTv;
        public CategoryRvViewHolder(View itemView) {
            super(itemView);
            bannerImg = (ImageView) itemView.findViewById(R.id.item_category_rv_banner_image);
            titleTv = (TextView) itemView.findViewById(R.id.item_category_rv_title);
            subtitleTv = (TextView) itemView.findViewById(R.id.item_category_rv_subtitle);
            authorTv = (TextView) itemView.findViewById(R.id.item_category_rv_author);
        }
    }
}
