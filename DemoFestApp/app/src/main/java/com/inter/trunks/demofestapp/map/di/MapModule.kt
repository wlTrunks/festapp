package com.inter.trunks.demofestapp.map.di

import com.inter.trunks.demofestapp.map.repository.GetEventPoints
import com.inter.trunks.demofestapp.map.repository.MockEventPointsRepository
import com.inter.trunks.demofestapp.map.vm.MapFragmentVM
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module


const val MAP_MODULE: String = "map_module"
const val MAP_VM: String = "map_vm"
val MapModule: Module = module(path = MAP_MODULE) {
    single { MockEventPointsRepository() as GetEventPoints }
    viewModel(name = MAP_VM) { MapFragmentVM() }
}