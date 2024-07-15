import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){

        Scanner lectura = new Scanner(System.in);
        Scanner monedaDeDestino = new Scanner(System.in);
        Scanner valorMonedaOrigen = new Scanner(System.in);
        Scanner salir = new Scanner(System.in);
        List<String> historial = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");



        while (true) {
            System.out.println("************************************************************");
            System.out.println("********* Bienvenido al conversor de Monedas ************** ");
            System.out.println("*********************** Menú *******************************");
            System.out.println("Clave      Moneda           Pais");
            System.out.println("MXN    Peso Mexicano        México");
            System.out.println("USD    Dollar Americano     Estados Unidos");
            System.out.println("EUR    Euro                 Unión Europea");
            System.out.println("BOB    Boliviano            Bolivia");
            System.out.println("BRL    Real Brasileño       Brasil");
            System.out.println("CLP    Peso Chileno         Chile");
            System.out.println("COP    Peso Colombiano      Colombia");
            System.out.println("AUD    Dollar Australiano   México");
            System.out.println("ARS    Peso Argentino       Argentina");
            System.out.println("JPY    Yen Japonés          Japón");
            System.out.println("************************************************************");
            System.out.println("************************************************************");





            System.out.println("Ingresa la clave de tu moneda");
            String nombreDeMoneda = lectura.nextLine();
            System.out.println("Ingresa el número que quieres convertir");
            Double cantidadConvertir = valorMonedaOrigen.nextDouble();

            System.out.println("Ingresa la clave de la moneda de Destino");
            String monedaDestino = monedaDeDestino.nextLine();  // Cambia esto a la moneda que quieras ver

            ConsultaMoneda consultaMoneda = new ConsultaMoneda();
            Moneda moneda = consultaMoneda.buscaMoneda(nombreDeMoneda);

            double tasaDeCambio = moneda.conversion_rates().get(monedaDestino) * cantidadConvertir;

            // Obtener la fecha y hora actuales
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            String fechaHoraFormato = fechaHoraActual.format(formatter);

            String resultado = cantidadConvertir + nombreDeMoneda + " Es igual a: "  + tasaDeCambio + monedaDestino;

            System.out.println(resultado);
            historial.add(resultado + " " +fechaHoraFormato);

            System.out.println("Salir del conversor: Presione 1");
            System.out.println("Continuar en el conversor: Presione 2");
            int salirCiclo = salir.nextInt();

            if(salirCiclo == 1){
                System.out.println("******************* Tu Historial de conversiones ******************");
                for (String conversion : historial) {
                    System.out.println(conversion);
                }

                break;
            }

        }
    }
}
