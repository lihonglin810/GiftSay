package com.lanou3g.dllo.giftsay.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.RotateBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 */
public class RotateVpAdapter extends PagerAdapter{

    private List<RotateBean.DataBean.BannersBean> datas;
    private Context context;
    private LayoutInflater inflater;

    public RotateVpAdapter(List<RotateBean.DataBean.BannersBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public RotateVpAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<RotateBean.DataBean.BannersBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // position是int最大值所以这里可能是几百甚至上千,因此取余避免数组越界
        int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_home_lunbo_vp, container, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_home_lunbo_iv);
        Picasso.with(context).load(datas.get(newPosition).getImage_url()).into(imageView);
        container.addView(convertView);
        return convertView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
