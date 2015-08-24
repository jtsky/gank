package com.jin.gank.data;

import java.util.List;

/**
 * Created by Administrator on 2015/8/24.
 */
public class GankRandom {

    /**
     * error : false
     * results : [{"createdAt":"2015-05-28T11:18:58.168Z","publishedAt":"2015-05-29T03:36:51.888Z","used":true,"type":"Android","url":"https://github.com/romannurik/AndroidSDKSearchExtension","objectId":"5566f9a2e4b0aec39bf9b10b","who":"mthli","desc":"快速搜索Android SDK文档的Chrome扩展","updatedAt":"2015-08-15T03:09:57.714Z"},{"createdAt":"2015-08-18T15:24:36.747Z","publishedAt":"2015-08-19T03:56:32.551Z","used":true,"type":"Android","url":"https://github.com/SkillCollege/SimplifyReader","objectId":"55d34e3400b0de09f8fb0532","who":"Jason","desc":"一款基于Google Material Design设计开发的Android客户端，包括新闻简读，图片浏览，视频爽看 ，音乐轻听以及二维码扫描五个子模块，项目采取的是MVP架构开发。","updatedAt":"2015-08-19T03:56:34.075Z"},{"createdAt":"2015-06-07T11:00:27.934Z","publishedAt":"2015-06-09T03:30:27.469Z","used":true,"type":"Android","url":"https://github.com/JorgeCastilloPrz/FABProgressCircle","objectId":"5574244be4b029ae5fd0f298","who":"mthli","desc":"在FloatingActionButton上显示环形进度条","updatedAt":"2015-08-15T03:09:57.923Z"},{"createdAt":"2015-05-18T02:25:10.936Z","publishedAt":"2015-05-19T08:40:35.957Z","used":true,"type":"Android","url":"https://github.com/dmytrodanylyk/circular-progress-button","objectId":"55594d86e4b0b8cd3b7aefcc","who":"Jason","desc":"带进度显示的Button","updatedAt":"2015-08-15T03:09:57.704Z"},{"createdAt":"2015-06-02T15:38:30.156Z","publishedAt":"2015-06-04T05:01:40.057Z","used":true,"type":"Android","url":"https://github.com/yaa110/Piclice","objectId":"556dcdf6e4b005426cf9e94d","who":"Jason","desc":"一款将图片切片与分享的应用","updatedAt":"2015-08-15T03:09:57.802Z"},{"createdAt":"2015-07-13T02:02:11.196Z","publishedAt":"2015-07-13T03:33:29.420Z","used":true,"type":"Android","url":"https://github.com/worker8/TourGuide","objectId":"55a31c23e4b031b0057bb3ff","who":"有时放纵","desc":"一个用于你的android app引导功能的库","updatedAt":"2015-08-15T03:09:59.286Z"},{"createdAt":"2015-07-27T04:51:14.289Z","publishedAt":"2015-07-29T03:32:59.575Z","used":true,"type":"Android","url":"https://github.com/code-mc/material-icon-lib","objectId":"55b5b8c200b0c43f5b1de3c8","who":"Jason","desc":"包含1000多个material矢量图标的安卓图标库","updatedAt":"2015-08-15T03:15:54.746Z"},{"createdAt":"2015-06-05T04:24:39.142Z","publishedAt":"2015-06-09T03:38:06.063Z","used":true,"type":"Android","url":"https://github.com/PaoloRotolo/AppIntro","objectId":"55712487e4b0ba4266fa223e","who":"mthli","desc":"一个漂亮的App功能介绍库","updatedAt":"2015-08-15T03:09:57.927Z"},{"createdAt":"2015-08-10T22:47:04.910Z","publishedAt":"2015-08-11T03:28:03.108Z","used":true,"type":"Android","url":"https://github.com/kingideayou/SlideBottomPanel","objectId":"55c929e860b20fc9a88711bf","who":"代码家","desc":"底部划出菜单，滑动时背景图透明度渐变，支持嵌套 LiewView 或 ScrollView。","updatedAt":"2015-08-15T03:15:54.387Z"},{"createdAt":"2015-06-16T16:00:11.974Z","publishedAt":"2015-06-17T04:09:49.084Z","used":true,"type":"Android","url":"http://blog.csdn.net/garybook/article/details/7925728","objectId":"5580480be4b02f99238c9596","who":"LHF","desc":"Android中的签名机制","updatedAt":"2015-08-15T03:09:57.814Z"}]
     */
    private boolean error;
    private List<ResultsEntity> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public static class ResultsEntity {
        /**
         * createdAt : 2015-05-28T11:18:58.168Z
         * publishedAt : 2015-05-29T03:36:51.888Z
         * used : true
         * type : Android
         * url : https://github.com/romannurik/AndroidSDKSearchExtension
         * objectId : 5566f9a2e4b0aec39bf9b10b
         * who : mthli
         * desc : 快速搜索Android SDK文档的Chrome扩展
         * updatedAt : 2015-08-15T03:09:57.714Z
         */
        private String createdAt;
        private String publishedAt;
        private boolean used;
        private String type;
        private String url;
        private String objectId;
        private String who;
        private String desc;
        private String updatedAt;

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public boolean isUsed() {
            return used;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public String getObjectId() {
            return objectId;
        }

        public String getWho() {
            return who;
        }

        public String getDesc() {
            return desc;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }
    }
}
