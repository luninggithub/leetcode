package com.baidu.duer.lnhttp.chain;

import android.util.Log;

import com.baidu.duer.lnhttp.Call;
import com.baidu.duer.lnhttp.Response;

import java.io.IOException;


public class RetryInterceptor implements Interceptor {

    @Override
    public Response intercept(InterceptorChain interceptorChain) throws IOException {
        Log.e("interceprot", "重试拦截器....");
        Call call = interceptorChain.call;
        IOException ioException = null;

        for (int i = 0 ; i < call.getHttpClient().getRetryTimes(); i ++) {
            if (call.isCanceled()) {
                throw new IOException("this task had canceled");
            }
            try {
                Response response = interceptorChain.proceed();
                return response;
            } catch (IOException e) {
                ioException = e;
            }
        }
        throw ioException;
    }

    @Override
    public String getName() {
        return "RetryInterceptor";
    }
}
