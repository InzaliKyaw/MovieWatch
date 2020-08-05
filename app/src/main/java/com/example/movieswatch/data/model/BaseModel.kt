package com.example.movieswatch.data.model

import com.example.movieswatch.network.dataagent.MoviesDataAgents
import com.example.movieswatch.network.dataagent.RetrofitDataAgentImpl

abstract class BaseModel {
    val mDataAgents: MoviesDataAgents = RetrofitDataAgentImpl
}