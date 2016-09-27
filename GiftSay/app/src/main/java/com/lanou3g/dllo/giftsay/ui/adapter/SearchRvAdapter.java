package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.SearchHotWordBean;

import java.util.List;

/**
 * Created by dllo on 16/9/27.
 */
public class SearchRvAdapter extends RecyclerView.Adapter<SearchRvAdapter.SearchRvViewHolder>{
    private List<String> datas;
    private Context context;

    public SearchRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public SearchRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search_rv,parent,false);
        SearchRvViewHolder holder = new SearchRvViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SearchRvViewHolder holder, int position) {
        String string = datas.get(position);
        holder.textView.setText(string);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 :datas.size();
    }

    class SearchRvViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public SearchRvViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_search_rv_tv);
        }
    }
}
