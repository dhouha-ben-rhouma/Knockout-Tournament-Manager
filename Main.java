package projett;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Tournoi tournoi = new Tournoi(); // Création d'un objet Tournoi
        
        boolean running = true;
        
        while (running) {
            afficherMenu(); // Affiche le menu
            int choix = scanner.nextInt(); // Lecture du choix de l'utilisateur
            scanner.nextLine(); // Consommer la ligne restante
            
            switch (choix) {
                case 1:
                    // Entrer les équipes
                    tournoi.entrerEquipes(scanner);
                    break;
                case 2:
                    // Organiser les matchs pour un niveau
                    System.out.print("Entrez le niveau de la compétition (ex: 1/8 de finale): ");
                    int niveau = scanner.nextInt();
                    tournoi.organiserMatchs(niveau);
                    break;
                case 3:
                    // Afficher le calendrier des matchs
                    tournoi.afficherCalendrier();
                    break;
                case 4:
                    // Afficher la liste des équipes participantes avec le nombre de matchs gagnés
                    tournoi.afficherResultats();
                    break;
                case 5:
                    // Afficher les équipes éliminées avec leur niveau d’élimination
                    System.out.println("\n--- Équipes éliminées ---");
                    for (Equipe e : tournoi.getEquipes()) {
                        if (e.isEliminee()) {
                            System.out.println(e.getNom() + " - Niveau d'élimination: " + e.getNiveauElimination());
                        }
                    }
                    break;
                case 6:
                    // Afficher les équipes encore en compétition
                    System.out.println("\n--- Équipes encore en compétition ---");
                    for (Equipe e : tournoi.getEquipes()) {
                        if (!e.isEliminee()) {
                            System.out.println(e.getNom());
                        }
                    }
                    break;
                case 7:
                    // Afficher le classement final
                    tournoi.afficherClassementFinal();
                    break;
                case 8:
                    // Quitter le programme
                    System.out.println("Fin du programme.");
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
        
        scanner.close();
    }

	public static void afficherMenu() {

	    System.out.println("||************************************************************************************************||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||                        #########    ##    #########      ###                                   ||");
	    System.out.println("||                        ##           ##    ##            ## ##                                  ||");
	    System.out.println("||                        ##           ##    ##           ##   ##                                 ||");
	    System.out.println("||                        ######       ##    ######      #########                                ||");
	    System.out.println("||                        ##           ##    ##         ##       ##                               ||");
	    System.out.println("||                        ##           ##    ##        ##         ##                              ||");
	    System.out.println("||                        ##           ##    ##       ##           ##                             ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||************************************************************************************************||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||                                   MENU PRINCIPAL                                               ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||************************************************************************************************||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||   1. Entrer la liste des équipes                                                               ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||   2. Organiser les matchs d’un niveau                                                          ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||   3. Afficher le calendrier des matchs                                                         ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||   4. Afficher les résultats des matchs                                                         ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||   5. Afficher les équipes éliminées                                                            ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||   6. Afficher les équipes encore en compétition                                                ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||   7. Afficher le classement final                                                              ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||   8. Quitter                                                                                   ||");
	    System.out.println("||                                                                                                ||");
	    System.out.println("||************************************************************************************************||");
	    System.out.print  ("|| 👉 Entrez votre choix : ");
	}
}