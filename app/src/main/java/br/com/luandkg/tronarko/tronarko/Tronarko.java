package br.com.luandkg.tronarko.tronarko;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 		AUTOR : LUAN ALVES FREITAS
// 		DATA  : 21 09 2018
//
//       	ATUALIZACOES
//
//	ATUALIZACAO 1 : 29/10/2019 - Implementacao Modarko e Periarko
//	ATUALIZACAO 2 : 01/12/2019 - Alteracao de Nomenclatura dos Superarkos 
//  ATUALIZACAO 3 : 29/12/2019 - Metodo de Sincronizacao

public class Tronarko {

	private final String DATA_INICIO = "21/09/2018";

	public String getAgora() {
		return getTronAgora().getTexto();
	}

	public Tron getTronAgora() {

		Hazde h = getHazde();
		Tozte t = getTozte();

		Tron ret = new Tron(h.getArco(), h.getItta(), h.getUzzon(), t.getSuperarko(), t.getHiperarko(),
				t.getTronarko());

		return ret;
	}

	public final String toString() {
		return getAgora();
	}

	public Tozte getTozte() {

		Calendar c = Calendar.getInstance();

		int dia = c.getTime().getDay();
		int mes = c.getTime().getMonth();
		int ano = c.getTime().getYear();
		//

		dia = c.get(Calendar.DAY_OF_MONTH);
		mes = c.get(Calendar.MONTH) + 1;
		ano = c.get(Calendar.YEAR);

		return getData(dia + "/" + mes + "/" + ano);

	}

	public Tozte getData(String eData) {

		// System.out.printf("\nHCC : %s",eData);

		Calendar c = Calendar.getInstance();

		long Diferenca = 0;

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		try {
			Date DTI = df.parse(DATA_INICIO);
			Date DTE = df.parse(eData);
			Diferenca = (DTE.getTime() - DTI.getTime()) / 86400000L;

		} catch (java.text.ParseException evt) {
		}

		int iTronarko = 7000;
		int iHiperarko = 1;
		int iSuperarko = 1;

		if (Diferenca >= 0) {

			while (Diferenca >= 500) {
				Diferenca -= 500;
				iTronarko += 1;
			}

			iHiperarko = 1;
			while (Diferenca >= 50) {
				Diferenca -= 50;
				iHiperarko += 1;
			}
			iSuperarko = 1 + (int) Diferenca;

		} else if (Diferenca < 0) {

			iTronarko -= 1;
			while (Diferenca <= -500) {
				Diferenca += 500;
				iTronarko -= 1;
			}
			iHiperarko = 10;
			while (Diferenca <= -50) {
				Diferenca += 50;
				iHiperarko -= 1;
			}
			iSuperarko = 50 + 1 + (int) Diferenca;
		}

		return new Tozte(iSuperarko, iHiperarko, iTronarko);
	}

	public Hazde getHora(int eHora, int eMinuto, int eSegundo) {

		int iArco = 0;
		int iIttas = 0;
		int iUzzons = 0;

		int eMilissegundo = 0;

		long Tudo = eMilissegundo + (eSegundo * 1000) + (eMinuto * 1000 * 60) + (eHora * 1000 * 60 * 60);

		double Taxa1 = (24 * 1000 * 60 * 60);
		double Taxa2 = (10 * 1000 * 100 * 100);

		double Taxador = Taxa1 / Taxa2;

		double Entaxa = Tudo / Taxador;
		long IEntaxa = (long) Entaxa;

		iUzzons = (int) (IEntaxa / 1000);

		while (iUzzons >= 100) {
			iUzzons -= 100;
			iIttas += 1;
		}

		while (iIttas >= 100) {
			iIttas -= 100;
			iArco += 1;
		}

		iArco += 1;

		return new Hazde(iArco, iIttas, iUzzons);
	}

	public Hazde getHazde() {

		Calendar c = Calendar.getInstance();

		int eMilissegundo = 0;
		int eSegundo = c.getTime().getSeconds();
		int eMinuto = c.getTime().getMinutes();
		int eHora = c.getTime().getHours();

		return getHora(eHora, eMinuto, eSegundo);

	}

	public int getSincronizanteHazde(Hazde Local, Hazde Origem) {
		return (Origem.getTotalEttons() - Local.getTotalEttons());
	}

	public int getSincronizanteTozte(Tozte Local, Tozte Origem) {
		return (Origem.getSuperarkosTotal() - Local.getSuperarkosTotal());
	}

	public class Hazde {

		private int arco;
		private int itta;
		private int uzzon;

		public int getArco() {
			return this.arco;
		}

		public int getItta() {
			return this.itta;
		}

		public int getUzzon() {
			return this.uzzon;
		}

		public Hazde(int _arco, int _itta, int _uzzon) {
			this.arco = _arco;
			this.itta = _itta;
			this.uzzon = _uzzon;
		}

		public int getTotalEttons() {
			int ret = 0;

			ret += (this.getArco() - 1) * 100 * 100;
			ret += this.getItta() * 100;
			ret += this.getUzzon();

			return ret;
		}

		public String getTexto() {
			String texto = "";

			texto = this.getArco() + ":" + this.getItta() + ":" + this.getUzzon();

			return texto;
		}

		public String getTextoSemEttos() {
			String texto = "";

			texto = this.getArco() + ":" + this.getItta() + ":" + this.getUzzon();

			return texto;
		}

		public final String toString() {
			return getTexto();
		}

		public String Periarko() {
			String ret = "";

			if (getArco() >= 1 && getArco() <= 2) {
				ret = "UD";
			}
			if (getArco() >= 3 && getArco() <= 5) {
				ret = "AD";
			}
			if (getArco() >= 6 && getArco() <= 8) {
				ret = "ED";
			}
			if (getArco() >= 9 && getArco() <= 10) {
				ret = "OD";
			}

			return ret;
		}

		public String PeriarkoCompleto() {
			return String.valueOf(this.getArco()) + "º " + String.valueOf(this.getItta()) + " " + Periarko();
		}

		public String Modarko() {
			String ret = "";

			if (getArco() >= 1 && getArco() <= 2) {
				ret = "OZZ";
			}
			if (getArco() >= 3 && getArco() <= 5) {
				ret = "AZZ";
			}
			if (getArco() >= 6 && getArco() <= 8) {
				ret = "AZZ";
			}
			if (getArco() >= 9 && getArco() <= 10) {
				ret = "OZZ";
			}

			return ret;
		}

		public String ModarkoCompleto() {
			return String.valueOf(this.getArco()) + "º " + Modarko();
		}

		public Hazde adicionar_Arco(int a) {
			return modificar_Arco(this, a);
		}

		public Hazde adicionar_Itta(int i) {
			return modificar_Itta(this, i);
		}

		public Hazde adicionar_Uzzon(int u) {
			return modificar_Uzzon(this, u);
		}

		public Hazde modificar_Arco(Hazde sTron, int a) {

			int narco = sTron.getArco() + a;

			while (narco > 10) {
				narco -= 10;
			}

			while (narco <= 0) {
				narco += 10;
			}

			Hazde ret = new Hazde(narco, sTron.getItta(), sTron.getUzzon());

			return ret;

		}

		public Hazde modificar_Itta(Hazde sTron, int i) {

			int nitta = sTron.getItta() + i;
			int narco = 0;

			while (nitta >= 100) {
				nitta -= 100;
				narco += 1;
			}

			while (nitta < 0) {
				nitta += 100;
				narco -= 1;
			}

			Hazde ret = new Hazde(sTron.getArco(), nitta, sTron.getUzzon());

			return modificar_Arco(ret, narco);

		}

		public Hazde modificar_Uzzon(Hazde sTron, int u) {

			int nuzzon = sTron.getUzzon() + u;
			int nitta = 0;

			while (nuzzon >= 100) {
				nuzzon -= 100;
				nitta += 1;
			}

			while (nuzzon < 0) {
				nuzzon += 100;
				nitta -= 1;
			}

			Hazde ret = new Hazde(sTron.getArco(), sTron.getItta(), nuzzon);

			return modificar_Itta(ret, nitta);

		}

		// INTERNALIZAR METODOS

		public void internalizar_Arco(int a) {

			int narco = this.getArco() + a;

			while (narco > 10) {
				narco -= 10;
			}

			while (narco <= 0) {
				narco += 10;
			}

			this.arco = narco;

		}

		public void internalizar_Itta(int i) {

			int nitta = this.getItta() + i;
			int narco = 0;

			while (nitta >= 100) {
				nitta -= 100;
				narco += 1;
			}

			while (nitta < 0) {
				nitta += 100;
				narco -= 1;
			}

			this.itta = nitta;

			Hazde ret = modificar_Arco(this, narco);

			this.arco = ret.getArco();

			this.uzzon = ret.getUzzon();
			this.itta = ret.getItta();

		}

		public void internalizar_Uzzon(int u) {

			int nuzzon = this.getUzzon() + u;
			int nitta = 0;

			while (nuzzon >= 100) {
				nuzzon -= 100;
				nitta += 1;
			}

			while (nuzzon < 0) {
				nuzzon += 100;
				nitta -= 1;
			}

			this.uzzon = nuzzon;

			Hazde ret = modificar_Itta(this, nitta);

			this.arco = ret.getArco();

			this.itta = ret.getItta();

		}

	}

	public static class Tozte {

		private int superarko;
		private int hiperarko;
		private int tronarko;

		public int getSuperarkosTotal() {
			return this.getSuperarko() + ((this.getHiperarko() - 1) * 50) + (this.getTronarko() * 500);
		}

		public int getSuperarko() {
			return this.superarko;
		}

		public int getHiperarko() {
			return this.hiperarko;
		}

		public int getTronarko() {
			return this.tronarko;
		}

		public Tozte(int _superarko, int _hiperarko, int _tronarko) {
			this.superarko = _superarko;
			this.hiperarko = _hiperarko;
			this.tronarko = _tronarko;
		}

		public String getTexto() {
			String texto = "";

			String p1 = String.valueOf(this.getSuperarko());
			if (p1.length() == 1) {
				p1 = "0" + p1;
			}

			String p2 = String.valueOf(this.getHiperarko());
			if (p2.length() == 1) {
				p2 = "0" + p2;
			}

			texto = p1 + "/" + p2 + "/" + this.getTronarko();

			return texto;
		}

		public final String toString() {
			return getTexto();
		}

		public int SuperarkoDoTronarko() {
			return ((getHiperarko() - 1) * 50) + getSuperarko();
		}

		public int getMegarko() {
			int mega = 1;
			int ns = this.superarko;

			while (ns > 10) {
				mega += 1;
				ns -= 10;
			}

			return mega;
		}

		// SIZARKO

		public int Hizarko() {
			int ret = 1;
			int sdt = SuperarkoDoTronarko();

			while (sdt > 125) {
				ret += 1;
				sdt -= 125;
			}

			return ret;
		}

		public int Hizarko_Duracao() {
			int sdt = SuperarkoDoTronarko();

			while (sdt > 125) {
				sdt -= 125;
			}

			return sdt;
		}

		public Tozte Hizarko_Inicio() {
			switch (Hizarko()) {

			case 1:
				return this.Hizarko_InicioH1();
			case 2:
				return this.Hizarko_InicioH2();

			case 3:
				return this.Hizarko_InicioH3();

			case 4:
				return this.Hizarko_InicioH4();

			}
			return null;
		}

		public Tozte Hizarko_Fim() {
			switch (Hizarko()) {

			case 1:
				return this.Hizarko_FimH1();
			case 2:
				return this.Hizarko_FimH2();

			case 3:
				return this.Hizarko_FimH3();

			case 4:
				return this.Hizarko_FimH4();

			}
			return null;
		}

		public Tozte Hizarko_InicioH1() {

			Tozte ret = new Tozte(1, 1, this.tronarko);

			return ret;
		}

		public Tozte Hizarko_InicioH2() {
			return Hizarko_InicioH1().adicionar_Superarko(125);
		}

		public Tozte Hizarko_InicioH3() {
			return Hizarko_InicioH1().adicionar_Superarko(250);
		}

		public Tozte Hizarko_InicioH4() {
			return Hizarko_InicioH1().adicionar_Superarko(375);
		}

		public Tozte Hizarko_FimH1() {
			return Hizarko_InicioH1().adicionar_Superarko(124);
		}

		public Tozte Hizarko_FimH2() {
			return Hizarko_InicioH2().adicionar_Superarko(124);
		}

		public Tozte Hizarko_FimH3() {
			return Hizarko_InicioH3().adicionar_Superarko(124);
		}

		public Tozte Hizarko_FimH4() {
			return Hizarko_InicioH4().adicionar_Superarko(124);
		}

		public int Hizarko_Acabar() {

			return 126 - Hizarko_Duracao();

		}

		public String Hizarko_nome() {
			String ret = "";

			switch (Hizarko()) {
			case 1:
				ret = "Hittarium";
				break;
			case 2:
				ret = "Deggovium";
				break;
			case 3:
				ret = "Nuztium";
				break;
			case 4:
				ret = "Harbarium";
				break;

			}

			return ret;
		}

		// SIGNOS
		public int getSigno() {
			int ret = 1;
			int sdt = SuperarkoDoTronarko();
			int faixa = 50;

			while (sdt > faixa) {
				ret += 1;
				sdt -= faixa;
			}

			return ret;
		}

		public String Signo_nome() {
			String ret = "";

			switch (getSigno()) {
			case 1:
				ret = "Tigre";
				break;
			case 2:
				ret = "Raposa";
				break;
			case 3:
				ret = "Leopardo";
				break;
			case 4:
				ret = "Leão";
				break;
			case 5:
				ret = "Touro";
				break;
			case 6:
				ret = "Lobo";
				break;
			case 7:
				ret = "Gato";
				break;
			case 8:
				ret = "Carpa";
				break;
			case 9:
				ret = "Gavião";
				break;
			case 10:
				ret = "Serpente";
				break;

			}

			return ret;
		}

		public String Hiperarko_nome() {
			String ret = "";

			switch (getHiperarko()) {
			case 1:
				ret = "Atlas";
				break;
			case 2:
				ret = "Terron";
				break;
			case 3:
				ret = "Iggrox";
				break;
			case 4:
				ret = "Omplo";
				break;
			case 5:
				ret = "Uxmo";
				break;
			case 6:
				ret = "Sallu";
				break;
			case 7:
				ret = "Ithur";
				break;
			case 8:
				ret = "Gram";
				break;
			case 9:
				ret = "Hettiz";
				break;
			case 10:
				ret = "Ellun";
				break;

			}

			return ret;
		}

		public int SuperarkoEmMegarko() {
			int ret = this.getSuperarko();

			while (ret > 10) {
				ret -= 10;
			}

			return ret;
		}

		public String Superarko_capital() {
			return Superarko_nome() + ", " + superarko + " de " + Hiperarko_nome();
		}

		public String Superarko_nome() {
			String ret = "";

			switch (SuperarkoEmMegarko()) {
			case 1:
				ret = "Alfa";
				break;
			case 2:
				ret = "Beta";
				break;
			case 3:
				ret = "Gama";
				break;
			case 4:
				ret = "Delta";
				break;
			case 5:
				ret = "Epsilon";
				break;
			case 6:
				ret = "Iota";
				break;
			case 7:
				ret = "Kapa";
				break;
			case 8:
				ret = "Zeta";
				break;
			case 9:
				ret = "Sigma";
				break;
			case 10:
				ret = "Ômega";
				break;

			}

			return ret;
		}

		// DIVISAO DO TRONARKO

		public int getBimestre() {
			int b = getHiperarko();
			int r = 0;

			if (b == 1 || b == 2) {
				r = 1;
			}
			if (b == 3 || b == 4) {
				r = 2;
			}
			if (b == 5 || b == 6) {
				r = 3;
			}
			if (b == 7 || b == 8) {
				r = 4;
			}
			if (b == 9 || b == 10) {
				r = 5;
			}

			return r;

		}

		public int getSemestre() {
			int s = getHiperarko();
			int r = 0;

			if (s >= 1 && s <= 5) {
				r = 1;
			}
			if (s >= 6 && s <= 10) {
				r = 2;
			}

			return r;

		}

		// ADICIONAR METODOS

		public Tozte adicionar_Superarko(int s) {
			return modificar_Superarko(this, s);
		}

		public Tozte adicionar_Hiperarko(int h) {
			return modificar_Hiperarko(this, h);
		}

		public Tozte adicionar_Tronarko(int t) {
			return modificar_Tronarko(this, t);
		}

		public Tozte proximo_Superarko() {
			return modificar_Superarko(this, 1);
		}

		public Tozte anterior_Superarko() {
			return modificar_Superarko(this, -1);
		}

		// MODIFICAR METODOS

		public Tozte modificar_Superarko(Tozte sTron, int s) {

			int nsuperarko = sTron.getSuperarko() + s;
			int nhiperarko = 0;

			while (nsuperarko > 50) {
				nsuperarko -= 50;
				nhiperarko += 1;
			}

			while (nsuperarko <= 0) {
				nsuperarko += 50;
				nhiperarko -= 1;
			}

			Tozte ret = new Tozte(nsuperarko, sTron.getHiperarko(), sTron.getTronarko());

			if ((nhiperarko == 0) == false) {
				return modificar_Hiperarko(ret, nhiperarko);
			} else {
				return ret;
			}

		}

		public Tozte modificar_Hiperarko(Tozte sTron, int h) {

			int nhiperarko = sTron.getHiperarko() + h;
			int ntronarko = 0;

			while (nhiperarko > 10) {
				nhiperarko -= 10;
				ntronarko += 1;
			}

			while (nhiperarko <= 0) {
				nhiperarko += 10;
				ntronarko -= 1;
			}

			Tozte ret = new Tozte(sTron.getSuperarko(), nhiperarko, sTron.getTronarko());

			if ((ntronarko == 0) == false) {
				return modificar_Tronarko(ret, ntronarko);
			} else {
				return ret;
			}

		}

		public Tozte modificar_Tronarko(Tozte sTron, int t) {

			int ntronarko = sTron.getTronarko() + t;

			Tozte ret = new Tozte(sTron.getSuperarko(), sTron.getHiperarko(), ntronarko);

			return ret;

		}

		// INTERNALIZAR METODOS

		public void internalizar_Superarko(int s) {

			int nsuperarko = this.getSuperarko() + s;
			int nhiperarko = 0;

			while (nsuperarko > 50) {
				nsuperarko -= 50;
				nhiperarko += 1;
			}

			while (nsuperarko <= 0) {
				nsuperarko += 50;
				nhiperarko -= 1;
			}

			if ((nhiperarko == 0)) {
				this.superarko = nsuperarko;
			} else {
				Tozte r = modificar_Hiperarko(this, nhiperarko);

				this.superarko = nsuperarko;
				this.hiperarko = r.getHiperarko();
				this.tronarko = r.getTronarko();
			}

		}

		public void internalizar_Hiperarko(int h) {

			int nhiperarko = this.getHiperarko() + h;
			int ntronarko = 0;

			while (nhiperarko > 10) {
				nhiperarko -= 10;
				ntronarko += 1;
			}

			while (nhiperarko <= 0) {
				nhiperarko += 10;
				ntronarko -= 1;
			}

			if ((ntronarko == 0)) {
				this.hiperarko = nhiperarko;
			} else {
				this.hiperarko = nhiperarko;
				this.tronarko = modificar_Tronarko(this, ntronarko).getTronarko();
			}

		}

		public void internalizar_Tronarko(int t) {

			int ntronarko = this.getTronarko() + t;

			this.tronarko = ntronarko;
		}

	}

	public class Tron {

		private Hazde HazdeC;
		private Tozte TozteC;

		public Tron(int _arco, int _itta, int _uzzon, int _superarko, int _hiperarko, int _tronarko) {

			HazdeC = new Hazde(_arco, _itta, _uzzon);
			TozteC = new Tozte(_superarko, _hiperarko, _tronarko);

		}

		public Hazde getHazde() {
			return HazdeC;
		}

		public Tozte getTozte() {
			return TozteC;
		}

		public String getTexto (){
			return HazdeC.getTexto() + " " + TozteC.getTexto();
		}
		
		

		// INTERNALIZAR METODOS

		public void internalizar_Superarko(int s) {
			TozteC.internalizar_Superarko(s);
		}

		public void internalizar_Hiperarko(int h) {
			TozteC.internalizar_Hiperarko(h);
		}

		public void internalizar_Tronarko(int t) {
			TozteC.internalizar_Hiperarko(t);
		}
		
		

		public void internalizar_Arco(int a) {
			
			int narco = HazdeC.getArco() + a;
			int nsuperarko = 0;

			while (narco > 10) {
				narco -= 10;
				nsuperarko+=1;
			}

			while (narco <= 0) {
				narco += 10;
				nsuperarko-=1;
			}

			HazdeC = new Hazde(narco,HazdeC.getItta(),HazdeC.getUzzon());
			
			TozteC.internalizar_Superarko(nsuperarko);
			
		}

		public void internalizar_Itta(int i) {
			HazdeC.internalizar_Itta(i);
		}

		public void internalizar_Uzzon(int u) {
			HazdeC.internalizar_Uzzon(u);
		}
		
		
	}

}
