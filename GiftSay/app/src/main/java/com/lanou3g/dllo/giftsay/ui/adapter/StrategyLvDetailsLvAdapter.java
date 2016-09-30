package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.StrategyLvDetailsBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/30.
 */
public class StrategyLvDetailsLvAdapter extends BaseAdapter{

    private List<StrategyLvDetailsBean.DataBean.ItemsBean> datas;
    private Context context;

    public StrategyLvDetailsLvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<StrategyLvDetailsBean.DataBean.ItemsBean> datas) {
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
        StrategyLvDetailsViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_common,parent,false);
            holder = new StrategyLvDetailsViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (StrategyLvDetailsViewHolder) convertView.getTag();
        }
        StrategyLvDetailsBean.DataBean.ItemsBean bean = datas.get(position);
        if (bean.getColumn() != null && bean.getAuthor() != null){
            holder.categoryTv.setText(bean.getColumn().getCategory());
            holder.topTitleTv.setText(bean.getColumn().getTitle());
            holder.nicknameTv.setText(bean.getAuthor().getNickname());
            holder.bottomTitleTv.setText(bean.getTitle());
            String count = String.valueOf(bean.getLikes_count());
            holder.likeCountsTv.setText(count);
            Picasso.with(context).load(bean.getAuthor().getAvatar_url()).into(holder.avatarImg);
            Picasso.with(context).load(bean.getCover_image_url()).into(holder.coverImg);
        }
        return convertView;
    }
    class StrategyLvDetailsViewHolder{
        TextView categoryTv,topTitleTv,bottomTitleTv,nicknameTv,likeCountsTv;
        ImageView coverImg;
        CircleImageView avatarImg;
        public StrategyLvDetailsViewHolder(View view) {
            categoryTv = (TextView) view.findViewById(R.id.item_category);
            topTitleTv = (TextView) view.findViewById(R.id.item_top_title);
            bottomTitleTv = (TextView) view.findViewById(R.id.item_bottom_title);
            nicknameTv = (TextView) view.findViewById(R.id.item_nickname);
            likeCountsTv = (TextView) view.findViewById(R.id.item_likes_count);
            avatarImg = (CircleImageView) view.findViewById(R.id.item_avatar_img);
            coverImg = (ImageView) view.findViewById(R.id.item_cover_img);
        }
    }
}
