import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainEntregavel {
        public static void main(String[] args) {


                DigitalHouseManager dhmanager1 = new DigitalHouseManager();

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



                dhmanager1.cursos.get(0).setProftitular(dhmanager1.professores.get(0));
                dhmanager1.cursos.get(0).setProfadjunto(dhmanager1.professores.get(2));
                dhmanager1.cursos.get(1).setProftitular(dhmanager1.professores.get(1));
                dhmanager1.cursos.get(1).setProfadjunto(dhmanager1.professores.get(3));

                for (Curso i:dhmanager1.cursos) {
                        System.out.println(i.proftitular.getNome()+" "+i.proftitular.getSobrenome());
                }

                dhmanager1.matricularAluno(101,20001);
                dhmanager1.matricularAluno(102,20001);
                dhmanager1.matricularAluno(103,20001);
                dhmanager1.matricularAluno(104,20001);
                dhmanager1.cancelarMatriculaAluno(101);
                dhmanager1.matricularAluno(104,20001);

        }
}