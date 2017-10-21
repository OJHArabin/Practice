
package controller;

import entity.Menu;
import entity.Page;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import logic.MenuFacade;
import logic.PageFacade;

@ManagedBean
@RequestScoped
public class MenuController {

   private Menu currentMenu;

    public Integer getPageID() {
        return pageID;
    }

    public void setPageID(Integer pageID) {
        this.pageID = pageID;
    }
   Integer pageID;
   
  @EJB
  MenuFacade menuFacade;
  @EJB
  PageFacade pageFacade;

   private List<Menu> menuList;
    public MenuController()
    {
    }
        @PostConstruct
       public void init()
       {
           currentMenu=new Menu();
           menuList=new LinkedList<>();
           
                   
       }
    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    
   public String save()
   {
        FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage("Message"));
       System.out.println("Current Menu is "+currentMenu);
       currentMenu.setPage(pageFacade.find(pageID));
       menuFacade.create(currentMenu);
       
       currentMenu.setMenuName(null);
       currentMenu.setMenuId(null);
       currentMenu.setSubMenu(null);
       currentMenu.setPage(null);
       
       return "adminPanel";
   }

    public List<Menu> getMenuList() {
        return menuFacade.findAll();
    }
    public List<Page> getPageList()
    {
        return pageFacade.findAll();
       
    }
    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
    
}
