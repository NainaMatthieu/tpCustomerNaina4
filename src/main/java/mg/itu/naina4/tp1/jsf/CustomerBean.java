/**
 * Backing bean pour la page JSF customerList.
 *
 * @author NainaMatthieu
 */
package mg.itu.naina4.tp1.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.itu.naina4.tp1.entity.Customer;
import mg.itu.naina4.tp1.service.CustomerManager;

/**
 *
 * @author NainaMatthieu
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

    private List<Customer> customerList;
    @Inject
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     * @return La liste des clients.
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }
}
