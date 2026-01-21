import modelos.Alumno;
import modelos.Colegio;
import modelos.Curso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PruebasPracticaEvaluable1 {
    public static void main(String[] args) {
        Colegio colegio1 = new Colegio();
        colegio1.setIdentificador(1);
        colegio1.setNombre("Safa Reyes");
        colegio1.setDireccion("Calla Calatrava");
        colegio1.setFechaFundacion(LocalDate.of(1980, 10, 10));

        List<Alumno> alumnos1 = new ArrayList<Alumno>();
        colegio1.setAlumnos(alumnos1);

        Alumno alumno1 = new Alumno();
        alumno1.setIdentificador(1);
        alumno1.setDni("77934073E");
        alumno1.setNombre("Anderson");
        alumno1.setApellidos("Olivos Gamarra");
        alumno1.setCurso(Curso.CICLOS);
        alumno1.setFechaNacimiento(LocalDate.of(2001,10,13));

        alumnos1.add(alumno1);

        System.out.println(colegio1);
    }
}
