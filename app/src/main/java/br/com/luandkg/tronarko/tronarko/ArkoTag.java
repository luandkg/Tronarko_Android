package br.com.luandkg.tronarko.tronarko;

public class ArkoTag {

	private String eNome="";
	private int eHiperarko = 0;
	private  int eSuperarko = 0;
	private  int eAntes = 0;
	private  int eDepois = 0;
	
	public ArkoTag(String aNome,int aHiperarko,int aSuperarko,int aAntes,int aDepois) {
		eNome=aNome;
		eHiperarko = aHiperarko;
		eSuperarko = aSuperarko;
		eAntes = aAntes;
		eDepois = aDepois;

	}
	
	public String Nome() {return eNome;}

	public int Hiperarko() {return eHiperarko;}
	public int Superarko() {return eSuperarko;}
	public int Antes() {return eAntes;}
	public int Depois() {return eDepois;}

}
