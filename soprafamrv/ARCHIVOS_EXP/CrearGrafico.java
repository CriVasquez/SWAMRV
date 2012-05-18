/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soprafamrv.ARCHIVOS_EXP;


import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import java.io.File;
import org.jfree.chart.plot.*;
import java.io.*;
import java.sql.ResultSet;
import org.jfree.chart.ChartFactory;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author Cri
 */
public class CrearGrafico {
    
    public void BarChart(ResultSet rs) {
        // Create a simple Bar chart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(5, "Compras", "Enero");
        dataset.setValue(7, "Compras", "Febrero");
        dataset.setValue(9, "Compras", "Marzo");
        dataset.setValue(5, "Compras", "Abril");
        dataset.setValue(10, "Compras", "Mayo");
        JFreeChart chart = ChartFactory.createBarChart("Compras realizadas", "Compras realizadas, 2007", "Numero de Compras", dataset, PlotOrientation.VERTICAL, false, true, false);
        try {
            ChartUtilities.saveChartAsJPEG(new File("/home/jose/Desktop/Barchart.jpg"), chart, 500, 300);
            } catch (IOException e) {
                System.err.println("Error creando grafico.");
                }
        }  
 


// Create a time series chart
    public void GraficoLineal(){
        org.jfree.data.time.TimeSeries pop = new org.jfree.data.time.TimeSeries("Linea de Crecimiento", Day.class);
        pop.add(new Day(2, 1, 2007), 100);
        pop.add(new Day(2, 2, 2007), 150);
        pop.add(new Day(2, 3, 2007), 200);
        pop.add(new Day(2, 4, 2007), 250);
        pop.add(new Day(2, 5, 2007), 300);
        pop.add(new Day(2, 6, 2007), 1500);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(pop);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Crecimiento Ubuntu",
                "Fecha",
                "Numero Usuarios",
                dataset,true,true,false);
        try {
            ChartUtilities.saveChartAsJPEG(new File("/home/jose/Desktop/TimeSeries.jpg"), chart, 500, 300);
            } catch (IOException e) {
                System.err.println("Error creando grafico.");
                }
        }
    
}
    

