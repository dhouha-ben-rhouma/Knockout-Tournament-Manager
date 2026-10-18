package projett;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tournoi {

	private ArrayList<Equipe> equipes;
	private ArrayList<Match> matchs;

	public Tournoi() {
		equipes = new ArrayList<>();
		matchs = new ArrayList<>();
	}

	private boolean equipeExiste(String nom) {
		for (Equipe e : equipes) {
			if (e.getNom().equalsIgnoreCase(nom)) {
				return true;
			}
		}
		return false;
	}

	private boolean couleurValide(String couleur) {
		String[] couleursAutorisees = { "rouge", "bleu", "vert", "jaune", "noir", "blanc" };

		for (String c : couleursAutorisees) {
			if (c.equalsIgnoreCase(couleur)) {
				return true;
			}
		}
		return false;
	}
	private boolean niveauDejaJoue(int niveau) {
        for (Equipe e : equipes) {
            if (e.getNiveauElimination() == niveau) {
                return true;
            }
        }
        return false;
    }

    private int niveauAttendu() {
        int equipesRestantes = 0;

        for (Equipe e : equipes) {
            if (e.getNiveauElimination() == 0) {
                equipesRestantes++;
            }
        }

        return equipesRestantes / 2;
    }

	public void entrerEquipes(Scanner sc) {
			System.out.println("\n--- Entrée des équipes (16 équipes) ---");

			for (int i = 1; i <= 16; i++) {
				System.out.println("Équipe " + i + " :");
				String nom;
				String couleur;
				do {
					System.out.print("Nom : ");
					nom = sc.nextLine();

					if (equipeExiste(nom)) {
						System.out.println("❌ Erreur : cette équipe existe déjà. Réessayez.");
					}

				} while (equipeExiste(nom));

				// 🎨 Contrôle de la couleur
				do {
					System.out.print("Couleur : ");
					couleur = sc.nextLine();

					if (!couleurValide(couleur)) {
						System.out.println("❌ Couleur invalide !");
						System.out.println("Couleurs autorisées : rouge, bleu, vert, jaune, noir, blanc");
					}

				} while (!couleurValide(couleur));

				Equipe e = new Equipe(i, nom, couleur);
				equipes.add(e);

				System.out.println("→ Ajoutée !");
			}
		}


	public void organiserMatchs(int niveau) {
		int attendu = niveauAttendu();

	    // ❌ Niveau déjà joué
	    if (niveauDejaJoue(niveau)) {
	        System.out.println("❌ Erreur : ce niveau a déjà été joué.");
	        return;
	    }

	    // ❌ Mauvais ordre
	    if (niveau != attendu) {
	        System.out.println("❌ Erreur : niveau invalide.");
	        System.out.println("Vous devez d'abord jouer le niveau : " + attendu);
	        return;
	    }

		System.out.println("\n--- Organisation des matchs : " + niveau + " ---");

		// Mélanger les équipes pour un tirage au sort
		Collections.shuffle(equipes);

		// On prend les équipes encore en compétition
		ArrayList<Equipe> enCompetition = new ArrayList<>();
		for (Equipe e : equipes) {
			if (e.getNiveauElimination() == 0) {
				enCompetition.add(e);
			}
		}

		// Organisation des matchs (2 par 2)
		for (int i = 0; i < enCompetition.size(); i += 2) {
			Equipe e1 = enCompetition.get(i);
			Equipe e2 = enCompetition.get(i + 1);

			Match m = new Match(e1, e2, niveau);
			m.jouerMatch(); // détermine gagnant + perdant
			matchs.add(m);
		}
	}

	public void afficherCalendrier() {
		System.out.println("\n--- Calendrier des matchs ---");

		for (Match m : matchs) {
			System.out.println(
					m.getEquipe1().getNom() + " VS " + m.getEquipe2().getNom() + " | Niveau : " + m.getNiveau());
		}
	}

	public void afficherResultats() {
		System.out.println("\n--- Résultats des matchs ---");

		for (Match m : matchs) {
			System.out.println(m.getEquipe1().getNom() + " vs " + m.getEquipe2().getNom() + " | Vainqueur : "
					+ m.getVainqueur().getNom());
		}
	}

	public void afficherClassementFinal() {
		System.out.println("\n--- Classement Final ---");

		// Règles du sujet :
		// 1 : vainqueur finale
		// 2 : finaliste perdant
		// 3 : vainqueur match 3e place
		// 4 : perdant match 3e place
		// 5 : éliminés en quart
		// 6 : autres éliminés

		for (Equipe e : equipes) {
			System.out.println(e.getNom() + " | Victoires : " + e.getNbVictoires() + " | Élimination : "
					+ e.getNiveauElimination());
		}
	}

	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}

}