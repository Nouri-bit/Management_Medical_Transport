package net.model;

import java.math.BigInteger;
import java.util.Date;
public class Seance {
private int idseance; 
public int getIdseance() {
	return idseance;
}
public void setIdseance(int idseance) {
	this.idseance = idseance;
}
private String titre;
private int type;
private float duree;
private int tranche; 
private boolean attente;
private Long idpatient;
private String  jour;
private float kmreel;
private Date date;
private double distance; 
private Long idchauffeur;
private String etat; 
private double montant;

public float getDuree() {
	return duree;
}
public void setDuree(float duree) {
	this.duree = duree;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public double getDistance() {
	return distance;
}
public void setDistance(double distance2) {
	this.distance = distance2;
}
public Seance() {
	super();
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
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
public Long getIdchauffeur() {
	return idchauffeur;
}
public void setIdchauffeur(Long idchauffeur) {
	this.idchauffeur = idchauffeur;
}


}
