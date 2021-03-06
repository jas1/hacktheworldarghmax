package sample1.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sample1.common.web.FacesUtils;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean(name="pantalla1Bean")
public class Pantalla1Bean implements Serializable {

	public String elegirGrowler(){
		FacesUtils.getManagedBean(SessionBean.class).setGrowlerOrMesa("growler");
		return "pantalla2";
	}
	
	public String elegirBar(){
		FacesUtils.getManagedBean(SessionBean.class).setGrowlerOrMesa("bar");
		return "pantalla2";
	}
			
}
