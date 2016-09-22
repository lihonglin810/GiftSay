package com.lanou3g.dllo.giftsay.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/20.
 * 分类RecyclerView实体类
 */
public class CategoryRvBean {

    /**
     * code : 200
     * data : {"columns":[{"author":"4K馆长","banner_image_url":"http://img03.liwushuo.com/image/160905/558q5j6sx.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160905/558q5j6sx.jpg?imageView2/2/w/300/q/85/format/webp","category":"数码","cover_image_url":"http://img01.liwushuo.com/image/160905/75rv8fj87.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160905/75rv8fj87.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472806296,"description":"搜罗天下数码好物，每周测评体验极客最前沿。","id":99,"order":0,"post_published_at":1474243200,"status":0,"subtitle":"","title":"数码体验馆","updated_at":1474369469},{"author":"穿衣大队长","banner_image_url":"http://img01.liwushuo.com/image/160608/ygqtl238c.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/ygqtl238c.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img03.liwushuo.com/image/160713/4egoefdla.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/4egoefdla.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501669,"description":"做你的私人搭配师，每日搭配治好你的选择困难症，满足你多睡5分钟的小小心愿。","id":13,"order":0,"post_published_at":1474329600,"status":0,"subtitle":"更新至第119期","title":"明天穿什么","updated_at":1474365902},{"author":"礼帮主","banner_image_url":"http://img02.liwushuo.com/image/160905/dask3xap6.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160905/dask3xap6.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160905/o8ud1yp9x.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160905/o8ud1yp9x.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472808060,"description":"追女生、送父母、找基友，最全最优送礼指南，从此送礼不操心","id":102,"order":0,"post_published_at":1474329600,"status":0,"subtitle":"","title":"礼物帮兄","updated_at":1474364359},{"author":"淘局长","banner_image_url":"http://img03.liwushuo.com/image/160608/rcmok6bpq.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/rcmok6bpq.jpg?imageView2/2/w/300/q/85/format/webp","category":"海淘","cover_image_url":"http://img03.liwushuo.com/image/160713/5cbekga4c.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/5cbekga4c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462500836,"description":"你想要的全世界，我都有！","id":3,"order":0,"post_published_at":1474189200,"status":0,"subtitle":"更新至第74期","title":"海淘情报局","updated_at":1474362838},{"author":"上上签","banner_image_url":"http://img03.liwushuo.com/image/160902/9u68tzum1.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160902/9u68tzum1.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img03.liwushuo.com/image/160902/gsscbi494.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160902/gsscbi494.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472785741,"description":"把对你的爱，写进365首诗里、歌里拥入365天的心里、梦里。","id":96,"order":0,"post_published_at":1474340400,"status":0,"subtitle":"","title":"日复一签","updated_at":1474362832},{"author":"灰姑娘","banner_image_url":"http://img03.liwushuo.com/image/160608/qojypq4pe.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/qojypq4pe.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501946,"description":"好看就行。\u2014\u2014玛丽莲·赫本·千颂伊","id":23,"order":0,"post_published_at":1474254000,"status":0,"subtitle":"更新至第69期","title":"靠脸吃饭","updated_at":1474361333},{"author":"小礼君","banner_image_url":"http://img01.liwushuo.com/image/160901/hnxa6azdx.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160901/hnxa6azdx.jpg?imageView2/2/w/300/q/85/format/webp","category":"活动","cover_image_url":"http://img01.liwushuo.com/image/160901/6uqx378s8.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160901/6uqx378s8.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472708659,"description":"你我的互动让生活更生动","id":95,"order":0,"post_published_at":1473670800,"status":0,"subtitle":"","title":"热门活动","updated_at":1474339588},{"author":"美少女大人","banner_image_url":"http://img03.liwushuo.com/image/160902/xh7fnmi0x.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160902/xh7fnmi0x.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img03.liwushuo.com/image/160902/ostfcv54z.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160902/ostfcv54z.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472812805,"description":"史上最实用又超级简单易懂的直男穿搭术。拯救直男审美，让你撩妹更轻松。","id":104,"order":0,"post_published_at":1474329600,"status":0,"subtitle":"","title":"穿衣指「男」","updated_at":1474334719},{"author":"叫我小公举","banner_image_url":"http://img03.liwushuo.com/image/160608/muk9fdsya.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/muk9fdsya.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img03.liwushuo.com/image/160713/1p98sh06h.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/1p98sh06h.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501717,"description":"僻静的街角有一家杂货铺，或许你带着忧愁走进店中，但不期而遇的小物却让你展露欢颜。","id":14,"order":0,"post_published_at":1474362000,"status":0,"subtitle":"更新至第62期","title":"解忧杂货铺","updated_at":1474334692},{"author":"美物娘","banner_image_url":"http://img02.liwushuo.com/image/160608/8nluue8yx.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/8nluue8yx.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img02.liwushuo.com/image/160713/zlsbvl5it.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/zlsbvl5it.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501829,"description":"贪念时间所有美好的东西，唯一不吝啬的，就是与你分享。","id":19,"order":0,"post_published_at":1474243200,"status":0,"subtitle":"更新至第97期","title":"美物收割机","updated_at":1474279984},{"author":"文具菌","banner_image_url":"http://img02.liwushuo.com/image/160912/s9vu7wxnb.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160912/s9vu7wxnb.jpg?imageView2/2/w/300/q/85/format/webp","category":"爱读书","cover_image_url":"http://img03.liwushuo.com/image/160912/lb2cgsotg.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160912/lb2cgsotg.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1473643494,"description":"一个任由文具控种草、拔草的集合地，每周安利给最爱文具的你。\r\n","id":108,"order":0,"post_published_at":1473908400,"status":0,"subtitle":"更新至第1期","title":"文具集中营","updated_at":1474279932}],"paging":{"next_url":"http://api.liwushuo.com/v2/columns?limit=11&offset=11"}}
     * message : OK
     */

    private int code;
    /**
     * columns : [{"author":"4K馆长","banner_image_url":"http://img03.liwushuo.com/image/160905/558q5j6sx.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160905/558q5j6sx.jpg?imageView2/2/w/300/q/85/format/webp","category":"数码","cover_image_url":"http://img01.liwushuo.com/image/160905/75rv8fj87.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160905/75rv8fj87.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472806296,"description":"搜罗天下数码好物，每周测评体验极客最前沿。","id":99,"order":0,"post_published_at":1474243200,"status":0,"subtitle":"","title":"数码体验馆","updated_at":1474369469},{"author":"穿衣大队长","banner_image_url":"http://img01.liwushuo.com/image/160608/ygqtl238c.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/ygqtl238c.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img03.liwushuo.com/image/160713/4egoefdla.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/4egoefdla.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501669,"description":"做你的私人搭配师，每日搭配治好你的选择困难症，满足你多睡5分钟的小小心愿。","id":13,"order":0,"post_published_at":1474329600,"status":0,"subtitle":"更新至第119期","title":"明天穿什么","updated_at":1474365902},{"author":"礼帮主","banner_image_url":"http://img02.liwushuo.com/image/160905/dask3xap6.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160905/dask3xap6.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160905/o8ud1yp9x.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160905/o8ud1yp9x.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472808060,"description":"追女生、送父母、找基友，最全最优送礼指南，从此送礼不操心","id":102,"order":0,"post_published_at":1474329600,"status":0,"subtitle":"","title":"礼物帮兄","updated_at":1474364359},{"author":"淘局长","banner_image_url":"http://img03.liwushuo.com/image/160608/rcmok6bpq.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/rcmok6bpq.jpg?imageView2/2/w/300/q/85/format/webp","category":"海淘","cover_image_url":"http://img03.liwushuo.com/image/160713/5cbekga4c.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/5cbekga4c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462500836,"description":"你想要的全世界，我都有！","id":3,"order":0,"post_published_at":1474189200,"status":0,"subtitle":"更新至第74期","title":"海淘情报局","updated_at":1474362838},{"author":"上上签","banner_image_url":"http://img03.liwushuo.com/image/160902/9u68tzum1.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160902/9u68tzum1.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img03.liwushuo.com/image/160902/gsscbi494.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160902/gsscbi494.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472785741,"description":"把对你的爱，写进365首诗里、歌里拥入365天的心里、梦里。","id":96,"order":0,"post_published_at":1474340400,"status":0,"subtitle":"","title":"日复一签","updated_at":1474362832},{"author":"灰姑娘","banner_image_url":"http://img03.liwushuo.com/image/160608/qojypq4pe.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/qojypq4pe.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501946,"description":"好看就行。\u2014\u2014玛丽莲·赫本·千颂伊","id":23,"order":0,"post_published_at":1474254000,"status":0,"subtitle":"更新至第69期","title":"靠脸吃饭","updated_at":1474361333},{"author":"小礼君","banner_image_url":"http://img01.liwushuo.com/image/160901/hnxa6azdx.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160901/hnxa6azdx.jpg?imageView2/2/w/300/q/85/format/webp","category":"活动","cover_image_url":"http://img01.liwushuo.com/image/160901/6uqx378s8.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160901/6uqx378s8.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472708659,"description":"你我的互动让生活更生动","id":95,"order":0,"post_published_at":1473670800,"status":0,"subtitle":"","title":"热门活动","updated_at":1474339588},{"author":"美少女大人","banner_image_url":"http://img03.liwushuo.com/image/160902/xh7fnmi0x.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160902/xh7fnmi0x.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img03.liwushuo.com/image/160902/ostfcv54z.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160902/ostfcv54z.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472812805,"description":"史上最实用又超级简单易懂的直男穿搭术。拯救直男审美，让你撩妹更轻松。","id":104,"order":0,"post_published_at":1474329600,"status":0,"subtitle":"","title":"穿衣指「男」","updated_at":1474334719},{"author":"叫我小公举","banner_image_url":"http://img03.liwushuo.com/image/160608/muk9fdsya.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/muk9fdsya.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img03.liwushuo.com/image/160713/1p98sh06h.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/1p98sh06h.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501717,"description":"僻静的街角有一家杂货铺，或许你带着忧愁走进店中，但不期而遇的小物却让你展露欢颜。","id":14,"order":0,"post_published_at":1474362000,"status":0,"subtitle":"更新至第62期","title":"解忧杂货铺","updated_at":1474334692},{"author":"美物娘","banner_image_url":"http://img02.liwushuo.com/image/160608/8nluue8yx.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/8nluue8yx.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img02.liwushuo.com/image/160713/zlsbvl5it.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/zlsbvl5it.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501829,"description":"贪念时间所有美好的东西，唯一不吝啬的，就是与你分享。","id":19,"order":0,"post_published_at":1474243200,"status":0,"subtitle":"更新至第97期","title":"美物收割机","updated_at":1474279984},{"author":"文具菌","banner_image_url":"http://img02.liwushuo.com/image/160912/s9vu7wxnb.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160912/s9vu7wxnb.jpg?imageView2/2/w/300/q/85/format/webp","category":"爱读书","cover_image_url":"http://img03.liwushuo.com/image/160912/lb2cgsotg.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160912/lb2cgsotg.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1473643494,"description":"一个任由文具控种草、拔草的集合地，每周安利给最爱文具的你。\r\n","id":108,"order":0,"post_published_at":1473908400,"status":0,"subtitle":"更新至第1期","title":"文具集中营","updated_at":1474279932}]
     * paging : {"next_url":"http://api.liwushuo.com/v2/columns?limit=11&offset=11"}
     */

    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * next_url : http://api.liwushuo.com/v2/columns?limit=11&offset=11
         */

        private PagingBean paging;
        /**
         * author : 4K馆长
         * banner_image_url : http://img03.liwushuo.com/image/160905/558q5j6sx.jpg-w300
         * banner_webp_url : http://img03.liwushuo.com/image/160905/558q5j6sx.jpg?imageView2/2/w/300/q/85/format/webp
         * category : 数码
         * cover_image_url : http://img01.liwushuo.com/image/160905/75rv8fj87.jpg-w720
         * cover_webp_url : http://img01.liwushuo.com/image/160905/75rv8fj87.jpg?imageView2/2/w/720/q/85/format/webp
         * created_at : 1472806296
         * description : 搜罗天下数码好物，每周测评体验极客最前沿。
         * id : 99
         * order : 0
         * post_published_at : 1474243200
         * status : 0
         * subtitle :
         * title : 数码体验馆
         * updated_at : 1474369469
         */

        private List<ColumnsBean> columns;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<ColumnsBean> getColumns() {
            return columns;
        }

        public void setColumns(List<ColumnsBean> columns) {
            this.columns = columns;
        }

        public static class PagingBean {
            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class ColumnsBean {
            private String author;
            private String banner_image_url;
            private String banner_webp_url;
            private String category;
            private String cover_image_url;
            private String cover_webp_url;
            private int created_at;
            private String description;
            private int id;
            private int order;
            private int post_published_at;
            private int status;
            private String subtitle;
            private String title;
            private int updated_at;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBanner_image_url() {
                return banner_image_url;
            }

            public void setBanner_image_url(String banner_image_url) {
                this.banner_image_url = banner_image_url;
            }

            public String getBanner_webp_url() {
                return banner_webp_url;
            }

            public void setBanner_webp_url(String banner_webp_url) {
                this.banner_webp_url = banner_webp_url;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public String getCover_webp_url() {
                return cover_webp_url;
            }

            public void setCover_webp_url(String cover_webp_url) {
                this.cover_webp_url = cover_webp_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getPost_published_at() {
                return post_published_at;
            }

            public void setPost_published_at(int post_published_at) {
                this.post_published_at = post_published_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
