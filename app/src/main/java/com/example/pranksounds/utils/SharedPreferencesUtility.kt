package com.example.pranksounds.utils

import android.content.Context
import android.preference.PreferenceManager

object SharedPreferencesUtility {

    fun setPreference(context: Context?, key: String?, value: Long) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun setPreference(context: Context?, key: String?, value: Boolean) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    /*fun getPreference(context: Context?, key: String?, defaultValue: Int): Int {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getInt(key, defaultValue)
    }*/

    fun getPreference(context: Context?, key: String?, defaultValue: Long): Long {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getLong(key, defaultValue)
    }

    fun getPreference(context: Context?, key: String?, defaultValue: Boolean): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getBoolean(key, defaultValue)
    }

    fun setPreference(context: Context?, key: String?, value: String?) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getPreference(context: Context?, key: String?, defaultValue: String?): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(key, defaultValue)
    }

    fun deletePreference(context: Context?, key: String?) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        preferences.edit().remove(key).apply()
    }
}