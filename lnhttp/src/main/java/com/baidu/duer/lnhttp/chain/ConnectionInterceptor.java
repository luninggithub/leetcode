package com.baidu.duer.lnhttp.chain;

import android.util.Log;

import com.baidu.duer.lnhttp.HttpClient;
import com.baidu.duer.lnhttp.HttpConnection;
import com.baidu.duer.lnhttp.HttpUrl;
import com.baidu.duer.lnhttp.Request;
import com.baidu.duer.lnhttp.Response;

import java.io.IOException;


public class ConnectionInterceptor implements Interceptor {

    @Override
    public Response intercept(InterceptorChain interceptorChain) throws IOException {
        Log.e("interceptor", "获取连接拦截器");
        Request request = interceptorChain.call.getRequest();
        HttpClient httpClient = interceptorChain.call.getHttpClient();
        HttpUrl httpUrl = request.getHttpUrl();

        HttpConnection httpConnection = httpClient.getConnectionPool().getHttpConnection(httpUrl.getHost(),httpUrl.getPort());
        if (null == httpConnection) {
            httpConnection = new HttpConnection();
        } else {
            Log.e("interceptor", "从连接池中获得连接");
        }
        httpConnection.setRequest(request);

        try {
            Response response = interceptorChain.proceed(httpConnection);
            if (response.isKeepAlive()) {
                httpClient.getConnectionPool().putHttpConnection(httpConnection);
            } else {
                httpConnection.close();
            }
            return response;
        } catch (IOException e) {
            httpConnection.close();
            throw e;
        }
    }

    @Override
    public String getName() {
        return "ConnectionInterceptor";
    }
}
