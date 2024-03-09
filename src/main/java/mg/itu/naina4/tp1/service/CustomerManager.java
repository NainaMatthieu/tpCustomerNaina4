/**
 * Façade pour gérer les Customers.
 *
 * @author NainaMatthieu
 */
package mg.itu.naina4.tp1.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.naina4.tp1.entity.Customer;

@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Permet de persister un client dans la base de données. Cette méthode
     * utilise la gestion de transaction pour garantir l'intégrité des données.
     * Elle prend un objet Customer en paramètre et le persiste dans la base de
     * données.
     *
     * @param customer Le client à persister dans la base de données.
     */
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }

}
