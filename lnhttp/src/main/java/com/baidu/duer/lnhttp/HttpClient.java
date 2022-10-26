package com.baidu.duer.lnhttp;

import com.baidu.duer.lnhttp.chain.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class HttpClient {

    //设置调度器
    private Dispatcher dispatcher;

    private List<Interceptor> interceptors;

    private int retryTimes;

    private ConnectionPool connectionPool;

    public int getRetryTimes() {
        return retryTimes;
    }

    public Dispatcher getDispather() {
        return dispatcher;
    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    /**
     * 构造方法
     */
    public HttpClient(Builder builder) {
        this.dispatcher = builder.dispatcher;
        this.interceptors = builder.interceptors;
        this.retryTimes = builder.retryTimes;
        this.connectionPool = builder.connectionPool;
    }

    /**
     * 生成一个网络请求Call对象实例
     * @param request
     * @return
     */
    public Call newCall(Request request) {
        return new Call(this,request);
    }

    //TODO 建造对象
    public static final class Builder{
        Dispatcher dispatcher;
        List<Interceptor> interceptors = new ArrayList<>();
        int retryTimes;
        ConnectionPool connectionPool;
        public Builder addInterceptors(Interceptor interceptor) {
            interceptors.add(interceptor);
            return this;
        }
        public Builder setDispather(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }
        public Builder setRetryTimes(int retryTimes) {
            this.retryTimes = retryTimes;
            return this;
        }
        public Builder setConnectionPool(ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
            return this;
        }

        public HttpClient build() {
            if (null == dispatcher) {
                dispatcher = new Dispatcher();
            }
            if (null == connectionPool) {
                connectionPool = new ConnectionPool();
            }
            return new HttpClient(this);
        }

    }
}
