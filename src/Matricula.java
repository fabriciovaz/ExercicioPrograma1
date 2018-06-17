import java.util.Calendar;

public class Matricula {
    Aluno aluno;
    Curso curso;
    Calendar data;
    static int nAlunosMatriculados;

    public Matricula(Aluno aluno, Curso curso, Calendar data) {
        this.aluno = aluno;
        this.curso = curso;
        this.data = data;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public Calendar getData() {
        return data;
    }
}
