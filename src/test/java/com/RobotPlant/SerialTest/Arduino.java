package com.RobotPlant.SerialTest;

import java.util.Scanner;
import jssc.SerialPort;
import jssc.SerialPortException;

public class Arduino {

public static void main(String[] args) throws InterruptedException,     SerialPortException {

    Scanner scan = new Scanner(System.in);
    int nummer = 0;
 SerialPort serialPort = new SerialPort("COM4");


        while (true) {
            menu();
             if (scan.hasNextInt()) {
            nummer = scan.nextInt();
        } else {
            System.out.println("verkeerde ingave");
        }
        switch (nummer) {
            case 0:
                serialPort.openPort();//Open serial port
        Thread.sleep(1000);
        serialPort.setParams(SerialPort.BAUDRATE_9600, 
                             SerialPort.DATABITS_8,
                             SerialPort.STOPBITS_1,
                             SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);

         serialPort.writeBytes("a".getBytes());//Write data to port
           serialPort.closePort();//Close serial port
                break;
            case 1:
                 serialPort.openPort();//Open serial port
        Thread.sleep(1000);
        serialPort.setParams(SerialPort.BAUDRATE_9600, 
                             SerialPort.DATABITS_8,
                             SerialPort.STOPBITS_1,
                             SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);
         serialPort.writeBytes("b".getBytes());//Write data to port
         serialPort.writeBytes("c".getBytes());//Write data to port
           serialPort.closePort();//Close serial port
                break;

                 case 2:
                serialPort.openPort();//Open serial port
        Thread.sleep(1000);
        serialPort.setParams(SerialPort.BAUDRATE_9600, 
                             SerialPort.DATABITS_8,
                             SerialPort.STOPBITS_1,
                             SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);

         serialPort.writeBytes("d".getBytes());//Write data to port
           serialPort.closePort();//Close serial port
                break;
                 case 3:
                serialPort.openPort();//Open serial port
        Thread.sleep(1000);
        serialPort.setParams(SerialPort.BAUDRATE_9600, 
                             SerialPort.DATABITS_8,
                             SerialPort.STOPBITS_1,
                             SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);

         serialPort.writeBytes("e".getBytes());//Write data to port
           serialPort.closePort();//Close serial port
                break;
        }


}
}

public static void menu() {
    final String ANSI_CLS = "\u001b[2J";
    final String ANSI_HOME = "\u001b[H";
    System.out.print(ANSI_CLS + ANSI_HOME);
    System.out.flush();
    System.out.println("");  
    System.out.println("    ************************************************************************************");
    System.out.println("    *      ***       ********   *******   **    **  *****  **      **      ******      *");
    System.out.println("    *     ** **      **    **   **    **  **    **   ***   ****    **    ***    ***    *");
    System.out.println("    *    **   **     *** ****   **     ** **    **   ***   ** **   **  **          **  *");
    System.out.println("    *   *********    **   **    **     ** **    **   ***   **  **  **  **          **  *");
    System.out.println("    *  **       **   **    **   **    **  **    **   ***   **   ** **    ***    ***    *");
    System.out.println("    * **         **  **     **  *******     ****    *****  **    ****      ******      *");
    System.out.println("    ************************************************************************************");
    System.out.println("");
    System.out.println("    By Emmanouil Perselis");
    System.out.println("");
    System.out.println("What would you like to do?");
    System.out.println("0.---");
    System.out.println("1.Toggle lights");
    System.out.println("2.Toggle air");
    System.out.println("3.---");
    System.out.println("4.---");
}
}
