package v;

import m.Treino;

import javax.swing.*;

import c.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroTreinoFrame extends JFrame {
    private JTextField tipoField;
    private JTextField dataField;
    private JTextField horarioField;
    private Controlador controlador;

    public CadastroTreinoFrame(Controlador controlador) {
        this.controlador = controlador;

        // Configuração da Janela
        setTitle("Cadastro de Treino");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Componentes
        JLabel tipoLabel = new JLabel("Tipo de Treino:");
        tipoLabel.setBounds(20, 20, 150, 30);
        add(tipoLabel);

        tipoField = new JTextField();
        tipoField.setBounds(160, 20, 200, 30);
        add(tipoField);

        JLabel dataLabel = new JLabel("Data (dd/MM/yyyy):");
        dataLabel.setBounds(20, 60, 150, 30);
        add(dataLabel);

        dataField = new JTextField();
        dataField.setBounds(160, 60, 200, 30);
        add(dataField);

        JLabel horarioLabel = new JLabel("Horário (HH:mm):");
        horarioLabel.setBounds(20, 100, 150, 30);
        add(horarioLabel);

        horarioField = new JTextField();
        horarioField.setBounds(160, 100, 200, 30);
        add(horarioField);

        JButton cadastrarButton = new JButton("Cadastrar Treino");
        cadastrarButton.setBounds(150, 150, 150, 30);
        add(cadastrarButton);

        // Evento de cadastro
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarTreino();
            }
        });
    }

    private void cadastrarTreino() {
        String tipo = tipoField.getText();
        String dataStr = dataField.getText();
        String horario = horarioField.getText();
        Date data;

        try {
            // Convertendo a data de String para Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            data = sdf.parse(dataStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy.");
            return;
        }

        // Criando o objeto Treino
        Treino treino = new Treino(tipo, data, horario);

        // Cadastrando no controlador
        if (controlador.agendarTreino(treino)) {
            JOptionPane.showMessageDialog(this, "Treino cadastrado com sucesso!");
            tipoField.setText("");
            dataField.setText("");
            horarioField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar treino.");
        }
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        CadastroTreinoFrame frame = new CadastroTreinoFrame(controlador);
        frame.setVisible(true);
    }
}
