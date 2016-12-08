package utils;
import java.io.FileNotFoundException;

public class PathRapportHelper {
	static private String nomOS = System.getProperty("os.name");
	static private String versionOS = System.getProperty("os.version");
	static private String separateur = System.getProperty("file.separator");
	static private String nomUtilisateur = System.getProperty("user.name");
	static private String repertoireCourant = System.getProperty("user.dir");
	public static String getNomOS() {
		return nomOS;
	}
	
	public static String getVersionOS() {
		return versionOS;
	}
	
	public static String getSeparateur() {
		return separateur;
	}
	
	public static String getNomUtilisateur() {
		return nomUtilisateur;
	}
	
	public static String getRepertoireCourant() {
		return repertoireCourant;
	}
	
	public static void main(String[] args) 
		throws FileNotFoundException
	{
		
	}
}