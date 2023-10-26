import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class BombaVista extends JFrame {
    BombaControlador control;
    protected boolean isPesos;
    public JButton btnPesos, btnLitros, btnDespachar, btnSetPrecio, btn9, btn8, btn7, btn6, btn5, btn4, btn3, btn2, btn1, btn0, btnPunto;
    public JPanel panelMain, panelBotones, panelDisplay, panelTitle, panelKeyboard, panelRightSide, panelFooter;
    public JLabel txtLitros, txtVenta, txtQtyLitros, txtQtyVenta, txtPrecio, txtTitulo;
    public JTextField inputPrecio;

    public BombaVista(BombaControlador control) {
        super("PEMEX GASOLINERA - @elzackarias");
        this.control = control;
        this.setSize(800, 400);
        //this.setLayout(new FlowLayout(FlowLayout));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.isPesos = true;
        initComponents();
    }

    private void initComponents() {
        Border blackline = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.white), BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnPesos = new JButton("💵");
        btnPesos.setMargin(new Insets(10, 10, 10, 10));
        btnPesos.addActionListener(control);
        btnLitros = new JButton("⛽");
        btnLitros.setMargin(new Insets(10, 10, 10, 10));
        btnLitros.addActionListener(control);
        btnSetPrecio = new JButton("Cambiar precio");
        btnSetPrecio.addActionListener(control);
        btnDespachar = new JButton("Despachar");
        btnDespachar.addActionListener(control);
        txtTitulo = new JLabel("🔴 P E M E X  -  G A S");
        txtTitulo.setForeground(Color.green);
        txtTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        txtVenta = new JLabel("   Venta Total");
        txtVenta.setForeground(Color.white);
        txtVenta.setFont(new Font("Arial", Font.BOLD, 14));
        txtLitros = new JLabel("   Litros");
        txtLitros.setForeground(Color.white);
        txtLitros.setFont(new Font("Arial", Font.BOLD, 14));
        txtQtyLitros = new JLabel("0.00");
        txtQtyLitros.setForeground(Color.white);
        txtQtyLitros.setFont(new Font("Arial", Font.BOLD, 16));
        txtQtyLitros.setHorizontalAlignment(SwingConstants.RIGHT);
        txtQtyVenta = new JLabel("$0.00");
        txtQtyVenta.setFont(new Font("Arial", Font.BOLD, 16));
        txtQtyVenta.setForeground(Color.white);
        txtQtyVenta.setHorizontalAlignment(SwingConstants.RIGHT);
        btn9 = new JButton("9");
        btn9.setMargin(new Insets(10, 10, 10, 10));
        btn9.addActionListener(control);
        btn8 = new JButton("8");
        btn8.addActionListener(control);
        btn7 = new JButton("7");
        btn7.addActionListener(control);
        btn6 = new JButton("6");
        btn6.addActionListener(control);
        btn5 = new JButton("5");
        btn5.addActionListener(control);
        btn4 = new JButton("4");
        btn4.addActionListener(control);
        btn3 = new JButton("3");
        btn3.addActionListener(control);
        btn2 = new JButton("2");
        btn2.addActionListener(control);
        btn1 = new JButton("1");
        btn1.addActionListener(control);
        btn0 = new JButton("0");
        btn0.addActionListener(control);
        btnPunto = new JButton("•");
        btnPunto.addActionListener(control);
        disableAllBtn();
        panelMain = new JPanel(new FlowLayout(FlowLayout.CENTER,40,20));
        panelTitle = new JPanel(new GridLayout(2, 1,0,0));
        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
        panelBotones.setBackground(Color.BLACK);
        panelDisplay = new JPanel(new GridLayout(2, 2));
        panelDisplay.setBackground(Color.BLACK);
        panelTitle.add(new JLabel(""));
        panelTitle.add(txtTitulo);
        panelTitle.setBackground(Color.BLACK);
        panelRightSide = new JPanel(new BorderLayout());
        txtPrecio = new JLabel("Precio: $");
        txtPrecio.setForeground(Color.white);
        txtPrecio.setFont(new Font("Arial", Font.BOLD, 16));
        inputPrecio = new JTextField("0.00",5);
        panelFooter = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 0));
        panelFooter.setBackground(Color.BLACK);
        panelKeyboard = new JPanel(new GridLayout(4, 3));
        panelFooter.add(txtPrecio);
        panelFooter.add(inputPrecio);
        panelFooter.add(btnSetPrecio);
        panelFooter.add(btnDespachar);
        panelDisplay.add(txtQtyVenta);
        panelDisplay.add(txtVenta);
        panelDisplay.add(txtQtyLitros);
        panelDisplay.add(txtLitros);
        panelBotones.add(btnPesos);
        panelBotones.add(btnLitros);
        panelKeyboard.add(btn9);
        panelKeyboard.add(btn8);
        panelKeyboard.add(btn7);
        panelKeyboard.add(btn6);
        panelKeyboard.add(btn5);
        panelKeyboard.add(btn4);
        panelKeyboard.add(btn3);
        panelKeyboard.add(btn2);
        panelKeyboard.add(btn1);
        panelKeyboard.add(btn0);
        panelKeyboard.add(btnPunto);
        panelKeyboard.setBackground(Color.BLACK);
        panelRightSide.add(panelBotones,BorderLayout.PAGE_START);
        panelRightSide.add(panelKeyboard);
        panelRightSide.add(panelFooter,BorderLayout.PAGE_END);
        panelDisplay.setBorder(blackline);
        this.add(panelTitle, BorderLayout.PAGE_START);
        panelMain.add(panelDisplay, BorderLayout.WEST);
        panelMain.add(panelRightSide, BorderLayout.EAST);
        panelMain.setBackground(Color.BLACK);
        this.add(panelMain);
    }
    public void disableAllBtn(){
        btn9.setEnabled(false);
        btn8.setEnabled(false);
        btn7.setEnabled(false);
        btn6.setEnabled(false);
        btn5.setEnabled(false);
        btn4.setEnabled(false);
        btn3.setEnabled(false);
        btn2.setEnabled(false);
        btn1.setEnabled(false);
        btn0.setEnabled(false);
        btnPunto.setEnabled(false);
    }
    public void enableAllBtn(boolean isPeso) {
        btn9.setEnabled(true);
        btn8.setEnabled(true);
        btn7.setEnabled(true);
        btn6.setEnabled(true);
        btn5.setEnabled(true);
        btn4.setEnabled(true);
        btn3.setEnabled(true);
        btn2.setEnabled(true);
        btn1.setEnabled(true);
        btn0.setEnabled(true);
        if(isPeso){
            btnPunto.setEnabled(true);
        }
    }
    public void showError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
