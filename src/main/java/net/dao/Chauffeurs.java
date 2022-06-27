package net.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.model.Agent;
import net.model.Chauffeur;
import net.model.Seance;

public class Chauffeurs {
	public List<Chauffeur> Rembourssement() throws ClassNotFoundException{
	
		ArrayList<Chauffeur> users= new ArrayList<Chauffeur>();
		
		String sql = "SELECT nss, nom, prenom, mail, idoperateur, type, photo\r\n"
				+ "	FROM public.\"chauffeur \";"; 
		Class.forName("org.postgresql.Driver")	;
		try {
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			ResultSet t=statement.executeQuery();
			
			 while(t.next()) {
				// t.getResultList();
				 ArrayList<Seance> ss= new ArrayList<Seance>();
				 double total=0;
				Chauffeur A= new Chauffeur();
				A.setMail(t.getString("mail"));
				A.setNom(t.getString("nom"));
				A.setNss(t.getLong("nss"));
				A.setPhoto(t.getString("photo"));
				A.setPrenom(t.getString("prenom"));
				A.setType(t.getInt("type"));
				A.setIdoperateur(t.getInt("idoperateur"));
				System.out.println(A.getNss());
				String sql2= "select dt, jr, kml, att, ty , tr, idd, dr from (select s.date dt , s.jour jr, s.idseance idd, s.duree dr,  s.kmreel kml, s.attente att, s.type ty, s.tranche tr  from \r\n"
						+ "public.\"chauffeur \" ch , public.seance s  where ch.nss=? and s.idchauffeur = ch.nss and s.kmreel>0 and s.etat='valide' ) resultat ; "; 
				PreparedStatement statement2=connection.prepareStatement(sql2);
				statement2.setLong(1,A.getNss());
				ResultSet t2=statement2.executeQuery();
				while (t2.next()) {
					
					Seance seance = new Seance();
					seance.setJour(t2.getString("jr"));
					seance.setIdseance(t2.getInt("idd"));
					seance.setKmreel(t2.getFloat("kml"));
					seance.setAttente(t2.getBoolean("att"));
					seance.setType(t2.getInt("tr"));
					seance.setTranche(t2.getInt("ty"));
					seance.setDuree(Float.valueOf(t2.getString("dr")));
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
					seance.setDate(simpleDateFormat.parse(t2.getString("dt")));
					
String squl="SELECT tr, compte FROM (SELECT ch.nss numero, count(*) compte, s.tranche tr\r\n"
		+ "													FROM public.\"chauffeur \" ch, public.\"seance\" s , public.\"patient\" p\r\n"
		+ "													where   s.date=? and s.tranche=? and ch.nss=? and ch.nss= s.idchauffeur and p.nss= s.idpatient \r\n"
		+ "							                             \r\n"
		+ "														group by s.tranche , ch.nss \r\n"
		+ "														\r\n"
		+ "														order by count(*) , numero)\r\n"
		+ "														resultat\r\n"
		+ "														;";
PreparedStatement statement22=connection.prepareStatement(squl);
	statement22.setString(1, ""+seance.getDate());
	statement22.setInt(2, seance.getTranche());
	statement22.setLong(3, A.getNss());
	ResultSet t22=statement22.executeQuery();
	if(t22.next()) {
	int nombre= t22.getInt("compte");
    double dis=0;
    double montant=0;
      if (nombre==1) {
    	  if((t2.getString("jr").equals("samedi")) || (t2.getString("jr").equals("vendredi")) || (t2.getInt("tr")==3)) {
          	float duree= Float.valueOf(t2.getString("dr"));
          	if(A.getType()==1) {
					if(seance.isAttente()==true) {
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=(((100*27)+(dis*19))+ (25*(duree/0.25)))*1.25;
							}
							else {
								montant=((27*(seance.getKmreel())+ (25*(duree/0.25))))*1.25;
							}
						
						
					}
					else {
						if(seance.getKmreel()>100) {
						dis= seance.getKmreel()-100;
						montant=((100*27)+(dis*19))*1.25;
						}
						else {
							montant=(27*(seance.getKmreel()))*1.25;
						}
					}
				}
				else if (A.getType()==2) {
					if(seance.isAttente()==true) {
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=(((100*18)+(dis*13.5)+ (25*(duree/0.25))))*1.25;
							}
							else {
								montant=((18*(seance.getKmreel())+ (25*(duree/0.25))))*1.25;
							}
						
					}
					else {
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=((100*18)+(dis*13.5))*1.25;
							}
							else {
								montant=(18*(seance.getKmreel()))*1.25;
							}
						}
						
					
				}
				else {
					if(seance.isAttente()==true) {
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=(((100*12)+(dis*9)+ (25*(duree/0.25))))*1.25;
							}
							else {
								montant=((12*(seance.getKmreel())+ (25*(duree/0.25))))*1.25;
							}	
						
					}
					else {
						if(seance.getKmreel()>100) {
						dis= seance.getKmreel()-100;
						montant=((100*12)+(dis*9))*1.25;
						}
						else {
							montant=(12*(seance.getKmreel()))*1.25;
						}
					}
					
				}
          }
          /// cas non jour férié + non flil 
          /////////////////////////////////////
          else {
				if(A.getType()==1) {
					if(seance.isAttente()==true) {
						float duree= Float.valueOf(t2.getString("dr"));
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=((100*27)+(dis*19)) + (25*(duree/0.25));
							}
							else {
								montant=(27*(seance.getKmreel()))+ (25*(duree/0.25));
							}
						
					}
					else {
						if(seance.getKmreel()>100) {
						dis= seance.getKmreel()-100;
						montant=(100*27)+(dis*19);
						}
						else {
							montant=27*(seance.getKmreel());
						}
					}
				}
				else if (A.getType()==2) {
					float duree= Float.valueOf(t2.getString("dr"));
					if(seance.isAttente()==true) {
						if(seance.getKmreel()>100) {
							
							dis= seance.getKmreel()-100;
							montant=((100*18)+(dis*13.5)) + (25*(duree/0.25));
							}
							else {
								montant=(18*(seance.getKmreel()))+ (25*(duree/0.25));
							}
						
					}
					else {
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=(100*18)+(dis*13.5);
							}
							else {
								montant=18*(seance.getKmreel());
							}
						}
						
					
				}
				else {
					if(seance.isAttente()==true) {
						float duree= Float.valueOf(t2.getString("dr"));
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=((100*12)+(dis*9))+ (25*(duree/0.25));
							}
							else {
								montant=(12*(seance.getKmreel())) + (25*(duree/0.25));
							}
						
					}
					else {
						if(seance.getKmreel()>100) {
						dis= seance.getKmreel()-100;
						montant=((100*12)+(dis*9));
						}
						else {
							montant=(12*(seance.getKmreel()));
						}
					}
					
				}}
      }
      else {
    	  if((t2.getString("jr").equals("samedi")) || (t2.getString("jr").equals("vendredi")) || (t2.getInt("tr")==3)) {
          	float duree= Float.valueOf(t2.getString("dr"));
          	if(A.getType()==1) {
					if(seance.isAttente()==true) {
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=(((100*27)+(dis*19))*1.25)+ (25*(duree/0.25));
							montant = montant*0.5;
							}
							else {
								montant=((27*(seance.getKmreel()))*1.25)+ (25*(duree/0.25));
								montant = montant*0.5;
							}
						
						
					}
					else {
						if(seance.getKmreel()>100) {
						dis= seance.getKmreel()-100;
						montant=((100*27)+(dis*19))*1.25;
						montant = montant*0.5;
						}
						else {
							montant=(27*(seance.getKmreel()))*1.25;
							montant = montant*0.5;
						}
					}
				}
				else if (A.getType()==2) {
					if(seance.isAttente()==true) {
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=(((100*18)+(dis*13.5))*1.25)+ (25*(duree/0.25));
							montant = montant*0.5;
							}
							else {
								montant=((18*(seance.getKmreel()))*1.25)+ (25*(duree/0.25));
								montant = montant*0.5;
							}
						
					}
					else {
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=((100*18)+(dis*13.5))*1.25;
							montant = montant*0.5;
							}
							else {
								montant=(18*(seance.getKmreel()))*1.25;
								montant = montant*0.5;
							}
						}
						
					
				}
				else {
					if(seance.isAttente()==true) {
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=(((100*12)+(dis*9))+ (25*(duree/0.25)))*1.25;
							montant = montant*0.5;
							}
							else {
								montant=((12*(seance.getKmreel()))+ (25*(duree/0.25)))*1.25;
								montant = montant*0.5;
							}	
						
					}
					else {
						if(seance.getKmreel()>100) {
						dis= seance.getKmreel()-100;
						montant=((100*12)+(dis*9))*1.25;
						montant = montant*0.5;
						}
						else {
							montant=(12*(seance.getKmreel()))*1.25;
							montant = montant*0.5;
						}
					}
					
				}
          }
          /// cas non jour férié + non flil 
          /////////////////////////////////////
          else {
				if(A.getType()==1) {
					if(seance.isAttente()==true) {
						float duree= Float.valueOf(t2.getString("dr"));
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=((100*27)+(dis*19)) + (25*(duree/0.25));
							montant = montant*0.5;
							}
							else {
								montant=(27*(seance.getKmreel()))+ (25*(duree/0.25));
								montant = montant*0.5;
							}
						
					}
					else {
						if(seance.getKmreel()>100) {
						dis= seance.getKmreel()-100;
						montant=(100*27)+(dis*19);
						montant = montant*0.5;
						}
						else {
							montant=27*(seance.getKmreel());
							montant = montant*0.5;
						}
					}
				}
				else if (A.getType()==2) {
					float duree= Float.valueOf(t2.getString("dr"));
					if(seance.isAttente()==true) {
						if(seance.getKmreel()>100) {
							
							dis= seance.getKmreel()-100;
							montant=((100*18)+(dis*13.5)) + (25*(duree/0.25));
							montant = montant*0.5;
							}
							else {
								montant=(18*(seance.getKmreel()))+ (25*(duree/0.25));
								montant = montant*0.5;
							}
						
					}
					else {
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=(100*18)+(dis*13.5);
							montant = montant*0.5;
							}
							else {
								montant=18*(seance.getKmreel());
								montant = montant*0.5;
							}
						}
						
					
				}
				else {
					if(seance.isAttente()==true) {
						float duree= Float.valueOf(t2.getString("dr"));
						if(seance.getKmreel()>100) {
							dis= seance.getKmreel()-100;
							montant=((100*12)+(dis*9))+ (25*(duree/0.25));
							montant = montant*0.5;
							}
							else {
								montant=(12*(seance.getKmreel())) + (25*(duree/0.25));
								montant = montant*0.5;
							}
						
					}
					else {
						if(seance.getKmreel()>100) {
						dis= seance.getKmreel()-100;
						montant=((100*12)+(dis*9));
						montant = montant*0.5;
						}
						else {
							montant=(12*(seance.getKmreel()));
							montant = montant*0.5;
						}
					}
					
				}} 
      }
               
					seance.setMontant(montant);
					System.out.println(montant);
					System.out.println(seance.getIdseance());
					ss.add(seance);
					total=total + montant;
				}}
				A.setSeance(ss);
				A.setTotal(total);
				users.add(A);
			 }
			 
		}

		catch(Exception e){
			e.printStackTrace();
		};
		return users;
	}
	//////////////////////////////////////// LISTE DES CHAUFFEURS /////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<Chauffeur> liste_chauffeurs() throws ClassNotFoundException{
		
		ArrayList<Chauffeur> users= new ArrayList<Chauffeur>();
		
		String sql = "SELECT nss, nom, prenom, mail, idoperateur, type, photo\r\n"
				+ "	FROM public.\"chauffeur \";"; 
		Class.forName("org.postgresql.Driver")	;
		try {
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/2cs_project_18","postgres", "20001999");
			PreparedStatement statement=connection.prepareStatement(sql);
			ResultSet t=statement.executeQuery();
			
			 while(t.next()) {
				// t.getResultList();
				 
				Chauffeur A= new Chauffeur();
				A.setMail(t.getString("mail"));
				A.setNom(t.getString("nom"));
				A.setNss(t.getLong("nss"));
				A.setPhoto(t.getString("photo"));
				A.setPrenom(t.getString("prenom"));
				A.setType(t.getInt("type"));
				A.setIdoperateur(t.getInt("idoperateur"));
				users.add(A);
			 }
			
		}

		catch(Exception e){
			e.printStackTrace();
		};

		return users;
	}
 
}
