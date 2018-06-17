public abstract class Professor {//Fsta classe abstrata permite caracterizar um professor, com as principais
    private String nome;                 // informacões necessárias
    private String sobrenome;
    private int tempoDeCasa;
    private int idProfessor;

    public Professor(String nome, String sobrenome, int tempoDeCasa, int id) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tempoDeCasa = tempoDeCasa;
        this.idProfessor = id;
    }
// Getters e Setters
    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getTempoDeCasa() {
        return tempoDeCasa;
    }

    public void setTempoDeCasa(int tempoDeCasa) {
        this.tempoDeCasa = tempoDeCasa;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }


    @Override   //Sobrescreve o método equals para comparar os objetos a partir da comparação do IdProfessor
    public boolean equals(Object objeto){
        boolean result;
        if((objeto == null) || (getClass() != objeto.getClass())){
            result = false;
        }
        if(this.getIdProfessor() == ((Professor) objeto).getIdProfessor()){
            result = true;
        } else{
            result=false;
        }
        return result;
    }
}
