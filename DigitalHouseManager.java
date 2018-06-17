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
        for (Curso i:cursos) {      //for each
          if (i.getIdCurso() == codigoCurso){
              cursos.remove(i);
          }
        }
    }

    public void excluirProfessor(Integer codigoProfessor){

        for (Professor i:professores) {      //for each: o iterador i é um objeto do tipo professor, percorrendo todas a
            if (i.getIdProfessor() == codigoProfessor){  //posicoes na lista professores
                professores.remove(i);
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

        for (Aluno i:alunos) {
            if (i.getIdAluno() == codigoAluno){
                alunos.remove(i.getIdAluno());
            }
        }
    }

    public void cancelarMatriculaAluno(Integer codigoAluno){

        for (Iterator<Matricula> i = matriculas.iterator(); i.hasNext();) {
            Matricula matricula = i.next();
            if (matricula.aluno.getIdAluno()==codigoAluno) {
                i.remove();
            }
        }
        //altera a matricula
//        for (Matricula i:matriculas) {
//            if (i.aluno.getIdAluno() == codigoAluno){
//                matriculas.remove(i);
//            }
//        }
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
                            Curso.nAlunosNoCurso++; //Altera o contador estático
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


