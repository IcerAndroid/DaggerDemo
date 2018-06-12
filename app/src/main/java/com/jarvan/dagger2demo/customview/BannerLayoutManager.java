package com.jarvan.dagger2demo.customview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * 创建日期：2018/6/11 on 下午3:21
 * 描述:
 * 作者:张冰
 */
public class BannerLayoutManager extends RecyclerView.LayoutManager {

    private int offsetX = 0; //水平偏移
    private int mLeftX = 0; //卡片左端点的位置

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        //没有数据不进行处理
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }

        //将所有的子view临时移除并且回收
        detachAndScrapAttachedViews(recycler);

        offsetX = 0;
        //进行布局
        for (int i = 0; i < getItemCount(); i++) {
            View child = recycler.getViewForPosition(i);
            addView(child);
            measureAndLayout(child, i);
        }
    }

    /**
     * 计算view的大小并设置位置
     */
    private void measureAndLayout(View view, int position) {
        //1、开始计算大小
        measureChildWithMargins(view, 0, 0);

        //计算宽度
        int width = getDecoratedMeasuredWidth(view);
        //计算高度
        int height = getDecoratedMeasuredHeight(view);

        //将view放在RecyclerView
        layoutDecoratedWithMargins(view, offsetX, 0, offsetX + width, height);

        //更新水平位移
        offsetX += width;
    }

    @Override
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler,
            RecyclerView.State state) {
        Log.d("TAG",dx+"");
        offsetChildrenHorizontal(-dx);
        return -dx;
    }
}
