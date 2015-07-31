package azioni;

import helper.FormClienteHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import model.FacadeUtente;

public class AzioneInstallazione extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		FormClienteHelper helper = new FormClienteHelper(request);
		HttpSession session = request.getSession();
		if (helper.convalida()) {
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String mail = request.getParameter("mail");
			String username = request.getParameter("username");
			String password = DigestUtils.md5Hex(request.getParameter("password"));
			
			session.setAttribute("nome", nome);
			session.setAttribute("cognome", cognome);
			session.setAttribute("mail", mail);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("ruolo", "admin");
			
			FacadeUtente facade = new FacadeUtente();
			
			boolean adminInserito = facade.inserisciUtente(
					(String)session.getAttribute("nome"),
					(String)session.getAttribute("cognome"),
					(String)session.getAttribute("mail"), 
					(String)session.getAttribute("username"),
					(String)session.getAttribute("password"),
					(String)session.getAttribute("ruolo"));
			String passwordTest = DigestUtils.md5Hex("user");
			boolean userTestingInserito = facade.inserisciUtente("test", "test", "test@test.it", "user", passwordTest, "user");
			if(adminInserito && userTestingInserito) {
				esitoAzione = "installazioneOK";
				request.setAttribute("info", "Utente admin e utente user creati.");
			}
		} else {
			esitoAzione = "installazioneKO";
		}
		return esitoAzione;
	}
}
