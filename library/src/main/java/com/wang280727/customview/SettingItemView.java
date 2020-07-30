package com.wang280727.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by wyu on 2017/8/14.
 */

public class SettingItemView extends RelativeLayout {
    private TextView tvContext;
    private TextView tvRightText;
    private ImageView ivLeftIcon;
    private ImageView ivRightIcon;
    private String left;
    private String right;
    private int image;
    private int rightImage;
    private int lineColor = 0xff999999;
    private boolean showLeftIcon = true;
    private boolean showRightIcon = true;

    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SettingItemView);
            left = typedArray.getString(R.styleable.SettingItemView_left_Text);
            right = typedArray.getString(R.styleable.SettingItemView_right_Text);
            image = typedArray.getResourceId(R.styleable.SettingItemView_left_icon, -1);
            rightImage = typedArray.getResourceId(R.styleable.SettingItemView_right_icon, -1);
            showLeftIcon = typedArray.getBoolean(R.styleable.SettingItemView_show_left_icon, true);
            showRightIcon = typedArray.getBoolean(R.styleable.SettingItemView_show_right_icon, true);
            typedArray.recycle();
        }
        LayoutInflater.from(context).inflate(R.layout.view_setting_item, this);

        tvContext = (TextView) findViewById(R.id.tvContext);
        ivLeftIcon = (ImageView) findViewById(R.id.ivLeftIcon);

        tvRightText = (TextView) findViewById(R.id.tvRightText);
        ivRightIcon = (ImageView) findViewById(R.id.ivRightIcon);


        if (left != null) {
            tvContext.setText(left);
        }
        if (right != null) {
            tvRightText.setText(right);
        }
        if (image != -1) {
            ivLeftIcon.setImageResource(image);
        }
        if (rightImage != -1) {
            ivRightIcon.setImageResource(rightImage);
        }

        ivLeftIcon.setVisibility(showLeftIcon ? VISIBLE : GONE);
        ivRightIcon.setVisibility(showRightIcon ? VISIBLE : GONE);
    }

    public void setRightIconVisibility(boolean visible) {
        ivRightIcon.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setRightTextVisibility(boolean visible) {
        tvRightText.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setRightImageResource(int resource) {
        if (resource != 0) {
            ivRightIcon.setImageResource(resource);
        }
    }

    public void setRightTextColor(int textColor) {
        tvRightText.setTextColor(textColor);
    }

    public void setRightText(String str) {
        tvRightText.setText(str);
    }

    public void setLeftIconVisibility(boolean visible) {
        ivLeftIcon.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setLeftTextVisibility(boolean visible) {
        tvContext.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setLeftImageResource(int resource) {
        if (resource != 0) {
            ivLeftIcon.setImageResource(resource);
        }
    }

    public void setLeftText(String str) {
        tvContext.setText(str);
    }

    public void setLeftTextColor(int textColor) {
        tvContext.setTextColor(textColor);
    }
}
