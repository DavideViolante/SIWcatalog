package azioni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeUtente;

public class AzioneConfermaInserimentoCliente extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "error";
		HttpSession session = request.getSession();
		
		if (request.getParameter("conferma").equals("si")) {
			FacadeUtente facade = new FacadeUtente();
			if(facade.inserisciUtente(
					(String) session.getAttribute("nome"),
					(String) session.getAttribute("cognome"),
					(String) session.getAttribute("mail"),
					(String) session.getAttribute("username"),
					(String) session.getAttribute("password"),
					(String) session.getAttribute("ruolo"))) {
				esitoAzione = "confermaInserimentoClienteSI";
				request.setAttribute("info", "Cliente inserito con successo.");
			}
		} else {
			session.removeAttribute("nome");
			session.removeAttribute("cognome");
			session.removeAttribute("mail");
			session.removeAttribute("username");
			session.removeAttribute("password");
			session.removeAttribute("ruolo");
			esitoAzione = "confermaInserimentoClienteNO";
		}
		return esitoAzione;
	}
}
