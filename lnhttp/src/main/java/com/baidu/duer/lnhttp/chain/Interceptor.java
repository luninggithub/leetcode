package com.baidu.duer.lnhttp.chain;

import com.baidu.duer.lnhttp.Response;

import java.io.IOException;

public interface Interceptor {

    Response intercept(InterceptorChain interceptorChain) throws IOException;

    String getName();
}
