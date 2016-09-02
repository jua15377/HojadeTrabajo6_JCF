
public class developer {
    private String nombre;
    private String tipo;
    private int identificador;
    public  developer(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public int getIdentificador(){
        return identificador;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
