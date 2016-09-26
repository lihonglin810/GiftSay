package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public class CategoryRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<CategoryRvBean.DataBean.ColumnsBean> datas;
    private Context context;
    private static final int TYPE_ONE_IMG = 1;// 一张图片
    private static final int TYPE_LIST = 0;// 列表数据

    public CategoryRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CategoryRvBean.DataBean.ColumnsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_LIST:
                View viewList = LayoutInflater.from(context).inflate(R.layout.item_category_strategy_rv,parent,false);
                CategoryRvViewHolder categoryRvViewHolder = new CategoryRvViewHolder(viewList);
                return categoryRvViewHolder;
            case TYPE_ONE_IMG:
                View viewImg = LayoutInflater.from(context).inflate(R.layout.item_category_rv_last_img,parent,false);
                OneImgViewHolder oneImgViewHolder = new OneImgViewHolder(viewImg);
                return oneImgViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
            switch (type){
                case TYPE_LIST:
                    CategoryRvViewHolder rvViewHolder = (CategoryRvViewHolder) holder;
                    Picasso.with(context).load(datas.get(position).getBanner_image_url()).into(rvViewHolder.bannerImg);
                    rvViewHolder.titleTv.setText(datas.get(position).getTitle());
                    rvViewHolder.subtitleTv.setText(datas.get(position).getSubtitle());
                    rvViewHolder.authorTv.setText(datas.get(position).getAuthor());
                    break;
                case TYPE_ONE_IMG:
                    OneImgViewHolder imgViewHolder = (OneImgViewHolder) holder;
                    break;
            }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == datas.size()) {
            return TYPE_ONE_IMG;
        } else {
            return TYPE_LIST;
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 :datas.size() + 1;
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
    class OneImgViewHolder extends RecyclerView.ViewHolder{
        TextView lookAllBtn;
        public OneImgViewHolder(View itemView) {
            super(itemView);
            lookAllBtn = (TextView) itemView.findViewById(R.id.item_category_rv_img_to_all);
        }
    }
}
