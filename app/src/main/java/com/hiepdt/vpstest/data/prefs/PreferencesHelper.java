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

import com.hiepdt.vpstest.models.ServiceItemModel;

import java.util.List;

/**
 * Created by hiepdt on 12/04/2022
 */

public interface PreferencesHelper {

    List<ServiceItemModel> getServiceList();

    void setServiceList(List<ServiceItemModel> models);

    void clearCache();

}
