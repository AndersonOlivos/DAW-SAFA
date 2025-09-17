
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.sl.modelos.*;
import com.sl.utilidades.UtilidadesGeografia;

public class UtilidadesGeografiaTest {

    private List<Pais> paises;
    private List<Continente> continentes;
    private List<Ciudad> ciudades;
    private List<ComunidadAutonoma> comunidadAutonomas;

    @BeforeEach
    void setUp() {
        Ciudad madrid = new Ciudad("Madrid", 3000000L, null, null, 604L);
        Ciudad barcelona = new Ciudad("Barcelona", 1600000L, null, null, 101L);
        Ciudad sevilla = new Ciudad("Sevilla", 900000L, null, null, 150L);

        ComunidadAutonoma madridCA = new ComunidadAutonoma("Madrid", null, List.of(madrid), 6000000L, madrid);
        ComunidadAutonoma catalunya = new ComunidadAutonoma("Cataluña", null, List.of(barcelona), 7500000L, barcelona);
        ComunidadAutonoma andalucia = new ComunidadAutonoma("Andalucía", null, List.of(sevilla), 7500000L, sevilla);


        Pais francia = new Pais("Francia", new Ciudad("París", 2200000L, null, null, 105L), new ArrayList<>(), new ArrayList<>());
        Pais espana = new Pais("España", madrid, List.of(madridCA, catalunya, andalucia), new ArrayList<>(List.of(francia)));

        madrid.setComunidadAutonoma(madridCA);
        madrid.setPais(espana);
        barcelona.setComunidadAutonoma(catalunya);
        barcelona.setPais(espana);
        madridCA.setPais(espana);
        catalunya.setPais(espana);

        espana.getComunidadesAutonomas().forEach(ca -> ca.setPais(espana));

        paises = List.of(espana, francia);
        ciudades = List.of(madrid, barcelona);
        comunidadAutonomas = List.of(madridCA, catalunya, andalucia);
        continentes = List.of(new Continente("Europa", paises));
    }

    @Test
    void testEjercicio1() {
        List<Pais> resultado = UtilidadesGeografia.ejercicio1(paises);
        assertEquals(1, resultado.size());
        assertEquals("España", resultado.get(0).getNombre());
    }

    @Test
    void testEjercicio2() {
        Map<Continente, Integer> resultado = UtilidadesGeografia.ejercicio2(continentes);
        assertEquals(1, resultado.size());
        assertEquals(2, resultado.get(continentes.get(0)));
    }

    @Test
    void testEjercicio3() {
        List<Ciudad> ciudadesPrueba = new ArrayList<>(ciudades);
        ciudadesPrueba.addAll(ciudades);
        List<Ciudad> resultado = new UtilidadesGeografia().ejercicio3(ciudadesPrueba, paises);
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(ciudades.get(0)));
    }

    @Test
    void testEjercicio4() {
        Map<Pais, Long> resultado = UtilidadesGeografia.ejercicio4(paises);
        assertEquals(2, resultado.size());
        assertEquals(5500000L, resultado.get(paises.get(0)));
        assertEquals(0L, resultado.get(paises.get(1)));
    }

    @Test
    void testEjercicio5() {
        InformePais informe = new InformePais(paises.getFirst(), 5500000L, 3, 3);
        InformePais informe2 = new InformePais(null, 15L, 1, 4);
        assertTrue(UtilidadesGeografia.ejercicio5(informe, paises.getFirst()));
        assertFalse(UtilidadesGeografia.ejercicio5(informe2, paises.getFirst()));
    }

    @Test
    void testEjercicio6() {
        InformeDetalladoPais informe = UtilidadesGeografia.ejercicio6(paises.get(0));
        assertNotNull(informe);
        assertEquals(3, informe.getExtensionComunidades().size());
        assertEquals(3, informe.getPoblacionComunidades().size());
        assertEquals(1600000L, informe.getPoblacionComunidades().get(comunidadAutonomas.get(1)));
        assertEquals(101L, informe.getExtensionComunidades().get(comunidadAutonomas.get(1)));
        assertEquals("Madrid", informe.getComunidadMasPoblada().getNombre());
        assertEquals("Madrid", informe.getComunidadDeLaCapital().getNombre());
    }
}