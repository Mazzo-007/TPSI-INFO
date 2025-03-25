package Glax9.distributor;

import Glax9.distributorException.*;

import java.util.Arrays;

public class DistributoreGalattico {
    //ATTRIBUTI

    private int altezza, flavorIndex, temperatura, statoQuiete, maxAltezza, countdownStatoQuiete;
    private String[] flavor = {
            "Energia Oscura al Cioccolato Galattico",
            "Antimateria alla Vaniglia Cosmica",
            "Quasar al Caramello Stellare",
            "Gravitone al Pistacchio Lunare",
            "Singolarità alla Menta Spaziale",
            "Protone al Limone Nebulare",
            "Materia Strana al Cocco Interdimensionale",
            "Pulsar al Caffè Wormhole",
            "Bosone di Higgs alla Nocciola Astrofisica",
            "Supernova ai Frutti di Andromeda"
    };

    //METODI

    //COSTRUTTORE
    public DistributoreGalattico(int maxAltezza, int temperatura, int flavorIndex, int altezza, int countdownStatoQuiete) {
        this.maxAltezza = maxAltezza;
        this.temperatura = temperatura;
        this.flavorIndex = flavorIndex;
        this.altezza = altezza;
        this.countdownStatoQuiete = countdownStatoQuiete;
        statoQuiete = 0;
    }

    //GET & SET
    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public int getFlavorIndex() {
        return flavorIndex;
    }

    public void setFlavorIndex(int flavorIndex) {
        this.flavorIndex = flavorIndex;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getStatoQuiete() {
        return statoQuiete;
    }

    public void setStatoQuiete(int statoQuiete) {
        this.statoQuiete = statoQuiete;
    }

    public int getMaxAltezza() {
        return maxAltezza;
    }

    public void setMaxAltezza(int maxAltezza) {
        this.maxAltezza = maxAltezza;
    }

    public int getCountdownStatoQuiete() {
        return countdownStatoQuiete;
    }

    public void setCountdownStatoQuiete(int countdownStatoQuiete) {
        this.countdownStatoQuiete = countdownStatoQuiete;
    }

    public String[] getFlavor() {
        return flavor;
    }

    public void setFlavor(String[] flavor) {
        this.flavor = flavor;
    }

    //SIMULA
    public void simula() throws GelatoOverloadException, CosmicSugarStormException, ThermodynamicViolationException, RebellionException, WarException {
        int maxExpan = 10;
        int minExpan = 1;

        int maxTemp = 10;
        int minTemp = 1;

        altezza += (int) (Math.random()*(maxExpan - minExpan + 1)) + minExpan;
        temperatura -= (int) (Math.random()*(maxTemp - minTemp + 1)) + minTemp;

        if (temperatura <= 0) {
            throw new WarException("Il gelato si sta solidificando! E' scoppiata una guerra di Gelato chiudiamo tutto!");
        }

        if (altezza >= maxAltezza) {
            throw new GelatoOverloadException("Il distributore ha raggiunto un'altezza pericolosa per il pianeta!");
        }

        if (Math.random() <= 0.2) {
            flavorIndex = (int) (Math.random()*(flavor.length));
            System.out.println("Il distributore è impazzito, ha cambiato il gusto!\n");
        }

        if (Math.random() <= 0.15) {
            throw new CosmicSugarStormException("Oh no il distributore è stato colpito da una tempesta!");
        }

        if (Math.random() <= 0.05) {
            throw new ThermodynamicViolationException("Non è possibile! La temperatura è scesa sotto lo zero assoluto!");
        }

        if (statoQuiete >= 7) {
            if (countdownStatoQuiete > 0) {
                System.out.println("Gli alieni stanno sospettando per la calma! Attivo mod Zarglax");
                System.out.println("Ribelione in : " + countdownStatoQuiete);
                countdownStatoQuiete--;
            } else {
                throw new RebellionException("Gli alieni ci hanno scoperto!");
            }
        }
    }

    //TO STRING
    @Override
    public String toString() {
        return "DistributoreGalattico di Glax-9\n" +
                "  Altezza attuale: " + altezza +
                "\n  Gusto attuale: " + flavor[flavorIndex] +
                "\n  Temperatura attuale: " + temperatura +
                "\n  Cicli in stato di quiete: " + statoQuiete;
    }
}
