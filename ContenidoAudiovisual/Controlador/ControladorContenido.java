package controlador;
import modelo.Pelicula;
import util.CSVUtil;
import vista.VistaConsola;
import java.util.List;
public class ControladorContenido {
    private VistaConsola vista;
    public ControladorContenido(VistaConsola vista) {
        this.vista = vista;
    }
    public void iniciar() {
        vista.mostrarBienvenida();
        List<Pelicula> peliculas = CSVUtil.leerPeliculasDesdeCSV("data/peliculas.csv");
        vista.mostrarPeliculas(peliculas);
    }
}
