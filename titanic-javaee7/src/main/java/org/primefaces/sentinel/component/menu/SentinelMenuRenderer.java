/*
 * Copyright 2009-2015 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.sentinel.component.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import org.primefaces.component.api.AjaxSource;
import org.primefaces.component.api.UIOutcomeTarget;
import org.primefaces.component.menu.AbstractMenu;
import org.primefaces.component.menu.BaseMenuRenderer;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.Separator;
import org.primefaces.model.menu.Submenu;
import org.primefaces.util.ComponentUtils;

public class SentinelMenuRenderer extends BaseMenuRenderer {

    @Override
    protected void encodeMarkup(FacesContext context, AbstractMenu abstractMenu) throws IOException {
        SentinelMenu menu = (SentinelMenu) abstractMenu;
        ResponseWriter writer = context.getResponseWriter();
        String clientId = menu.getClientId(context);
        String style = menu.getStyle();
        String styleClass = menu.getStyleClass();
        styleClass = (styleClass == null) ? "layout-menubar-container" : "layout-menubar-container " + styleClass;
        
        writer.startElement("ul", menu);
        writer.writeAttribute("id", clientId, "id");
        writer.writeAttribute("class", styleClass, "styleClass");
        if(style != null) {
            writer.writeAttribute("style", style, "style");
        }
        
        if(menu.getElementsCount() > 0) {
            encodeElements(context, menu, menu.getElements(), 0);
        }
        
        writer.endElement("ul");
    }
    
    protected void encodeElements(FacesContext context, AbstractMenu menu, List<MenuElement> elements, int marginLevel) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String menuClientId = menu.getClientId(context);
        
        for(MenuElement element : elements) {
            if(element.isRendered()) {
                if(element instanceof MenuItem) {
                    MenuItem menuItem = (MenuItem) element;
                    String menuItemClientId = (menuItem instanceof UIComponent) ? menuItem.getClientId() : menuClientId + "_" + menuItem.getClientId();
                    String containerStyle = menuItem.getContainerStyle();
                    String containerStyleClass = menuItem.getContainerStyleClass();

                    writer.startElement("li", null);
                    writer.writeAttribute("id", menuItemClientId, null);
                    writer.writeAttribute("role", "menuitem", null);
                    
                    if(containerStyle != null) writer.writeAttribute("style", containerStyle, null);
                    if(containerStyleClass != null) writer.writeAttribute("class", containerStyleClass, null);

                    encodeMenuItem(context, menu, menuItem, marginLevel);
                    
                    writer.endElement("li");
                }
                else if(element instanceof Submenu) {
                    Submenu submenu = (Submenu) element;
                    String submenuClientId = (submenu instanceof UIComponent) ? ((UIComponent) submenu).getClientId() : menuClientId + "_" + submenu.getId();
                    String style = submenu.getStyle();
                    String styleClass = submenu.getStyleClass();
                    
                    writer.startElement("li", null);
                    writer.writeAttribute("id", submenuClientId, null);
                    writer.writeAttribute("role", "menuitem", null);
                    
                    if(style != null) writer.writeAttribute("style", style, null);
                    if(styleClass != null) writer.writeAttribute("class", styleClass, null);
 
                    encodeSubmenu(context, menu, submenu, marginLevel);
                    
                    writer.endElement("li");
                } 
                else if(element instanceof Separator) {
                    encodeSeparator(context, (Separator) element);
                }
            }
        }
    }
    
    protected void encodeMenuItem(FacesContext context, AbstractMenu menu, MenuItem menuitem, int marginLevel) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String title = menuitem.getTitle();
        boolean disabled = menuitem.isDisabled();
        String style = menuitem.getStyle();

        writer.startElement("a", null);
        if(title != null) writer.writeAttribute("title", title, null);
        if(style != null) writer.writeAttribute("style", style, null);
        if(marginLevel > 0) writer.writeAttribute("class", "marginLevel-" + marginLevel, null);

        if(disabled) {
            writer.writeAttribute("href", "#", null);
            writer.writeAttribute("onclick", "return false;", null);
        }
        else {
            String onclick = menuitem.getOnclick();
            if(marginLevel == 0) {
                onclick = (onclick == null) ? "Sentinel.toggleSubMenu(this)" : "Sentinel.toggleSubMenu(this);" + onclick;
            }

            //GET
            if(menuitem.getUrl() != null || menuitem.getOutcome() != null) {                
                String targetURL = getTargetURL(context, (UIOutcomeTarget) menuitem);
                writer.writeAttribute("href", targetURL, null);

                if(menuitem.getTarget() != null) {
                    writer.writeAttribute("target", menuitem.getTarget(), null);
                }
            }
            //POST
            else {
                writer.writeAttribute("href", "#", null);

                UIComponent form = ComponentUtils.findParentForm(context, menu);
                if(form == null) {
                    throw new FacesException("MenuItem must be inside a form element");
                }

                String command;
                if(menuitem.isDynamic()) {
                    String menuClientId = menu.getClientId(context);
                    Map<String,List<String>> params = menuitem.getParams();
                    if(params == null) {
                        params = new LinkedHashMap<String, List<String>>();
                    }
                    List<String> idParams = new ArrayList<String>();
                    idParams.add(menuitem.getId());
                    params.put(menuClientId + "_menuid", idParams);

                    command = menuitem.isAjax() ? buildAjaxRequest(context, menu, (AjaxSource) menuitem, form, params) : buildNonAjaxRequest(context, menu, form, menuClientId, params, true);
                } 
                else {
                    command = menuitem.isAjax() ? buildAjaxRequest(context, (AjaxSource) menuitem, form) : buildNonAjaxRequest(context, ((UIComponent) menuitem), form, ((UIComponent) menuitem).getClientId(context), true);
                }

                onclick = (onclick == null) ? command : onclick + ";" + command;
            }

            if(onclick != null) {
                writer.writeAttribute("onclick", onclick, null);
            }
        }

        encodeMenuItemContent(context, menu, menuitem);

        writer.endElement("a");
	}
    
    @Override
    protected void encodeMenuItemContent(FacesContext context, AbstractMenu menu, MenuItem menuitem) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String icon = menuitem.getIcon();
        Object value = menuitem.getValue();
        
        if(icon != null) {
            writer.startElement("i", null);
            writer.writeAttribute("class", icon + " yellow i", null);
            writer.endElement("i");
        }

        if(value != null) {
            writer.writeText(" " + value, "value");
        }
    }
    
    protected void encodeSubmenu(FacesContext context, AbstractMenu menu, Submenu submenu, int marginLevel) throws IOException{
		ResponseWriter writer = context.getResponseWriter();
        String icon = submenu.getIcon();
        String label = submenu.getLabel();

        //title
        writer.startElement("a", null);
        writer.writeAttribute("href", "#", null);
        writer.writeAttribute("onclick", "Sentinel.toggleSubMenu(this);return false;", null);
        if(marginLevel > 0) {
            writer.writeAttribute("class", "marginLevel-" + marginLevel, null);
        }
        
        if(icon != null) {
            writer.startElement("i", null);
            writer.writeAttribute("class", icon + " yellow i", null);
            writer.endElement("i");
        }

        if(label != null) {
            writer.writeText(label, null);
        }
        
        writer.startElement("i", null);
        writer.writeAttribute("class", "icon-angle-down Fright", null);
        writer.endElement("i");
       
        writer.endElement("a");

        //submenus and menuitems
        if(submenu.getElementsCount() > 0) {
            writer.startElement("ul", null);
            writer.writeAttribute("class", "layout-menubar-submenu-container", null);
            writer.writeAttribute("role", "menu", null);
			encodeElements(context, menu, submenu.getElements(), ++marginLevel);
			writer.endElement("ul");
        }
	}

    @Override
    protected void encodeScript(FacesContext context, AbstractMenu abstractMenu) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("script", null);
        writer.writeAttribute("type", "text/javascript", null);
        writer.write("Sentinel.restoreMenuState();");
        writer.endElement("script");
    }
}
