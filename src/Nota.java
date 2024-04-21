import java.util.ArrayList;

public class Nota {
    protected Disciplina disciplinaCursada;
    protected Aluno aluno;
    protected double nota;

    public Nota(Disciplina disciplina, Aluno aluno, double nota){
        this.disciplinaCursada=disciplina;
        this.aluno=aluno;
        this.nota=nota;
    }

    public String getDisciplina(){
        return this.disciplinaCursada.getCodigo();
    }

    public Aluno getAluno(){
        return this.aluno;
    }

    public double getNota(){
        return this.nota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "disciplinaCursada=" + disciplinaCursada +
                ", nota=" + nota +
                '}';
    }
}
