package com.vkydroid.cleanarch.domain.usecases

import com.vkydroid.cleanarch.domain.reppository.PeopleRepository
import javax.inject.Inject

class GetPeopleListUseCase @Inject constructor(
    private val peopleRepository: PeopleRepository
) {
    internal suspend operator fun invoke() = peopleRepository.getPeople()
}