package No1;


// 使用了 jFreeChart 的第三方库
// 包含 jcommon jfreechart 两个 jar 已放在 jars 文件夹中
// Author : Sonder Lau 199050418
// Created : 2020 / 04 / 13
// 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class DispersionOfFunctionCurves {

    public static void main(String[] args) {

        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
        mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
        mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));

        ChartFactory.setChartTheme(mChartTheme);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "y = -2 t sin (t^2) 的离散点绘制", // chart title
                "t", // x axis label
                "y", // y axis label
                getCollection(), // data
                PlotOrientation.VERTICAL,
                false, // include legend
                false, // tooltips
                false // urls
        );


        XYPlot plot = (XYPlot) chart.getPlot();


        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        // 设置连线不可见
        renderer.setSeriesLinesVisible(0, false);

        plot.setRenderer(renderer);


        // 窗口设置
        ChartFrame frame = new ChartFrame("函数曲线的离散化 by 刘柏田", chart);
        frame.pack(); // fit window to figure size
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static XYSeriesCollection getCollection (){
        XYSeriesCollection result = new XYSeriesCollection();

        // 因为画在了一张表上 故只有4个 delta


        //* 0.01
        XYSeries mFirst = new XYSeries("First");
        for (double x = 0; x <= 8;  x += 0.01) {
            double y = -2*x* Math.sin(x*x);
            mFirst.add(x, y);
        }

        //* 0.1
        XYSeries mSecond = new XYSeries("Second");
        for (double x = 0; x <= 8;  x += 0.1) {
            double y = -2*x* Math.sin(x*x);
            mSecond.add(x, y);
        }

        //* 0.5
        XYSeries mThird = new XYSeries("Third");
        for (double x = 0; x <= 8;  x += 0.5) {
            double y = -2*x* Math.sin(x*x);
            mThird.add(x, y);
        }

        //* 1
        XYSeries mForth = new XYSeries("Forth");
        for (double x = 0; x <= 8;  x += 1) {
            double y = -2*x* Math.sin(x*x);
            mForth.add(x, y);
        }


        result.addSeries(mFirst);
        result.addSeries(mSecond);
        result.addSeries(mThird);
        result.addSeries(mForth);

        return result;

    }


}
