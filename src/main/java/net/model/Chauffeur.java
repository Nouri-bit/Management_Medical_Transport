package net.model;

public class Chauffeur {
private Long nss;
private String nom;
private String prenom;
private String photo;
private String mail;
private String pwd;
private int idoperateur;

public int getIdoperateur() {
	return idoperateur;
}
public void setIdoperateur(int idoperateur) {
	this.idoperateur = idoperateur;
}
private int type;
public Long getNss() {
	return nss;
}
public void setNss(Long nss) {
	this.nss = nss;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}

}
