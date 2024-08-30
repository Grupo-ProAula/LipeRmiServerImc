package rmi.imc;

import rmi.imc.net.ServerIMC;

public class Main {

    public static void main(String[] args) {
        ServerIMC service = new ServerIMC();
        try {
            service.Start();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
