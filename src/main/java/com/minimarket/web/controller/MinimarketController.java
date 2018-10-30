package com.minimarket.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.minimarket.web.DAO.IProductoDAO;
import com.minimarket.web.DAO.MarcaDAO;
import com.minimarket.web.DAO.ProductoDAO;
import com.minimarket.web.DAO.CategoriaDAO;
import com.minimarket.web.DAO.ICategoriaDAO;
import com.minimarket.web.DAO.IMarcaDAO;
import com.minimarket.web.entity.Marca;
import com.minimarket.web.entity.Producto;
import com.minimarket.web.entity.Categoria;;

@Controller
@RequestMapping("/minimarket")
public class MinimarketController {

	@Autowired
	private MarcaDAO mDAO;

	@Autowired
	private ProductoDAO pDAO;

	@Autowired
	private CategoriaDAO cDAO;

	
	@GetMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("productos", pDAO.crud().findAll());

		return "listar_productos.html";
	}

	@GetMapping("/crear")
	public String crear(Model model) {

		model.addAttribute("categorias", cDAO.crud().findAll());
		model.addAttribute("marcas", mDAO.crud().findAll());

		return "agregar.html";
	}

	@PostMapping("/almacenar")
	public String almacenar(Model model, RedirectAttributes ra, 
			@RequestParam("txtSKU") int sku,
			@RequestParam("txtNombre") String nombre,
			@RequestParam("txtPrecio") int precio,
			@RequestParam("cboMarca") int marcaId,
			@RequestParam("cboCategoria") int categoriaId,
			@RequestParam("txtDescripcion") String descripcion
			) {

		Categoria categoria = new Categoria();
		categoria.setIdCategoria(categoriaId);
		
		Marca marca = new Marca();
		marca.setIdMarca(marcaId);

		Producto producto = new Producto();
		producto.setCategoria(categoria);
		producto.setMarca(marca);
		producto.setSku(sku);
		producto.setNombreProduto(nombre);
		producto.setPrecioProducto(precio);
		producto.setDescripcionProduto(descripcion);

		// guardamos el animal y comprobamos que se haya
		// insertado correctamente
		Producto produtoAgregado = pDAO.crud().save(producto);
		String mensaje = "Error al agregar el producto";
		if (produtoAgregado != null) {
			mensaje = "Producto Guardado correctamente";
		}

		ra.addFlashAttribute("mensaje", mensaje);

		return "redirect:crear";
	}

	@GetMapping("/eliminar")
	public String eliminar(Model model, RedirectAttributes ra, @RequestParam("id") int id) {

		String mensaje = "";

		try {
			// eliminamos al animal
			pDAO.crud().deleteById(id);
			mensaje = "Eliminado correctamente";
		} catch (Exception ex) {
			mensaje = "No se ha podido eliminar";
		}

		ra.addFlashAttribute("mensaje", mensaje);

		return "redirect:listar";
	}

	@GetMapping("/modificar")
	public String modificar(Model model,
			RedirectAttributes ra,
			@RequestParam("id") int id) {
		
		//buscamos al animal
		Producto p = null;
		
		try {
			
			p = pDAO.crud().findById(id).get();
			
		} catch (Exception e) {
			
			//si el animal no existe en la BBDD
			//lo redirigimos de vuelta con un mensaje de error
			ra.addFlashAttribute("mensaje", "El Producto no existe");
			return "redirect:listar";
		}
		
		//si encuentra el animal lo enviamos a la vista
		model.addAttribute("p", p);
		
		//mandamos las razas y familias para llenar los combobox
		model.addAttribute("categorias", cDAO.crud().findAll());
		model.addAttribute("marcas", mDAO.crud().findAll());
		
		return "modificar.html";
	}

	@PostMapping("/actualizar")
	public String actualizar(Model model,
			RedirectAttributes ra,
			@RequestParam("txtId") int id,
			@RequestParam("txtNombre") String nombre,
			@RequestParam("txtPeso") float peso,
			@RequestParam("cboCategoria") int categoriaId,
			@RequestParam("cboMarca") int marcaId)
	{
			
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(categoriaId);
		Marca marca=new Marca();
		marca.setIdMarca(marcaId);
		
		Producto produto = new Producto();
		//producto.setSku(id);
		
		produto.setMarca(marca);
		//guardamos el animal y comprobamos que se haya
		//insertado correctamente
		Producto productoAgregado = pDAO.crud().save(produto);
		String mensaje = "Error al modificar";
		if(productoAgregado!= null) {
			mensaje = "Modificado correctamente";
		}
		
		ra.addFlashAttribute("mensaje", mensaje);
		
		return "redirect:listar";
	}
	
	
	
	
	
}
