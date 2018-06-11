package com.jarvan.dagger2demo.ui.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jarvan.dagger2demo.R;
import com.jarvan.dagger2demo.model.bean.GankIoSection;

import java.util.List;

/**
 * 创建日期：2018/6/6 on 上午10:24
 * 描述:
 * 作者:张冰
 */
public class TodayAdapter extends BaseSectionQuickAdapter<GankIoSection, BaseViewHolder> {

    public TodayAdapter(List<GankIoSection> data) {
        super(R.layout.item_recycler_today_common, R.layout.item_recycler_today_title, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, GankIoSection item) {
        helper.setText(R.id.item_category, item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankIoSection item) {
        if ("福利".equals(item.t.getType())) {
            helper.setVisible(R.id.item_rl_image, true);
            Glide.with(mContext)
                    .load(item.t.getUrl())
                    .into((ImageView) helper.getView(R.id.item_gank_image));
        } else {
            helper.getView(R.id.item_rl_image).setVisibility(View.GONE);
        }

        StringBuilder stringBuilder = new StringBuilder(item.t.getDesc());
        final String who = item.t.getWho();
        if (!TextUtils.isEmpty(who) && !"null".equals(who)) {
            stringBuilder.append(String.format(" [%s]", who));
        }
        helper.setText(R.id.item_gank_desc, stringBuilder.toString());
        helper.setText(R.id.item_gank_image_desc, stringBuilder.toString());
    }
}
