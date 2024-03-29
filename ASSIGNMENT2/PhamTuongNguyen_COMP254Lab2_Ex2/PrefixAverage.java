/**
 * Author: Pham Tuong Nguyen
 * ID: 30128505
 * Assignment 2 - Algorithm Analysis
 * Exercise 2
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

class PrefixAverage {

  /**
   * Returns an array a such that, for all j, a[j] equals the average of x[0],
   * ..., x[j].
   */
  public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n]; // filled with zeros by default
    for (int j = 0; j < n; j++) {
      double total = 0; // begin computing x[0] + ... + x[j]
      for (int i = 0; i <= j; i++)
        total += x[i];
      a[j] = total / (j + 1); // record the average
    }
    return a;
  }

  /**
   * Returns an array a such that, for all j, a[j] equals the average of x[0],
   * ..., x[j].
   */
  public static double[] prefixAverage2(double[] x) {
    int n = x.length;
    double[] a = new double[n]; // filled with zeros by default
    double total = 0; // compute prefix sum as x[0] + x[1] + ...
    for (int j = 0; j < n; j++) {
      total += x[j]; // update prefix sum to include x[j]
      a[j] = total / (j + 1); // compute average based on current sum
    }
    return a;
  } 

  public static void main(String[] args) {
    int[] sizes = { 100, 500, 1000, 10000, 20000};
    XYSeries series1 = new XYSeries("prefixAverage1");
    XYSeries series2 = new XYSeries("prefixAverage2");

    // Test prefixAverage1. Time complexity is O(n^2)
    System.out.println("prefixAverage1");
    for (int size : sizes) {
      double[] x = new double[size];
      for (int i = 0; i < size; i++) {
        x[i] = i;
      }
      long startTime = System.currentTimeMillis();
      prefixAverage1(x);
      long endTime = System.currentTimeMillis();
      long duration = endTime - startTime;
      series1.add(size, duration);
      System.out.println("Length of array: " + size + ", " + duration + "ms");
    }

    // Test prefixAverage2. Time complexity is O(n)
    System.out.println("\nprefixAverage2");
    for (int size : sizes) {
      double[] x = new double[size];
      for (int i = 0; i < size; i++) {
        x[i] = i;
      }
      long startTime = System.currentTimeMillis();
      prefixAverage2(x);
      long endTime = System.currentTimeMillis();
      long duration = endTime - startTime;
      series2.add(size, duration);
      System.out.println("Length of array: " + size + ", " + duration + "ms");
    }
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(series1);
    dataset.addSeries(series2);

    JFreeChart chart = ChartFactory.createXYLineChart(
        "Running Time of prefixAverage1 and prefixAverage2",
        "Input Size",
        "Running Time in milliseconds",
        dataset);

    XYPlot plot = (XYPlot) chart.getPlot();
    NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
    yAxis.setLowerBound(-5);
    
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    chartPanel.setMouseWheelEnabled(true);

    javax.swing.JFrame frame = new javax.swing.JFrame("Running Time Analysis");
    frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(chartPanel);
    frame.pack();
    frame.setVisible(true);
  }
}
