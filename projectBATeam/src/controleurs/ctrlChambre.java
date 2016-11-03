package controleurs;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import modeles.Model;
import modeles.ProcsE02;
import modeles.modAyant;
import modeles.modChambre;
import modeles.modListAyant;
import modeles.modListCodeLocalisation;
import modeles.modListCodeType;
import windows.winChambre;
import windows.winPickList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;


public class ctrlChambre {

	private static Pattern patternNoCham;
	private static Pattern patternEtage;
	private static Pattern patternPrix;
	private static Pattern patternMemo;

    private static Matcher matcherNoCham;
	private static Matcher matcherEtage;
	private static Matcher matcherPrix;
	private static Matcher matcherMemo;
    
	public modChambre modeleChambre = null;
	public modListCodeType modeleCodeType = null;
	public modListCodeLocalisation modeleCodeLocalisation = null;
	private Model modValide;
	private Model newChambreCodCom;
	private int position = 0;
	public modAyant modeleAyant = null;
	public modListAyant modeleListAyant = null;
	public ctrlChambre(winChambre instance) {
		
		modValide = ProcsE02.SELECT_CHAMBRE();
		newChambreCodCom = ProcsE02.SELECT_CODCOM();
		modeleChambre = new modChambre();	
		AffecteValeurs(instance,position);

	}
	private void AffecteValeurs(winChambre instance, int ligne) {
			
		 modeleChambre.setCourant((int) modeleChambre.getValueAt(ligne,0));
	    //Affichage des informations de la chambre
		
		
		instance.getTxtNoChambre().setText(modeleChambre.getValueAt(ligne, 0).toString()); 
		instance.getTxtEtage().setText(modeleChambre.getValueAt(ligne, 1).toString());   
		instance.getTxtPrix().setText(modeleChambre.getValueAt(ligne, 2).toString());
		instance.getTxtEtat().setText(modeleChambre.getValueAt(ligne, 3).toString());
		instance.getTxtMemo().setText(modeleChambre.getValueAt(ligne, 4).toString());
		instance.getTxtCodTypeCha().setText(modeleChambre.getValueAt(ligne, 5).toString());
		instance.getTxtDescType().setText(modeleChambre.getValueAt(ligne, 6).toString());
		instance.getTxtCodLoc().setText(modeleChambre.getValueAt(ligne, 7).toString());
		instance.getTxtDescLoc().setText(modeleChambre.getValueAt(ligne, 8).toString());

		
		//Affichage des commodité de la chambre
		modeleAyant = new modAyant((int)modeleChambre.getCourant());
		winChambre.setjScrollPane(new JTable(modeleAyant)); 
		
	    
	}
	private void AffecteValeursType(winChambre instance, int ligne) {
		modeleCodeType = new modListCodeType();
		instance.getTxtCodTypeCha().setText(modeleCodeType.getValueAt(ligne, 0).toString());
		instance.getTxtDescType().setText(modeleCodeType.getValueAt(ligne, 1).toString());

	}
	private void AffecteValeursLocalisation(winChambre instance, int ligne) {
		modeleCodeLocalisation = new modListCodeLocalisation();
		instance.getTxtCodLoc().setText(modeleCodeLocalisation.getValueAt(ligne, 0).toString());
		instance.getTxtDescLoc().setText(modeleCodeLocalisation.getValueAt(ligne, 1).toString());
	}
	private void AffecteValeursCommodite(winChambre instance, int ligne) {
		modeleListAyant = new modListAyant(ligne);
		winChambre.addjScrollPane(new JTable(modeleListAyant));
	}
	
	public void Premier(winChambre instance) {
		 position = 0;
	     AffecteValeurs(instance,position);		
	}
	public void BonPrecedent(winChambre instance) {
		if (position> 0)
			position--;
		else position= modeleChambre.getLesEnreg().size()-1;
		modeleChambre.setCourant((int)modeleChambre.getValueAt(position, 0));
		AffecteValeurs(instance,position);	
	}
	public void Dernier(winChambre instance) {
		position = modeleChambre.getLesEnreg().size()-1;
	     AffecteValeurs(instance,position);		
	}
	public void BonSuivant(winChambre instance) {
		if (position< modeleChambre.getLesEnreg().size()-1)
			 position++;
		else position = 0;
		modeleChambre.setCourant((int)modeleChambre.getValueAt(position, 0));
		AffecteValeurs(instance,position);		
	}
	public void ListeChambres (winChambre instance, Boolean AjoutActive){   
	    position = winPickList.pickFromTable(new modChambre(),"listes des chambres");
		AffecteValeurs(instance, position);	
	}
	public void ListeCodType (winChambre instance, Boolean AjoutActive){
		position = winPickList.pickFromTable(new modListCodeType(),"listes des type de chambre");
		AffecteValeursType(instance, position);	
	}
	public void ListeCodLocalisation (winChambre instance, Boolean AjoutActive){
		position = winPickList.pickFromTable(new modListCodeLocalisation(),"listes des code de Localisation");
		AffecteValeursLocalisation(instance, position);	
	}
	public boolean getChckbxEnEtatSelected(winChambre instance) {
		return instance.chckbxEnEtat.isSelected();
	}
	public void setChckbxEnEtatSelected(boolean selected, winChambre instance) {
		instance.chckbxEnEtat.setSelected(selected);
		if(getChckbxEnEtatSelected(instance) == true)
		{
			instance.chckbxHorsDusage.setSelected(false);
		}
		instance.getTxtEtat().setText("1");
	}
	public boolean getChckbxHorsDusageSelected(winChambre instance) {
		return instance.chckbxHorsDusage.isSelected();
	}
	public void setChckbxHorsDusageSelected(boolean selected, winChambre instance) {
		instance.chckbxHorsDusage.setSelected(selected);
		if(getChckbxHorsDusageSelected(instance) == true)
		{
			instance.chckbxEnEtat.setSelected(false);
		}
		instance.getTxtEtat().setText("0");
		
	}
	public void validationChambre(winChambre instance)
	{
		ArrayList<String> errors = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		
		patternNoCham = Pattern.compile("^\\d{1,3}$");
		patternEtage = Pattern.compile("^\\d{1,2}$");
		patternPrix = Pattern.compile("^(\\d{1,4})[.]?(\\d{1,2})$");
		patternMemo = Pattern.compile("^[a-z A-Z]{1,50}$");

        matcherNoCham = patternNoCham.matcher(instance.getTxtNoChambre().getText());
        matcherEtage = patternEtage.matcher(instance.getTxtEtage().getText());
        matcherPrix = patternPrix.matcher(instance.getTxtPrix().getText());
        matcherMemo = patternMemo.matcher(instance.getTxtMemo().getText());

        if(matcherNoCham.find())
        {
	        if(modValide.contains(instance.getTxtNoChambre().getText(), 0)) {
	            errors.add("Le numero de chambre est deja pris\n");
	        }
	        else{
	        	System.out.println(matcherNoCham);
	            System.out.println("Trouvé !");
	        }
        }
	    else
	    {
            errors.add("Le numero de chambre est invalide\n");
	    }
        
        if(matcherEtage.find()) {
        	System.out.println(matcherEtage);
            System.out.println("Trouvé !");

        }
        else{
            errors.add("Le numero de l'étage est invalide\n");
        }
        
        if(matcherPrix.find()) {
        	System.out.println(matcherPrix);
            System.out.println("Trouvé !");

        }
        else{
            errors.add("Le prix est invalide\n");
        }
        
        if(matcherMemo.find()) {
        	System.out.println(matcherMemo);

        }
        else{
            errors.add("Le memo est invalide\n");
        }
        
        if(errors.isEmpty())
        {
        	System.out.println("j'ai aucune erreure");
        	
            values.add(instance.getTxtNoChambre().getText());
            values.add(instance.getTxtEtage().getText());
            values.add(instance.getTxtPrix().getText());
			if(instance.chckbxEnEtat.isSelected())
			{
				values.add("1");
			}
			if(instance.chckbxHorsDusage.isSelected())
			{
				values.add("0");
			}
            values.add(instance.getTxtCodTypeCha().getText());
            values.add(instance.getTxtCodLoc().getText());
            values.add(instance.getTxtMemo().getText());
        	JOptionPane.showMessageDialog(null, values, "Champs validé",JOptionPane.WARNING_MESSAGE);
        	
        	boolean succes = true;
			
			ProcsE02.INSERT_CHAMBRE(values);
			
			for(int i = 0; i < newChambreCodCom.getRowCount() ; i++)
			{
				ProcsE02.INSERT_AYANT(new ArrayList<String>(Arrays.asList(instance.getTxtNoChambre().getText(),newChambreCodCom.getValueAt(i,0).toString())));
			}
		//resultat
	        if(modValide.contains(instance.getTxtNoChambre().getText(), 0)) {
	        	succes = true;
	        }
	        else{
	        	succes = false;
	        }

			
			if(succes)
			{
				JOptionPane.showMessageDialog(instance,"Ajout reussie");
				//this.setConsultationMode();
			}
			else
			{
				JOptionPane.showMessageDialog(instance,"Ajout echoue veuillez contacter l equipe de support");
			}
        }
        else
        {
        	JOptionPane.showMessageDialog(null, errors, "Champs invalides",JOptionPane.ERROR_MESSAGE);
        }
	}
	public void setAjout() 
	{
		newChambreCodCom.empty();		
	}
	public void addCodCom(){

		Model modele = ProcsE02.SELECT_CODCOM();
		modele.substractModele(newChambreCodCom);
		int index = winPickList.pickFromTable(modele,"listes des commodite");
		newChambreCodCom.addRow(new ArrayList<Object>(Arrays.asList((String)modele.getValueAt(index, 0) , (String)modele.getValueAt(index, 1))));
		winChambre.addjScrollPane(new JTable(newChambreCodCom));
		
	}
	public void removeCodCom(){
		newChambreCodCom.removeLastRow();
		winChambre.addjScrollPane(new JTable(newChambreCodCom));
	}

}
