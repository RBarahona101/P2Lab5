package p2lab5_rigobertobarahona;

import java.util.ArrayList;

public abstract class Robot {
    
    protected int ID;
    protected int X;
    protected int Y; 
    protected boolean carga;
    protected String fecha;
    
    public Robot() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public boolean isCarga() {
        return carga;
    }

    public void setCarga(boolean carga) {
        this.carga = carga;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Robot(int ID, int X, int Y, boolean carga, String fecha) {
        this.ID = ID;
        this.X = X;
        this.Y = Y;
        this.carga = carga;
        this.fecha = fecha;
    }
    
    public abstract int adv();
    
    public abstract ArrayList<Character> chr();
    
    public abstract ArrayList<Character> dmnt();
    
    public abstract int gir();
    
    public abstract boolean movimiento();
}
