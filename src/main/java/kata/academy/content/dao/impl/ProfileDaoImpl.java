package kata.academy.content.dao.impl;

import kata.academy.content.dao.ProfileDao;
import kata.academy.content.model.entity.Profile;
import kata.academy.content.util.JpaUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class ProfileDaoImpl implements ProfileDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persistProfile(Profile profile) {
        entityManager.persist(profile);
    }

    @Override
    public Optional<Profile> getProfileByAccountId(long accountId) {
        return JpaUtil.getSingleResultOrNull(entityManager.createQuery(
                        """
                                SELECT p
                                FROM Profile p
                                WHERE p.accountId = :accountId
                           """, Profile.class)
                .setParameter("accountId", accountId)
        );
    }

    @Override
    public void updateProfile(Profile profile) {
        entityManager.merge(profile);
    }


}
