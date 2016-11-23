package it.alfasoft.fabrizio.view;
 
import java.util.ArrayList;
import java.util.List;

import it.alfasoft.fabrizio.bean.Dipendente;
import it.alfasoft.fabrizio.service.GestioneUtenti;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
 
@ManagedBean
@ViewScoped
public class OnlineMenu {
     
    private MenuModel model;
    private GestioneUtenti gU;
    private List<Dipendente> online;
 
    @PostConstruct
    public void init() {
    	setOnline(new ArrayList<Dipendente>());
    	
        model = new DefaultMenuModel();
        gU = new GestioneUtenti();
        
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Utenti Online"); 
        DefaultMenuItem item;
        
        for(Dipendente d : gU.getOnline()){
        	item = new DefaultMenuItem(d.getCognome()+" "+d.getNome());
        	item.setIcon("fa fa-fw fa-comments-o");
        	item.setId("d"+d.getId_utente());
        	item.setOnclick("");
        	item.setUpdate("@form");
        	firstSubmenu.addElement(item);
        }
        
//        online.add(gU.getOnline().get(0));
        model.addElement(firstSubmenu);
    }
 
    public MenuModel getModel() {
        return model;
    }

	public List<Dipendente> getOnline() {
		return online;
	}

	public void setOnline(List<Dipendente> online) {
		this.online = online;
	}
	
    public void updateModel(){
        this.init();
    }
    
    public void create(Dipendente d){
    	online.add(d);
    }
}