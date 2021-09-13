/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientetaller;

import java.time.LocalDate;
import java.util.Scanner;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author fbhda
 */
public class Consumer {
    
    public static void main(String args[]){
        int option,id;
        Trip trip;
        Scanner scanner = new Scanner(System.in);
        
        TripServiceConsumer tripService = new TripServiceConsumer();
        do{
            option = selectOption();
            switch(option){
                case 0:
                    break;
                case 1:
                    //id - name - departure - destination - date
                    System.out.println("*****Listado de paseos*******");
                    String leftAlignFormat = "| %-5s | %-20s | %-20s | %-20s | %-10s |%n";
                    System.out.format(leftAlignFormat, "ID" , "Nombre", "Origen", "Destino", "Fecha");
                    for(Trip t: tripService.getAllTrips()){
                        System.out.format(leftAlignFormat, t.getID(), t.getName(), t.getDeparture(), t.getDestination(), t.getDate());
                    }
                    break;
                
                case 2:
                    System.out.println("Ingrese el ID del paseo a eliminar: ");
                    id = scanner.nextInt();
                    System.out.println(tripService.deleteTrip(id));
                    break;
                    
                case 3:
                    System.out.println("Ingrese el ID del paseo a modificar");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    
                    trip = new Trip();
                    
                    System.out.println("Ingrese el nuevo país de origen: ");
                    trip.setDeparture(scanner.nextLine());
                    
                    System.out.println("Ingrese el nuevo país de destino: ");
                    trip.setDestination(scanner.nextLine());
                    
                    trip = tripService.updateTrip(id, trip);
                    if(trip != null){
                        System.out.println("El paseo fue actualizado exitosamente, los nuevos datos son: ");
                        System.out.println(trip.toString());
                    }else{
                        System.out.println("No fue posible actualizar los datos del paseo");
                    }
                    
                    break;
                    
                case 4:
                    trip = new Trip();
                    System.out.println("Nombre del paseo: ");
                    trip.setName(scanner.nextLine());
                   
                    System.out.println("País de origen: ");
                    trip.setDeparture(scanner.nextLine());
                    
                    System.out.println("País de destino: ");
                    trip.setDestination(scanner.nextLine());
                    
                    System.out.println("Fecha: ");
                    trip.setDate(LocalDate.parse(scanner.nextLine()));
                    
                    trip = tripService.createTrip(trip);
                    if(trip != null){
                        System.out.println("El paseo fue creado con exito con los siguientes datos");
                        System.out.println(trip.toString());
                    }else{
                        System.out.println("No fue posible crear el paseo");
                    }
                    break;
                    
                default:
                    System.out.println("Opción inválida, vuelva a intentar");
                    break;
            }
            System.out.println("");
        }while(option != 0);
    }   
    
    
    public static int selectOption(){
        int op = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("******Menu*******");
        System.out.println("1) Obtener listado de paseos");
        System.out.println("2) Borrar paseo");
        System.out.println("3) Modificar origen y destino");
        System.out.println("4) Crear paseo");
        System.out.println("0) Salir");
   
        System.out.println("");
        
        System.out.println("Seleccione: ");
        op = scanner.nextInt();
        //scanner.close();
        return op;
    }
    
    public void createTrip(){
    }
}
