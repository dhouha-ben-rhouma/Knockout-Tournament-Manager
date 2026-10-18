package projett;

public class Equipe {
    
    private int id;
    private String nom;
    private String couleur;
    private int niveauElimination; // ex: "8", "4", "2", "1"
    private boolean eliminee;
    private int nbVictoires;

    

    public Equipe(int id, String nom, String couleur) {
        this.id = id;
        this.nom = nom;
        this.couleur = couleur;
        this.eliminee = false;
        this.niveauElimination =0;
        this.nbVictoires=0;
    }
    
    public void gagnerMatch() {
		nbVictoires++;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getNbVictoires() {
        return nbVictoires;
    }

    public boolean isEliminee() {
        return eliminee;
    }

    public void eliminer(int niveau) {
        this.eliminee = true;
        this.niveauElimination = niveau;
    }

    public int getNiveauElimination() {
        return niveauElimination;
    }

    public String toString() {
        return "Equipe [ID=" + id + ", Nom=" + nom + ", Couleur=" + couleur +
               ", Matchs gagnés=" + nbVictoires +
               ", Élimination=" + niveauElimination + "]";
    }
    
}