import javax.swing.*;

import c.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalFrame extends JFrame {
    private Controlador controlador;

    public MenuPrincipalFrame(Controlador controlador) {
        this.controlador = controlador;

        // Configuração da Janela
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Botões de navegação
        JButton alunosButton = new JButton("Gerenciar Alunos");
        alunosButton.setBounds(100, 50, 200, 30);
        add(alunosButton);

        JButton professoresButton = new JButton("Gerenciar Professores");
        professoresButton.setBounds(100, 100, 200, 30);
        add(professoresButton);

        JButton pagamentosButton = new JButton("Gerenciar Pagamentos");
        pagamentosButton.setBounds(100, 150, 200, 30);
        add(pagamentosButton);

        // Ações dos Botões
        alunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlunosFrame frame = new AlunosFrame(controlador);
                frame.setVisible(true);
            }
        });

        professoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroProfessorFrame frame = new CadastroProfessorFrame(controlador);
                frame.setVisible(true);
            }
        });

        pagamentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PagamentosFrame frame = new PagamentosFrame(controlador);
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        MenuPrincipalFrame frame = new MenuPrincipalFrame(controlador);
        frame.setVisible(true);
    }
}
