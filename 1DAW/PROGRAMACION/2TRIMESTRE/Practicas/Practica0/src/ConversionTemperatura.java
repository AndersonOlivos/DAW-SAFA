public class ConversionTemperatura {
    public static void main(String[] args) {
        Double temperaturaC = 20.0;
        System.out.println("Temperatura en Celsius: " + temperaturaC);
        System.out.println("Temperatura en Farenheit: " + convertidorCaF(temperaturaC));
    }

    public static Double convertidorCaF(Double celsius){
        return (celsius * 9/5 + 32);
    }
}
