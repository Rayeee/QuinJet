package me.zgy;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Rayee on 2017/11/30.
 */
public class Test {

    public static void main(String... args) throws IOException, InterruptedException {
        String url = "http://www.kuaidi100.com/query?type=shentong&temp=0.20225095125411285&postid=";
        AtomicLong atomicLong = new AtomicLong(402825450385l);
        OkHttpClient okHttpClient = new OkHttpClient();
        for (; ; ) {
            Request request = new Request.Builder().url(url + atomicLong.getAndDecrement()).build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            String result = response.body().string();
            if(atomicLong.get() % 1 == 0){
                System.out.println(atomicLong.get() + "--->" + result);
            }
            if (result.contains("太仓")) {
                System.out.println("找到太仓！！！！" + atomicLong.get() + "--->" + result);
            }
            Thread.sleep(1000);
        }

    }

}
