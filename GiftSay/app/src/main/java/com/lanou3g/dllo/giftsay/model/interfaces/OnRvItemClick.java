package com.lanou3g.dllo.giftsay.model.interfaces;

/**
 * Created by dllo on 16/9/27.
 * RecyclerView的接口
 */
public interface OnRvItemClick<T> {
    void onRvItemClickListener(int position,T t);
}
