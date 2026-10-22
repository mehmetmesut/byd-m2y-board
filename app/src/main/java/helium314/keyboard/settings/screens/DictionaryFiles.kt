// SPDX-License-Identifier: GPL-3.0-only
package helium314.keyboard.settings.screens

import android.content.Context
import helium314.keyboard.latin.common.LocaleUtils
import helium314.keyboard.latin.utils.DictionaryInfoUtils
import java.io.File
import java.util.Locale

/** @return list of user dictionary files and whether an internal dictionary exists */
fun getUserAndInternalDictionaries(context: Context, locale: Locale): Pair<List<File>, Boolean> {
    val userDicts = mutableListOf<File>()
    var hasInternalDict = false
    val userLocaleDir = DictionaryInfoUtils.getCacheDirectoryForLocale(locale, context)?.let { File(it) }
    if (userLocaleDir?.exists() == true && userLocaleDir.isDirectory) {
        userLocaleDir.listFiles()?.forEach {
            if (it.name.endsWith(DictionaryInfoUtils.USER_DICTIONARY_SUFFIX))
                userDicts.add(it)
            else if (it.name.startsWith(DictionaryInfoUtils.MAIN_DICT_PREFIX))
                hasInternalDict = true
        }
    }
    if (hasInternalDict)
        return userDicts to true
    val internalDicts = DictionaryInfoUtils.getAssetsDictionaryList(context) ?: return userDicts to false
    val best = LocaleUtils.getBestMatch(locale, internalDicts.toList()) {
        DictionaryInfoUtils.extractLocaleFromAssetsDictionaryFile(it)
    }
    return userDicts to (best != null)
}
