package p2lab5_rigobertobarahona;

import java.util.ArrayList;

public class MovilAgil extends Robot{
    
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

    public MovilAgil() {
    }

    public MovilAgil(int ID, int X, int Y, boolean carga, String fecha, ArrayList<Character> load) {
        super(ID, X, Y, carga, fecha);
        this.load = load;
    }

    @Override
    public int adv() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean chr(ArrayList<Robot> simulacion) {
        
        if ( ( (MovilAgil)simulacion.get(0) ).getLoad().isEmpty() ){
           ( (MovilAgil) simulacion.get(0) ).getLoad().add('C');
           return true;
        } else{
           return false;
        }
    }

    public void dmnt(ArrayList<Robot> simulacion, ArrayList<Character> canasta) {
        ( (MovilAgil) simulacion.get(0) ).getLoad().clear();
        canasta.add('C');
    }

    @Override
    public int gir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean movimiento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int status(){
        return 2;
    }
        @Override
    public String toString() {
        return "Robot Agil " + ID;
    }
    
}
