package soprafamrv.ARCHIVOS_EXP;

/**
 *
 * @author Cri
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import soprafamrv.BD.Conexion;
 

public class GeneratePDF {
    // Se crea el documento
    Document documento = new Document(PageSize.A4);    
    int[] CANTIDADXMES = new int[12];
    int[] MESES = {1,2,3,4,5,6,7,8,9,10,11,12};

    public void crearDocumento(String NombrePDF) throws DocumentException, FileNotFoundException{
        System.out.println("INICIO DENTRO DE CLASE GENERATEPDF EN METODO CREARDOCUMENTO");
        // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
        FileOutputStream ficheroPdf = new FileOutputStream(NombrePDF+".pdf");
        // Se asocia el documento al OutputStream y se indica que el espaciado entre
        // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
        PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
        // Se abre el documento.
        documento.open();
         System.out.println("TERMINO DENTRO DE CLASE GENERATEPDF EN METODO CREARDOCUMENTO");
    }
                
    //ESTO LO TENGO Q TRABAJAR Y TRATAR DE COPIAR IGUAL QUE LA TABLA
    public void ContenidoDocumento(String Encabezado, String Subtitulo, String TIPO, ResultSet InformacionPersonal, ResultSet ContenidoServicios) throws DocumentException, SQLException{
        //Agregando Encabezado
        Paragraph paragraph = new Paragraph(Encabezado, FontFactory.getFont(FontFactory.COURIER,16,Font.BOLD));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraph);
        
        documento.add(new Paragraph("\n"));
        
        //Agregando Subtitulo
        Paragraph paragraph1 = new Paragraph(Subtitulo, FontFactory.getFont(FontFactory.COURIER_BOLD,14,Font.BOLD));
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraph1);
        
        //documento.add(new Paragraph(Encabezado));
        documento.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------"));
        while (InformacionPersonal.next()){
            documento.add(new Paragraph("NUMERO ORDEN DE TRABAJO : " +InformacionPersonal.getString("idot"), FontFactory.getFont(FontFactory.COURIER,10,Font.NORMAL)));
            documento.add(new Paragraph("NUMERO ORDEN DE TRABAJO : " +InformacionPersonal.getString("fechainicio"), FontFactory.getFont(FontFactory.COURIER,10,Font.NORMAL)));
            documento.add(new Paragraph("PATENTE VEHICULO        : " +InformacionPersonal.getString("patente"), FontFactory.getFont(FontFactory.COURIER,10,Font.NORMAL)));
            documento.add(new Paragraph("MECANICO                : " +InformacionPersonal.getString("mecnombre")+ " " +InformacionPersonal.getString("mecapepa")+ " " +InformacionPersonal.getString("mecamema"), FontFactory.getFont(FontFactory.COURIER,10,Font.NORMAL)));
            documento.add(new Paragraph("ADMINISTRADOR           : " +InformacionPersonal.getString("adnombre")+ " " +InformacionPersonal.getString("adapepa")+ " " +InformacionPersonal.getString("adamema"), FontFactory.getFont(FontFactory.COURIER,10,Font.NORMAL)));    
        }
        documento.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------"));
        Paragraph paragraph2 = new Paragraph(TIPO,FontFactory.getFont(FontFactory.COURIER_BOLD,12,Font.BOLD));
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraph2);
        documento.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------"));
        documento.add(new Paragraph("N U M E R O  S E R V I C I O      -      T I P O  S E R V I C I O      -      O B S E R V A C I O N E S", FontFactory.getFont(FontFactory.COURIER_BOLD,8,Font.BOLD)));
        documento.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------"));
        while (ContenidoServicios.next()){
            documento.add(new Paragraph(ContenidoServicios.getString("id_servicio")+ "  " +ContenidoServicios.getString("nombre"), FontFactory.getFont(FontFactory.COURIER,10,Font.NORMAL)));
            documento.add(new Paragraph("____________________________________________________________________________"));
            documento.add(new Paragraph("____________________________________________________________________________"));
        }
        documento.add(new Paragraph(" "));
        documento.add(new Paragraph("\n--------------------------------------------------------------------------------------------------------------------------------"));
        /*documento.add(new Paragraph("Este es el segundo y tiene una fuente rara",
				FontFactory.getFont("gisha",   // fuente
				12,                            // tamaño
				Font.NORMAL)));                 // estilo
				//BaseColor.CYAN)));             // color
         * 
         */
        documento.close();
        
        }
    public void ContenidoInformeVehiculos(String Encabezado, String Subtitulo, String TIPO, ResultSet InformacionVehiculos, ResultSet Graficos) throws DocumentException, SQLException{
        //Agregando Encabezado
        Paragraph paragraph = new Paragraph(Encabezado, FontFactory.getFont(FontFactory.COURIER,16,Font.BOLD));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraph);
        
        documento.add(new Paragraph("\n"));
        
        //Agregando Subtitulo
        Paragraph paragraph1 = new Paragraph(Subtitulo, FontFactory.getFont(FontFactory.COURIER_BOLD,14,Font.BOLD));
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraph1);
        
        //documento.add(new Paragraph(Encabezado));
        documento.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------"));
        while (InformacionVehiculos.next()){
            documento.add(new Paragraph(InformacionVehiculos.getString("patente")+ " " +InformacionVehiculos.getString("chasis")+ " " +InformacionVehiculos.getString("marca")+ " " +InformacionVehiculos.getString("modelo")+ " " +InformacionVehiculos.getString("ano"), FontFactory.getFont(FontFactory.COURIER,10,Font.NORMAL)));
            
        }
        documento.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------"));
        Paragraph paragraph2 = new Paragraph(TIPO,FontFactory.getFont(FontFactory.COURIER_BOLD,12,Font.BOLD));
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraph2);
        documento.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------"));
        documento.add(new Paragraph("G R A F I C O   E S T A D I S T I C O", FontFactory.getFont(FontFactory.COURIER_BOLD,8,Font.BOLD)));
        documento.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------"));
        
        //DESDE AQUI DEBO COMENZAR A TRABAJAR CON EL GRAFICO
      
        while (Graficos.next()){
            documento.add(new Paragraph(Graficos.getString("patente")+ "  " +Graficos.getString("marca"), FontFactory.getFont(FontFactory.COURIER,10,Font.NORMAL)));
            documento.add(new Paragraph("____________________________________________________________________________"));
            documento.add(new Paragraph("____________________________________________________________________________"));
        }
        documento.add(new Paragraph(" "));
        documento.add(new Paragraph("\n--------------------------------------------------------------------------------------------------------------------------------"));
        documento.close();
        
        
    }
    
    public void ContenidoInformeRepuestos(String Encabezado, String Subtitulo, String TIPO, int ANO) throws DocumentException, SQLException{
        //Agregando Encabezado
        Paragraph paragraph = new Paragraph(Encabezado, FontFactory.getFont(FontFactory.COURIER,16,Font.BOLD));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraph);
        
        documento.add(new Paragraph("\n"));
        
        //Agregando Subtitulo
        Paragraph paragraph1 = new Paragraph(Subtitulo, FontFactory.getFont(FontFactory.COURIER_BOLD,14,Font.BOLD));
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        documento.add(paragraph1);
    
        //desde aqui debo trabajar        
        documento.close();
        for (int x=0; x<MESES.length; x++){        
            System.out.println("Dentro del FOR");            
            String query = "Select sum(cd.cantidad)TOTAL_AÑO, r.nombre, r.marca from compra_detalle cd, repuesto r, compra c where cd.nro_factura = c.nro_factura and cd.id_repuesto = r.id_repuesto and c.fecha_compra between to_date('1-' || "+MESES[x]+" || '-' || "+ANO+",'dd-mm-yyyy') and to_date(last_day(to_date('28-' || "+MESES[x]+" || '-' || "+ANO+",'dd-mm-yyyy'))) group by r.nombre, r.marca";            
            ResultSet rs = Conexion.ejecutarQuery(query);            
            int cantidad_inicial = 0;
            int cantidad_final = 0;
            while(rs.next()){
                System.out.println("Dentro del WHILE n° " +x);
                System.out.println("CANTIDAD EN: " +x+ " CANTIDAD: " +rs.getString("TOTAL_AÑO"));
                cantidad_inicial = Integer.parseInt(rs.getString("TOTAL_AÑO"));
                cantidad_final = cantidad_inicial + cantidad_final;                                                                          
            }
            System.out.println("\nEN EL MES: " +x+ " del año: " +ANO+ "  se sumaron: " +cantidad_final+ " repuestos");
            CANTIDADXMES[x] = cantidad_final;
            
            //CANTIDADXMES[x] = String.valueOf(cantidad_final);
            //System.out.println("Cantidad Final:" +CANTIDADXMES[x]);
            
            //System.out.println("IMPRIMIENDO MES DE: " +MESES[x]+ " mas su cantidad total por año de " +CANTIDADXMES[x]);
            
            System.out.println("SALI del WHILE");
            
        }
        System.out.println("TERMINO LA EJECUCION");
        
        
        
        
    }
    
    
    
}
