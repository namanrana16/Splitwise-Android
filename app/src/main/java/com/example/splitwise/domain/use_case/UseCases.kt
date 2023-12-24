package com.example.splitwise.domain.use_case

import com.example.splitwise.domain.use_case.getHomeDetails.GetHomeDetails
import com.example.splitwise.domain.use_case.read_onboarding.ReadOnboardingUseCase
import com.example.splitwise.domain.use_case.save_onboarding.SaveOnboardingUseCase

data class UseCases(
    val getHomeDetailsUseCase: GetHomeDetails,
    val saveOnBoardingUseCase: SaveOnboardingUseCase,
    val readOnBoardingUseCase: ReadOnboardingUseCase
    //val searchTransaction: SearchHeroUseCase,
   // val getTransaction:GetSelectedHeroUseCase
)