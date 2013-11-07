import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;




public class AppletJasper extends JApplet {
	public Button btnPrint = new Button("Imprimir");
	public static JasperReport jasperReport;
	public static JasperPrint jasperPrint;
	public static JRPrintPage jreJRPrintPage;
	public static JasperDesign jasperDesign;  
	public static JasperPrintManager jasperPrintManager;  
	//public static String reportTemplateUrl = "/home/jhonfx/exampleticket.jrxml";
	public static String reportTemplateUrl = "exampleticket.jrxml";
	
	
	
	
	
	public void init() {
		System.out.println("iniciando applet");
		
		final Properties prop = new Properties();
		
		this.add(btnPrint);
        btnPrint.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(null, "click al boton");
            	
        	  ShipmentTicket stk = new ShipmentTicket();
          	  try {
          		  prop.load(new FileInputStream("config.properties"));
          		  System.out.println(prop.getProperty("nameJasper"));
          		  Map<String, Object> parameters = new HashMap<>();
          		  parameters.put("serie", stk.getSerie());
          		  parameters.put("razonSocial", stk.getRazonSocial());
          		  parameters.put("direccion", stk.getDireccion());
          		  parameters.put("colindantes", stk.getColindantes());
          		  parameters.put("provincia", stk.getProvincia());
          		  parameters.put("telefonos", stk.getTelefonos());
          		  parameters.put("telmex", stk.getTelmex());
          		  parameters.put("referencia", stk.getReferencia());
          		  parameters.put("almacen", stk.getAlmacen());
          		  parameters.put("medio", stk.getMedio());
          		  parameters.put("horario", stk.getHorario());
          		  parameters.put("clientes", stk.getClientes());
          		  parameters.put("numeroExtraño", stk.getNumeroExtraño());
          		  parameters.put("lote", stk.getLote());
          		  parameters.put("embarque", stk.getEmbarque());
          		  //jasperDesign = JRXmlLoader.load(reportTemplateUrl);
          		  jasperReport = JasperCompileManager.compileReport(prop.getProperty("nameJasper"));
          		  jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
          		  //JasperViewer.viewReport(jasperPrint);
          		  JasperPrintManager.printReport(jasperPrint, true);
          	  } catch (Exception ex) {
          		JOptionPane.showMessageDialog(null, ex);
          		  ex.printStackTrace();          		  
          	  }
            	//checkWebPermission();
            }
        });
            	
	}
	
//	void checkWebPermission() {
//		final SecurityManager sm = System.getSecurityManager();
//		
//		if (null == sm)
//			throw new RuntimeException("Security manager is null"); 
//		
//		sm.checkPermission(new SocketPermission("www.google.com", "connect"));
//		System.out.println("Got permission to connect.");
//	}
	
	public void paint(Graphics g) {
        g.draw3DRect(1, 1, getSize().width - 3, getSize().height - 3, false);
    }
	
	public void stop() {}

}
