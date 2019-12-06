package br.com.luandkg.tronarko.tronarko;

import java.util.ArrayList;

public class Eventum {

	private ArrayList<ArkoTag> ToztesSelecionados;

	public Eventum() {
		
		ToztesSelecionados = new ArrayList<ArkoTag>();

		ToztesSelecionados.add(new ArkoTag("Festival Reciclum Tron", 1, 1, 3, 0));

		
		ToztesSelecionados.add(new ArkoTag("Festival do Fogo", 9, 38, 3, 3));
		ToztesSelecionados.add(new ArkoTag("Festival do Água", 4, 20, 3, 3));
		ToztesSelecionados.add(new ArkoTag("Festival do Vento", 1, 15, 3, 3));
		ToztesSelecionados.add(new ArkoTag("Festival do Terra", 6, 30, 3, 3));

		ToztesSelecionados.add(new ArkoTag("Festival dos Valores", 3, 45, 3, 3));

		ToztesSelecionados.add(new ArkoTag("Festival Ressignificação", 5, 5, 5, 5));

		
		ToztesSelecionados.add(new ArkoTag("Festival da Colheita", 7, 27, 3, 0));
		ToztesSelecionados.add(new ArkoTag("Festival da Colheita", 7, 38, 0, 0));
		ToztesSelecionados.add(new ArkoTag("Festival da Colheita", 7, 29, 0, 0));
		ToztesSelecionados.add(new ArkoTag("Festival da Colheita", 7, 30, 0, 3));

		ToztesSelecionados.add(new ArkoTag("Festival de Attrios", 9, 42, 3, 3));


		ToztesSelecionados.add(new ArkoTag("Festival Reciclum Tron", 10, 50, 0, 3));

	}

	public ArrayList<String> ArkoTags(){
		
		ArrayList<String> ret = new ArrayList<String>();
		
		
		int tamanho = ToztesSelecionados.size();
		int indice = 0;

		while (indice < tamanho) {
			ArkoTag TozteCorrente = ToztesSelecionados.get(indice);

			ret.add(TozteCorrente.Nome() + "  ->  [ " + TozteCorrente.Superarko() + "/" + TozteCorrente.Hiperarko() + " ]");
			
			indice+=1;
		}
		
		
		
		
		return ret;
	}
	
	public ArrayList<String> eventos(Tronarko.Tozte TozteProcurar) {

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

}
