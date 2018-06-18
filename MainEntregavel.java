import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainEntregavel {
        public static void main(String[] args) {


                DigitalHouseManager dhmanager1 = new DigitalHouseManager();

                //Atribuição de valores aos objetos curso, alunos e professores

                dhmanager1.registrarProfessorTitular("Paul", "Dirac", 1001, "Físico teórico de Partículas");
                dhmanager1.registrarProfessorTitular("James", "Clark Maxwell", 1002, "Eletromagnetismo");
                dhmanager1.registrarProfessorAdjunto("Linus", "Pauling", 2001, 20);
                dhmanager1.registrarProfessorAdjunto("Cesar", "Lattes", 2002, 20);
                dhmanager1.registrarCurso("FullStack", 20001, 3);
                dhmanager1.registrarCurso("Android", 20002, 2);
                dhmanager1.registrarAluno("Fabrício", "Vaz", 101);
                dhmanager1.registrarAluno("Bruno", "Silva", 102);
                dhmanager1.registrarAluno("Carlos", "Almeida", 103);
                dhmanager1.registrarAluno("Diego", "Castro", 104);
                dhmanager1.registrarAluno("Erik", "Silva", 105);
                dhmanager1.registrarAluno("Gabriel", "Almeida", 106);
                dhmanager1.registrarAluno("Hugo", "Castro", 107);



                //Alocação de professores nos dois cursos criados
                dhmanager1.alocarProfessores(20001,1001,2001);
                dhmanager1.alocarProfessores(20002,1002,2002);

               //Mostra os professores de cada curso
            System.out.println("\n\n\n********Professores e respectivos cursos*******");
            for (Curso i:dhmanager1.cursos) {
                System.out.println(i.proftitular.getNome()+" "+i.proftitular.getSobrenome()+"----"+i.nomeCurso);
                System.out.println(i.profadjunto.getNome()+" "+i.profadjunto.getSobrenome()+"----"+i.nomeCurso);
            }

                //Exclui um professor
                dhmanager1.excluirProfessor(2002);

                //Mostra os professores de cada curso. No lugar do nome do professor excluido aparece "Professor nao cadastrado. O curso nao é excluído.
                System.out.println("\n\n\n********Professores e respectivos cursos*******");
                for (Curso i:dhmanager1.cursos) {
                    System.out.println(i.proftitular.getNome()+" "+i.proftitular.getSobrenome()+"----"+i.nomeCurso);
                    System.out.println(i.profadjunto.getNome()+" "+i.profadjunto.getSobrenome()+"----"+i.nomeCurso);
                }

                dhmanager1.matricularAluno(101,20001);
                dhmanager1.matricularAluno(102,20001);
                dhmanager1.matricularAluno(103,20001);
                //Tenta registrar um aluno a mais no curso 20001
                dhmanager1.matricularAluno(104,20001);
                //Exclui um aluno
                dhmanager1.excluirAluno(101);
                //Tenta matricular novamente
                dhmanager1.matricularAluno(104,20001);
                //Matricula alunos no curso 20002
                dhmanager1.matricularAluno(105,20002);
                dhmanager1.matricularAluno(106,20002);
                //O curso já está cheio!!
                dhmanager1.matricularAluno(107,20002);

                //Exibe uma lista de alunos matriculados e o respectivo curso
                    System.out.println("\n\n\n********Lista de alunos por curso*******");
                for (Matricula i:dhmanager1.matriculas) {
                    System.out.print(i.aluno.getNome()+" "+i.aluno.getSobrenome()+"---");
                    System.out.println(i.curso.nomeCurso+" "+i.curso.getIdCurso());
                }

                //Exclui um curso
                dhmanager1.excluirCurso(20002);
            //Exibe uma lista de alunos matriculados e o respectivo curso
                System.out.println("\n\n\n********Lista de alunos por curso*******");
            for (Matricula i:dhmanager1.matriculas) {
                System.out.print(i.aluno.getNome()+" "+i.aluno.getSobrenome()+"---");
                System.out.println(i.curso.nomeCurso+" "+i.curso.getIdCurso());
            }
        }
}