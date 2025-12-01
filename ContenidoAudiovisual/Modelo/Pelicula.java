public class Pelicula implements Contenido {
    private String titulo;
    private int duracion;
    private String genero;

    public Pelicula(String titulo, int duracion, String genero) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public int getDuracion() {
        return duracion;
    }

    @Override
    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", genero='" + genero + '\'' +
                '}';
    }
}