package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.HomePopBean;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 */
public class HomePopAdapter extends RecyclerView.Adapter<HomePopAdapter.HomeViewHolder>{

    private List<HomePopBean> datas;
    private Context context;

    public HomePopAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomePopBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pop_choose,parent,false);
        HomeViewHolder holder = new HomeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.popchooseTv.setText(datas.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 :datas.size();
    }


    class HomeViewHolder extends RecyclerView.ViewHolder{
        private TextView popchooseTv;
        public HomeViewHolder(View itemView) {
            super(itemView);
            popchooseTv = (TextView) itemView.findViewById(R.id.item_pop_choose_tv);
        }
    }
}
