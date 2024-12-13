package c;

import java.util.ArrayList;
import java.util.List;

import m.Aluno;
import m.Pagamento;
import m.Professor;
import m.Treino;

public class Controlador {
    private List<Aluno> alunos = new ArrayList<>();

    // Cadastro de aluno
    public boolean cadastrarAluno(Aluno aluno) {
        if (aluno != null) {
            alunos.add(aluno);
            return true;
        }
        return false;
    }

    // Listar alunos
    public List<Aluno> listarAlunos() {
        return alunos;
    }

    // Excluir aluno
    public boolean excluirAluno(Aluno aluno) {
        return alunos.remove(aluno);
    }

    // Atualizar aluno
    public boolean atualizarAluno(Aluno aluno, String novoNome, double novaNota) {
        if (aluno != null) {
            aluno.setNome(novoNome); // Atualiza o nome do aluno
            return true;
        }
        return false;
    }

    public boolean registrarPagamento(Pagamento pagamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarPagamento'");
    }

    public boolean cadastrarProfessor(Professor professor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarProfessor'");
    }

    public boolean agendarTreino(Treino treino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agendarTreino'");
    }
}
