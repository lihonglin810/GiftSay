package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.HomePopBean;
import com.lanou3g.dllo.giftsay.model.bean.HomeTabTitleBean;
import com.lanou3g.dllo.giftsay.model.interfaces.OnRvItemClick;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * 主页popwindow适配器
 */
public class HomePopAdapter extends RecyclerView.Adapter<HomePopAdapter.HomeViewHolder> {

    private List<HomeTabTitleBean.DataBean.ChannelsBean> datas;
    private Context context;
    private int selectPosition;
    private OnRvItemClick onRvItemClick;

    public HomePopAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomeTabTitleBean.DataBean.ChannelsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
        notifyDataSetChanged();
    }

    public void setOnRvItemClick(OnRvItemClick onRvItemClick) {
        this.onRvItemClick = onRvItemClick;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pop_choose, parent, false);
        HomeViewHolder holder = new HomeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, int position) {
        HomeTabTitleBean.DataBean.ChannelsBean bean = datas.get(position);
        holder.popchooseTv.setText(bean.getName());
        if (position == selectPosition) {
            holder.popchooseTv.setTextColor(Color.RED);
        } else {
            holder.popchooseTv.setTextColor(Color.GRAY);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getLayoutPosition();
                HomeTabTitleBean.DataBean.ChannelsBean channelsBean = datas.get(position);
                onRvItemClick.onRvItemClickListener(position, channelsBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }


    class HomeViewHolder extends RecyclerView.ViewHolder {
        private TextView popchooseTv;

        public HomeViewHolder(View itemView) {
            super(itemView);
            popchooseTv = (TextView) itemView.findViewById(R.id.item_pop_choose_tv);
        }
    }
}
