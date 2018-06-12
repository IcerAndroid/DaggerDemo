package com.jarvan.dagger2demo.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jarvan.dagger2demo.R;

/**
 * 创建日期：2018/6/11 on 下午3:45
 * 描述:
 * 作者:张冰
 */
public class BannerAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public BannerAdapter() {
        super(R.layout.item_banner);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.banner_title, item);
    }
}
