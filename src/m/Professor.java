package m;

public class Professor {
    private String nome;
    private String especialidade;
    private double salario;

    public Professor(String nome, String especialidade, double salario) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nome + " - " + especialidade;
    }
}
