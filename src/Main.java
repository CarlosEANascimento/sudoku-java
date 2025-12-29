public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        Controlador.gerarCelulas();
        ui.adicionarCelulas(Controlador.celulas);
        ui.setVisible(true);
    }
}