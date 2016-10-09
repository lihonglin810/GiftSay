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
    public List<CollectBean> queryByTitle(String title){
        QueryBuilder<CollectBean> qb = new QueryBuilder<>(CollectBean.class);
        qb.where("title = ?",new String []{title});
        return liteOrm.query(qb);
    }
    public List<CollectBean> queryByTitle(String title, int start, int end){
        QueryBuilder<CollectBean> qb = new QueryBuilder<>(CollectBean.class);
        qb.where("title = ?",new String []{title});
        // 但是:end需要判断,不要超出数据库数据的个数的限制
        qb.limit(start,end);
        return liteOrm.query(qb);
    }
    // 按条件删除
    public void deleteByTitle(String title){
        WhereBuilder wb = new WhereBuilder(CollectBean.class,"title = ?",new String []{title});
        liteOrm.delete(wb);
    }
}
