package helper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class FormProdottoHelper extends Helper {
	private String id;
	private String nome;
	private String descrizione;
	private String prezzo;

	public FormProdottoHelper(HttpServletRequest request) throws ServletException {
		super(request);
		this.id = request.getParameter("id");
		this.nome = request.getParameter("nome");
		this.descrizione = request.getParameter("descrizione");
		this.prezzo = request.getParameter("prezzo");
	}

	@Override
	public boolean convalida() {
		boolean bool = true;
		if (this.id.isEmpty()) {
			request.setAttribute("erroreID", "ID obbligatorio");
			bool = false;
		}
		if (this.nome.isEmpty()) {
			request.setAttribute("erroreNome", "Nome obbligatorio.");
			bool = false;
		}
		if (this.descrizione.isEmpty()) {
			request.setAttribute("erroreDescrizione", "Descrizione obbligatoria.");
			bool = false;
		}// prima: ^[0-9]*\\.?[0-9]*$
		if (this.prezzo.isEmpty() || !this.prezzo.matches("^[0-9]*([^\\,?][\\.?])?[0-9]*$")
			|| Double.parseDouble(this.prezzo) < 0) {
			request.setAttribute("errorePrezzo", "Prezzo errato o mancante.");
			bool = false;
		}
		return bool;
	}

	public boolean convalidaPerCancellazione() {
		boolean bool = true;
		if (this.id.isEmpty()) {
			request.setAttribute("erroreID", "ID obbligatorio.");
			bool = false;
		}
		return bool;
	}

}
