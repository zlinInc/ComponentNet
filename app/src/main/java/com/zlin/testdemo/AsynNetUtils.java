package com.zlin.testdemo;

import android.os.Handler;

/**
 * @author ZLin
 * 创建时间：2018/11/4 14:37
 * description:异步转化请求数据，
 **/
public class AsynNetUtils {
    public interface Callback {
        void onResponse(String response);
    }

    public static void get(final String url, final Callback callback) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String response = HttpRequestDemo.get(url);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onResponse(response);
                    }
                });
            }
        }).start();
    }

    public static void post(final String url, final String content, final Callback callback) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String response = HttpRequestDemo.post(url, content);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onResponse(response);
                    }
                });
            }
        }).start();
    }

}
