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
import java.util.Comparator;

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

    /**
     * Récupère tous les Discount et les trie par ordre croissant de taux de
     * réduction.
     *
     * @return Une liste triée par ordre croissant des objets Discount.
     */
    public List<Discount> getAllDiscountsAsc() {
        List<Discount> discounts = getAllDiscounts();
        discounts.sort(Comparator.comparing(Discount::getRate));
        return discounts;
    }

    /**
     * Récupère tous les Discount et les trie par ordre décroissant de taux de
     * réduction.
     *
     * @return Une liste triée par ordre décroissant des objets Discount.
     */
    public List<Discount> getAllDiscountsDesc() {
        List<Discount> discounts = getAllDiscounts();
        discounts.sort(Comparator.comparing(Discount::getRate).reversed());
        return discounts;
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

    @Transactional
    public Discount update(Discount discount) {
        return em.merge(discount);
    }
}
