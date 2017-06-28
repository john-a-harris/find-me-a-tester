package com.umotif.findmeatester;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}
