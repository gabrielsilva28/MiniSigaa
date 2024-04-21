
public class DisciplinaCursada {

    protected String disciplinaCursada;
    protected double nota;

    public DisciplinaCursada(String disciplinaCursada,double nota){
        this.disciplinaCursada=disciplinaCursada;
        this.nota=nota;
    }

    public String getDisciplinaCursada() {
        return disciplinaCursada;
    }

    public void setDisciplinaCursada(String disciplinaCursada) {
        this.disciplinaCursada = disciplinaCursada;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "DisciplinaCursada{" +
                "disciplinaCursada=" + disciplinaCursada +
                ", nota=" + nota +
                '}';
    }



}


