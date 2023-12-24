package com.example.splitwise.domain.use_case.read_onboarding

import com.example.splitwise.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnboardingUseCase( private val repository: Repository) {

        operator fun invoke(): Flow<Boolean>
        {
            return repository.readOnBoardingState()
        }
}