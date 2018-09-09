package com.test.franer.editfocusdemo;

import android.content.Context;
import android.util.AttributeSet;

public class MyEditText extends android.support.v7.widget.AppCompatEditText {

    private SelectionChangedListener mSelectionChangedListener;

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (mSelectionChangedListener != null) {
            mSelectionChangedListener.onSelectionChanged(selStart, selEnd);
        }
    }

    interface SelectionChangedListener {
        void onSelectionChanged(int selStart, int selEnd);
    }

    public void addSelectionChangedListener(SelectionChangedListener listener) {
        mSelectionChangedListener = listener;
    }
}
