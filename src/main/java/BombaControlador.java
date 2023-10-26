import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BombaControlador implements ActionListener {
    private BombaModelo modelo;
    private BombaVista vista;

    public BombaControlador() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnPesos) {
            System.out.println("Me pucharon pesos");
            vista.disableAllBtn();
            vista.enableAllBtn(true);
            vista.txtQtyVenta.setText("$0.00");
            vista.txtQtyLitros.setText("0.00");
            modelo.setIsPeso(true);
        }
        if (e.getSource() == vista.btnLitros) {
            System.out.println("Me pucharon litros");
            vista.disableAllBtn();
            vista.enableAllBtn(false);
            vista.txtQtyVenta.setText("$0.00");
            vista.txtQtyLitros.setText("0.00");
            modelo.setIsPeso(false);
        }

        if (e.getSource() == vista.btn9) {
            System.out.println("Me pucharon 9");
            addDisplay(9, modelo.getIsPeso());
        }

        if (e.getSource() == vista.btn8) {
            System.out.println("Me pucharon 8");
            addDisplay(8, modelo.getIsPeso());
        }

        if (e.getSource() == vista.btn7) {
            System.out.println("Me pucharon 7");
            addDisplay(7, modelo.getIsPeso());
        }

        if (e.getSource() == vista.btn6) {
            System.out.println("Me pucharon 6");
            addDisplay(6, modelo.getIsPeso());
        }

        if (e.getSource() == vista.btn5) {
            System.out.println("Me pucharon 5");
            addDisplay(5, modelo.getIsPeso());
        }

        if (e.getSource() == vista.btn4) {
            System.out.println("Me pucharon 4");
            addDisplay(4, modelo.getIsPeso());
        }

        if (e.getSource() == vista.btn3) {
            System.out.println("Me pucharon 3");
            addDisplay(3, modelo.getIsPeso());
        }

        if (e.getSource() == vista.btn2) {
            System.out.println("Me pucharon 2");
            addDisplay(2, modelo.getIsPeso());
        }

        if (e.getSource() == vista.btn1) {
            System.out.println("Me pucharon 1");
            addDisplay(1, modelo.getIsPeso());
        }

        if (e.getSource() == vista.btn0) {
            System.out.println("Me pucharon 0");
            addDisplay(0, modelo.getIsPeso());
            //System.out.println(modelo.getPrecioLitro());
        }
        if(e.getSource() == vista.btnPunto){
            System.out.println("Me pucharon punto");
                if(vista.txtQtyVenta.getText().contains(".")){
                    vista.showError("Ya hay un punto en la cantidad de pesos");
                }else{
                    vista.txtQtyVenta.setText(vista.txtQtyVenta.getText() + ".");
                    modelo.convertPesoToLiters(Float.parseFloat(vista.txtQtyVenta.getText().substring(1)));
                }
        }

        if(e.getSource() == vista.btnSetPrecio){
            try{
                float newPrecio = Float.parseFloat(vista.inputPrecio.getText());
                this.modelo.setPrecioLitro(newPrecio);
                System.out.println("Cambiado precio a " + vista.inputPrecio.getText());
                this.vista.txtQtyLitros.setText("0.00");
                this.vista.txtQtyVenta.setText("$0.00");
            }catch(NumberFormatException err){
                vista.showError("Error al cambiar el precio, solo se aceptan números, intenta nuevamente.");
                this.vista.inputPrecio.setText("21.0");
            }
        }

        if(e.getSource() == vista.btnDespachar){
            try{
                if(modelo.getIsPeso()){
                    modelo.despachar(Float.parseFloat(vista.txtQtyVenta.getText().substring(1)));
                }else{
                    modelo.despachar(Integer.parseInt(vista.txtQtyLitros.getText()));
                }
                vista.txtQtyLitros.setText("0.00");
                vista.txtQtyVenta.setText("$0.00");
            }catch(NumberFormatException err){
                vista.showError("Error al despachar, solo se aceptan números, intenta nuevamente.");
                this.vista.inputPrecio.setText("21.0");
            }
        }

        vista.repaint();
    }

    private void addDisplay(int key, boolean isPeso) {
        if (!isPeso) {
            System.out.println("Me pucharon " + key);
            String prevValue = vista.txtQtyLitros.getText().equals("0.00") ? "" : vista.txtQtyLitros.getText();
            vista.txtQtyLitros.setText(prevValue + key);
            vista.txtQtyVenta.setText("$" + modelo.convertLitersToPeso(Integer.parseInt(vista.txtQtyLitros.getText())) + "");
        } else {
            System.out.println("Me pucharon " + key);
            String prevValue = vista.txtQtyVenta.getText().equals("$0.00") ? "$" : vista.txtQtyVenta.getText();
            vista.txtQtyVenta.setText(prevValue.charAt(0) == '$' ? prevValue + key : "$" + prevValue + key);
            vista.txtQtyLitros.setText(modelo.convertPesoToLiters(Float.parseFloat(vista.txtQtyVenta.getText().substring(1)))+"");
        }
    }

    public void setModelo(BombaModelo modelo) {
        this.modelo = modelo;
    }

    public BombaModelo getModelo() {
        return modelo;
    }

    public void setVista(BombaVista vista) {
        this.vista = vista;
        vista.inputPrecio.setText(modelo.getPrecioLitro() + "");
        vista.showError("Nomas hay pura magna :(");
    }

    public BombaVista getVista() {
        return vista;
    }

}
