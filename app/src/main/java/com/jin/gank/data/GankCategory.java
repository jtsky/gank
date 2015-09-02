package com.jin.gank.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/8/24.
 */
public class GankCategory {

    /**
     * error : false
     * results : [{"createdAt":"2015-08-24T03:53:33.486Z","publishedAt":"2015-08-24T04:06:07.602Z","used":true,"type":"休息视频","url":"http://v.youku.com/v_show/id_XMTMxMDA3MTEzNg==.html?from=s1.8-1-1.2","objectId":"55da953d00b04a634990f1c8","who":"代码家","desc":"从海龟鼻子里取出吸管儿（看的我要哭了","updatedAt":"2015-08-24T04:06:07.986Z"},{"createdAt":"2015-08-24T02:56:43.287Z","publishedAt":"2015-08-24T04:06:07.601Z","used":true,"type":"Android","url":"https://github.com/cesarferreira/dryrun","objectId":"55da87eb00b04a63498dee53","who":"mthli","desc":"快速尝试各种lib的demo","updatedAt":"2015-08-24T04:06:08.249Z"},{"createdAt":"2015-08-24T02:27:40.869Z","publishedAt":"2015-08-24T04:06:07.600Z","used":true,"type":"Android","url":"https://github.com/ashishb/android-security-awesome","objectId":"55da811c60b296e567e04ae4","who":"andyiac","desc":"一些android安全相关收集","updatedAt":"2015-08-24T04:06:07.992Z"},{"createdAt":"2015-08-24T02:26:06.138Z","publishedAt":"2015-08-24T04:06:07.600Z","used":true,"type":"Android","url":"https://github.com/PkmX/lcamera","objectId":"55da80be60b296e567e0364d","who":"mthli","desc":"一个使用新的Camera2 API的相机App","updatedAt":"2015-08-24T04:06:07.979Z"},{"createdAt":"2015-08-24T02:10:00.994Z","publishedAt":"2015-08-24T04:06:07.599Z","used":true,"type":"iOS","url":"https://github.com/likumb/SimpleMemo","objectId":"55da7cf800b04a63498b413f","who":"鲍永章","desc":"已上架的便签App源码，Swift编写，支持AppleWatch。","updatedAt":"2015-08-24T04:06:07.983Z"},{"createdAt":"2015-08-24T01:46:55.914Z","publishedAt":"2015-08-24T04:06:07.598Z","used":true,"type":"Android","url":"https://github.com/venmo/tooltip-view","objectId":"55da778f60b2ce30313cbcea","who":"有时放纵","desc":"一个android的工具提示view","updatedAt":"2015-08-24T04:06:07.995Z"},{"createdAt":"2015-08-24T01:37:37.406Z","publishedAt":"2015-08-24T04:06:07.597Z","used":true,"type":"Android","url":"http://zuimeia.com/app/3252/?category=15&platform=2","objectId":"55da756160b27e6c78cde002","who":"lxxself","desc":"设计师利器，安卓程序员好好学","updatedAt":"2015-08-24T04:06:07.996Z"},{"createdAt":"2015-08-24T01:39:50.174Z","publishedAt":"2015-08-24T04:06:07.597Z","used":true,"type":"Android","url":"https://github.com/hitherejoe/Android-Boilerplate","objectId":"55da75e600b05bb7664709ec","who":"有时放纵","desc":"一个用了Espresso和Robolectric的android样板","updatedAt":"2015-08-24T04:06:08.012Z"},{"createdAt":"2015-08-24T01:34:58.737Z","publishedAt":"2015-08-24T04:06:07.594Z","used":true,"type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1evdga4dimoj20qo0hsmzf.jpg","objectId":"55da74c200b0a527148167f8","who":"张涵宇","desc":"8.24","updatedAt":"2015-08-24T04:06:08.796Z"},{"createdAt":"2015-08-23T13:18:19.102Z","publishedAt":"2015-08-24T04:06:07.593Z","used":true,"type":"拓展资源","url":"http://json.parser.online.fr/","objectId":"55d9c81b60b26a528474478e","who":"lxxself","desc":"Json Parser Online","updatedAt":"2015-08-24T04:06:08.010Z"}]
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

    public static class ResultsEntity implements Serializable {
        /**
         * createdAt : 2015-08-24T03:53:33.486Z
         * publishedAt : 2015-08-24T04:06:07.602Z
         * used : true
         * type : 休息视频
         * url : http://v.youku.com/v_show/id_XMTMxMDA3MTEzNg==.html?from=s1.8-1-1.2
         * objectId : 55da953d00b04a634990f1c8
         * who : 代码家
         * desc : 从海龟鼻子里取出吸管儿（看的我要哭了
         * updatedAt : 2015-08-24T04:06:07.986Z
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
