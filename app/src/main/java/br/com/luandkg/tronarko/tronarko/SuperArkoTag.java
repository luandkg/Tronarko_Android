package br.com.luandkg.tronarko.tronarko;

public class SuperArkoTag {

	private String eNome = "";
	
	private int eHiperarkoInicio = 0;
	private int eSuperarkoInicio = 0;
	
	private int eHiperarkoFim = 0;
	private int eSuperarkoFim = 0;
	
	
	private int eIntervalo = 0;
	private int eInicio = 0;

	
	private int eAntes = 0;
	private int eDepois = 0;

	public SuperArkoTag(String aNome, int aHiperarkoInicio, int aSuperarkoInicio,int aHiperarkoFim, int aSuperarkoFim,int aIntervalo,int aInicio, int aAntes, int aDepois) {
		eNome = aNome;
		
		eHiperarkoInicio = aHiperarkoInicio;
		eSuperarkoInicio = aSuperarkoInicio;
		
		eHiperarkoFim= aHiperarkoFim;
		eSuperarkoFim = aSuperarkoFim;
		
		eIntervalo=aIntervalo;
		eInicio=aInicio;
		eAntes = aAntes;
		eDepois = aDepois;

	}

	public String Nome() {
		return eNome;
	}

	public int HiperarkoInicio() {
		return eHiperarkoInicio;
	}

	public int SuperarkoInicio() {
		return eSuperarkoInicio;
	}

	public int HiperarkoFim() {
		return eHiperarkoFim;
	}

	public int SuperarkoFim() {
		return eSuperarkoFim;
	}
	
	
	public int Antes() {
		return eAntes;
	}

	public int Depois() {
		return eDepois;
	}

	public int Intervalo() {
		return eIntervalo;
	}
	
	public int Inicio() {
		return eInicio;
	}

	

	
}
