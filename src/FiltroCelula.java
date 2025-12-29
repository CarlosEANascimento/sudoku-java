import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class FiltroCelula extends DocumentFilter {
    private final int x;
    private final int y;
    private final JTextField celula;

    public FiltroCelula(int x, int y, JTextField celula) {
        this.x = x;
        this.y = y;
        this.celula = celula;
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if(text == null || text.isEmpty()) {
            fb.replace(offset, length, text, attrs);
            Controlador.getCelula(x, y).setValor(0);
            celula.setForeground(Color.BLACK);
            return;
        }

        if(!text.matches("[1-9]")) {
            return;
        }

        if(fb.getDocument().getLength() - length + text.length() > 1) {
            return;
        }

        int valor = Integer.parseInt(text);

        fb.replace(offset, length, text, attrs);

        if(Controlador.validar(x, y, Integer.parseInt(text))) {
            Controlador.getCelula(x, y).setValor(valor);
            celula.setForeground(Color.BLACK);

            if(Controlador.checarFim()) {
                SwingUtilities.invokeLater(UI::mensagemFim);
            }
        } else {
            Controlador.getCelula(x, y).setValor(0);
            celula.setForeground(Color.RED);
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        fb.remove(offset, length);
        Controlador.getCelula(x, y).setValor(0);
        celula.setForeground(Color.BLACK);
    }
}
