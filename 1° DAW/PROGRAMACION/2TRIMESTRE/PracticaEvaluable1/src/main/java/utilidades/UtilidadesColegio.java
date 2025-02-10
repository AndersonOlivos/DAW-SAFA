package utilidades;

import modelos.Alumno;
import modelos.Colegio;
import modelos.Curso;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesColegio {

    public static Integer totalAlumnos(List<Colegio> colegios){
        Integer total = 0;
        for (Colegio colegio : colegios){
            if(colegio.getAlumnos() != null) {
                total = total + colegio.getAlumnos().size();
            }
        }
        return total;
    }

    public static List<Alumno> mayoresEdad(Colegio colegio){
        List<Alumno> alumnos = new ArrayList<Alumno>();
        for (Alumno alumno : colegio.getAlumnos()){
            if(alumno.getFechaNacimiento() != null) {
                Integer edadAlumno = Period.between(alumno.getFechaNacimiento(), LocalDate.now()).getYears();
                if (edadAlumno >= 18 && alumno.getCurso() == Curso.CICLOS) {
                    alumnos.add(alumno);
                }
            }
        }
        return alumnos;
    }

    public static Map<Colegio, Integer> totalAlumnosPorColegio(List<Colegio> colegios){
        Map<Colegio, Integer> alumnos = new HashMap<Colegio, Integer>();
        for (Colegio colegio : colegios){
            if(colegio.getAlumnos().size()>0){
                alumnos.put(colegio, colegio.getAlumnos().size());
            }
        }
        return alumnos;
    }

    public static Map<Curso, List<Alumno>> alumnosPorCurso(Colegio colegio){
        Map<Curso, List<Alumno>> alumnos = new HashMap<>();
        for(Alumno alumno : colegio.getAlumnos()){
            if(alumnos.containsKey(alumno.getCurso())){
                alumnos.get(alumno.getCurso()).add(alumno);
            } else {
                alumnos.put(alumno.getCurso(), new ArrayList<>(List.of(alumno)));
            }
        }
        return alumnos;
    }

}
