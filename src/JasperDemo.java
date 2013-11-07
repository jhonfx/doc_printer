/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.HorizontalAlignEnum;
import net.sf.jasperreports.engine.type.PrintOrderEnum;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jhonfx
 */
public class JasperDemo {

  /**
   * @param args the command line arguments
   */
  
  ;
  
  public static JasperReport jasperReport;
  public static JasperPrint jasperPrint;
  public static JRPrintPage jreJRPrintPage;
  public static JasperDesign jasperDesign;  
  public static JasperPrintManager jasperPrintManager;
  
  public static String reportTemplateUrl = "/home/jhonfx/exampleticket.jrxml";
  
  
  
  public static void main(String[] args) {
	  ShipmentTicket stk = new ShipmentTicket();
	  try {
		  Map parameters = new HashMap<>();
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
		  jasperDesign = JRXmlLoader.load(reportTemplateUrl);
		  jasperReport = JasperCompileManager.compileReport(reportTemplateUrl);
		  jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		  //JasperViewer.viewReport(jasperPrint);
		  jasperPrintManager.printReport(jasperPrint, true);
	  } catch (Exception ex) {
		  ex.printStackTrace();
	  }
	   
  }
    
}
