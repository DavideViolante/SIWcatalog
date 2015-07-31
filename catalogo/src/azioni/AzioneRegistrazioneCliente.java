package azioni;

import helper.FormClienteHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import model.FacadeUtente;
import model.Utente;

public class AzioneRegistrazioneCliente extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		FormClienteHelper helper = new FormClienteHelper(request);
		if (helper.convalida()) {
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String mail = request.getParameter("mail");
			String username = request.getParameter("username");
			String password = DigestUtils.md5Hex(request.getParameter("password"));
			String ruolo = "user";
			
			FacadeUtente facade = new FacadeUtente();
			Utente utenteEsistente = facade.trovaUtente(username);
			// se devo sovrascrivere un altro utente!
			if(utenteEsistente == null) {
				if(facade.inserisciUtente(nome, cognome, mail, username, password, ruolo)) {
					esitoAzione = "registrazioneClienteOK";
					request.setAttribute("info", "Registrazione effettuata, puoi effettuare il login.");
				}
			} else {
				esitoAzione = "registrazioneClienteKO";
				request.setAttribute("erroreDuplicato", "Username già esistente.");
			}
		} else {
			esitoAzione = "registrazioneClienteKO";
		}
		return esitoAzione;
	}
}
