package com.jarvan.dagger2demo.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jarvan.dagger2demo.R;

/**
 * 创建日期：2018/6/6 on 下午4:35
 * 描述:
 * 作者:张冰
 */
public class BottomSheetAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public BottomSheetAdapter() {
        super(R.layout.item_recycler_bottom_sheet_date);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_date, item);
    }
}
