import java.util.Objects;

public class PersonajeMarvelImpl implements PersonajeMarvel {
    private String nombre; //consultable y modificable
    private String alias; //consultable
    private Boolean esHeroe; //consultable y modificable
    private String poderPrincipal; //consultable y modificable
    private String afiliacion; //consultable y modificable
    private Double poder; //consultable y modificable

    public PersonajeMarvelImpl() {
    }

    public PersonajeMarvelImpl(String nombre, String alias, Boolean esHeroe, String poderPrincipal, String afiliacion, Double poder) {
        this.nombre = nombre;
        this.alias = alias;
        this.esHeroe = esHeroe;
        this.poderPrincipal = poderPrincipal;
        this.afiliacion = afiliacion;
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public Boolean getEsHeroe() {
        return esHeroe;
    }

    public void setEsHeroe(Boolean esHeroe) {
        this.esHeroe = esHeroe;
    }

    public String getPoderPrincipal() {
        return poderPrincipal;
    }

    public void setPoderPrincipal(String poderPrincipal) {
        this.poderPrincipal = poderPrincipal;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public Double getPoder() {
        return poder;
    }

    public void setPoder(Double poder) {
        this.poder = poder;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonajeMarvelImpl that = (PersonajeMarvelImpl) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(alias, that.alias) && Objects.equals(esHeroe, that.esHeroe) && Objects.equals(poderPrincipal, that.poderPrincipal) && Objects.equals(afiliacion, that.afiliacion) && Objects.equals(poder, that.poder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, alias, esHeroe, poderPrincipal, afiliacion, poder);
    }

    @Override
    public String toString() {
        return alias + " (" + nombre + "). Su poder principal es el " + poderPrincipal.toLowerCase()
                + ".\nSu afiliación, " + afiliacion + ". " + (esHeroe ? "Es Heroe" : "No es un heroe")
                + ". Su poder es de " + poder + ".";
    }
}
