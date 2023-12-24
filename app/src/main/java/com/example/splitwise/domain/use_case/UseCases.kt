package com.example.splitwise.domain.use_case

import com.example.splitwise.domain.use_case.getHomeDetails.GetHomeDetails
import com.example.splitwise.domain.use_case.get_transaction.GetTransactionUseCase
import com.example.splitwise.domain.use_case.read_onboarding.ReadOnboardingUseCase
import com.example.splitwise.domain.use_case.save_onboarding.SaveOnboardingUseCase
import com.example.splitwise.domain.use_case.search_transaction.SearchTransactionUseCase

data class UseCases(
    val getHomeDetailsUseCase: GetHomeDetails,
    val saveOnBoardingUseCase: SaveOnboardingUseCase,
    val readOnBoardingUseCase: ReadOnboardingUseCase,
    val searchTransaction: SearchTransactionUseCase,
    val getTransaction: GetTransactionUseCase
)