package ExamenPrueba;

public class TestExamen {
    public static void main(String[] args) {
        Festivo festivo1 = new FestivoImpl("Semana Santa", "abril");
        Poblacion poblacion1 = new PoblacionImpl("Sevilla", 1942389, 14.036, 200, 200, festivo1);

        System.out.println(poblacion1);
    }
}
