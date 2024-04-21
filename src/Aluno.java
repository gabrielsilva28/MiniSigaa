import java.util.ArrayList;

public class Aluno extends Pessoa{
    private ArrayList<Disciplina> disciplinas;

    public Aluno(String nome, String matricula, String area) {
        super(nome,matricula,area);
        this.disciplinas = new ArrayList<>();
    }

    public ArrayList<Disciplina> getDisciplina(){
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
