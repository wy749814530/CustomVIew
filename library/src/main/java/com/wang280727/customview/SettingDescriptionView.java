package com.wang280727.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingDescriptionView extends RelativeLayout {
    String titleString, descriptionString;
    int titleSize = 17, descriptionSize = 13;
    int leftIcon, rightIcon;
    int titleColor = 0xff333333;
    int descriptionColor = 0xff666666;
    TextView tvTitleView, tvDescriptionView;
    ImageView ivRightIcon;
    RCImageView ivLeftIcon;
    boolean showLeftIcon = true, showRightIcon = true;
    private int leftIconCorner = 0;

    public SettingDescriptionView(Context context) {
        this(context, null);
    }

    public SettingDescriptionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingDescriptionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SettingDescriptionView);

            titleString = typedArray.getString(R.styleable.SettingDescriptionView_title_Text);
            descriptionString = typedArray.getString(R.styleable.SettingDescriptionView_description_Text);
            titleColor = typedArray.getColor(R.styleable.SettingDescriptionView_title_Text_color, titleColor);
            descriptionColor = typedArray.getColor(R.styleable.SettingDescriptionView_description_text_color, descriptionColor);
            titleSize = typedArray.getDimensionPixelSize(R.styleable.SettingDescriptionView_title_Text_size, titleSize);
            descriptionSize = typedArray.getColor(R.styleable.SettingDescriptionView_description_text_size, descriptionSize);
            leftIconCorner = typedArray.getInt(R.styleable.SettingDescriptionView_left_icon_corner, leftIconCorner);

            leftIcon = typedArray.getResourceId(R.styleable.SettingDescriptionView_left_icon, -1);
            rightIcon = typedArray.getResourceId(R.styleable.SettingDescriptionView_right_icon, -1);
            showLeftIcon = typedArray.getBoolean(R.styleable.SettingDescriptionView_show_left_icon, true);
            showRightIcon = typedArray.getBoolean(R.styleable.SettingDescriptionView_show_right_icon, true);
            typedArray.recycle();
        }


        LayoutInflater.from(context).inflate(R.layout.view_setting_description, this);

        tvTitleView = findViewById(R.id.tv_title_view);
        tvDescriptionView = findViewById(R.id.tv_description_view);
        ivLeftIcon = findViewById(R.id.iv_left_icon);
        ivRightIcon = findViewById(R.id.iv_right_icon);

        if (titleString != null) {
            tvTitleView.setText(titleString);
        }

        if (descriptionString != null) {
            tvDescriptionView.setText(descriptionString);
        }

        tvTitleView.setTextSize(titleSize);
        tvDescriptionView.setTextSize(descriptionSize);

        tvTitleView.setTextColor(titleColor);
        tvDescriptionView.setTextColor(descriptionColor);

        if (leftIcon != -1) {
            ivLeftIcon.setImageResource(leftIcon);
        }

        if (leftIconCorner == 1) {
            ivLeftIcon.setRoundAsCircle(true);
        } else if (leftIconCorner == 2) {
            ivLeftIcon.setRadius(5);
        }

        if (rightIcon != -1) {
            ivRightIcon.setImageResource(rightIcon);
        }

        ivLeftIcon.setVisibility(showLeftIcon ? VISIBLE : GONE);
        ivRightIcon.setVisibility(showRightIcon ? VISIBLE : GONE);
    }


    public void setTitleSize(int titleSize) {
        this.titleSize = titleSize;
        tvTitleView.setTextSize(titleSize);
    }

    public void setDescriptionSize(int descriptionSize) {
        this.descriptionSize = descriptionSize;
        tvDescriptionView.setTextSize(descriptionSize);
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
        tvTitleView.setTextColor(titleColor);
    }

    public void setDescriptionColor(int descriptionColor) {
        this.descriptionColor = descriptionColor;
        tvDescriptionView.setTextColor(descriptionColor);
    }

    public void setTitleString(String titleString) {
        this.titleString = titleString;
        tvTitleView.setText(titleString);
    }

    public void setDescriptionString(String descriptionString) {
        this.descriptionString = descriptionString;
        tvDescriptionView.setText(descriptionString);
    }

    public void setLeftIcon(int leftIcon) {
        this.leftIcon = leftIcon;
        ivLeftIcon.setImageResource(leftIcon);
    }

    public void setRightIcon(int rightIcon) {
        this.rightIcon = rightIcon;
        ivRightIcon.setImageResource(rightIcon);
    }

    public void setShowLeftIcon(boolean showLeftIcon) {
        this.showLeftIcon = showLeftIcon;
        ivLeftIcon.setVisibility(showLeftIcon ? VISIBLE : GONE);
    }

    public void setShowRightIcon(boolean showRightIcon) {
        this.showRightIcon = showRightIcon;
        ivRightIcon.setVisibility(showRightIcon ? VISIBLE : GONE);
    }
}
