public class ProfessorTitular extends Professor { //Herda características da classe professor e acrescenta  o atributo especialidade
    String especialidade;


    // Construtor da classe com os atributos herdados e o atributo especialidade, criado nesta classe
    public ProfessorTitular(String nome, String sobrenome, int tempoDeCasa, int id, String especialidade) {
        super(nome, sobrenome, tempoDeCasa, id);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
