package controleurs;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import modeles.Model;
import modeles.procsE02;
import modeles.modAyant;
import modeles.modChambre;
import modeles.modListAyant;
import modeles.modListCodeLocalisation;
import modeles.modListCodeType;
import windows.winChambre;
import windows.winChambreRapport;
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
	private int positionPickList = 0;
	public Model modeleAyant = null;
	public modListAyant modeleListAyant = null;
	public ctrlChambre(winChambre instance) {
		
		modValide = procsE02.SELECT_CHAMBRE();
		newChambreCodCom = procsE02.SELECT_CODCOM();
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
		modeleAyant = procsE02.SELECT_AYANT(modeleChambre.getValueAt(ligne, 0).toString());
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
	public void Premier(winChambre instance) {
		 position = 0;
	     System.out.println(position);
	     AffecteValeurs(instance,position);		
	}
	public void BonPrecedent(winChambre instance) {
		if (position> 0)
			position--;
		else position= modeleChambre.getLesEnreg().size()-1;
		modeleChambre.setCourant((int)modeleChambre.getValueAt(position, 0));
	     System.out.println(position);
		AffecteValeurs(instance,position);	
	}
	public void Dernier(winChambre instance) {
		position = modeleChambre.getLesEnreg().size()-1;
	     System.out.println(position);
	     AffecteValeurs(instance,position);		
	}
	public void BonSuivant(winChambre instance) {
		if (position< modeleChambre.getLesEnreg().size()-1)
			 position++;
		else position = 0;
		modeleChambre.setCourant((int)modeleChambre.getValueAt(position, 0));
	     System.out.println(position);
		AffecteValeurs(instance,position);		
	}
	public void ListeChambres (winChambre instance, Boolean AjoutActive){   
	    position = winPickList.pickFromTable(new modChambre(),"listes des chambres");
		AffecteValeurs(instance, position);	
	}
	public void ListeCodType (winChambre instance, Boolean AjoutActive){
		positionPickList = winPickList.pickFromTable(new modListCodeType(),"listes des type de chambre");
		AffecteValeursType(instance, positionPickList);	
	}
	public void ListeCodLocalisation (winChambre instance, Boolean AjoutActive){
		positionPickList = winPickList.pickFromTable(new modListCodeLocalisation(),"listes des code de Localisation");
		AffecteValeursLocalisation(instance, positionPickList);	
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

	        }
        }
	    else
	    {
            errors.add("Le numero de chambre est invalide\n");
	    }
        
        if(matcherEtage.find()) {


        }
        else{
            errors.add("Le numero de l'étage est invalide\n");
        }
        
        if(matcherPrix.find()) {

        }
        else{
            errors.add("Le prix est invalide\n");
        }
        
        if(matcherMemo.find()) {

        }
        else{
            errors.add("Le memo est invalide\n");
        }
		if(newChambreCodCom.getRowCount() == 0)
		{
			errors.add("la chambre doit avoir au moins une commodite\n");
		}
        if(errors.isEmpty())
        {        	
        	ArrayList<String> values = new ArrayList<String>();
			values.add( instance.getTxtNoChambre().getText() );
			values.add( instance.getTxtEtage().getText() );
			values.add(instance.getTxtPrix().getText());
			if(instance.chckbxEnEtat.isSelected())
				values.add("1");
			else
				values.add("0");
			values.add( instance.getTxtCodTypeCha().getText());
			values.add( instance.getTxtCodLoc().getText());
			values.add( instance.getTxtMemo().getText());
        	//JOptionPane.showMessageDialog(null, values, "Champs validé",JOptionPane.WARNING_MESSAGE);
        	
        	boolean succes = true;
        	float Prix = Float.valueOf(instance.getTxtPrix().getText());
        	int Etat = Integer.parseInt(instance.getTxtEtat().getText());
			if(!procsE02.INSERT_CHAMBRE(instance.getTxtNoChambre().getText(),instance.getTxtEtage().getText(),Prix,Etat,instance.getTxtCodTypeCha().getText(),instance.getTxtCodLoc().getText(),instance.getTxtMemo().getText()))
			{
				succes = false;
			}
			for(int i = 0; i < newChambreCodCom.getRowCount() ; i++)
			{
				if(!procsE02.INSERT_AYANT(instance.getTxtNoChambre().getText(),newChambreCodCom.getValueAt(i,0).toString()))
				{
					succes = false;
				}
			}
			if(instance.chckbxEnEtat.isSelected())
			{
				if(!procsE02.UPDATE_ADDTYPECHAM(instance.getTxtCodTypeCha().getText()))
				{
					succes = false;
				}
			}
		//resultat
				if(succes)
				{
					
					JOptionPane.showMessageDialog(instance,"Ajout reussie");
					instance.ModeConsultation();
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
	public void addCodCom()
	{
		Model modele = procsE02.SELECT_CODCOM();
		modele.substractModele(newChambreCodCom);
		int index = winPickList.pickFromTable(modele,"listes des commodite");
		newChambreCodCom.addRow(new ArrayList<Object>(Arrays.asList((String)modele.getValueAt(index, 0) , (String)modele.getValueAt(index, 1))));
		winChambre.addjScrollPane(new JTable(newChambreCodCom));
		
	}
	public void removeCodCom()
	{
		newChambreCodCom.removeLastRow();
		winChambre.addjScrollPane(new JTable(newChambreCodCom));
	}
	public void supprimer(winChambre instance) 
	{
		boolean succes = true;
		if(!(procsE02.SELECT_DE().contains(instance.getTxtNoChambre().getText(),1)))
		{
			if(procsE02.DELETE_AYANT(modeleChambre.getValueAt(position, 0).toString()) && procsE02.DELETE_CHAMBRE(modeleChambre.getValueAt(position, 0).toString()))
			{
				if(instance.chckbxEnEtat.isSelected())
				{
					if(!procsE02.UPDATE_SUPPTYPECHAM(instance.getTxtCodTypeCha().getText()))
					{
		        		System.out.println("j'ai erreure type chambre");
		        		succes = false;
					}
				}
				if(succes == true)
				{
					JOptionPane.showMessageDialog(instance,"Supression reussi ");
					modeleChambre = new modChambre();
					position = 0;
					AffecteValeurs(instance, position);
				}
			}
			else
				JOptionPane.showMessageDialog(instance,"Supression echoue veuillez contacter l equipe de support");
		}
		else
			JOptionPane.showMessageDialog(instance,"Impossible de supprimer la chambre car une reservation existe pour celle-ci");		
	}
	public void setModifMode()
	{
		newChambreCodCom = modeleAyant;
	}
	public void modifier(winChambre instance) {
	     System.out.println(position);

  		if(!(procsE02.SELECT_DE().contains(instance.getTxtNoChambre().getText(),1)))
		{
  			
        	boolean succes = true;
        	ArrayList<String> errors = new ArrayList<String>();
    		
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

            }
    	    else
    	    {
                errors.add("Le numero de chambre est invalide\n");
    	    }
            
            if(matcherEtage.find()) {


            }
            else{
                errors.add("Le numero de l'étage est invalide\n");
            }
            
            if(matcherPrix.find()) {

            }
            else{
                errors.add("Le prix est invalide\n");
            }
            
            if(matcherMemo.find()) {

            }
            else{
                errors.add("Le memo est invalide\n");
            }
    		if(newChambreCodCom.getRowCount() == 0)
    		{
    			errors.add("la chambre doit avoir au moins une commodite\n");
    		}
            if(errors.isEmpty())
            {        	
            	ArrayList<String> values = new ArrayList<String>();
    			values.add( instance.getTxtNoChambre().getText() );
    			values.add( instance.getTxtEtage().getText() );
    			values.add(instance.getTxtPrix().getText());
    			if(instance.chckbxEnEtat.isSelected())
    				values.add("1");
    			else
    				values.add("0");
    			values.add( instance.getTxtCodTypeCha().getText());
    			values.add( instance.getTxtCodLoc().getText());
    			values.add( instance.getTxtMemo().getText());
            	JOptionPane.showMessageDialog(null, values, "Champs validé",JOptionPane.WARNING_MESSAGE);
            	
            	float Prix = Float.valueOf(instance.getTxtPrix().getText());
            	int Etat = Integer.parseInt(instance.getTxtEtat().getText());
            
       	     System.out.println(position);
             	if(procsE02.DELETE_AYANT(modeleChambre.getValueAt(position, 0).toString()) && procsE02.DELETE_CHAMBRE(modeleChambre.getValueAt(position, 0).toString()))
    			{
    				if(instance.chckbxEnEtat.isSelected())
    				{
    					if(!procsE02.UPDATE_SUPPTYPECHAM(instance.getTxtCodTypeCha().getText()))
    					{
    		        		System.out.println("j'ai erreure type chambre");
    		        		succes = false;
    					}
    				}
    				if(succes == true)
    				{
    					if(!procsE02.INSERT_CHAMBRE(instance.getTxtNoChambre().getText(),instance.getTxtEtage().getText(),Prix,Etat,instance.getTxtCodTypeCha().getText(),instance.getTxtCodLoc().getText(),instance.getTxtMemo().getText()))
    	    			{
    	    				succes = false;
    	            		System.out.println("j'ai erreure chambre");
    	    			}
    	    			for(int i = 0; i < newChambreCodCom.getRowCount() ; i++)
    	    			{
    	    				if(!procsE02.INSERT_AYANT(instance.getTxtNoChambre().getText(),newChambreCodCom.getValueAt(i,0).toString()))
    	    				{
    	    	        		System.out.println("j'ai erreure ayant");
    	    					succes = false;
    	    				}
    	    			}
    	    			if(Etat == 1)
    	    			{
    	    				if(!procsE02.UPDATE_ADDTYPECHAM(instance.getTxtCodTypeCha().getText()))
    	    				{
    	    	        		System.out.println("j'ai erreure type chambre");
    	    					succes = false;
    	    				}
    	    			}
    				}
    			}
    			else
    				JOptionPane.showMessageDialog(instance,"Modification echoue veuillez contacter l equipe de support");
    		
        	
				if(succes == true)
				{
					instance.ModeConsultation();
				}
            }
		}
	}
	//production de rapport
		public void rapport(){
			winChambreRapport winRapport = new winChambreRapport();
			winRapport.setVisible(true);
	        //fenetre.dispose();
		}

}
