package net.model;

public class Patient {
	private int NSS;
	private String Nom;
	private String Prenom;
	private String Addresse;
	private int idChauffeur;
	public int getNSS() {
		return NSS;
	}
	public void setNSS(int nSS) {
		NSS = nSS;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getAddresse() {
		return Addresse;
	}
	public void setAddresse(String Addresse) {
		Addresse = Addresse;
	}
	public int getIdChauffeur() {
		return idChauffeur;
	}
	public void setIdChauffeur(int idChauffeur) {
		this.idChauffeur = idChauffeur;
	}
	

}
