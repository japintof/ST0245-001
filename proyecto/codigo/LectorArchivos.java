import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LectorArchivos
{
  public void leerCSV(){
      ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
      Path FilePath = Paths.get("C:\\CSV\\test.csv");
      try{
          BufferedReader br = Files.newBufferedReader(FilePath);
          String linea;
          while((linea = br.readLine()) !=null){
              String[]datosLinea = linea.split(";");
              ArrayList<String> datosTemporal = new ArrayList<String>();
              for (String dato : datosLinea){
                  datosTemporal.add(dato);
                }
                datos.add(datosTemporal);
        }
     }  catch (IOException e) {
            e.printStackTrace();
        }
 }
        
}