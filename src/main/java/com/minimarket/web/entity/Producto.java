package com.minimarket.web.entity;
// Generated 29-10-2018 14:07:51 by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Producto generated by hbm2java
 */
@Entity
@Table(name = "producto")
public class Producto implements java.io.Serializable {

	private int sku;
	private Categoria categoria;
	private Marca marca;
	private String nombreProduto;
	private int precioProducto;
	private int stockProducto;
	private String descripcionProduto;

	public Producto() {
	}

	public Producto(int sku, Categoria categoria, Marca marca, String nombreProduto, int precioProducto,
			int stockProducto, String descripcionProduto) {
		this.sku = sku;
		this.categoria = categoria;
		this.marca = marca;
		this.nombreProduto = nombreProduto;
		this.precioProducto = precioProducto;
		this.stockProducto = stockProducto;
		this.descripcionProduto = descripcionProduto;
	}

	@Id

	@Column(name = "SKU", unique = true, nullable = false)
	public int getSku() {
		return this.sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria", nullable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marca", nullable = false)
	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Column(name = "nombre_produto", nullable = false, length = 50)
	public String getNombreProduto() {
		return this.nombreProduto;
	}

	public void setNombreProduto(String nombreProduto) {
		this.nombreProduto = nombreProduto;
	}

	@Column(name = "precio_producto", nullable = false)
	public int getPrecioProducto() {
		return this.precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}

	@Column(name = "stock_producto", nullable = false)
	public int getStockProducto() {
		return this.stockProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}

	@Column(name = "descripcion_produto", nullable = false, length = 100)
	public String getDescripcionProduto() {
		return this.descripcionProduto;
	}

	public void setDescripcionProduto(String descripcionProduto) {
		this.descripcionProduto = descripcionProduto;
	}

}