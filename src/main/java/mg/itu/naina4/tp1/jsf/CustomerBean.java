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
     *
     * @return La liste des clients.
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }

    /**
     * Compare deux objets Customer pour le tri par état puis par ville.
     *
     * @param o Le premier objet Customer à comparer
     * @param b Le deuxième objet Customer à comparer
     * @return Un entier négatif si le premier objet est situé avant le deuxième
     * dans l'ordre de tri, zéro s'ils sont considérés comme égaux, ou un entier
     * positif si le premier objet est situé après le deuxième. L'ordre de tri
     * est déterminé en fonction de l'état, puis de la ville dans cet état.
     */
    public int trieParEtatPuisVille(Object o, Object b) {
        Customer customer1 = (Customer) o;
        Customer customer2 = (Customer) b;
        int etatComp = customer1.getState().compareTo(customer2.getState());
        if (etatComp != 0) {
            return etatComp;
        } else {
            // Si les états sont égaux, on compare les villes dans cet état
            return customer1.getCity().compareTo(customer2.getCity());
        }
    }
}
