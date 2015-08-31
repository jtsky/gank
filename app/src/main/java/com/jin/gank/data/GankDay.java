package com.jin.gank.data;

import java.util.List;

/**
 * Created by Administrator on 2015/8/24.
 */
public class GankDay {

    /**
     * error : false
     * category : ["iOS","Android","瞎推荐","拓展资源","福利","休息视频"]
     * results : {"福利":[{"createdAt":"2015-08-07T01:21:06.112Z","publishedAt":"2015-08-07T03:57:47.310Z","used":true,"type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1eutscfcqtcj20dw0i0q4l.jpg","objectId":"55c4080240ac7d0a9507905e","who":"张涵宇","desc":"8.7\u2014\u2014（1）","updatedAt":"2015-08-15T03:15:54.765Z"},{"createdAt":"2015-08-07T01:21:33.518Z","publishedAt":"2015-08-07T03:57:47.229Z","used":true,"type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1eutsd0pgiwj20go0p0djn.jpg","objectId":"55c4081d60b2c9d32a67a92e","who":"张涵宇","desc":"8.7\u2014\u2014（2）","updatedAt":"2015-08-15T03:15:54.843Z"}],"休息视频":[{"createdAt":"2015-08-06T13:06:17.211Z","publishedAt":"2015-08-07T03:57:48.104Z","used":true,"type":"休息视频","url":"http://www.zhihu.com/question/21778055/answer/19905413?utm_source=weibo&utm_medium=weibo_share&utm_content=share_answer&utm_campaign=share_button","objectId":"55c35bc960b2750766954ec3","who":"lxxself","desc":"听到就心情大好的歌，简直妖魔哈哈哈哈哈，原地址 http://v.youku.com/v_show/id_XMTQxODA5NDM2.html","updatedAt":"2015-08-15T03:15:54.872Z"}],"拓展资源":[{"createdAt":"2015-08-07T01:36:06.932Z","publishedAt":"2015-08-07T03:57:48.081Z","used":true,"type":"拓展资源","url":"https://github.com/buunguyen/octotree","objectId":"55c40b8600b08484a7f3a032","who":"lxxself","desc":"Display GitHub code in tree format","updatedAt":"2015-08-15T03:15:54.382Z"}],"瞎推荐":[{"createdAt":"2015-08-07T01:52:30.267Z","publishedAt":"2015-08-07T03:57:48.084Z","used":true,"type":"瞎推荐","url":"https://cmd.fm/","objectId":"55c40f5e00b00045334934b4","who":"lxxself","desc":"程序员的电台FmM，这个页面chrome插件有问题啊哭，我写了回删除不了啊","updatedAt":"2015-08-15T03:15:54.383Z"}],"iOS":[{"createdAt":"2015-08-07T01:32:51.588Z","publishedAt":"2015-08-07T03:57:48.070Z","used":true,"type":"iOS","url":"http://adriansampson.net/blog/llvm.html","objectId":"55c40ac360b2c9d32a67ca25","who":"CallMeWhy","desc":"LLVM 简介","updatedAt":"2015-08-15T03:15:54.384Z"},{"createdAt":"2015-08-06T14:45:18.733Z","publishedAt":"2015-08-07T03:57:47.242Z","used":true,"type":"iOS","url":"https://github.com/molon/MLLabel","objectId":"55c372fe60b2f809e41eb388","who":"鲍永章","desc":"基于TextKit的UILabel，支持超链接和自定义表达式。","updatedAt":"2015-08-15T03:15:54.536Z"},{"createdAt":"2015-08-07T01:33:30.871Z","publishedAt":"2015-08-07T03:57:48.083Z","used":true,"type":"iOS","url":"http://chris.eidhof.nl/posts/swift-c-interop.html","objectId":"55c40aea00b025867b19c9af","who":"CallMeWhy","desc":"Swift 和 C 函数","updatedAt":"2015-08-15T03:15:54.408Z"},{"createdAt":"2015-08-07T01:34:00.984Z","publishedAt":"2015-08-07T03:57:48.174Z","used":true,"type":"iOS","url":"http://airspeedvelocity.net/2015/08/03/arrays-linked-lists-and-performance/","objectId":"55c40b0800b0fac2c2809acc","who":"CallMeWhy","desc":"Arrays Linked Lists 和性能比较","updatedAt":"2015-08-15T03:15:55.105Z"}],"Android":[{"createdAt":"2015-08-06T07:15:52.065Z","publishedAt":"2015-08-07T03:57:48.045Z","used":true,"type":"Android","url":"https://github.com/recruit-lifestyle/FloatingView","objectId":"55c309a800b00045333db517","who":"mthli","desc":"类似Link Bubble的悬浮式操作设计","updatedAt":"2015-08-15T03:15:55.098Z"},{"createdAt":"2015-08-07T01:33:07.815Z","publishedAt":"2015-08-07T03:57:47.317Z","used":true,"type":"Android","url":"http://www.zhihu.com/question/33636939","objectId":"55c40ad340ac7d0a9507b324","who":"lxxself","desc":"Android开发中，有哪些让你觉得相见恨晚的方法、类或接口？","updatedAt":"2015-08-15T03:15:54.407Z"},{"createdAt":"2015-08-06T15:00:38.350Z","publishedAt":"2015-08-07T03:57:48.076Z","used":true,"type":"Android","url":"https://github.com/tom91136/Akatsuki","objectId":"55c3769660b2750766971ce6","who":"鲍永章","desc":"使用注解来处理Activity的状态恢复","updatedAt":"2015-08-15T03:15:54.866Z"},{"createdAt":"2015-08-07T02:19:44.342Z","publishedAt":"2015-08-07T03:57:48.142Z","used":true,"type":"Android","url":"https://git.oschina.net/way/PinnedHeaderListView","objectId":"55c415c060b2d140ca882eac","who":"有时放纵","desc":"Android Lollipop联系人之PinnedListView简单使用","updatedAt":"2015-08-15T03:15:55.020Z"},{"createdAt":"2015-08-06T14:58:28.171Z","publishedAt":"2015-08-07T03:57:48.073Z","used":true,"type":"Android","url":"https://github.com/Q42/AndroidScrollingImageView","objectId":"55c3761400b00045334480d2","who":"鲍永章","desc":"图片可以自动滚动的ImageView，可以实现视差效果。","updatedAt":"2015-08-15T03:15:55.123Z"}]}
     */
    private boolean error;
    private List<String> category;
    private ResultsEntity results;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public void setResults(ResultsEntity results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public List<String> getCategory() {
        return category;
    }

    public ResultsEntity getResults() {
        return results;
    }

    public static class ResultsEntity {
        /**
         * 福利 : [{"createdAt":"2015-08-07T01:21:06.112Z","publishedAt":"2015-08-07T03:57:47.310Z","used":true,"type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1eutscfcqtcj20dw0i0q4l.jpg","objectId":"55c4080240ac7d0a9507905e","who":"张涵宇","desc":"8.7\u2014\u2014（1）","updatedAt":"2015-08-15T03:15:54.765Z"},{"createdAt":"2015-08-07T01:21:33.518Z","publishedAt":"2015-08-07T03:57:47.229Z","used":true,"type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1eutsd0pgiwj20go0p0djn.jpg","objectId":"55c4081d60b2c9d32a67a92e","who":"张涵宇","desc":"8.7\u2014\u2014（2）","updatedAt":"2015-08-15T03:15:54.843Z"}]
         * 休息视频 : [{"createdAt":"2015-08-06T13:06:17.211Z","publishedAt":"2015-08-07T03:57:48.104Z","used":true,"type":"休息视频","url":"http://www.zhihu.com/question/21778055/answer/19905413?utm_source=weibo&utm_medium=weibo_share&utm_content=share_answer&utm_campaign=share_button","objectId":"55c35bc960b2750766954ec3","who":"lxxself","desc":"听到就心情大好的歌，简直妖魔哈哈哈哈哈，原地址 http://v.youku.com/v_show/id_XMTQxODA5NDM2.html","updatedAt":"2015-08-15T03:15:54.872Z"}]
         * 拓展资源 : [{"createdAt":"2015-08-07T01:36:06.932Z","publishedAt":"2015-08-07T03:57:48.081Z","used":true,"type":"拓展资源","url":"https://github.com/buunguyen/octotree","objectId":"55c40b8600b08484a7f3a032","who":"lxxself","desc":"Display GitHub code in tree format","updatedAt":"2015-08-15T03:15:54.382Z"}]
         * 瞎推荐 : [{"createdAt":"2015-08-07T01:52:30.267Z","publishedAt":"2015-08-07T03:57:48.084Z","used":true,"type":"瞎推荐","url":"https://cmd.fm/","objectId":"55c40f5e00b00045334934b4","who":"lxxself","desc":"程序员的电台FmM，这个页面chrome插件有问题啊哭，我写了回删除不了啊","updatedAt":"2015-08-15T03:15:54.383Z"}]
         * iOS : [{"createdAt":"2015-08-07T01:32:51.588Z","publishedAt":"2015-08-07T03:57:48.070Z","used":true,"type":"iOS","url":"http://adriansampson.net/blog/llvm.html","objectId":"55c40ac360b2c9d32a67ca25","who":"CallMeWhy","desc":"LLVM 简介","updatedAt":"2015-08-15T03:15:54.384Z"},{"createdAt":"2015-08-06T14:45:18.733Z","publishedAt":"2015-08-07T03:57:47.242Z","used":true,"type":"iOS","url":"https://github.com/molon/MLLabel","objectId":"55c372fe60b2f809e41eb388","who":"鲍永章","desc":"基于TextKit的UILabel，支持超链接和自定义表达式。","updatedAt":"2015-08-15T03:15:54.536Z"},{"createdAt":"2015-08-07T01:33:30.871Z","publishedAt":"2015-08-07T03:57:48.083Z","used":true,"type":"iOS","url":"http://chris.eidhof.nl/posts/swift-c-interop.html","objectId":"55c40aea00b025867b19c9af","who":"CallMeWhy","desc":"Swift 和 C 函数","updatedAt":"2015-08-15T03:15:54.408Z"},{"createdAt":"2015-08-07T01:34:00.984Z","publishedAt":"2015-08-07T03:57:48.174Z","used":true,"type":"iOS","url":"http://airspeedvelocity.net/2015/08/03/arrays-linked-lists-and-performance/","objectId":"55c40b0800b0fac2c2809acc","who":"CallMeWhy","desc":"Arrays Linked Lists 和性能比较","updatedAt":"2015-08-15T03:15:55.105Z"}]
         * Android : [{"createdAt":"2015-08-06T07:15:52.065Z","publishedAt":"2015-08-07T03:57:48.045Z","used":true,"type":"Android","url":"https://github.com/recruit-lifestyle/FloatingView","objectId":"55c309a800b00045333db517","who":"mthli","desc":"类似Link Bubble的悬浮式操作设计","updatedAt":"2015-08-15T03:15:55.098Z"},{"createdAt":"2015-08-07T01:33:07.815Z","publishedAt":"2015-08-07T03:57:47.317Z","used":true,"type":"Android","url":"http://www.zhihu.com/question/33636939","objectId":"55c40ad340ac7d0a9507b324","who":"lxxself","desc":"Android开发中，有哪些让你觉得相见恨晚的方法、类或接口？","updatedAt":"2015-08-15T03:15:54.407Z"},{"createdAt":"2015-08-06T15:00:38.350Z","publishedAt":"2015-08-07T03:57:48.076Z","used":true,"type":"Android","url":"https://github.com/tom91136/Akatsuki","objectId":"55c3769660b2750766971ce6","who":"鲍永章","desc":"使用注解来处理Activity的状态恢复","updatedAt":"2015-08-15T03:15:54.866Z"},{"createdAt":"2015-08-07T02:19:44.342Z","publishedAt":"2015-08-07T03:57:48.142Z","used":true,"type":"Android","url":"https://git.oschina.net/way/PinnedHeaderListView","objectId":"55c415c060b2d140ca882eac","who":"有时放纵","desc":"Android Lollipop联系人之PinnedListView简单使用","updatedAt":"2015-08-15T03:15:55.020Z"},{"createdAt":"2015-08-06T14:58:28.171Z","publishedAt":"2015-08-07T03:57:48.073Z","used":true,"type":"Android","url":"https://github.com/Q42/AndroidScrollingImageView","objectId":"55c3761400b00045334480d2","who":"鲍永章","desc":"图片可以自动滚动的ImageView，可以实现视差效果。","updatedAt":"2015-08-15T03:15:55.123Z"}]
         */
        private List<GankCategory.ResultsEntity> 福利;
        private List<GankCategory.ResultsEntity> 休息视频;
        private List<GankCategory.ResultsEntity> 拓展资源;
        private List<GankCategory.ResultsEntity> 瞎推荐;
        private List<GankCategory.ResultsEntity> iOS;
        private List<GankCategory.ResultsEntity> Android;

        public void set福利(List<GankCategory.ResultsEntity> 福利) {
            this.福利 = 福利;
        }

        public void set休息视频(List<GankCategory.ResultsEntity> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public void set拓展资源(List<GankCategory.ResultsEntity> 拓展资源) {
            this.拓展资源 = 拓展资源;
        }

        public void set瞎推荐(List<GankCategory.ResultsEntity> 瞎推荐) {
            this.瞎推荐 = 瞎推荐;
        }

        public void setIOS(List<GankCategory.ResultsEntity> iOS) {
            this.iOS = iOS;
        }

        public void setAndroid(List<GankCategory.ResultsEntity> Android) {
            this.Android = Android;
        }

        public List<GankCategory.ResultsEntity> get福利() {
            return 福利;
        }

        public List<GankCategory.ResultsEntity> get休息视频() {
            return 休息视频;
        }

        public List<GankCategory.ResultsEntity> get拓展资源() {
            return 拓展资源;
        }

        public List<GankCategory.ResultsEntity> get瞎推荐() {
            return 瞎推荐;
        }

        public List<GankCategory.ResultsEntity> getIOS() {
            return iOS;
        }

        public List<GankCategory.ResultsEntity> getAndroid() {
            return Android;
        }


    }
}
