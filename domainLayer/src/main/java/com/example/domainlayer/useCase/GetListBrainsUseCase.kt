package com.example.domainlayer.useCase

import com.example.domainlayer.repository.JetBrainsRepository

class GetListBrainsUseCase (private val jetBrainsRepository: JetBrainsRepository) {
    suspend operator fun invoke() = jetBrainsRepository.getListJetBrains()
}
