package ud.prog3.Comunio;

import java.awt.Color; 
import java.awt.BasicStroke; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import java.awt.Toolkit;

public class XYLineChart_AW extends ApplicationFrame
{ 
	public XYLineChart_AW( String nombreJugador, int numeroJornadas )
{
    super("Datos del jugador");
    setIconImage(Toolkit.getDefaultToolkit().getImage(XYLineChart_AW.class.getResource("/ud/prog3/Comunio/img/comunioIcono.jpg")));
    JFreeChart xylineChart = ChartFactory.createXYLineChart(
    	"Estadisticas del jugador" ,
       "Jornada" ,
       "Puntos" ,
       createDataset(nombreJugador, numeroJornadas) ,
       PlotOrientation.VERTICAL ,
       true , true , false);
       
    ChartPanel chartPanel = new ChartPanel( xylineChart );
    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
    final XYPlot plot = xylineChart.getXYPlot( );
    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
    renderer.setSeriesPaint( 0 , Color.BLACK );
   
    renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
    
    plot.setRenderer( renderer ); 
    setContentPane( chartPanel ); 
 }
 
// private XYDataset createDataset(  )
// {
//    final XYSeries firefox = new XYSeries( "Firefox" );          
//    firefox.add( 1.0 , 1.0 );          
//    firefox.add( 2.0 , 4.0 );          
//    firefox.add( 3.0 , 3.0 );          
//    final XYSeries chrome = new XYSeries( "Chrome" );          
//    chrome.add( 1.0 , 4.0 );          
//    chrome.add( 2.0 , 5.0 );          
//    chrome.add( 3.0 , 6.0 );          
//    final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
//    iexplorer.add( 3.0 , 4.0 );          
//    iexplorer.add( 4.0 , 5.0 );          
//    iexplorer.add( 5.0 , 4.0 );          
//    final XYSeriesCollection dataset = new XYSeriesCollection( );          
//    dataset.addSeries( firefox );          
//    dataset.addSeries( chrome );          
//    dataset.addSeries( iexplorer );
//    return dataset;
// }
	
	
	 private XYDataset createDataset( String nombreJugador, int numeroJornadas )//hay que poner un bucle for con las jornadas que haya
	 {
	    final XYSeries jugador = new XYSeries( nombreJugador ); 
	    
	    jugador.add( 1.0 , 1.0 );          
	    jugador.add( 2.0 , 4.0 );          
	    jugador.add( 3.0 , 3.0 );      
	    jugador.add( 4.0 , 2.0 );    
	    jugador.add( 5.0 , 7.0 );    
	    jugador.add( 6.0 , 15.0 );    
	    jugador.add( 7.0 , 3.0 );    
	    jugador.add( 8.0 , 32.0 );    
	    jugador.add( 9.0 , 20.0 );    
	    
	          
	    final XYSeriesCollection dataset = new XYSeriesCollection( );          
	    dataset.addSeries( jugador );          
	    
	    return dataset;
	 }
	

 public static void main( String[ ] args ) 
 {
    XYLineChart_AW chart = new XYLineChart_AW("Cristiano Ronaldo",9);
    chart.pack( );          
    RefineryUtilities.centerFrameOnScreen( chart );          
    chart.setVisible( true ); 
 }
 
 
 public int puntosJornada()
 {
	 Statement st=null;
	 st=BasesDeDatos.getStatement();
	 
	 String consulta="select * from jugadores";
	 try {
		ResultSet rs=st.executeQuery(consulta);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 return 0;
 }
}


