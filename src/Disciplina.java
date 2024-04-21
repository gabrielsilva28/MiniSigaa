import java.util.ArrayList;

public class Disciplina {
    protected String codigo;
    protected String disciplina;
    protected String horario;
    protected String area;
    protected String preRequisito;
    protected String tipo;

    public Disciplina(String codigo, String disciplina, String horario, String area,String preRequisito, String tipo) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.horario = horario;
        this.area = area;
        this.preRequisito=preRequisito;
        this.tipo = tipo;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getHorario() {
        return horario;
    }

    public String getArea() {
        return area;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPreRequisito() {
        return preRequisito;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPreRequisito(String preRequisito) {
        this.preRequisito = preRequisito;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "codigo='" + codigo + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", horario='" + horario + '\'' +
                ", area='" + area + '\'' +
                ", preRequisito='" + preRequisito + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}




