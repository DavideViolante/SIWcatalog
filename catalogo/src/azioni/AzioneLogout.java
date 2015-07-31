package azioni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AzioneLogout extends Azione {
	
	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esito = "error";
		
		if(request.getSession() != null) {
			request.getSession().invalidate();
			request.setAttribute("info", "Logout effettuato.");
			esito = "logoutOK";
		}
		return esito;
	}
	
}
