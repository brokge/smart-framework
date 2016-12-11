package com.udaye.framework.proxy;

/**
 * 代理接口
 * Created by chenlw on 16-8-10.
 */
public interface Proxy {
    /**
     * 执行链式代理
     *
     * @param proxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
