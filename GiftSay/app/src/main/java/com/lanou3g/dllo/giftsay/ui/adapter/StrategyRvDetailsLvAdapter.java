package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.StrategyRvDetailsBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/29.
 */
public class StrategyRvDetailsLvAdapter extends BaseAdapter{
    private Context context;
    private List<StrategyRvDetailsBean.DataBean.PostsBean> datas;

    public void setDatas(List<StrategyRvDetailsBean.DataBean.PostsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public StrategyRvDetailsLvAdapter(Context context) {
        this.context = context;
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
        StrategyRvDetailsViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_strategy_rv_detials_lv,parent,false);
            holder = new StrategyRvDetailsViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (StrategyRvDetailsViewHolder) convertView.getTag();
        }
        StrategyRvDetailsBean.DataBean.PostsBean bean = datas.get(position);
        if (bean != null){
            holder.titleTv.setText(bean.getTitle());
            holder.authorTv.setText(bean.getAuthor().getNickname());
            holder.likeCountTv.setText(bean.getLikes_count()+"");
            Picasso.with(context).load(bean.getCover_image_url()).into(holder.imageView);
        }
        return convertView;
    }
    class StrategyRvDetailsViewHolder {
        ImageView imageView ;
        TextView titleTv,authorTv,likeCountTv;
        public StrategyRvDetailsViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.strategy_rv_details_img);
            titleTv = (TextView) view.findViewById(R.id.strategy_rv_details_title);
            authorTv = (TextView) view.findViewById(R.id.strategy_rv_details_author);
            likeCountTv = (TextView) view.findViewById(R.id.strategy_rv_details_like_counts);
        }
    }
}
