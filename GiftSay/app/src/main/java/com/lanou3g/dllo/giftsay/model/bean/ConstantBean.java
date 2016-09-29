package com.lanou3g.dllo.giftsay.model.bean;

/**
 * Created by dllo on 16/9/22.
 * App的数据常量类
 */
public final class ConstantBean {

    private ConstantBean() {
    }
    /**
     * 首页TAB数据
     */
    public static final String TAB_TITLE_URL = "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=1";
    /**
     * 搜索热词
     */
    public static final String HOT_WORD_URL = "http://api.liwushuo.com/v2/search/hot_words";
    /**
     * 首页精选ListView的URl
     */
    public static final String RECOMMEND_URL = "http://api.liwushuo.com/v2/channels/100/items_v2?ad=2&gender=1&generation=1&limit=10&offset=0";
    /**
     * 首页跳转详情拼接网址
     */
    public static final String HOME_PINJIE_URL = "http://hawaii.liwushuo.com/posts/";
    /**
     * 首页精选的横向RecyclerView的URL
     */
    public static final String SCROLL_URL = "http://api.liwushuo.com/v2/secondary_banners?gender=1&generation=2";
    /**
     * 首页轮播图
     */
    public static final String CAROUSEL_URL = "http://api.liwushuo.com/v2/banners?channel";
    /**
     * 首页女朋友界面
     */
    public static final String GIRLFRIEND_URL = "http://api.liwushuo.com/v2/channels/10/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页海淘界面
     */
    public static final String SEA_AMOY_URL = "http://api.liwushuo.com/v2/channels/129/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页创意界面
     */
    public static final String ORIGINAKITY_URL = "http://api.liwushuo.com/v2/channels/125/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页科技界面
     */
    public static final String TECHNOLOGY_URL = "http://api.liwushuo.com/v2/channels/28/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页送父母界面
     */
    public static final String PARENT_URL = "http://api.liwushuo.com/v2/channels/6/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页送基友
     */
    public static final String SEND_JIYOU_URL = "http://api.liwushuo.com/v2/channels/26/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页送闺蜜
     */
    public static final String SEND_GUIMI_URL = "http://api.liwushuo.com/v2/channels/5/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页送同事
     */
    public static final String SEND_TONGSHI_URL = "http://api.liwushuo.com/v2/channels/17/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页送宝贝
     */
    public static final String SEND_BABY_URL = "http://api.liwushuo.com/v2/channels/24/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页设计感
     */
    public static final String DESIGN_URL = "http://api.liwushuo.com/v2/channels/127/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页文艺风
     */
    public static final String LITERATURE_URL = "http://api.liwushuo.com/v2/channels/14/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页奇葩
     */
    public static final String CRACKPOT_URL = "http://api.liwushuo.com/v2/channels/126/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 首页萌萌哒
     */
    public static final String ADORABLE_URL = "http://api.liwushuo.com/v2/channels/11/items_v2?gender=1&limit=20&offset=0&generation=1";
    /**
     * 榜单页每日推荐
     */
    public static final String EVERYDAY_URL = "http://api.liwushuo.com/v2/ranks_v2/ranks/1?limit=20&offset=0";
    /**
     * 榜单页TOP100
     */
    public static final String TOP100_URL = "http://api.liwushuo.com/v2/ranks_v2/ranks/2?limit=20&offset=0";
    /**
     * 榜单页独立原创榜
     */
    public static final String INDEPENDENT_URL = "http://api.liwushuo.com/v2/ranks_v2/ranks/3?limit=20&offset=0";
    /**
     * 榜单页新星榜
     */
    public static final String NEW_STAR_URL = "http://api.liwushuo.com/v2/ranks_v2/ranks/4?limit=20&offset=0";
    /**
     * 分类页攻略RecyclerView
     */
    public static final String CATEGORY_RV_URL = "http://api.liwushuo.com/v2/columns";
    /**
     * 分类页攻略RecyclerView点击详情后面的拼接网址
     */
    public static final String CATEGORY_RV_PINJIE_URL = "?limit=100&offset=0";
    /**
     * 分类页攻略RecyclerView全部数据
     */
    public static final String CATEGORY_RV_ALL_URL = "http://api.liwushuo.com/v2/columns?limit=100&offset=0";
    /**
     * 分类页攻略ListView
     */
    public static final String CATEGORY_LV_URL = "http://api.liwushuo.com/v2/channel_groups/all";
    /**
     * 分类页单品URL
     */
    public static final String CATEGORY_SINGLE_URL = "http://api.liwushuo.com/v2/item_categories/tree";
    /**
     * 分类单品点击详情前半部分网址
     */
    public static final String SINGLE_DETIALS_BEFORE_URL = "http://api.liwushuo.com/v2/item_subcategories/";
    /**
     * 分类单品点击详情后半部分网址
     */
    public static final String SINGLE_DETIALS_AFTER_URL = "/items?limit=50&offset=0";

    public static final String[] WEEK = {"星期天","星期一","星期二","星期三","星期四","星期五","星期六"};

}
