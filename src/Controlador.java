import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controlador {
    public static List<Celula> celulas = new ArrayList<>(81);

    // NO MOMENTO, VALORES FIXADOS
    public static void  gerarCelulas() {
        try {
            BufferedReader fonte = new BufferedReader(new FileReader("src/valor_fixo.txt"));
            String linha = fonte.readLine();
            String[] fonteCelulas = linha.split(" ");
            if(fonteCelulas.length != 81) throw new IOException("Arquivo Inválido");

            for (int i = 0; i < 81; i++) {
                String[] componentes = fonteCelulas[i].split(";");

                String[] posicao = componentes[0].split(",");
                String[] situacao = componentes[1].split(",");

                int posX = Integer.parseInt(posicao[0]);
                int posY = Integer.parseInt(posicao[1]);
                int valor =  Integer.parseInt(situacao[0]);
                boolean fixo = situacao[1].equals("true");

                celulas.add(new Celula(posX, posY, valor, fixo));
            }

            fonte.close();
        } catch (IOException ex) {
            System.out.println("Erro ao ler o arquivo");
        }
    }

    public static Celula getCelula(int x, int y) {
        return celulas.stream().filter(c -> c.getX() == x && c.getY() == y).findFirst().orElse(null);
    }

    public static boolean validar(int posX, int posY, int valor) {
        int indiceAncora;
        Set<Integer> usados = new HashSet<>();

        // validar valor no bloco 3x3
        int xBloco = posX / 3;
        int yBloco = posY / 3;

        for(Celula celula : celulas) {
            if(celula.getX() / 3 == xBloco && celula.getY() / 3 == yBloco && celula.getValor() != 0) {
                if(!usados.add(celula.getValor())) return false;
            }
        }

        // validar valor na linha
        usados.clear();

        for(Celula  celula : celulas){
            if(celula.getY() == posY && celula.getValor() != 0) {
                if(!usados.add(celula.getValor())) return false;
            }
        }

        // validar valor na coluna
        usados.clear();

        for(Celula  celula : celulas){
            if(celula.getX() == posX && celula.getValor() != 0) {
                if(!usados.add(celula.getValor())) return false;
            }
        }

        return true;
    }

    public static boolean checarFim() {
        return celulas.stream().allMatch(c -> c.getValor() != 0);
    }
}
