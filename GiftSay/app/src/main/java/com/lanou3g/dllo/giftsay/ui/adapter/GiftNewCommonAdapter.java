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
import com.lanou3g.dllo.giftsay.utils.ScreenSizeUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 */
public class GiftNewCommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private String imgUrl;
    private List<GiftCommonBean.DataBean.ItemsBean> datas;

    private static final int TYPE_ONE_IMG = 0;// 一张图片
    private static final int TYPE_LIST = 1;// 列表数据

    public GiftNewCommonAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<GiftCommonBean.DataBean.ItemsBean> datas, String imgUrl) {
        this.datas = datas;
        this.imgUrl = imgUrl;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_ONE_IMG:
                View view = LayoutInflater.from(context).inflate(R.layout.item_gift_common_one_img, parent, false);
                HolderOneImg holderOneImg = new HolderOneImg(view);
                return holderOneImg;
            case TYPE_LIST:
                View viewList = LayoutInflater.from(context).inflate(R.layout.item_gift_common, parent, false);
                HolderList holderList = new HolderList(viewList);
                return holderList;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE_IMG;
        } else {
            return TYPE_LIST;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type){
            case TYPE_ONE_IMG:
                // 0的position在这被用了
                HolderOneImg holderOneImg = (HolderOneImg) holder;
                ViewGroup.LayoutParams params = holderOneImg.coverImageView.getLayoutParams();
                params.width = ScreenSizeUtil.getScreenWidth(context);
                holderOneImg.coverImageView.setLayoutParams(params);

                Picasso.with(context).load(imgUrl).into(holderOneImg.coverImageView);
                break;
            case TYPE_LIST:
                // position从1开始
                // 从集合中第0个数据开始取
                HolderList holderList = (HolderList) holder;
                GiftCommonBean.DataBean.ItemsBean itemsBean = datas.get(position - 1);
                Picasso.with(context).load(itemsBean.getCover_image_url()).into(holderList.coverImg);
                holderList.shortDescriptionTv.setText(itemsBean.getShort_description());
                holderList.nameTv.setText(itemsBean.getName());
                holderList.priceTv.setText(itemsBean.getPrice());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size() + 1;
    }

    class HolderOneImg extends RecyclerView.ViewHolder {
        private ImageView coverImageView;
        public HolderOneImg(View itemView) {
            super(itemView);
            coverImageView = (ImageView) itemView.findViewById(R.id.item_gift_one_img);
        }
    }

    class HolderList extends RecyclerView.ViewHolder {
        private ImageView coverImg;
        private TextView shortDescriptionTv,nameTv,priceTv;
        public HolderList(View itemView) {
            super(itemView);
            coverImg = (ImageView) itemView.findViewById(R.id.item_gift_cover_image);
            shortDescriptionTv = (TextView) itemView.findViewById(R.id.short_description_tv);
            nameTv = (TextView) itemView.findViewById(R.id.item_gift_name_tv);
            priceTv = (TextView) itemView.findViewById(R.id.item_gift_price_tv);
        }
    }
}
