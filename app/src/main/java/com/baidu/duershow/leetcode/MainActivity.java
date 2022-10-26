package com.baidu.duershow.leetcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.baidu.duer.lnhttp.Call;
import com.baidu.duer.lnhttp.Callback;
import com.baidu.duer.lnhttp.HttpClient;
import com.baidu.duer.lnhttp.Request;
import com.baidu.duer.lnhttp.RequestBody;
import com.baidu.duer.lnhttp.Response;
import com.baidu.duer.lnhttp.chain.Interceptor;
import com.baidu.duer.lnhttp.chain.InterceptorChain;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "LN-HTTP";

    HttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = new HttpClient.Builder()
                .addInterceptors(new Interceptor() {
                    @Override
                    public Response intercept(InterceptorChain interceptorChain) throws IOException {
                        Log.i(TAG, "CustomInterceptor ---> custom work here!");
                        return interceptorChain.proceed();
                    }

                    @Override
                    public String getName() {
                        return "CustomInterceptor";
                    }
                })
                .setRetryTimes(3)
                .build();
    }

    public void get(View view) {
        Request request = new Request.Builder()
                .setHttpUrl("http://www.kuaidi100.com/query?type=yuantong&postid=222222222")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, Throwable throwable) {
                throwable.printStackTrace();
                Log.e(TAG, "onFailure", throwable);
            }

            @Override
            public void onResponse(Call call, Response response) {
                Log.i(TAG, response.getBody());
            }
        });
    }

    public void post(View view) {
        RequestBody body = new RequestBody()
                .add("key", "064a7778b8389441e30f91b8a60c9b23")
                .add("city", "深圳");


        Request request = new Request.Builder()
                .setHttpUrl("http://restapi.amap.com/v3/weather/weatherInfo")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, Throwable throwable) {
                throwable.printStackTrace();
                Log.e(TAG, "onFailure", throwable);
            }

            @Override
            public void onResponse(Call call, Response response) {
                Log.i(TAG, response.getBody());
            }
        });
    }
}