/**
 * Façade pour gérer les Discount (réduction possible des clients).
 *
 * @author NainaMatthieu
 */
package mg.itu.naina4.tp1.service;

import mg.itu.naina4.tp1.entity.Discount;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;

/**
 *
 * Gère la persistance des discount.
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

    @Transactional
    public Discount update(Discount discount) {
        return em.merge(discount);
    }
}
