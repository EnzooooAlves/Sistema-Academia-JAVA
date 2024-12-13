package v;


import m.Pagamento;

import javax.swing.*;

import m.Aluno;
import c.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("unused")
public class CadastroPagamentoFrame extends JFrame {
    private JComboBox<Aluno> alunoComboBox;
    private JTextField valorField;
    private Controlador controlador;

    public CadastroPagamentoFrame(Controlador controlador) {
        this.controlador = controlador;

        // Configuração da Janela
        setTitle("Cadastro de Pagamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Componentes
        JLabel alunoLabel = new JLabel("Aluno:");
        alunoLabel.setBounds(20, 20, 100, 30);
        add(alunoLabel);

        alunoComboBox = new JComboBox<>();
        for (Aluno aluno : controlador.listarAlunos()) {
            alunoComboBox.addItem(aluno);
        }
        alunoComboBox.setBounds(80, 20, 200, 30);
        add(alunoComboBox);

        JLabel valorLabel = new JLabel("Valor:");
        valorLabel.setBounds(20, 60, 100, 30);
        add(valorLabel);

        valorField = new JTextField();
        valorField.setBounds(80, 60, 200, 30);
        add(valorField);

        JButton cadastrarButton = new JButton("Registrar Pagamento");
        cadastrarButton.setBounds(120, 150, 150, 30);
        add(cadastrarButton);

        // Evento de cadastro
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPagamento();
            }
        });
    }

    private void cadastrarPagamento() {
        Aluno aluno = (Aluno) alunoComboBox.getSelectedItem();
        double valor;

        try {
            valor = Double.parseDouble(valorField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um valor válido!");
            return;
        }

        // Criando o pagamento
        Date dataPagamento = new Date(); // Data atual
        Pagamento pagamento = new Pagamento(aluno, valor, dataPagamento);

        // Cadastrando o pagamento
        if (controlador.registrarPagamento(pagamento)) {
            JOptionPane.showMessageDialog(this, "Pagamento registrado com sucesso!");
            valorField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao registrar pagamento.");
        }
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        CadastroPagamentoFrame frame = new CadastroPagamentoFrame(controlador);
        frame.setVisible(true);
    }
}
