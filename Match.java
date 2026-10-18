package projett;


public class Match {
	private Equipe equipe1 , equipe2;
	private Equipe vainqueur;
	private int niveau;
	
	public Match (Equipe equipe1,Equipe equipe2, int niveau) {
		this.equipe1=equipe1;
		this.equipe2=equipe2;
		this.niveau=niveau;
	}
	
	public Equipe getEquipe2() {
		return equipe2;
	}
	
	public Equipe getEquipe1() {
		return equipe1;
	}
	
	public void jouerMatch() {

	    int scoreEquipe1 = (int) (Math.random() * 10);
	    int scoreEquipe2 = (int) (Math.random() * 10);

	    System.out.println("Match: " + equipe1.getNom() + " vs " + equipe2.getNom());
	    System.out.println("Score: " + equipe1.getNom() + " " + scoreEquipe1 +
	                       " - " + scoreEquipe2 + " " + equipe2.getNom());

	    // 🟢 Cas 1 : équipe 1 gagne
	    if (scoreEquipe1 > scoreEquipe2) {
	        vainqueur = equipe1;
	        equipe1.gagnerMatch();
	        equipe2.eliminer(niveau);
	    }
	    // 🟢 Cas 2 : équipe 2 gagne
	    else if (scoreEquipe2 > scoreEquipe1) {
	        vainqueur = equipe2;
	        equipe2.gagnerMatch();
	        equipe1.eliminer(niveau);
	    }
	    // 🔴 Cas 3 : égalité → tirs au but
	    else {
	        int tab1, tab2;

	        do {
	            tab1 = (int) (Math.random() * 6); // 0 à 5
	            tab2 = (int) (Math.random() * 6);
	        } while (tab1 == tab2); // pas d’égalité aux TAB

	        System.out.println("⚽ Tirs au but : " +
	                equipe1.getNom() + " " + tab1 +
	                " - " + tab2 + " " + equipe2.getNom());

	        if (tab1 > tab2) {
	            vainqueur = equipe1;
	            equipe1.gagnerMatch();
	            equipe2.eliminer(niveau);
	        } else {
	            vainqueur = equipe2;
	            equipe2.gagnerMatch();
	            equipe1.eliminer(niveau);
	        }
	    }

	    System.out.println("Vainqueur du match: " + vainqueur.getNom());
	}


    public Equipe getVainqueur() {
        return vainqueur;
    }
    
    public int getNiveau() {
		return niveau;
    }

}