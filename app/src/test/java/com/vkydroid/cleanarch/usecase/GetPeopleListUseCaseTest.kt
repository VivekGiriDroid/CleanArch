package com.vkydroid.cleanarch.usecase

import com.nhaarman.mockitokotlin2.whenever
import com.vkydroid.cleanarch.domain.People
import com.vkydroid.cleanarch.domain.common.Resource
import com.vkydroid.cleanarch.domain.reppository.PeopleRepository
import com.vkydroid.cleanarch.domain.usecases.GetPeopleListUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetPeopleListUseCaseTest {

    private lateinit var getPeopleListUseCase: GetPeopleListUseCase
    private lateinit var peopleRepositoryImpl: PeopleRepository

    @Before
    fun setUp() {
        getPeopleListUseCase = GetPeopleListUseCase(peopleRepositoryImpl)
    }

    @Test
    fun `invoke should return people list`(){
        runBlocking {
            whenever(peopleRepositoryImpl.getPeople()).thenReturn(Resource<List<People>>())

        }
    }
}