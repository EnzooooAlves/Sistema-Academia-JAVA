package v;

import m.Professor;

import javax.swing.*;

import c.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProfessorFrame extends JFrame {
    private JTextField nomeField;
    private JTextField especialidadeField;
    private JTextField salarioField;
    private Controlador controlador;

    public CadastroProfessorFrame(Controlador controlador) {
        this.controlador = controlador;

        // Configuração da Janela
        setTitle("Cadastro de Professor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Componentes
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 100, 30);
        add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(80, 20, 200, 30);
        add(nomeField);

        JLabel especialidadeLabel = new JLabel("Especialidade:");
        especialidadeLabel.setBounds(20, 60, 100, 30);
        add(especialidadeLabel);

        especialidadeField = new JTextField();
        especialidadeField.setBounds(120, 60, 200, 30);
        add(especialidadeField);

        JLabel salarioLabel = new JLabel("Salário:");
        salarioLabel.setBounds(20, 100, 100, 30);
        add(salarioLabel);

        salarioField = new JTextField();
        salarioField.setBounds(80, 100, 200, 30);
        add(salarioField);

        JButton cadastrarButton = new JButton("Cadastrar Professor");
        cadastrarButton.setBounds(120, 150, 150, 30);
        add(cadastrarButton);

        // Evento de cadastro
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProfessor();
            }
        });
    }

    private void cadastrarProfessor() {
        String nome = nomeField.getText();
        String especialidade = especialidadeField.getText();
        double salario;

        try {
            salario = Double.parseDouble(salarioField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um salário válido!");
            return;
        }

        Professor professor = new Professor(nome, especialidade, salario);
        if (controlador.cadastrarProfessor(professor)) {
            JOptionPane.showMessageDialog(this, "Professor cadastrado com sucesso!");
            nomeField.setText("");
            especialidadeField.setText("");
            salarioField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar professor.");
        }
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        CadastroProfessorFrame frame = new CadastroProfessorFrame(controlador);
        frame.setVisible(true);
    }
}
