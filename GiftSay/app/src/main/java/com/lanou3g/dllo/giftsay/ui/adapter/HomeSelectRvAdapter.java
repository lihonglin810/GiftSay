package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.HomeSelectRvBean;
import com.lanou3g.dllo.giftsay.utils.ScreenSizeUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 */
public class HomeSelectRvAdapter extends RecyclerView.Adapter<HomeSelectRvAdapter.RvViewHolder>{
    private List<HomeSelectRvBean.DataBean.SecondaryBannersBean> datas;
    private Context context;

    public HomeSelectRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomeSelectRvBean.DataBean.SecondaryBannersBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_select_rv,parent,false);
        RvViewHolder holder = new RvViewHolder(view);
        // 用工具类分别适配高度和宽度
        int height  = ScreenSizeUtil.getScreenHeight(context);
        int weight = ScreenSizeUtil.getScreenWidth(context);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = height/6 ;
        params.width = weight/4;
        view.setLayoutParams(params);
        return holder;
    }

    @Override
    public void onBindViewHolder(RvViewHolder holder, int position) {
        Picasso.with(context).load(datas.get(position).getImage_url()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 :datas.size();
    }

    class RvViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public RvViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_select_rv_img);
        }
    }
}
