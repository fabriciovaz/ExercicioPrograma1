public class Aluno{//Esta classe permite caracterizar um aluno com nome, sobrenome, e id, com seus getters e setters.
    private String nome;
    private String sobrenome;
    private int idAluno;


    public Aluno(String nome, String sobrenome, int id) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idAluno = id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

@Override
    public boolean equals(Object objeto){
        boolean result;
        if((objeto == null) || (getClass() != objeto.getClass())){
            result = false;
        }
        if(this.getIdAluno() == ((Aluno) objeto).getIdAluno()){
            result = true;
        } else{
            result=false;
        }
        return result;
    }


}
