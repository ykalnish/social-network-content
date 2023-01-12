package kata.academy.content.dao;

import kata.academy.content.model.entity.Profile;

import java.util.Optional;

public interface ProfileDao {

    void persistProfile(Profile profile);

    Optional<Profile> getProfileByAccountId(long accountId);

    void updateProfile(Profile profile);
}
