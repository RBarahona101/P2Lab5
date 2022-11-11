package p2lab5_rigobertobarahona;

import java.util.ArrayList;

public class Mano extends Robot {
    
    protected ArrayList<Character> load = new ArrayList();

    public ArrayList<Character> getLoad() {
        return load;
    }

    public void setLoad(ArrayList<Character> load) {
        this.load = load;
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

    public Mano() {
    }

    public Mano(int ID, int X, int Y, boolean carga, String fecha, ArrayList<Character> load) {
        super(ID, X, Y, carga, fecha);
        this.load = load;
    }
    
    
    
    public int adv() {
       int temp = 0;
       return temp;
    }

    @Override
    public ArrayList<Character> chr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Character> dmnt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int gir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean movimiento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
