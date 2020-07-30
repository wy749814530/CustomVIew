package com.wang280727.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @WYU-WIN
 * @date 2020/7/27 0027.
 * description：
 */
public class PasswordEditView extends RelativeLayout {
    private String TAG = getClass().getSimpleName();
    private String hintString = "";
    private String textString = "";
    private int textColor = 0xff333333;
    private int textSize = 17;
    private int inputType = 129; // 密码
    private int maxLength = 20;
    private int left_icon = -1, clear_icon = -1, eye_open_icon = -1, eye_close_icon = -1;

    private ImageView ivLeftImageView, ivClearImageView, ivEyeImageView;
    private EditText edPasswordView;

    public PasswordEditView(Context context) {
        this(context, null);
    }

    public PasswordEditView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PasswordEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PasswordEditView);

            hintString = typedArray.getString(R.styleable.PasswordEditView_android_hint);
            textString = typedArray.getString(R.styleable.PasswordEditView_android_text);
            textColor = typedArray.getColor(R.styleable.PasswordEditView_android_textColor, textColor);
            textSize = typedArray.getDimensionPixelSize(R.styleable.PasswordEditView_android_textSize, textSize);
            inputType = typedArray.getInt(R.styleable.PasswordEditView_android_inputType, inputType);
            maxLength = typedArray.getColor(R.styleable.PasswordEditView_android_maxLength, maxLength);

            left_icon = typedArray.getResourceId(R.styleable.PasswordEditView_left_icon, -1);
            clear_icon = typedArray.getResourceId(R.styleable.PasswordEditView_clear_icon, -1);
            eye_open_icon = typedArray.getResourceId(R.styleable.PasswordEditView_eye_open_icon, -1);
            eye_close_icon = typedArray.getResourceId(R.styleable.PasswordEditView_eye_close_icon, -1);
            typedArray.recycle();
        }


        LayoutInflater.from(context).inflate(R.layout.view_password_edit, this);

        edPasswordView = findViewById(R.id.ed_password_view);
        ivLeftImageView = findViewById(R.id.iv_left_icon);
        ivClearImageView = findViewById(R.id.iv_vlear);
        ivEyeImageView = findViewById(R.id.iv_eye);
        if (left_icon == -1) {
            ivLeftImageView.setVisibility(GONE);
        } else {
            ivLeftImageView.setImageResource(left_icon);
        }

        if (clear_icon == -1) {
            ivClearImageView.setVisibility(GONE);
        } else {
            ivClearImageView.setImageResource(clear_icon);
        }
        if (eye_open_icon == -1 || eye_close_icon == -1) {
            ivEyeImageView.setVisibility(GONE);
        } else {
            ivEyeImageView.setImageResource(eye_close_icon);
        }

        edPasswordView.setInputType(inputType);
        if (hintString != null) {
            edPasswordView.setHint(hintString);
        }
        if (!TextUtils.isEmpty(textString)) {
            edPasswordView.setHint(textString);
        }

        edPasswordView.setTextColor(textColor);
        edPasswordView.setTextSize(textSize);
        edPasswordView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        initListener();
    }

    private void initListener() {
        ivClearImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                edPasswordView.setText("");
            }
        });

        ivEyeImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("open".equals(ivEyeImageView.getTag())) {//设置密文
                    ivEyeImageView.setTag("close");
                    ivEyeImageView.setImageResource(eye_close_icon);
                    edPasswordView.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {//设置明文
                    ivEyeImageView.setTag("open");
                    ivEyeImageView.setImageResource(eye_open_icon);
                    edPasswordView.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }

    public void setTextString(String textString) {
        edPasswordView.setText(textString);
    }

    public String getTextString() {
        return edPasswordView.getText().toString();
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        edPasswordView.setTextColor(textColor);
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        edPasswordView.setTextSize(textSize);
    }

    public void setHintString(String hintString) {
        this.hintString = hintString;
        edPasswordView.setHint(hintString);
    }

    public void setInputType(int inputType) {
        this.inputType = inputType;
        edPasswordView.setInputType(inputType);
    }


}
