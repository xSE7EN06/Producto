/**
 * Prenda
 */
public class Prenda {

    private String nombrePrenda;
    private String disenador;
    private int anioColeccion;
    private double precio;

    public Prenda(String nombrePrenda, String disenador, int anioColeccion, double precio){
        this.nombrePrenda = nombrePrenda;
        this.disenador = disenador;
        this.anioColeccion = anioColeccion;
        this.precio = precio;
    }

    public String getNombrePrenda(){
        return this.nombrePrenda;
    }

    public String getDisenador(){
        return this.disenador;
    }

    public int getAnioColeccion(){
        return anioColeccion;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setNombrePrenda(String nombrePrenda){
        this.nombrePrenda = nombrePrenda;
    }

    public void setDisenador (String disenador){
        this.disenador = disenador;
    }

    public void setAnioColeccion(int anioColeccion){
        this.anioColeccion = anioColeccion;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }
}