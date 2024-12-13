import java.io.*;
import java.util.List;

public class Persistencia {

    private static final String ARQUIVO_ALUNOS = "alunos.dat";

    // Salva a lista de alunos em um arquivo
    public static void salvarAlunos(List<Aluno> alunos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_ALUNOS))) {
            oos.writeObject(alunos); // Serializa a lista de alunos
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega a lista de alunos de um arquivo
    @SuppressWarnings("unchecked")
    public static List<Aluno> carregarAlunos() {
        List<Aluno> alunos = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_ALUNOS))) {
            alunos = (List<Aluno>) ois.readObject(); // Desserializa a lista de alunos
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return alunos;
    }
}
