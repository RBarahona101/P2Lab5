package p2lab5_rigobertobarahona;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class P2LabExamen {
    static Scanner lea = new Scanner(System.in);
    static Random r = new Random();
    
    public static void main(String[] args) {
        
        boolean flag = true;
        char [][] matriz = new char[8][8];
        ArrayList<Robot> robots = new ArrayList();
        ArrayList<Character> ip = new ArrayList();
        robots.add( new Mano (80085, 0, 0, true, "Hoy", ip ) );
        robots.add( new MovilAgil( 7171, 0, 0, true, "Ayer", ip ) );
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
                            if (temp instanceof Mano){
                                
                            } else {
                                salida += robots.indexOf(temp) + " - " + temp + "\n";
                            }
                        }
                        System.out.println(salida);
                        System.out.print("Seleccionar Indice: ");
                        int indice = lea.nextInt();
                        ArrayList<Robot> simulacion = new ArrayList();
                        simulacion.add( robots.get(indice) );
                        ArrayList<Character> canasta = new ArrayList();
                        int X = 0;
                        int Y = 0;
                        
                        SimulacionAutomatica(matriz, simulacion, canasta, X, Y);
                        // Fin de Juego
                        simulacion.clear();
                        canasta.clear();
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
                        System.out.println("Las Robots Agiles No Pueden Manejarse");
                    }else{
                        String salida = "";
                        for (Object temp : robots) {
                            if (temp instanceof MovilAgil){
                            
                            }else{
                                salida += robots.indexOf(temp) + " - " + temp + "\n";
                            }
                        }
                        System.out.println(salida);
                        System.out.print("Seleccionar Indice: ");
                        int indice = lea.nextInt();
                        ArrayList<Robot> simulacion = new ArrayList();
                        simulacion.add( robots.get(indice) );
                        boolean Sim = true;
                        
                        boolean C1;
                        boolean C2;
                        boolean C3;
                        boolean C4; 
                        boolean C5;
                        boolean C6;
                        
                        int rotacion = 180;
                        ArrayList<Character> canasta = new ArrayList();
                        matriz = Fill(matriz);
                        int X = 0;
                        int Y = 0;
                        
                        Robot r = new Robot();
                        
                        try{    
                        while (Sim == true){
                            Imprimir(matriz, X, Y);
                            String d = "Abajo";
                            if (rotacion == 0){
                                d = "Arriba";
                            }else if (rotacion == 90){
                                d = "Derecha";
                            } else if (rotacion == 180){
                                d = "Abajo";
                            } else if (rotacion == 270){
                                d = "Izquierda";
                            }
                            System.out.println(simulacion + " esta viendo " + d);
                            System.out.print("Introducir Comando [adv/chr/dmnt/gir/exit]: ");
                            String cm = lea.next();
                            switch (cm){
                                case "exit": {
                                    Sim = false;
                                    break;
                                }
                                case "adv":{
                                    if (rotacion == 0){
                                        if (Y - 1 >= 0){
                                            if( matriz[Y-1][X] !=  'X'){
                                                Y = Y - 1;
                                            }else{
                                                System.out.println("Bop");
                                            }
                                        }
                                    } else if (rotacion == 90 ){
                                        if (X + 1 <= 7){
                                            if (matriz[Y][X+1] != 'X'){
                                                X = X + 1;
                                            }
                                            else{
                                                System.out.println("Bop");
                                            }
                                        }
                                    } else if (rotacion == 180 ){
                                        if (Y + 1 <= 7){
                                            if (matriz[Y+1][X] != 'X'){
                                                Y = Y + 1;
                                            }else{
                                                System.out.println("Bop");
                                            }
                                        }
                                    } else if (rotacion == 270){
                                        if (X - 1 >= 0){
                                            if (matriz[Y][X-1] != 'X'){
                                                X = X - 1;
                                            }else{
                                                System.out.println("Bop");
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "chr": {
                                    if (Y == 0 && X == 7) {
                                       /* if( r.chr(simulacion) == true) {
                                        matriz[0][7] = ' '; 
                                        }
                                       */
                                       if (simulacion.get(0) instanceof Mano){
                                           if ( ( (Mano) simulacion.get(0) ).getLoad().isEmpty() ){
                                               ( (Mano) simulacion.get(0) ).getLoad().add('C');
                                               matriz[0][7] = ' ';
                                               System.out.println("Yoink");
                                           }
                                           
                                        } else if ( simulacion.get(0) instanceof Androide ){
                                            if ( ( (Androide) simulacion.get(0) ).getLoad().size() < 2 ){
                                               ( (Androide) simulacion.get(0) ).getLoad().add('C');
                                               matriz[0][7] = ' ';  
                                               System.out.println("Yoink");
                                            }
                                        } else {
                                            ( (MovilPesado) simulacion.get(0) ).getLoad().add('C');
                                            matriz[0][7] = ' '; 
                                            System.out.println("Yoink");
                                        }
                                    } else if (Y == 1 && X == 4){
                                        if (simulacion.get(0) instanceof Mano){
                                           if ( ( (Mano) simulacion.get(0) ).getLoad().isEmpty() ){
                                               ( (Mano) simulacion.get(0) ).getLoad().add('C');
                                               matriz[1][4] = ' ';
                                               System.out.println("Yoink");
                                           }
                                           
                                        } else if ( simulacion.get(0) instanceof Androide ){
                                            if ( ( (Androide) simulacion.get(0) ).getLoad().size() < 2 ){
                                               ( (Androide) simulacion.get(0) ).getLoad().add('C');
                                               matriz[1][4] = ' ';
                                               System.out.println("Yoink");
                                            }
                                        } else {
                                            ( (MovilPesado) simulacion.get(0) ).getLoad().add('C');
                                            matriz[1][4] = ' '; 
                                            System.out.println("Yoink");
                                        }
                                    }else if (Y == 2 && X == 0){
                                        if (simulacion.get(0) instanceof Mano){
                                           if ( ( (Mano) simulacion.get(0) ).getLoad().isEmpty() ){
                                               ( (Mano) simulacion.get(0) ).getLoad().add('C');
                                               matriz[2][0] = ' ';
                                               System.out.println("Yoink");
                                           }
                                           
                                        } else if ( simulacion.get(0) instanceof Androide ){
                                            if ( ( (Androide) simulacion.get(0) ).getLoad().size() < 2 ){
                                               ( (Androide) simulacion.get(0) ).getLoad().add('C');
                                               matriz[2][0] = ' ';
                                               System.out.println("Yoink");
                                            }
                                        } else {
                                            ( (MovilPesado) simulacion.get(0) ).getLoad().add('C');
                                            matriz[2][0] = ' '; 
                                            System.out.println("Yoink");
                                        }
                                    }else if (Y == 6 && X == 0){
                                      if (simulacion.get(0) instanceof Mano){
                                           if ( ( (Mano) simulacion.get(0) ).getLoad().isEmpty() ){
                                               ( (Mano) simulacion.get(0) ).getLoad().add('C');
                                               matriz[6][0] = ' ';
                                               System.out.println("Yoink");
                                           }
                                           
                                        } else if ( simulacion.get(0) instanceof Androide ){
                                            if ( ( (Androide) simulacion.get(0) ).getLoad().size() < 2 ){
                                               ( (Androide) simulacion.get(0) ).getLoad().add('C');
                                               matriz[6][0] = ' ';
                                               System.out.println("Yoink");
                                            }
                                        } else {
                                            ( (MovilPesado) simulacion.get(0) ).getLoad().add('C');
                                            matriz[6][0] = ' '; 
                                            System.out.println("Yoink");
                                        }
                                    }else if (Y == 7 && X == 0){
                                        if (simulacion.get(0) instanceof Mano){
                                           if ( ( (Mano) simulacion.get(0) ).getLoad().isEmpty() ){
                                               ( (Mano) simulacion.get(0) ).getLoad().add('C');
                                               matriz[7][0] = ' ';
                                               System.out.println("Yoink");
                                           }
                                           
                                        } else if ( simulacion.get(0) instanceof Androide ){
                                            if ( ( (Androide) simulacion.get(0) ).getLoad().size() < 2 ){
                                               ( (Androide) simulacion.get(0) ).getLoad().add('C');
                                               matriz[7][0] = ' '; 
                                               System.out.println("Yoink");
                                            }
                                        } else {
                                            ( (MovilPesado) simulacion.get(0) ).getLoad().add('C');
                                            matriz[7][0] = ' '; 
                                            System.out.println("Yoink");
                                        }
                                    } else if (Y == 7 && X == 3){
                                        if (simulacion.get(0) instanceof Mano){
                                           if ( ( (Mano) simulacion.get(0) ).getLoad().isEmpty() ){
                                               ( (Mano) simulacion.get(0) ).getLoad().add('C');
                                               matriz[7][3] = ' ';
                                               System.out.println("Yoink");
                                           }
                                           
                                        } else if ( simulacion.get(0) instanceof Androide ){
                                            if ( ( (Androide) simulacion.get(0) ).getLoad().size() < 2 ){
                                               ( (Androide) simulacion.get(0) ).getLoad().add('C');
                                               matriz[7][3] = ' ';  
                                               System.out.println("Yoink");
                                            }
                                        } else {
                                            ( (MovilPesado) simulacion.get(0) ).getLoad().add('C');
                                            matriz[7][3] = ' '; 
                                            System.out.println("Yoink");
                                        }
                                    } else{
                                        System.out.println("Nope");
                                    }
                                    break;
                                }
                                case "dmnt": {
                                    if (Y == 7 && X == 7){
                                        if (simulacion.get(0) instanceof Mano){
                                            ( (Mano) simulacion.get(0) ).getLoad().clear();
                                            canasta.add('C');
                                            System.out.println("Can't have shite in Detroit");
                                        } else if (simulacion.get(0) instanceof Androide){
                                            for (int i = 0; i < ( (Androide) simulacion.get(0) ).getLoad().size() ; i++){
                                                canasta.add('C');
                                            }
                                            ( (Androide) simulacion.get(0) ).getLoad().clear();
                                            System.out.println("Can't have shite in Detroit");
                                        } else {
                                            if ( ((MovilPesado) simulacion.get(0) ).getLoad().size() >= 5){
                                                for (int i = 0; i < ((MovilPesado) simulacion.get(0) ).getLoad().size(); i++){
                                                    canasta.add('C');
                                                }
                                                ((MovilPesado) simulacion.get(0) ).getLoad().clear();
                                                System.out.println("Can't have shite in Detroit");
                                            }else{
                                                System.out.println("Ha agarrar mas");
                                            }
                                        }   
                                    }else{
                                        System.out.println("Nope querida");
                                    }
                                    break;
                                }
                                case "gir": {
                                    System.out.print("Ingresar Angulo[0, 90, 180, 270]: ");
                                    int R = lea.nextInt();
                                    if (R == 0 || R == 90 || R == 180 || R == 270){
                                        rotacion = R;
                                    }else{
                                        System.out.println("Eso no se puede huey");
                                    }
                                    break;
                                }
                                default: {
                                    System.out.println("Nope querido");
                                    break;
                                }
                            }
                            //Fin de While
                            if (canasta.size() == 6){
                                Sim = false;
                            }
                        }
                        System.out.println("La simulacion ha terminado");
                        // Fin de Juego
                        simulacion.clear();
                        canasta.clear();
                    } catch(Exception IndexoutofBounds){
                        System.out.println("Oops");
                    }
                    }
                    //Fin de Caso
                    break;
                }
                default: {
                    flag = false;
                    break;
                }
            }
        }
        
    }
    public static void Imprimir(char [][] matriz, int X, int Y){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (Y == i && X == j){
                    System.out.print("[R]");
                }else{
                    System.out.print("[" + matriz[i][j] + "]");    
                }
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

    public static void SimulacionAutomatica(char[][] matriz, ArrayList<Robot> simulacion, ArrayList<Character> canasta, int X, int Y) {
        boolean Sim = true;
        int rotacion = 180;
        while (Sim == true) {
            int random1 = r.nextInt(3);
            switch(random1){
                case 0: {
                    rotacion = 0;
                    break;
                }
                case 1: {
                    rotacion = 90;
                    break;
                }
                case 2: {
                    rotacion = 180;
                    break;
                }
                case 3: {
                    rotacion = 270;
                    break;
                }
                default: {
                    rotacion = 180;
                    break;
                }
            }
            Imprimir(matriz, X, Y);
            String d = "Abajo";
            if (rotacion == 0) {
                d = "Arriba";
            } else if (rotacion == 90) {
                d = "Derecha";
            } else if (rotacion == 180) {
                d = "Abajo";
            } else if (rotacion == 270) {
                d = "Izquierda";
            }
            System.out.println(simulacion + " esta viendo " + d);
            int random2 = r.nextInt(3);
            switch (random2) {
                case 0: {
                    if (rotacion == 0) {
                        if (Y - 1 >= 0) {
                            if (matriz[Y - 1][X] != 'X') {
                                Y = Y - 1;
                            } else {
                                System.out.println("Bop");
                            }
                        }
                    } else if (rotacion == 90) {
                        if (X + 1 <= 7) {
                            if (matriz[Y][X + 1] != 'X') {
                                X = X + 1;
                            } else {
                                System.out.println("Bop");
                            }
                        }
                    } else if (rotacion == 180) {
                        if (Y + 1 <= 7) {
                            if (matriz[Y + 1][X] != 'X') {
                                Y = Y + 1;
                            } else {
                                System.out.println("Bop");
                            }
                        }
                    } else if (rotacion == 270) {
                        if (X - 1 >= 0) {
                            if (matriz[Y][X - 1] != 'X') {
                                X = X - 1;
                            } else {
                                System.out.println("Bop");
                            }
                        }
                    }
                    break;
                }
                case 1: {
                    if (Y == 0 && X == 7) {
                        /* if( r.chr(simulacion) == true) {
                                        matriz[0][7] = ' '; 
                                        }
                         */
                        if (simulacion.get(0) instanceof Mano) {
                            if (((Mano) simulacion.get(0)).getLoad().isEmpty()) {
                                ((Mano) simulacion.get(0)).getLoad().add('C');
                                matriz[0][7] = ' ';
                                System.out.println("Yoink");
                            }

                        } else if (simulacion.get(0) instanceof Androide) {
                            if (((Androide) simulacion.get(0)).getLoad().size() < 2) {
                                ((Androide) simulacion.get(0)).getLoad().add('C');
                                matriz[0][7] = ' ';
                                System.out.println("Yoink");
                            }
                        } else {
                            ((MovilPesado) simulacion.get(0)).getLoad().add('C');
                            matriz[0][7] = ' ';
                            System.out.println("Yoink");
                        }
                    } else if (Y == 1 && X == 4) {
                        if (simulacion.get(0) instanceof Mano) {
                            if (((Mano) simulacion.get(0)).getLoad().isEmpty()) {
                                ((Mano) simulacion.get(0)).getLoad().add('C');
                                matriz[1][4] = ' ';
                                System.out.println("Yoink");
                            }

                        } else if (simulacion.get(0) instanceof Androide) {
                            if (((Androide) simulacion.get(0)).getLoad().size() < 2) {
                                ((Androide) simulacion.get(0)).getLoad().add('C');
                                matriz[1][4] = ' ';
                                System.out.println("Yoink");
                            }
                        } else {
                            ((MovilPesado) simulacion.get(0)).getLoad().add('C');
                            matriz[1][4] = ' ';
                            System.out.println("Yoink");
                        }
                    } else if (Y == 2 && X == 0) {
                        if (simulacion.get(0) instanceof Mano) {
                            if (((Mano) simulacion.get(0)).getLoad().isEmpty()) {
                                ((Mano) simulacion.get(0)).getLoad().add('C');
                                matriz[2][0] = ' ';
                                System.out.println("Yoink");
                            }

                        } else if (simulacion.get(0) instanceof Androide) {
                            if (((Androide) simulacion.get(0)).getLoad().size() < 2) {
                                ((Androide) simulacion.get(0)).getLoad().add('C');
                                matriz[2][0] = ' ';
                                System.out.println("Yoink");
                            }
                        } else {
                            ((MovilPesado) simulacion.get(0)).getLoad().add('C');
                            matriz[2][0] = ' ';
                            System.out.println("Yoink");
                        }
                    } else if (Y == 6 && X == 0) {
                        if (simulacion.get(0) instanceof Mano) {
                            if (((Mano) simulacion.get(0)).getLoad().isEmpty()) {
                                ((Mano) simulacion.get(0)).getLoad().add('C');
                                matriz[6][0] = ' ';
                                System.out.println("Yoink");
                            }

                        } else if (simulacion.get(0) instanceof Androide) {
                            if (((Androide) simulacion.get(0)).getLoad().size() < 2) {
                                ((Androide) simulacion.get(0)).getLoad().add('C');
                                matriz[6][0] = ' ';
                                System.out.println("Yoink");
                            }
                        } else {
                            ((MovilPesado) simulacion.get(0)).getLoad().add('C');
                            matriz[6][0] = ' ';
                            System.out.println("Yoink");
                        }
                    } else if (Y == 7 && X == 0) {
                        if (simulacion.get(0) instanceof Mano) {
                            if (((Mano) simulacion.get(0)).getLoad().isEmpty()) {
                                ((Mano) simulacion.get(0)).getLoad().add('C');
                                matriz[7][0] = ' ';
                                System.out.println("Yoink");
                            }

                        } else if (simulacion.get(0) instanceof Androide) {
                            if (((Androide) simulacion.get(0)).getLoad().size() < 2) {
                                ((Androide) simulacion.get(0)).getLoad().add('C');
                                matriz[7][0] = ' ';
                                System.out.println("Yoink");
                            }
                        } else {
                            ((MovilPesado) simulacion.get(0)).getLoad().add('C');
                            matriz[7][0] = ' ';
                            System.out.println("Yoink");
                        }
                    } else if (Y == 7 && X == 3) {
                        if (simulacion.get(0) instanceof Mano) {
                            if (((Mano) simulacion.get(0)).getLoad().isEmpty()) {
                                ((Mano) simulacion.get(0)).getLoad().add('C');
                                matriz[7][3] = ' ';
                                System.out.println("Yoink");
                            }

                        } else if (simulacion.get(0) instanceof Androide) {
                            if (((Androide) simulacion.get(0)).getLoad().size() < 2) {
                                ((Androide) simulacion.get(0)).getLoad().add('C');
                                matriz[7][3] = ' ';
                                System.out.println("Yoink");
                            }
                        } else {
                            ((MovilPesado) simulacion.get(0)).getLoad().add('C');
                            matriz[7][3] = ' ';
                            System.out.println("Yoink");
                        }
                    } else {
                        System.out.println("Nope");
                    }
                    break;
                }
                case 2: {
                    if (Y == 7 && X == 7) {
                        if (simulacion.get(0) instanceof MovilAgil) {
                            ((MovilAgil) simulacion.get(0)).getLoad().clear();
                            canasta.add('C');
                            System.out.println("Can't have shite in Detroit");
                        } else if (simulacion.get(0) instanceof Androide) {
                            for (int i = 0; i < ((Androide) simulacion.get(0)).getLoad().size(); i++) {
                                canasta.add('C');
                            }
                            ((Androide) simulacion.get(0)).getLoad().clear();
                            System.out.println("Can't have shite in Detroit");
                        } else {
                            if (((MovilPesado) simulacion.get(0)).getLoad().size() >= 5) {
                                for (int i = 0; i < ((MovilPesado) simulacion.get(0)).getLoad().size(); i++) {
                                    canasta.add('C');
                                }
                                ((MovilPesado) simulacion.get(0)).getLoad().clear();
                                System.out.println("Can't have shite in Detroit");
                            } else {
                                System.out.println("Ha agarrar mas");
                            }
                        }
                    } else {
                        System.out.println("Nope querida");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Ingresar Angulo[0, 90, 180, 270]: ");
                    int R = r.nextInt(3);
                    switch(R){
                        case 0: {
                            R = 0;
                            break;
                        }
                        case 1: {
                            R = 90;
                            break;
                        }
                        case 2: {
                            R = 180;
                            break;
                        }
                        case 3: {
                            R = 270;
                            break;
                        }
                        default: {
                            R = 0;
                            break;
                        }
                    }
                    rotacion = R;
                    break;
                }
                default: {
                    System.out.println("Beep Boop");
                    break;
                }
            }
            //Fin de While
            if (canasta.size() == 6) {
                Sim = false;
            }
        }
    }
}
