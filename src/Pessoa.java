public class Pessoa {
    protected String nome;
    protected String area;
    protected String matricula;

    public Pessoa(String nome,String matricula,String area){
        this.nome=nome;
        this.matricula=matricula;
        this.area=area;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getArea() {
        return area;
    }

}