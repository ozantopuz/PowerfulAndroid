package com.ozantopuz.powerfulAndroid.core.dagger.scope

import java.lang.annotation.Documented
import javax.inject.Scope

/**
 * In Dagger, an unscoped component cannot depend on a scoped component. As
 * [ApplicationComponent] is a scoped component (`@Singleton`, we create a custom
 * scope to be used by all fragment components. Additionally, a component with a specific scope
 * cannot have a sub component with the same scope.
 */
@Documented
@Scope
@Retention
annotation class ActivityScoped