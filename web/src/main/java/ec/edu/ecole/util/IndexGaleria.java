/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ecole.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

/**
 *
 * @author MASHUK
 */
public class IndexGaleria implements java.io.Serializable {

	private static final long serialVersionUID = 3919756577520664789L;
	private List<IndexGaleria> images = new ArrayList<IndexGaleria>();
	private String image;
	private String caption;

	/** Creates a new instance of IndexGaleria */
	public IndexGaleria() {
	}

	@PostConstruct
	public void init() {
		for (int i = 1; i < 4; i++) {
			IndexGaleria ig = new IndexGaleria();
			ig.setImage("Escuela" + i + ".jpg");
			ig.setCaption("Nature " + i);
			images.add(ig);
		}

	}

	public List<IndexGaleria> getImages() {
		return images;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
