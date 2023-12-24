package com.example.splitwise.domain.use_case.save_onboarding

import com.example.splitwise.data.repository.Repository

class SaveOnboardingUseCase(
    private val repository: Repository
) {

        suspend operator fun invoke(completed:Boolean)
        {

            repository.savedOnBoardingState(completed = completed)
        }
}