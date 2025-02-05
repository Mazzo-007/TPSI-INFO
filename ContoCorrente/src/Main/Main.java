package Main;

import CCManagement.CC;
import java.util.Scanner;

import CCManagement.CifraNegativaException;
import CCManagement.SaldoInsufficienteException;
import java.util.InputMismatchException;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean stato = true, check;
        int scelta = 0;

        System.out.println("CREAZIONE CONTO CORRENTE");
        System.out.print("Inserisci il nome del titolare del conto: ");
        CC contocorrente = new CC(scanner.next());

        do {
            do {
                try {
                    System.out.println("Conto corrente di: " + contocorrente.getNomeCorrentista());
                    System.out.print("Opzioni:\n   1. Preleva\n   2. Deposita\n   3. Stampa conto\n   4. Esci\nSeleziona: ");
                    scelta = scanner.nextInt();
                    scanner.nextLine();
                    check = false;
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("Input non valido, inserisci un numero");
                    check = true;
                }
            } while (check);

            switch (scelta) {
                case 1 -> {
                    do {
                        try {
                            System.out.print("Inserisci la cifra da prelevare: ");
                            contocorrente.preleva(scanner.nextDouble());
                            scanner.nextLine();
                            System.out.println("Prelievo effetuato con successo");
                            check = false;
                        } catch (CifraNegativaException | SaldoInsufficienteException e) {
                            System.out.println(e.getMessage());
                            check = true;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Input non valido, inserisci un numero");
                            check = true;
                        }
                    } while (check);
                }
                case 2 -> {
                    do {
                        try {
                            System.out.print("Inserisci la cifra da depositare: ");
                            contocorrente.deposita(scanner.nextDouble());
                            scanner.nextLine();
                            System.out.println("Deposito effetuato con successo");
                            check = false;
                        } catch (CifraNegativaException e) {
                            System.out.println(e.getMessage());
                            check = true;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Input non valido, inserisci un numero");
                            check = true;
                        }
                    } while (check);
                }
                case 3 -> System.out.println(contocorrente);
                case 4 -> stato = false;
                default -> System.out.println("Opzione inesistente");
            }
        } while (stato);
    }
}