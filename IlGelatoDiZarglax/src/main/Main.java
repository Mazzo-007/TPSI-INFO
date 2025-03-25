package main;

import Glax9.distributor.DistributoreGalattico;
import Glax9.distributorException.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DistributoreGalattico DistributoreGlax9 = new DistributoreGalattico(50, 50, 3, 5, 3);

        System.out.println("Il gelato di Zarglax:");

        while (true) {
            System.out.println("\n-------------------------");

            System.out.println("\nIl distributore sta facendo un nuovo gelato al gusto di: " + DistributoreGlax9.getFlavor()[DistributoreGlax9.getFlavorIndex()] + "\n");

            try {
                DistributoreGlax9.simula();
                DistributoreGlax9.setStatoQuiete(DistributoreGlax9.getStatoQuiete()+1);
                System.out.println(DistributoreGlax9);
            } catch (WarException e) {
                System.out.println(DistributoreGlax9);
                System.out.println("\n" + e.getMessage());
                System.out.println("Dobbiamo staccare tutto!");
                break;
            } catch (GelatoOverloadException e) {
                System.out.println(DistributoreGlax9);
                DistributoreGlax9.setStatoQuiete(0);
                System.out.println("\n" + e.getMessage());
                System.out.println("Avvio il protocollo di compressione criogenica");
                DistributoreGlax9.setAltezza(DistributoreGlax9.getAltezza()/2);
            } catch (CosmicSugarStormException e) {
                System.out.println(DistributoreGlax9);
                DistributoreGlax9.setStatoQuiete(0);
                System.out.println("\n" + e.getMessage());
                Thread.sleep(4000);
            } catch (ThermodynamicViolationException e) {
                System.out.println(DistributoreGlax9);
                System.out.println("\n" + e.getMessage());
                break;
            } catch (RebellionException e) {
                System.out.println(DistributoreGlax9);
                System.out.println("\n" + e.getMessage());
                System.out.println("Oh no! Il distributore è esploso!");
                break;
            }

            Thread.sleep(1000);
        }
    }
}