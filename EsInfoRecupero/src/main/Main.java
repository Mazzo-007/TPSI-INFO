package main;

import RivenditaVeicoli.Rivendita;
import RivenditaVeicoli.Moto;
import RivenditaVeicoli.Auto;

public class Main {

    public static void main(String[] args) {

        Auto[] listaAuto = {
            new Auto("Fiat", "500", 2002, 5),
            new Auto("Volkswagen", "Golf", 2015, 5),
            new Auto("Toyota", "Yaris", 2020, 5),
            new Auto("Ford", "Focus", 2018, 5),
            new Auto("BMW", "Serie 3", 2017, 5),
            new Auto("Audi", "A4", 2019, 5),
            new Auto("Mercedes", "Classe A", 2021, 5),
            new Auto("Peugeot", "208", 2016, 5),
            new Auto("Renault", "Clio", 2014, 5),
            new Auto("Fiat", "Panda", 2022, 5)
        };

        Moto[] listamoto = {
            new Moto("Beta", "RR", 2021, false),
            new Moto("Yamaha", "R1", 2019, false),
            new Moto("Kawasaki", "Ninja 650", 2020, false),
            new Moto("Honda", "CBR 500", 2018, false),
            new Moto("Ducati", "Panigale V4", 2021, false),
            new Moto("Suzuki", "GSX-R750", 2017, false),
            new Moto("KTM", "Duke 390", 2022, false),
            new Moto("Harley-Davidson", "Iron 883", 2016, true),
            new Moto("Triumph", "Street Triple", 2019, true),
            new Moto("Aprilia", "RS 660", 2023, false)
        };

        Rivendita r = new Rivendita("Rivendita1", 12);
        Rivendita r1 = new Rivendita("Rivendita2", listamoto);

        r.add(listamoto[4]);
        r.add(listaAuto[6]);
        r.add(listaAuto[3]);
        r.add(listamoto[2]);
        r.add(listamoto[0]);

        System.out.println(r.read());
        System.out.println(r1.read());

        System.out.println(r.read(3));
        System.out.println(r.read(1));
        System.out.println(r1.read(9));
        System.out.println(r1.read(5));
    }
}