import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class Celula {
    private final int x;
    private final int y;
    private final int valor;
    private int entrada;
    private final boolean fixo;

    public Celula(int x, int y, int valor, boolean fixo) {
        this.x = x;
        this.y = y;
        this.valor = valor;
        this.entrada = fixo ? valor : 0;
        this.fixo = fixo;
    }

    public JTextField componenteDaCelula() {
        JTextField celula = new JTextField();
        celula.setHorizontalAlignment(JTextField.CENTER);

        if(this.fixo) {
            celula.setEditable(false);
            celula.setText(String.valueOf(this.valor));
            celula.setBackground(new java.awt.Color(220, 220, 220));
        } else {
            celula.setEditable(true);
            AbstractDocument doc = (AbstractDocument) celula.getDocument();
            doc.setDocumentFilter(new FiltroCelula(x, y, celula));
        }

        return celula;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValor() {
        if(fixo)  {
            return valor;
        }  else {
            return entrada;
        }
    }

    public void setValor(int valor) {
        if(!this.fixo) entrada = valor;
    }

    public boolean isFixo() {
        return fixo;
    }
}
