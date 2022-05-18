package com.folioreader.android.sample

import android.content.Context
import android.util.Log
import com.folioreader.model.locators.ReadLocator

object UserDataHelper {
    private const val SP_FILE_NAME = "sp_file_user"
    private const val SP_KEY_LOCATOR = "key_locator"

    fun saveDemoBookLocator(context: Context, locator: ReadLocator) {
        val sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        sp.edit().putString(SP_KEY_LOCATOR, locator.toJson()).apply()
    }

    fun getDemoBookLocator(context: Context): ReadLocator? {
        val sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        val jsonStr = sp.getString(SP_KEY_LOCATOR, "")
        Log.i("UserDataHelper", "-> getReadLocator -> $jsonStr")
        return ReadLocator.fromJson(jsonStr)
    }
}