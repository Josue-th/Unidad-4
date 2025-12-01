import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {
    public static List<Pelicula> leerPeliculasDesdeCSV(String archivoRuta) {
        List<Pelicula> peliculas = new ArrayList<>();
        
        // Uso de try-with-resources para asegurar el cierre de recursos
        try (BufferedReader br = new BufferedReader(new FileReader(archivoRuta))) {
            String linea;
            
            // Suponiendo que el archivo no tiene encabezado. Si lo tiene, use br.readLine(); aquí.
            
            while ((linea = br.readLine()) != null) {
                // Utiliza .trim() en la línea antes de split para evitar problemas con espacios iniciales/finales
                String[] datos = linea.trim().split(",");
                
                if (datos.length == 3) {
                    String titulo = datos[0].trim();
                    String genero = datos[2].trim();
                    int duracion = -1; // Valor predeterminado en caso de fallo de conversión

                    // 🛑 PUNTO DE CORRECCIÓN: Manejo de la NumberFormatException
                    try {
                        // Intenta la conversión, limpiando el espacio antes
                        duracion = Integer.parseInt(datos[1].trim()); 
                        
                        // Si la conversión es exitosa, se añade la película
                        peliculas.add(new Pelicula(titulo, duracion, genero));
                        
                    } catch (NumberFormatException nfe) {
                        System.err.println("❌ ERROR de formato de duración en la línea: " + titulo + ". Valor ('" + datos[1].trim() + "') no es un entero. Línea saltada.");
                    }
                } else {
                    System.err.println("⚠️ ADVERTENCIA: Línea no procesada debido a un número incorrecto de campos (se esperan 3): " + linea);
                }
            }
        } catch (IOException e) {
            // Manejo de errores de Archivo (p. ej., archivo no encontrado)
            System.err.println("🛑 ERROR leyendo archivo: " + archivoRuta + ". Mensaje: " + e.getMessage());
        }
        
        return peliculas;
    }
}