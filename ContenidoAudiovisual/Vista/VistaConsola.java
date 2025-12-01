import java.util.List;

public class VistaConsola {
    public void mostrarBienvenida() {
        System.out.println("=== Sistema de Contenidos Audiovisuales ===");
    }

    public void mostrarPeliculas(List<? extends Contenido> contenidos) {
        for (Contenido c : contenidos) {
            System.out.println(c);
        }
    }
}