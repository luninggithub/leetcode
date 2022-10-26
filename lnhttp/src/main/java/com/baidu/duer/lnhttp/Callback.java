package com.baidu.duer.lnhttp;

public interface Callback {

    void onFailure(Call call,Throwable throwable);

    void onResponse(Call call,Response response);
}
