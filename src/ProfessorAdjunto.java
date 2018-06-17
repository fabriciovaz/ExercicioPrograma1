public class ProfessorAdjunto extends Professor { //Herda os atributos da classe professor e acrescenta quantidade de horas de monitoria
   int quantHorasMonitoria;

    public ProfessorAdjunto(String nome, String sobrenome, int tempoDeCasa, int id, int quantHorasMonitoria) {
        super(nome, sobrenome, tempoDeCasa, id);
        this.quantHorasMonitoria = quantHorasMonitoria;
    }
}
