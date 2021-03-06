package com.example.farmigosample;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

public class YourMarkerView extends MarkerView {
    private TextView tvContent;
    public YourMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        // find your layout components
        tvContent = (TextView) findViewById(R.id.tvContent);
    }
    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        String LabelSelected=MainActivity.dataSets.get(highlight.getDataSetIndex()).getLabel();
        tvContent.setText(LabelSelected+"\n"+e.getY());
        // this will perform necessary layouting
        super.refreshContent(e, highlight);
    }
    private MPPointF mOffset;
    @Override
    public MPPointF getOffset() {
        mOffset = new MPPointF(-(getWidth() / 2f), -getHeight());
        return mOffset;
    }
}