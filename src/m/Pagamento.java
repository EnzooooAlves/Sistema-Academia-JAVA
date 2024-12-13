package m;

import java.util.Date;

public class Pagamento {
    private Aluno aluno;
    private double valor;
    private Date dataPagamento;

    public Pagamento(Aluno aluno, double valor, Date dataPagamento) {
        this.aluno = aluno;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Override
    public String toString() {
        return aluno.getNome() + " - R$ " + valor + " - " + dataPagamento.toString();
    }
}
