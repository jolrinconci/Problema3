/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema3;

/**
 *Clase que nos permite asignar un puesto disponible en un parqueadero, 
 *mostrar puestos disponibles, calcular valor a pagar y mostrar el 
 * ingreso diario.
 * 
 * @author José Luis Rincón y Diana Marcela Molina
 * @version 1.0
 * since 02/24/2016
 */
public class PROBLEMA3 {

    /**
     * @param args the command line arguments
     */
    static String placas[]=new String [88];
    static int  puestos[]=new int [88];//0= disponible/ 1=ocupado;
    static double horas[]=new double [88];
    static double ingresosDia=0;
    static double tarifa=2000;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        valoresIniciales();
        java.util.Scanner lectura=new java.util.Scanner(System.in);
        boolean salida=false;
        int opcionMenu;
        while(!salida){
            mostrarMenu();
            opcionMenu = lectura.nextInt();
            System.out.print("\n");//salto de linea.
            if(opcionMenu==0){
                salida=true;
            }
            else if(opcionMenu==1){
                asignarPuestoParqueadero();
            }
            else if(opcionMenu==2){
                mostrarPuestosParqueadero();
            }
            else if(opcionMenu==3){
                calcularPrecio();
            }
            else if(opcionMenu==4){
                 mostrarIngresosDia();
            }
            else{
                System.out.println("No ha seleccionado una opción válida.");
            }
                    
        }
        
    }
    static void valoresIniciales(){
        for(int i = 1; i<88; i++){
            puestos[i]=0;
        }
    }
    static void mostrarMenu(){
        System.out.println("\n\n0: Salir");
        System.out.println("1: Asignar puesto");
        System.out.println("2: Mostrar puestos disponibles");
        System.out.println("3: Calcular valor a pagar"); 
        System.out.println("4: Mostrar ingresos del día");
    }
    static void asignarPuestoParqueadero(){
        String placa;
        double hora;
        boolean salida=false;
        java.util.Scanner lectura=new java.util.Scanner(System.in);
        System.out.println("Ingrese la placa:");
        placa=lectura.next();
        System.out.println("Ingrese la hora:");
        hora=lectura.nextDouble();
        for(int i = 1; i<88; i++){
            if(puestos[i]==0 && salida==false){
                placas[i]=placa;
                horas[i]=hora;
                puestos[i]=1;
                salida=true;
                System.out.println("El puesto asignado para parquear es: "+i);
            }
        }     
    }
    static void mostrarPuestosParqueadero(){
        for(int i =1; i<88; i++){
            if(puestos[i]==0){
                System.out.print(i+" ");
            }
            else{
                System.out.print("x ");
            }
            if(i%16==0){
                System.out.print("\n");
            }
        }
    }
    static void calcularPrecio(){
        double hora;
        int puesto;
        double precio;
        java.util.Scanner lectura=new java.util.Scanner(System.in);
        System.out.println("Ingrese el puesto:");
        puesto=lectura.nextInt();
        System.out.println("Ingrese la hora de salida:");
        hora=lectura.nextDouble();
        precio=(hora-horas[puesto])*tarifa;
        ingresosDia=ingresosDia+precio;
        System.out.println("el valor a pagar del puesto "+puesto+" es: $"+precio);
        horas[puesto]=0;
        puestos[puesto]=0;
        placas[puesto]=null;
        
    }
    static void mostrarIngresosDia(){
        System.out.println("Los ingresos del día son: $"+ingresosDia);
    }
}