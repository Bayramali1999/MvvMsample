package uz.alisoft.data.storage

import android.content.Context

const val SHARED_PREFERENCE_NAME = "SHARED_PREFERENCE_NAME"
const val FIRST_NAME = "FIRST_NAME"
const val LAST_NAME = "LAST_NAME"
const val DEFAULT_LAST_NAME = "DEFAULT_LAST_NAME"
const val DEFAULT_FIRST_NAME = "DEFAULT_FIRST_NAME"

class SharedPreferenceStorage(ctx: Context) : UserStorage {
    private val sharedPreferences =
        ctx.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(FIRST_NAME, user.firstname).apply()
        sharedPreferences.edit().putString(LAST_NAME, user.lastname).apply()
        return true
    }

    override fun get(): User {
        val firstName =
            sharedPreferences.getString(FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName =
            sharedPreferences.getString(LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME

        return User(firstName, lastName)
    }
}