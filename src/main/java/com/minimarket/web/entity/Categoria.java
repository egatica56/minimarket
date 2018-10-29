package com.minimarket.web.entity;
// Generated 29-10-2018 14:07:51 by Hibernate Tools 5.2.11.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categoria generated by hbm2java
 */
@Entity
@Table(name = "categoria")
public class Categoria implements java.io.Serializable {

	private Integer idCategoria;
	private String nombreCategoria;
	private String descripcionCategoria;
	private Set<Producto> productos = new HashSet<Producto>(0);
	private Set<Producto> productos_1 = new HashSet<Producto>(0);
	private Set<Producto> productos_2 = new HashSet<Producto>(0);
	private Set<Producto> productos_3 = new HashSet<Producto>(0);

	public Categoria() {
	}

	public Categoria(String nombreCategoria, String descripcionCategoria) {
		this.nombreCategoria = nombreCategoria;
		this.descripcionCategoria = descripcionCategoria;
	}

	public Categoria(String nombreCategoria, String descripcionCategoria, Set<Producto> productos,
			Set<Producto> productos_1, Set<Producto> productos_2, Set<Producto> productos_3) {
		this.nombreCategoria = nombreCategoria;
		this.descripcionCategoria = descripcionCategoria;
		this.productos = productos;
		this.productos_1 = productos_1;
		this.productos_2 = productos_2;
		this.productos_3 = productos_3;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_categoria", unique = true, nullable = false)
	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name = "nombre_categoria", nullable = false, length = 50)
	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Column(name = "descripcion_categoria", nullable = false, length = 100)
	public String getDescripcionCategoria() {
		return this.descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Producto> getProductos_1() {
		return this.productos_1;
	}

	public void setProductos_1(Set<Producto> productos_1) {
		this.productos_1 = productos_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Producto> getProductos_2() {
		return this.productos_2;
	}

	public void setProductos_2(Set<Producto> productos_2) {
		this.productos_2 = productos_2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Producto> getProductos_3() {
		return this.productos_3;
	}

	public void setProductos_3(Set<Producto> productos_3) {
		this.productos_3 = productos_3;
	}

}
