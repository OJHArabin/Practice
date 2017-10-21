
package controller;

import entity.Page;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import logic.PageFacade;

@ManagedBean
@RequestScoped
public class PageController {

   private Page currentPage;
  @EJB
  PageFacade pageFacade;

   private List<Page> pageList;
    public PageController()
    {
    }
        @PostConstruct
       public void init()
       {
           currentPage=new Page();
           pageList=new LinkedList<>();
           
                   
       }
    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    
   public String save()
   {
       System.out.println("Save Called");
       pageFacade.create(currentPage);
       currentPage.setPageName(null);
       currentPage.setPageId(null);
       currentPage.setPageContent(null);
       currentPage.setPageUrl(null);
       
       return "adminPanel";
   }

    public List<Page> getPageList() {
        return pageFacade.findAll();
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }
    
}
