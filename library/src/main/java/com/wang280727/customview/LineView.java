package com.wang280727.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

public class LineView extends LinearLayout {
    private RelativeLayout lineLay;
    private int lineColor = 0xffdddddd;

    public LineView(Context context) {
        this(context, null);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LineView);
            lineColor = typedArray.getColor(R.styleable.LineView_line_color, lineColor);
            typedArray.recycle();
        }
        LayoutInflater.from(context).inflate(R.layout.view_line, this);

        lineLay = findViewById(R.id.lineLay);
        lineLay.setBackgroundColor(lineColor);
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        lineLay.setBackgroundColor(lineColor);
    }
}
