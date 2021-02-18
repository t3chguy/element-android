/*
 * Copyright 2020 The Matrix.org Foundation C.I.C.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.android.sdk.internal.session.sync

import org.matrix.android.sdk.api.util.Extended
import org.matrix.android.sdk.internal.network.NetworkConstants
import org.matrix.android.sdk.internal.network.TimeOutInterceptor
import org.matrix.android.sdk.internal.session.sync.model.SyncResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap

internal interface SyncAPI {
    /**
     * Set all the timeouts to 1 minute by default
     */
    @GET(NetworkConstants.URI_API_PREFIX_PATH_R0 + "sync")
    fun sync(@QueryMap params: Map<String, String>,
             @Header(TimeOutInterceptor.CONNECT_TIMEOUT) connectTimeOut: Long = TimeOutInterceptor.DEFAULT_LONG_TIMEOUT,
             @Header(TimeOutInterceptor.READ_TIMEOUT) readTimeOut: Long = TimeOutInterceptor.DEFAULT_LONG_TIMEOUT,
             @Header(TimeOutInterceptor.WRITE_TIMEOUT) writeTimeOut: Long = TimeOutInterceptor.DEFAULT_LONG_TIMEOUT
    ): Call<Extended<SyncResponse>>
}
