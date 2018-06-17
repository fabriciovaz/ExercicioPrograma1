import java.util.List;

public class Curso {   //Esta classe permite caracterizar um curso com nome, Id, ProfessorTitular, ProfessorAdjunto
    String nomeCurso;  //quantidade max de alunos e numero de alunos (uma static atualizada a cada matricula
    int idCurso;
    Professor proftitular;
    Professor profadjunto;
    int quantMaxAlunos;
    List Alunos;
    static int nAlunosNoCurso = 0;

    public static void setnAlunosNoCurso(int nAlunosNoCurso) {
        Curso.nAlunosNoCurso = nAlunosNoCurso;
    }


    //Sobrecarga nos metodos construtores
    public Curso(String nomeCurso, int idCurso, Professor proftitular, Professor profadjunto, int quantMaxAlunos, List alunos) {
        this.nomeCurso = nomeCurso;
        this.idCurso = idCurso;
        this.proftitular = proftitular;
        this.profadjunto = profadjunto;
        this.quantMaxAlunos = quantMaxAlunos;
        Alunos = alunos;
    }

    public Curso(String nomeCurso, int idCurso, int quantMaxAlunos) {
        this.nomeCurso = nomeCurso;
        this.idCurso = idCurso;
        this.quantMaxAlunos = quantMaxAlunos;

    }


    //Getters e Setters
    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Professor getProftitular() {
        return proftitular;
    }

    public void setProftitular(Professor proftitular) {
        this.proftitular = proftitular;
    }

    public Professor getProfadjunto() {
        return profadjunto;
    }

    public void setProfadjunto(Professor profadjunto) {
        this.profadjunto = profadjunto;
    }

    public int getQuantMaxAlunos() {
        return quantMaxAlunos;
    }

    public void setQuantMaxAlunos(int quantMaxAlunos) {
        this.quantMaxAlunos = quantMaxAlunos;
    }

    public List getAlunos() {
        return Alunos;
    }

    public void setAlunos(List alunos) {
        Alunos = alunos;
    }



    public Boolean adicionarUmAluno(Aluno umAluno) {// Compara a variavel estatica nAlunosNoCurso com a quantidadeMaxAlunos
        boolean resposta;                           // nesse curso
        if (Curso.nAlunosNoCurso < this.quantMaxAlunos) {
            resposta = true;
        } else {
            resposta = false;
        }
        return resposta;
    }

    public void excluirAluno(Aluno umAluno){
        Alunos.remove(umAluno);
    }
}
