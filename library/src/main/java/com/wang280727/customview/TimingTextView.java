package com.wang280727.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

/**
 * @WYU-WIN
 * @date 2020/7/28 0028.
 * description：
 */
public class TimingTextView extends RCRelativeLayout {

    public TimingTextView(Context context) {
        this(context, null);
    }

    public TimingTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimingTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {

        }
        LayoutInflater.from(context).inflate(R.layout.view_timing_text, this);

    }
}
