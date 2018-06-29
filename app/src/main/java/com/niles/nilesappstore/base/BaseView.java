package com.niles.nilesappstore.base;

/**
 * Created by Niles
 * Date 2018/6/29 15:24
 * Email niulinguo@163.com
 */
public interface BaseView<T> {

    void setPresenter(T presenter);

    boolean isActive();
}
