package v;

import javax.swing.*;

import Aluno;
import c.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlunosFrame extends JFrame {
    private JComboBox<Aluno> alunoComboBox;
    private JTextField nomeField;
    private JTextField notaField;
    private Controlador controlador;

    public AlunosFrame(Controlador controlador) {
        this.controlador = controlador;

        // Configuração da Janela
        setTitle("Gestão de Alunos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Componentes
        JLabel alunoLabel = new JLabel("Selecione Aluno:");
        alunoLabel.setBounds(20, 20, 120, 30);
        add(alunoLabel);

        alunoComboBox = new JComboBox<>();
        for (Aluno aluno : controlador.listarAlunos()) {
            alunoComboBox.addItem(aluno);
        }
        alunoComboBox.setBounds(150, 20, 200, 30);
        add(alunoComboBox);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 60, 100, 30);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(80, 60, 200, 30);
        add(nomeField);

        JLabel notaLabel = new JLabel("Nota:");
        notaLabel.setBounds(20, 100, 100, 30);
        add(notaLabel);

        notaField = new JTextField();
        notaField.setBounds(80, 100, 200, 30);
        add(notaField);

        JButton atualizarButton = new JButton("Atualizar");
        atualizarButton.setBounds(80, 150, 100, 30);
        add(atualizarButton);

        JButton excluirButton = new JButton("Excluir");
        excluirButton.setBounds(200, 150, 100, 30);
        add(excluirButton);

        // Ação de Atualização
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno alunoSelecionado = (Aluno) alunoComboBox.getSelectedItem();
                String novoNome = nomeField.getText();
                double novaNota;
                try {
                    novaNota = Double.parseDouble(notaField.getText());
                    if (controlador.atualizarAluno(alunoSelecionado, novoNome, novaNota)) {
                        JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Nota inválida!");
                }
            }
        });

        // Ação de Exclusão
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno alunoSelecionado = (Aluno) alunoComboBox.getSelectedItem();
                if (controlador.excluirAluno(alunoSelecionado)) {
                    JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
                    alunoComboBox.removeItem(alunoSelecionado);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir aluno!");
                }
            }
        });
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        AlunosFrame frame = new AlunosFrame(controlador);
        frame.setVisible(true);
    }
}
