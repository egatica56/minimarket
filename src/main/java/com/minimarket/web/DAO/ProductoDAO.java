package com.minimarket.web.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductoDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private IProductoDAO crud;

	public IProductoDAO crud() {
		return this.crud;

	}

}
