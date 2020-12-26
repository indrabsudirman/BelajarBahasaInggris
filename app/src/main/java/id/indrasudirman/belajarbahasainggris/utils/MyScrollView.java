package id.indrasudirman.belajarbahasainggris.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MyScrollView  extends ScrollView {

    public OnScrollViewListener mListener;

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        // TODO Auto-generated method stub
        super.onScrollChanged(l, t, oldl, oldt);
        if (mListener != null) {
            mListener.onScrollChanged1(mListener);
        }
    }

    public void setOnScrollViewListener(OnScrollViewListener listener) {
        mListener = listener;
    }
    public static interface OnScrollViewListener {
        public void onScrollChanged1(OnScrollViewListener listener);
    }
}
