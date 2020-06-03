# school

Sistema de gestión escolar en javaEE.

TABLAS PENDIENTES DE CREAR

* Parents
* Studen Medical
* Transportation
** Matriculas
* Inscripcion
** User tranform to person


FUNCIONALIDADES PENDIENTES

* Reportes con jasper


*----------------------------------*

Codigo para construir select ne menu

<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html>
    <body>
        <f:view>      
            <h:form>
                <h:panelGrid>
                 <h:commandButton value="Load SelectOneMenu" action="#{pageBean.loadMenu}" />
              <h:commandButton value="Create Postback" action="#{pageBean.doNothing}" />
          </h:panelGrid>
          <h:panelGrid binding="#{pageBean.panel}" />
         </h:form>
        </f:view>
    </body>
</html>

public class PageBean {
     
    private HtmlPanelGrid panel;
    private List<SelectItem> selectItems;

    public HtmlPanelGrid getPanel() {
        return panel;
    }

    public void setPanel(HtmlPanelGrid panel) {
        this.panel = panel;
    }
        
    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<SelectItem> selectItems) {
        this.selectItems = selectItems;
    }

    public void loadMenu() {       
        selectItems = new Vector<SelectItem>();
        SelectItem selectItem1 = new SelectItem("first", "First Option");
        SelectItem selectItem2 = new SelectItem("second", "Second Option");
        selectItems.add(selectItem1);
        selectItems.add(selectItem2);
        
        HtmlSelectOneMenu menu = new HtmlSelectOneMenu();
        UISelectItems items = new UISelectItems();
        
        ValueExpression expr = getValueExpression("#{pageBean.selectItems}");
        items.setValueExpression("value", expr);
        
        menu.getChildren().add(items);
        panel.getChildren().add(menu);
    }
    
    public void doNothing() {
    }
    
    private ValueExpression getValueExpression(String expression) {
        ExpressionFactory expressionFactory = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
        ELContext expressionContext = FacesContext.getCurrentInstance().getELContext();
        return expressionFactory.createValueExpression(expressionContext, expression, Object.class);
    }
    
}
