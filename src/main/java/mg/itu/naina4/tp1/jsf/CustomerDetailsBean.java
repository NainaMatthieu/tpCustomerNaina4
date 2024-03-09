/**
 * Backing bean pour la page JSF customerDetail.
 *
 * @author NainaMatthieu
 */
package mg.itu.naina4.tp1.jsf;

import java.io.Serializable;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mg.itu.naina4.tp1.entity.Customer;
import mg.itu.naina4.tp1.service.CustomerManager;

/**
 *
 * @author NainaMatthieu
 */
@Named(value = "customerDetailsBean")
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @Inject
    private CustomerManager customerManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }

}
