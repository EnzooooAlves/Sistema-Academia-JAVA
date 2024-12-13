package v;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import c.Controlador;
import m.Aluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField planoField;
    private JTable tabelaAlunos;
    private DefaultTableModel tableModel;
    private Controlador controlador;

    public MainFrame() {
        controlador = new Controlador();

        // Configuração da Janela
        setTitle("Gerenciamento de Academia");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Componentes
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 100, 30);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(80, 20, 200, 30);
        add(nomeField);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeLabel.setBounds(20, 60, 100, 30);
        add(idadeLabel);

        idadeField = new JTextField();
        idadeField.setBounds(80, 60, 200, 30);
        add(idadeField);

        JLabel planoLabel = new JLabel("Plano de Treino:");
        planoLabel.setBounds(20, 100, 150, 30);
        add(planoLabel);

        planoField = new JTextField();
        planoField.setBounds(150, 100, 200, 30);
        add(planoField);

        JButton cadastrarButton = new JButton("Cadastrar Aluno");
        cadastrarButton.setBounds(300, 150, 150, 30);
        add(cadastrarButton);

        JButton cadastroTreinoButton = new JButton("Cadastrar Treino");
        cadastroTreinoButton.setBounds(300, 200, 150, 30);
        add(cadastroTreinoButton);

        // Tabela
        tableModel = new DefaultTableModel(new String[]{"Nome", "Idade", "Plano de Treino"}, 0);
        tabelaAlunos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        scrollPane.setBounds(20, 150, 250, 200);
        add(scrollPane);

        // Eventos
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        cadastroTreinoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCadastroTreino();
            }
        });
    }

    private void cadastrarAluno() {
        String nome = nomeField.getText();
        int idade;
        try {
            idade = Integer.parseInt(idadeField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite uma idade válida!");
            return;
        }

        String planoTreino = planoField.getText();

        // Criando o aluno e cadastrando
        Aluno aluno = new Aluno(nome, idade, planoTreino);
        if (controlador.cadastrarAluno(aluno)) {
            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
            nomeField.setText("");
            idadeField.setText("");
            planoField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar aluno.");
        }

        listarAlunos();
    }

    private void listarAlunos() {
        tableModel.setRowCount(0); // Limpar tabela
        for (Aluno aluno : controlador.listarAlunos()) {
            tableModel.addRow(new Object[]{aluno.getNome(), aluno.getIdade(), aluno.getPlanoTreino()});
        }
    }

    private void abrirCadastroTreino() {
        new CadastroTreinoFrame(controlador).setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}
