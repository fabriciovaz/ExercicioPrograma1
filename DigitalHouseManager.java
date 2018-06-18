import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DigitalHouseManager {  //Esta classe contém as listas e os seus métodos modificadores
                                    //É a partir desta classe que serão feitas as alterações nesse mini banco de dados

    List<Aluno> alunos = new ArrayList<Aluno>();
    List<Professor> professores = new ArrayList<Professor>();
    List<Curso> cursos = new ArrayList<Curso>();
    List<Matricula> matriculas = new ArrayList<Matricula>();




    //Os objetos das classes Professor, aluno, curso e matricula são instanciados durante a execução
    //dos métodos que criam ou editam objetos dessas classes.



    public void registrarCurso(String nomeCurso, Integer codigoCurso, Integer quantidadeMaximaDeAlunos){
        Curso curso01 = new Curso(nomeCurso,codigoCurso,quantidadeMaximaDeAlunos);
        cursos.add(curso01);  //Os objetos são adicionados às listas após serem instanciados
    }

    public void excluirCurso(Integer codigoCurso){
        for (int i=0; i<cursos.size(); i++) {
            if (cursos.get(i).getIdCurso()==codigoCurso) {
                cursos.remove(cursos.get(i));
                cancelarMatriculaCurso(codigoCurso);

            }
        }
    }

    public void excluirProfessor(Integer codigoProfessor){

        for (int i=0; i<professores.size(); i++) {
            if (professores.get(i).getIdProfessor()==codigoProfessor) {
                professores.remove(professores.get(i));

            }
        }
        for (int j=0; j<cursos.size(); j++) {
            if (cursos.get(j).proftitular.getIdProfessor()==codigoProfessor) {
                cursos.get(j).proftitular.setNome("Professor não cadastrado!");
                cursos.get(j).proftitular.setSobrenome("Professor não cadastrado!");
                cursos.get(j).proftitular.setIdProfessor(0);
            }
            if (cursos.get(j).profadjunto.getIdProfessor()==codigoProfessor) {
                cursos.get(j).profadjunto.setNome("Professor não cadastrado!");
                cursos.get(j).profadjunto.setSobrenome("Professor não cadastrado!");
                cursos.get(j).profadjunto.setIdProfessor(0);
            }

        }

    }



    public void registrarProfessorAdjunto(String nome, String sobrenome, Integer codigoProfessor, Integer quantidadeDeHoras){
        ProfessorAdjunto profA01 = new ProfessorAdjunto(nome,sobrenome,0,codigoProfessor,quantidadeDeHoras);
        professores.add(profA01);//cria o objeto aluno01 da classe Aluno e o adiciona à lista professores
    }

    public void registrarProfessorTitular(String nome, String sobrenome, Integer codigoProfessor, String especialidade){
        ProfessorTitular profT01 = new ProfessorTitular(nome,sobrenome,0,codigoProfessor,especialidade);
        professores.add(profT01);//cria o objeto aluno01 da classe Aluno e o adiciona à lista professores
    }

    public void registrarAluno(String nome, String sobrenome, Integer codigoAluno){
        Aluno aluno01 = new Aluno(nome,sobrenome,codigoAluno);
        alunos.add(aluno01);//cria o objeto aluno01 da classe Aluno e adiciona
    }                       //o objeto na lista alunos, do tipo Aluno.

    public void excluirAluno(Integer codigoAluno){

        for (int i=0; i<alunos.size(); i++) {
            if (alunos.get(i).getIdAluno()==codigoAluno) {
                alunos.remove(alunos.get(i));
                cancelarMatriculaAluno(codigoAluno);
            }
        }
    }

    public void cancelarMatriculaAluno(Integer codigoAluno){//Não foi possível utilizar o for each

        for (int i=0; i<matriculas.size(); i++) {
            if (matriculas.get(i).aluno.getIdAluno()==codigoAluno) {
                matriculas.remove(matriculas.get(i));
               matriculas.get(i).curso.setnAlunosMatriculados(matriculas.get(i).curso.getnAlunosMatriculados()-1); //Diminui 1 no contador nAlunos Matriculados;
            }
        }
    }

    public void cancelarMatriculaCurso(Integer codigoCurso){//Não foi possível utilizar o for each

        for (int i=0; i<matriculas.size(); i++) {
            if (matriculas.get(i).curso.getIdCurso()==codigoCurso) {
                matriculas.remove(matriculas.get(i));
                i--;

            }
        }
    }



    public void matricularAluno(Integer codigoAluno, Integer codigoCurso){
        for (Aluno i:alunos) {      //for each
            if (i.getIdAluno() == codigoAluno){
                for (Curso j:cursos) {      //for each
                    if (j.getIdCurso() == codigoCurso){
                        if (j.adicionarUmAluno(i)) {  //Utiliza um método para avaliar se ainda há vagas
                            Calendar calendar1 = Calendar.getInstance();
                            Matricula matricula01 = new Matricula(i, j, calendar1);
                            matriculas.add(matricula01);
                            j.setnAlunosMatriculados(j.getnAlunosMatriculados()+1); //Adiciona 1 no contador n
                            System.out.println("Matrícula realizada com sucesso!");
                        }
                            else{
                                System.out.println("Não foi possível realizar a matrícula. Não há mais vagas");
                            }

                    }
                }
            }
        }
    }

    public int nAlunosMatriculados(int codigoCurso) {
       int n=0;
        for (Matricula i : matriculas) {      //Obtém o número de alunos em um curso
            if (i.curso.getIdCurso() == codigoCurso) {
                n++;
            }
        }
        return n;
    }



    public void alocarProfessores(Integer codigoCurso, Integer codigoProfessorTitular, Integer codigoProfessorAdjunto){
        for (Curso i:cursos) {      //for each
            if (i.getIdCurso() == codigoCurso){
                for (Professor j:professores) {      //for each
                    if (j.getIdProfessor() == codigoProfessorTitular){
                        i.setProftitular(j);
                    }
                }
            }
        }
        for (Curso i:cursos) {      //for each
            if (i.getIdCurso() == codigoCurso){
                for (Professor j:professores) {      //for each
                    if (j.getIdProfessor() == codigoProfessorAdjunto){
                        i.setProfadjunto(j);
                    }
                }
            }
        }


    }
}


