package br.com.juridico.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.juridico.modelo.Usuario;

@Repository
@SuppressWarnings("serial")
public class UsuarioDao implements Serializable {

	@PersistenceContext
	EntityManager manager;

	public boolean existe(Usuario usuario) {

		TypedQuery<Usuario> query = manager.createQuery(
				" select u from Usuario u "
						+ " where u.nmLogin = :pLogin and u.dsSenha = :pSenha",
				Usuario.class);

		query.setParameter("pLogin", usuario.getNmLogin());
		query.setParameter("pSenha", usuario.getDsSenha());
		try {
			@SuppressWarnings("unused")
			Usuario resultado = query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}

		return true;
	}

}
