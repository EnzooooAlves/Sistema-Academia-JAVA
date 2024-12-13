package m;

public class Aluno {
    private String nome;
    private int idade;
    private String planoTreino;

    public Aluno(String nome, int idade, String planoTreino) {
        this.nome = nome;
        this.idade = idade;
        this.planoTreino = planoTreino;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPlanoTreino() {
        return planoTreino;
    }

    public void setPlanoTreino(String planoTreino) {
        this.planoTreino = planoTreino;
    }

    @Override
    public String toString() {
        return nome + " - Idade: " + idade + " - Plano: " + planoTreino;
    }
}
