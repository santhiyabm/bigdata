/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigdemo;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class PieChart extends ApplicationFrame 
{
   public PieChart( String title ) 
   {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   private static PieDataset createDataset( ) 
   {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Amazon" , new Double( Integer.parseInt(NewJFrame.price.get(0).toString())) );  
      dataset.setValue( "Shopcules" , new Double( Integer.parseInt(NewJFrame.price.get(1).toString()) ) );   
      dataset.setValue( "Snapdeal" , new Double( Integer.parseInt(NewJFrame.price.get(2).toString()) ) );    
      dataset.setValue( "Flipkart" , new Double( Integer.parseInt(NewJFrame.price.get(3).toString()) ) );  
      dataset.setValue( "Ebay" , new Double( Integer.parseInt(NewJFrame.price.get(4).toString()) ) );  
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         Home.name,  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel( )
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
   public static void main( String[ ] args )
   {
      PieChart demo = new PieChart( Home.name );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}
