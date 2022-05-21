package com.folioreader.model

import android.util.Log
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.folioreader.util.ObjectMapperSingleton
import java.io.Serializable

class SelectedWord(var word: String, var left: Int, var top: Int) : Serializable {

    @Suppress("unused") // Required for fromJSON()
    constructor() : this("", 0, 0)

    fun toJson(): String? {

        return try {
            val objectMapper = ObjectMapper()
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
            objectMapper.writeValueAsString(this)
        } catch (e: Exception) {
            Log.e(LOG_TAG, "-> ", e)
            null
        }
    }

    companion object {
        private const val LOG_TAG: String = "SelectedWord"

        @JvmStatic
        fun fromJson(json: String?): SelectedWord? {
            return try {
                ObjectMapperSingleton.getObjectMapper()
                    .reader()
                    .forType(SelectedWord::class.java)
                    .readValue(json)
            } catch (e: Exception) {
                Log.e(LOG_TAG, "-> ", e)
                null
            }
        }
    }
}