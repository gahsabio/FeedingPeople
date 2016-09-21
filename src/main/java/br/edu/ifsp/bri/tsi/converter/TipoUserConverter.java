/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.converter;

import br.edu.ifsp.bri.tsi.domain.TipoUser;
import br.edu.ifsp.bri.tsi.service.TipoUserService;
import br.edu.ifsp.bri.tsi.util.ClassLocatorService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author gahsabio
 */

@FacesConverter(value = "tipoUserConverter", forClass = TipoUser.class )
public class TipoUserConverter implements Converter {
    
    private TipoUser tipoUser;
    
    private TipoUserService tipoUserService;    

    public TipoUserConverter() {
         tipoUserService = ClassLocatorService.getBean(TipoUserService.class);
    }
    
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       if ( string == null || string.length() == 0) {
           return null;
       }
//       tipoUser = tipoUserService.findTipoUserById(this.getKey(string));
       return tipoUser;  
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
       if ( o == null ){
            return null;
       }
       if ( o instanceof TipoUser ){
           TipoUser tipoUser = (TipoUser) o;
           return getStringKey(tipoUser.getCodigoTpUsuario());
       }
       return null;
    }
    
    
    private Integer getKey( String string ){
        java.lang.Integer key;
        key = Integer.valueOf(string);
        return key;
    }
    
    private String getStringKey( Integer value ){
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }
}
