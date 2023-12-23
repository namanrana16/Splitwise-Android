package com.example.splitwise.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.splitwise.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
): ViewModel() {


}