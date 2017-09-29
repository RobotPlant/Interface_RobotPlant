package com.RobotPlant.SerialTest;

import java.util.Scanner;

public class JavaSerialIntegration {

	public static void main(String[] args) throws Exception {
        SerialPortCom serialPortCom = new SerialPortCom();
        String[] ports = serialPortCom.getAvailableSerialPorts();
        System.out.println("Serial ports on the computer are:");
        for (int i = 0; i < ports.length; i++) {
            System.out.println((i + 1) + ". " + ports[i]);
        }

        System.out.println("Chose the serial port desired (1 , 2 , anything), and press enter: ");
        Scanner scanner = new Scanner(System.in);
        int selectedPort = scanner.nextInt();
        String port = ports[selectedPort - 1];

        System.out.println("You will use the port: " + port);
        serialPortCom.initialize(port);
        System.out.println("Sending A....");
        // Send text A
        serialPortCom.sendData("A");
        System.out.println("A has been received");
        // Wait 10 seconds
        System.out.println("Waiting 10 seconds...");
        Thread.sleep(1000000);

        System.out.println("Sending 1....");
        // Send text 1
        serialPortCom.sendData("1");
        System.out.println("1 has been received");
        // Wait 10 seconds
        System.out.println("Waiting 10 seconds...");
        Thread.sleep(1000000);


        serialPortCom.closeConnection();
        System.out.println("Serial communication has finished");
    }

}
