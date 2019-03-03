package assignment;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/* DrawMultiGraph2JavaFX.java  
 *  
 * this is a function which use JavaFX library to draw the graph to show
 *
 *  
 *
 */
public class DrawGraphJavaFX{

	
	static List<String> a = new ArrayList<String>();
	static List<Double> b = new ArrayList<Double>();

	public DrawGraphJavaFX(List<String> a, List<Double> b) {
		this.a = a;
		this.b = b;
		
	}
  public static void initFX(JFXPanel p,List<String> a, List<Double> b){
	final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    xAxis.setLabel("Date");
    final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis); 

    lineChart.setTitle("Line Chart");
    XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
    series.setName("volumn");
    // populating the series with data
    for(int i = 0;i<a.size();i++) {
    	series.getData().add(new XYChart.Data<String, Number>(a.get(i),b.get(i)));
    }
    Scene scene = new Scene(lineChart, 800, 600);
    lineChart.getData().add(series);

    p.setScene(scene);
 
  }
  
  private static void initAndShowGUI(List<String> a, List<Double> b) {
      // This method is invoked on Swing thread
      JFrame frame = new JFrame("Volumn");
      frame.setSize(400, 400);
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension dim = tk.getScreenSize();
//      frame.setSize(dim.width/4, dim.height/4);
      frame.setLocation(new Point(dim.width*3/4, dim.height*3/4));
		
      final JFXPanel fxPanel = new JFXPanel();
      frame.add(fxPanel);
      frame.setVisible(true);

      Platform.runLater(new Runnable() {
          @Override
          public void run() {
              initFX(fxPanel,a,b);
          }
      });
  }
 
  public static void main(String [] args) {
	  SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
              initAndShowGUI(a,b);
          }
      });	
  }
}