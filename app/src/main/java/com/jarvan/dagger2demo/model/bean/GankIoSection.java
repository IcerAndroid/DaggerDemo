package com.jarvan.dagger2demo.model.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * 创建日期：2018/6/6 on 上午10:50
 * 描述:
 * 作者:张冰
 */
public class GankIoSection extends SectionEntity<GankEntity> {
    public GankIoSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public GankIoSection(GankEntity gankEntity) {
        super(gankEntity);
    }
}
