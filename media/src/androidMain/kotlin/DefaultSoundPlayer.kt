/*
 Copyright 2024 Splendo Consulting B.V. The Netherlands

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

package com.splendo.kaluga.media

import android.media.AudioAttributes
import android.media.SoundPool
import com.splendo.kaluga.base.ApplicationHolder
import java.net.URL

actual class DefaultSoundPlayer actual constructor(source: MediaSource) : SoundPlayer {

    private val soundPool = SoundPool.Builder().apply {
        val attributes = AudioAttributes.Builder().apply {
            setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
        }.build()
        setAudioAttributes(attributes)
    }.build()

    private val soundId: Int = soundPool.load(source)

    actual override fun play() {
        soundPool.play(soundId, 1F, 1F, 1, 0, 1F)
    }

    actual override fun close() {
        soundPool.release()
    }

    // private fun SoundPool.load(source: MediaSource): Int = if (source is MediaSource.Url) load(source.url) else throw MediaSoundError.UnexpectedMediaSourceShouldBeURL
    private fun SoundPool.load(source: MediaSource): Int = when(source) {
        is MediaSource.Url -> load(source.url)
        is MediaSource.Asset -> TODO()
        is MediaSource.File -> TODO()
        is MediaSource.Content -> load(source.uri.path, 1)
        is MediaSource.Id -> load(ApplicationHolder.applicationContext, source.id, 1)
        else -> throw MediaSoundError.UnexpectedMediaSourceShouldBeURL
    }

    private fun SoundPool.load(url: URL): Int = if (url.path != null) load(url.path, 1) else throw MediaSoundError.CannotAccessMediaSource
}
