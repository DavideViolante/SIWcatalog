package azioni;

import helper.FormClienteHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import model.FacadeUtente;
import model.Utente;


public class AzioneLogin extends Azione {
	
	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		HttpSession session = request.getSession();
		FormClienteHelper helper = new FormClienteHelper(request);
		if(helper.convalidaLogin()) {
			String username = request.getParameter("username");
			String password = DigestUtils.md5Hex(request.getParameter("password"));
			FacadeUtente facade = new FacadeUtente();
			Utente utente = facade.login(username, password);
			if (utente != null) {
				session.setAttribute("utente", utente);
				esitoAzione = "loginOK";
				request.setAttribute("info", "Login effettuato.");
			} else {
				esitoAzione = "loginKO";
				request.setAttribute("erroreLogin", "Username o password errati.");
			}
		} else {
			esitoAzione = "loginKO";
		}
		return esitoAzione;
	}
}
