package net.model;

public class Seance {
private String text;
private int type;
private int tranche; 
private boolean attente;
private int idpatient;
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
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
public int getIdpatient() {
	return idpatient;
}
public void setIdpatient(int idpatient) {
	this.idpatient = idpatient;
}

}
