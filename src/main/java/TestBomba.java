public class TestBomba {
    public static void main(String[] args) {
        BombaControlador controlador = new BombaControlador();
        BombaModelo modelo = new BombaModelo();
        BombaVista vista = new BombaVista(controlador);
        controlador.setModelo(modelo);
        controlador.setVista(vista);
        vista.setVisible(true);
    }
}
