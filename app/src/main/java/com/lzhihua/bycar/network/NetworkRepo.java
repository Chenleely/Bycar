package com.lzhihua.bycar.network;

import com.alibaba.fastjson.JSON;

import java.util.Map;

import okhttp3.Request;

public class NetworkRepo {
    public static final String Base_url="";
    public static class OkhttpOption{
        private String url;
        private String tag;//log时使用
        private Map<String ,String > params;//设置header
        public OkhttpOption(String tag){
            this.tag=tag;
        }

        public String getTag() {
            return tag;
        }

        public Map<String, String> getParams() {
            return params;
        }
        public static final class Builder{
            public String tag;
            public Map<String,String > params;
            public String url;

            public void setTag(String tag) {
                this.tag = tag;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setParams(Map<String, String> params) {
                this.params = params;
            }
            public OkhttpOption build(){
                OkhttpOption okhttpOption=new OkhttpOption(tag);
                okhttpOption.params=params;
                okhttpOption.url=url;
                return okhttpOption;
            }
        }
    }
    public static String appendUri(String url, Map<String,String> params){
        StringBuffer buffer=new StringBuffer();
        if(params.isEmpty()){
            return url;
        }else {
            buffer.append("?");
            for(String key:params.keySet()){
                buffer.append(key);
                buffer.append("=");
                buffer.append(params.get(key));
            }
        }
        return buffer.toString();
    }
}
