package kata.academy.content.service;

import kata.academy.content.model.dto.ProfilePersistRequestDto;
import kata.academy.content.model.enums.Visibility;

public interface ProfileService {

    void persistProfile(ProfilePersistRequestDto dto);

    void updateVisibility(Visibility visibility, long profileId);
}
