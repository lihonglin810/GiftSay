package com.lanou3g.dllo.giftsay.model.db;

import com.lanou3g.dllo.giftsay.model.bean.CollectBean;
import com.lanou3g.dllo.giftsay.ui.app.GiftSayApp;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.List;

/**
 * Created by dllo on 16/10/9.
 * 数据库单类
 */
public class LiteOrmInstance {
    private static LiteOrmInstance instance;
    /**
     * 数据库名字
     */
    private static final String DB_NAME = "collect.db";

    private LiteOrm liteOrm;

    public LiteOrmInstance() {
        liteOrm = LiteOrm.newSingleInstance(GiftSayApp.getContext(),DB_NAME);
    }

    public static LiteOrmInstance getInstance() {
        if (instance == null){
            synchronized (LiteOrmInstance.class){
                if (instance == null){
                    instance = new LiteOrmInstance();
                }
            }
        }
        return instance;
    }

    // 插入一条
    public void insert(CollectBean cb){
        liteOrm.insert(cb);
    }
    // 插入集合数据
    public void insert(List<CollectBean> cbs){
        liteOrm.insert(cbs);
    }
    // 查询所有
    public List<CollectBean> queryAll(){
        return liteOrm.query(CollectBean.class);
    }
    // 根据条件查询
    public List<CollectBean> queryByName(String name){
        QueryBuilder<CollectBean> qb = new QueryBuilder<>(CollectBean.class);
        qb.where("name = ?",new String []{name});
        return liteOrm.query(qb);
    }
    // 按条件删除
    public void deleteByName(String name){
        WhereBuilder wb = new WhereBuilder(CollectBean.class,"name = ?",new String []{name});
        liteOrm.delete(wb);
    }
}
