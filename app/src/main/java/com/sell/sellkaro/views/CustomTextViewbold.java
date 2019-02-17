package com.sell.sellkaro.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.sell.sellkaro.R;


/**
 * Created by Rish on 30/06/2015.
 */
public class CustomTextViewbold extends android.support.v7.widget.AppCompatTextView {

    Context context;

    public CustomTextViewbold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    public CustomTextViewbold(Context context) {
        super(context);
        this.context = context;
        init(null);
    }

    public CustomTextViewbold(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);

    }

    public void init(AttributeSet attr) {

        if (attr != null) {
            TypedArray a = getContext().obtainStyledAttributes(attr, R.styleable.CustomTextView);
            String fontName = a.getString(R.styleable.CustomTextView_TextSize);

//            if (fontName != null) {
//                if (fontName.equals("TITLE_TEXT")) {
//                    this.setTextSize( 5.8f);
//                } else if (fontName.equals("DES_TEXT")) {
//
//                    this.setTextSize( 4.5f);
//                } else if (fontName.equals("NORMAL_TEXT")) {
//
//                    this.setTextSize(5);
//                }
//
//            }

            Typeface face = Typeface.createFromAsset(getContext().getAssets(),"fonts/ProximaNovaBold.otf" +
                    "");
            this.setTypeface(face);
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
