package com.bin.david.smartchart.adapter;

import android.content.res.Resources;
import android.graphics.DashPathEffect;
import android.support.annotation.Nullable;

import com.bin.david.smartchart.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.daivd.chart.core.PieChart;
import com.daivd.chart.data.ChartData;
import com.daivd.chart.provider.component.level.LevelLine;
import com.daivd.chart.data.PieData;
import com.daivd.chart.data.style.FontStyle;
import com.daivd.chart.data.style.PointStyle;
import com.daivd.chart.legend.ILegend;
import com.daivd.chart.provider.component.mark.MsgMarkView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang on 2017/10/13.
 */

public class RotateChartListAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    

    public RotateChartListAdapter(@Nullable List<String> data) {
        super(R.layout.item_rotate_chart, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
      PieChart pieChart =  helper.getView(R.id.pieChart);
      Resources res = mContext.getResources();
      FontStyle.setDefaultTextSpSize(mContext,12);
      List<String> groupData = new ArrayList<>();
      groupData.add("华北");
      groupData.add("华中");
      groupData.add("华东");
      groupData.add("华西");


      List<PieData> pieDatas = new ArrayList<>();


      PieData columnData1 = new PieData("华北","℃",res.getColor(R.color.arc1),20d);
      PieData columnData2 = new PieData("华中","℃",res.getColor(R.color.arc2),15d);
      PieData columnData3 = new PieData("华东","℃",res.getColor(R.color.arc3),25d);
      PieData columnData4 = new PieData("华西","℃",res.getColor(R.color.arc21),5d);
      pieDatas.add(columnData1);
      pieDatas.add(columnData2);
      pieDatas.add(columnData3);
      pieDatas.add(columnData4);
      ChartData<PieData> chartData = new ChartData<>("饼图",groupData,pieDatas);
      pieChart.setShowChartName(true);
      //设置标题样式
      FontStyle fontStyle = pieChart.getChartTitle().getTextStyle();
      fontStyle.setTextColor(res.getColor(R.color.arc3));
      fontStyle.setTextSpSize(mContext,15);
      pieChart.getProvider().setOpenMark(true);
      pieChart.getProvider().setMarkView(new MsgMarkView(mContext));
      pieChart.getLegend().getLegendStyle().setShape(PointStyle.CIRCLE);
      pieChart.getLegend().setLegendDirection(ILegend.TOP);
      pieChart.setRotate(true);
      pieChart.setChartData(chartData);
      pieChart.startChartAnim(1000);
    }
}