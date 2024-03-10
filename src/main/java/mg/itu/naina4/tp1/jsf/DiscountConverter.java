/*
 *Convertisseur JSF pour les objets Discount
 *Converti les discount en String 
 *Converti les String en discount
 */
package mg.itu.naina4.tp1.jsf;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import mg.itu.naina4.tp1.entity.Discount;
import mg.itu.naina4.tp1.service.DiscountManager;

/**
 *
 * @author NainaMatthieu
 */
@FacesConverter(value = "discountConverter", managed=true)
public class DiscountConverter implements Converter<Discount> {

    @Inject
    private DiscountManager discountManager;

    /**
     * Convertit une String en Discount.
     *
     * @param value valeur à convertir
     */
    @Override
    public Discount getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        return discountManager.findById(value);
    }

    /**
     * Convertit un Discount en String.
     *
     * @param value valeur à convertir
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Discount discount) {
        if (discount == null) {
            return "";
        }
        return discount.getCode();
    }
}
