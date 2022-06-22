package net.model;


public class Seance {
private String titre;
private int type;
private int tranche; 
private boolean attente;
private Long idpatient;
private String  jour;
private float kmreel;
private Long idChauffeur;
public Long getIdChauffeur() {
	return idChauffeur;
}
public void setIdChauffeur(Long idChauffeur) {
	this.idChauffeur = idChauffeur;
}
public float getKmreel() {
	return kmreel;
}
public void setKmreel(float kmreel) {
	this.kmreel = kmreel;
}
public String getJour() {
	return jour;
}
public void setJour(String  jour) {
	this.jour = jour;
}
public String gettitre() {
	return titre;
}
public void settitre(String titre) {
	this.titre = titre;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getTranche() {
	return tranche;
}
public void setTranche(int tranche) {
	this.tranche = tranche;
}
public boolean isAttente() {
	return attente;
}
public void setAttente(boolean attente) {
	this.attente = attente;
}
public Long getIdpatient() {
	return idpatient;
}
public void setIdpatient(Long idpatient) {
	this.idpatient = idpatient;
}

}
