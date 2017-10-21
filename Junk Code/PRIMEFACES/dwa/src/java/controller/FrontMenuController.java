/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import entity.Menu;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import logic.MenuFacade;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;


/**
 *
 * @author Rabin pc
 */
@ManagedBean
@SessionScoped
public class FrontMenuController {
  
    private MenuModel menuModel ;
     @EJB
     private MenuFacade menuFacade;
    /**
     * Creates a new instance of FirstController
     */
     @PostConstruct
    public void init()
    {
        List<Menu> menuFacadeList=menuFacade.findAll();
        menuModel=new DefaultMenuModel();
        Map<String,List<String>> menuSubMenuMap=new HashMap<>();
        for(Menu menuFacade:menuFacadeList)
        {
            if(!menuSubMenuMap.containsKey(menuFacade.getMenuName()))
            {
                List<String> subMenuList=new LinkedList<>();
                
                subMenuList.add(menuFacade.getSubMenu());
                menuSubMenuMap.put(menuFacade.getMenuName(), subMenuList);
             }
            else
            {
                menuSubMenuMap.get(menuFacade.getMenuName()).add(menuFacade.getSubMenu());
            }
            
        }
        Set<String> keySet=menuSubMenuMap.keySet();
        for(String key:keySet)
        {
            DefaultSubMenu subMenu=new DefaultSubMenu(key);
            List<String> subMenuNameList=menuSubMenuMap.get(key);
            for(String subMenuName:subMenuNameList)
            {
                DefaultMenuItem menuItem=new DefaultMenuItem(subMenuName);
           
                subMenu.addElement(menuItem);
            }
            menuModel.addElement(subMenu);
        }
        System.out.println("Size of menu is menu model"+ menuModel.getElements().size());
       
       
    }
    public FrontMenuController() {
    }

    public MenuFacade getMenu() {
        return menuFacade;
    }

    public void setMenu(MenuFacade menuFacade) {
        this.menuFacade = menuFacade;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }
    
}
