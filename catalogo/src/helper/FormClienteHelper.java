package helper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class FormClienteHelper extends Helper {

	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String mail;

	public FormClienteHelper(HttpServletRequest request) throws ServletException {
		super(request);
		this.username = request.getParameter("username");
		this.password = request.getParameter("password");
		request.getParameter("ruolo");
		this.nome = request.getParameter("nome");
		this.cognome = request.getParameter("cognome");
		this.mail = request.getParameter("mail");
	}

	@Override
	public boolean convalida() {
		boolean bool = true;
		if (this.nome.isEmpty()) {
			request.setAttribute("erroreNome", "Nome obbligatorio.");
			bool = false;
		}
		if (this.cognome.isEmpty()) {
			request.setAttribute("erroreCognome", "Cognome obbligatorio.");
			bool = false;
		}
		if (this.mail.isEmpty()) {
			request.setAttribute("erroreMail", "Mail obbligatoria.");
			bool = false;
		}
		if (this.username.isEmpty()) {
			request.setAttribute("erroreUsername", "Username obbligatorio.");
			bool = false;
		}
		if (this.password.isEmpty()) {
			request.setAttribute("errorePassword", "Password obbligatoria.");
			bool = false;
		}
		return bool;
	}
	
	public boolean convalidaLogin() {
		boolean bool = true;
		if (this.username.isEmpty()) {
			request.setAttribute("erroreUsername", "Username obbligatorio.");
			bool = false;
		}
		if (this.password.isEmpty()) {
			request.setAttribute("errorePassword", "Password obbligatoria.");
			bool = false;
		}
		return bool;
	}
	
}
