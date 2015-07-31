package azioni;

import helper.FormClienteHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import model.FacadeUtente;


public class AzioneInserimentoCliente extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String mail = request.getParameter("mail");
		String username = request.getParameter("username");
		String password = DigestUtils.md5Hex(request.getParameter("password"));
		String ruolo = request.getParameter("ruolo");
		
		FacadeUtente facade = new FacadeUtente();
		FormClienteHelper helper = new FormClienteHelper(request);
		
		if (helper.convalida()) {
			if(facade.trovaUtente(username) == null) {
				HttpSession sessione = request.getSession();
				sessione.setAttribute("nome", nome);
				sessione.setAttribute("cognome", cognome);
				sessione.setAttribute("mail", mail);
				sessione.setAttribute("username", username);
				sessione.setAttribute("password", password);
				sessione.setAttribute("ruolo", ruolo);
				esitoAzione = "inserimentoClienteOK";
			} else {
				esitoAzione = "inserimentoClienteKO";
				request.setAttribute("erroreDuplicato", "Username già esistente.");
			}
		} else {
			esitoAzione = "inserimentoClienteKO";
		}
		return esitoAzione;
	}
}
