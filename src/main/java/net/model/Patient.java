package net.model;

import java.math.BigInteger;

//import javax.persistence.Column;
//@Table(name="Patient")
public class Patient {
    
	private Long NSS;
	private String Nom;
	private String Prenom;
	private String Addresse;
	//private int idChauffeur;
	public Long getNSS() {
		return NSS;
	}
	public void setNSS(Long nSS) {
		this.NSS = nSS;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String Nom) {
		 this.Nom=Nom ;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}
	public String getAddresse() {
		return Addresse;
	}
	public void setAddresse(String Addresse) {
		this.Addresse = Addresse;
	}
	

}
