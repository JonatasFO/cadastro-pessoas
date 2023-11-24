public class Aluno {
    private Long id;
    private String nome;
    private Integer idade;
    private String faculdade;
    public Aluno() {
    }
    public Aluno(String nome, Integer idade, String faculdade) {
        this.nome = nome;
        this.idade = idade;
        this.faculdade = faculdade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(String faculdade) {
        this.faculdade = faculdade;
    }

    @Override
    public String toString() {
        return "\n Nome: " + nome + ", idade: " + idade + ", Faculdade: " + faculdade;
    }


}
