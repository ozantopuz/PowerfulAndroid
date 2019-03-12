package com.ozantopuz.powerfulAndroid.core.dagger.scope

import javax.inject.Scope

@Scope
@Retention
@Target(allowedTargets = arrayOf(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION))
annotation class FragmentScoped