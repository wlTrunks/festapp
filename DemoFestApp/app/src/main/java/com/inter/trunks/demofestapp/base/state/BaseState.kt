package com.inter.trunks.demofestapp.base.state

import me.ilich.juggler.states.ContentOnlyState
import me.ilich.juggler.states.State
import org.koin.standalone.KoinComponent

abstract class BaseState(params: State.Params?) : ContentOnlyState<State.Params>(params), KoinComponent