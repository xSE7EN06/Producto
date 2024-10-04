import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BoutiqueElegance {
    private static Scanner teclado;
    private static ArrayList<Prenda> inventario = new ArrayList<>();
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
         // Inicializar el inventario con algunas prendas
         inventario.add(new Prenda("Vestido de Noche", "Angel", 2022, 150.0));
         inventario.add(new Prenda("Camisa Casual", "Diego", 2021, 50.0));
         inventario.add(new Prenda("Pantalón Deportivo", "Diego", 2023, 70.0));
         inventario.add(new Prenda("Chaqueta de Cuero", "Ana", 2020, 200.0));
         inventario.add(new Prenda("Falda Elegante", "Juan", 2022, 80.0));
         inventario.add(new Prenda("Blusa de Seda", "Juan", 2021, 60.0));
         inventario.add(new Prenda("Abrigo de Invierno", "Marcelo", 2023, 300.0));
         inventario.add(new Prenda("Traje de Baño", "Marcelo", 2023, 40.0));
         inventario.add(new Prenda("Sandalias de Verano", "Fernando", 2022, 35.0));
         inventario.add(new Prenda("Zapatos de Tacón", "Ana", 2021, 120.0));

        int opcion;
        boolean salir = false;

        do{
            mostrarMenuPrincipal();
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
            case 1:
            do {
                System.out.println("Ingresa el nombre del diseñador");
                String nombre = teclado.nextLine();
                
                ArrayList<Prenda> prendasEncontradas = consultarDisenador(nombre);
                
                if (prendasEncontradas.isEmpty()) {
                    System.out.println("No se encontraron prendas para el diseñador " + nombre + ".");
                } else {
                    System.out.println("Prendas encontradas para " + nombre + ":");
                    for (Prenda prenda : prendasEncontradas) {
                        System.out.println("Prenda: " + prenda.getNombrePrenda() + ", Año: " + prenda.getAnioColeccion() + ", Precio: " + prenda.getPrecio());
                    }
                }
            
                System.out.println("¿Deseas buscar otro diseñador? (si/no)");
                String respuesta = teclado.next();
                salir = !respuesta.equalsIgnoreCase("si"); // Simplificando la lógica
            } while (!salir);
            salir = false;
                break;
            case 2:
                double total = calcularTotal();
                System.out.println("El precio total de todos los articulos es de: "+total);
                break;
            case 3:
                System.out.println("Ingresa el nombre de la prenda");
                String nombrePrenda = teclado.nextLine();

                System.out.println("Ingresa el nombre del disenador");
                String nombreDisenador = teclado.nextLine();

                System.out.println("Ingresa el año de coleccion");
                int anio = teclado.nextInt();

                System.out.println("Ingresa el precio");
                double precio = teclado.nextDouble();
                teclado.nextLine();

                Prenda objPrenda = new Prenda(nombrePrenda, nombreDisenador, anio, precio);
                inventario.add(objPrenda); // Agregar la nueva prenda al ArrayList
                System.out.println("Prenda agregada con éxito.");
                break;
            case 4:
            ordenarPorAnio();
            salir = false;
                break;
            case 5:
            salir = true;
                break;
                default:
                System.out.println("No existe el valor favor de intentar de nuevo.");
                salir = false;
                break;
            }
        }while(!salir);
        mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n---------------------------------------");
        System.out.println("Bienvenidos a BoutiqueElegance");
        System.out.println("_______________________________________");
        System.out.println(" 1.- Realizar busqueda por diseñador");
        System.out.println(" 2.- Calcular valor total del inventario ");
        System.out.println(" 3.- Registrar nuevas prendas ");
        System.out.println(" 4.- Ordenar inventario por año ");
        System.out.println(" 5.- Salir");
        System.out.println("Ingrese la opcion correspondiente ");
    }

    public static ArrayList<Prenda> consultarDisenador(String disenador){
        ArrayList<Prenda> resultado = new ArrayList<>();

         for (Prenda prenda : inventario) {
            if (prenda.getDisenador().equalsIgnoreCase(disenador)) {
                resultado.add(prenda);
            }
        }

        return resultado;
    }

    public static double calcularTotal(){
        double tota = 0.0;

        for(Prenda prenda: inventario){
            tota += prenda.getPrecio();
        }

        return tota;
    }

     public static void ordenarPorAnio() {
        Collections.sort(inventario, new Comparator<Prenda>() {
            @Override
            public int compare(Prenda p1, Prenda p2) {
                return Integer.compare(p1.getAnioColeccion(), p2.getAnioColeccion());
            }
        });
        System.out.println("Inventario ordenado por año.");
        mostrarInventario(); // Método para mostrar el inventario
    }

    public static void mostrarInventario() {
        for (Prenda prenda : inventario) {
            if (prenda != null) { 
                System.out.println("Prenda: " + prenda.getNombrePrenda() + ", Año: " + prenda.getAnioColeccion() + ", Precio: " + prenda.getPrecio());
            }
        }
    }
}
