package com.lanou3g.dllo.giftsay.model.bean;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/10/9.
 * 收藏实体类
 */
@Table("collect")
public class CollectBean {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;
    private String name;
    private String description;
    private String price;
    private String imgUrl;

    public CollectBean() {
    }

    public CollectBean(int id, String name, String description, String price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public CollectBean(String imgUrl, String price, String description, String name) {
        this.imgUrl = imgUrl;
        this.price = price;
        this.description = description;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
