import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UI extends JFrame {
    public UI() {
        setTitle("Sudoko");
        setSize(960, 960);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void adicionarCelulas(List<Celula> celulas) {
        this.setLayout(new GridLayout(3, 3, 10, 10));

        JPanel[][] bloco3x3 = new JPanel[3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                bloco3x3[i][j] = new JPanel(new GridLayout(3, 3, 5, 5));
                this.add(bloco3x3[i][j]);
            }
        }

        for (Celula celula : celulas) {
            int blocoX = celula.getX() / 3;
            int blocoY = celula.getY() / 3;

            bloco3x3[blocoY][blocoX].add(celula.componenteDaCelula());
        }
    }

    public static void mensagemFim() {
        JDialog fim = new JDialog();
        fim.setTitle("Fim");
        fim.setLayout(new BorderLayout());
        fim.setSize(300, 150);
        fim.setLocationRelativeTo(null);

        JLabel label = new JLabel("Sudoku concluído!", SwingConstants.CENTER);
        label.setForeground(new Color(0, 81, 44));
        label.setFont(new Font("Arial", Font.BOLD, 16));

        fim.add(label, BorderLayout.CENTER);
        fim.setVisible(true);
    }
}
