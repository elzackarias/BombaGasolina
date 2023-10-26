 class DataReturn {
    String servido;
    String disponible;
    String costoTotal;
    boolean isExceed;
    public DataReturn(String servido, String disponible, String costoTotal, boolean isExceed) {
        this.servido = servido;
        this.disponible = disponible;
        this.costoTotal = costoTotal;
        this.isExceed = isExceed;
    }
}
