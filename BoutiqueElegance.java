import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoutiqueElegance {
    private static Scanner teclado;
    private static int contador = 10;
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        Prenda[] inventario = {
            new Prenda("Vestido de Noche", "Diseñador A", 2022, 150.0),
            new Prenda("Camisa Casual", "Diseñador B", 2021, 50.0),
            new Prenda("Pantalón Deportivo", "Diseñador C", 2023, 70.0),
            new Prenda("Chaqueta de Cuero", "Diseñador D", 2020, 200.0),
            new Prenda("Falda Elegante", "Diseñador A", 2022, 80.0),
            new Prenda("Blusa de Seda", "Diseñador B", 2021, 60.0),
            new Prenda("Abrigo de Invierno", "Diseñador E", 2023, 300.0),
            new Prenda("Traje de Baño", "Diseñador F", 2023, 40.0),
            new Prenda("Sandalias de Verano", "Diseñador A", 2022, 35.0),
            new Prenda("Zapatos de Tacón", "Diseñador B", 2021, 120.0)
        };

        int opcion;
        boolean salir = false;

        do{
            mostrarMenuPrincipal();
            opcion = teclado.nextInt(); 

            switch (opcion) {
            case 1:
                do{
                System.out.println("Ingresa el nombre del diseñador");
                String nombre = teclado.nextLine();
                ArrayList<Prenda> prendasEncontradas = consultarDisenador(inventario, nombre);
                System.out.println("Prendas encontradas para " + nombre + ":");
                for (Prenda prenda : prendasEncontradas) {
                    System.out.println("Prenda: " + prenda.getNombrePrenda() + ", Año: " + prenda.getAnioColeccion() + ", Precio: " + prenda.getPrecio());
                }

                System.out.println("¿Deseas buscar otro diseñador? (si/no)");
                String respuesta = teclado.next();
                if(respuesta.equals("si")){
                    salir = false;
                }else{
                    salir = true;
                }
               }while(!salir);
                salir = false;
                break;
            case 2:
                double total = calcularTotal(inventario);
                System.out.println("El precio total de todos los articulos es de: "+total);
                break;
            case 3:
            if(contador < inventario.length){
                System.out.println("Ingresa el nombre de la prenda");
                String nombrePrenda = teclado.nextLine();

                System.out.println("Ingresa el nombre del disenador");
                String nombreDisenador = teclado.nextLine();

                System.out.println("Ingresa el año de coleccion");
                int anio = teclado.nextInt();

                System.out.println("Ingresa el precio");
                double precio = teclado.nextDouble();
                teclado.nextLine();

                inventario[contador] = new Prenda(nombrePrenda, nombreDisenador, anio, precio);
                contador++; // Incrementar el contador
                System.out.println("Prenda agregada exitosamente.");

            }else {
                System.out.println("El inventario está lleno. No se pueden agregar más prendas.");
            }
                break;
            case 4:
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
        System.out.println(" 4.- Salir ");
        System.out.println("Ingrese la opcion correspondiente ");
    }

    public static ArrayList<Prenda> consultarDisenador(Prenda[] inventario, String disenador){
        ArrayList<Prenda> resultado = new ArrayList<>();

         for (Prenda prenda : inventario) {
            if (prenda.getDisenador().equalsIgnoreCase(disenador)) {
                resultado.add(prenda);
            }
        }

        return resultado;
    }
}
