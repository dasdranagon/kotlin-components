/*
 Copyright 2023 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.test.media

import com.splendo.kaluga.media.BaseMediaManager
import com.splendo.kaluga.media.MediaManager
import com.splendo.kaluga.media.MediaManager.Event
import com.splendo.kaluga.media.MediaSource
import com.splendo.kaluga.media.MediaSurface
import com.splendo.kaluga.media.MediaSurfaceController
import com.splendo.kaluga.media.MediaSurfaceProvider
import com.splendo.kaluga.media.PlayableMedia
import com.splendo.kaluga.media.PlaybackError
import com.splendo.kaluga.media.VolumeController
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.on
import com.splendo.kaluga.test.base.mock.parameters.mock
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration

/**
 * Mock implementation of [VolumeController]
 * @param currentVolume The volume of the audio playback. A value of `0.0` indicates silence; a value of `1.0` (the default) indicates full audio volume for the player instance.
 * @param setupMocks If `true` this will automatically set up some mocking
 */
class MockVolumeController(
    override val currentVolume: MutableStateFlow<Float>,
    setupMocks: Boolean = true
) : VolumeController {

    /**
     * A [com.splendo.kaluga.test.base.mock.SuspendMethodMock] for [updateVolumeMock]
     * If `setupMocks` was set to `true` on construction this will automatically update [currentVolume]
     */
    val updateVolumeMock = this::updateVolume.mock()

    init {
        if (setupMocks) {
            updateVolumeMock.on().doExecute { (volume) ->
                currentVolume.value = volume
            }
        }
    }

    override suspend fun updateVolume(volume: Float): Unit = updateVolumeMock.call(volume)
}

class MockMediaSurfaceController : MediaSurfaceController {

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [renderVideoOnSurface]
     */
    val renderVideoOnSurfaceMock = this::renderVideoOnSurface.mock()

    override suspend fun renderVideoOnSurface(surface: MediaSurface?): Unit = renderVideoOnSurfaceMock.call(surface)
}

/**
 * Mock implementation of [MediaManager]
 * @param events A [MutableSharedFlow] of all the [Event] detected by the media manager
 * @param volumeController a [MockVolumeController] to act as the [VolumeController]
 * @param mediaSurfaceController a [MockMediaSurfaceController] to act as the [MediaSurfaceController]
 * @param setupMocks If `true` this will automatically set up some mocking
 */
class MockMediaManager(
    override val events: MutableSharedFlow<MediaManager.Event>,
    val volumeController: MockVolumeController,
    val mediaSurfaceController: MockMediaSurfaceController,
    setupMocks: Boolean = true
) : MediaManager, VolumeController by volumeController, MediaSurfaceController by mediaSurfaceController {

    /**
     * A [com.splendo.kaluga.test.base.mock.SuspendMethodMock] for [createPlayableMedia]
     * If `setupMocks` was set to `true` on construction, this will automatically return a [MockPlayableMedia]
     */
    val createPlayableMediaMock = this::createPlayableMedia.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [initialize]
     */
    val initializeMock = this::initialize.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [play]
     */
    val playMock = this::play.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [pause]
     */
    val pauseMock = this::pause.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [seekTo]
     */
    val seekToMock = this::seekTo.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [stop]
     */
    val stopMock = this::stop.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [reset]
     */
    val resetMock = this::reset.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [end]
     */
    val endMock = this::end.mock()

    init {
        if (setupMocks) {
            createPlayableMediaMock.on().doExecute { (source) ->
                MockPlayableMedia(source)
            }
        }
    }

    override suspend fun createPlayableMedia(source: MediaSource): PlayableMedia? = createPlayableMediaMock.call(source)
    override fun initialize(playableMedia: PlayableMedia): Unit = initializeMock.call(playableMedia)

    override fun play(rate: Float): Unit = playMock.call(rate)
    override fun pause(): Unit = pauseMock.call()
    override suspend fun seekTo(duration: Duration): Boolean = seekToMock.call(duration)
    override fun stop(): Unit = stopMock.call()

    override fun reset(): Unit = resetMock.call()
    override fun end(): Unit = endMock.call()
}

/**
 * Mock implementation for [BaseMediaManager]
 * @param mediaSurfaceProvider a [MediaSurfaceProvider] that will automatically call [renderVideoOnSurface] for the latest [MediaSurface]
 * @param volumeController a [MockVolumeController] to act as the [VolumeController]
 * @param mediaSurfaceController a [MockMediaSurfaceController] to act as the [MediaSurfaceController]
 * @param coroutineContext the [CoroutineContext] on which the media will be managed
 * @param setupMocks If `true` this will automatically set up some mocking
 */
class MockBaseMediaManager(
    mediaSurfaceProvider: MediaSurfaceProvider?,
    val volumeController: MockVolumeController,
    val mediaSurfaceController: MockMediaSurfaceController,
    coroutineContext: CoroutineContext,
    setupMocks: Boolean = true
) : BaseMediaManager(mediaSurfaceProvider, coroutineContext), VolumeController by volumeController, MediaSurfaceController by mediaSurfaceController {

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [handleCreatePlayableMediaMock]
     */
    val handleCreatePlayableMediaMock = this::handleCreatePlayableMedia.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [initialize]
     */
    val initializeMock = this::initialize.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [play]
     */
    val playMock = this::play.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [pause]
     */
    val pauseMock = this::pause.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [startSeek]
     * If `setupMocks` was set to `true` on construction, this will automatically cause [handleSeekCompleted] to be called immediately after [startSeek] has been called
     */
    val startSeekMock = this::startSeek.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [stop]
     */
    val stopMock = this::stop.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [handleReset]
     */
    val handleResetMock = this::handleReset.mock()

    /**
     * A [com.splendo.kaluga.test.base.mock.MethodMock] for [cleanUp]
     */
    val cleanUpMock = this::cleanUp.mock()

    init {
        if (setupMocks) {
            startSeekMock.on().doExecute { handleSeekCompleted(true) }
        }
    }

    override fun handleCreatePlayableMedia(source: MediaSource): PlayableMedia? = handleCreatePlayableMediaMock.call(source)

    override fun initialize(playableMedia: PlayableMedia): Unit = initializeMock.call(playableMedia)

    override fun play(rate: Float): Unit = playMock.call(rate)
    override fun pause(): Unit = pauseMock.call()
    override fun startSeek(duration: Duration): Unit = startSeekMock.call(duration)
    override fun stop(): Unit = stopMock.call()

    override fun handleReset(): Unit = handleResetMock.call()
    override fun cleanUp(): Unit = cleanUpMock.call()

    public override fun handlePrepared(playableMedia: PlayableMedia) = super.handlePrepared(playableMedia)
    public override fun handleError(error: PlaybackError) = super.handleError(error)
    public override fun handleCompleted() = super.handleCompleted()

    public override fun handleSeekCompleted(success: Boolean) = super.handleSeekCompleted(success)
}
