package com.splendo.kaluga.architecture.compose.viewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.splendo.kaluga.architecture.viewmodel.BaseViewModel

/**
 * Composable which manages [viewModel] lifecycle and optionally adds it to local [ViewModelStore].
 * @param viewModel view model to manage
 * @param content content based on [viewModel]
 */
@Composable
fun <ViewModel : BaseViewModel> ViewModelComposable(
    viewModel: ViewModel,
    content: @Composable (ViewModel.() -> Unit)? = null
) {
    viewModel.linkLifecycle()
    content?.invoke(viewModel)
}

/**
 * Stores a view model in the local [ViewModelStore]. Use if the view model
 * was created manually and is not located in Activity/Fragment [ViewModelStore].
 */
@Composable fun <VM : BaseViewModel> store(provider: @Composable () -> VM): VM =
    provider().also { handleLocalViewModelStore(it) }

/**
 * Stores and remembers a view model in the local [ViewModelStore].
 * Use if the view model was created manually and is not located in Activity/Fragment [ViewModelStore].
 * provider will only be evaluated during the composition. Recomposition will always return the value produced by provider.
 */
@Composable
fun <VM : BaseViewModel> storeAndRemember(provider: @DisallowComposableCalls () -> VM): VM = store {
    remember(provider)
}

/**
 * Stores and remembers a view model in the local [ViewModelStore].
 * Use if the view model was created manually and is not located in Activity/Fragment [ViewModelStore].
 * provider will only be evaluated during the composition. Recomposition will always return the value produced by provider.
 */
@Composable
fun <VM : BaseViewModel> storeAndRemember(key: Any?, provider: @DisallowComposableCalls () -> VM): VM = store {
    remember(key, provider)
}

@Composable
private fun <VM : BaseViewModel> handleLocalViewModelStore(viewModel: VM): VM {
    // we delegate VM cleanup to the ViewModelStore, which lives in scope of the current @Composable
    val viewModelStoreOwner = rememberComposableViewModelStoreOwner(viewModel)

    // ViewModelProvider is the one, who can access ViewModelStore.put()
    val viewModelProvider = remember(viewModelStoreOwner) {
        ViewModelProvider(
            viewModelStoreOwner,
            @Suppress("UNCHECKED_CAST")
            object : ViewModelProvider.Factory {
                override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T =
                    viewModel as T
            }
        )
    }
    // actual injection of the VM into the ViewModelStore
    viewModelProvider.get(viewModel::class.java)

    return viewModel
}

@Composable
private fun rememberComposableViewModelStoreOwner(viewModel: BaseViewModel): ViewModelStoreOwner {
    val viewModelStoreOwner = remember(viewModel) {
        val viewModelStore = ViewModelStore()
        ViewModelStoreOwner { viewModelStore }
    }
    DisposableEffect(Unit) {
        onDispose {
            viewModelStoreOwner.viewModelStore.clear()
        }
    }

    return viewModelStoreOwner
}

@Composable
private fun <VM : BaseViewModel> VM.linkLifecycle(): VM {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(Unit) {
        val observer = VmObserver(this@linkLifecycle)

        lifecycle.addObserver(observer)

        onDispose {
            lifecycle.removeObserver(observer)
            observer.onDispose()
        }
    }
    return this
}

private class VmObserver<VM : BaseViewModel>(private val viewModel: VM) : DefaultLifecycleObserver {
    private var resumed = false

    override fun onResume(owner: LifecycleOwner) {
        viewModel.didResume().also { resumed = true }
    }
    override fun onPause(owner: LifecycleOwner) {
        viewModel.didPause().also { resumed = false }
    }

    fun onDispose() {
        if (resumed) {
            viewModel.didPause()
        }
    }
}
