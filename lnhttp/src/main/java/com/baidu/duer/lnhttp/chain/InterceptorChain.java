package com.baidu.duer.lnhttp.chain;

import android.util.Log;

import com.baidu.duer.lnhttp.Call;
import com.baidu.duer.lnhttp.HttpConnection;
import com.baidu.duer.lnhttp.Response;

import java.io.IOException;
import java.util.List;


public class InterceptorChain {
    private static final String TAG = "LN-HTTP";

    final List<Interceptor> interceptors;
    final int index;
    final Call call;
    HttpConnection httpConnection;


    public InterceptorChain(List<Interceptor> interceptors, int index, Call call,HttpConnection httpConnection) {
        this.interceptors = interceptors;
        this.index = index;
        this.call = call;
        this.httpConnection = httpConnection;
    }

    public Response proceed(HttpConnection httpConnection) throws IOException{
        this.httpConnection = httpConnection;
        return proceed();
    }

    public Response proceed() throws IOException{
        Log.i(TAG, "Response proceed():" + index);
        if (index > interceptors.size()) {
            throw new IOException("Interceptor Chain Error");
        }
        Interceptor interceptor = interceptors.get(index);
        InterceptorChain next = new InterceptorChain(interceptors,index + 1, call, httpConnection);
        Log.i(TAG, "interceptor.intercept(next) before:" + index + ", name:" + interceptor.getName());
        Response response = interceptor.intercept(next);
        Log.i(TAG, "interceptor.intercept(next) after:" + index + ", name:" + interceptor.getName());
        return response;
    }


}
