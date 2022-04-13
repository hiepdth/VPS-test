/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.hiepdt.vpstest.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hiepdt.vpstest.models.ServiceItemModel;
import com.hiepdt.vpstest.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiepdt on 12/04/2022
 */

public class AppPreferencesHelper implements PreferencesHelper {
    private Gson gson = new Gson();
    private static final String PREF_KEY_SERVICE_LIST = "PREF_KEY_SERVICE_LIST";

    private final SharedPreferences mPrefs;

    public AppPreferencesHelper(Context context) {
        mPrefs = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public List<ServiceItemModel> getServiceList() {
        String json = mPrefs.getString(PREF_KEY_SERVICE_LIST, "");
        if (TextUtils.isEmpty(json)) return new ArrayList<>();
        return gson.fromJson(json, new TypeToken<List<ServiceItemModel>>() {
        }.getType());
    }

    @Override
    public void setServiceList(List<ServiceItemModel> models) {
        String json = "";
        if (models != null) {
            json = gson.toJson(models);
        }
        mPrefs.edit().putString(PREF_KEY_SERVICE_LIST, json).apply();
    }

    @Override
    public void clearCache() {
        mPrefs.edit().remove(PREF_KEY_SERVICE_LIST).apply();
    }
}
