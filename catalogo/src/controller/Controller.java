package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import azioni.Azione;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> comando2azione; 
	private Map<String, String> esito2pagina;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String prossimaPagina = null;
		String comando = this.leggiComando(request.getServletPath());
		String nomeAzione = this.comando2azione.get(comando);
		if (nomeAzione==null) {
			prossimaPagina = "/error.jsp";
		}
		else {
			Azione azione = null;
			try {
				azione =(Azione)Class.forName(nomeAzione).newInstance();
				String esitoAzione = azione.esegui(request);
				prossimaPagina = this.esito2pagina.get(esitoAzione);
			} catch (InstantiationException e) {
				prossimaPagina = "/errori.jsp";
			} catch (IllegalAccessException e) {
				prossimaPagina = "/errore.jsp";
			} catch (ClassNotFoundException e) {
				prossimaPagina = "/errornf.jsp";
			}
			ServletContext application  = getServletContext();
			RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
			rd.forward(request, response);		
		}
	}

	@Override
	public void init() {
		this.comando2azione = new HashMap<String, String>();
		this.esito2pagina = new HashMap<String, String>();

		/**
		 * LEGENDA
		 * OK = andato a buon fine
		 * KO = non andato a buon fine
		 * SI = ha cliccato si su conferma
		 * NO = ha cliccato no su conferma
		 */

		// generali
		this.comando2azione.put("installazione","azioni.AzioneInstallazione");
		this.esito2pagina.put("installazioneOK","/index.jsp");
		this.esito2pagina.put("installazioneKO","/install.jsp");

		// clienti
		this.comando2azione.put("registrazioneCliente","azioni.AzioneRegistrazioneCliente");
		this.esito2pagina.put("registrazioneClienteOK","/index.jsp");
		this.esito2pagina.put("registrazioneClienteKO","/register.jsp");

		this.comando2azione.put("inserimentoCliente","azioni.AzioneInserimentoCliente");
		this.esito2pagina.put("inserimentoClienteOK","/confermaInserimentoCliente.jsp");
		this.esito2pagina.put("inserimentoClienteKO","/inserimentoCliente.jsp");

		this.comando2azione.put("confermaInserimentoCliente","azioni.AzioneConfermaInserimentoCliente");
		this.esito2pagina.put("confermaInserimentoClienteSI","/inseritoCliente.jsp");
		this.esito2pagina.put("confermaInserimentoClienteNO","/inserimentoCliente.jsp");	

		this.comando2azione.put("login","azioni.AzioneLogin");
		this.esito2pagina.put("loginOK","/index.jsp");
		this.esito2pagina.put("loginKO","/login.jsp");

		this.comando2azione.put("logout","azioni.AzioneLogout");
		this.esito2pagina.put("logoutOK","/index.jsp");

		// prodotti
		this.comando2azione.put("inserimentoProdotto","azioni.AzioneInserimentoProdotto");
		this.esito2pagina.put("inserimentoProdottoOK","/confermaInserimentoProdotto.jsp");
		this.esito2pagina.put("inserimentoProdottoKO","/inserimentoProdotto.jsp");

		this.comando2azione.put("confermaInserimentoProdotto","azioni.AzioneConfermaInserimentoProdotto");
		this.esito2pagina.put("confermaInserimentoProdottoSI","/inseritoProdotto.jsp");	
		this.esito2pagina.put("confermaInserimentoProdottoNO","/inserimentoProdotto.jsp");

		this.comando2azione.put("cancellazioneProdotto","azioni.AzioneCancellazioneProdotto");
		this.esito2pagina.put("cancellazioneProdottoOK","/confermaCancellazioneProdotto.jsp");
		this.esito2pagina.put("cancellazioneProdottoKO","/cancellazioneProdotto.jsp");		

		this.comando2azione.put("confermaCancellazioneProdotto","azioni.AzioneConfermaCancellazioneProdotto");
		this.esito2pagina.put("confermaCancellazioneProdottoSI","/index.jsp");
		this.esito2pagina.put("confermaCancellazioneProdottoNO","/cancellazioneProdotto.jsp");

		this.comando2azione.put("listaProdotti","azioni.AzioneMostraListaProdotti");
		this.esito2pagina.put("listaProdottiOK","/listaProdotti.jsp");	

		this.comando2azione.put("mostraProdotto","azioni.AzioneMostraProdotto");
		this.esito2pagina.put("mostraProdottoOK","/listaProdotti.jsp");

		// ordini 
		this.comando2azione.put("visualizzaRigheOrdine", "azioni.AzioneListaRigheOrdine");
		this.esito2pagina.put("listaRigheOrdineOK","/listaRigheOrdine.jsp");
		this.esito2pagina.put("listaRigheOrdineKO","/listaOrdini.jsp");

		this.comando2azione.put("inserimentoOrdine", "azioni.AzioneInserimentoOrdine");
		this.esito2pagina.put("inserimentoOrdineOK","/inserisciRiga.jsp");
		this.esito2pagina.put("inserimentoOrdineKO","/inserisciOrdine.jsp");

		this.comando2azione.put("confermaOrdine", "azioni.AzioneConfermaInserimentoOrdine");
		this.esito2pagina.put("confermaInserimentoOrdineSI","/index.jsp");
		this.esito2pagina.put("confermaInserimentoOrdineNO","/index.jsp");
		this.esito2pagina.put("confermaInserimentoOrdineEmpty","/inserisciRiga.jsp");


		this.comando2azione.put("inserimentoRigaOrdine", "azioni.AzioneInserimentoRigaOrdine");
		this.comando2azione.put("riprendiOrdine", "azioni.AzioneRiprendiCompilazioneOrdine");
		this.esito2pagina.put("inserimentoRigaOK","/inserisciRiga.jsp");

		this.comando2azione.put("listaOrdini", "azioni.AzioneMostraOrdini");
		this.esito2pagina.put("listaOrdiniOK","/listaOrdini.jsp");

		this.comando2azione.put("listaOrdiniTot", "azioni.AzioneListaOrdini");
		this.esito2pagina.put("listaOrdiniTotOK","/listaOrdiniTot.jsp");

		this.comando2azione.put("ricercaCliente", "azioni.AzioneRicercaClienteByOrdine");
		this.esito2pagina.put("ricercaClienteOK","/ricercaCliente.jsp");
		this.esito2pagina.put("ricercaClienteKO","/ricercaCliente.jsp");

		this.comando2azione.put("evasioneOrdine", "azioni.AzioneEvasioneOrdine");
		this.esito2pagina.put("evasioneOrdineOK","/confermaEvasione.jsp");
		this.esito2pagina.put("evasioneOrdineKO","/evasioneOrdine.jsp");

		this.comando2azione.put("confermaEvasioneOrdine", "azioni.AzioneConfermaEvasioneOrdine");
		this.esito2pagina.put("confermaEvasioneOrdineSI","/index.jsp");
		this.esito2pagina.put("confermaEvasioneOrdineNO","/evasioneOrdine.jsp");

		this.esito2pagina.put("errore","/error.jsp");

	}

	public String leggiComando(String s){
		String ritornata=s.substring(1,s.length()-3);
		return ritornata;
	}
}

