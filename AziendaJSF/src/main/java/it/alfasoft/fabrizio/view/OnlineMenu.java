package it.alfasoft.fabrizio.view;
 
import it.alfasoft.fabrizio.bean.Dipendente;
import it.alfasoft.fabrizio.service.GestioneUtenti;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
 
@ManagedBean
public class OnlineMenu {
     
    private MenuModel model;
    private GestioneUtenti gU;
 
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        gU = new GestioneUtenti();
        
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Utenti Online"); 
        DefaultMenuItem item;
        
        for(Dipendente d : gU.getListDipendenti()){
        	item = new DefaultMenuItem(d.getCognome()+" "+d.getNome());
        	item.setIcon("fa fa-fw fa-comments-o");
        	item.setOnclick("");
        	firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
    }
 
    public MenuModel getModel() {
        return model;
    }
}