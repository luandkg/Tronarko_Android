package br.com.luandkg.tronarko.tronarko;

import java.util.ArrayList;
import br.com.luandkg.tronarko.tronarko.Tronarko.Tozte;

public class Eventum {

	private ArrayList<ArkoTag> ToztesSelecionados;
	private ArrayList<SuperArkoTag> SuperToztes;

	
	public Eventum() {

		ToztesSelecionados = new ArrayList<ArkoTag>();
		SuperToztes = new ArrayList<SuperArkoTag>();

		
		ToztesSelecionados.add(new ArkoTag("Festival Reciclum Tron", 1, 1, 3, 0));

		ToztesSelecionados.add(new ArkoTag("Festival do Fogo", 9, 38, 3, 3));
		ToztesSelecionados.add(new ArkoTag("Festival do Água", 4, 20, 3, 3));
		ToztesSelecionados.add(new ArkoTag("Festival do Vento", 1, 15, 3, 3));
		ToztesSelecionados.add(new ArkoTag("Festival do Terra", 6, 30, 3, 3));

		
		


		ToztesSelecionados.add(new ArkoTag("Festival Reciclum Tron", 10, 50, 0, 3));

		SuperToztes.add(new SuperArkoTag("Grande Competição de Izzator", 9, 10,9,42,5,6500, 20, 10));
		SuperToztes.add(new SuperArkoTag("Torneio de Hazzo", 9, 10,9,20,2,5431, 20, 10));
		
		SuperToztes.add(new SuperArkoTag("Corrida dos Ventos", 1, 25,1,30,3,6500, 20, 10));
		SuperToztes.add(new SuperArkoTag("Cruzada dos Águas", 7, 40,7,45,3,6501, 20, 10));
		SuperToztes.add(new SuperArkoTag("Jornada do Fogo", 6, 15,6,20,3,6502, 20, 10));
		SuperToztes.add(new SuperArkoTag("Emboscada da Terra", 8, 5,8,15,3,6503, 20, 10));

		SuperToztes.add(new SuperArkoTag("Festival da Colheita", 7, 27,7,30,1,6200, 20, 10));

		
	}

	public ArrayList<String> ArkoTags() {

		ArrayList<String> ret = new ArrayList<String>();

		int tamanho = ToztesSelecionados.size();
		int indice = 0;

		while (indice < tamanho) {
			ArkoTag TozteCorrente = ToztesSelecionados.get(indice);

			ret.add(TozteCorrente.Nome() + "  ->  [ " + TozteCorrente.Superarko() + "/" + TozteCorrente.Hiperarko()
					+ " ]");

			indice += 1;
		}

		return ret;
	}
	
	public ArrayList<String> SuperArkoTags() {

		ArrayList<String> ret = new ArrayList<String>();

		int tamanho = SuperToztes.size();
		int indice = 0;

		while (indice < tamanho) {
			SuperArkoTag TozteCorrente = SuperToztes.get(indice);

			ret.add(TozteCorrente.Nome() + "  ->  [ " + TozteCorrente.SuperarkoInicio() + "/" + TozteCorrente.HiperarkoInicio()
					+ " a " + TozteCorrente.SuperarkoFim() + "/" + TozteCorrente.HiperarkoFim() + " ] a cada " + TozteCorrente.Intervalo() + " desde " + TozteCorrente.Inicio());

			indice += 1;
		}

		return ret;
	}

	public ArrayList<String> ProximoArkoTags(Tozte TozteProcurar) {

		ArrayList<String> ret = new ArrayList<String>();

		int tamanho = ToztesSelecionados.size();
		int indice = 0;

		while (indice < tamanho) {
			ArkoTag TozteCorrente = ToztesSelecionados.get(indice);

			ret.add(TozteCorrente.Nome() + "  ->  [ " + TozteCorrente.Superarko() + "/" + TozteCorrente.Hiperarko() + "/" + TozteProcurar.getTronarko()
					+ " ]");

			indice += 1;
		}

		return ret;
	}
	
	
	public ArrayList<String> ProximosSuperArkoTags(Tozte TozteProcurar) {

		ArrayList<String> ret = new ArrayList<String>();

		int tamanho = SuperToztes.size();
		int indice = 0;

		while (indice < tamanho) {
			SuperArkoTag TozteCorrente = SuperToztes.get(indice);

			
			int TronarkoInicio = TozteCorrente.Inicio();
			while(true) {
				if (TronarkoInicio + TozteCorrente.Intervalo() <= TozteProcurar.getTronarko()) {
					TronarkoInicio=	TronarkoInicio + TozteCorrente.Intervalo() ;
				}else {
					break;
				}
			}
			
			if (TronarkoInicio<TozteProcurar.getTronarko()) {
				TronarkoInicio=	TronarkoInicio + TozteCorrente.Intervalo() ;
			}
			
			ret.add(TozteCorrente.Nome() + "  ->  [ " + TozteCorrente.SuperarkoInicio() + "/" + TozteCorrente.HiperarkoInicio() + "/" + TronarkoInicio
					+ " a " + TozteCorrente.SuperarkoFim() + "/" + TozteCorrente.HiperarkoFim() + "/" + TronarkoInicio + " ] a cada " + TozteCorrente.Intervalo() + " desde " + TozteCorrente.Inicio());

			indice += 1;
		}

		return ret;
	}
	

	public ArrayList<String> Eventos(Tozte TozteProcurar) {

		ArrayList<String> ret = new ArrayList<String>();

		int tamanho = ToztesSelecionados.size();
		int indice = 0;

		while (indice < tamanho) {
			ArkoTag TozteCorrente = ToztesSelecionados.get(indice);

			int Corrente = (TozteCorrente.Hiperarko() * 50) + (TozteCorrente.Superarko());

			int Procurar = ((TozteProcurar.getHiperarko() * 50) + TozteProcurar.getSuperarko());

			if (Procurar == Corrente) {
				ret.add("Hoje é Feriado : " + TozteCorrente.Nome());
			} else {

				if (Procurar < Corrente) {
					if ((Corrente - Procurar) <= TozteCorrente.Antes()) {

						if ((Corrente - Procurar) == 1) {
							ret.add("Falta : " + (Corrente - Procurar) + " Superarko para " + TozteCorrente.Nome());
						} else {
							ret.add("Faltam : " + (Corrente - Procurar) + " Superarkos para " + TozteCorrente.Nome());
						}
					}
				}

				if (Procurar > Corrente) {
					if ((Procurar - Corrente) <= TozteCorrente.Depois()) {

						if ((Procurar - Corrente) == 1) {
							ret.add("Passou : " + (Procurar - Corrente) + " Superarko após " + TozteCorrente.Nome());
						} else {
							ret.add("Passou : " + (Procurar - Corrente) + " Superarkos após " + TozteCorrente.Nome());
						}
					}
				}

			}

			indice += 1;
		}

		return ret;
	}


	public ArrayList<String> SuperEventos(Tozte TozteProcurar) {

		ArrayList<String> ret = new ArrayList<String>();

		int tamanho = SuperToztes.size();
		int indice = 0;

		while (indice < tamanho) {
			SuperArkoTag TozteCorrente = SuperToztes.get(indice);

			
			
			int TronarkoInicio = TozteCorrente.Inicio();
			while(true) {
				if (TronarkoInicio + TozteCorrente.Intervalo() <= TozteProcurar.getTronarko()) {
					TronarkoInicio=	TronarkoInicio + TozteCorrente.Intervalo() ;
				}else {
					break;
				}
			}
			
			
			if (TronarkoInicio == TozteProcurar.getTronarko()) {
				
				

				int ProcurarInicio = (TozteCorrente.HiperarkoInicio() * 50) + (TozteCorrente.SuperarkoInicio());

				int Corrente = ((TozteProcurar.getHiperarko() * 50) + TozteProcurar.getSuperarko());
				
				int ProcurarFim = (TozteCorrente.HiperarkoFim() * 50) + (TozteCorrente.SuperarkoFim());

				if (ProcurarInicio == Corrente) {
					ret.add("Hoje é o Inicio de : " + TozteCorrente.Nome());
				}else if (ProcurarFim == Corrente) {
						ret.add("Hoje é o fim de : " + TozteCorrente.Nome());
				} else {

					if (  Corrente<ProcurarInicio) {
						int Falta = ProcurarInicio-Corrente;

						if ((Falta ) <= TozteCorrente.Antes()) {

							if ((ProcurarInicio-Corrente) == 1) {
								ret.add("Falta : " + (Falta) + " Superarko para " + TozteCorrente.Nome());
							} else {
								ret.add("Faltam : " + (Falta) + " Superarkos para " + TozteCorrente.Nome());
							}
						}
					}

					if (Corrente>ProcurarFim) {
						int Passou = Corrente-ProcurarFim;
						if ((Passou) <= TozteCorrente.Depois()) {

							if ((Passou) == 1) {
								ret.add("Passou : " + (Passou) + " Superarko após " + TozteCorrente.Nome());
							} else {
								ret.add("Passou : " + (Passou) + " Superarkos após " + TozteCorrente.Nome());
							}
						}
					}

				}

				if (Corrente>ProcurarInicio && Corrente < ProcurarFim) {
					ret.add("Estamos no " + TozteCorrente.Nome());
				}
				
				
			}
			
			
			indice += 1;
		}

		return ret;
	}
	
}
