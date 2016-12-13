package utils;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public final class Formator {
	public static MaskFormatter formating(String s){
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter(s);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return mf;
	}
}
