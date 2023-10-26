public class BombaModelo {
    private int litrosDeposito;
    private boolean isPeso;
    private float precioLitro, cantidadServidaEnLitros, totalEnPesos;
    public BombaModelo(){
        litrosDeposito = 1000;
        precioLitro = (float)21;
        isPeso = false;
    }
    public BombaModelo(int capacidadInicial){
        litrosDeposito = capacidadInicial;
        precioLitro = (float)21;
        isPeso = false;
    }
    public void setPrecioLitro(float nuevoPrecio){
        precioLitro = nuevoPrecio;
    }
    public float getPrecioLitro(){
        return precioLitro;
    }
    public void setLitrosDeposito(int nuevosLitrosDeposito){
        litrosDeposito = nuevosLitrosDeposito;
    }
    public int getLitrosDeposito(){
        return litrosDeposito;
    }
    public void despachar(int litrosSolicitados){
        if(litrosSolicitados > litrosDeposito){
            System.out.println("No hay suficiente gasolina en el depósito. Se despachan " + litrosDeposito + " litros.");
            litrosSolicitados = litrosDeposito;
        }
        float costoTotal = litrosSolicitados * precioLitro;
        litrosDeposito -= litrosSolicitados;
        System.out.println("Litros servidos: " + litrosSolicitados);
        System.out.println("Litros disponibles en el depósito: " + litrosDeposito);
        System.out.println("Costo total: $" + costoTotal);
    }
    public void despachar(float cantidadPesos){
        int litros = convertPesoToLiters(cantidadPesos);
        despachar(litros);
    }

    public int convertPesoToLiters(float cantidadPesos){
        System.out.println(cantidadPesos);
        return (int) (cantidadPesos / precioLitro);
    }

    public float convertLitersToPeso(int cantidadLitros){
        return cantidadLitros * precioLitro;
    }

    public void setIsPeso(boolean isPeso){
        this.isPeso = isPeso;
    }
    public boolean getIsPeso(){
        return isPeso;
    }
    public void mostrarEstado(){

    }
}
