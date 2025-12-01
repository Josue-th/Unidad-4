import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {
    public static List<Pelicula> leerPeliculasDesdeCSV(String archivoRuta) {
        List<Pelicula> peliculas = new ArrayList<>();
        
        // Uso de try-with-resources para cerrar BufferedReader y FileReader automáticamente
        try (BufferedReader br = new BufferedReader(new FileReader(archivoRuta))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                // Asegura que haya exactamente 3 campos
                if (datos.length == 3) {
                    String titulo = datos[0].trim();
                    String genero = datos[2].trim();
                    int duracion = -1; // Valor por defecto
                    
                    try {
                        // Intenta convertir el String a int
                        duracion = Integer.parseInt(datos[1].trim());
                        
                        // Si la conversión fue exitosa, crea el objeto Pelicula
                        peliculas.add(new Pelicula(titulo, duracion, genero));
                        
                    } catch (NumberFormatException nfe) {
                        // Manejo robusto: Ignora la línea con formato de número incorrecto
                        System.err.println("Error de formato de número en la duración de la película: " + titulo + ". Línea saltada.");
                    }
                }
            } // Fin del while
        } catch (IOException e) {
            // Manejo de errores de archivo
            e.printStackTrace();
        }
        
        return peliculas;
    }
}