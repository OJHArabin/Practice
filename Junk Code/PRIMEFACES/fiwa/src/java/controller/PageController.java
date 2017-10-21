
package controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PageController {
    private String centerContent;
    public PageController() 
    {
    }
    @PostConstruct
    public void init()
    {
        centerContent="IndexBody";
    }
    public void setCurrentMenuItem(String menuItemName)
    {
        centerContent=menuItemName;
    }

    public String getCenterContent() {
        return centerContent;
    }
}
