package p2lab5_rigobertobarahona;

import java.util.Scanner;
import java.util.ArrayList;

public class P2LabExamen {
    static Scanner lea = new Scanner(System.in);

    public static void main(String[] args) {
        
        boolean flag = true;
        char [][] matriz = new char[8][8];
        ArrayList<Robot> robots = new ArrayList();
        
        while (flag == true){
            System.out.println("1) Crear Robot ");
            System.out.println("2) Listar Robot");
            System.out.println("3) Simular Automaticamente");
            System.out.println("4) Actuar Manualmente");
            System.out.println("5) Salir");
            System.out.print("Eligir Opcion: ");
            int opcion = lea.nextInt();
            switch(opcion){
                case 1: {
                    boolean repeticion = false;
                    System.out.print("ID (Numerico y Unico): ");
                    int ID = lea.nextInt();
                    if (robots.isEmpty()){
                        repeticion = false;
                    }else{
                        for (int i = 0; i < robots.size(); i++){
                            if (ID == robots.get(i).getID() ){
                                repeticion = true;
                            }
                        }
                    }
                    if (repeticion == true){
                        System.out.println("Repeticion Detectada");
                    }else{
                        System.out.print("Posicion X: ");
                        int X = lea.nextInt();
                        System.out.print("Posicion Y: ");
                        int Y = lea.nextInt();
                        System.out.print("Esta Cargado (S/N): ");
                        char detectar = lea.next().charAt(0);
                        boolean carga = false;
                        if (detectar == 'S' || detectar == 's'){
                            carga = true;
                        }
                        String fecha = "";
                        System.out.print("Fecha de Fabricacion: ");
                        fecha = lea.next();
                        System.out.println("1) Mano Robotica");
                        System.out.println("2) Movil Agil");
                        System.out.println("3) Androide");
                        System.out.println("4) Movil Pesado");
                        System.out.print("Eligir Tipo de Robot: ");
                        int opcion2 = lea.nextInt();
                        ArrayList<Character> load = new ArrayList();
                        switch(opcion2){
                            case 1:{
                                robots.add(new Mano(ID, X, Y, carga, fecha, load) );
                                System.out.println("Mano Robotica Agregado");
                                break;
                            }
                            case 2: {
                                robots.add( new MovilAgil(ID, X, Y, carga, fecha, load) );
                                System.out.println("Robot Movil Agil Agregado");
                                break;
                            }
                            case 3: {
                                robots.add( new Androide( ID, X, Y, carga, fecha, load) );
                                System.out.println("Androide Agregado");
                                break;
                            }
                            case 4: {
                                robots.add( new MovilPesado( ID, X, Y , carga, fecha, load) );
                                System.out.println("Robot Movil Pesado Agregado");
                                break;
                            }
                            default:{
                                System.out.println("Hubo un error");
                                break;
                            }
                        }
                    }
                    //Fin de Case
                    break;
                }
                case 2: {
                    if (robots.isEmpty() ){
                        System.out.println("No hay Robots registrados");
                    }else{
                        String salida = "";
                        for (Object temp : robots) {
                            if (temp instanceof Robot){
                                salida += robots.indexOf(temp) + " - " + temp + "\n";
                            }
                        }
                        System.out.println(salida);
                    }
                    break;
                }
                case 3: {
                    int cont = 0;
                    if (robots.isEmpty() ){
                        System.out.println("No hay robots");
                    } else{
                        for (int i = 0; i < robots.size() ; i++){
                            if (robots.get(i) instanceof Mano){
                                
                            }else{
                                cont++;
                            }
                        }
                    }
                    if (cont == 0){
                        System.out.println("Las Manos Roboticas No Pueden Automaticarse");
                    }else{
                        String salida = "";
                        for (Object temp : robots) {
                            if (temp instanceof Robot){
                                salida += robots.indexOf(temp) + " - " + temp + "\n";
                            }
                        }
                        System.out.println(salida);
                        System.out.print("Seleccionar Indice: ");
                        int indice = lea.nextInt();
                        ArrayList<Robot> simulacion = new ArrayList();
                        simulacion.add( robots.get(indice) );
                        boolean Sim = true;
                        // Fin de Juego
                        simulacion.clear();
                    }
                    //Fin de Case
                    break;
                }
                case 4:{
                                 int cont = 0;
                    if (robots.isEmpty() ){
                        System.out.println("No hay robots");
                    } else{
                        for (int i = 0; i < robots.size() ; i++){
                            if (robots.get(i) instanceof MovilAgil){
                                
                            }else{
                                cont++;
                            }
                        }
                    }
                    if (cont == 0){
                        System.out.println("Las Robots Agiles No Pueden Automaticarse");
                    }else{
                        String salida = "";
                        for (Object temp : robots) {
                            if (temp instanceof Robot){
                                salida += robots.indexOf(temp) + " - " + temp + "\n";
                            }
                        }
                        System.out.println(salida);
                        System.out.print("Seleccionar Indice: ");
                        int indice = lea.nextInt();
                        ArrayList<Robot> simulacion = new ArrayList();
                        simulacion.add( robots.get(indice) );
                        boolean Sim = true;
                        // Fin de Juego
                        simulacion.clear();
                    }
                    //Fin de Caso
                    break;
                }
                case 5:{
                    matriz = Fill(matriz);
                    Imprimir(matriz);
                    break;
                }
                default: {
                    flag = false;
                    break;
                }
            }
        }
        
    }
    public static void Imprimir(char [][] matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print("[" + matriz[i][j] + "]");            
            }
            System.out.println();
        }
    }
     public static char [][] Fill (char [][] matriz){
        char[][] temp = matriz;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = ' ';
            }
        }
        temp [0][0] = 'R';
        temp [7][7] = 'D';
        
        temp [0][7] = 'C';
        temp [1][4] = 'C';
        temp [2][0] = 'C';
        
        temp [6][0] = 'C';
        temp [7][2] = 'C';
        temp [7][5] = 'C';
        
        temp[0][1] = 'X';
        temp[0][2] = 'X';
        temp[1][5] = 'X';
        temp[2][2] = 'X';
        temp[2][7] = 'X';
        temp[3][0] = 'X';
        temp[3][4] = 'X';
        temp[3][6] = 'X';
        temp[3][7] = 'X';
        
        temp[5][2] = 'X';
        temp[5][3] = 'X';
        temp[5][5] = 'X';
        temp[6][7] = 'X';
        temp[7][0] = 'X';
        temp[7][3] = 'X';
        return temp;
    }
    
}
