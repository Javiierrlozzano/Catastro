/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;


import HOME.Estadisticas;
import VISTA.FAMILIA2;
import VISTA.FAMILIA3;
import java.io.File;

import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import org.w3c.dom.Attr;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

import java.sql.ResultSet;

import java.util.Vector;


import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;/*
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;*/
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.CDATASection;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


/**
 *
 * @author JAVIER
 */
public class GENERAL_CLASS {
    
    public void AbrirJInternalFrame(JInternalFrame Windows ,JDesktopPane Panel,MySQL_Query QuerySQL, boolean ActivarPanel){
         try{
            JInternalFrame[] pruebas = Panel.getAllFrames();
            if (pruebas.length == 0) {
             
                 Windows.setVisible(true);
                 Panel.add(Windows);
            }
            for (int i = 0; i < pruebas.length; i++) {
            //Cada vez que se cree un InternalFrame Se tiene que hacer esta funcion.
            if (!Windows.isVisible() ) {
               if (Windows.getClass() == Estadisticas.class) {
                    
                    if (!Windows.isVisible()) {
                       Windows= new Estadisticas(); 
                       Windows.setVisible(true);
                       Panel.add(Windows);
                   }
                   
                } /*if  (Windows.getClass()== CrearUsuario.class){
                       if (!Windows.isVisible()) {
                       Windows= new CrearUsuario(QuerySQL,ActivarPanel); 
                       Windows.setVisible(true);
                       Panel.add(Windows);
                   
                }if  (Windows.getClass()== FAMILIA3.class){
                       if (!Windows.isVisible()) {
                       Windows= new FAMILIA3(QuerySQL,ActivarPanel); 
                       Windows.setVisible(true);
                       Panel.add(Windows);
                   }
                }
                if  (Windows.getClass()== FAMILIA2.class){
                       if (!Windows.isVisible()) {
                       Windows= new FAMILIA2(QuerySQL,ActivarPanel); 
                       Windows.setVisible(true);
                       Panel.add(Windows);
                   }
                }}*/
              
            }
         else{
                System.out.println("ventana abierta ");
            }
            }
        }catch(Exception ex){
            System.out.println("error " +ex);
        }
    }
    
    //Funcion para agregar nueva fila en JTable con Enter
    public void AgregarDatosJTableArry(JTable table,Object arry[] ){
        DefaultTableModel  modelo ;
        modelo =(DefaultTableModel) table.getModel();
        modelo.addRow(arry);
    }//probandos
    public void  newRowJTable(JTable table,java.awt.event.KeyEvent evt){
        DefaultTableModel  modelo =(DefaultTableModel) table.getModel();
        try {
            if (evt.getKeyCode() ==127) {
                int rows = table.getSelectedRow();
           modelo.removeRow(rows);
        }
        }catch(Exception ex ){
            System.out.println(ex.getMessage());
        }
    }
    //Cambiar Fondos
     public void cambiar_fondo(JLabel Fondo_claro, String img) {
        Icon Imagenes = new ImageIcon(getClass().getResource(img));
        Fondo_claro.setIcon(Imagenes);
    }
    //Funcion para abrir ventanas 
    public void OpenWindows(JFrame win, JPanel x){
        try{
      if( win.isVisible() ==false){
        win.setVisible(true);
       win.setLocationRelativeTo(null);
      }else{
          JOptionPane.showMessageDialog(x, "La ventana Esta Abierta");
      }
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
   
    }
    public void GeneralKMl(String NombreRuta,String Latitud[] ,String Longitud[],JPanel x) {
  String ruta="src\\CLASES\\"+NombreRuta+".kml";
         try{ 
             //Examina para guardar
    JFileChooser guardar = new JFileChooser(); 
    FileNameExtensionFilter as = new FileNameExtensionFilter("KMl","kml");
    guardar.setName(NombreRuta+".kml");
    guardar.setFileFilter(as);
    guardar.showSaveDialog(null);
    guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    File archivo = guardar.getSelectedFile();
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      
        
         //Elemento raíz
      Document doc = docBuilder.newDocument();
      doc.setXmlVersion("1.0");
      Element rootElement = doc.createElement("kml");
       Attr RootAtri = doc.createAttribute("xmlns");
       RootAtri.setNodeValue("http://www.opengis.net/kml/2.2");
       rootElement.setAttributeNode(RootAtri);
      doc.appendChild(rootElement);
      //Etiqueta Document 
       Element Document = doc.createElement("Document");
       rootElement.appendChild(Document);
       //Name
        Element Name = doc.createElement("name");
        Name.setTextContent(NombreRuta);
        Document.appendChild(Name);
       
        //Descripcion 
        Element description = doc.createElement("description");
      Document.appendChild(description);
       //Style normal
      Element Style = doc.createElement("Style");
      Document.appendChild(Style);
      Attr attr = doc.createAttribute("id");
      attr.setValue("line-FFD600-2938-nodesc-normal");
      Style.setAttributeNode(attr);
      //LineStyle
       Element LineStyle = doc.createElement("LineStyle");
      Style.appendChild(LineStyle);
      Element color = doc.createElement("color");
      color.setTextContent("ff00d6ff");
      LineStyle.appendChild(color);
      //WIDTH
       Element width = doc.createElement("width");
      width.setTextContent("4.407");
      LineStyle.appendChild(width);
      //BalloonStyle
      Element BalloonStyle = doc.createElement("BalloonStyle");
      Style.appendChild(BalloonStyle);
      //text
      Element text = doc.createElement("text");
      BalloonStyle.appendChild(text);
      //CDATA
      CDATASection CDATA = doc.createCDATASection("<h3>$[name]</h3>");
      text.appendChild(CDATA);
      
      //Style highlight
       Element Style1 = doc.createElement("Style");
      Document.appendChild(Style1);
      Attr Atribu = doc.createAttribute("id");
      Atribu.setValue("line-FFD600-2938-nodesc-highlight");
      Style1.setAttributeNode(Atribu);
      //LineStyle
       Element LineStyle1 = doc.createElement("LineStyle");
      Style1.appendChild(LineStyle1);
      Element color1 = doc.createElement("color");
      color1.setTextContent("ff00d6ff");
      LineStyle1.appendChild(color1);
      //WIDTH
       Element Wint2 = doc.createElement("width");
      Wint2.setTextContent("4.407");
      LineStyle1.appendChild(Wint2);
      //BalloonStyle
      Element BalloonStyle1 = doc.createElement("BalloonStyle");
      Style1.appendChild(BalloonStyle1);
      //text
      Element text1 = doc.createElement("text");
      BalloonStyle1.appendChild(text1);
      //CDATA
      CDATASection Data1 = doc.createCDATASection("<h3>$[name]</h3>");
      text1.appendChild(Data1);
      
      //StyleMap
        Element StyleMap = doc.createElement("StyleMap");
      Document.appendChild(StyleMap);
      Attr Atributos = doc.createAttribute("id");
      Atributos.setValue("line-FFD600-2938-nodesc");
      StyleMap.setAttributeNode(Atributos);
      
      //Pair normal
      Element Pair = doc.createElement("Pair");
      StyleMap.appendChild(Pair);
      //key
       Element key = doc.createElement("key");
       key.setTextContent("normal");
      Pair.appendChild(key);
      //styleUrl
         Element styleUrl = doc.createElement("styleUrl");
       styleUrl.setTextContent("#line-FFD600-2938-nodesc-normal");
      Pair.appendChild(styleUrl);
          //Pair highlight
      Element Pairhighlight = doc.createElement("Pair");
      StyleMap.appendChild(Pairhighlight);
      //key
       Element keyhighlight = doc.createElement("key");
       keyhighlight.setTextContent("highlight");
      Pairhighlight.appendChild(keyhighlight);
      //styleUrl
         Element styleUrlhighlight = doc.createElement("styleUrl");
       styleUrlhighlight.setTextContent("#line-FFD600-2938-nodesc-highlight");
      Pairhighlight.appendChild(styleUrlhighlight);
      
      //Folder
        Element Folder = doc.createElement("Folder");
      Document.appendChild(Folder);
      
      //name 
      Element nam = doc.createElement("name");
      nam.setTextContent(NombreRuta+".kml");
      Folder.appendChild(nam);
      //Placemark
      Element Placemark = doc.createElement("Placemark");
      Folder.appendChild(Placemark);
      //Name
      Element nam1 = doc.createElement("name");
      nam1.setTextContent(NombreRuta);
      Placemark.appendChild(nam1);
      
      //StyUleurl
      Element StyURL = doc.createElement("styleUrl");
      StyURL.setTextContent("#line-FFD600-2938-nodesc");
      Placemark.appendChild(StyURL);
      
      //LineString 
       Element LineString = doc.createElement("LineString");
       Placemark.appendChild(LineString);
       //tessellate
       Element tessellate = doc.createElement("tessellate");
      tessellate.setTextContent("1");
      LineString.appendChild(tessellate);
      
       //coordinates
        Element coordinates = doc.createElement("coordinates");
        String Cordenadas=""; 
            for (int i = 0; i < Latitud.length; i++) {
                Cordenadas +=Longitud[i]+","+Latitud[i]+",0";
            }
      coordinates.setTextContent(Cordenadas);
      
      LineString.appendChild(coordinates);
       
      
    //Se escribe el contenido del XML en un archivo
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      
      
      StreamResult result = new StreamResult( archivo + ".kml");
      transformer.transform(source, result);
        
        }catch(Exception ex){
        
        }
   
        
    }
    //Crear WebViwer JavaFX 
    public void CrearWebViwe(String web){
    //Se crea nueva clase para crear Web Viwer Java FX
        WebViwer ts = new WebViwer();
        ts.CrearWeb(web);
    }
    
    //Actualizar Table con select 
    public void ActualizarTableSelect(  JTable table){
         DefaultTableModel  modelo ;
        try{
         modelo =(DefaultTableModel) table.getModel();
         table.changeSelection(DISPOSE_ON_CLOSE, DISPOSE_ON_CLOSE, true, true);
         
        }
        catch(Exception x){
            System.out.print("Error al llenar "+x.getMessage());
        }
    }
    
    /*
    //Informes
    public void Informes(String path,Map hm ){
        try{
           
        CONEXION_MySQL conn = new CONEXION_MySQL();
        JasperReport reporte = null;
        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
        JasperPrint jprint = JasperFillManager.fillReport(path, hm,conn.Conexion());
        JasperViewer view = new JasperViewer(jprint,false);
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        view.setVisible(true);
        }catch(JRException ex)
        {JOptionPane.showMessageDialog(null,"Error Crear Informe" + ex.getMessage());}
    
    
    }*/
    //Cambio de colores Claro
    public void CambiarColoresClaro(JPanel panelesColor[],Color ColorJPanel[],JTextField Text[],JPanel CabeceraVenta,JLabel ex[], Color JPanelColores,Color CabeceraCabesera){
    int Pabe =panelesColor.length;
        for (int i = 0; i < Pabe; i++) {
            panelesColor[i].setBackground(ColorJPanel[i]);
        }
    }
     //Cambio de colores Oscuro
    public void CambiarColoresOscuro(JPanel panelesColor[],JTextField Text[],JPanel CabeceraVenta,JLabel ex[], Color JPanelColores,Color CabeceraCabesera,Color JLabel){
    
    }
     //Funcion para limpiar las casillas de textos 

 public void LimpiarTodo(Object todo[]	){
     for (int i = 0; i < todo.length; i++) {
         if (todo[i].getClass() ==JTextField.class) {
             JTextField ex = (JTextField) todo[i];
             ex.setText("");
         }if (todo[i].getClass() ==JCheckBox.class) {
             JCheckBox chk= (JCheckBox)todo[i];
             chk.setSelected(false);
         }if (todo[i].getClass() ==JTable .class) {
             JTable Table = (JTable) todo[i];
            DefaultTableModel modelo =(DefaultTableModel) Table.getModel();
            modelo.setRowCount(0);
         }if (todo[i].getClass() ==JComboBox .class) {
             JComboBox com = (JComboBox) todo[i];
             com.setSelectedIndex(0);//
         }
     }
     
 }

     //Permitir Solo numeros
    public void  SoloNumeros(java.awt.event.KeyEvent evt,JPanel x){
    char validar = evt.getKeyChar();
       if ( Character.isLetter(validar)){
        evt.consume();
       JOptionPane.showMessageDialog(x, "Ingresar solo Numero");
       } 
    }
     //Cerrar con la text ESC
    public void CerrarWindowsKey(java.awt.event.KeyEvent evt ,JFrame x){
    int  cerrar = evt.getKeyCode();
   
        if (27 == cerrar ){
           int close =  ValdarCerrar();
                if(close == 0){
                    x.setVisible(false);
                }
        }
    }
       //Agregar datos JFieldText de MySQL
    public void TextLlenarSQL(ResultSet resultado,JTextField Text[]){
    int in = Text.length;
        try { while(resultado.next()){
                for (int i = 0; i < in; i++) {
                    Text[i].setText(resultado.getString(i+1));
                }
            }
        }catch(Exception ex ){
            System.out.println(ex.getMessage());
        }
        
    }
        public void AgregarDatosComboboxMysql(JComboBox [] Combobox,ResultSet rs,int indicador){
        try {
            int TotalCombox = Combobox.length;
            for (int i = 0; i < TotalCombox; i++) {
                Combobox[i].removeAllItems(); 
                Combobox[i].addItem("Seleccionar");
                Combobox[i].setSelectedIndex(0);
            }
            while(rs.next()){
                for (int j = 0; j < TotalCombox;j++) {
                    Combobox[j].addItem(rs.getString(j+indicador));
                }
            }
        }
        catch(Exception ex){
        
        }
        }
      //Agregar datos ComboBox de MySQL
    public void AgregarDatosCombobox(JComboBox Combobox,ResultSet rs, int enteros){
        try {
            Combobox.removeAllItems();
            Combobox.addItem("Seleccionar");
            Combobox.setSelectedIndex(0);
            while(rs.next()){
                Combobox.addItem(rs.getString(enteros));
            }
        }
        catch(Exception ex){
        
        }
        
    }
 
    //Insertar Imagenes a un Label 
      public void InsertarImagenLabel(byte[] imagen, JLabel Label){
            if (imagen.length != 0 || imagen !=null ) {
            try{
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(imagen);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                
                Label.setIcon(imgi);
            }catch(IOException ex){ 
                JOptionPane.showMessageDialog(null,"Error insertar Imagen "+ ex.getMessage()); 
            }
        }else{
            Label.setText("No hay Foto");
        }
    } 
    
      //Agregar Resultados en Tablas de MySQL
    public void AgregarTable(JTable Table , int Colum[], ResultSet rs ){
         DefaultTableModel  modelo ;
        try{
         modelo =(DefaultTableModel) Table.getModel();
         modelo.setRowCount(0);
         while(rs.next()){
            Vector v = new Vector();
            for (int i = 0; i < Colum.length; i++) {
              v.add(rs.getString(Colum[i]));
                 } 
            modelo.addRow(v);
            }
        }
        catch(Exception x){
            System.out.print("Error al llenar "+x.getMessage());
        }
    }
    //Solo mayusculas
    public void Mayus(JTextField text){
     text.setText (text.getText().toUpperCase());
    }
    //Valir cerrar
    public int ValdarCerrar(){
        int conf = JOptionPane.showConfirmDialog(null, "¿Realmente quiere cancelar?", 
                "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return conf ;
    }
    //Validar Vacios Text
    public boolean VaciosText(JTextField Text[]){
       boolean Valirdat = true;
        int in = Text.length;
        for (int i = 0; i < in; i++) {
            if (Text[i].getText().length()==0) {
                 Valirdat=false;
                break;
            }
        }
        return Valirdat;
    }
     //Validar Vacios Combobox
    public boolean VaciosCombobox(JComboBox[] ListComx){
       boolean Valirdar = true;
        int in = ListComx.length;
        for (int i = 0; i < in; i++) {
            if (ListComx[i].getSelectedIndex() ==0) {
                 Valirdar=false;
                break;
            }
        }
        return Valirdar;
    }
    //Buscar datos JTable
    public String[] DatosJTable(JTable table ){
          String valor[] = new String [table.getColumnCount()];
        try{
             if(table.isEnabled()){
        int seleccion =   table.getSelectedRow()  ;
        for (int i = 0; i < table.getColumnCount(); i++) {
            if ( table.getValueAt(seleccion, i) !=null) {
                 valor[i] = table.getValueAt(seleccion, i).toString();
            }
            }
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error Llamar Datos Tabla "+ex.getMessage());
        }
        return valor;
       
    }
    //Funciones para IMAGENES
    public File  Exan(JPanel x){
            File rutas =null;
        try {
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        j.setFileFilter(fil);
        
        int s = j.showOpenDialog(x);
        if(s == JFileChooser.APPROVE_OPTION){
            String ruta = j.getSelectedFile().getAbsolutePath();
             rutas = new File(ruta);
              return rutas;
        }
        
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    
        
        return rutas; 
    }
    public byte[] AgregarImagenBit(File ruta){
       byte [] icono =null;
         try{
             if(ruta != null){
                 icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
             System.out.print(icono);
              System.out.print(" ");
             }
        }catch(Exception ex){
             System.out.print("Error en Convertir ");
        }
         return icono;
    }
}

